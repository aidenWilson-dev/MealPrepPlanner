package controller;

import au.edu.uts.ap.javafx.Controller;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import model.Ingredient;


public class addEditIngredientController extends Controller<Ingredient>  {

    @FXML
    private TextField nameTf;

    @FXML
    private TextField amountTf;

    @FXML
    public void initialize(){
        nameTf.setText(getIngredient().getName());
        amountTf.setText(String.valueOf(getIngredient().getAmount()));
    }

    @FXML
    public void exit() {
        getIngredient().setIngredientAmount(Integer.parseInt(amountTf.getText()));
        getIngredient().setIngredientName(nameTf.getText());
        stage.close();
    }

    public Ingredient getIngredient(){
        return this.model;
    }
    
}
