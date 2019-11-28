package test.admin.TestManager;

import database.examine;
import test.LoginUser;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author edz
 */
public class DelExamine extends javax.swing.JFrame {

    public DelExamine() {
        initComponents();
    }

    private static List<examine> addList = new ArrayList<>();
    private static List<examine> delList = new ArrayList<>();
    private int count = 1;

//    static {
//        OutputStream output = null;
//        InputStream input = null;
//        byte[] arr = new byte[1000000];
//        String recieve = null;
//        String[] result = null;
//        int length = 0;
//        try {
//            output = LoginUser.socket.getOutputStream();
//            output.write("exportExamine".getBytes());
//            input = LoginUser.socket.getInputStream();
//            length = input.read(arr);
//            recieve = new String(arr, 0, length);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        result = recieve.split("`");
//        System.out.println("-----------------------------");
//        System.out.println(recieve);
//        for (int i = 0; i < result.length; i++) {
//            examine ex = new examine();
//            ex.seteId(Integer.valueOf(result[i++]));
//            ex.setContent(result[i]);
//            addList.add(ex);
//        }
//    }

    private void jButton5MouseClicked(MouseEvent evt) {
        if (count * 5 >= addList.size()) {
            JOptionPane.showMessageDialog(this, "最后一页", "提示信息", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        if (count * 5 >= addList.size()) {
            jTextArea3.setText("");
        } else {
            jTextArea3.setText(addList.get(count * 5).getContent());
        }
        if (count * 5 + 1 >= addList.size()) {
            jTextArea4.setText("");
        } else {
            jTextArea4.setText(addList.get(count * 5 + 1).getContent());
        }
        if (count * 5 + 2 >= addList.size()) {
            jTextArea5.setText("");
        } else {
            jTextArea5.setText(addList.get(count * 5 + 2).getContent());
        }
        if (count * 5 + 3 >= addList.size()) {
            jTextArea6.setText("");
        } else {
            jTextArea6.setText(addList.get(count * 5 + 3).getContent());
        }
        if (count * 5 + 4 >= addList.size()) {
            jTextArea7.setText("");
        } else {
            jTextArea7.setText(addList.get(count * 5 + 4).getContent());
        }
        jCheckBox1.setSelected(false);
        jCheckBox2.setSelected(false);
        jCheckBox3.setSelected(false);
        jCheckBox4.setSelected(false);
        jCheckBox5.setSelected(false);
        count++;
    }

    private void jButton6MouseClicked(MouseEvent evt) {
        OutputStream output = null;
        String string = "";
        if (delList.isEmpty()) {
            JOptionPane.showMessageDialog(this, "请选择删除题目", "提示信息", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        for (int i = 0; i < delList.size(); i++) {
            string += delList.get(i).geteId() + "`";
        }
        System.out.println(string);
        try {
            output = LoginUser.socket.getOutputStream();
            output.write(("delExamine" + "`" + string).getBytes());
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
        delList.clear();
        if (result.equals("成功")) {
            JOptionPane.showMessageDialog(this, "删除成功", "删除信息", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
    }

    private void jButton7MouseClicked(MouseEvent evt) {
        addList.clear();
//        delList.clear();
//        count=1;
        new ManagerTest().setVisible(true);
        dispose();
    }

    private int count1 = 0;

    private void jCheckBox1MouseClicked(MouseEvent evt) {
        if (count1 == 1) {
            for (examine ex : delList) {
                if (addList.get((count - 1) * 5 + 0).geteId().equals(ex.geteId())) {
                    delList.remove(ex);
                }
            }
            jCheckBox1.setSelected(false);
            count1--;
        } else {
            examine ex = new examine();
            ex.seteId(addList.get((count - 1) * 5 + 0).geteId());
            delList.add(ex);
            count1++;
        }
    }

    private int count2 = 0;

    private void jCheckBox2MouseClicked(MouseEvent evt) {
        if (count2 == 1) {
            for (examine ex : delList) {
                if (addList.get((count - 1) * 5 + 1).geteId().equals(ex.geteId())) {
                    delList.remove(ex);
                }
            }
            jCheckBox2.setSelected(false);
            count2--;
        } else {
            examine ex = new examine();
            ex.seteId(addList.get((count - 1) * 5 + 1).geteId());
            delList.add(ex);
            count2++;
        }
    }

    private int count3 = 0;

    private void jCheckBox3MouseClicked(MouseEvent evt) {
        if (count3 == 1) {
            for (examine ex : delList) {
                if (addList.get((count - 1) * 5 + 3).geteId().equals(ex.geteId())) {
                    delList.remove(ex);
                }
            }
            jCheckBox3.setSelected(false);
            count3--;
        } else {
            examine ex = new examine();
            ex.seteId(addList.get((count - 1) * 5 + 3).geteId());
            delList.add(ex);
            count3++;
        }
    }

    private int count4 = 0;

    private void jCheckBox4MouseClicked(MouseEvent evt) {
        if (count4 == 1) {
            for (examine ex : delList) {
                if (addList.get((count - 1) * 5 + 2).geteId().equals(ex.geteId())) {
                    delList.remove(ex);
                }
            }
            jCheckBox4.setSelected(false);
            count4--;
        } else {
            examine ex = new examine();
            ex.seteId(addList.get((count - 1) * 5 + 2).geteId());
            delList.add(ex);
            count4++;
        }
    }

    private int count5 = 0;

    private void jCheckBox5MouseClicked(MouseEvent evt) {
        if (count5 == 1) {
            for (examine ex : delList) {
                if (addList.get((count - 1) * 5 + 4).geteId().equals(ex.geteId())) {
                    delList.remove(ex);
                }
            }
            jCheckBox5.setSelected(false);
            count5--;
        } else {
            examine ex = new examine();
            ex.seteId(addList.get((count - 1) * 5 + 4).geteId());
            delList.add(ex);
            count5++;
        }
    }

    private void initComponents() {

        OutputStream output = null;
        InputStream input = null;
        byte[] arr = new byte[1000000];
        String recieve = null;
        String[] result = null;
        int length = 0;
        try {
            output = LoginUser.socket.getOutputStream();
            output.write("exportExamine".getBytes());
            input = LoginUser.socket.getInputStream();
            length = input.read(arr);
            recieve = new String(arr, 0, length);
        } catch (IOException e) {
            e.printStackTrace();
        }
        result = recieve.split("`");
        System.out.println("-----------------------------");
        System.out.println(recieve);
        for (int i = 0; i < result.length; i++) {
            examine ex = new examine();
            ex.seteId(Integer.valueOf(result[i++]));
            ex.setContent(result[i]);
            addList.add(ex);
        }

        jButton5 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jButton7 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea3 = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextArea4 = new javax.swing.JTextArea();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTextArea5 = new javax.swing.JTextArea();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTextArea6 = new javax.swing.JTextArea();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTextArea7 = new javax.swing.JTextArea();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox3 = new javax.swing.JCheckBox();
        jCheckBox4 = new javax.swing.JCheckBox();
        jCheckBox5 = new javax.swing.JCheckBox();
        jButton6 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("学生系统");

        jButton5.setText("下一页");
        jButton5.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                jButton5MouseClicked(e);
            }
        });

        jTextField1.setFont(new java.awt.Font("Lucida Grande", 0, 22)); // NOI18N
        jTextField1.setText("        试 题 删 除 系 统");
        jTextField1.setActionCommand("<Not Set>");

        jButton7.setText("退出系统");
        jButton7.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                jButton7MouseClicked(e);
            }
        });


        jTextArea3.setColumns(20);
        jTextArea3.setRows(5);
        jScrollPane3.setViewportView(jTextArea3);
        jTextArea3.setText(addList.get(0).getContent());

        jTextArea4.setColumns(20);
        jTextArea4.setRows(5);
        jScrollPane4.setViewportView(jTextArea4);
        jTextArea4.setText(addList.get(1).getContent());

        jTextArea5.setColumns(20);
        jTextArea5.setRows(5);
        jScrollPane5.setViewportView(jTextArea5);
        jTextArea5.setText(addList.get(2).getContent());

        jTextArea6.setColumns(20);
        jTextArea6.setRows(5);
        jScrollPane6.setViewportView(jTextArea6);
        jTextArea6.setText(addList.get(3).getContent());

        jTextArea7.setColumns(20);
        jTextArea7.setRows(5);
        jScrollPane7.setViewportView(jTextArea7);
        jTextArea7.setText(addList.get(4).getContent());

        jCheckBox1.setText("1");
        jCheckBox1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                jCheckBox1MouseClicked(e);
            }
        });

        jCheckBox2.setText("2");
        jCheckBox2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                jCheckBox2MouseClicked(e);
            }
        });

        jCheckBox3.setText("4");
        jCheckBox3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                jCheckBox3MouseClicked(e);
            }
        });

        jCheckBox4.setText("3");
        jCheckBox4.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                jCheckBox4MouseClicked(e);
            }
        });

        jCheckBox5.setText("5");
        jCheckBox5.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                jCheckBox5MouseClicked(e);
            }
        });

        jButton6.setText("确认删除");
        jButton6.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                jButton6MouseClicked(e);
            }
        });


        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(150, 150, 150)
                                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(26, 26, 26)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jCheckBox1)
                                                        .addComponent(jCheckBox2)
                                                        .addComponent(jCheckBox4)
                                                        .addComponent(jCheckBox3)
                                                        .addComponent(jCheckBox5))
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                .addComponent(jScrollPane3)
                                                                .addComponent(jScrollPane5)
                                                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 492, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(12, 12, 12)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                        .addComponent(jScrollPane7)
                                                                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 492, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                                .addGap(96, 96, 96)
                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(96, 96, 96))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(9, 9, 9)
                                                .addComponent(jCheckBox1)
                                                .addGap(24, 24, 24)
                                                .addComponent(jCheckBox2)
                                                .addGap(24, 24, 24)
                                                .addComponent(jCheckBox4)
                                                .addGap(24, 24, 24)
                                                .addComponent(jCheckBox3)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(10, 10, 10)
                                                .addComponent(jCheckBox5)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(56, 56, 56))
        );

        pack();
    }// </editor-fold>

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DelExamine.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DelExamine.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DelExamine.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DelExamine.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new DelExamine().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JCheckBox jCheckBox5;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTextArea jTextArea3;
    private javax.swing.JTextArea jTextArea4;
    private javax.swing.JTextArea jTextArea5;
    private javax.swing.JTextArea jTextArea6;
    private javax.swing.JTextArea jTextArea7;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration
}

