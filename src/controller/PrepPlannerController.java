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
import model.PrepPlannerModel;

public class PrepPlannerController extends Controller<PrepPlannerModel> {

    @FXML
    private Button exitButton;

    @FXML
    public void exit() {
        Platform.exit();
    }

    public PrepPlannerModel getPrepPlanner(){
        return this.model;
    }
}
