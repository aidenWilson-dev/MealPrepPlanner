package model;

import java.text.*;
import javafx.beans.property.*;
import javafx.beans.binding.*;
import java.util.*;

public class Ingredient {
    

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

}
