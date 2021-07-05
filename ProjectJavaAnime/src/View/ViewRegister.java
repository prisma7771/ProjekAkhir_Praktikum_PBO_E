package View;

import javax.swing.*;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.BorderFactory;
import java.awt.BasicStroke;
import java.awt.*;
import java.awt.Color;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class ViewRegister extends JFrame {

    public JButton jButton1;
    public JButton jButton2;
    JLabel jLabel0;
    JLabel jLabel1;
    JLabel jLabel2;
    JLabel jLabel3;
    JLabel jLabel4;
    JLabel jLabel5;
    JPanel jPanel1;
    JPanel jPanel2;
    public JTextField jTextField0;
    public JTextField jTextField1;
    public JTextField jTextField2;
    public JPasswordField jPasswordField3;
    public JTextField jTextField4;
    Image img2 = Toolkit.getDefaultToolkit().getImage("img\\Jinx_0.jpg");

    public ViewRegister() {
        this.setContentPane(new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(img2, 0, 0, this.getWidth(), this.getHeight(), this);
            }
        });

        setTitle("AnimuKU.com");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(450, 200);
        setResizable(false);
        setVisible(true);
        setLayout(null);
        setSize(600, 400);
        jPanel1 = new JPanel();
        jLabel0 = new JLabel();
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        jLabel4 = new JLabel();
        jLabel5 = new JLabel();
        jTextField0 = new JTextField();
        jTextField1 = new JTextField();
        jTextField2 = new JTextField();
        jPasswordField3 = new JPasswordField();
        jTextField4 = new JTextField();
        jButton1 = new JButton();
        jButton2 = new JButton();

        add(jPanel1);
        jPanel1.add(jLabel1);
        jPanel1.add(jLabel0);
        jPanel1.add(jLabel2);
        jPanel1.add(jLabel3);
        jPanel1.add(jLabel4);
        jPanel1.add(jLabel5);
        jPanel1.add(jTextField0);
        jPanel1.add(jTextField1);
        jPanel1.add(jTextField2);
        jPanel1.add(jPasswordField3);
        jPanel1.add(jTextField4);
        jPanel1.add(jButton1);
        jPanel1.add(jButton2);

        jLabel2.setFont(new Font("Nirmala UI", 1, 18));
        jLabel2.setText("REGISTER");
        jLabel2.setBounds(210, 10, 84, 35);

        jPanel1.setBackground(new Color(255, 255, 255, 200));
        jPanel1.setBorder(BorderFactory.createStrokeBorder(new BasicStroke((float) 5.0f), Color.black));
        jPanel1.setLayout(null);
        jPanel1.setBounds(20, 30, 530, 300);

        jLabel0.setFont(new Font("Tw Cen MT", 1, 11));
        jLabel0.setText("USERNAME");
        jLabel0.setBounds(70, 80, 85, 22);

        jLabel1.setFont(new Font("Tw Cen MT", 1, 11));
        jLabel1.setText("NAMA LENGKAP");
        jLabel1.setBounds(70, 110, 85, 22);

        jLabel3.setFont(new Font("Tw Cen MT", 1, 11));
        jLabel3.setText("E-MAIL");
        jLabel3.setBounds(70, 140, 85, 22);

        jLabel4.setFont(new Font("Tw Cen MT", 1, 11));
        jLabel4.setText("PASSWORD");
        jLabel4.setBounds(70, 170, 85, 22);

        jLabel5.setFont(new Font("Tw Cen MT", 1, 11));
        jLabel5.setText("No. TELEPON");
        jLabel5.setBounds(70, 200, 85, 22);

        jTextField0.setBounds(170, 80, 271, 20);
        jTextField1.setBounds(170, 110, 271, 20);
        jTextField2.setBounds(170, 140, 271, 20);
        jPasswordField3.setBounds(170, 170, 271, 20);
        jTextField4.setBounds(171, 200, 271, 20);

        jButton1.setFont(new Font("Nirmala UI", 1, 12));
        jButton1.setText("REGISTER");
        jButton1.setBorder(new SoftBevelBorder(BevelBorder.RAISED));
        jButton1.setBounds(294, 241, 84, 33);

        jButton2.setFont(new Font("Nirmala UI", 1, 12));
        jButton2.setText("BACK");
        jButton2.setBorder(new SoftBevelBorder(BevelBorder.RAISED));
        jButton2.setBounds(134, 241, 84, 33);

    }

    public String getjTextField0() {
        return jTextField0.getText();
    }

    public String getjTextField1() {
        return jTextField1.getText();
    }

    public String getjTextField2() {
        return jTextField2.getText();
    }

    public String getjTextField3() {
        return jPasswordField3.getText();
    }

    public String getjTextField4() {
        return jTextField4.getText();
    }
}
