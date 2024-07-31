package controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import model.MealPlanner;
import model.Recipe;
import model.WeekBreakdown;

public class MealSelectorController extends Controller<MealPlanner> {

    //Recipe listView
    @FXML
    private ListView<Recipe> recipeLV;

    public void onContinue(){
        //Create a stage that shows all the needed ingredients
        try {
            Stage stage = new Stage();
            stage.getIcons().add(new Image("/view/images/prepIcon.jpeg"));
            stage.setX(ViewLoader.X);
            stage.setY(ViewLoader.Y);
            //Get requied number of meals and selected meals
            int reqMeals = getMealPlanner().getMealsNumber();
            Recipe selectedRecipe = recipeLV.getSelectionModel().getSelectedItem();
            ViewLoader.showStage(new WeekBreakdown(reqMeals, selectedRecipe), "/view/WeekBreakdown.fxml", "Week Breakdown", stage);
        //Error handling
        } catch (IOException ex) {
            Logger.getLogger(PrepPlannerController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void exit(){
        //close stage
        stage.close();
    }
    
    //get mealPlanner
    public MealPlanner getMealPlanner(){
        return this.model;
    }
    
}
