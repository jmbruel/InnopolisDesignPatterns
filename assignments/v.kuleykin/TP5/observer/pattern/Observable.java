package observer.pattern;

import java.util.Vector;

/**
 * An abstract class for all Observable subjects
 */
public abstract class Observable {

	private Vector<Observer> newObservers;
	private Vector<Observer> updateObservers;

	/**
	 * Constructs an Observable object
	 */
	public Observable() {
		this.newObservers = new Vector<>();
		this.updateObservers = new Vector<>();
	}

	/**
	 * Attach to this Subject
	 * 
	 * @param o
	 *            the Observer that wishes to attach
	 */
	public void attach(Observer o, boolean observeNew, boolean observeUpdates) {
		if (observeNew) newObservers.add(o);
		if (observeUpdates) updateObservers.add(o);
	}

	/**
	 * Detach from this Subject
	 * 
	 * @param o
	 *            the Observer that wishes to detach
	 */
	public void detach(Observer o) {
		newObservers.removeElement(o);
		updateObservers.removeElement(o);
	}

	/**
	 * The Push version of `notifyObservers`.
	 * @param args
	 */
	public void notifyObservers(Object args, boolean observeNew, boolean observeUpdates) {
		if (observeNew) {
		for (Observer o: newObservers) {
			o.update(args);
		}
		}
		if (observeUpdates) {
			for (Observer o: updateObservers) {
				o.update(args);
			}
		}
	}

	/**
	 * Pull updated data from this Subject
	 * 
	 * @return the updated data from the Subject
	 */
	public abstract Object getUpdate();
}