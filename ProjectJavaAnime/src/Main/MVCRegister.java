package Main;

import View.ViewRegister;
import Model.ModelRegister;
import Controller.ControllerRegister;

public class MVCRegister {

    ViewRegister vr = new ViewRegister();
    ModelRegister mreg = new ModelRegister();
    ControllerRegister cr = new ControllerRegister(vr, mreg);
}
