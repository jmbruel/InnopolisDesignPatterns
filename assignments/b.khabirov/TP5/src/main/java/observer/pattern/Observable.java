package observer.pattern;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * A generic observable, implements observers storage and notification.
 * @param <ObservationType> Observers are keyed by type, so that some observers
 *                         can subscribe only to some subset of possible events.
 *                         This type must be provided by a subclass. It is a good choice
 *                         to use a enum type for this generic type.
 */
public abstract class Observable<ObservationType, Data> {
	/**
	 * Observers storage
	 */
	protected Map<ObservationType, Set<Observer>> observers;

	/**
	 * Constructs an Observable object
	 */
	public Observable() {
		this.observers = new HashMap<>();
	}

	/**
	 * Attach to this subject
	 * @param o an observer wishing to attach
	 * @param observationTypes list of observation type instances, that the observer wishes to follow
	 */
	public void attach(Observer o, ObservationType[] observationTypes) {
		for (ObservationType observationType : observationTypes) {
			Set<Observer> observersForType = observers.get(observationType);
			if (observersForType == null) {
				observersForType = new HashSet<>();
			}

			observersForType.add(o);
		}
	}

	/**
	 * Detach from this Subject
	 * 
	 * @param o
	 *            the Observer that wishes to detach
	 */
	public void detach(Observer o) {
		observers.values().forEach(observersForType -> observersForType.remove(o));
	}

	/**
	 * Notify all Observers that Subject has changed for given observation type
	 */
	public void notifyObserversForTypes(ObservationType[] types) {
		for (ObservationType type : types) {
			observers.get(type).forEach(observer -> observer.update(this));
		}
	}

	/**
	 * Pull updated data from this Subject
	 * 
	 * @return the updated data from the Subject
	 */
	public abstract Data getUpdate();
}