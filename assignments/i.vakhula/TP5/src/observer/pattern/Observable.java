package observer.pattern;

import observer.CourseRecord;

import java.util.Vector;

/**
 * An abstract class for all Observable subjects
 */
public abstract class Observable {
    /**
     * Constructs an Observable object
     */
    public Observable() {
        this.observers = new Vector<Observer>();
    }

    /**
     * Attach to this Subject
     *
     * @param o the Observer that wishes to attach
     */
    public abstract void attach(Observer o, Action action);

    /**
     * Detach from this Subject
     *
     * @param o the Observer that wishes to detach
     */
    public void detach(Observer o) {
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
            Observer observer = observers.elementAt(i);
            observer.update(this);
        }
    }

    public void notifyObservers(Object o) {
        CourseRecord courseRecord = (CourseRecord) o;
        this.observers.forEach(observer -> {
            observer.update(courseRecord);
        });
    }

    /**
     * Pull updated data from this Subject
     *
     * @return the updated data from the Subject
     */
    public abstract Object getUpdate();

    protected Vector<Observer> observers;
}