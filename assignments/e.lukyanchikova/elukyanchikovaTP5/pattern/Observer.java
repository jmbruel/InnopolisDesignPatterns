package elukyanchikovaTP5.pattern;

/**
 * An interface for all Observers
 */
public interface Observer {
	/**
	 * Informs this elukyanchikovaTP5.observer that an observed subject has changed
	 * 
	 * @param  o the observed subject that has changed
	 */
	public void update(Observable o);
	/**
	 * Informs this elukyanchikovaTP5.observer that an observed subject has changed
	 * @param args object that has changed from observable
	 */
	public void update(Object args);

}