package application.action;

/**
 * An ActionList is an object that implements a end-user menu.<BR>
 * It is defined by a title (printed on top of the menu).<BR>
 * It is also defined by a list of different application.action objects that the menu manages.<BR>
 * It is attended to :<BR>
 * - display the end-user menu numbered from 1 (list of messages of actions).<BR>
 * - display a quit option (0).<BR>
 * - wait for some user-response.<BR>
 * - launch the requested application.action.<BR>
 *
 * It is parameterized by the  type of object on which the actions of the list application.action may act on (execute on).<BR>
 *
 * @param <Context> The type of object on which the list application.action may act on.
 */
public interface ActionList<Context> extends Action<Context>{
    /**
     * Title of the list of actions (menu).
     *
     * @return the title of the application.action list
     */
    public String listTitle();

    /**
     * The number of actions in the application.action list.
     *
     * @return number of actions in the application.action list.
     */
    public int size();

    /**
     * Add an application.action at the end of the list application.action if it does not yet exists.
     *
     * @param ac the application.action to add
     * @return true if application.action is added, else false
     */
    public boolean addAction(Action<Context> ac);

    /**
     * Add an application.action in the list application.action at the specified index if it does not yet exists.
     *
     * @param ac the application.action to add
     * @param index index to add the application.action
     * @return true if application.action is added, else false
     * @throws IndexOutOfBoundsException if (index < 0) || (index > size())
     */
    public boolean addAction(Action<Context> ac, int index);

    /**
     * Remove an application.action from the list application.action at the specified index.
     *
     * @param index index to remove the application.action
     * @return true
     * @throws IndexOutOfBoundsException if (index < 0) || (index > size())
     */
    public boolean removeAction(int index);

    /**
     * Remove an application.action from the list application.action.
     *
     * @param ac the application.action to remove
     * @return true if application.action is removed (found), else false
     */
    public boolean removeAction(Action<Context> ac);

    /**
     * List of the messages of actions contained in the application.action list
     *
     * @return an array of messages of the list application.action
     */
    public String[] listOfActions() ;
}