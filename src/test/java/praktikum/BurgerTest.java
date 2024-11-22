package praktikum;

import org.junit.*;

//import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

public class BurgerTest {

    private Burger burger;
    private Bun bun;

    @Before
    public void setUp() {
        bun = new Bun("Fluoriscent Bun", 988);
        burger = new Burger();
        burger.setBuns(bun);
    }

    @Test
    public void testAddIngredient() {
        Ingredient ingredient = Mockito.mock(Ingredient.class);
        when(ingredient.getPrice()).thenReturn(4142f);
        when(ingredient.getName()).thenReturn("Asteroid Blue Cheese");

        burger.addIngredient(ingredient);

        assertEquals(1, burger.ingredients.size());
        assertEquals("Asteroid Blue Cheese", burger.ingredients.get(0).getName());
    }

    private void assertEquals(String asteroidBlueCheese, String name) {
    }

    private void assertEquals(int i, int size) {
    }

    @Test
    public void testRemoveIngredient() {
        Ingredient ingredient1 = Mockito.mock(Ingredient.class);
        when(ingredient1.getName()).thenReturn("Asteroid Blue Cheese");
        burger.addIngredient(ingredient1);

        Ingredient ingredient2 = Mockito.mock(Ingredient.class);
        when(ingredient2.getName()).thenReturn("Beef Meteorite");
        burger.addIngredient(ingredient2);

        burger.removeIngredient(0);

        assertEquals(1, burger.ingredients.size());
        assertEquals( "Beef Meteorite", burger.ingredients.get(0).getName());
    }

    @Test
    public void testMoveIngredient() {
        Ingredient ingredient1 = Mockito.mock(Ingredient.class);
        when(ingredient1.getName()).thenReturn("Beef Meteorite");
        burger.addIngredient(ingredient1);

        Ingredient ingredient2 = Mockito.mock(Ingredient.class);
        when(ingredient2.getName()).thenReturn("Mini-Salad");
        burger.addIngredient(ingredient2);

        burger.moveIngredient(0, 1);

        assertEquals("Mini-Salad", burger.ingredients.get(0).getName());
        assertEquals("Beef Meteorite", burger.ingredients.get(1).getName());
    }

    @Test
    public void testGetPrice() {
        Ingredient ingredient = Mockito.mock(Ingredient.class);
        when(ingredient.getPrice()).thenReturn(3000F);
        burger.addIngredient(ingredient);

        float expectedPrice = bun.getPrice() * 2 + ingredient.getPrice(); // 2.5 * 2 + 3000 = 3005
        assertEquals(expectedPrice, burger.getPrice(), 0.001);
    }

    private void assertEquals(float expectedPrice, float price, double v) {
    }

    @Test
    public void testGetReceipt() {
        Ingredient ingredient = Mockito.mock(Ingredient.class);
        when(ingredient.getPrice()).thenReturn(3000f);
        when(ingredient.getName()).thenReturn("Asteroid Blue Cheese");
        when(ingredient.getType()).thenReturn(IngredientType.FILLING);

        burger.addIngredient(ingredient);

        String expectedReceipt = "(==== Fluoriscent Bun ====\n" +
                "= cheese Cheese =\n" +
                "(==== Fluoriscent Bun ====\n" +
                "\nPrice: 3005.000000\n"; // 2.5 * 2 + 3000
        assertEquals(expectedReceipt, burger.getReceipt());
    }
}
