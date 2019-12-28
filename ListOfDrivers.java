import java.util.ArrayList;
/**
 * ListOfDrivers class stores an arraylist of Driver objects.
 *
 * @author Farhad Ullah Rezwan
 * @version 1.0 (1.6.2019)
 */
public class ListOfDrivers
{
    private ArrayList<Driver> drivers;

    /**
     * Constructor for objects of class ListOfDrivers
     */
    public ListOfDrivers()
    {
        drivers = new ArrayList<Driver>();
    }

    /**
     * Non-default constructor for objects of class ListOfDrivers
     * 
     * @param newDrivers a collection of drivers that holds one or more drivers
     */
    public ListOfDrivers(ArrayList<Driver> newDrivers)
    {
        drivers = newDrivers;
    }
    
    /**
     * Diaplays the details of all drivers for championship
     */
    public void displayListOfDrivers()
    {
        for (int index = 0; index < drivers.size(); index++)
        {
            System.out.print(index + 1 + ". ");
            System.out.println(drivers.get(index).displayDriver());
        }
    }
    
    /**
     * An accessor method that returns the collection of all drivers' information
     * 
     * @return an ArrayList that indicates the collection of all drivers
     */
    public ArrayList<Driver> getDrivers()
    {
        return drivers;
    }
    
    /**
     * An accessor method that returns a specific driver's information
     * 
     * @param index an integer that indicates the index of an ArrayList
     * @return an object of Driver class
     */
    public Driver getDrivers(int index)
    {
        return drivers.get(index);
    }
    
    /**
     * A method that helps to create a Driver's object providing appropriate informaiton
     * 
     * @param newName a string to indicate a driver's name
     * @param newRanking an integer to indicate a driver's ranking
     * @param newSpecialSkill a string to indicate a driver's special skill
     * @param newEligibleToRace a boolean value to indicate weather a driver is eligible to race or not
     * @param newAccumulatedScore an integer to indicate the accumulated socre for a driver
     * @param newAccumulatedTime an integer to indicate the accumulated time for a driver for each race
     */
    public void createDriver(String newName, int newRanking, String newSpecialSkill, 
                    boolean newEligibleToRace, int newAccumulatedScore, 
                    int newAccumulatedTime)
    {
        Driver oneDriver = new Driver(newName, newRanking, newSpecialSkill, newEligibleToRace, 
                                        newAccumulatedScore, newAccumulatedTime);
        setDrivers(oneDriver);
    }
    
    /**
     * A mutator method that appends a driver's information in the collection
     * 
     * @param an object of driver class that holds a driver's information
     */
    public void setDrivers(Driver newDriver)
    {
        drivers.add(newDriver);
    }
    
    /**
     * A mutator method that inserts a driver's information in a specified position(index) of the collection
     * 
     * @param an object of driver class that holds a driver's information
     */
    public void setDrivers(int index, Driver newDriver )
    {
        drivers.add(index, newDriver);
    }
    
    /**
     * A method that returns number of Driver's object
     * 
     * @return an integer value to indicate number of Driver's object
     */
    public int size()
    {
        return drivers.size();
    }
}
