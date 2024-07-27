package controller;

import au.edu.uts.ap.javafx.ViewLoader;
import au.edu.uts.ap.javafx.Controller;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.stage.*;
import javafx.scene.image.Image;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import model.PrepPlanner;
import model.Recipe;
import model.RecipeBook;

public class addEditRecipeController extends Controller<Recipe>  {

    @FXML
    private TextField nameTf;

    @FXML
    public void initialize(){
        nameTf.setText(getRecipe().getName());
    }

    @FXML
    public void exit() {
        getRecipe().setName(nameTf.getText());
        stage.close();
    }

    public Recipe getRecipe(){
        return this.model;
    }
    
}
