package rationale.emotions.chesspawn.impl;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.testng.annotations.Test;

import rationale.emotions.ChessBoard;
import rationale.emotions.chesspawn.IPawn;
import rationale.emotions.pojo.Location;

public class KnightTest {
    @Test(groups = "functional")
    public void moveToTestNegative() {
        ChessBoard board = new ChessBoard(3);
        IPawn pawn = new Knight();
        Location location = new Location(1, 3);
        pawn.moveTo(location, board);
        assertTrue(board.canVisit(new Location(2, 3)));
    }

    @Test(groups = "functional")
    public void testMoveTo() {
        ChessBoard board = new ChessBoard(3);
        IPawn pawn = new Knight();
        Location location = new Location(3, 3);
        pawn.moveTo(location, board);
        assertFalse(board.canVisit(location));
    }

    @Test(groups = "functional")
    public void testMoveToOutOfBoardScenario() {
        ChessBoard board = new ChessBoard(3);
        IPawn pawn = new Knight();
        Location location = new Location(5, 3);
        pawn.moveTo(location, board);
        assertFalse(board.canVisit(location));
    }

    @Test(groups = "functional")
    public void testNextMoveLocations() {
        List<Location> expected = Arrays.asList(new Location[] { new Location(1, 1), new Location(1, 3) });
        ChessBoard board = new ChessBoard(3);
        IPawn pawn = new Knight();
        Location location = new Location(3, 2);
        List<Location> actual = pawn.nextMoveLocations(location, board);
        assertEquals(actual, expected);
    }

    @Test(groups = "functional")
    public void testNextMoveLocationsNull() {
        ChessBoard board = new ChessBoard(3);
        IPawn pawn = new Knight();
        Location location = new Location(2, 2);
        List<Location> actual = pawn.nextMoveLocations(location, board);
        assertTrue(actual.isEmpty());
    }
    
}
