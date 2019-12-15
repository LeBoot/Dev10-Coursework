package bl.classmodeling;

/**
 *
 * @author Boone
 */
public class Book1 {
    
    //properties
    private int numPages;
    private int numChapters;
    private String typeFont;
    private String nameAuthor;
    
    //constructor
    public Book1() {
        
    }
    
    //getters and setters

    public int getNumPages() {
        return numPages;
    }

    public void setNumPages(int numPages) {
        this.numPages = numPages;
    }

    public int getNumChapters() {
        return numChapters;
    }

    public void setNumChapters(int numChapters) {
        this.numChapters = numChapters;
    }

    public String getTypeFont() {
        return typeFont;
    }

    public void setTypeFont(String typeFont) {
        this.typeFont = typeFont;
    }

    public String getNameAuthor() {
        return nameAuthor;
    }

    public void setNameAuthor(String nameAuthor) {
        this.nameAuthor = nameAuthor;
    }
    
    //methods
    public void print() {
        System.out.println("The book is being printed.");
    }
    public void edit() {
        System.out.println("The book is being edited.");
    }
    public void distribute() {
        System.out.println("The book is being distributed.");
    }
}
