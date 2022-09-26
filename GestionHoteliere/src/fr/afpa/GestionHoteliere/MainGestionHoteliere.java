package fr.afpa.GestionHoteliere;

import java.util.Scanner;
import java.io.IOException;
import java.util.Random;

public class MainGestionHoteliere {

	public static void main(String[] args) {
		//login and password
				String username = "Admin";
				String password = "1234";
				
				// Creation of the rooms
				int nbRoom = 20;
				int nbOption = 2;
				int listOfRoom[][] = generateListOfRoom(nbRoom, nbOption);
				
				//Start of the functionalities of the program
				clearScreen();
				String lastChoice = null;
				displayMenu(lastChoice);
				tttmenu(lastChoice, username, password, nbRoom, nbOption, listOfRoom);
	}
	/**
	 * Creates the tab.
	 * 
	 * @param size1 
	 * The number of line of the tab
	 * @param size2
	 * The number of the column of the tab. The second column is randomly generated
	 * @return the created tab
	 */
	public static int[][] generateListOfRoom(int size1, int size2) {
		int roomList[][] = new int[size1][size2];
		for (int i=0; i<size1; i++) {
			for (int j=0; j<size2; j++) {
				if (j==0) {
					roomList[i][j] = i+1;
				}else if (j==1) {
					Random rn = new Random();
					roomList[i][j] = rn.nextInt(2);
				}
			}
		}
		return roomList;
	}
	
	/**
	 * Clears the screen
	 */
	public static void clearScreen() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            }else {
                Runtime.getRuntime().exec("clear");
			}
        } catch (IOException | InterruptedException ex) {}
    }
	
	/**
	 * Displays the menu
	 * 
	 * @param lastChoice
	 * 		The last choice made by the user
	 */
	public static void displayMenu(String lastChoice) {
		System.out.println("------------------------------------------------MENU DE GESTION DE L'HOTEL------------------------------------------------\n");
		System.out.println("A- Afficher l'etat de l'hotel");
		System.out.println("B- Afficher le nombre de chambres reservees");
		System.out.println("C- Afficher le nombre de chambres libres");
		System.out.println("D- Afficher le numero de la premiere chambre vide");
		System.out.println("E- Afficher le numero de la derniere chambre vide");
		System.out.println("F- Reserver une chambre (Le programme doit reserver la premiere chambre vide)");
		System.out.println("G- Liberer une chambre (Le programme doit liberer la derniere chambre occupee)");
		System.out.println("\nQ- Quitter\n");
		System.out.println("--------------------------------------------------------------------------------------------------------------------------\n");
		if(lastChoice != null) {
			System.out.println("Precedent: " + lastChoice);
		}
		System.out.print("Votre choix :");
	}
	
	
	/**
	 * Asks the choice and runs the functionalities of the program
	 * 
	 * @param lastChoice
	 * 		The last choice made by the user
	 * @param username
	 * 		The stocked login
	 * @param password
	 * 		The stocked password
	 * @param nbRoom
	 * 		The number of rooms
	 * @param nbOption
	 * 		The number of options (ex: number of rooms, availability of the rooms...)
	 * @param listOfRoom
	 * 		The tab containing the rooms
	 */
	public static void tttmenu(String lastChoice, String username, String password, int nbRoom, int nbOption, int listOfRoom[][] ) {
		Scanner sc = new Scanner(System.in);
		boolean run = true;
		do {
		String choice = sc.nextLine();
			switch(choice.toUpperCase()) { 
				case "A":
					clearScreen();
					lastChoice = "Choix A";
					hotelStatus(nbRoom, listOfRoom);
					break;
				
				case "B":
					clearScreen();
					lastChoice = "Choix B";
					BookedRoom(nbRoom, listOfRoom);
					break;
				
				case "C":
					clearScreen();
					lastChoice = "Choix C";
					AvailableRoom(nbRoom, listOfRoom);
					break;
				
				case "D":
					clearScreen();
					lastChoice = "Choix D";
					firstAvailableRoom(nbRoom, listOfRoom);
					break;

				case "E":
					clearScreen();
					lastChoice = "Choix E";
					lastAvailableRoom(nbRoom, listOfRoom);
					break;
					
				case "F":
					clearScreen();
					lastChoice = "Choix F";
					bookRoom(username, password, nbRoom, listOfRoom);
					break;

				case "G":
					clearScreen();
					lastChoice = "Choix G";
					releaseRoom(username, password, nbRoom, listOfRoom);
					break;
				
				case "Q":
					clearScreen();
					run = false;
					System.out.println("Bye :(");
					break;
					
				default:
					clearScreen();
					displayMenu(lastChoice);
			}
		} while(run);
	}
	
	/**
	 * Displays the status of the rooms
	 * 
	 * @param nbRoom
	 * 		The number of rooms
	 * @param listOfRoom
	 * 		The tab containing the rooms
	 */
	public static void hotelStatus(int nbRoom, int listOfRoom[][]) {
		System.out.println("Voici le statut des chambres : ");
		for (int i=0; i<nbRoom; i++) {
			System.out.print("Chambre " + listOfRoom[i][0] + ", disponibilite : " + listOfRoom[i][1] + "\n");
		}
		System.out.print("\nAppuyez sur entrer pour continuer...");
	}
	
	public static void BookedRoom(int nbRoom, int listOfRoom[][]) {
		System.out.println("Liste des chambres reserves: ");
		int nbBookedRoom = 0;
		
		for (int i = 0; i< nbRoom ;i++) {
		if (listOfRoom[i][1] == 1) {
				nbBookedRoom += 1;	
				System.out.println("Chambre " + listOfRoom[i][0]);
			}
		}
		System.out.println ("\nIl y a " +  nbBookedRoom  + " chambres reservee(s).");
		System.out.print("\nAppuyez sur entrer pour continuer...");
	}
	

	
	/**
	 * Displays the available rooms
	 * 
	 * @param nbRoom
	 * 		The number of rooms
	 * @param listOfRoom
	 * 		The tab containing the rooms
	 */
	public static void AvailableRoom(int nbRoom, int listOfRoom[][]) {
		System.out.println("Liste des chambres libre: ");
		int nbAvailableRoom = 0;
		
		for (int i = 0; i< nbRoom ;i++) {
		if (listOfRoom[i][1] == 0) {
				nbAvailableRoom += 1;	
				System.out.println("Chambre " + listOfRoom[i][0]);
			}
		}
		System.out.println ("\nIl y a " +  nbAvailableRoom  + " chambres libre(s).");
		System.out.print("\nAppuyez sur entrer pour continuer...");
	}
	
	/**
	 * Displays the first available room
	 * 
	 * @param nbRoom
	 * 		The number of rooms
	 * @param listOfRoom
	 * 		The tab containing the rooms
	 */
	public static void firstAvailableRoom(int nbRoom, int listOfRoom[][]) {
		for (int i = 0; i< nbRoom ;i++) {
			if (listOfRoom[i][1] == 0) {	
				System.out.println("La premiere chambre libre est la chambre " + listOfRoom[i][0] + ".");
				break;
			}
		}
		System.out.print("\nAppuyez sur entrer pour continuer...");
	}
	
	/**
	 * Displays the last available room
	 * 
	 * @param nbRoom
	 * 		The number of rooms
	 * @param listOfRoom
	 * 		The tab containing the rooms
	 */
	public static void lastAvailableRoom(int nbRoom, int listOfRoom [][]) {
		for (int i = nbRoom-1; i>=0 ;i--) {
			if (listOfRoom[i][1] == 0) {	
				System.out.println("La derniere chambre libre est la chambre " + listOfRoom[i][0] + ".");
				break;
			}
		}
		System.out.print("\nAppuyez sur entrer pour continuer...");
	}
	
	
	/**
	 * Books the first available room. 
	 * Ask the login and password. If one of them is invalid, the room is not book 
	 * 
	 * @param username
	 * 		The stocked login
	 * @param password
	 * 		The stocked password
	 * @param nbRoom
	 * 		The number of rooms
	 * @param listOfRoom
	 * 		The tab containing the rooms
	 */
	public static void bookRoom(String username, String password, int nbRoom, int listOfRoom[][]) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Vous desirez reserver une chambre.");
		System.out.print("Veuillez entrer votre login : ");
		String usernameTest = sc.next();
		System.out.print("Veuillez entrer votre mot de passe : ");
		String passwordTest = sc.next();
		if (usernameTest.equals(username) && (passwordTest.equals(password))) {
			for (int i = 0; i< nbRoom ;i++) {
				if (listOfRoom[i][1] == 0) {	
					listOfRoom[i][1] = 1;
					System.out.println("La chambre " + listOfRoom[i][0] + " est reservee.");
					break;
				}
			}	
		}else {
			System.out.println("\nLogin ou mot de passe invalide.");
		}
		System.out.print("\nAppuyez sur entrer pour continuer...");
	}
	
	/**
	 * Releases the last available room. 
	 * Ask the login and password. If one of them is invalid, the room is not release 
	 * 
	 * @param username
	 * 		The stocked login
	 * @param password
	 * 		The stocked password
	 * @param nbRoom
	 * 		The number of rooms
	 * @param listOfRoom
	 * 		The tab containing the rooms
	 */
	public static void releaseRoom(String username, String password, int nbRoom, int listOfRoom[][]) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Vous desirez liberer la chambre.");
		System.out.print("Veuillez entrer votre login : ");
		String usernameTest = sc.next();
		System.out.print("Veuillez entrer votre mot de passe : ");
		String passwordTest = sc.next();
		if (usernameTest.equals(username) && (passwordTest.equals(password))) {
			int position = 0;
			for (int i = 0; i< nbRoom ;i++) {
				if (listOfRoom[i][1] == 1) {	
					position = listOfRoom[i][0];
				}
			}
			listOfRoom[position-1][1] = 0;
			System.out.println("La chambre " + position + " est liberee.");
			
		}else {
			System.out.println("\nLogin ou mot de passe invalide.");
		}
		System.out.print("\nAppuyez sur entrer pour continuer...");
	}
}
