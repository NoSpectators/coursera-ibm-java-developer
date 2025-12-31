// Book class to represent a library book
public class Book {
    private String bookTitle;    
    private String author;
    private int publicationYear;
    private boolean isAvailable;

    public Book(String bookTitle, String author, int publicationYear) {
        this.bookTitle = bookTitle;
        this.author = author;
        this.publicationYear = publicationYear;
        this.isAvailable = true; // default value (when book is available, it's added)
    }
        
    public String getBookTitle() {
        return this.bookTitle;
    }
    public String getAuthor() {
        return this.author;
    }
    public int getPublicationYear() {
        return this.publicationYear;
    }
    public boolean getIsAvailable() {
        return this.isAvailable;
    }
    
    public boolean checkOut() {
        // case 1: book is available for checkout   
        if (this.isAvailable) { 
            this.isAvailable = false; // checkout the book 
            return true; // true = successful checkout  
	}
        // case 2: book is already checked out and therefore not available
        return false;
    }
    public boolean returnBook() {
        // case 1: the book is already checked out 
        if (!this.isAvailable) {
            this.isAvailable = true; 
            return true; // true = successful return   
	}
        // case 2: the book is already checked in (available)
        return false; 
    }
    @Override 
    public String toString() {
        return "Title: " + this.getBookTitle() + ", Author: " + this.getAuthor() + ", Year: " + this.getPublicationYear() +
               ", Status: " + this.getIsAvailable();
    }
}
