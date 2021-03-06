package application.actionlist;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import banque.AgenceBancaire;
import action.Action;
import action.ActionList;
import application.action.GenericAction;

public class ActionListAgenceBancaire
	extends GenericAction
	implements ActionList {

	private String title;
	private List<Action> myMenu;
	
	public ActionListAgenceBancaire (String m, String c, String t) {
		super (m, c);
		this.title = t;
		this.myMenu = new ArrayList<>();
	}
	
	@Override
	public String listTitle() {
		return this.title;
	}

	@Override
	public boolean addAction(Action ac, int index) {
		for (Action myAc : this.myMenu) {
			if (ac == myAc) {
				return false;
			}
		}
		this.myMenu.add(index, ac);
		return true;
	}

	@Override
	public boolean addAction(Action ac) {
		return this.addAction(ac, this.myMenu.size());
	}

	@Override
	public boolean removeAction(Action ac) {
		for (int i=0; i<this.myMenu.size(); i++) {
			if (ac == this.myMenu.get(i)) {
				this.myMenu.remove (i);
				return true;
			}
		}
		return false;
	}

	@Override
	public String[] listOfActions() {
		ArrayList<String> res = new ArrayList<>();
		
		for (Action myAc : this.myMenu) {
			res.add(myAc.actionMessage());
		}
		return res.toArray(new String[0]);
	}
	
	@Override
	public boolean removeAction(int index) {
		this.myMenu.remove(index);
		return true;
	}
	
	@Override
	public int size() {
		return this.myMenu.size();
	}

	@Override
	public void execute(AgenceBancaire ab) throws Exception {
		int i;
		int choice;
		
		while (true) {
			for (i=0; i<5; i++)
				System.out.println();
			
			this.printTitle(ab);
			this.printMenu();
					
			choice = this.readResponse();
			
			if (choice == 0) {
				return ;
			}
			else {
				try {
					this.myMenu.get(choice -1).execute(ab);
				} catch (Exception e) {
					// To do
				}
				System.out.println("Fin de "+myMenu.get(choice -1).actionMessage());
				this.tempo();
			}
		}
	}

	private int readResponse() {
		Scanner lect ;
		boolean ok;
		String rep;
		int choice;
		
		choice = -1;
		lect = new Scanner (System.in);
		do {
			ok = false;
			System.out.println("Votre choix ?");
			rep = lect.next();
			try {
				choice = Integer.parseInt(rep);
				if (choice == 0)
					ok = true;
				if ((choice-1)>=0 && (choice -1)<this.myMenu.size())
					ok=true;
			} catch (NumberFormatException nfe) { ok = false; }
			if (! ok)
				System.out.println("Erreur, nouvel essai ...");
		} while (!ok);
		return choice;
	}

	private void printMenu() {
		System.out.println("\n\n"+dec+"Choisir : ");
		int i;
		i=0;
		for (Action myAc : this.myMenu) {
			System.out.println(decTwice+(i+1)+numberOptSep+myAc.actionMessage());
			i++;
		}
		System.out.println("\n"+decTwice+"0"+numberOptSep+"Pour quitter ce menu");
	}

	private void printTitle(AgenceBancaire ac) {
		System.out.println("------------------");
		System.out.println(dec+"Agence "+ac.getNomAgence()
				+" de "+ac.getLocAgence());
		System.out.println(dec + this.title);
		System.out.println("------------------");
	}
	
	private void tempo () {
		Scanner lect ;
		
		lect = new Scanner (System.in );
		
		System.out.print("Tapper un car + return pour continuer ... ");
		lect.next(); // Inutile � stocker mais ... 
	}
	private final String dec="  ";
	private final String decTwice=dec+dec;
	private final String numberOptSep=" - ";
}
