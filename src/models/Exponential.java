package models;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;


public class Exponential implements Series{
    public int getElement(int firstElement, int index, int coefficient){
        return (int) ( firstElement * Math.pow(coefficient, index - 1));
    }
    public int sumOfProgression(int firstElement, int index, int coefficient){
       if (coefficient!=1) { return (int) ( firstElement * (Math.pow(coefficient, index) - 1) / (coefficient - 1)); }
       else {return firstElement*index;}
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
    public void exportInFile (int firstElement, int index, int coefficient, String fileName){
        File outputDir = new File("./files");
        if (!outputDir.exists()) {
            outputDir.mkdirs();
        }
        String fullPath = "./files/" + fileName + ".txt";

        int[] progression = new int[index];
        String progressionString = "";
        for(int i = 0; i<index; i++){
            progression[i] = (int) (firstElement * Math.pow(coefficient, i));
            progressionString = progressionString + progression[i] + " ";}
        try {
            FileWriter writer = new FileWriter(fullPath, false);
            writer.write(progressionString);
            writer.close();
            System.out.println("Writing to the file is successful");
        } catch (IOException e) {
            System.out.println("Error writing to file!");
            e.printStackTrace();
        }
    }

}
