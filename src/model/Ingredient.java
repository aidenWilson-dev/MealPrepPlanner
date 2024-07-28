package model;

import javafx.beans.property.*;

public class Ingredient {
    
    //Observable propertys for each field of an ingredient 
    private StringProperty ingredientName = new SimpleStringProperty();
    public final String getName() { return ingredientName.get(); }
    public ReadOnlyStringProperty ingredientNameProperty() { return ingredientName; }

    private IntegerProperty amountGrams = new SimpleIntegerProperty();
    public final int getAmount() { return amountGrams.get(); }
    public ReadOnlyIntegerProperty amountProperty() { return amountGrams; }

    public Ingredient(String name, Integer amt){
        this.ingredientName.set(name);
        this.amountGrams.set(amt);
    }

    //Setters for ingredient name and ingredient amount
    public void setIngredientName(String newName){
        this.ingredientName.set(newName);
    }

    public void setIngredientAmount(int newAmount){
        this.amountGrams.set(newAmount);
    }
}
