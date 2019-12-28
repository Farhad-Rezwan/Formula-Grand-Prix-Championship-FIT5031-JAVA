
/**
 * The Venue class handles each venue information
 *
 * @author Farhad Ullah Rezwan
 * @version 1.0 (1.6.2019)
 */
public class Venue
{
    private String venueName;
    private int noOfLaps;
    private int averageLapTime;
    private double chanceOfRain;

    /**
     * Constructor for objects of class Venue
     */
    public Venue()
    {
        venueName = "";
        noOfLaps = 0;
        averageLapTime = 0;
        chanceOfRain = 0.00;
    }
    
    /**
     * Non-Default constructor for objects of class Venue
     * 
     * @param newVanueName a string that indicates the name of a vanue
     * @param newNoOfLaps an integer that indicates the number of laps for a venue
     * @param newAverageLapTime an integer that indicates the average time of laps for a venue
     * @param newChanceOfRain a double that indicates the chance of rain for a venue
     */
    public Venue(String newVenueName, int newNoOfLaps, int newAverageLapTime,
                    double newChanceOfRain)
    {
        venueName = newVenueName;
        noOfLaps = newNoOfLaps;
        averageLapTime = newAverageLapTime;
        chanceOfRain = newChanceOfRain;
    }
    
    /**
     * A display method shows shows the informatios of a Venue
     * 
     * @return returns the state/information of a venue
     */
    public String displayVenue()
    {
        String state = "Name: " + venueName + "; N0. Laps: " + noOfLaps +
                        "; Avg time: " + averageLapTime + "; Rain Chance : " + chanceOfRain + ".";
        return state;
    }
    
    /**
     * An accessor method to get the average time of a vanue
     *
     * @return an integer that indicates the average time of a venue
     */
    public int getAverageLapTime()
    {
        return averageLapTime;
    }

    /**
     * An accessor method that returns the chance of rain in a venue
     *
     * @return a double that indicates the chacne of rain in a vanue  
     */
    public double getChanceOfRain()
    {
        return chanceOfRain;
    }

    /**
     * An accessor method that returns the number of laps for a venue
     *
     * @return an integer that indicates the number of laps for a vanue  
     */
    public int getNoOfLaps()
    {
        return noOfLaps;
    }

    /**
     * An accessor method that returns venue name
     *
     * @return a string that indicates the name of a vanue 
     */
    public String getVenueName()
    {
        return venueName;
    }
    
    /**
     * A mutator method to set the name of a vanue
     * 
     * @param newVanueName a string that indicates the name of a vanue
     */
    public void setVenueName(String newVenueName)
    { 
        venueName = newVenueName;
    }
    
    /**
     * A mutator method to set the number of laps for a venue
     * 
     * @param newNoOfLaps an integer that indicates the number of laps for a venue
     */
    public void setNoOfLaps(int newNoOfLaps)
    { 
        noOfLaps = newNoOfLaps;
    }
    
    /**
     * A mutator method to set the average lap time for a vanue
     * 
     * @param newAverageLapTime an integer that indicates the average time of laps for a venue
     */
    public void setAverageLapTime(int newAverageLapTime)
    { 
        averageLapTime = newAverageLapTime;
    }
    
    /**
     * A mutator method to set the chances of rain in a vanue
     * 
     * @param newChanceOfRain a double that indicates the chance of rain for a venue
     */
    public void setChanceOfRain(double newChanceOfRain)
    { 
        chanceOfRain = newChanceOfRain;
    }
    
}
