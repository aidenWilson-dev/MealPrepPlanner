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
import model.RecipeBookModel;

public class RecipeBookController extends Controller<RecipeBookModel> {

    @FXML
    private Button exitButton;

    @FXML
    public void exit() {
        Platform.exit();
    }

    public RecipeBookModel getRecipeBook(){
        return this.model;
    }
}
