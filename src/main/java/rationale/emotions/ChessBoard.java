package rationale.emotions;

import java.util.ArrayList;
import java.util.List;

import rationale.emotions.pojo.ChessBoardLocation;
import rationale.emotions.pojo.Location;

/**
 * A representation of a N x N chess-board. Contains utility methods which help in :
 * <ul>
 * <li>Marking a location on the board as visited by a pawn (to simulate a pawn moving to a location on the chess board)
 * <li>Finding out if a given location is already visited by a pawn.
 * <li>Marking a location on the board as "can be visited" by a pawn.
 * </ul>
 * 
 */
public class ChessBoard {
    /**
     * Represents the board size as specified by the user.
     */
    private int boardSize = 0;
    /**
     * Represents the location which determines the success condition. Essentially if a pawn lands in this location,
     * then it can be assumed that a solution has been reached.
     */
    private Location finalLocation = null;
    /**
     * This {@link List} of {@link ChessBoardLocation} represents the actual chess board.
     */
    private List<List<ChessBoardLocation>> chessBoard = null;;

    /**
     * 
     * @param size
     *            - The size of the board. Size cannot be negative or zero.
     */
    public ChessBoard(int size) {
        this(size, new Location(size, size));
    }

    /**
     * @param size - The size of the board. Size cannot be negative or zero.
     * @param finalLocation - A {@link Location} object that represents the final Location.
     */
    public ChessBoard(int size, Location finalLocation) {
        if (size <= 0) {
            throw new IllegalArgumentException("The size of the chess board cannot be negative or zero.");
        }
        if (finalLocation == null || finalLocation.getX() < 0 || finalLocation.getY() < 0) {
            throw new IllegalArgumentException(
                    "The location that determines success condition cannot be null (or) negative.");
        }
        this.boardSize = size;
        chessBoard = new ArrayList<List<ChessBoardLocation>>(boardSize);
        initBoard();
        this.finalLocation = finalLocation;

    }

    /**
     * Initializes the chess board.
     */
    private void initBoard() {
        for (int i = 1; i <= boardSize; i++) {
            List<ChessBoardLocation> columns = new ArrayList<ChessBoardLocation>(boardSize);
            for (int j = 1; j <= boardSize; j++) {
                columns.add(new ChessBoardLocation(i, j));
            }
            chessBoard.add(columns);
        }
    }

    /**
     * @return - A {@link Location} object that represents the final location which marks the solution as attained.
     * Once a pawn on a chess board lands on this location, solution has been achieved. 
     */
    public Location getFinalLocation() {
        return finalLocation;
    }

    /**
     * @param location - A {@link Location} that represents the location to be evaluated.
     * @return - <code>true</code> if the given location is inside the board and <code>false</code> otherwise.
     */
    public boolean isValid(Location location) {
        int x = location.getX() - 1;
        int y = location.getY() - 1;
        if (x < 0 || y < 0) {
            return false;
        }
        if (x >= boardSize || y >= boardSize) {
            return false;
        }
        return true;
    }

    /**
     * Given a {@link Location} object, the board marks this location as visited (to simulate a pawn moving on a board).
     * @param location - The {@link Location} to which a pawn will be moved (internally this location gets marked as visited).
     */
    public void visit(Location location) {
        if (canVisit(location)) {
            this.chessBoard.get(location.getX() - 1).get(location.getY() - 1).setVisited(true);
        }
    }
    
    /**
     * Given a {@link Location} object, the board marks this location as free.
     * 
     * @param location - The {@link Location} object that needs to be marked as free. [ This is essentially required when as part of traversing 
     * if a path doesn't yield results, then the locations in that path would need to be marked as free ]
     */
    public void markAsNotVisited(Location location) {
        if (isValid(location)) {
            this.chessBoard.get(location.getX() - 1).get(location.getY() - 1).setVisited(false);
        }
    }
    
    /**
     * Helps determine if a Given a {@link Location} object can be visited or not. 
     * @param location - The {@link Location} which needs to be checked if it can be visited or not.
     * @return - <code>true</code> if a location can be visited and <code>false</code> otherwise.
     */
    public boolean canVisit(Location location) {
        if (isValid(location)) {
            return this.chessBoard.get(location.getX() - 1).get(location.getY() - 1).canVisit();
        }
        return false;
    }

    /**
     * @return - the size of the board as an int.
     */
    public int getSize(){
        return this.boardSize;
    }
}
