package Controller;

import Main.MVCFrontPage;
import Main.MVCLogin;
import View.ViewRegister;
import Model.ModelRegister;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static javax.swing.JOptionPane.showMessageDialog;

public class ControllerRegister implements ActionListener {

    MVCFrontPage mfp;
    ViewRegister vr;
    ModelRegister mreg;

    public ControllerRegister(ViewRegister vr, ModelRegister mreg) {
        this.vr = vr;
        this.mreg = mreg;

        vr.jButton1.addActionListener(this);
        vr.jButton2.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vr.jButton1) {
            String username = vr.getjTextField0();
            String name = vr.getjTextField1();
            String email = vr.getjTextField2();
            String password = vr.getjTextField3();
            String noHp = vr.getjTextField4();

            if (username.equals("") || email.equals("") || name.equals("") || email.equals("") || password.equals("") || noHp.equals("")) {
                JOptionPane.showMessageDialog(null, "Data Tidak Boleh Kosong");

            }
            if (!noHp.matches("^[0-9]+$")) {
                showMessageDialog(null, "NoTelepon Must Digit");
            } else {
                if (mreg.TambahAkun(username, name, email, password, noHp) == 1) {
                    JOptionPane.showMessageDialog(null, "Selamat Bergabug Dengan Kami!");
                    MVCLogin ml = new MVCLogin();
                    vr.setVisible(false);

                } else {
                    JOptionPane.showMessageDialog(null, "Email/Username Telah Terdaftar!");
                }
            }

        } else if (e.getSource() == vr.jButton2) {
            System.out.println("click");
            MVCFrontPage mfp = new MVCFrontPage();
            vr.setVisible(false);
        }
    }

}
