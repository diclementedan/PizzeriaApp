/*
    Name:  Daniel Di Clemente
    Assignment:  Assignment 4
    Program: Pizzeria
    Date:  April 4, 2020
    
    Description:
    This program models a GUI to be used as a POS system in a pizzeria. It will
    provide the customer with options for pizza size/qty, toppings, drink
    choice/qty. It will inform the customer if the order is not valid. If it is 
    a valid order, the customer will have their order summary and total
    displayed to them.
*/

package diclemed;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author D.D
 */
public class Pizzeria extends Application{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Method to load the pane for the GUI
     * @param stage the window in which the scene is displayed
     * @throws Exception throws any checked exceptions
     */
    @Override
    public void start(Stage stage) throws Exception {
        Pane root = FXMLLoader.load(getClass().getResource("FXMLPizzeria.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Dan's Pizzeria");
        stage.setScene(scene);
        stage.show();
    }

}
