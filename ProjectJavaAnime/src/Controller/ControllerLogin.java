package Controller;

import Main.MVCFrontPage;
import Main.MVCMenu;
import Main.MVCMenuAdmin;
import View.ViewLogin;
import Model.ModelLogin;
import Main.Akun;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControllerLogin implements ActionListener {

    ViewLogin vl;
    ModelLogin mlog;

    public ControllerLogin(ViewLogin vl, ModelLogin mlog) {
        this.vl = vl;
        this.mlog = mlog;

        vl.jblogin.addActionListener(this);
        vl.jbback.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vl.jblogin) {
            String email = vl.getFemail();
            String password = vl.getFpass();

            if (email.equals("") || password.equals("")) {
                JOptionPane.showMessageDialog(null, "Data Tidak Boleh Kosong");
            } else {
                if (mlog.HitungAkun(email, password) == 1) {
                    JOptionPane.showMessageDialog(null, "Berhasil Masuk!");
                    vl.setVisible(false);
                    mlog.CekAkun(email, password);
                    String username = mlog.data[0];
                    String mail = mlog.data[1];
                    Akun akun = new Akun(mail, username);
                    MVCMenu mm = new MVCMenu(akun);
                } else if (mlog.HitungAdmin(email, password) == 1) {
                    JOptionPane.showMessageDialog(null, "Berhasil Masuk!");
                    vl.setVisible(false);
                    mlog.CekAdmin(email, password);
                    String username = mlog.data[0];
                    Akun akun = new Akun(username);
                    MVCMenuAdmin mma = new MVCMenuAdmin(akun);
                } else {
                    JOptionPane.showMessageDialog(null, "Email / Password Salah");
                }
            }

        } else if (e.getSource() == vl.jbback) {
            System.out.println("click");
            MVCFrontPage mfp = new MVCFrontPage();
            vl.setVisible(false);
        }
        reset();
    }

    public void reset() {
        vl.femail.setText("");
        vl.fpass.setText("");
    }
}
