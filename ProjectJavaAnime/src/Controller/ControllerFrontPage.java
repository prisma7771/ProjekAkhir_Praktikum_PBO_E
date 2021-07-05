package Controller;

import View.ViewFrontPage;
import Main.MVCLogin;
import Main.MVCRegister;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControllerFrontPage implements ActionListener {

    ViewFrontPage viewfrontpage;

    public ControllerFrontPage(ViewFrontPage viewfrontpage) {
        this.viewfrontpage = viewfrontpage;

        viewfrontpage.jlogin.addActionListener(this);
        viewfrontpage.jregister.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == viewfrontpage.jlogin) {
            System.out.println("clicked");
            viewfrontpage.setVisible(false);
            MVCLogin ml = new MVCLogin();
        } else if (e.getSource() == viewfrontpage.jregister) {
            MVCRegister mr = new MVCRegister();
            viewfrontpage.setVisible(false);
        }
    }
}
