import application.ApplicationContextBankAgency;

public class BankAgencyApp{
	public static void main(String[] argv){
		ApplicationContextBankAgency context = ApplicationContextBankAgency.getInstance();

		try {
			ApplicationContextBankAgency.generateMenu().execute(context);
		} catch (Exception e){
			e.printStackTrace();
		}
	}
}
