package praktikum;

import org.junit.Test;

import static org.junit.Assert.*;

public class BunTest {

    @Test
    public void testBunCreation() {
        Bun bun = new Bun("Fluoriscent Bun", 988);

        assertEquals("Fluoriscent Bun", bun.getName());
        assertEquals(988, bun.getPrice(), 0);
    }



    @Test
    public void testBunPriceNotNegative() {
        Bun bun = new Bun("Fluoriscent Bun", 32);
        assertTrue(bun.getPrice() >= 0);
    }
}