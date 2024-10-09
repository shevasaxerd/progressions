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

    public void start(){
        System.out.print("The first element of progression: ");
        int firstElement = 5; System.out.println(firstElement);

        System.out.print("The cofficient: ");
        int coefficient = 3; System.out.println(coefficient);

        System.out.print("The size of progression: ");
        int index = 16; System.out.println(index);

        System.out.println(liner.getElement(firstElement, 5, coefficient));
        System.out.println(liner.sumOfProgression(firstElement, index, coefficient));
        System.out.println(liner.toString(firstElement, index, coefficient));
        liner.exportInFile(firstElement, index, coefficient);

        System.out.println(" --------------------------------------------------- ");

        System.out.print("The first element of progression: ");
        firstElement = 1; System.out.println(firstElement);

        System.out.print("The cofficient: ");
        coefficient = 2; System.out.println(coefficient);

        System.out.print("Enter size of progression: ");
        index = 11; System.out.println(index);

        System.out.println(exponential.getElement(firstElement, 5, coefficient));
        System.out.println(exponential.sumOfProgression(firstElement, index, coefficient));
        System.out.println(exponential.toString(firstElement, index, coefficient));
        exponential.exportInFile(firstElement, index, coefficient);

    }
}
