package application.action;

import application.ExecutionContext;

/**
 * An interface describing factory, that assembles an action.
 */
public interface ActionFactory<E extends ExecutionContext> {
    /**
     * Assembles an action.
     * @return an action instance.
     */
    Action<E> createAction();
}
