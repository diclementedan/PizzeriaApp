/*
    PizzeriaController.java
    Author: Daniel Di Clemente
    Date: April 4, 2020

    Description
    This class is the controller for FXMLPizzeria.fxml. It handles any
    interactions and events that take place once the pizzeria GUI has been
    loaded. It also performs various validations to ensure the customer is 
    placing an appropriate order. Final calculations for the order total is also
    performed here.
 */
package diclemed;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author dicle
 */
public class PizzeriaController implements Initializable {

    @FXML
    private Menu mnuFile;
    @FXML
    private MenuItem mnuExit;
    @FXML
    private ToggleGroup grpPizzaSize;
    @FXML
    private ToggleGroup grpDrinks;
    @FXML
    private Label lblHeader;
    @FXML
    private TextField txtPizzaQty;
    @FXML
    private Label lblToppings;
    @FXML
    private CheckBox chkCheese;
    @FXML
    private CheckBox chkPepp;
    @FXML
    private CheckBox chkMush;
    @FXML
    private CheckBox chkOlive;
    @FXML
    private Label lblDrinks;
    @FXML
    private TextField txtDrinkQty;
    @FXML
    private RadioButton rdoSmall;
    @FXML
    private RadioButton rdoMed;
    @FXML
    private RadioButton rdoLrg;
    @FXML
    private RadioButton rdoCoke;
    @FXML
    private RadioButton rdoJuice;
    @FXML
    private RadioButton rdoChocMilk;
    @FXML
    private Label lblReceiptTitle;
    @FXML
    private TextArea txaReceipt;
    @FXML
    private Button btnOk;
    @FXML
    private Button btnCancel;

    // constant for the tax rate to be applied to orders
    private final double TAX_RATE = 0.13;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        mnuExit.setOnAction(t -> buttonAction(t));
        btnOk.setOnAction(t -> buttonAction(t));
        btnCancel.setOnAction(t -> buttonAction(t));
    }

    @FXML
    private void buttonAction(ActionEvent event) {
        if (event.getSource() == mnuExit) {
            System.exit(0);
        }
        if (event.getSource() == btnCancel) {
            grpPizzaSize.selectToggle(null);
            txtPizzaQty.clear();
            chkCheese.setSelected(false);
            chkPepp.setSelected(false);
            chkMush.setSelected(false);
            chkOlive.setSelected(false);
            grpDrinks.selectToggle(null);
            txtDrinkQty.clear();
            txaReceipt.clear();
        }
        if (event.getSource() == btnOk) {
            btnOk(event);
        }
    }

    /**
     * Helper method to handle the tasks needed to be performed when the "OK"
     * button is selected.
     * @param event the actionEvent that took place
     */
    private void btnOk(ActionEvent event) {
        PizzaOrder order1 = new PizzaOrder();
        boolean validOrder = true;
        boolean pizzaSelected, drinkSelected;
        String pizzaSize, drinkChoice;

        // get & set value from pizza options
        if (rdoSmall.isSelected()) {
            pizzaSelected = true;
            order1.setSize(PizzaSize.SMALL);
        } else if (rdoMed.isSelected()) {
            pizzaSelected = true;
            order1.setSize(PizzaSize.MEDIUM);
        } else if (rdoLrg.isSelected()) {
            pizzaSelected = true;
            order1.setSize(PizzaSize.LARGE);
        } else {
            pizzaSelected = false;
        }

        // get & set value from drink options
        if (rdoCoke.isSelected()) {
            drinkSelected = true;
            order1.setDrinks(Drinks.COKE);
        } else if (rdoJuice.isSelected()) {
            drinkSelected = true;
            order1.setDrinks(Drinks.JUICE);
        } else if (rdoChocMilk.isSelected()) {
            drinkSelected = true;
            order1.setDrinks(Drinks.CHOCOLATE_MILK);
        } else {
            drinkSelected = false;
        }

        try {
            if (drinkSelected) {
                order1.setNumDrinks(Integer.parseInt(txtDrinkQty.getText()));
            } else {
                order1.setNumDrinks(0);
            }
            if (pizzaSelected) {
                order1.setNumPizzas(Integer.parseInt(txtPizzaQty.getText()));
            } else {
                order1.setNumPizzas(0);
            }
        } catch (NumberFormatException e) {
            validOrder = false;
            txaReceipt.setText("Error: Only numbers can be entered!");
        } catch (IllegalArgumentException e) {
            validOrder = false;
            txaReceipt.setText(e.getMessage());
        }

        if (txtDrinkQty.getText().equals("") && txtPizzaQty.getText().equals("")) {
            order1.setSize(PizzaSize.SMALL);
            order1.setDrinks(Drinks.COKE);
            txaReceipt.setText("Error: You must select at least one pizza or "
                    + "drink");
            validOrder = false;
        }
        
        if (chkMush.isSelected()) {
            order1.getToppings().add(Toppings.MUSHROOMS);
        }
        if (chkPepp.isSelected()) {
            order1.getToppings().add(Toppings.PEPPERONI);
        }
        if (chkOlive.isSelected()) {
            order1.getToppings().add(Toppings.OLIVES);
        }
        if (chkCheese.isSelected()) {
            order1.getToppings().add(Toppings.CHEESE);
        }

        if (validOrder) {
            double tax = TAX_RATE * order1.subTotal();
            double total = tax + order1.subTotal();

            txaReceipt.setText(order1.toString());
            txaReceipt.appendText(String.format("%31s%n%-25s%5.2f%n%-25s%5.2f"
                    + "%n%-25s%5.2f", "===============================", 
                    "Subtotal:", order1.subTotal(), "HST:", tax, "Total:", 
                    total));
        }
    }
}
