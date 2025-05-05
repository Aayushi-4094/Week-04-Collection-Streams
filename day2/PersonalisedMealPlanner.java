import java.util.ArrayList;
import java.util.List;

interface MealPlan {
    String getMealType();
}

class VegetarianMeal implements MealPlan {
    @Override
    public String getMealType() {
        return "Vegetarian";
    }
}

class VeganMeal implements MealPlan {
    @Override
    public String getMealType() {
        return "Vegan";
    }
}

class KetoMeal implements MealPlan {
    @Override
    public String getMealType() {
        return "Keto";
    }
}

class HighProteinMeal implements MealPlan {
    @Override
    public String getMealType() {
        return "High-Protein";
    }
}

class Meal<T extends MealPlan> {
    private T mealPlan;
    private List<String> mealOptions;

    public Meal(T mealPlan) {
        this.mealPlan = mealPlan;
        this.mealOptions = new ArrayList<>();
    }

    public void addMealOption(String mealOption) {
        mealOptions.add(mealOption);
    }

    public T getMealPlan() {
        return mealPlan;
    }

    public List<String> getMealOptions() {
        return mealOptions;
    }
}

public class PersonalisedMealPlanner {
    public static <T extends MealPlan> Meal<T> generateMealPlan(T mealPlan) {
        Meal<T> meal = new Meal<>(mealPlan);
        if (mealPlan instanceof VegetarianMeal) {
            meal.addMealOption("Vegetable stir-fry");
            meal.addMealOption("Lentil soup");
        } else if (mealPlan instanceof VeganMeal) {
            meal.addMealOption("Vegan salad");
            meal.addMealOption("Tofu stir-fry");
        } else if (mealPlan instanceof KetoMeal) {
            meal.addMealOption("Grilled salmon");
            meal.addMealOption("Avocado salad");
        } else if (mealPlan instanceof HighProteinMeal) {
            meal.addMealOption("Grilled chicken");
            meal.addMealOption("Protein shake");
        }
        return meal;
    }

    public static void main(String[] args) {
        Meal<VegetarianMeal> vegetarianMeal = generateMealPlan(new VegetarianMeal());
        System.out.println("Meal Plan: " + vegetarianMeal.getMealPlan().getMealType());
        System.out.println("Meal Options: " + vegetarianMeal.getMealOptions());

        Meal<VeganMeal> veganMeal = generateMealPlan(new VeganMeal());
        System.out.println("Meal Plan: " + veganMeal.getMealPlan().getMealType());
        System.out.println("Meal Options: " + veganMeal.getMealOptions());
    }
}


