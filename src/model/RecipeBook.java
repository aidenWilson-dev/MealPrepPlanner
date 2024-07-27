package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOError;
import java.io.IOException;
import java.util.Scanner;

public class RecipeBook {

    private ObservableList<Recipe> recipes = FXCollections.observableArrayList();

    public RecipeBook(){
        LoadRecipes();
    }

    public ObservableList<Recipe> getRecipes() {
        return recipes;
    }

    public void deleteRecipeFile(Recipe recipeToRemove){
        //Load Directory
        File recipeFolder = new File("src/model/Recipes");
        if (recipeFolder.isDirectory()) {
            String recipeFileName = getRecipeFileName(recipeToRemove);
            for (File file : recipeFolder.listFiles()) {
                if (recipeFileName.equals(file.getName())) {
                    file.delete();
                }
            }
        }
    }
    
    public static String getRecipeFileName(Recipe recipe){
        return recipe.getName().replace(" ", "-").concat(".txt");
    }

    public static String getRecipeFileName(String recipeName){
        return recipeName.replace(" ", "-").concat(".txt");
    }

    public static void updateRecipeFileName(String oldName, String newName){
        File recipeFolder = new File("src/model/Recipes");
        if (recipeFolder.isDirectory()) {
            for (File file : recipeFolder.listFiles()) {
                if (file.getName().equals(getRecipeFileName(oldName))) {
                    File newRecipeFile = new File(String.format("%s/%s", recipeFolder, newName));
                    file.delete();
                }
            }
        }
    }

    public void updateRecipes(){
        //Load Directory
        File recipeFolder = new File("src/model/Recipes");
        if (recipeFolder.isDirectory()) {
            for (Recipe recipe : recipes) {
                boolean fileFound = false;
                String recipeFileName = getRecipeFileName(recipe);
                File correspondingFile = null;
                for (File file : recipeFolder.listFiles()) {
                    if (recipeFileName.equals(file.getName())) {
                        fileFound = true;
                        correspondingFile = file;
                    }
                }
                if (fileFound) {
                    writeToFile(recipe, correspondingFile);
                }else {
                    try {
                        File newRecipeFile = new File(String.format("%s/%s", recipeFolder, recipeFileName));
                        if (newRecipeFile.createNewFile()) {
                            writeToFile(recipe, newRecipeFile);
                        }else{
                            System.err.println("Recipe file already exists");
                        }
                    } catch (IOException e) {
                        System.err.println("Error occured when updating recipe");
                    }
                }
            }    
        }
    }

    public void writeToFile(Recipe recipe, File correspondingFile){
        try {
            String dump = recipe.ingredientDump();
            FileWriter writer = new FileWriter(correspondingFile);
            writer.write(dump);
            writer.close();            
        } catch (IOException e) {
            System.err.println("Error occured when updating recipe");
        }
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
