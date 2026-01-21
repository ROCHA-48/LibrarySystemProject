package service;

import model.Book;

public class LibraryManager {
    private Book[] books = new Book[100];
    private int count = 0;

    // Ajouter un livre
    public void addBook(Book book) {
        books[count++] = book;
    }

    // Supprimer un livre par ISBN
    public boolean removeBook(String isbn) {
        for (int i = 0; i < count; i++) {
            if (books[i].getIsbn().equalsIgnoreCase(isbn)) {
                for (int j = i; j < count - 1; j++) {
                    books[j] = books[j + 1];
                }
                books[--count] = null;
                return true;
            }
        }
        return false;
    }

    // Mettre à jour un livre par ISBN
    public boolean updateBook(String isbn, Book updated) {
        for (int i = 0; i < count; i++) {
            if (books[i].getIsbn().equalsIgnoreCase(isbn)) {
                books[i] = updated;
                return true;
            }
        }
        return false;
    }

    // Afficher les livres
    public void displayBooks() {
        for (int i = 0; i < count; i++) {
            System.out.println(books[i].getTitle() + " | " +
                    books[i].getAuthor() + " | " +
                    books[i].getIsbn() + " | " +
                    books[i].getPublicationYear() + " | " +
                    books[i].getGenre());
        }
    }

    // Recherche linéaire
    public Book linearSearchByTitle(String title) {
        for (int i = 0; i < count; i++) {
            if (books[i].getTitle().equalsIgnoreCase(title)) return books[i];
        }
        return null;
    }

    public Book linearSearchByAuthor(String author) {
        for (int i = 0; i < count; i++) {
            if (books[i].getAuthor().equalsIgnoreCase(author)) return books[i];
        }
        return null;
    }

    public Book linearSearchByIsbn(String isbn) {
        for (int i = 0; i < count; i++) {
            if (books[i].getIsbn().equalsIgnoreCase(isbn)) return books[i];
        }
        return null;
    }

    // Recherche binaire (tableau trié par titre)
    public Book binarySearchByTitle(String title) {
        int left = 0, right = count - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int cmp = books[mid].getTitle().compareToIgnoreCase(title);
            if (cmp == 0) return books[mid];
            else if (cmp < 0) left = mid + 1;
            else right = mid - 1;
        }
        return null;
    }

    // Tri à bulles
    public void bubbleSortByTitle() {
        for (int i = 0; i < count - 1; i++) {
            for (int j = 0; j < count - i - 1; j++) {
                if (books[j].getTitle().compareToIgnoreCase(books[j + 1].getTitle()) > 0) {
                    Book temp = books[j]; books[j] = books[j + 1]; books[j + 1] = temp;
                }
            }
        }
    }

    // Tri par sélection
    public void selectionSortByAuthor() {
        for (int i = 0; i < count - 1; i++) {
            int min = i;
            for (int j = i + 1; j < count; j++) {
                if (books[j].getAuthor().compareToIgnoreCase(books[min].getAuthor()) < 0) min = j;
            }
            Book temp = books[i]; books[i] = books[min]; books[min] = temp;
        }
    }

    // Tri rapide (QuickSort) par année
    public void quickSortByYear() { quickSort(0, count - 1); }
    private void quickSort(int low, int high) {
        if (low < high) {
            int pi = partition(low, high);
            quickSort(low, pi - 1);
            quickSort(pi + 1, high);
        }
    }
    private int partition(int low, int high) {
        int pivot = books[high].getPublicationYear();
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (books[j].getPublicationYear() <= pivot) {
                i++;
                Book temp = books[i]; books[i] = books[j]; books[j] = temp;
            }
        }
        Book temp = books[i + 1]; books[i + 1] = books[high]; books[high] = temp;
        return i + 1;
    }
}
