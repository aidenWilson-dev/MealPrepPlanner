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
import model.RecipeBook;

public class AddEditRecipeController extends Controller<Recipe>  {

    //Name textfield
    @FXML
    private TextField nameTf;

    //Ingredients tableview
    @FXML
    private TableView<Ingredient> ingredientsTV;

    //Set name textfield text to the name of the recipe
    @FXML
    public void initialize(){
        nameTf.setText(getRecipe().getName());
    }

    @FXML
    public void exit() {
        //Check to see if name of recipe has been changed
        String oldName = getRecipe().getName();
        String newName = nameTf.getText();
        if (!(oldName.equals(newName))) {
            //Update name of recipe file and recipe object
            RecipeBook.updateRecipeFileName(oldName, newName);
            getRecipe().setName(nameTf.getText());
        }
        //close the stage
        stage.close();
    }

    @FXML
    public void onAdd(){
        try {
            //Create a new ingredient 
            Ingredient newIngredient = new Ingredient("New Ingredient", 0);
            //Add new ingredient
            getRecipe().getIngredients().add(newIngredient);
            //Create new menu to edit newly created ingredient 
            Stage stage = new Stage();
            stage.getIcons().add(new Image("/view/images/prepIcon.jpeg"));
            stage.setX(ViewLoader.X);
            stage.setY(ViewLoader.Y);
            ViewLoader.showStage(newIngredient, "/view/AddEditIngredient.fxml", "Add Ingredient", stage);
        //Error handling
        } catch (IOException ex) {
            Logger.getLogger(PrepPlannerController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    public void onDelete(){
        //Delete the ingredient selected in the tableview from the ingredients list
        getRecipe().getIngredients().remove(ingredientsTV.getSelectionModel().getSelectedItem());
    }

    @FXML
    public void onEdit(){
        //Get the selected ingredient 
        Ingredient selectedIngredient = ingredientsTV.getSelectionModel().getSelectedItem();
        if (selectedIngredient != null) {
            try {
                //Create new stage to edit the ingredient 
                Stage stage = new Stage();
                stage.getIcons().add(new Image("/view/images/prepIcon.jpeg"));
                stage.setX(ViewLoader.X);
                stage.setY(ViewLoader.Y);
                ViewLoader.showStage(selectedIngredient, "/view/AddEditIngredient.fxml", "Edit Ingredient", stage);
            //Error handling
            } catch (IOException ex) {
                Logger.getLogger(PrepPlannerController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    //Return model
    public Recipe getRecipe(){
        return this.model;
    }
    
}
