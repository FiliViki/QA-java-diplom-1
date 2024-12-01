package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    private Burger burger;

    @Mock
    private Bun bun;
    @Mock
    private Ingredient ingredient;

   @Before
   public void setUp() {
       burger = new Burger();
//       Bun bun = new Bun("Fluoriscent Bun", 988);
//       Burger burger = new Burger();
//       burger.setBuns(bun);
   }

    @Test
    public void testAddIngredient() {
        burger.addIngredient(ingredient);
        assertTrue(burger.ingredients.contains(ingredient));
    }

    @Test
    public void testRemoveIngredient() {
        burger.addIngredient(ingredient);
        int initialSize = burger.ingredients.size();

        burger.removeIngredient(0);
        assertEquals(initialSize - 1, burger.ingredients.size());
    }

    @Test
    public void testMoveIngredient() {
        Ingredient ingredient1 = new Ingredient(IngredientType.SAUCE, "Ketchup", 20.0f);
        Ingredient ingredient2 = new Ingredient(IngredientType.FILLING, "Meet", 10.0f);

        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.moveIngredient(0, 1);

        assertEquals(ingredient1, burger.ingredients.get(1));
    }

    @Test
    public void testGetPrice() {
        Mockito.when(bun.getPrice()).thenReturn(10.0f);
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        Mockito.when(ingredient.getPrice()).thenReturn(20.0f);

        float expectedPrice = 2 * 10.0f + 20.0f;
        assertEquals(expectedPrice, burger.getPrice(), 0.001f);
    }

    @Test
    public void testGetReceipt() {
        Mockito.when(bun.getName()).thenReturn("Some bun");
        Mockito.when(bun.getPrice()).thenReturn(10.0f);
        burger.setBuns(bun);

        Mockito.when(ingredient.getName()).thenReturn("Some ingredient");
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.FILLING);
        burger.addIngredient(ingredient);

        String receipt = burger.getReceipt();
        assertTrue(receipt.contains("Some bun"));
        assertTrue(receipt.contains("Some ingredient"));
    }
}
