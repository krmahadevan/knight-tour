package rationale.emotions.chesspawn;

import java.util.List;

import rationale.emotions.ChessBoard;
import rationale.emotions.PawnMoveManager;
import rationale.emotions.pojo.Location;

/**
 * This interface represents the abilities that any given pawn should have. All pawns that intend to be placed on a
 * {@link ChessBoard} would need to implement this interface. If not, then they cannot be used in conjunction with
 * {@link PawnMoveManager}.
 * 
 */
public interface IPawn {
    /**
     * This method retrieves the list of valid locations on a given {@link ChessBoard} keeping in mind any specific
     * Chess game rules the current pawn may be bound by.
     * 
     * @param fromLocation
     *            - A {@link Location} object that indicates from where to start.
     * @param board
     *            - A {@link ChessBoard} object on which to operate.
     * @return - A {@link List} of {@link Location} that represent the next plausible locations to where the current
     *         pawn can move to.
     */
    public List<Location> nextMoveLocations(Location fromLocation, ChessBoard board);

    /**
     * A utility method that causes the current pawn to move to a given location on the chess board.
     * 
     * @param toLocation
     *            - A {@link Location} that represents the location to where to move to.
     * @param board
     *            - A {@link ChessBoard} object on which to operate.
     */
    public void moveTo(Location toLocation, ChessBoard board);

}
