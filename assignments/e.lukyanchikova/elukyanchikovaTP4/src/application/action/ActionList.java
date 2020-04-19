package elukyanchikovaTP4.src.application.action;

public interface ActionList<E> extends Action<E>{
	/**
	 * Title of the list of actions (menu).
	 *
	 * @return the title of the action list
	 */
	public String listTitle();

	/**
	 * The number of actions in the action list.
	 *
	 * @return number of actions in the action list.
	 */
	public int size();

	/**
	 * Add an action at the end of the list action if it does not yet exists.
	 *
	 * @param ac the action to add
	 * @return true if action is added, else false
	 */
	public boolean addAction(Action<E> ac);

	/**
	 * Add an action in the list action at the specified index if it does not yet exists.
	 *
	 * @param ac the action to add
	 * @param index index to add the action
	 * @return true if action is added, else false
	 * @throws IndexOutOfBoundsException if (index < 0) || (index > size())
	 */
	public boolean addAction(Action<E> ac, int index);

	/**
	 * Remove an action from the list action at the specified index.
	 *
	 * @param index index to remove the action
	 * @return true
	 * @throws IndexOutOfBoundsException if (index < 0) || (index > size())
	 */
	public boolean removeAction(int index);

	/**
	 * Remove an action from the list action.
	 *
	 * @param ac the action to remove
	 * @return true if action is removed (found), else false
	 */
	public boolean removeAction(Action<E> ac);

	/**
	 * List of the messages of actions contained in the action list
	 *
	 * @return an array of messages of the list action
	 */
	public String[] listOfActions() ;
}