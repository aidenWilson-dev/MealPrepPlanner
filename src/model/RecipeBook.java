package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class RecipeBook {

    //List of recipes
    private ObservableList<Recipe> recipes = FXCollections.observableArrayList();

    //On creation of the model load all the saved recipes
    public RecipeBook(){
        LoadRecipes();
    }

    //Delete recipe file
    public void deleteRecipeFile(Recipe recipeToRemove){
        //Load Directory
        File recipeFolder = new File("src/model/Recipes");
        if (recipeFolder.isDirectory()) {
            //Get recipe file name
            String recipeFileName = getRecipeFileName(recipeToRemove);
            for (File file : recipeFolder.listFiles()) {
                //Find the file with the same name as the recipe
                if (recipeFileName.equals(file.getName())) {
                    //Delete it
                    file.delete();
                }
            }
        }
    }

    //Convert recipe name to appropriate file name
    public static String getRecipeFileName(Recipe recipe){
        return recipe.getName().replace(" ", "-").concat(".txt");
    }

    public static String getRecipeFileName(String recipeName){
        return recipeName.replace(" ", "-").concat(".txt");
    }
    
    //Convert file name to appropriate recipe name
    public static String getRecipeName(File recipeFile){
        return recipeFile.getName().replace("-", " ").replace(".txt", "");
    }

    //Update a recipes file name
    public static void updateRecipeFileName(String oldName, String newName){
        //Load Directory 
        File recipeFolder = new File("src/model/Recipes");
        if (recipeFolder.isDirectory()) {
            for (File file : recipeFolder.listFiles()) {
                //If the file is the same name as the old one
                if (file.getName().equals(getRecipeFileName(oldName))) {
                    //Create a new file with the the new name 
                    new File(String.format("%s/%s", recipeFolder, newName));
                    //Delete the old file
                    //The file contents can be discarded as its re-written when the page is closed
                    file.delete();
                }
            }
        }
    }

    //Updating a recipes contents
    public void updateRecipes(){
        //Load Directory
        File recipeFolder = new File("src/model/Recipes");
        if (recipeFolder.isDirectory()) {
            //For each recipe currently in the recipe list
            for (Recipe recipe : recipes) {
                //Flag to denote if the file has been found 
                boolean fileFound = false;
                //Convert recipe name into file name
                String recipeFileName = getRecipeFileName(recipe);
                //Make a field to store the correspodning file when/if found
                File correspondingFile = null;
                for (File file : recipeFolder.listFiles()) {
                    //If the file has the same name as the recipe, we have found the correct file
                    if (recipeFileName.equals(file.getName())) {
                        //Set flag and copy current file
                        fileFound = true;
                        correspondingFile = file;
                    }
                }
                //Write to file
                if (fileFound) {
                    writeToFile(recipe, correspondingFile);
                //If file not found
                }else {
                    try {
                        //Create new file and write to it, handling appropriate errors
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

    //Write recipe contents to file 
    public void writeToFile(Recipe recipe, File correspondingFile){
        try {
            //Get the file dump from the recipe object
            String dump = recipe.ingredientDump();
            //Create FileWriter and write to the file
            FileWriter writer = new FileWriter(correspondingFile);
            writer.write(dump);
            writer.close();      
        //Error handling      
        } catch (IOException e) {
            System.err.println("Error occured when updating recipe");
        }
    }

    //Load saved recipes
    public void LoadRecipes(){
        //Load Directory
        File recipeFolder = new File("src/model/Recipes");
        if (recipeFolder.isDirectory()) {
            //Load saved recipe files 
            File[] recipeFileList = recipeFolder.listFiles();
            if (recipeFileList != null) {
                for (File recipeFile : recipeFileList) {
                    try {
                        //create a new recipe and file scanner object
                        Recipe currRecipe = new Recipe();
                        Scanner fileScanner = new Scanner(recipeFile);
                        //While there is still lines to be read in the recipe file
                        while (fileScanner.hasNextLine()) {
                            //Grab the line
                            String line = fileScanner.nextLine();
                            //Split it at the seperator 
                            String[] parts = line.split(":");
                            //Add the ingredient to the recipe 
                            currRecipe.addIngredient(parts[0], Integer.parseInt(parts[1]));
                        }
                        //Convert recipe filename to recipe name
                        String recipeName = getRecipeName(recipeFile);
                        //Set name of recipe and add it to the list of the recipes
                        currRecipe.setName(recipeName);
                        recipes.add(currRecipe);
                        fileScanner.close();
                    //Error handling
                    } catch (FileNotFoundException e) {
                        System.err.println("Error occured when loaded recipes");
                    }
                }
            }
        }
    }

    //Return recipes list
    public ObservableList<Recipe> getRecipes() {
        return recipes;
    }

}
