package model;

import javafx.collections.ObservableList;

public class MealPlanner {

    //Final recipe list
    private ObservableList<Recipe> recipeList;

    //Amount of meals for the week
    private int mealsNumber;

    //Recipe List setter
    public void setRecipeList(ObservableList<Recipe> rl){
        recipeList = rl;
    }
    
    //mealsNumber setter
    public void setMealsNumber(int num){
        mealsNumber = num;
    }

    //Return recipe list, used to pass through to the day planner
    public ObservableList<Recipe> getRecipeList(){
        return recipeList;
    }
    
}
