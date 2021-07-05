package View;

import javax.swing.*;
import java.awt.*;
import javax.swing.BorderFactory;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;

public class ViewFrontPage extends JFrame {

    Font font = new Font("Rockwell", Font.BOLD, 16);
    JLabel lbl1 = new JLabel("Welcome to ANIMUKU");
    JLabel lbl2 = new JLabel("Where You Can Found Your Favorite Anime");
    JLabel lbl3 = new JLabel("ENJOY!!!");

    public JButton jlogin = new JButton("Login");
    public JButton jregister = new JButton("Register");

    JPanel jpanel1 = new JPanel();
    JPanel jpanel = new JPanel();

    Image img = Toolkit.getDefaultToolkit().getImage("img\\Lovelive.jpeg");

    public ViewFrontPage() {

        this.setContentPane(new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(img, 0, 0, this);
            }
        });
        setTitle("AnimuKU.com");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(550, 200);
        setResizable(false);
        setVisible(true);
        setLayout(null);
        setSize(300, 400);

        add(jpanel);
        jpanel.setVisible(true);
        jpanel.setLayout(null);
        jpanel.setSize(70, 100);
        jpanel.setBounds(20, 10, 250, 100);
        jpanel.setBackground(new Color(255, 255, 255, 200));
        jpanel.setBorder(BorderFactory.createLineBorder(Color.black));

        jpanel.add(lbl1);
        lbl1.setFont(font);
        lbl1.setBounds(35, 2, 180, 50);
        jpanel.add(lbl2);
        lbl2.setBounds(5, 25, 250, 50);
        jpanel.add(lbl3);
        lbl3.setBounds(100, 50, 150, 50);

        add(jpanel1);
        jpanel1.setBorder(BorderFactory.createLineBorder(Color.black));

        jpanel1.setVisible(true);
        jpanel1.setLayout(null);
        jpanel1.setSize(70, 100);
        jpanel1.setBounds(60, 160, 170, 120);
        jpanel1.setBackground(new Color(255, 255, 255, 200));

        jpanel1.add(jlogin);
        jlogin.setBounds(37, 20, 100, 25);
        jlogin.setBorder(new SoftBevelBorder(BevelBorder.RAISED));

        jpanel1.add(jregister);
        jregister.setBounds(37, 60, 100, 25);
        jregister.setBorder(new SoftBevelBorder(BevelBorder.RAISED));

    }
}
