package controller;

import au.edu.uts.ap.javafx.Controller;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import model.Ingredient;


public class AddEditIngredientController extends Controller<Ingredient>  {

    //Name textfield
    @FXML
    private TextField nameTf;

    //Amount textfield
    @FXML
    private TextField amountTf;

    @FXML
    public void initialize(){
        //Set the text fields default text to the ingredients name and amount  
        nameTf.setText(getIngredient().getName());
        amountTf.setText(String.valueOf(getIngredient().getAmount()));
    }

    @FXML
    public void exit() {
        //Update the name and amount of the ingredient
        getIngredient().setIngredientAmount(Integer.parseInt(amountTf.getText()));
        getIngredient().setIngredientName(nameTf.getText());
        //Close stage
        stage.close();
    }

    //Return the model
    public Ingredient getIngredient(){
        return this.model;
    }
    
}
