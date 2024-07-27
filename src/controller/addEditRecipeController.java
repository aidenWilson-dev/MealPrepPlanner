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
import model.Ingredient;
import model.Recipe;

public class addEditRecipeController extends Controller<Recipe>  {

    @FXML
    private TextField nameTf;

    @FXML
    private TableView<Ingredient> ingredientsTV;

    @FXML
    public void initialize(){
        nameTf.setText(getRecipe().getName());
    }

    @FXML
    public void exit() {
        getRecipe().setName(nameTf.getText());
        stage.close();
    }

    @FXML
    public void onAdd(){
        try {
            Ingredient newIngredient = new Ingredient("New Ingredient", 0);
            getRecipe().getIngredients().add(newIngredient);
            Stage stage = new Stage();
            stage.getIcons().add(new Image("/view/images/prepIcon.jpeg"));
            stage.setX(ViewLoader.X);
            stage.setY(ViewLoader.Y);
            ViewLoader.showStage(newIngredient, "/view/addEditIngredient.fxml", "Add Ingredient", stage);
        } catch (IOException ex) {
            Logger.getLogger(PrepPlannerController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    public void onDelete(){
        getRecipe().getIngredients().remove(ingredientsTV.getSelectionModel().getSelectedItem());
    }

    @FXML
    public void onEdit(){
        try {
            Stage stage = new Stage();
            stage.getIcons().add(new Image("/view/images/prepIcon.jpeg"));
            stage.setX(ViewLoader.X);
            stage.setY(ViewLoader.Y);
            ViewLoader.showStage(ingredientsTV.getSelectionModel().getSelectedItem(), "/view/addEditIngredient.fxml", "Edit Ingredient", stage);
        } catch (IOException ex) {
            Logger.getLogger(PrepPlannerController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Recipe getRecipe(){
        return this.model;
    }
    
}
