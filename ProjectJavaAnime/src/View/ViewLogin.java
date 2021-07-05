package View;

import javax.swing.JLabel;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;

public class ViewLogin extends JFrame {

    JLabel lbl1 = new JLabel("LOGIN");
    JLabel lbl2 = new JLabel("E-MAIL/USERNAME");
    JLabel lbl3 = new JLabel("PASSWORD");

    JPanel jp1 = new JPanel();
    JPanel jp2 = new JPanel();

    public JTextField femail = new JTextField();
    public JPasswordField fpass = new JPasswordField();

    public JButton jblogin = new JButton("LOGIN");
    public JButton jbback = new JButton("BACK");

    Image img = Toolkit.getDefaultToolkit().getImage("img\\Lovelive.jpeg");

    public ViewLogin() {

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

        add(jp2);
        jp2.setBounds(100, 20, 100, 50);
        jp2.setLayout(null);
        jp2.setSize(100, 30);
        jp2.setVisible(true);
        jp2.setBorder(BorderFactory.createLineBorder(Color.blue));
        jp2.setBackground(new Color(255, 255, 255, 220));
        
        jp2.add(lbl1);
        lbl1.setBounds(33, 5, 100, 20);
        
        add(jp1);
        jp1.setBounds(30, 80, 280, 280);
        jp1.setLayout(null);
        jp1.setSize(230, 230);
        jp1.setVisible(true);
        jp1.setBorder(BorderFactory.createLineBorder(Color.blue));
        jp1.setBackground(new Color(255, 255, 255, 220));

        jp1.add(lbl2);
        lbl2.setBounds(65, 20, 150, 10);
        jp1.add(femail);
        femail.setBounds(27, 40, 180, 25);

        jp1.add(lbl3);
        lbl3.setBounds(80, 100, 100, 10);
        jp1.add(fpass);
        fpass.setBounds(27, 120, 180, 25);

        jp1.add(jbback);
        jbback.setBounds(28, 180, 85, 25);
        jbback.setBorder(new SoftBevelBorder(BevelBorder.RAISED));

        jp1.add(jblogin);
        jblogin.setBounds(120, 180, 85, 25);
        jblogin.setBorder(new SoftBevelBorder(BevelBorder.RAISED));

    }

    public String getFemail() {
        return femail.getText();
    }

    public String getFpass() {
        return fpass.getText();
    }

}
