package controller;

import au.edu.uts.ap.javafx.Controller;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import model.WeekBreakdown;

public class WeekBreakdownController extends Controller<WeekBreakdown> {

    //Name label
    @FXML
    private Label nameLabel;

    //Called when the fxml file is loaded before it is displayed
    @FXML
    public void initialize(){
        String labelText = String.format("%s - For The Week", getWeekBreakdown().getRecipeName());
        nameLabel.setText(labelText);
    }

    //Close buttone
    @FXML
    public void exit(){
        stage.close();
    }

    //Return the model
    public WeekBreakdown getWeekBreakdown(){
        return this.model;
    }
    
}
