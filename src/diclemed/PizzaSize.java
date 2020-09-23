/*
    PizzzaSize.java
    Author: Daniel Di Clemente
    Date: April 4, 2020

    Description
    This class is an enumeration class representing the available sizes that a
    pizza can be ordered as. Each constant has a name and a price associated.
 */
package diclemed;

/**
 *
 * @author D.D
 */
public enum PizzaSize {

    SMALL("Small", 5.25),
    MEDIUM("Medium", 7.50),
    LARGE("Large", 9.95);
    
    private String sizeName;
    private double sizePrice;

    /**
     * Private constructor to build the enumeration
     * @param sizeName name of the pizza size
     * @param sizePrice price of the size as a double
     */
    private PizzaSize(String sizeName, double sizePrice) {
        this.sizeName = sizeName;
        this.sizePrice = sizePrice;
    }

    /**
     * Retrieves the name of the size as a String
     * @return the name of the pizza size
     */
    public String getSizeName() {
        return sizeName;
    }

    /**
     * Retrieves the price of the pizza size as a double
     * @return the pizza sizes price
     */
    public double getSizePrice() {
        return sizePrice;
    }

    /**
     * Retrieves a string representation of the enumeration
     * @return A formatted String containing the pizza sizes name and price
     */
    @Override
    public String toString() {
        return String.format("%s @ $%.2f", sizeName, sizePrice);
    }
    
    
}
