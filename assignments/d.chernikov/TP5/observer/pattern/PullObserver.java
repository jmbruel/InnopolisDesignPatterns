package observer.pattern;

/**
 * An interface for pull Observers
 */
public interface PullObserver {
    /**
     * Informs this observer that an observed subject has changed
     *
     * @param o
     *            the observed subject that has changed
     */
    void update(Object o); // TODO: PullObservable
}
