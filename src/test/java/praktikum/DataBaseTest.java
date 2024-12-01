package praktikum;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DataBaseTest {

    @Test
    public void testAvailableBuns() {
        Database database = new Database();
        assertEquals(3, database.availableBuns().size()); // Проверяем, что булочек 3
    }
}
