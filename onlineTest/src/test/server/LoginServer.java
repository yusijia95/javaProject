package test.server;

import controller.AdmControl;
import controller.controllerImpl.AdmControlImpl;
import controller.controllerImpl.StuControlImpl;
import database.Student;
import database.examine;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LoginServer implements Runnable {
    Socket socket;

    public LoginServer(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        InputStream input = null;
        OutputStream output = null;
        byte[] arr = new byte[10000];
        String loginMessage = null;
        StuControlImpl stuControl = new StuControlImpl();
        AdmControl admControl = new AdmControlImpl();
        Student student = new Student();
        Date date=new Date();
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss");
        while (true) {
            List<examine> listExam = new ArrayList<>();
            List<Student> listStu = new ArrayList<>();
            String loginResult = null;
            try {
                input = socket.getInputStream();
                int length = input.read(arr);
                loginMessage = new String(arr, 0, length);
                String[] str = loginMessage.split("`");
                if (str[0].equals("studentLogin")) {
                    if (stuControl.login(str[1], str[2])) {
                        loginResult = "登录成功";
                        student.setStuName(str[1]);
                        student.setStuPassword(str[2]);
                    } else {
                        loginResult = "登录失败";
                    }
                } else if (str[0].equals("teacherLogin")) {
                    if (admControl.login(str[1], str[2])) {
                        loginResult = "登录成功";
                    } else {
                        loginResult = "登录失败";
                    }
                } else if (str[0].equals("stuUpdate")) {
                    if (stuControl.update(Integer.valueOf(str[1]), str[2], str[3], str[4])) {
                        loginResult = "修改成功";
                    } else {
                        loginResult = "修改失败";
                    }
                } else if (str[0].equals("stuTest")) {
                    listExam = stuControl.test();
                    System.out.println(listExam);
                    String string = "";
                    for (examine ex : listExam) {
                        output = socket.getOutputStream();
                        string += ex.getContent() + "`" + ex.getA() + "`" + ex.getB() + "`" + ex.getC() + "`" + ex.getD() + "`" + ex.getAnswer() + "`";
                    }
                    System.out.println(string);
                    output.write(string.getBytes());
                    output.flush();
                } else if (str[0].equals("stuTestScore")) {
                    student.setStuScore(Integer.valueOf(str[1]));
                    try {
                        student.setStartTime(dateFormat.parse(str[2]));
                        student.setEndTime(dateFormat.parse(str[3]));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    if (stuControl.updateScore(student)) {
                        loginResult = "修改成功";
                    } else {
                        loginResult = "修改失败";
                    }
                } else if (str[0].equals("stuSearch")) {
                    loginResult = String.valueOf(stuControl.select(student.getStuName(), student.getStuPassword()));
                } else if (str[0].equals("AddStudent")) {
                    if (str[1] != null) {
                        for (int i = 1; i < str.length; i++) {
                            Student student1 = new Student(str[i]);
                            listStu.add(student1);
                        }
                        if (admControl.addStudent(listStu)) {
                            loginResult = "添加成功";
                        } else {
                            loginResult = "添加失败";
                        }
                    } else {
                        loginResult = "添加失败";
                    }
                } else if (str[0].equals("selectStu")) {
                    student = admControl.selectStu(Integer.valueOf(str[1]), str[2]);
                    if (student != null) {
                        loginResult = student.getStuId() + "`" + student.getStuName() + "`" + student.getStuScore();
                    } else {
                        loginResult = "失败";
                    }
                } else if (str[0].equals("selectStuName")) {
                    listStu = admControl.selectStuName(str[1]);
                    String string = "";
                    if (listStu != null && !listStu.isEmpty()) {
                        for (Student stu : listStu) {
                            string += stu.getStuId() + "`" + stu.getStuName() + "`" + stu.getStuScore() + "`";
                        }
                        output = socket.getOutputStream();
                    } else {
                        string = "失败";
                    }
                    output.write(string.getBytes());
                    output.flush();
                } else if (str[0].equals("deleteStu")) {
                    System.out.println(str[1]);
                    for (int i = 1; i < str.length; i++) {
                        listStu.add(new Student());
                        listStu.get(i - 1).setStuId(Integer.valueOf(str[i]));
                    }
                    if (admControl.delStudent(listStu)) {
                        loginResult = "成功";
                    } else {
                        loginResult = "失败";
                    }
                } else if (str[0].equals("upStudent")) {
                    if (admControl.updateStu(Integer.valueOf(str[1]), str[2], str[3], Integer.valueOf(str[4]))) {
                        loginResult = "修改成功";
                    } else {
                        loginResult = "修改失败";
                    }
                } else if (str[0].equals("addExamine")) {
                    if (str[1] != null) {
                        for (int i = 1; i < str.length; i++) {
                            examine ex = new examine();
                            ex.setContent(str[i++]);
                            ex.setA(str[i++]);
                            ex.setB(str[i++]);
                            ex.setC(str[i++]);
                            ex.setD(str[i++]);
                            ex.setAnswer(str[i]);
                            listExam.add(ex);
                        }
                        if (admControl.addExamine(listExam)) {
                            loginResult = "成功";
                        } else {
                            loginResult = "添加失败";
                        }
                    } else {
                        loginResult = "添加失败";
                    }
                } else if (str[0].equals("exportExamine")) {
                    listExam = admControl.selectAllExamine();
                    String string = "";
                    if (listExam == null && listExam.isEmpty()) {
                        string = "失败";
                    } else {
                        for (int i = 0; i < listExam.size(); i++) {
                            string += listExam.get(i).geteId() + "`" + listExam.get(i).getContent() + "`";
                        }
                    }
                    output = socket.getOutputStream();
                    output.write(string.getBytes());
                    output.flush();
                } else if (str[0].equals("delExamine")) {
                    System.out.println(str[1]);
                    for (int i = 1; i < str.length; i++) {
                        listExam.add(new examine());
                        listExam.get(i - 1).seteId(Integer.valueOf(str[i]));
                    }
                    System.out.println(listStu);
                    if (admControl.delExamine(listExam)) {
                        loginResult = "成功";
                    } else {
                        loginResult = "失败";
                    }
                }else if (str[0].equals("selExamineKey")) {
                    listExam = admControl.selectExamineKey(str[1]);
                    String string = "";
                    if (listExam != null && !listExam.isEmpty()) {
                        for (examine ex : listExam) {
                            string +=ex.geteId()+"`"+ ex.getContent() + "`" + ex.getA() + "`" + ex.getB() + "`"+ ex.getC()+ "`" + ex.getD()+ "`" + ex.getAnswer()+"`";
                        }
                        output = socket.getOutputStream();
                    } else {
                        string = "失败";
                    }
                    output.write(string.getBytes());
                    output.flush();
                }
                else if (str[0].equals("upExamine")) {
                    int count=0;
                    for (int i = 1; i < str.length; i++) {
                        listExam.add(new examine());
                        listExam.get(count).seteId(Integer.valueOf(str[i++]));
                        listExam.get(count).setContent(str[i++]);
                        listExam.get(count).setA(str[i++]);
                        listExam.get(count).setB(str[i++]);
                        listExam.get(count).setC(str[i++]);
                        listExam.get(count).setD(str[i++]);
                        listExam.get(count).setAnswer(str[i]);
                        count++;
                    }
                    if (admControl.upExamine(listExam)) {
                        loginResult = "成功";
                    } else {
                        loginResult = "失败";
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (loginResult != null) {
                try {
                    output = socket.getOutputStream();
                    output.write(loginResult.getBytes());
                    output.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
