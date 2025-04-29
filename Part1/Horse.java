import java.lang.Math;

/**
 * Write a description of class Horse here.
 * 
 * @author Benjamin Maltby
 * @version 22/4/2025
 */
public class Horse
{
    //Fields of class Horse
    
    private String name;
    private char symbol;
    private int distanceTravelled;
    private boolean hasFallen;
    private double confidence;
      
    //Constructor of class Horse
    /**
     * Constructor for objects of class Horse
     */
    public Horse(char horseSymbol, String horseName, double horseConfidence) {
        symbol = horseSymbol;
        name = horseName;
        confidence = horseConfidence;
        distanceTravelled = 0;
        hasFallen = false;
    }
    
    //Other methods of class Horse
    public void fall() {
        hasFallen = true;
    }

    public double getConfidence() {
        return confidence;
    }

    public int getDistanceTravelled() {
        return distanceTravelled;
    }

    public String getName() {
        return name;
    }

    public char getSymbol() {
        return symbol;
    }

    public void goBackToStart() {
        distanceTravelled = 0;
        hasFallen = false;
    }

    public boolean hasFallen() {
        return hasFallen;
    }

    public void moveForward() {
        distanceTravelled++;
    }

    public void setConfidence(double newConfidence) {
        // Clamp newConfidence between 0 and 1
        confidence = Math.min(1, Math.max(0, newConfidence));
    }

    public void setSymbol(char newSymbol) {
        symbol = newSymbol;
    }
    
}
