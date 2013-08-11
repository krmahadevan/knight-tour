package rationale.emotions;

import java.util.Collections;
import java.util.List;

import rationale.emotions.chesspawn.IPawn;
import rationale.emotions.chesspawn.impl.Knight;
import rationale.emotions.exception.NoSolutionPathExistsException;
import rationale.emotions.internal.CmdLineOptionsParser;
import rationale.emotions.pojo.Location;

/**
 * This is the main entry class into the KnightsTour stand-alone application.
 *
 */
public class KnightsTour {

    public static void main(String[] args) {
        
        ChessBoard board = null;
        IPawn knight = null;
        Location initial = null;
        try {
            int x, y, size = 3;
            CmdLineOptionsParser cmd = new CmdLineOptionsParser(args);
            x = cmd.getParamValue("#x");
            y = cmd.getParamValue("#y");
            if (cmd.isParamPresent("#size")) {
                size = cmd.getParamValue("#size");
            }
            board = new ChessBoard(size);
            knight = new Knight();
            initial = new Location(x, y);
            boolean valid = board.isValid(initial);
            if (!valid) {
                String msg = String.format("Initial position %s is an invalid location on %d x %d sized Chess Board.",
                        initial, size, size);
                throw new IllegalArgumentException(msg);
            }

        } catch (RuntimeException e) {
            printHelp();
            throw e;
        }

        List<Location> solutions = PawnMoveManager.lookForSolution(initial, knight, board);
        if (solutions == null || solutions.isEmpty()) {
            throw new NoSolutionPathExistsException("Couldn't find a path to move the knight from " + initial + " to "
                    + board.getFinalLocation());
        }
        Collections.reverse(solutions);
        StringBuilder builder = new StringBuilder();
        int size = solutions.size();
        for (int i = 0; i < size; i++) {
            builder.append(solutions.get(i));
            if (i != size - 1) {
                builder.append("~>>");
            }
        }
        System.out.println("The navigation path is as follows:\n");
        System.out.println(builder.toString());

    }

    private static void printHelp() {
        StringBuilder builder = new StringBuilder();
        builder.append("\nUsing the ").append(KnightsTour.class.getSimpleName()).append("standalone application.\n");
        builder.append("To use ").append(KnightsTour.class.getSimpleName()).append(" on a 3x3 chessboard run :\n");
        builder.append("java -jar knightstour.jar #x <x> #y <y> [where x and y are positive positions on the board.]\n");
        builder.append("To use ").append(KnightsTour.class.getSimpleName()).append(" on a nxn chessboard run :\n");
        builder.append("java -jar knightstour.jar #size <n> (where n is the board size)  #x <x> #y <y> [where x and y are positive positions on the board.]");
        System.out.println(builder.toString());
    }
}
