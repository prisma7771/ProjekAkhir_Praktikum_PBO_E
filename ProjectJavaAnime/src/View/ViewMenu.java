package View;

import javax.swing.*;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JPanel;
import javax.swing.BorderFactory;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import Main.Akun;

public class ViewMenu extends JFrame {

    public ViewMenuShow vsm;
    public ViewMenuDownload vmd;
    public ViewMenuLibrary vml;
    public JButton jButton1;
    public JButton jButton2;
    public JButton jButton3;
    public JButton jButton4;
    public JButton jLabel1;
    JLabel jLabel2;
    JLabel jLabel3;
    JLabel jLabel4;
    JLabel jLabel5;
    JPanel jPanel1;
    JPanel jPanel2;
    JPanel jPanel3;
    Image img = Toolkit.getDefaultToolkit().getImage("img\\Lovelive.jpeg");
    Akun akun;

    public ViewMenu(Akun akun) {
        this.akun = akun;
        vsm = new ViewMenuShow(akun);
        vmd = new ViewMenuDownload(akun);
        vml = new ViewMenuLibrary(akun);

        jPanel1 = new JPanel();
        jPanel2 = new JPanel();
        jPanel3 = new JPanel();
        jButton1 = new JButton();
        jButton2 = new JButton();
        jButton3 = new JButton();
        jButton4 = new JButton();
        jLabel1 = new JButton();
        jLabel2 = new JLabel();
        jLabel4 = new JLabel();
        jLabel5 = new JLabel();

        this.setContentPane(new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
            }
        });
        setTitle("AnimuKU.com");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(550, 200);
        setResizable(false);
        setVisible(true);
        setLayout(null);
        setSize(500, 333);

        jPanel1.setBackground(new java.awt.Color(0, 204, 204));
        jPanel1.setBorder(BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setLayout(null);

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Franklin Gothic Heavy", 0, 10)); 
        jButton1.setForeground(new java.awt.Color(51, 51, 51));
        jButton1.setText("SHOW LIST");
        jButton1.setBorder(new SoftBevelBorder(BevelBorder.RAISED));

        jPanel1.add(jButton1);
        jButton1.setBounds(11, 52, 67, 19);

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("Franklin Gothic Heavy", 0, 10)); 
        jButton2.setForeground(new java.awt.Color(51, 51, 51));
        jButton2.setText("DOWNLOAD");
        jButton2.setBorder(new SoftBevelBorder(BevelBorder.RAISED));

        jPanel1.add(jButton2);
        jButton2.setBounds(11, 89, 67, 19);

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setFont(new java.awt.Font("Franklin Gothic Heavy", 0, 10)); 
        jButton3.setForeground(new java.awt.Color(51, 51, 51));
        jButton3.setText("YOUR ANIME");
        jButton3.setBorder(new SoftBevelBorder(BevelBorder.RAISED));

        jPanel1.add(jButton3);
        jButton3.setBounds(11, 126, 67, 19);

        jButton4.setBackground(new java.awt.Color(255, 255, 255));
        jButton4.setFont(new java.awt.Font("Franklin Gothic Heavy", 0, 10)); 
        jButton4.setForeground(new java.awt.Color(51, 51, 51));
        jButton4.setText("LOGOUT");
        jButton4.setBorder(new SoftBevelBorder(BevelBorder.RAISED));

        jPanel1.add(jButton4);
        jButton4.setBounds(11, 163, 67, 19);

        add(jPanel1);
        jPanel1.setBounds(0, 0, 100, 330);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255, 195));
        jPanel2.setBorder(BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 3, 18)); 
        jLabel2.setText("WELCOME HOME,");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(42, 1, 157, 37);

        jLabel5.setFont(new java.awt.Font("Franklin Gothic Heavy", 3, 36)); 
        jLabel5.setForeground(new java.awt.Color(0, 0, 255));
        jLabel5.setHorizontalAlignment(SwingConstants.RIGHT);
        jLabel5.setText("ANIMUKU.COM");
        jPanel2.add(jLabel5);
        jLabel5.setBounds(20, 230, 260, 41);

        jLabel4.setFont(new java.awt.Font("Times New Roman", 3, 20)); 
        jPanel2.add(jLabel4);
        jLabel4.setBounds(200, 3, 174, 30);
        jLabel4.setText(akun.getusername());

        add(jPanel2);
        jPanel2.setBounds(110, 30, 380, 300);

        jPanel3.setBackground(new java.awt.Color(0, 204, 204));
        jPanel3.setLayout(null);
        jPanel3.setBorder(BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setFont(new java.awt.Font("Franklin Gothic Heavy", 3, 24)); 
        jLabel1.setText("ANIMUKU.COM");
        jPanel3.add(jLabel1);
        jLabel1.setBounds(180, 5, 180, 20);
        jLabel1.setBorder(BorderFactory.createEmptyBorder());
        jLabel1.setBackground(new java.awt.Color(0, 204, 204));

        add(jPanel3);
        jPanel3.setBounds(110, 0, 380, 30);

    }

    public void ShowMenu() {

        jPanel2.setVisible(false);
        vmd.setVisible(false);
        vml.setVisible(false);
        add(vsm);
        vsm.setBounds(110, 30, 380, 300);
        vsm.setVisible(true);
    }

    public void HomeMenu() {
        jPanel2.setVisible(true);
        vsm.setVisible(false);
        vmd.setVisible(false);
        vml.setVisible(false);
    }

    public void ShowDownload() {
        jPanel2.setVisible(false);
        vsm.setVisible(false);
        vml.setVisible(false);
        add(vmd);
        vmd.setBounds(110, 30, 380, 300);
        vmd.setVisible(true);
    }

    public void ShowLibrary() {
        jPanel2.setVisible(false);
        vsm.setVisible(false);
        vmd.setVisible(false);
        add(vml);
        vml.setBounds(110, 30, 380, 300);
        vml.setVisible(true);
    }
}
