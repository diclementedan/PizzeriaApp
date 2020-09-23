/*
    Drinks.java
    Author: Daniel Di Clemente
    Date: April 4, 2020

    Description
    This is an enumeration class that represents the drink options that are
    available to be ordered.
*/

package diclemed;

import javafx.scene.control.ColorPicker;

/**
 *
 * @author D.D
 */
public enum Drinks {
    
    COKE("Coke", 1.25),
    JUICE("Juice", 1.95),
    CHOCOLATE_MILK("Chocolate Milk", 2.25);
    
    private String drinkName;
    private double drinkPrice;

    /**
     * Private constructor to build the enumeration options for drinks
     * @param drinkName the name of the drink as a String
     * @param drinkCost the cost of the drink as a double
     */
    private Drinks(String drinkName, double drinkCost) {
        this.drinkName = drinkName;
        this.drinkPrice = drinkCost;
    }

    /**
     * Retrieves the name of the drink
     * @return the String containing the drink name
     */
    public String getDrinkName() {
        return drinkName;
    }

    /**
     * Retrieves the price of the drink
     * @return a double containing the drink price
     */
    public double getDrinkPrice() {
        return drinkPrice;
    }

    /**
     * A string representation of the drink option
     * @return a formatted String containing the drink name and price
     */
    @Override
    public String toString() {
        return String.format("%s @ $%.2f", drinkName, drinkPrice);
    }
    
    
}
