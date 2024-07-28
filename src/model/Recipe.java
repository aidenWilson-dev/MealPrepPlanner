package model;


import javafx.beans.property.ReadOnlyStringProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Recipe {

    //List of ingredients
    private ObservableList<Ingredient> ingredients = FXCollections.observableArrayList();

    //Observeable property for the recipe name
    private StringProperty recipeName = new SimpleStringProperty();
    public final String getName() { return recipeName.get(); }
    public ReadOnlyStringProperty recipeNameProperty() { return recipeName; }

    public Recipe(){
        //Default recipe name
        recipeName.set("Recipe Name");
    }

    //Add ingredient to recipe
    public void addIngredient(String name, Integer amount){
        Ingredient ingredient = new Ingredient(name, amount);
        ingredients.add(ingredient);
    }

    //Set name of recipe
    public void setName(String name){
        this.recipeName.set(name);
    }

    //Get file dump of ingredients for recipe file
    public String ingredientDump(){
        StringBuilder dump = new StringBuilder();
        //For each ingredient, add a new line to the dump in the form
        //Ingredient:Amount
        for (Ingredient ingredient : ingredients) {
            StringBuilder individualDump = new StringBuilder();
            individualDump.append(String.format("%s:%d\n", ingredient.getName(), ingredient.getAmount()));
            dump.append(individualDump);
        }
        //Return the dump
        return dump.toString();
    }

    //toString method to return name of recipe for table view
    @Override
    public String toString() {
        return recipeName.get();
    }

    //Return ingredients list
    public ObservableList<Ingredient> getIngredients() {
        return ingredients;
    }
    
}
