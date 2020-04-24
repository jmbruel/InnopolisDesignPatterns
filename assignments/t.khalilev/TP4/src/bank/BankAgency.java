package bank;

import java.util.ArrayList;

import bank.exception.ABAccountAlreadyExistingException;
import bank.exception.ABInexistingAccountException;
import bank.exception.ABNullAccountException;


public class BankAgency {

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

		return this.findAccount(pNumCompte);
	}


	public Account[] getAccountsOf(String pOwnerName) {

		Account t[], cTemp;
		ArrayList<Account> alTemp; // ArrayList de Account temporaire
		int nbC, nbCTemp, i;

		t = null;

		alTemp = new ArrayList<Account>();
		nbC = this.accounts.size();
		for (i = 0; i < nbC; i++) {
			cTemp = accounts.get(i);
			if (cTemp.getOwner().equals(pOwnerName)) {
				alTemp.add(cTemp);
			}
		}

		if (alTemp.size() != 0) {
			nbCTemp = alTemp.size();
			t = new Account[nbCTemp];
			for (i = 0; i < nbCTemp; i++) {
				t[i] = alTemp.get(i);
			}

		} else {
			t = new Account[0];
		}
		return t;
	}

	public void print() {
		int i, nbC;
		Account cTemp;

		System.out.println();
		System.out.println("Name: " + this.name + " (" + this.loc + ")");
		System.out.println("" + this.accounts.size() + " Accounts:");
		nbC = this.accounts.size();
		for (i = 0; i < nbC; i++) {
			cTemp = accounts.get(i);
			cTemp.print();
			System.out.println("   Balance: " + cTemp.balance());
		}
		System.out.println();
	}

	/**
	 * Permet d'obtenir la repr�sentation String d'une BankAgency.<BR>
	 * <BR>
	 * Donne le name de l'BankAgency, la localisation, le nombre de Comptes.<BR>
	 * <BR>
	 */

	public String toString() {
		return "Agency Name: " + this.name + " (" + this.loc + ") : "+this.accounts.size()+" accounts";
	}
	
	/**
	 * Permet d'ajouter un Account � l'BankAgency.<BR>
	 * Le Account pCompteAAjouter est ajout� � l'BankAgency s'il n'existe pas d�j� un Account
	 * ayant le m�me num�ro de compte que pCompteAAjouter 
	 * (identique en num�ro de compte � pCompteAAjouter.getNumCompte()).<BR>
	 * Si on appelle la m�thode avec null en param�tre, la m�thode l�ve une exception.<BR>
	 * 
	 * @param pAccountToAdd
	 *            Le Account � ajouter � l'BankAgency.
	 * @throws ABNullAccountException  lorsque pCompteAAjouter == null	
	 * @throws ABAccountAlreadyExistingException  lorsque un compte de num�ro pCompteAAjouter.getNumCompte() existe d�j� dans l'BankAgency.
	 * @see BankAgency#removeAccount(String)
	 */

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

	/**
	 * Permet de supprimer un Account de l'BankAgency, � partir de son num�ro.<BR>
	 * Le Account (unique) de num�ro pNumCompte est retir� de l'BankAgency s'il est
	 * trouv�.<BR>
	 * Une exception est lev�e si le compte n'est pas trouv�.<BR>
	 * 
	 * @param pNumCompte
	 *            Le num�ro du Account � supprimer de l'BankAgency.
	 * @throws ABInexistingAccountException	Lorsque aucun compte de num�ro pNumCompte ne peut �tre trouv�.
	 * @see BankAgency#addAccount(Account)
	 */
	public void removeAccount(String pNumCompte) throws ABInexistingAccountException{
		Account c;

		// On cherche un Account de m�me num�ro
		c = this.findAccount(pNumCompte);

		// Si pas trouv� ...
		if (c == null) {
			// ... erreur
			throw new ABInexistingAccountException(
					"Error suppressing inexisting Account ("
					+ pNumCompte+ ") in Agency " 
					+ this.name + " (" + this.loc + ")");
		} else {
			// ... on enl�ve ce Account
			this.accounts.remove(c);
		}
	}


	/**
	 * M�thode priv�e de recherche d'un compte.
	 * Cherche un compte dans accounts ayant pour num�ro de compte pNC.
	 * Renvoie null si aucun compte n'est trouv�.
	 *
	 * @param      pNC  num�ro dui compte recherch�
	 * @return     l'objet compte (la r�f�rence de) trouv� ou null si non trouv�. 
	 */
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