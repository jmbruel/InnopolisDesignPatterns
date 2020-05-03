package observer.pattern;

import java.util.Vector;

/**
 * An abstract class for all Observable subjects
 */
public abstract class PushObservable<T> {
	/**
	 * Constructs an Observable object
	 */
	public PushObservable() {
		this.observers = new Vector<>();
	}

	/**
	 * Attach to this Subject
	 * 
	 * @param o
	 *            the Observer that wishes to attach
	 */
	public void attach(PushObserver<T> o) {
		this.observers.addElement(o);
	}

	/**
	 * Detach from this Subject
	 * 
	 * @param o
	 *            the Observer that wishes to detach
	 */
	public void detach(PushObserver<T> o) {
		for (int i = 0; i < observers.size(); i++) {
			if (observers.elementAt(i).equals(o))
				observers.removeElementAt(i);
		}
	}

	/**
	 * Notify all Observers that Subject has changed
	 */
	public void notifyObservers() {
		for (int i = 0; i < observers.size(); i++) {
			PushObserver<T> observer = observers.elementAt(i);
			observer.update(getUpdate());
		}
	}

	/**
	 * Pull updated data from this Subject
	 * 
	 * @return the updated data from the Subject
	 */
	public abstract T getUpdate();

	protected Vector<PushObserver<T>> observers;
}