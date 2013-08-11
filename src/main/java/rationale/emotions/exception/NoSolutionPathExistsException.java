package rationale.emotions.exception;

import rationale.emotions.ChessBoard;

/**
 * This is a subclass of {@link RuntimeException} and would be thrown when there are no solutions found
 * i.e., there exists no path from a given starting point to the point as determined by {@link ChessBoard}.
 *
 */
public class NoSolutionPathExistsException extends RuntimeException {

    private static final long serialVersionUID = 9164363150145620991L;

    /**
     * Constructs a default exception object.
     */
    public NoSolutionPathExistsException() {
        super();
    }

    /**
     * @param msg - The message to be used when constructing the exception.
     */
    public NoSolutionPathExistsException(String msg) {
        super(msg);
    }

    /**
     * @param msg - The message to be used when constructing the exception.
     * @param throwable - A {@link Throwable} object that represents the actual error information, stacktrace etc.,
     */
    public NoSolutionPathExistsException(String msg, Throwable throwable) {
        super(msg, throwable);
    }

    /**
     * @param throwable - A {@link Throwable} object that represents the actual error information, stacktrace etc.,
     */
    public NoSolutionPathExistsException(Throwable throwable) {
        super(throwable);
    }

}
