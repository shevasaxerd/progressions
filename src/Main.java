import models.Liner;
import models.Series;
import models.Exponential;
import services.MainService;

public class Main {
    public static void main(String[] args) {
        Liner liner = new Liner();
        Exponential exponential = new Exponential();
        MainService mainService = new MainService(liner, exponential);
        mainService.start();

    }
}