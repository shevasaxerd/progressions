package models;
import java.io.FileWriter;
import java.io.IOException;

public class Exponential implements Series{
    public int getElement(int firstElement, int index, int coefficient){
        return (int) ( firstElement * Math.pow(coefficient, index - 1));
    }
    public int sumOfProgression(int firstElement, int index, int coefficient){
        return (int) ( firstElement * (Math.pow(coefficient, index) - 1) / (coefficient - 1));
    }
    public String toString(int firstElement, int index, int coefficient){
        int[] progression = new int[index];
        String progressionString = "";
        for(int i = 0; i<index; i++){
            progression[i] = (int) (firstElement * Math.pow(coefficient, i));
            progressionString = progressionString + progression[i] + " ";
        }
        return progressionString;
    }
    public void exportInFile (int firstElement, int index, int coefficient){
        int[] progression = new int[index];
        String progressionString = "";
        for(int i = 0; i<index; i++){
            progression[i] = (int) (firstElement * Math.pow(coefficient, i));
            progressionString = progressionString + progression[i] + " ";}
        try {
            FileWriter writer = new FileWriter("progression.txt", false);
            writer.write(progressionString);
            writer.close();
            System.out.println("Writing to the file is successful");
        } catch (IOException e) {
            System.out.println("Error writing to file!");
            e.printStackTrace();
        }
    }

}
