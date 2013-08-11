package rationale.emotions;

import java.util.ArrayList;
import java.util.List;

import rationale.emotions.chesspawn.IPawn;
import rationale.emotions.pojo.Location;

/**
 * This utility class helps in exploring the plausibility of a shortest optimized path from a given location to the
 * location that is deemed to be the intended location on a {@link ChessBoard}.
 * 
 */
public class PawnMoveManager {
    private PawnMoveManager() {
        // hide constructor to defeat instantiation
    }

    /**
     * This utility method attempts at trying to find the shortest path from the location represented by
     * {@link Location} to the location represented by {@link ChessBoard#getFinalLocation()}.
     * 
     * @param location
     *            - A {@link Location} that represents the starting point.
     * @param pawn
     *            - A {@link IPawn} that represents a pawn that is to be moved.
     * @param board
     *            - A {@link ChessBoard} object that represents the board on which the pawn is to be moved.
     * @return - A {@link List} of {@link Location} if there is a path available. Returns <code>null</node>
     * if there is no path available.
     */
    public static List<Location> lookForSolution(Location location, IPawn pawn, ChessBoard board) {

        // Lets check if the location given to us is the final location.
        if (location.equals(board.getFinalLocation())) {
            List<Location> locations = new ArrayList<Location>();
            locations.add(location);
            return locations;
        }
        
        //Can we even visit the location on the board. If we cant, we need to return back.
        if (board.canVisit(location) == false) {
            return null;
        }
        
        List<List<Location>> solution = new ArrayList<List<Location>>();
        
        //mark the current location as visited.
        board.visit(location);
        
        //query the pawn to find out a list of valid locations that can be traversed from the current point
        //on the chess board.
        List<Location> possiblePlacesToStart = pawn.nextMoveLocations(location, board);
        
        //Now we iterate recursively each of the same location to see what can be the possible optimal path.
        for (Location eachPlace : possiblePlacesToStart) {
            List<Location> interim = lookForSolution(eachPlace, pawn, board);
            // If the response was a null, then it means we hit a dead end. Don't add it to our solutions list.
            if (interim != null) {
                solution.add(interim);
            } else {
                //since the traversal didn't yield a possible solution, lets unmark the current location.
                board.markAsNotVisited(location);
            }

        }

        //This section will serve as the consolidation part for all the possible solutions that we may have 
        //accumulated so far.
        List<Location> finalResult = null;
        int size = Integer.MAX_VALUE;
        //Iterate through all the solutions that we have so far, to see which of them has the shortest size.
        //The path with the shortest size would be deemed as the so called optimal solution.
        for (List<Location> eachSolution : solution) {
            if (eachSolution != null && !eachSolution.isEmpty() && eachSolution.size() < size) {
                finalResult = eachSolution;
                size = eachSolution.size();
            }
        }
        if (size == Integer.MAX_VALUE) {
            return null;
        } else {
            finalResult.add(location);
        }
        return finalResult;
    }

}
