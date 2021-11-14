package polymorphiclist;

/**
 * This exception is simply used to catch if a recursive call has been made
 * at an {@code EmptyList} node. Can only be thrown by the {@link EmptyList}
 * class.
 *
 * @author Samuel Adrian Kosasih
 * @version 1.1
 * @see Exception
 * @see PolymorphicList
 * @see NonEmptyList
 * @see EmptyList
 */
public class EmptyListException extends Exception {

    /**
     * Constructs a new exception with no detail message.
     */
    public EmptyListException() {
        super();
    }

    /**
     * Constructs a new exception with the specified detail message.
     *
     * @param message the detail message
     */
    public EmptyListException(String message) {
        super(message);
    }
}
