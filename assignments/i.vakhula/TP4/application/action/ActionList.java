package application.action;

/**
 * An ActionList is an object that implements a end-user menu.<BR>
 * It is defined by a title (printed on top of the menu).<BR>
 * It is also defined by a list of different action objects that the menu manages.<BR>
 * It is attended to :<BR>
 * - display the end-user menu numbered from 1 (list of messages of actions).<BR>
 * - display a quit option (0).<BR>
 * - wait for some user-response.<BR>
 * - launch the requested action.<BR>
 * <p>
 * It is parameterized by the  type of object on which the actions of the list action may act on (execute on).<BR>
 *
 * @param <E> The type of object on which the list action may act on.
 */
public interface ActionList<E> extends Action<E> {
    /**
     * Title of the list of actions (menu).
     *
     * @return the title of the action list
     */
    String listTitle();

    /**
     * The number of actions in the action list.
     *
     * @return number of actions in the action list.
     */
    int size();

    /**
     * Add an action at the end of the list action if it does not yet exists.
     *
     * @param ac the action to add
     * @return true if action is added, else false
     */
    boolean addAction(Action<E> ac);

    /**
     * Add an action in the list action at the specified index if it does not yet exists.
     *
     * @param ac    the action to add
     * @param index index to add the action
     * @return true if action is added, else false
     * @throws IndexOutOfBoundsException if (index < 0) || (index > size())
     */
    boolean addAction(Action<E> ac, int index);

    /**
     * Remove an action from the list action at the specified index.
     *
     * @param index index to remove the action
     * @return true
     * @throws IndexOutOfBoundsException if (index < 0) || (index > size())
     */
    boolean removeAction(int index);

    /**
     * Remove an action from the list action.
     *
     * @param ac the action to remove
     * @return true if action is removed (found), else false
     */
    boolean removeAction(Action<E> ac);

    /**
     * List of the messages of actions contained in the action list
     *
     * @return an array of messages of the list action
     */
    String[] listOfActions();
}
