package test.student;

import javax.swing.*;
import java.util.Date;

public class TimerThread implements Runnable {
    StuTest stuTest;

    public TimerThread(StuTest stuTest) {
        this.stuTest = stuTest;
    }
    @Override
    public void run() {
        Long startTime = System.currentTimeMillis();
        Date date=null;
        String hour=null;
        String minute=null;
        String second=null;
        while (true) {
            stuTest.curTime = 7200 - (System.currentTimeMillis() - startTime)/1000;
            hour=String.valueOf(stuTest.curTime/3600);
            minute=String.valueOf(stuTest.curTime/60%60);
            second=String.valueOf(stuTest.curTime%60%60);
            stuTest.jTextField2.setText(hour+":"+minute+":"+second);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (stuTest.curTime <= 0) {
//                JOptionPane.showMessageDialog(stuTest,"考试已结束，成绩已提交","提示信息",JOptionPane.INFORMATION_MESSAGE);
                stuTest.jButton7.doClick();
                stuTest.setVisible(false);
                new StuMenu().setVisible(true);
                break;
            }
        }
    }
}
