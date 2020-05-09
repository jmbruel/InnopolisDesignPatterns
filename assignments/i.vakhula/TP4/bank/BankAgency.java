package bank;

import application.ApplicationContextBankAgency;
import bank.exception.ABAccountAlreadyExistingException;
import bank.exception.ABInexistingAccountException;
import bank.exception.ABNullAccountException;

import java.util.ArrayList;


// V ARRAYLLIST OK

/************************************************************
 * La classe BankAgency permet de g�rer une agence bancaire comme un ensemble de Comptes.<BR>
 * Une BankAgency a un name, une localisation (ville) et g�re un ensemble de Comptes.<BR>
 * Exemple : agence "Agence Caisse Epargne" � "Pibrac".<BR>
 * Chaque Account de l'BankAgency a un num�ro unique (v�rification faite lors de l'ajout d'un Account).<BR>
 *
 * @author Andr� P�ninou.
 * @version 7.02
 *****************************/

public class BankAgency {
    // Attributs
    private String name, loc;
    private ArrayList<Account> accounts;

    public BankAgency(String pNomAgence, String pLocAgence) {
        this.name = pNomAgence;
        this.loc = pLocAgence;
        this.accounts = new ArrayList<Account>();
    }

    public String getAgencyName() {
        return this.name;
    }


    public String getAgencyLoc() {
        return this.loc;
    }


    public int getNbAccounts() {
        return this.accounts.size();
    }

    public Account getAccount(String pNumCompte) {
        // A titre d'exemple : utilise une m�thode priv�e d�finie en fin de
        // classe
        return this.findAccount(pNumCompte);
    }


    public Account[] getAccountsOf(String pOwnerName) {

        Account t[], cTemp;
        ArrayList<Account> alTemp; // ArrayList de Account temporaire
        int nbC, nbCTemp, i;

        t = null;

        // Recherche des comptes de pNomProprietaire dans l'BankAgency
        alTemp = new ArrayList<Account>();
        nbC = this.accounts.size();
        for (i = 0; i < nbC; i++) {
            cTemp = accounts.get(i);
            if (cTemp.getOwner().equals(pOwnerName)) {
                alTemp.add(cTemp);
            }
        }

        // Si on a trouv� des comptes ...
        if (alTemp.size() != 0) {
            // ... on cr�e un tableau et on les recopie
            nbCTemp = alTemp.size();
            t = new Account[nbCTemp];
            for (i = 0; i < nbCTemp; i++) {
                t[i] = alTemp.get(i);
            }
            /*
             * Ou bien directement, sans les lignes ci-dessus :
             *		t = alTemp.toArray(new Account[0]);
             * cf. doc ArrayList / T[] toArray(T[])
             */
        } else {
            // ... pas de compte dans un tableau vide
            t = new Account[0];
        }
        return t;
    }

	/*	Autre solution possible : sans ArrayList temporaire
	 	public Account[] getComptesDe (String pNomProprietaire)
		{
			Account t[], cTemp;
			int nbC, nbCCourants, i, j;

			t=null;

			// On compte les comptes de pNomProprietaire
			nbC = 0;
			nbCCourants = this.vCpt.size();
			for (i=0; i<nbCCourants; i++)
			{
				cTemp = accounts.get(i);
				if (cTemp.getProprietaire().equals(pNomProprietaire)) {
					nbC++;
				}
			}

			// Si on a trouv� des comptes ...
			if (nbC != 0)
			{
				// ...  on cr�e un tableau et on les recherche � nouveau
				// pour les recopier
				t = new Account[nbC];
				j=0;
				nbCCourants = this.alCptes.size();
				for (i=0; i<nbCCourants; i++)
				{
					cTemp = accounts.get(i);
					if (cTemp.getProprietaire().equals(pNomProprietaire)) {
						t[j++] = cTemp;
					}
				}
			}
			else {
				t=new Account[0];
			}

			return t;
		}
	 */


    public void print() {
        int i, nbC;
        Account cTemp;

        ApplicationContextBankAgency.getInstance().outputDevice.println();
        ApplicationContextBankAgency.getInstance().outputDevice.println("Name: " + this.name + " (" + this.loc + ")");
        ApplicationContextBankAgency.getInstance().outputDevice.println("" + this.accounts.size() + " Accounts:");
        nbC = this.accounts.size();
        for (i = 0; i < nbC; i++) {
            cTemp = accounts.get(i);
            cTemp.print();
            ApplicationContextBankAgency.getInstance().outputDevice.println("   Balance: " + cTemp.balance());
        }
        ApplicationContextBankAgency.getInstance().outputDevice.println();
    }


    public String toString() {
        return "Agency Name: " + this.name + " (" + this.loc + ") : " + this.accounts.size() + " accounts";
    }

    public void addAccount(Account pAccountToAdd) throws ABNullAccountException, ABAccountAlreadyExistingException {
        Account c;

        // Si null => refus�
        if (pAccountToAdd == null) {
            throw new ABNullAccountException("Errorr adding 'null' Account in Agency "
                    + this.name + " (" + this.loc + ")");
        }

        // On cherche un Account de m�me num�ro
        c = this.findAccount(pAccountToAdd.getAccountNumber());

        // Si trouv�
        if (c != null) {
            // => refus�
            throw new ABAccountAlreadyExistingException(
                    "Error adding existing Account ("
                            + pAccountToAdd.getAccountNumber() + ") in Agency "
                            + this.name + " (" + this.loc + ")");
        } else {
            // ... on ajoute le Account
            this.accounts.add(pAccountToAdd);

        }
    }

    public void removeAccount(String pNumCompte) throws ABInexistingAccountException {
        Account c;

        // On cherche un Account de m�me num�ro
        c = this.findAccount(pNumCompte);

        // Si pas trouv� ...
        if (c == null) {
            // ... erreur
            throw new ABInexistingAccountException(
                    "Error suppressing inexisting Account ("
                            + pNumCompte + ") in Agency "
                            + this.name + " (" + this.loc + ")");
        } else {
            // ... on enl�ve ce Account
            this.accounts.remove(c);
        }
    }

    private Account findAccount(String pNC) {
        Account c, cTemp;
        int i, nbC;

        // On parcours l'ArrayList de l'BankAgency
        nbC = this.accounts.size();
        c = null;
        for (i = 0; i < nbC && c == null; i++) {
            cTemp = accounts.get(i);
            // Si un Account a le m�me num�ro que pNC
            if (cTemp.getAccountNumber().equals(pNC)) {
                // ... on le garde
                c = cTemp;
            }
        }
        return c;
    }
}