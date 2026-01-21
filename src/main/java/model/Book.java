package model;

import structure.BorrowingHistory;

public class Book {
    private String title;
    private String author;
    private String isbn;
    private int publicationYear;
    private String genre;

    private BorrowingHistory history = new BorrowingHistory();

    public Book(String title, String author, String isbn, int publicationYear, String genre) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.publicationYear = publicationYear;
        this.genre = genre;
    }

    // Accesseurs
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getIsbn() { return isbn; }
    public int getPublicationYear() { return publicationYear; }
    public String getGenre() { return genre; }
    public BorrowingHistory getHistory() { return history; }

    // Modificateurs
    public void setTitle(String title) { this.title = title; }
    public void setAuthor(String author) { this.author = author; }
    public void setIsbn(String isbn) { this.isbn = isbn; }
    public void setPublicationYear(int year) { this.publicationYear = year; }
    public void setGenre(String genre) { this.genre = genre; }
}
