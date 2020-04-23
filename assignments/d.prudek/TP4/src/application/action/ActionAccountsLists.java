package application.action;

import application.context.IContext;

/**
 *
 * @author David Prudek
 */
public class ActionAccountsLists implements Action {
    
    private String message;
    private String code;

    public ActionAccountsLists(String message, String code) {
        this.message = message;
        this.code = code;
    }
    
    

    @Override
    public String actionMessage() {
        return message;
    }

    @Override
    public String actionCode() {
        return code;
    }

    @Override
    public void execute(IContext context) throws Exception {
        context.getBankAgency().print();
    }
    
}
