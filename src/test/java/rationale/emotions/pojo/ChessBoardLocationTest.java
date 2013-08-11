package rationale.emotions.pojo;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

import org.testng.annotations.Test;

public class ChessBoardLocationTest {
    @Test
    public void testCreation() {
        ChessBoardLocation loc = new ChessBoardLocation(1, 2);
        assertEquals(loc.getX(), 1);
        assertEquals(loc.getY(), 2);
        loc.setVisited(true);
        assertFalse(loc.canVisit());
    }
}
