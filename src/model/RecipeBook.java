package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class RecipeBook {

    private ObservableList<Recipe> recipes = FXCollections.observableArrayList();

    public RecipeBook(){
        LoadRecipes();
    }

    public ObservableList<Recipe> getRecipes() {
        return recipes;
    }

    public void updateRecipes(){
        
    }

    public void LoadRecipes(){
        //Load Directory
        File recipeFolder = new File("src/model/Recipes");
        if (recipeFolder.isDirectory()) {
            File[] recipeFileList = recipeFolder.listFiles();
            if (recipeFileList != null) {
                for (File recipeFile : recipeFileList) {
                    try {
                        Recipe currRecipe = new Recipe();
                        Scanner fileScanner = new Scanner(recipeFile);
                        while (fileScanner.hasNextLine()) {
                            String line = fileScanner.nextLine();
                            String[] parts = line.split(":");
                            currRecipe.addIngredient(parts[0], Integer.parseInt(parts[1]));
                        }
                        String recipeName = recipeFile.getName().replace("-", " ").replace(".txt", "");
                        currRecipe.setName(recipeName);
                        recipes.add(currRecipe);
                        fileScanner.close();
                    } catch (FileNotFoundException e) {
                        System.err.println("Error occured when loaded recipes");
                    }
                }
            }
        }
    }
}
