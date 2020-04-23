package pattern;

import java.util.Vector;

/**
 * Representation of an observable
 */
public abstract class Observable {

    enum Event {
        Change,
        Add,
        All
    }

	public Observable() {
		this.observers = new Vector<Observer>();
	}

	public void attach(Observer o, Event forEvent) {
		this.observers.addElement(o);
	}

	public void detach(Observer o) {
		for (int i = 0; i < observers.size(); i++) {
			if (observers.elementAt(i).equals(o))
				observers.removeElementAt(i);
		}
	}

	public void notifyObservers() {
		for (int i = 0; i < observers.size(); i++) {
			Observer observer = observers.elementAt(i);
			observer.update(this);
		}
	}

	public abstract Object getUpdate();

	protected Vector<Observer> observers;
}