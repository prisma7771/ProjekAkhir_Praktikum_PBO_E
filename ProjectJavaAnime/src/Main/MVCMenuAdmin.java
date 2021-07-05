package Main;

import View.ViewMenuAdmin;
import Model.ModelMenuShowAdmin;
import Controller.ControllerMenuAdmin;

public class MVCMenuAdmin {

    Akun akun;

    public MVCMenuAdmin(Akun akun) {
        this.akun = akun;
        ViewMenuAdmin vma = new ViewMenuAdmin(akun);
        ModelMenuShowAdmin mmsa = new ModelMenuShowAdmin(akun);
        ControllerMenuAdmin cma = new ControllerMenuAdmin(vma, mmsa);

    }

}
