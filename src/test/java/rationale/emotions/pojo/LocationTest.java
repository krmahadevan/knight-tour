package rationale.emotions.pojo;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;

public class LocationTest {
    @Test(groups = "unit")
    public void testGetXandY() {
        Location loc = new Location(1, 2);
        assertEquals(loc.getX(), 1);
        assertEquals(loc.getY(), 2);
    }

    @Test(groups = "unit")
    public void testEquals() {
        Location actual = new Location(1, 2);
        Location expected = new Location(1, 2);
        assertTrue(expected.equals(actual));
    }

}
