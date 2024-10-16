package services;
import models.Exponential;
import models.Series;
import models.Liner;

public class MainService {
    private Liner liner;
    private Exponential exponential;
    public MainService(){}
    public MainService(Liner liner, Exponential exponential){
        this.liner=liner;
        this.exponential = exponential;
    }

}
