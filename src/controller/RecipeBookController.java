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
import model.Recipe;
import model.RecipeBook;

public class RecipeBookController extends Controller<RecipeBook> {

    //Exit button
    @FXML
    private Button exitButton;

    //Recipes tableview
    @FXML
    private TableView<Recipe> recipesTV;

    @FXML 
    private void deleteRecipe(){
        //Get selected recipe
        Recipe recipeToDelete = recipesTV.getSelectionModel().getSelectedItem();
        //Remove recipe from recipes list
        getRecipeBook().getRecipes().remove(recipeToDelete);
        //Delete recipe file
        getRecipeBook().deleteRecipeFile(recipeToDelete);
    }
    
    @FXML
    private void addRecipe(){
        //Create new stage to add the recipe
        try {
            //Create new recipe
            Recipe newRecipe = new Recipe();
            //Add it to recipe list
            getRecipeBook().getRecipes().add(newRecipe);
            Stage stage = new Stage();
            stage.getIcons().add(new Image("/view/images/prepIcon.jpeg"));
            stage.setX(ViewLoader.X);
            stage.setY(ViewLoader.Y);
            ViewLoader.showStage(newRecipe, "/view/AddEditRecipe.fxml", "Add Recipe", stage);
        //Error handling
        } catch (IOException ex) {
            Logger.getLogger(PrepPlannerController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void editRecipe(){
        //Create new stage to edit recipe
        try {
            //Get selected recipe
            Recipe selectedRecipe = recipesTV.getSelectionModel().getSelectedItem();
            Stage stage = new Stage();
            stage.getIcons().add(new Image("/view/images/prepIcon.jpeg"));
            stage.setX(ViewLoader.X);
            stage.setY(ViewLoader.Y);
            ViewLoader.showStage(selectedRecipe, "/view/AddEditRecipe.fxml", "Add Recipe", stage);
        //Error handling
        } catch (IOException ex) {
            Logger.getLogger(PrepPlannerController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    public void exit() {
        //Update recipes and close the stage
        getRecipeBook().updateRecipes();
        stage.close();
    }

    //Return the model
    public RecipeBook getRecipeBook(){
        return this.model;
    }
}
