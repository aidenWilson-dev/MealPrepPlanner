package model;

import javafx.beans.property.*;

public class Ingredient {
    
    //Observable property for ingredient name
    private StringProperty ingredientName = new SimpleStringProperty();
    public final String getName() { return ingredientName.get(); }
    public ReadOnlyStringProperty ingredientNameProperty() { return ingredientName; }

    //Observable property for ingredient amount
    private IntegerProperty amount = new SimpleIntegerProperty();
    public final int getAmount() { return amount.get(); }
    public ReadOnlyIntegerProperty amountProperty() { return amount; }

    //Observable property for the type of the amount (grams cups etc)
    private StringProperty amountMeasurement = new SimpleStringProperty();
    public final String getAmountMeasurement() {return amountMeasurement.get(); }
    public ReadOnlyStringProperty amountMeasurementProperty() { return amountMeasurement; }

    //Constructor
    public Ingredient(String name, Integer amt, String measurement){
        this.ingredientName.set(name);
        this.amount.set(amt);
        this.amountMeasurement.set(measurement);
    }

    //Setter for ingredient name
    public void setIngredientName(String newName){
        this.ingredientName.set(newName);
    }

    //Setter for ingredient amount
    public void setIngredientAmount(int newAmount){
        this.amount.set(newAmount);
    }

    //Setter for ingredient amount type 
    public void setIngredientMeasurement(String newType){
        this.amountMeasurement.set(newType);
    }
    
}

