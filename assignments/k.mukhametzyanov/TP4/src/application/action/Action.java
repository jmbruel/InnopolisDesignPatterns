package application.action;
/**
 * An Action is an object that implements some application.action of a user's menu.<BR>
 * It is defined by a message, an optional code, an execute method to "do" the application.action.<BR>
 * It is parameterized by the  type of object on which the application.action may act on (execute on).
 *
 * @param <Context> The type of object on which the application.action may act on.
 */
public interface Action <Context> {
    /**
     * Message of the application.action (to show on screen).
     *
     * @return the message of the application.action
     */
    String actionMessage();

    /**
     * Code of the application.action (may be used to identify the application.action among other ones).
     *
     * @return the code of the application.action
     */
    String actionCode();

    /**
     * The method to call in order to "execute" the application.action on <code>ag</code>.
     *
     * @param context the context on which the application.action may act on
     * @throws Exception when an uncaught exception occurs during execution
     */
    void execute(Context context) throws Exception;
}