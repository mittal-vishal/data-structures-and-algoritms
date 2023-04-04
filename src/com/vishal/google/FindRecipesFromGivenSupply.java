package com.vishal.google;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindRecipesFromGivenSupply {

    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        Set<String> recipeSet = new HashSet<>();
        for(String recipe: supplies){
            recipeSet.add(recipe);
        }
        List<String> results = new ArrayList<>();
        boolean isFound = true;
        while(isFound){
            isFound = false;
            for(int i = 0; i < recipes.length; i++){
                String currentRecipe = recipes[i];
                if(recipeSet.contains(currentRecipe)){
                    continue;
                }
                List<String> ingredientList = ingredients.get(i);
                boolean isExist = true;
                for(String recipeContent: ingredientList){
                    if(!recipeSet.contains(recipeContent)){
                        isExist = false;
                        break;
                    }
                }
                if(isExist){
                    recipeSet.add(currentRecipe);
                    results.add(currentRecipe);
                    isFound = true;
                }
            }
        }
        return results;
    }

}
