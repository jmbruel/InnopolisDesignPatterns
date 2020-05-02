import application.ApplicationContextBankAgency;
import application.BankActionFactory;
import application.action.Action;

public class BankAgencyApp {
	public static void main(String[] argv) {
		// 1. get execution context
		ApplicationContextBankAgency context = ApplicationContextBankAgency.getInstance();
		// 2. assemble the menu
		Action<ApplicationContextBankAgency> mainMenu = new BankActionFactory().createAction();

		// 3. run the action
		try {
			mainMenu.execute(context);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}