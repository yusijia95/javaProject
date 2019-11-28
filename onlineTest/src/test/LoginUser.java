package test;

import test.student.StuMenu;
import test.admin.AdmMenu;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class LoginUser extends JFrame {

    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;


    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LoginUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LoginUser().setVisible(true);
            }
        });
    }

    public LoginUser() {
        initComponents();
    }

    public static Socket socket;

    static {
        try {
            socket = new Socket("192.168.9.233", 6666);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {
        OutputStream output = null;
        InputStream input = null;
        Scanner sca = new Scanner(System.in);
        while (true) {
            String name = jTextField1.getText();
            char[] chararr = jPasswordField1.getPassword();
            String password = new String(chararr);
            String distinct = null;
            if (jRadioButton1.isSelected()) {
                distinct = "studentLogin";
            } else {
                distinct = "teacherLogin";
            }
            try {
                output = socket.getOutputStream();
                output.write((distinct + "`" + name + "`" + password).getBytes());
                output.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
            String loginResult = null;
            byte[] arr = new byte[100];
            try {
                input = socket.getInputStream();
                int length = input.read(arr);
                loginResult = new String(arr, 0, length);
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (loginResult.equals("登录成功")) {
                if (jRadioButton1.isSelected()) {
                    JOptionPane.showMessageDialog(this, "登录成功", "登录提示", JOptionPane.INFORMATION_MESSAGE);
                    StuMenu student = new StuMenu();
                    student.setVisible(true);
                    dispose();
//                    jFrame.setVisible(false);
                    return;
                } else if(jRadioButton2.isSelected()) {
                    JOptionPane.showMessageDialog(this, "登录成功", "登录提示", JOptionPane.INFORMATION_MESSAGE);
                    AdmMenu admMenu = new AdmMenu();
                    admMenu.setVisible(true);
                    dispose();
                    return;
//                    this.setVisible(false);
                }
            } else {
                JOptionPane.showMessageDialog(this, "输入错误", "登录提示", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
        }


    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jTextField1 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPasswordField1 = new javax.swing.JPasswordField();
        jTextField2 = new javax.swing.JTextField();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();

        jButton1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                jButton1MouseClicked(e);

            }
        });
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("半圆考试系统");
        setAutoRequestFocus(false);
        setBackground(new java.awt.Color(255, 255, 255));
        setFont(new java.awt.Font(".SF NS Text", 0, 24)); // NOI18N

        jButton2.setText("账号");

        jButton3.setText("密码");

        jTextField2.setBackground(new java.awt.Color(238, 238, 238));
        jTextField2.setFont(new java.awt.Font("Lucida Grande", 0, 18));
        jTextField2.setText("欢迎登录半圆官网");
        jTextField2.setBorder(null);

        jRadioButton1.setBackground(new java.awt.Color(255, 255, 255));
        jRadioButton1.setText("学生");

        jRadioButton2.setBackground(new java.awt.Color(255, 255, 255));
        jRadioButton2.setText("教师");

        jButton1.setText("登录");
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(jRadioButton1);
        buttonGroup.add(jRadioButton2);
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap(77, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jButton2)
                                        .addComponent(jButton3))
                                .addGap(31, 31, 31)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(127, 127, 127))
                        .addGroup(layout.createSequentialGroup()
                                .addGap(130, 130, 130)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jRadioButton1)
                                                .addGap(18, 18, 18)
                                                .addComponent(jRadioButton2)))
                                .addGap(0, 0, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                                .addGap(123, 123, 123)
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton3)
                                        .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jRadioButton1)
                                        .addComponent(jRadioButton2))
                                .addGap(18, 18, 18)
                                .addComponent(jButton1)
                                .addContainerGap(74, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>

}
