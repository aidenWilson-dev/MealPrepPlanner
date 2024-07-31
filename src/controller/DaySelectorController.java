package controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import model.MealPlanner;

public class DaySelectorController extends Controller<MealPlanner>{

    final int MEALS_IN_WEEK = 14;

    //Array of all checkboxes to make iterating over it easier 
    private CheckBox[] checkBoxes = new CheckBox[MEALS_IN_WEEK];

    //All meal checkboxes
    // @FXML
    // private CheckBox monBreakfast;
    @FXML
    private CheckBox monLunch;
    @FXML 
    private CheckBox monDinner;

    // @FXML
    // private CheckBox tueBreakfast;
    @FXML
    private CheckBox tueLunch;
    @FXML 
    private CheckBox tueDinner;

    // @FXML
    // private CheckBox wedBreakfast;
    @FXML
    private CheckBox wedLunch;
    @FXML 
    private CheckBox wedDinner;

    // @FXML
    // private CheckBox thuBreakfast;
    @FXML
    private CheckBox thuLunch;
    @FXML 
    private CheckBox thuDinner;

    // @FXML
    // private CheckBox friBreakfast;
    @FXML
    private CheckBox friLunch;
    @FXML 
    private CheckBox friDinner;

    // @FXML
    // private CheckBox satBreakfast;
    @FXML
    private CheckBox satLunch;
    @FXML 
    private CheckBox satDinner;

    // @FXML
    // private CheckBox sunBreakfast;
    @FXML
    private CheckBox sunLunch;
    @FXML 
    private CheckBox sunDinner;


    @FXML
    public void exit(){
        //Close stage
        stage.close();
    }

    @FXML
    public void onContinue(){
        //Count the amount of selected checkboxes 
        //NumMeals is the amount of meals NOT needed
        int numMeals = 0;
        for (CheckBox checkBox : checkBoxes) {
            if (checkBox.isSelected()) {
                numMeals++;
            }
        }
        if (numMeals > 0) {
            //Create new stage to choose recipe
            try {
                Stage stage = new Stage();
                stage.getIcons().add(new Image("/view/images/prepIcon.jpeg"));
                stage.setX(ViewLoader.X);
                stage.setY(ViewLoader.Y);
                //NumMeals is the amount of meals NOT needed, to get the amount needed we subtract 
                //that number from 14
                getMealPlanner().setMealsNumber(14-numMeals);
                ViewLoader.showStage(getMealPlanner(), "/view/MealSelector.fxml", "Select Meal", stage);
            //Error handling
            } catch (IOException ex) {
                Logger.getLogger(PrepPlannerController.class.getName()).log(Level.SEVERE, null, ex);
            }   
        }   
    }

    @FXML 
    public void initialize(){
        //Add all the checkboxes to the checkboxes array
        // checkBoxes[0] = monBreakfast;
        checkBoxes[0] = monLunch;
        checkBoxes[1] = monDinner;

        // checkBoxes[3] = tueBreakfast;
        checkBoxes[2] = tueLunch;
        checkBoxes[3] = tueDinner;

        // checkBoxes[6] = wedBreakfast;
        checkBoxes[4] = wedLunch;
        checkBoxes[5] = wedDinner;

        // checkBoxes[9] = thuBreakfast;
        checkBoxes[6] = thuLunch;
        checkBoxes[7] = thuDinner;

        // checkBoxes[12] = friBreakfast;
        checkBoxes[8] = friLunch;
        checkBoxes[9] = friDinner;

        // checkBoxes[15] = satBreakfast;
        checkBoxes[10] = satLunch;
        checkBoxes[11] = satDinner;

        // checkBoxes[18] = sunBreakfast;
        checkBoxes[12] = sunLunch;
        checkBoxes[13] = sunDinner;
        
    }

    //Get MealPlanner
    public MealPlanner getMealPlanner(){
        return this.model;
    }
    
}
