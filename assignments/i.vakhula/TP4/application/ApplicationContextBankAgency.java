package application;

import application.interaction.InputDevice;
import application.interaction.OutputDevice;
import bank.BankAgency;

/**
 * Context of bank agency. Use Singleton pattern
 */
public class ApplicationContextBankAgency {

    private BankAgency agency;

    /**
     * IO initializes in private constructor
     */
    public final InputDevice inputDevice;
    public final OutputDevice outputDevice;

    private static ApplicationContextBankAgency uniqueInstance = new ApplicationContextBankAgency();

    private ApplicationContextBankAgency() {
        this.inputDevice = new InputDevice();
        this.outputDevice = new OutputDevice();
        this.agency = AccessBankAgency.getBankAgency();
    }

    public static ApplicationContextBankAgency getInstance() {
        return uniqueInstance;
    }

    public BankAgency getAgency() {
        return this.agency;
    }
}
