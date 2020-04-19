package elukyanchikovaTP4.src.application.action;
import application.BankAgencyApplicationContext;
import bank.BankAgency;

public class ActionAccountsList implements Action<BankAgencyApplicationContext>{
    private final String message;
    private final String code;

    public ActionAccountsList(String message, String code){
        this.message = message;
        this.code = code;
    }

    @Override
    public String actionMessage() {
        return this.message;
    }

    @Override
    public String actionCode() {
        return this.code;
    }

    @Override
    public void execute(BankAgencyApplicationContext context) throws Exception {
        context.getBankAgency().print();
    }
}