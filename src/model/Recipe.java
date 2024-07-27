package model;


import javafx.beans.property.ReadOnlyStringProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Recipe {
    private ObservableList<Ingredient> ingredients = FXCollections.observableArrayList();

    private StringProperty recipeName = new SimpleStringProperty();
    public final String getName() { return recipeName.get(); }
    public ReadOnlyStringProperty recipeNameProperty() { return recipeName; }

    public Recipe(){
        recipeName.set("Recipe Name");
    }

    public void addIngredient(String name, Integer amount){
        Ingredient ingredient = new Ingredient(name, amount);
        ingredients.add(ingredient);
    }

    public void setName(String name){
        this.recipeName.set(name);
    }

    @Override
    public String toString() {
        return recipeName.get();
    }

    public ObservableList<Ingredient> getIngredients() {
        return ingredients;
    }
    
}
