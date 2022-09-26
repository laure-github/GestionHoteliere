# GestionHoteliere: Programme permettant d'afficher un menu pour la gestion des réservations dans un hôtel de 20 chambres

On souhaite développer un programme qui permet la gestion des réservations de chambre pour un hôtel qui contient 20 chambres. Les fonctions à assurer sont :
-	Au lancement de notre programme, on crée une liste de chambres, qui sont réservées (1) ou libres (0) en utilisant la fonction randInt.
-	Afficher l’état de l’hôtel
-	Afficher le nombre de chambres réservées 
-	Afficher le nombre de chambres libres  
-	Afficher le numéro de la première chambre vide
-	Afficher le numéro de la dernière chambre vide
-	Réserver une chambre 
-	Libérer une chambre 

Pour cela, nous devons afficher le menu suivant à l’utilisateur de notre programme : 

-------------------------------    MENU HOTEL DWWM PHP   ------------------------------------------------
A-	Afficher l’état de l’hôtel 
B-	Afficher le nombre de chambres réservées
C-	Afficher le nombre de chambres libres
D-	Afficher le numéro de la première chambre vide
E-	Afficher le numéro de la dernière chambre vide
F-	Réserver une chambre (Le programme doit réserver la première chambre vide)
G-	Libérer une chambre (Le programme doit libérer la dernière chambre occupée)
Q- Quitter 
---------------------------------------------------------------------------------------------------------------------
Votre choix   : 

Règles métier
Le menu doit s’afficher en boucle tant que l’utilisateur n’a pas choisi l’option « Quitter ».
Les deux options « F et G » doivent être protégées par un login et mot de passe stockés dans des variables.
Pour réserver une chambre, le programme doit réserver la première chambre vide.
Pour libérer une chambre, le programme doit libérer la dernière chambre occupée.
