package controller;

import au.edu.uts.ap.javafx.ViewLoader;
import au.edu.uts.ap.javafx.Controller;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.stage.*;
import javafx.scene.image.Image;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import model.Recipe;
import model.RecipeBook;

public class RecipeBookController extends Controller<RecipeBook> {

    @FXML
    private Button exitButton;

    //@FXML
    //private ListView<Recipe> recipesLV;

    @FXML
    private TableView<Recipe> recipesTV;

    @FXML 
    private void deleteRecipe(){
        getRecipeBook().getRecipes().remove(recipesTV.getSelectionModel().getSelectedItem());
    }
    
    @FXML
    private void addRecipe(){
        try {
            Stage stage = new Stage();
            stage.getIcons().add(new Image("/view/images/prepIcon.jpeg"));
            stage.setX(ViewLoader.X);
            stage.setY(ViewLoader.Y);
            ViewLoader.showStage(new Recipe(), "/view/addEditRecipe.fxml", "Add Recipe", stage);
        } catch (IOException ex) {
            Logger.getLogger(PrepPlannerController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void editRecipe(){
        //Recipe currRecipe = recipesLV.getSelectionModel().getSelectedItem();
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
