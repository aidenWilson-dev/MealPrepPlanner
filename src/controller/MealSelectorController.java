package controller;

import au.edu.uts.ap.javafx.Controller;
import model.MealPlanner;

public class MealSelectorController extends Controller<MealPlanner> {

    public void onContinue(){

    }

    public void exit(){
        stage.close();
    }
    
    public MealPlanner getMealPlanner(){
        return this.model;
    }
    
}
