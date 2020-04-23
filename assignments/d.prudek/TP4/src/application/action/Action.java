package application.action;

import application.context.IContext;

/**
 *
 * @author David Prudek
 */
public interface Action {
    /**
    * Message of the action (to show on screen).
    *
    * @return the message of the action
    */
    public String actionMessage ();

    /**
    * Code of the action (may be used to identify the action among other ones).
    *
    * @return the code of the action
    */
    public String actionCode ();

    /**
    * The method to call in order to "execute" the action on <code>ag</code>.
    *
    * @param context the BankAgencyContext on which the action may act on
    * @throws Exception when an uncaught exception occurs during execution
    */
    public void execute(IContext context) throws Exception;
}
