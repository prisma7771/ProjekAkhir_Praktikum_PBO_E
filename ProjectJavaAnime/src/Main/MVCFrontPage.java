package Main;

import View.ViewFrontPage;
import Controller.ControllerFrontPage;

public class MVCFrontPage {

    ViewFrontPage fp = new ViewFrontPage();
    ControllerFrontPage cfp = new ControllerFrontPage(fp);
}
