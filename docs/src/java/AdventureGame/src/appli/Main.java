package appli;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import comportement.arme.impl.ComportementArc;
import comportement.arme.impl.ComportementEpee;
import comportement.arme.impl.ComportementPoignard;

public class Main {
	private static Personnage personnage;
	private static BufferedReader stdin;

	public static void main(String[] args) throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		stdin = new BufferedReader(isr);
		personnage = choixPersonnage();
		afficherVilain("mygale");
		System.out
				.println("Une mygale surgit devant vous, souhaitez-vous changer d'arme pour l'affronter ?");
		choixArme();
		personnage.combattre();
		afficherVilain("squelette");
		System.out
				.println("Un squelette vous regarde de travers, souhaitez-vous changer d'arme pour l'affronter ?");
		choixArme();
		personnage.combattre();
		afficherVilain("dragon");
		System.out
				.println("Un dragon vous barre la route, souhaitez-vous changer d'arme pour l'affronter ?");
		choixArme();
		personnage.combattre();
		stdin.readLine();
		System.out.println("Félicitations, votre nom est désormais inscrit dans l'histoire du royaume !");
	}

	private static void choixArme() throws IOException {
		boolean choixValide = false;
		while (!choixValide) {
			System.out.println("1 - Garder la même");
			System.out.println("2 - Utiliser un arc");
			System.out.println("3 - Utiliser une épée");
			System.out.println("4 - S'équiper du poignard");
			System.out.println("Quel est votre choix ?");
			switch (stdin.readLine()) {
			case "même":
			case "1":
				choixValide = true;
				break;
			case "arc":
			case "2":
				personnage.setArme(new ComportementArc());
				choixValide = true;
				break;
			case "épéé":
			case "3":
				personnage.setArme(new ComportementEpee());
				choixValide = true;
				break;
			case "poignard":
			case "4":
				personnage.setArme(new ComportementPoignard());
				choixValide = true;
				break;
			}
		}
	}

	private static Personnage choixPersonnage() throws IOException {
		Personnage personnage = null;
		System.out.println("Bienvenue dans Game of IUTs");
		while (personnage == null) {
			System.out.println("Quel personnage souhaitez vous incarnez ?");
			System.out
					.println("Reine : munie de son poignard, elle dispose d'une force insoupçonnée");
			System.out
					.println("Roi : il préfère rester loin des combats et utilise un arc");
			System.out.println("Troll : une brute à l'épée");
			System.out.println("Chevalier : jamais sans son épée");
			System.out.println("Quitter : fini l'aventure");
			System.out.println("Quel est votre choix ?");
			switch (stdin.readLine()) {
			case "Reine":
			case "1":
				personnage = new Reine();
				break;
			case "Roi":
			case "2":
				personnage = new Roi();
				break;
			case "Troll":
			case "3":
				personnage = new Troll();
				break;
			case "Chevalier":
			case "4":
				personnage = new Chevalier();
			case "Quitter":
			case "5":
				System.exit(0);
			}
		}
		return personnage;
	}

	private static void afficherVilain(String nomVilain) {
		try {
			InputStream ips = new FileInputStream(nomVilain + ".txt");
			InputStreamReader ipsr = new InputStreamReader(ips);
			BufferedReader br = new BufferedReader(ipsr);
			String ligne;
			while ((ligne = br.readLine()) != null) {
				System.out.println(ligne);
			}
			br.close();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
}
