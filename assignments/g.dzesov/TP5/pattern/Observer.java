package pattern;

public interface Observer {
	/**
	 * Informs this observer that an observed subject has changed
	 */
	public void update(Observable o);

    /**
     * Informs this observer that an observed subject has changed
     */
    public void update(Object obj);
}