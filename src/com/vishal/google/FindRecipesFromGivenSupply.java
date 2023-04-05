package com.vishal.google;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindRecipesFromGivenSupply {

    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        Set<String> recipesSet = new HashSet<>();
        for(String supply: supplies){
            recipesSet.add(supply);
        }
        boolean isFound = true;
        List<String> results = new ArrayList<>();
        while(isFound){
            isFound = false;
            for(int i = 0; i < recipes.length; i++){
                String recipe = recipes[i];
                if(recipesSet.contains(recipe)){
                    continue;
                }
                List<String> ingredientContent = ingredients.get(i);
                boolean isExist = true;
                for(String ingredient: ingredientContent){
                    if(!recipesSet.contains(ingredient)){
                        isExist = false;
                    }
                }
                if(isExist){
                    recipesSet.add(recipe);
                    results.add(recipe);
                    isFound = true;
                }
            }
        }
        return results;
    }

}
