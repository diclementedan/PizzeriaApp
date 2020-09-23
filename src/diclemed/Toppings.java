/*
    Toppings.java
    Author: Daniel Di Clemente
    Date: April 4, 2020

    Description
    This class is an enumeration class that contains the toppings that are 
    available for purchase on a pizza. Each toping has an associated name and
    price.
 */
package diclemed;

/**
 *
 * @author D.D
 */
public enum Toppings {
    CHEESE("Cheese", 1.00),
    MUSHROOMS("Mushrooms", 1.25),
    OLIVES("Olives", 1.50),
    PEPPERONI("Pepperoni", 1.75);

    private String toppingName;
    private double toppingPrice;

    /**
     * Private constructor to build one of the enum variations
     * @param toppingName the name of the topping as a String
     * @param toppingPrice the price of the topping as a double
     */
    private Toppings(String toppingName, double toppingPrice) {
        this.toppingName = toppingName;
        this.toppingPrice = toppingPrice;
    }

    /**
     * Retrieves the name of the topping
     * @return the name of the topping as a String
     */
    public String getToppingName() {
        return toppingName;
    }

    /**
     * Retrieves the price of the topping
     * @return the topping price as a double
     */
    public double getToppingPrice() {
        return toppingPrice;
    }

    /**
     * A string representation of the topping
     * @return a formatted String containing the topping name and price
     */
    @Override
    public String toString() {
        return String.format("%s @ $%.2f", toppingName, toppingPrice);
    }

}
