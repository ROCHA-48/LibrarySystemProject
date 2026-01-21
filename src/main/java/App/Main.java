package App;

import java.util.Scanner;
import model.Book;
import service.LibraryManager;
import structure.ActivityStack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LibraryManager manager = new LibraryManager();
        ActivityStack activity = new ActivityStack();

        boolean running = true;
        while (running) {
            System.out.println("\n--- Menu Bibliothèque ---");
            System.out.println("1. Ajouter un livre");
            System.out.println("2. Supprimer un livre");
            System.out.println("3. Mettre à jour un livre");
            System.out.println("4. Afficher tous les livres");
            System.out.println("5. Recherche linéaire");
            System.out.println("6. Recherche binaire");
            System.out.println("7. Tri livres");
            System.out.println("8. Afficher activités récentes");
            System.out.println("0. Quitter");
            System.out.print("Choix : ");

            int choice = sc.nextInt();
            sc.nextLine(); // Consommer le saut de ligne

            switch (choice) {
                case 1:
                    System.out.print("Titre : "); String t = sc.nextLine();
                    System.out.print("Auteur : "); String a = sc.nextLine();
                    System.out.print("ISBN : "); String i = sc.nextLine();
                    System.out.print("Année : "); int y = sc.nextInt(); sc.nextLine();
                    System.out.print("Genre : "); String g = sc.nextLine();
                    manager.addBook(new Book(t, a, i, y, g));
                    activity.push("Ajout du livre : " + t);
                    break;
                case 2:
                    System.out.print("ISBN du livre à supprimer : "); String isbn = sc.nextLine();
                    if(manager.removeBook(isbn)) activity.push("Suppression du livre : " + isbn);
                    else System.out.println("Livre non trouvé !");
                    break;
                case 3:
                    System.out.print("ISBN du livre à mettre à jour : "); String uIsbn = sc.nextLine();
                    System.out.print("Nouveau titre : "); String ut = sc.nextLine();
                    System.out.print("Nouvel auteur : "); String ua = sc.nextLine();
                    System.out.print("Nouvel ISBN : "); String ui = sc.nextLine();
                    System.out.print("Nouvelle année : "); int uy = sc.nextInt(); sc.nextLine();
                    System.out.print("Nouveau genre : "); String ug = sc.nextLine();
                    if(manager.updateBook(uIsbn, new Book(ut, ua, ui, uy, ug))) activity.push("Mise à jour du livre : " + ut);
                    else System.out.println("Livre non trouvé !");
                    break;
                case 4:
                    manager.displayBooks();
                    break;
                case 5:
                    System.out.print("Recherche linéaire par (titre/auteur/isbn) : "); String field = sc.nextLine();
                    System.out.print("Valeur : "); String val = sc.nextLine();
                    Book found = null;
                    if(field.equalsIgnoreCase("titre")) found = manager.linearSearchByTitle(val);
                    else if(field.equalsIgnoreCase("auteur")) found = manager.linearSearchByAuthor(val);
                    else if(field.equalsIgnoreCase("isbn")) found = manager.linearSearchByIsbn(val);
                    if(found != null) {
                        System.out.println("Livre trouvé : " + found.getTitle());
                        activity.push("Recherche linéaire : " + val);
                    } else System.out.println("Livre non trouvé !");
                    break;
                case 6:
                    manager.bubbleSortByTitle();
                    System.out.print("Titre à rechercher (binaire) : "); String bval = sc.nextLine();
                    Book bf = manager.binarySearchByTitle(bval);
                    if(bf != null) {
                        System.out.println("Livre trouvé : " + bf.getTitle());
                        activity.push("Recherche binaire : " + bval);
                    } else System.out.println("Livre non trouvé !");
                    break;
                case 7:
                    System.out.println("1. Tri bulles par titre\n2. Tri sélection par auteur\n3. Tri rapide par année");
                    System.out.print("Choix : "); int tChoice = sc.nextInt(); sc.nextLine();
                    if(tChoice == 1) manager.bubbleSortByTitle();
                    else if(tChoice == 2) manager.selectionSortByAuthor();
                    else if(tChoice == 3) manager.quickSortByYear();
                    activity.push("Tri effectué : option " + tChoice);
                    break;
                case 8:
                    activity.display();
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Choix invalide !");
            }
        }

        sc.close();
    }
}
