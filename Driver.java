
/**
 * The Driver class handles driver information.
 *
 * @author Farhad Ullah Rezwan
 * @version 1.0 (1.6.2019)
 */
public class Driver
{
    private String name;
    private int ranking;
    private String specialSkill;
    private boolean eligibleToRace;
    private int accumulatedScore;
    private int accumulatedTime;

    /**
     * Constructor for objects of class Driver
     */
    public Driver()
    {
        name = "unknown";
        ranking = 0;
        specialSkill = "unknown";
        eligibleToRace = true;
        accumulatedScore = 0;
        accumulatedTime = 0;
    }
    
    /**
     * Non-Default Constructor for objects of class Driver
     * 
     * @param newName a string to indicate a driver's name
     * @param newRanking an integer to indicate a driver's ranking
     * @param newSpecialSkill a string to indicate a driver's special skill
     * @param newEligibleToRace a boolean value to indicate weather a driver is eligible to race or not
     * @param newAccumulatedScore an integer to indicate the accumulated socre for a driver
     * @param newAccumulatedTime an integer to indicate the accumulated time for a driver for each race
     */
    public Driver(String newName, int newRanking, String newSpecialSkill, 
                    boolean newEligibleToRace, int newAccumulatedScore, 
                    int newAccumulatedTime)
    {
        name = newName;
        ranking = newRanking;
        specialSkill = newSpecialSkill;
        eligibleToRace = newEligibleToRace;
        accumulatedScore = newAccumulatedScore;
        accumulatedTime = newAccumulatedTime;
    }

    /**
     * A display method for showing the sate of a driver
     * 
     * @return a drivers ovarall information
     */
    public String displayDriver()
    {
        String state = " " + name + ";\n      Rank: " + ranking +
                        "; Spec. Skill: " + specialSkill + "; Eligi. to Race: " + eligibleToRace +
                        ";\n      Acc. Score: " + accumulatedScore + "; Acc. Time: " + accumulatedTime + ".";
        return state;
    }
    
    /**
     * An accessor method to get the name of a driver
     * 
     * @return a string that indicates a driver's name
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * An accessor method to get the ranking of a driver
     * 
     * @return an integer that indicates a driver's ranking
     */
    public int getRanking()
    {
        return ranking;
    }
    
    /**
     * An accessor method to get the special skill of a driver
     *
     * @return a string that indicates a driver's special skill
     */
    public String getSpecialSkill()
    {
        return specialSkill;
    }
    
    /**
     * An accessor method to get the eligibility to race for a driver
     *
     * @return a boolean that indicates a driver's eligibility to race
     */
    public boolean getEligibleToRace()
    {
        return eligibleToRace;
    }
    
    /**
     * An accessor method to get the accumulated score of a driver
     * 
     * @return an integer that indicates a driver's accumulated score
     */
    public int getAccumulatedScore()
    {
        return accumulatedScore;
    }
    
    /**
     * An accessor method to get the accumulated score of a driver
     * 
     * @return an integer that indicates a driver's accumulated time
     */
    public int getAccumulatedTime()
    {
        return accumulatedTime;
    }
    
    /**
     * A mutator method to set a driver's name
     * 
     * @param newName a string to indicate a driver's name
     */
    public void setName(String newName)
    {
        name = newName;
    }
    
    /**
     * A mutator method to set a driver's ranking
     * 
     * @param newRanking an integer to indicate a driver's ranking
     */
    public void setRanking(int newRanking)
    {
        ranking = newRanking;
    }
    
    /**
     * A mutator method to set a driver's special skill
     * 
     * @param newSpecialSkill a string to indicate a driver's special skill
     */
    public void setSpecialSkill(String newSpecialSkill)
    {
        specialSkill = newSpecialSkill;
    }
    
    /**
     * A mutator method to set the eligibility for a driver to race
     * 
     * * @param newEligibleToRace a boolean value to indicate weather a driver is eligible for race or not
     */
    public void setEligibleToRace(boolean newEligibleToRace)
    {
        eligibleToRace = newEligibleToRace;
    }
    
    /**
     * A mutator method to show the accumulated score of a driver
     * 
     * @param newAccumulatedScore an integer to indicate the accumulated socre for a driver
     */
    public void setAccumulatedScore(int newAccumulatedScore)
    {
        accumulatedScore = newAccumulatedScore;
    }
    
    /**
     * A mutator method to show the accumulated score of a driver
     * 
     * @param newAccumulatedTime an integer to indicate the accumulated time for a driver for each race
     */
    public void setAccumulatedTime(int newAccumulatedTime)
    {
        accumulatedTime = newAccumulatedTime;
    }
    
}
