package Main;

import View.ViewMenu;
import Model.ModelMenuShow;
import Controller.ControllerMenu;

public class MVCMenu {

    Akun akun;

    public MVCMenu(Akun akun) {
        this.akun = akun;
        ViewMenu vl = new ViewMenu(akun);
        ModelMenuShow mms = new ModelMenuShow(akun);
        ControllerMenu cm = new ControllerMenu(vl, mms);
    }

}
