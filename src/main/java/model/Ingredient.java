package model;

import lombok.Data;

@Data
public class Ingredient {
    public static int id;
    private int ingredient_id;
    private String name;
    private int quantity;
    private int calories;

    public Ingredient(String name, int quantity, int calories) {
        this.name = name;
        this.quantity = quantity;
        this.calories = calories;
        this.ingredient_id = id;
        id++;
    }

    @Override
    public String toString() {
        return name + " (" + quantity + " g, " + calories + " kcal)";
    }
}
