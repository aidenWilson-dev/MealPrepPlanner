package controller;

import au.edu.uts.ap.javafx.ViewLoader;
import au.edu.uts.ap.javafx.Controller;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.stage.*;
import javafx.scene.image.Image;
import javafx.scene.control.*;
import model.MealPlanner;
import model.PrepPlanner;
import model.RecipeBook;

public class PrepPlannerController extends Controller<PrepPlanner> {

    //Exit button
    @FXML
    private Button exitButton;

    //Recipe book and meal Planner
    private RecipeBook recipeBook;
    private MealPlanner mealPlanner;

    @FXML
    public void exit() {
        //Close the stage
        stage.close();
    }

    @FXML
    public void initialize(){
        //Load Recipe book 
        recipeBook = new RecipeBook();
        mealPlanner = new MealPlanner();
    }

    @FXML
    public void recipeBook(){
        //Create a stage that shows all the recipes
        try {
            Stage stage = new Stage();
            stage.getIcons().add(new Image("/view/images/prepIcon.jpeg"));
            stage.setX(ViewLoader.X);
            stage.setY(ViewLoader.Y);
            ViewLoader.showStage(recipeBook, "/view/RecipeBook.fxml", "Recipe Book", stage);
        //Error handling
        } catch (IOException ex) {
            Logger.getLogger(PrepPlannerController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    public void mealPlanner(){
        //Create a stage to enter the mealPlanner
        try {
            Stage stage = new Stage();
            stage.getIcons().add(new Image("/view/images/prepIcon.jpeg"));
            stage.setX(ViewLoader.X);
            stage.setY(ViewLoader.Y);
            //Set the recipe list after if its been modified in the recipe book
            mealPlanner.setRecipeList(recipeBook.getRecipes());
            ViewLoader.showStage(mealPlanner, "/view/DaySelector.fxml", "Day Selector", stage);
        //Error handling
        } catch (IOException ex) {
            Logger.getLogger(PrepPlannerController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //return the model
    public PrepPlanner getPrepPlanner(){
        return this.model;
    }


}