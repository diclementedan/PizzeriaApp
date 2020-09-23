/*
    PizzaOrder.java
    Author: Daniel Di Clemente
    Date: April 4, 2020

    Description
    This class is the model class for the Pizzeria project. It models a pizza
    order. Contains all instance variables and an ArrayList for the toppings.
    Some exceptions are thrown to ensure no negative values are entered. Also
    the calculations for determining the pricing of the order takes place in
    this class. A string representation of the order can be retrieved from this
    class as well.
 */
package diclemed;

import java.util.ArrayList;

/**
 *
 * @author D.D
 */
public class PizzaOrder {

    private PizzaSize size;
    private ArrayList<Toppings> toppings = new ArrayList();
    private Drinks drinks;
    private int numPizzas;
    private int numDrinks;

    /**
     * No argument constructor to create a PizzaOrder
     */
    public PizzaOrder() {
    }

    /**
     * Three parameter constructor to create a PizzaOrder
     * @param size the size of the pizza from size enum
     * @param drinks the drinks chosen, from drinks enum
     * @param numPizzas the number of pizzas ordered
     * @param numDrinks the number of drinks ordered
     */
    public PizzaOrder(PizzaSize size, Drinks drinks,
            int numPizzas, int numDrinks) {
        this.size = size;
        this.drinks = drinks;
        this.numPizzas = numPizzas;
        this.numDrinks = numDrinks;
    }

    /**
     * Retrieves the size of the pizza
     * @return the pizza size
     */
    public PizzaSize getSize() {
        return size;
    }

    /**
     * Sets the size of the pizza
     * @param size the pizza size
     */
    public void setSize(PizzaSize size) {
        this.size = size;
    }

    /**
     * Retrieves the toppings added to the pizzas
     * @return toppings as an ArrayList
     */
    public ArrayList<Toppings> getToppings() {
        return toppings;
    }

    /**
     * Sets the toppings to be added to the ordered
     * @param toppings the toppings being added
     */
    public void setToppings(ArrayList<Toppings> toppings) {
        this.toppings = toppings;
    }

    /**
     * Retrieves the drinks in the order
     * @return drinks within the order
     */
    public Drinks getDrinks() {
        return drinks;
    }

    /**
     * sets the drinks that are to be added to the order
     * @param drinks the drinks to be added
     */
    public void setDrinks(Drinks drinks) {
        this.drinks = drinks;
    }

    /**
     * Retrieves the number of pizzas in the order
     * @return the number of pizzas as an int
     */
    public int getNumPizzas() {
        return numPizzas;
    }

    /**
     * Sets the number of pizzas for the order
     * @param numPizzas the number of pizzas as an int
     */
    public void setNumPizzas(int numPizzas) {
        if (numPizzas >= 0) {
            this.numPizzas = numPizzas;
        } else {
            throw new IllegalArgumentException("Error: Value must be positive");
        }
    }

    /**
     * Retrieves the number of drinks in the order
     * @return number of drinks in order as an int
     */
    public int getNumDrinks() {
        return numDrinks;
    }

    /**
     * Sets the number of drinks to be in the order
     * @param numDrinks number of drinks as an int
     */
    public void setNumDrinks(int numDrinks) {
        if (numDrinks >= 0) {
            this.numDrinks = numDrinks;
        } else {
            throw new IllegalArgumentException("Error: Value must be positive");
        }
    }

    /**
     * Calculates the total cost for the toppings in the order
     * @return the cost for the toppings as a double
     */
    public double toppingTotal() {
        double price = 0;
        for (int i = 0; i < toppings.size(); i++) {
            price += getNumPizzas() * toppings.get(i).getToppingPrice();
        }
        return price;
    }

    /**
     * Calculates the total cost for the drinks in the order
     * @return the cost for the drinks as a double
     */
    public double drinkTotal() {
        return numDrinks * drinks.getDrinkPrice();
    }
    
    /**
     * Calculates the total cost for the pizzas in the order
     * @return the cost for the pizzas as a double
     */
    public double pizzaTotal() {
        return numPizzas * size.getSizePrice();
    }
    
    /**
     * Calculates the subtotal for the order, includes toppings, drinks, pizzas.
     * @return the subtotal for the order as a double
     */
    public double subTotal() {
        double subtotal;
        if (size != null && drinks != null) {
            subtotal = toppingTotal() + drinkTotal() + pizzaTotal();
        } else if (drinks != null) {
            subtotal = drinkTotal();
        } else {
            subtotal = toppingTotal() + pizzaTotal();
        }
        return subtotal;
    }

    /**
     * Depending on the types of items in the order, a specific string
     * representation of the order will be returned
     * @return a formatted String displaying the items ordered and cost
     */
    @Override
    public String toString() {
        String msg = "";

        if (size != null && drinks != null) {

            msg += String.format("%-25s%5.2f%n   %d %s%n", "Pizza:",
                    pizzaTotal(), numPizzas, size.toString());

            msg += String.format("%-25s%5.2f%n", "Toppings:", toppingTotal());
            for (Toppings t : toppings) {
                msg += String.format("   %d %s%n", numPizzas, t.toString());
            }

            msg += String.format("%-25s%5.2f%n   %d %s%n", "Drinks:", 
                    drinkTotal(), numDrinks, drinks.toString());

        } else if (drinks != null) {

            msg += String.format("%-25s%5.2f%n   %d %s%n", "Drinks:", 
                    drinkTotal(), numDrinks, drinks.toString());

        } else {

            msg += String.format("%-25s%5.2f%n   %d %s%n", "Pizza:",
                    pizzaTotal(), numPizzas, size.toString());

            msg += String.format("%-25s%5.2f%n", "Toppings:", toppingTotal());
            for (Toppings t : toppings) {
                msg += String.format("   %d %s%n", numPizzas, t.toString());
            }
        }
        return msg;
    }

}
