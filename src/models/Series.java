package models;

public interface Series {
    public int getElement(int firstElement, int index, int coefficient);
    public int sumOfProgression(int firstElement, int index, int coefficient);
    public String toString(int firstElement, int index, int coefficient);
    public void exportInFile (int firstElement, int index, int coefficient);



}