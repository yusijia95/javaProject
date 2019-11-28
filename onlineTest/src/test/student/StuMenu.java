package test.student;

import test.LoginUser;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author 俞思笳
 */
public class StuMenu extends JFrame {

    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JTextField jTextField1;

    private void jButton1MouseClicked(MouseEvent evt){
//        this.setVisible(false);
        dispose();
        StuUpdate stuUpdate=new StuUpdate();
        stuUpdate.setVisible(true);
    }
    private void jButton2MouseClicked(MouseEvent e){
        //        setVisible(false);
        JOptionPane.showMessageDialog(this, "登录考试系统", "登录提示", JOptionPane.INFORMATION_MESSAGE);
        StuTest stuTest=new StuTest();
        TimerThread timerThread = new TimerThread(stuTest);
        Thread thread = new Thread(timerThread);
        thread.start();
        stuTest.setVisible(true);
        dispose();
    }
    private void jButton3MouseClicked(MouseEvent evt){
        OutputStream output = null;
        try {
            output = LoginUser.socket.getOutputStream();
            output.write(("stuSearch").getBytes());
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
        JOptionPane.showMessageDialog(this,"您的分数是:"+result,"成绩查询",JOptionPane.INFORMATION_MESSAGE);
        new StuMenu().setVisible(true);
        setVisible(false);
    }
    private void jButton4MouseClicked(MouseEvent e){
        setVisible(false);
    }
    private void jButton5MouseClicked(MouseEvent evt){
        dispose();
        new LoginUser().setVisible(true);
    }

    public StuMenu() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("学生系统");
        jButton1.setText("修改");
        jButton1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                jButton1MouseClicked(e);
            }
        });

        jButton2.setText("考试");
        jButton2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                jButton2MouseClicked(e);
            }
        });

        jButton3.setText("查询");
        jButton3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                jButton3MouseClicked(e);
            }
        });

        jButton4.setText("导出成绩");
        jButton4.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                jButton4MouseClicked(e);
            }
        });
        jButton5.setText("退出");
        jButton5.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                jButton5MouseClicked(e);
            }
        });
        jTextField1.setFont(new java.awt.Font("Lucida Grande", 0, 22));
        jTextField1.setText("       半 圆 学 生 系 统");
        jTextField1.setActionCommand("<Not Set>");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(109, 109, 109)
                                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(201, 201, 201)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jButton4)
                                                        .addComponent(jButton1)
                                                        .addComponent(jButton2)
                                                        .addComponent(jButton3)
                                                        .addComponent(jButton5))))
                                .addContainerGap(114, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(jButton1)
                                .addGap(25, 25, 25)
                                .addComponent(jButton2)
                                .addGap(25, 25, 25)
                                .addComponent(jButton3)
                                .addGap(25, 25, 25)
                                .addComponent(jButton4)
                                .addGap(25, 25, 25)
                                .addComponent(jButton5)
                                .addContainerGap(68, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>


    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(StuMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StuMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StuMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StuMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new StuMenu().setVisible(true);
            }
        });
    }

}

