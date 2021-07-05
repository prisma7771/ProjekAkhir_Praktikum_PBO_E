package Main;

import View.ViewLogin;
import Controller.ControllerLogin;
import Model.ModelLogin;

public class MVCLogin {

    ViewLogin vl = new ViewLogin();
    ModelLogin mlog = new ModelLogin();
    ControllerLogin cl = new ControllerLogin(vl, mlog);
}
