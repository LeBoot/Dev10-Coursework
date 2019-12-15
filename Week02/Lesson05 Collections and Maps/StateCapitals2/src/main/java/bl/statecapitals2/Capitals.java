package bl.statecapitals2;

/**
 *
 * @author Boone
 */
public class Capitals {
    
    //properties
    private String name;
    private int population;
    private int squareMilage;

    //constructor
    public Capitals(String name, int population, int squareMilage) {
        this.name = name;
        this.population = population;
        this.squareMilage = squareMilage;
    }
    
    //getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public int getSquareMilage() {
        return squareMilage;
    }

    public void setSquareMilage(int squareMilage) {
        this.squareMilage = squareMilage;
    }
        
}
