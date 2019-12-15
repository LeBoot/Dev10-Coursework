package bl.classmodeling;

/**
 *
 * @author Boone
 */
public class Airplane2 {
    
    //properties
    private int roundInSim;
    private String userName;
    private String userType;
    private int minutesInSim;
    private int programNum;
    
    //constructor
    public Airplane2() {
        
    }
    
    //getters and setters

    public int getRoundInSim() {
        return roundInSim;
    }

    public void setRoundInSim(int roundInSim) {
        this.roundInSim = roundInSim;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public int getMinutesInSim() {
        return minutesInSim;
    }

    public void setMinutesInSim(int minutesInSim) {
        this.minutesInSim = minutesInSim;
    }

    public int getProgramNum() {
        return programNum;
    }

    public void setProgramNum(int programNum) {
        this.programNum = programNum;
    }
    
    //methods
    public void isSimRunning(boolean isSimRunning) {
        if (isSimRunning) {
            System.out.println("The simulator is running.");
        } else {
            System.out.println("The simulator is not running.");
        }
    }
    
}
