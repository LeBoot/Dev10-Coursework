package bl.classmodeling;

/**
 *
 * @author Boone
 */
public class Book2 {
    
    //properties
    private double decimalLocation;
    private String genre;
    private String author;
    private boolean onShelf;
    
    //constructor
    public Book2() {
        
    }
    
    //getters and setters

    public double getDecimalLocation() {
        return decimalLocation;
    }

    public void setDecimalLocation(double decimalLocation) {
        this.decimalLocation = decimalLocation;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public boolean isOnShelf() {
        return onShelf;
    }

    public void setOnShelf(boolean onShelf) {
        this.onShelf = onShelf;
    }
    
    //methods
    public void checkOut() {
        System.out.println("You have checked out this book.");
    }
    public void returnBook() {
        System.out.println("You have returned the book.");
    }
}