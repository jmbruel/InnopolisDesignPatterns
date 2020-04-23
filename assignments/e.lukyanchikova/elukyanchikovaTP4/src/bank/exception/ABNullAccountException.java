package elukyanchikovaTP4.src.bank.exception;

/************************************************************
 * Cette exception est lev�e par la Classe BankAgency lorsque un compte avec valeur null est ajout� � l'agence.<BR>
 * 
 * @author Andr� P�ninou.
 * @version 3.0
 *****************************/

public class ABNullAccountException extends Exception {

	/**
	 * Constructeur par d�faut.<BR>
	 */
	public ABNullAccountException() {
		this("Erreur sur un objet de la classe BankAgency");
	}

	/**
	 * Constructeur param�tr�.<BR>
	 * 
	 * @param message
	 *            information qui sera affich�e si l'exception est affich�e �
	 *            l'�cran
	 */
	public ABNullAccountException(String message) {
		super(message);
	}
}


