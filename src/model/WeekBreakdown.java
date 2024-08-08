package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class WeekBreakdown {

    //Recipe and amount of days 
    private Recipe recipe;
    private int daysSelected;

    //List of ingredients summed up
    private ObservableList<Ingredient> ingredientSum = FXCollections.observableArrayList();


    //set the recipe the user selected 
    public WeekBreakdown(int days, Recipe selectedRecipe){
        recipe = selectedRecipe;
        daysSelected = days;
        for (Ingredient ingredient : recipe.getIngredients()) {
            int totalAmount = (ingredient.getAmount() * daysSelected);
            ingredientSum.add(new Ingredient(ingredient.getName(), totalAmount, ingredient.getAmountMeasurement()));      
        }
    }

    //Get Recipe name
    public String getRecipeName(){
        return recipe.getName();
    }

    //Get amount of days which meals are needed
    public int getDays(){
        return daysSelected;
    }

    //Return ingredients list
    public ObservableList<Ingredient> getIngredientSum() {
        return ingredientSum;
    }


    
}
