package test.student;

import database.Student;
import database.examine;
import test.LoginUser;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author 俞思笳
 */
public class StuTest extends javax.swing.JFrame {

    public StuTest() {
        initComponents();
    }

    private List<examine> list = new ArrayList<>();
    private int count = 0;
    private Integer stuScore = 0;
    private String stuStartTime = null;
    private String stuEndTime = null;
    public Long curTime;
    private String[] arr = new String[20];
    private Student student;
    private Date date;
    private SimpleDateFormat dateFormat;
    private SimpleDateFormat dateFormat2;
    public javax.swing.JTextField jTextField2;

//    static {
//        OutputStream output = null;
//        InputStream input = null;
//        byte[] arr = new byte[10000];
//        String recieve = null;
//        String[] result = null;
//        try {
//            output = LoginUser.socket.getOutputStream();
//            output.write("stuTest".getBytes());
//            output.flush();
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        }
//        int length = 0;
//        try {
//            input = LoginUser.socket.getInputStream();
//            length = input.read(arr);
//            recieve = new String(arr, 0, length);
//            result = recieve.split("`");
//            for (int i = 0; i < result.length; i++) {
//                examine ex = new examine();
//                ex.setContent(result[i++]);
//                ex.setA(result[i++]);
//                ex.setB(result[i++]);
//                ex.setC(result[i++]);
//                ex.setD(result[i++]);
//                ex.setAnswer(result[i]);
//                list.add(ex);
//            }
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//    }

    private void jButton5MouseClicked(MouseEvent evt) {
        if (count >= 19) {
            JOptionPane.showMessageDialog(this, "最后一题", "提示信息", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        count++;
        if (arr[count] == null) {
            buttonGroup1.clearSelection();
            arr[count] = "0";
        }
        if (arr[count].equals("A")) {
            jRadioButton1.setSelected(true);
        }
        if (arr[count].equals("B")) {
            jRadioButton2.setSelected(true);
        }
        if (arr[count].equals("C")) {
            jRadioButton3.setSelected(true);
        }
        if (arr[count].equals("D")) {
            jRadioButton4.setSelected(true);
        }
        jTextArea1.setText(list.get(count).getContent());
        jTextArea2.setText(list.get(count).getA());
        jTextArea3.setText(list.get(count).getB());
        jTextArea4.setText(list.get(count).getC());
        jTextArea5.setText(list.get(count).getD());
        System.out.println(stuScore);
    }

    private void jButton7MouseClicked(MouseEvent evt) {
        date = new Date();
        stuEndTime = dateFormat.format(date);
        System.out.println("endtime:" + stuEndTime);
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == null) {
                arr[i] = "0";
            }
        }
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getAnswer().equals(arr[i])) {
                stuScore += 5;
            }
        }

        OutputStream output = null;
        try {
            output = LoginUser.socket.getOutputStream();
            output.write(("stuTestScore" + "`" + stuScore + "`" + stuStartTime + "`" + stuEndTime).getBytes());
            output.flush();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        InputStream input = null;
        byte[] arr = new byte[10000];
        String result = null;
        try {
            input = LoginUser.socket.getInputStream();
            int length = input.read(arr);
            result = new String(arr, 0, length);
        } catch (IOException e) {
            e.printStackTrace();
        }
        list.clear();
        if (result.equals("修改成功")) {
            JOptionPane.showMessageDialog(this, "考试结束，成绩已提交", "提交成绩", JOptionPane.INFORMATION_MESSAGE);
            StuMenu stuMenu = new StuMenu();
            stuMenu.setVisible(true);
            dispose();
        }
    }

    private void jRadioButton1MouseClicked(MouseEvent evt) {
        arr[count] = "A";
    }

    private void jRadioButton2MouseClicked(MouseEvent evt) {
        arr[count] = "B";
    }

    private void jRadioButton3MouseClicked(MouseEvent evt) {
        arr[count] = "C";
    }

    private void jRadioButton4MouseClicked(MouseEvent evt) {
        arr[count] = "D";
    }


    private void jRadioButton5MouseClicked(MouseEvent evt) {
        count = 0;
        if (arr[count] == null) {
            buttonGroup1.clearSelection();
            arr[count] = "0";
        }
        if (arr[count].equals("A")) {
            jRadioButton1.setSelected(true);
        }
        if (arr[count].equals("B")) {
            jRadioButton2.setSelected(true);
        }
        if (arr[count].equals("C")) {
            jRadioButton3.setSelected(true);
        }
        if (arr[count].equals("D")) {
            jRadioButton4.setSelected(true);
        }
        jTextArea1.setText(list.get(count).getContent());
        jTextArea2.setText(list.get(count).getA());
        jTextArea3.setText(list.get(count).getB());
        jTextArea4.setText(list.get(count).getC());
        jTextArea5.setText(list.get(count).getD());
    }

    private void jRadioButton6MouseClicked(MouseEvent evt) {
        count = 1;
        if (arr[count] == null) {
            buttonGroup1.clearSelection();
            arr[count] = "0";
        }
        if (arr[count].equals("A")) {
            jRadioButton1.setSelected(true);
        }
        if (arr[count].equals("B")) {
            jRadioButton2.setSelected(true);
        }
        if (arr[count].equals("C")) {
            jRadioButton3.setSelected(true);
        }
        if (arr[count].equals("D")) {
            jRadioButton4.setSelected(true);
        }
        jTextArea1.setText(list.get(count).getContent());
        jTextArea2.setText(list.get(count).getA());
        jTextArea3.setText(list.get(count).getB());
        jTextArea4.setText(list.get(count).getC());
        jTextArea5.setText(list.get(count).getD());
    }

    private void jRadioButton7MouseClicked(MouseEvent evt) {
        count = 2;
        if (arr[count] == null) {
            buttonGroup1.clearSelection();
            arr[count] = "0";
        }
        if (arr[count].equals("A")) {
            jRadioButton1.setSelected(true);
        }
        if (arr[count].equals("B")) {
            jRadioButton2.setSelected(true);
        }
        if (arr[count].equals("C")) {
            jRadioButton3.setSelected(true);
        }
        if (arr[count].equals("D")) {
            jRadioButton4.setSelected(true);
        }
        jTextArea1.setText(list.get(count).getContent());
        jTextArea2.setText(list.get(count).getA());
        jTextArea3.setText(list.get(count).getB());
        jTextArea4.setText(list.get(count).getC());
        jTextArea5.setText(list.get(count).getD());
    }

    private void jRadioButton8MouseClicked(MouseEvent evt) {
        count = 3;
        if (arr[count] == null) {
            buttonGroup1.clearSelection();
            arr[count] = "0";
        }
        if (arr[count].equals("A")) {
            jRadioButton1.setSelected(true);
        }
        if (arr[count].equals("B")) {
            jRadioButton2.setSelected(true);
        }
        if (arr[count].equals("C")) {
            jRadioButton3.setSelected(true);
        }
        if (arr[count].equals("D")) {
            jRadioButton4.setSelected(true);
        }
        jTextArea1.setText(list.get(count).getContent());
        jTextArea2.setText(list.get(count).getA());
        jTextArea3.setText(list.get(count).getB());
        jTextArea4.setText(list.get(count).getC());
        jTextArea5.setText(list.get(count).getD());
    }

    private void jRadioButton9MouseClicked(MouseEvent evt) {
        count = 4;
        if (arr[count] == null) {
            buttonGroup1.clearSelection();
            arr[count] = "0";
        }
        if (arr[count].equals("A")) {
            jRadioButton1.setSelected(true);
        }
        if (arr[count].equals("B")) {
            jRadioButton2.setSelected(true);
        }
        if (arr[count].equals("C")) {
            jRadioButton3.setSelected(true);
        }
        if (arr[count].equals("D")) {
            jRadioButton4.setSelected(true);
        }
        jTextArea1.setText(list.get(count).getContent());
        jTextArea2.setText(list.get(count).getA());
        jTextArea3.setText(list.get(count).getB());
        jTextArea4.setText(list.get(count).getC());
        jTextArea5.setText(list.get(count).getD());
    }

    private void jRadioButton10MouseClicked(MouseEvent evt) {
        count = 5;
        if (arr[count] == null) {
            buttonGroup1.clearSelection();
            arr[count] = "0";
        }
        if (arr[count].equals("A")) {
            jRadioButton1.setSelected(true);
        }
        if (arr[count].equals("B")) {
            jRadioButton2.setSelected(true);
        }
        if (arr[count].equals("C")) {
            jRadioButton3.setSelected(true);
        }
        if (arr[count].equals("D")) {
            jRadioButton4.setSelected(true);
        }
        jTextArea1.setText(list.get(count).getContent());
        jTextArea2.setText(list.get(count).getA());
        jTextArea3.setText(list.get(count).getB());
        jTextArea4.setText(list.get(count).getC());
        jTextArea5.setText(list.get(count).getD());
    }

    private void jRadioButton11MouseClicked(MouseEvent evt) {
        count = 6;
        if (arr[count] == null) {
            buttonGroup1.clearSelection();
            arr[count] = "0";
        }
        if (arr[count].equals("A")) {
            jRadioButton1.setSelected(true);
        }
        if (arr[count].equals("B")) {
            jRadioButton2.setSelected(true);
        }
        if (arr[count].equals("C")) {
            jRadioButton3.setSelected(true);
        }
        if (arr[count].equals("D")) {
            jRadioButton4.setSelected(true);
        }
        jTextArea1.setText(list.get(count).getContent());
        jTextArea2.setText(list.get(count).getA());
        jTextArea3.setText(list.get(count).getB());
        jTextArea4.setText(list.get(count).getC());
        jTextArea5.setText(list.get(count).getD());
    }

    private void jRadioButton12MouseClicked(MouseEvent evt) {
        count = 7;
        if (arr[count] == null) {
            buttonGroup1.clearSelection();
            arr[count] = "0";
        }
        if (arr[count].equals("A")) {
            jRadioButton1.setSelected(true);
        }
        if (arr[count].equals("B")) {
            jRadioButton2.setSelected(true);
        }
        if (arr[count].equals("C")) {
            jRadioButton3.setSelected(true);
        }
        if (arr[count].equals("D")) {
            jRadioButton4.setSelected(true);
        }
        jTextArea1.setText(list.get(count).getContent());
        jTextArea2.setText(list.get(count).getA());
        jTextArea3.setText(list.get(count).getB());
        jTextArea4.setText(list.get(count).getC());
        jTextArea5.setText(list.get(count).getD());
    }

    private void jRadioButton13MouseClicked(MouseEvent evt) {
        count = 8;
        if (arr[count] == null) {
            buttonGroup1.clearSelection();
            arr[count] = "0";
        }
        if (arr[count].equals("A")) {
            jRadioButton1.setSelected(true);
        }
        if (arr[count].equals("B")) {
            jRadioButton2.setSelected(true);
        }
        if (arr[count].equals("C")) {
            jRadioButton3.setSelected(true);
        }
        if (arr[count].equals("D")) {
            jRadioButton4.setSelected(true);
        }
        jTextArea1.setText(list.get(count).getContent());
        jTextArea2.setText(list.get(count).getA());
        jTextArea3.setText(list.get(count).getB());
        jTextArea4.setText(list.get(count).getC());
        jTextArea5.setText(list.get(count).getD());
    }

    private void jRadioButton14MouseClicked(MouseEvent evt) {
        count = 9;
        if (arr[count] == null) {
            buttonGroup1.clearSelection();
            arr[count] = "0";
        }
        if (arr[count].equals("A")) {
            jRadioButton1.setSelected(true);
        }
        if (arr[count].equals("B")) {
            jRadioButton2.setSelected(true);
        }
        if (arr[count].equals("C")) {
            jRadioButton3.setSelected(true);
        }
        if (arr[count].equals("D")) {
            jRadioButton4.setSelected(true);
        }
        jTextArea1.setText(list.get(count).getContent());
        jTextArea2.setText(list.get(count).getA());
        jTextArea3.setText(list.get(count).getB());
        jTextArea4.setText(list.get(count).getC());
        jTextArea5.setText(list.get(count).getD());
    }

    private void jRadioButton15MouseClicked(MouseEvent evt) {
        count = 10;
        if (arr[count] == null) {
            buttonGroup1.clearSelection();
            arr[count] = "0";
        }
        if (arr[count].equals("A")) {
            jRadioButton1.setSelected(true);
        }
        if (arr[count].equals("B")) {
            jRadioButton2.setSelected(true);
        }
        if (arr[count].equals("C")) {
            jRadioButton3.setSelected(true);
        }
        if (arr[count].equals("D")) {
            jRadioButton4.setSelected(true);
        }
        jTextArea1.setText(list.get(count).getContent());
        jTextArea2.setText(list.get(count).getA());
        jTextArea3.setText(list.get(count).getB());
        jTextArea4.setText(list.get(count).getC());
        jTextArea5.setText(list.get(count).getD());
    }

    private void jRadioButton16MouseClicked(MouseEvent evt) {
        count = 11;
        if (arr[count] == null) {
            buttonGroup1.clearSelection();
            arr[count] = "0";
        }
        if (arr[count].equals("A")) {
            jRadioButton1.setSelected(true);
        }
        if (arr[count].equals("B")) {
            jRadioButton2.setSelected(true);
        }
        if (arr[count].equals("C")) {
            jRadioButton3.setSelected(true);
        }
        if (arr[count].equals("D")) {
            jRadioButton4.setSelected(true);
        }
        jTextArea1.setText(list.get(count).getContent());
        jTextArea2.setText(list.get(count).getA());
        jTextArea3.setText(list.get(count).getB());
        jTextArea4.setText(list.get(count).getC());
        jTextArea5.setText(list.get(count).getD());
    }

    private void jRadioButton17MouseClicked(MouseEvent evt) {
        count = 12;
        if (arr[count] == null) {
            buttonGroup1.clearSelection();
            arr[count] = "0";
        }
        if (arr[count].equals("A")) {
            jRadioButton1.setSelected(true);
        }
        if (arr[count].equals("B")) {
            jRadioButton2.setSelected(true);
        }
        if (arr[count].equals("C")) {
            jRadioButton3.setSelected(true);
        }
        if (arr[count].equals("D")) {
            jRadioButton4.setSelected(true);
        }
        jTextArea1.setText(list.get(count).getContent());
        jTextArea2.setText(list.get(count).getA());
        jTextArea3.setText(list.get(count).getB());
        jTextArea4.setText(list.get(count).getC());
        jTextArea5.setText(list.get(count).getD());
    }

    private void jRadioButton18MouseClicked(MouseEvent evt) {
        count = 13;
        if (arr[count] == null) {
            buttonGroup1.clearSelection();
            arr[count] = "0";
        }
        if (arr[count].equals("A")) {
            jRadioButton1.setSelected(true);
        }
        if (arr[count].equals("B")) {
            jRadioButton2.setSelected(true);
        }
        if (arr[count].equals("C")) {
            jRadioButton3.setSelected(true);
        }
        if (arr[count].equals("D")) {
            jRadioButton4.setSelected(true);
        }
        jTextArea1.setText(list.get(count).getContent());
        jTextArea2.setText(list.get(count).getA());
        jTextArea3.setText(list.get(count).getB());
        jTextArea4.setText(list.get(count).getC());
        jTextArea5.setText(list.get(count).getD());
    }

    private void jRadioButton19MouseClicked(MouseEvent evt) {
        count = 14;
        if (arr[count] == null) {
            buttonGroup1.clearSelection();
            arr[count] = "0";
        }
        if (arr[count].equals("A")) {
            jRadioButton1.setSelected(true);
        }
        if (arr[count].equals("B")) {
            jRadioButton2.setSelected(true);
        }
        if (arr[count].equals("C")) {
            jRadioButton3.setSelected(true);
        }
        if (arr[count].equals("D")) {
            jRadioButton4.setSelected(true);
        }
        jTextArea1.setText(list.get(count).getContent());
        jTextArea2.setText(list.get(count).getA());
        jTextArea3.setText(list.get(count).getB());
        jTextArea4.setText(list.get(count).getC());
        jTextArea5.setText(list.get(count).getD());
    }

    private void jRadioButton20MouseClicked(MouseEvent evt) {
        count = 15;
        if (arr[count] == null) {
            buttonGroup1.clearSelection();
            arr[count] = "0";
        }
        if (arr[count].equals("A")) {
            jRadioButton1.setSelected(true);
        }
        if (arr[count].equals("B")) {
            jRadioButton2.setSelected(true);
        }
        if (arr[count].equals("C")) {
            jRadioButton3.setSelected(true);
        }
        if (arr[count].equals("D")) {
            jRadioButton4.setSelected(true);
        }
        jTextArea1.setText(list.get(count).getContent());
        jTextArea2.setText(list.get(count).getA());
        jTextArea3.setText(list.get(count).getB());
        jTextArea4.setText(list.get(count).getC());
        jTextArea5.setText(list.get(count).getD());
    }

    private void jRadioButton21MouseClicked(MouseEvent evt) {
        count = 16;
        if (arr[count] == null) {
            buttonGroup1.clearSelection();
            arr[count] = "0";
        }
        if (arr[count].equals("A")) {
            jRadioButton1.setSelected(true);
        }
        if (arr[count].equals("B")) {
            jRadioButton2.setSelected(true);
        }
        if (arr[count].equals("C")) {
            jRadioButton3.setSelected(true);
        }
        if (arr[count].equals("D")) {
            jRadioButton4.setSelected(true);
        }
        jTextArea1.setText(list.get(count).getContent());
        jTextArea2.setText(list.get(count).getA());
        jTextArea3.setText(list.get(count).getB());
        jTextArea4.setText(list.get(count).getC());
        jTextArea5.setText(list.get(count).getD());
    }

    private void jRadioButton22MouseClicked(MouseEvent evt) {
        count = 17;
        if (arr[count] == null) {
            buttonGroup1.clearSelection();
            arr[count] = "0";
        }
        if (arr[count].equals("A")) {
            jRadioButton1.setSelected(true);
        }
        if (arr[count].equals("B")) {
            jRadioButton2.setSelected(true);
        }
        if (arr[count].equals("C")) {
            jRadioButton3.setSelected(true);
        }
        if (arr[count].equals("D")) {
            jRadioButton4.setSelected(true);
        }
        jTextArea1.setText(list.get(count).getContent());
        jTextArea2.setText(list.get(count).getA());
        jTextArea3.setText(list.get(count).getB());
        jTextArea4.setText(list.get(count).getC());
        jTextArea5.setText(list.get(count).getD());
    }

    private void jRadioButton25MouseClicked(MouseEvent evt) {
        count = 18;
        if (arr[count] == null) {
            buttonGroup1.clearSelection();
            arr[count] = "0";
        }
        if (arr[count].equals("A")) {
            jRadioButton1.setSelected(true);
        }
        if (arr[count].equals("B")) {
            jRadioButton2.setSelected(true);
        }
        if (arr[count].equals("C")) {
            jRadioButton3.setSelected(true);
        }
        if (arr[count].equals("D")) {
            jRadioButton4.setSelected(true);
        }
        jTextArea1.setText(list.get(count).getContent());
        jTextArea2.setText(list.get(count).getA());
        jTextArea3.setText(list.get(count).getB());
        jTextArea4.setText(list.get(count).getC());
        jTextArea5.setText(list.get(count).getD());
    }

    private void jRadioButton26MouseClicked(MouseEvent evt) {
        count = 19;
        if (arr[count] == null) {
            buttonGroup1.clearSelection();
            arr[count] = "0";
        }
        if (arr[count].equals("A")) {
            jRadioButton1.setSelected(true);
        }
        if (arr[count].equals("B")) {
            jRadioButton2.setSelected(true);
        }
        if (arr[count].equals("C")) {
            jRadioButton3.setSelected(true);
        }
        if (arr[count].equals("D")) {
            jRadioButton4.setSelected(true);
        }
        jTextArea1.setText(list.get(count).getContent());
        jTextArea2.setText(list.get(count).getA());
        jTextArea3.setText(list.get(count).getB());
        jTextArea4.setText(list.get(count).getC());
        jTextArea5.setText(list.get(count).getD());
    }


    @SuppressWarnings("unchecked")
    private void initComponents() {

        OutputStream output = null;
        InputStream input = null;
        byte[] arr = new byte[10000];
        String recieve = null;
        String[] result = null;
        try {
            output = LoginUser.socket.getOutputStream();
            output.write("stuTest".getBytes());
            output.flush();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        int length = 0;
        try {
            input = LoginUser.socket.getInputStream();
            length = input.read(arr);
            recieve = new String(arr, 0, length);
            result = recieve.split("`");
            for (int i = 0; i < result.length; i++) {
                examine ex = new examine();
                ex.setContent(result[i++]);
                ex.setA(result[i++]);
                ex.setB(result[i++]);
                ex.setC(result[i++]);
                ex.setD(result[i++]);
                ex.setAnswer(result[i]);
                list.add(ex);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


        jButton5 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jButton7 = new javax.swing.JButton();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea3 = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextArea4 = new javax.swing.JTextArea();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTextArea5 = new javax.swing.JTextArea();
        jRadioButton5 = new javax.swing.JRadioButton();
        jRadioButton6 = new javax.swing.JRadioButton();
        jRadioButton7 = new javax.swing.JRadioButton();
        jRadioButton8 = new javax.swing.JRadioButton();
        jRadioButton9 = new javax.swing.JRadioButton();
        jRadioButton10 = new javax.swing.JRadioButton();
        jRadioButton11 = new javax.swing.JRadioButton();
        jRadioButton12 = new javax.swing.JRadioButton();
        jRadioButton13 = new javax.swing.JRadioButton();
        jRadioButton14 = new javax.swing.JRadioButton();
        jRadioButton15 = new javax.swing.JRadioButton();
        jRadioButton16 = new javax.swing.JRadioButton();
        jRadioButton17 = new javax.swing.JRadioButton();
        jRadioButton18 = new javax.swing.JRadioButton();
        jRadioButton19 = new javax.swing.JRadioButton();
        jRadioButton20 = new javax.swing.JRadioButton();
        jRadioButton21 = new javax.swing.JRadioButton();
        jRadioButton22 = new javax.swing.JRadioButton();
        jRadioButton25 = new javax.swing.JRadioButton();
        jRadioButton26 = new javax.swing.JRadioButton();
        buttonGroup1 = new ButtonGroup();
        buttonGroup2 = new ButtonGroup();
        date = new Date();
        dateFormat = new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss");
        dateFormat2 = new SimpleDateFormat("hh:mm:ss");
        jTextField2 = new javax.swing.JTextField();

        stuStartTime = dateFormat.format(date);
        System.out.println("starttime:" + stuStartTime);

        buttonGroup1.add(jRadioButton1);
        buttonGroup1.add(jRadioButton2);
        buttonGroup1.add(jRadioButton3);
        buttonGroup1.add(jRadioButton4);
        buttonGroup2.add(jRadioButton5);
        buttonGroup2.add(jRadioButton6);
        buttonGroup2.add(jRadioButton7);
        buttonGroup2.add(jRadioButton8);
        buttonGroup2.add(jRadioButton9);
        buttonGroup2.add(jRadioButton10);
        buttonGroup2.add(jRadioButton11);
        buttonGroup2.add(jRadioButton12);
        buttonGroup2.add(jRadioButton13);
        buttonGroup2.add(jRadioButton14);
        buttonGroup2.add(jRadioButton15);
        buttonGroup2.add(jRadioButton16);
        buttonGroup2.add(jRadioButton17);
        buttonGroup2.add(jRadioButton18);
        buttonGroup2.add(jRadioButton19);
        buttonGroup2.add(jRadioButton20);
        buttonGroup2.add(jRadioButton21);
        buttonGroup2.add(jRadioButton22);
        buttonGroup2.add(jRadioButton25);
        buttonGroup2.add(jRadioButton26);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("学生系统");

        jButton5.setText("下一题");
        jButton5.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                jButton5MouseClicked(e);
            }
        });

        jTextField1.setFont(new java.awt.Font("Lucida Grande", 0, 22));
        jTextField1.setText("   半 圆  学 生 考 试 系 统");
        jTextField1.setActionCommand("<Not Set>");

        jButton7.setText("退出");
        jButton7.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                jButton7MouseClicked(e);
            }
        });

        jRadioButton1.setText("A");
        jRadioButton1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                jRadioButton1MouseClicked(e);
            }
        });

        jRadioButton2.setText("B");
        jRadioButton2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                jRadioButton2MouseClicked(e);
            }
        });

        jRadioButton3.setText("C");
        jRadioButton3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                jRadioButton3MouseClicked(e);
            }
        });

        jRadioButton4.setText("D");
        jRadioButton4.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                jRadioButton4MouseClicked(e);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);
        jTextArea1.setText(list.get(0).getContent());

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane2.setViewportView(jTextArea2);
        jTextArea2.setText(list.get(0).getA());

        jTextArea3.setColumns(20);
        jTextArea3.setRows(5);
        jScrollPane3.setViewportView(jTextArea3);
        jTextArea3.setText(list.get(0).getB());

        jTextArea4.setColumns(20);
        jTextArea4.setRows(5);
        jScrollPane4.setViewportView(jTextArea4);
        jTextArea4.setText(list.get(0).getC());

        jTextArea5.setColumns(20);
        jTextArea5.setRows(5);
        jScrollPane5.setViewportView(jTextArea5);
        jTextArea5.setText(list.get(0).getD());

        jRadioButton5.setText("1");
        jRadioButton5.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                jRadioButton5MouseClicked(e);
            }
        });

        jRadioButton6.setText("2");
        jRadioButton6.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                jRadioButton6MouseClicked(e);
            }
        });

        jRadioButton7.setText("3");
        jRadioButton7.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                jRadioButton7MouseClicked(e);
            }
        });

        jRadioButton8.setText("4");
        jRadioButton8.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                jRadioButton8MouseClicked(e);
            }
        });

        jRadioButton9.setText("7");
        jRadioButton9.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                jRadioButton9MouseClicked(e);
            }
        });

        jRadioButton10.setText("8");
        jRadioButton10.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                jRadioButton10MouseClicked(e);
            }
        });

        jRadioButton11.setText("5");
        jRadioButton11.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                jRadioButton11MouseClicked(e);
            }
        });

        jRadioButton12.setText("6");
        jRadioButton12.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                jRadioButton12MouseClicked(e);
            }
        });

        jRadioButton13.setText("11");
        jRadioButton13.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                jRadioButton13MouseClicked(e);
            }
        });

        jRadioButton14.setText("12");
        jRadioButton14.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                jRadioButton14MouseClicked(e);
            }
        });

        jRadioButton15.setText("13");
        jRadioButton15.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                jRadioButton15MouseClicked(e);
            }
        });

        jRadioButton16.setText("14");
        jRadioButton16.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                jRadioButton16MouseClicked(e);
            }
        });

        jRadioButton17.setText("15");
        jRadioButton17.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                jRadioButton17MouseClicked(e);
            }
        });

        jRadioButton18.setText("16");
        jRadioButton18.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                jRadioButton18MouseClicked(e);
            }
        });

        jRadioButton19.setText("17");
        jRadioButton19.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                jRadioButton19MouseClicked(e);
            }
        });

        jRadioButton20.setText("18");
        jRadioButton20.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                jRadioButton20MouseClicked(e);
            }
        });

        jRadioButton21.setText("9");
        jRadioButton21.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                jRadioButton21MouseClicked(e);
            }
        });

        jRadioButton22.setText("10");
        jRadioButton22.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                jRadioButton22MouseClicked(e);
            }
        });

        jRadioButton25.setText("19");
        jRadioButton25.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                jRadioButton25MouseClicked(e);
            }
        });

        jRadioButton26.setText("20");
        jRadioButton26.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                jRadioButton26MouseClicked(e);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton7)
                                .addGap(15, 15, 15))
                        .addGroup(layout.createSequentialGroup()
                                .addGap(122, 122, 122)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36)
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jRadioButton13)
                                                                .addGap(6, 6, 6)
                                                                .addComponent(jRadioButton14)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jRadioButton15)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jRadioButton16)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jRadioButton17)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jRadioButton18)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jRadioButton19)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jRadioButton20))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jRadioButton5)
                                                                .addGap(14, 14, 14)
                                                                .addComponent(jRadioButton6)
                                                                .addGap(14, 14, 14)
                                                                .addComponent(jRadioButton7)
                                                                .addGap(14, 14, 14)
                                                                .addComponent(jRadioButton8)
                                                                .addGap(14, 14, 14)
                                                                .addComponent(jRadioButton11)
                                                                .addGap(14, 14, 14)
                                                                .addComponent(jRadioButton12)
                                                                .addGap(14, 14, 14)
                                                                .addComponent(jRadioButton9)
                                                                .addGap(14, 14, 14)
                                                                .addComponent(jRadioButton10)))
                                                .addGap(14, 14, 14)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jRadioButton25)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jRadioButton26))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jRadioButton21)
                                                                .addGap(14, 14, 14)
                                                                .addComponent(jRadioButton22))))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(30, 30, 30)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                        .addComponent(jRadioButton2)
                                                                        .addComponent(jRadioButton3)
                                                                        .addComponent(jRadioButton4))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 512, Short.MAX_VALUE)
                                                                        .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING)
                                                                        .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.TRAILING)))
                                                        .addComponent(jScrollPane1)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jRadioButton1)
                                                                .addGap(7, 7, 7)
                                                                .addComponent(jScrollPane2)))))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(14, 14, 14)
                                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(8, 8, 8)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jRadioButton1)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jRadioButton2)
                                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jRadioButton3)
                                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jRadioButton4)
                                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jRadioButton5)
                                                        .addComponent(jRadioButton6)
                                                        .addComponent(jRadioButton7)
                                                        .addComponent(jRadioButton8)
                                                        .addComponent(jRadioButton11)
                                                        .addComponent(jRadioButton12)
                                                        .addComponent(jRadioButton9)
                                                        .addComponent(jRadioButton10))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jRadioButton13)
                                                        .addComponent(jRadioButton14)
                                                        .addComponent(jRadioButton15)
                                                        .addComponent(jRadioButton16)
                                                        .addComponent(jRadioButton17)
                                                        .addComponent(jRadioButton18)
                                                        .addComponent(jRadioButton19)
                                                        .addComponent(jRadioButton20)))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jRadioButton21)
                                                        .addComponent(jRadioButton22))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jRadioButton25)
                                                        .addComponent(jRadioButton26))))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton5)
                                        .addComponent(jButton7))
                                .addContainerGap())
        );

        pack();
    }// </editor-fold>

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(StuTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StuTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StuTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StuTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new StuTest().setVisible(true);
            }
        });
    }


    private javax.swing.JButton jButton5;
    public javax.swing.JButton jButton7;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton10;
    private javax.swing.JRadioButton jRadioButton11;
    private javax.swing.JRadioButton jRadioButton12;
    private javax.swing.JRadioButton jRadioButton13;
    private javax.swing.JRadioButton jRadioButton14;
    private javax.swing.JRadioButton jRadioButton15;
    private javax.swing.JRadioButton jRadioButton16;
    private javax.swing.JRadioButton jRadioButton17;
    private javax.swing.JRadioButton jRadioButton18;
    private javax.swing.JRadioButton jRadioButton19;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton20;
    private javax.swing.JRadioButton jRadioButton21;
    private javax.swing.JRadioButton jRadioButton22;
    private javax.swing.JRadioButton jRadioButton25;
    private javax.swing.JRadioButton jRadioButton26;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JRadioButton jRadioButton5;
    private javax.swing.JRadioButton jRadioButton6;
    private javax.swing.JRadioButton jRadioButton7;
    private javax.swing.JRadioButton jRadioButton8;
    private javax.swing.JRadioButton jRadioButton9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextArea jTextArea3;
    private javax.swing.JTextArea jTextArea4;
    private javax.swing.JTextArea jTextArea5;
    private javax.swing.JTextField jTextField1;
    private ButtonGroup buttonGroup1;
    private ButtonGroup buttonGroup2;
}
