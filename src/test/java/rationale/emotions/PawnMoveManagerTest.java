package rationale.emotions;

import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;
import org.testng.annotations.Test;

import rationale.emotions.chesspawn.IPawn;
import rationale.emotions.chesspawn.impl.Knight;
import rationale.emotions.pojo.Location;

public class PawnMoveManagerTest {
    @Test(groups = "functional")
    public void testLookForSolution() {
        ChessBoard board = new ChessBoard(3);
        IPawn knight = new Knight();
        Location initial = new Location(2, 1);
        List<Location> solutions = PawnMoveManager.lookForSolution(initial, knight, board);
        List<Location> expected = Arrays.asList(new Location[] { board.getFinalLocation(), initial });
        assertEquals(solutions, expected, "There was a mismatch in the solution.");
    }

    @Test(groups = "functional")
    public void testLookForSolutionNegative() {
        ChessBoard board = new ChessBoard(3);
        IPawn knight = new Knight();
        Location initial = new Location(2, 2);
        List<Location> solutions = PawnMoveManager.lookForSolution(initial, knight, board);
        assertNull(solutions, "There shouldn't have been any solution at all.");
    }

}
