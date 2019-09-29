package model;

import lombok.Data;
import model.enums.Level;
import model.enums.Meal;
import model.enums.Type;

import java.util.ArrayList;
import java.util.List;

@Data
public class Recipe {
    public static int id;
    private int recipe_id;
    private String title;
    private String description;
    private int prepareTime;
    private String imagePath;
    private Meal meal;
    private Level level;
    private Type type;
    private List<Ingredient> ingredients;

    @Override
    public String toString() {
        return title;
    }

    public Recipe(String title, String description, int prepareTime, String imagePath, Meal meal, Level level, Type type, List<Ingredient> ingredients) {
        this.title = title;
        this.description = description;
        this.prepareTime = prepareTime;
        this.imagePath = imagePath;
        this.meal = meal;
        this.level = level;
        this.type = type;
        this.ingredients = ingredients;
        this.recipe_id = id;
        id++;
    }
}
