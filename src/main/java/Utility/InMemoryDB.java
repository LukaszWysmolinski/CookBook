package Utility;

import model.Ingredient;
import model.Recipe;
import model.User;
import model.enums.Level;
import model.enums.Meal;
import model.enums.Type;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InMemoryDB {
    public static List<User> users = new ArrayList<User>(
            Arrays.asList(
                    new User("test", "test"),
                    new User("test2", "test2"),
                    new User("test3", "test3")
            )
    );

    public static List<Recipe> recipes = new ArrayList<>(
            Arrays.asList(
                    new Recipe("Bigos", "Bigos – tradycyjna dla kuchni polskiej, litewskiej i białoruskiej potrawa z kapusty i mięsa", 120, "/img/bigos.jpg", Meal.kolacja, Level.średni, Type.tradycyjny,
                            new ArrayList<Ingredient>(Arrays.asList(new Ingredient("kapusta kiszona", 100, 300), new Ingredient("kiełbasa", 100, 100)))),
                    new Recipe("Jajecznica", "Jajecznica – potrawa z rozmąconych, usmażonych na patelni jajek. Jest domeną prostej kuchni, ponieważ nie wymaga umiejętności kulinarnych ani techniki.", 15, "/img/jajecznica.jpg", Meal.śniadanie, Level.łatwy, Type.tradycyjny,
                            new ArrayList<Ingredient>(Arrays.asList(new Ingredient("jaja", 3, 200), new Ingredient("kiełbasa", 100, 100)))),
                    new Recipe("Arbuz w kostkach", "???", 10, "/img/arbuz.png", Meal.deser, Level.łatwy, Type.wegański,
                            new ArrayList<Ingredient>(Arrays.asList(new Ingredient("arbuz", 1, 100))))

            )
    );
    public static List<Ingredient> ingredients = new ArrayList<>(
            Arrays.asList(
                    new Ingredient("chleb", 100, 200),
                    new Ingredient("mleko", 100, 50),
                    new Ingredient("ziemniaki", 100, 300),
                    new Ingredient("cebula", 100, 120)
            )
    );

//    public static List<Ingredient> ingredients = new ArrayList<>(
//            Arrays.asList(new Ingredient("ziemniaki", 100, 500),
//                    new Ingredient("buraki", 100, 220),
//                    new Ingredient("cebula", 100, 160),
//                    new Ingredient("kapusta kiszona", 100, 190),
//                    new Ingredient("kiełbasa", 100, 6500)
//            ));


}
