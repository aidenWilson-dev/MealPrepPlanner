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

    //Measurement radio buttons
    @FXML
    private RadioButton cupButton;

    @FXML
    private RadioButton tableButton;

    @FXML
    private RadioButton teaButton;

    @FXML
    private RadioButton gramButton;


    //Toggle group for radio buttons
    private ToggleGroup measurementToggleGroup;

    @FXML
    public void initialize(){
        //Create toggle group and add the buttons
        measurementToggleGroup = new ToggleGroup();
        cupButton.setToggleGroup(measurementToggleGroup);
        tableButton.setToggleGroup(measurementToggleGroup);
        teaButton.setToggleGroup(measurementToggleGroup);   
        gramButton.setToggleGroup(measurementToggleGroup);
        //Set the text fields default text to the ingredients name and amount  
        nameTf.setText(getIngredient().getName());
        amountTf.setText(String.valueOf(getIngredient().getAmount()));
        //select the radio button that corresponds to the ingredient measurement type
        switch (getIngredient().getAmountMeasurement()) {
            case "Cups":
                measurementToggleGroup.selectToggle(cupButton);
                break;
            case "Tbsp":
                measurementToggleGroup.selectToggle(tableButton);
                break;
            case "Tsp":
                measurementToggleGroup.selectToggle(teaButton);
                break;
            case "Grams":
                measurementToggleGroup.selectToggle(gramButton);
                break;        
            default:
                break;
        }   
    }

    @FXML
    public void exit() {
        //Update the name and amount of the ingredient
        getIngredient().setIngredientAmount(Integer.parseInt(amountTf.getText()));
        getIngredient().setIngredientName(nameTf.getText());
        RadioButton selectedRadioButton = (RadioButton) measurementToggleGroup.getSelectedToggle();
        getIngredient().setIngredientMeasurement(selectedRadioButton.getText());
        stage.close();
    }

    //Return the model
    public Ingredient getIngredient(){
        return this.model;
    }
    
}
