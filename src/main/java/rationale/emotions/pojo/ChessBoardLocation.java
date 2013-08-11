package rationale.emotions.pojo;

/**
 * A simple POJO (Plain Old Java Object) that represents a square on a chess board.
 *
 */
public class ChessBoardLocation extends Location {
    /**
     * Used to represent if the current location was already visited or yet to be visited.
     */
    private boolean wasVisited = false;

    public ChessBoardLocation(int x, int y) {
        super(x, y);
    }

    /**
     * @return - <code>true</code> if the current location can be visited.
     */
    public boolean canVisit() {
        return wasVisited == false;
    }

    /**
     * @param wasVisited - <code>true</code> (or) <code>false</code> indicating the user's intention on whether to
     * mark/un-mark the current location.
     */
    public void setVisited(boolean wasVisited) {
        this.wasVisited = wasVisited;
    }

}
