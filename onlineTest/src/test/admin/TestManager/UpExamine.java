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
public class UpExamine extends javax.swing.JFrame {

    public UpExamine() {
        initComponents();
    }

    private List<examine> addlist = new ArrayList<>();
    private List<examine> uplist = new ArrayList<>();
    private int count=1;

    private void jButton5MouseClicked(MouseEvent evt) {
        OutputStream output = null;
        if (jTextArea1.equals(null) && jTextArea1.equals("")) {
            JOptionPane.showMessageDialog(this, "请输入问题", "提示信息", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        if (jTextArea1.equals(null) || jTextArea1.equals("") || jTextArea2.equals(null) || jTextArea2.equals("") || jTextArea3.equals(null) || jTextArea3.equals("") || jTextArea4.equals(null) || jTextArea4.equals("") || jTextArea5.equals(null) || jTextArea5.equals("")) {
            JOptionPane.showMessageDialog(this, "请输入答案内容", "提示信息", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        if (!jRadioButton1.isSelected() && !jRadioButton2.isSelected() && !jRadioButton3.isSelected() && !jRadioButton4.isSelected()) {
            JOptionPane.showMessageDialog(this, "请考题答案", "提示信息", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

//        examine ex = new examine();
//        ex.setContent(jTextArea1.getText());
//        ex.setA(jTextArea2.getText());
//        ex.setB(jTextArea3.getText());
//        ex.setC(jTextArea4.getText());
//        ex.setD(jTextArea5.getText());
//        if (jRadioButton1.isSelected()) {
//            ex.setAnswer("A");
//        }
//        if (jRadioButton2.isSelected()) {
//            ex.setAnswer("B");
//        }
//        if (jRadioButton3.isSelected()) {
//            ex.setAnswer("C");
//        }
//        if (jRadioButton4.isSelected()) {
//            ex.setAnswer("D");
//        }
//        ex.seteId(addlist.get(count - 1).geteId());
//        uplist.add(ex);

        String string="";
        System.out.println(uplist);
        for (examine ex:uplist) {
            string +=ex.geteId()+"`"+ex.getContent()+"`"+ex.getA()+"`"+ex.getB()+"`"+ex.getC()+"`"+ex.getD()+"`"+ex.getAnswer()+"`";
        }

        try {
            output = LoginUser.socket.getOutputStream();
            output.write(("upExamine" + "`" +string).getBytes());
            output.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        InputStream input = null;
        byte[] arr = new byte[1000000];
        String result = null;
        try {
            input = LoginUser.socket.getInputStream();
            int length = input.read(arr);
            result = new String(arr, 0, length);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (result.equals("成功")) {
            JOptionPane.showMessageDialog(this, "修改成功", "提示信息", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

    }

    private void jButton6MouseClicked(MouseEvent evt) {
        examine ex = new examine();
        ex.setContent(jTextArea1.getText());
        ex.setA(jTextArea2.getText());
        ex.setB(jTextArea3.getText());
        ex.setC(jTextArea4.getText());
        ex.setD(jTextArea5.getText());
        if (jRadioButton1.isSelected()) {
            ex.setAnswer("A");
        }
        if (jRadioButton2.isSelected()) {
            ex.setAnswer("B");
        }
        if (jRadioButton3.isSelected()) {
            ex.setAnswer("C");
        }
        if (jRadioButton4.isSelected()) {
            ex.setAnswer("D");
        }
        ex.seteId(addlist.get(count - 1).geteId());
        uplist.add(ex);

        if (count >= addlist.size()) {
            JOptionPane.showMessageDialog(this, "最后一页", "提示信息", JOptionPane.INFORMATION_MESSAGE);
            return;
        }else {

            System.out.println(count);
            System.out.println("-----------");
            System.out.println(addlist.size());
            buttonGroup.clearSelection();
            jTextArea1.setText(addlist.get(count).getContent());
            jTextArea2.setText(addlist.get(count).getA());
            jTextArea3.setText(addlist.get(count).getB());
            jTextArea4.setText(addlist.get(count).getC());
            jTextArea5.setText(addlist.get(count).getD());
            if (addlist.get(count).getAnswer().equals("A")) {
                jRadioButton1.setSelected(true);
            } else if (addlist.get(count).getAnswer().equals("B")) {
                jRadioButton2.setSelected(true);
            } else if (addlist.get(count).getAnswer().equals("C")) {
                jRadioButton3.setSelected(true);
            } else if (addlist.get(count).getAnswer().equals("D")) {
                jRadioButton4.setSelected(true);
            }
            count++;
        }
    }

    private void jButton7MouseClicked(MouseEvent evt) {
        new ManagerTest().setVisible(true);
        dispose();
    }

    private void jButton8MouseClicked(MouseEvent evt) {
        addlist.clear();
        OutputStream output = null;
        if (jTextField2.equals(null) && jTextField2.equals("")) {
            JOptionPane.showMessageDialog(this, "请输入关键字", "提示信息", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        try {
            output = LoginUser.socket.getOutputStream();
            output.write(("selExamineKey" + "`" + jTextField2.getText()).getBytes());
            output.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        InputStream input = null;
        byte[] arr = new byte[1000000];
        String result = null;
        String[] recieve = null;
        try {
            input = LoginUser.socket.getInputStream();
            int length = input.read(arr);
            result = new String(arr, 0, length);
            recieve = result.split("`");
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (result.equals("成功")) {
            JOptionPane.showMessageDialog(this, "修改成功", "提示信息", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        for (int i = 0; i < recieve.length; i++) {
            examine ex = new examine();
            ex.seteId(Integer.valueOf(recieve[i++]));
            ex.setContent(recieve[i++]);
            ex.setA(recieve[i++]);
            ex.setB(recieve[i++]);
            ex.setC(recieve[i++]);
            ex.setD(recieve[i++]);
            ex.setAnswer(recieve[i]);
            addlist.add(ex);
        }
        jTextArea1.setText(addlist.get(0).getContent());
        jTextArea2.setText(addlist.get(0).getA());
        jTextArea3.setText(addlist.get(0).getB());
        jTextArea4.setText(addlist.get(0).getC());
        jTextArea5.setText(addlist.get(0).getD());
        if (addlist.get(0).getAnswer().equals("A")) {
            jRadioButton1.setSelected(true);
        } else if (addlist.get(0).getAnswer().equals("B")) {
            jRadioButton2.setSelected(true);
        } else if (addlist.get(0).getAnswer().equals("C")) {
            jRadioButton3.setSelected(true);
        } else if (addlist.get(0).getAnswer().equals("D")) {
            jRadioButton4.setSelected(true);
        }
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

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
        jButton8 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jTextField2 = new javax.swing.JTextField();
        jButton6=new JButton();
        buttonGroup = new ButtonGroup();

        buttonGroup.add(jRadioButton1);
        buttonGroup.add(jRadioButton2);
        buttonGroup.add(jRadioButton3);
        buttonGroup.add(jRadioButton4);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("学生系统");

        jButton5.setText("确认修改");
        jButton5.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                jButton5MouseClicked(e);
            }
        });

        jButton6.setText("下一页");
        jButton6.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                jButton6MouseClicked(e);
            }
        });

        jTextField1.setFont(new java.awt.Font("Lucida Grande", 0, 22)); // NOI18N
        jTextField1.setText("        试 题 修 改 系 统");
        jTextField1.setActionCommand("<Not Set>");

        jButton7.setText("退出系统");
        jButton7.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                jButton7MouseClicked(e);
            }
        });

        jRadioButton1.setText("A");

        jRadioButton2.setText("B");

        jRadioButton3.setText("C");

        jRadioButton4.setText("D");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane2.setViewportView(jTextArea2);

        jTextArea3.setColumns(20);
        jTextArea3.setRows(5);
        jScrollPane3.setViewportView(jTextArea3);

        jTextArea4.setColumns(20);
        jTextArea4.setRows(5);
        jScrollPane4.setViewportView(jTextArea4);

        jTextArea5.setColumns(20);
        jTextArea5.setRows(5);
        jScrollPane5.setViewportView(jTextArea5);

        jButton8.setText("确认查询");
        jButton8.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                jButton8MouseClicked(e);
            }
        });

        jButton1.setText("输入关键字");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(19, 19, 19)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jRadioButton1)
                                                                .addGap(7, 7, 7)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                        .addComponent(jScrollPane1)
                                                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 492, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                        .addComponent(jRadioButton2)
                                                                        .addComponent(jRadioButton3)
                                                                        .addComponent(jRadioButton4))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                        .addComponent(jScrollPane3)
                                                                        .addComponent(jScrollPane5)
                                                                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 492, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(150, 150, 150)
                                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(140, 140, 140)
                                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(31, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
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
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(24, 24, 24))
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
            java.util.logging.Logger.getLogger(UpExamine.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UpExamine.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UpExamine.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UpExamine.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new UpExamine().setVisible(true);
            }
        });
    }


    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
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
    private javax.swing.JTextField jTextField2;
    private ButtonGroup buttonGroup;
}

