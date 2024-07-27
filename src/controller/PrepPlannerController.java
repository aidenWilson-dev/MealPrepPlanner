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
import model.RecipeBook;

public class PrepPlannerController extends Controller<PrepPlanner> {

    @FXML
    private Button exitButton;

    @FXML
    public void exit() {
        stage.close();
    }

    @FXML
    public void recipeBook(){
        try {
            Stage stage = new Stage();
            stage.getIcons().add(new Image("/view/images/prepIcon.jpeg"));
            stage.setX(ViewLoader.X);
            stage.setY(ViewLoader.Y);
            ViewLoader.showStage(new RecipeBook(), "/view/RecipeBook.fxml", "Recipe Book", stage);
        } catch (IOException ex) {
            Logger.getLogger(PrepPlannerController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public PrepPlanner getPrepPlanner(){
        return this.model;
    }
}
