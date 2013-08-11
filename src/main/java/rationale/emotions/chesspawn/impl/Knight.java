package rationale.emotions.chesspawn.impl;

import java.util.ArrayList;
import java.util.List;

import rationale.emotions.ChessBoard;
import rationale.emotions.chesspawn.IPawn;
import rationale.emotions.pojo.Location;

/**
 * This class represents the Knight in the chess board and aims at mimicking some of its behavior.
 * 
 */
public class Knight implements IPawn {

    @Override
    public List<Location> nextMoveLocations(Location fromLocation, ChessBoard board) {
        List<Location> validMoves = new ArrayList<Location>();
        for (AllowedMoves eachMove : AllowedMoves.values()) {
            int x = fromLocation.getX() + eachMove.getLocation().getX();
            int y = fromLocation.getY() + eachMove.getLocation().getY();
            Location temp = new Location(x, y);
            if (board.isValid(temp) && board.canVisit(temp)) {
                validMoves.add(temp);
            }
        }
        return validMoves;
    }

    @Override
    public void moveTo(Location toLocation, ChessBoard board) {
        board.visit(toLocation);
    }

    /**
     * An internal enum that represents in an abstract way the logic behind how the knight moves.
     * 
     */
    private static enum AllowedMoves {
        /**
         * The knight can move 2 rows down and 1 column to the left from the current location.
         */
        LONG_L_LEFT_DOWN(new Location(2, -1)),
        /**
         * The knight can move 2 rows down and 1 column to the right from the current location.
         */
        LONG_L_RIGHT_DOWN(new Location(2, 1)),
        /**
         * The knight can move 2 rows up and 1 column to the left from the current location.
         */
        LONG_L_LEFT_UP(new Location(-2, -1)),
        /**
         * The knight can move 2 rows up and 1 column to the right from the current location.
         */
        LONG_L_RIGHT_UP(new Location(-2, 1)),
        /**
         * The knight can move 1 row down and 2 columns to the left from the current location.
         */
        SHORT_L_LEFT_DOWN(new Location(1, -2)),
        /**
         * The knight can move 1 row down and 2 columns to the right from the current location.
         */
        SHORT_L_RIGHT_DOWN(new Location(1, 2)),
        /**
         * The knight can move 1 row up and 2 columns to the left from the current location.
         */
        SHORT_L_LEFT_UP(new Location(-1, -2)),
        /**
         * The knight can move 1 row up and 2 rows to the right from the current location.
         */
        SHORT_L_RIGHT_UP(new Location(-1, 2));

        private Location location;

        private AllowedMoves(Location location) {
            this.location = location;
        }

        public Location getLocation() {
            return location;
        }
    }

}
