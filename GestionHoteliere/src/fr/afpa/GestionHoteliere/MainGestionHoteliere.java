package fr.afpa.GestionHoteliere;

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
	
}
