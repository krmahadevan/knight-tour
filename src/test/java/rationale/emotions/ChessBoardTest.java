package rationale.emotions;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import rationale.emotions.pojo.Location;

public class ChessBoardTest {
    @Test(groups = "unit")
    public void testCanVisitReturnsFalse() {
        ChessBoard board = new ChessBoard(3);
        Location location = new Location(4, 2);
        assertFalse(board.canVisit(location), "The location should have been marked as cannot be visited.");
    }

    @Test(groups = "unit")
    public void testCanVisitReturnsTrue() {
        ChessBoard board = new ChessBoard(3);
        Location location = new Location(1, 2);
        assertTrue(board.canVisit(location), "The location should have been marked as can be visited.");
    }

    @Test(groups = "unit")
    public void testChessBoardCareationWithLocation() {
        Location location = new Location(1, 2);
        ChessBoard board = new ChessBoard(5, location);
        assertEquals(location, board.getFinalLocation(), "The chess board final location didn't match.");
    }

    @Test(expectedExceptions = { IllegalArgumentException.class }, groups = "unit")
    public void testChessBoardCareationWithNullLocation() {
        new ChessBoard(5, null);
    }

    @Test(expectedExceptions = { IllegalArgumentException.class }, groups = "unit")
    public void testChessBoardCreationNegative() {
        new ChessBoard(-5);
    }

    @Test(expectedExceptions = { IllegalArgumentException.class }, groups = "unit")
    public void testChessBoardCreationZeroSize() {
        new ChessBoard(0);
    }

    @Test(groups = "unit")
    public void testChessBoardSimpleCreation() {
        assertEquals(5, new ChessBoard(5).getSize(), "The chess board size wasn't the value that was given.");
    }

    @Test(groups = "unit")
    public void testIsValidReturnsFalse() {
        ChessBoard board = new ChessBoard(3);
        Location location = new Location(4, 2);
        assertFalse(board.isValid(location), "The location should have been marked as invalid.");
    }

    @Test(groups = "unit")
    public void testIsValidReturnsTrue() {
        ChessBoard board = new ChessBoard(3);
        Location location = new Location(1, 2);
        assertTrue(board.isValid(location), "The location should have been marked as valid.");
    }

    @Test(groups = "unit")
    public void testMarkAsNotVisited() {
        Location location = new Location(1, 2);
        ChessBoard board = new ChessBoard(5);
        board.visit(location);
        board.markAsNotVisited(location);
        assertTrue(board.canVisit(location), "The location should have been available to be visited again.");
    }

}
