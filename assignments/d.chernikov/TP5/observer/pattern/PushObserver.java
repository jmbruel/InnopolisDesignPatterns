package observer.pattern;

/**
 * An interface for push Observers
 */
public interface PushObserver<T> {
	/**
	 * Informs this observer that an observed subject has changed
	 *
	 * @param data
	 *            the data that has changed
	 */
	void update(T data);
}
