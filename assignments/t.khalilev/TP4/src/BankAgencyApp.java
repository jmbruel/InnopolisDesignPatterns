

import java.util.Locale;
import java.util.Scanner;

import application.AccessBankAgency;
import application.ApplicationContextBankAgency;
import bank.BankAgency;
import bank.Account;
import bank.exception.AccountException;

public class BankAgencyApp {

	public static void main(String[] argv) throws Exception {
		ApplicationContextBankAgency ctx = ApplicationContextBankAgency.getInstance();
		ApplicationContextBankAgency.getMenu().execute(ctx);
	}
}
