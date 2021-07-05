package Main;

import View.ViewMenuAdmin;
import Controller.ControllerEditData;
import Model.ModelEditData;
import Model.ModelMenuShowAdmin;
import View.ViewEditDialog;

public class MVCEditData {

    String Judul;
    ViewMenuAdmin vma;
    ModelMenuShowAdmin mmsa;

    public MVCEditData(ViewMenuAdmin vma, ModelMenuShowAdmin mmsa, String Judul) {
        this.vma = vma;
        this.mmsa = mmsa;
        this.Judul = Judul;

        ViewEditDialog d = new ViewEditDialog(Judul);
        ModelEditData med = new ModelEditData();
        ControllerEditData ced = new ControllerEditData(vma, mmsa, d, med);
    }

}
