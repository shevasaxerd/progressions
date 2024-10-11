import models.Liner;
import models.Series;
import models.Exponential;
import frames.windows.MainFrame;
import services.MainService;

public class Main {
    public static void main(String[] args) {
        Liner liner = new Liner();
        Exponential exponential = new Exponential();
        MainFrame mainFrame = new MainFrame(liner, exponential);

    }
}