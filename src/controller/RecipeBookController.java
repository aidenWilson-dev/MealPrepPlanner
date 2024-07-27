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

    @FXML
    private Button exitButton;

    @FXML
    private TableView<Recipe> recipesTV;

    @FXML 
    private void deleteRecipe(){
        getRecipeBook().getRecipes().remove(recipesTV.getSelectionModel().getSelectedItem());
    }
    
    @FXML
    private void addRecipe(){
        try {
            Recipe newRecipe = new Recipe();
            getRecipeBook().getRecipes().add(newRecipe);
            Stage stage = new Stage();
            stage.getIcons().add(new Image("/view/images/prepIcon.jpeg"));
            stage.setX(ViewLoader.X);
            stage.setY(ViewLoader.Y);
            ViewLoader.showStage(newRecipe, "/view/addEditRecipe.fxml", "Add Recipe", stage);
        } catch (IOException ex) {
            Logger.getLogger(PrepPlannerController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void editRecipe(){
        try {
            Stage stage = new Stage();
            stage.getIcons().add(new Image("/view/images/prepIcon.jpeg"));
            stage.setX(ViewLoader.X);
            stage.setY(ViewLoader.Y);
            ViewLoader.showStage(recipesTV.getSelectionModel().getSelectedItem(), "/view/addEditRecipe.fxml", "Add Recipe", stage);
        } catch (IOException ex) {
            Logger.getLogger(PrepPlannerController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    public void exit() {
        getRecipeBook().updateRecipes();
        stage.close();
    }

    public RecipeBook getRecipeBook(){
        return this.model;
    }
}
