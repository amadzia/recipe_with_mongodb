package com.example.recipe.services;

import com.example.recipe.commands.RecipeCommand;
import com.example.recipe.domain.Recipe;

import java.util.Set;

public interface RecipeService {

    Set<Recipe> getRecipes();

    Recipe findById(String idl);

    RecipeCommand saveRecipeCommand(RecipeCommand recipeCommand);

    RecipeCommand findCommandById(String id);

    void deleteById(String idToDelete);
}
