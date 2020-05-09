package bank;

import application.ApplicationContextBankAgency;
import bank.exception.AccountException;


/************************************************************
 * Classe Account permettant de g�rer des comptes simples.<BR>
 * Un Account a un num�ro, appartient � un propri�taire et on peut y faire des
 * versements (cr�dits) et des retraits (d�bits).<BR>
 * Seuls des contr�les de montants des op�rations >=0 sont r�alis�s.<BR>
 *
 * @author Andr� P�ninou.
 * @version 3.01
 *****************************/

// Classe des comptes standards

public class Account extends Object
// Si cet h�ritage n'est pas pr�cis�, il est implicite
{
    /*********************************
     * Partie priv�e d'impl�mentation
     **********************************/

    // Attributs

    // Nom du propri�taire
    private String owner;

    // Numero de Account
    private String accountNumber;

    private double debits, credits;

    private int nbDebits, nbCredits;

    public Account() {
        this("No number", "No owner");
    }

    public Account(String pAccountNumber, String pOwnerName) {
        this.accountNumber = pAccountNumber;
        this.owner = pOwnerName;
        this.debits = 0;
        this.credits = 0;
        this.nbCredits = 0;
        this.nbDebits = 0;
    }

    public double balance() {
        return this.credits - this.debits;
    }

    public String getOwner() {
        return this.owner;
    }

    public String getAccountNumber() {
        return this.accountNumber;
    }

    public void print() {
        ApplicationContextBankAgency.getInstance().outputDevice.println(this.toString());
    }

    public String toString() {
        return "  Num.: " + this.accountNumber + " - Owner: " + this.owner
                + " - Debit " + this.debits + " E / Credit " + this.credits
                + " E / NbOps " + (this.nbCredits + this.nbDebits);
    }

    public void withdraw(double pSum) throws AccountException {
        if (pSum < 0) {
            throw new AccountException(
                    "Errorr negative withdraw value forbidden " + this.accountNumber);
        }
        this.debits = this.debits + pSum;
        this.nbDebits++;
    }

    public void deposit(double pSum) throws AccountException {
        if (pSum < 0) {
            throw new AccountException(
                    "Errorr negative deposit value forbidden " + this.accountNumber);
        }
        this.credits = this.credits + pSum;
        this.nbCredits++;
    }

    public void setOwner(String pOwnerName) {
        this.owner = pOwnerName;
    }

}
