import models.Liner;
import models.Exponential;
import frames.MainFrame;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Liner liner = new Liner();
        Exponential exponential = new Exponential();
        MainFrame mainFrame = new MainFrame(liner, exponential);

    }
}