package praktikum;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class IngredientTest {

    @Test
    public void ingredientConstructorTest() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "Spicy-x", 90f);
        assertEquals(IngredientType.SAUCE, ingredient.getType());
        assertEquals("Spicy-x", ingredient.getName());
        assertEquals(90f, ingredient.getPrice(), 0f);
    }


    @Test
    public void ingredientGetTypeTest() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "Spicy-x", 90f);
        assertEquals(IngredientType.SAUCE, ingredient.getType());
    }

    @Test
    public void ingredientGetNameTest() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "Spicy-x", 90f);
        assertEquals("Spicy-x", ingredient.getName());
    }

    @Test
    public void ingredientGetPriceTest() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "Spicy-x", 90f);
        assertEquals(90f, ingredient.getPrice(), 0f);
    }

    @Test
    public void ingredientEmptyNameTest() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "", 90f);
        assertEquals("", ingredient.getName());
    }

    @Test
    public void ingredientZeroPriceTest() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "Spicy-x", 0.0f);
        assertEquals(0.0f, ingredient.getPrice(), 0f);
    }
}
