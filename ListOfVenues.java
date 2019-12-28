import java.util.ArrayList;
/**
 * ListOfVenues class stores an arraylist of Venue objects.
 *
 * @author Farhad Ullah Rezwan
 * @version 1.0 (1.6.2019)
 */
public class ListOfVenues
{
    private ArrayList<Venue> venues;
    
    /**
     * Constructor for objects of class ListOfVenues
     */
    public ListOfVenues()
    {
        venues = new ArrayList<Venue>();
    }

    /**
     * Non-default constructor for objects of class ListOfVenues
     * 
     * @param newVenues a collection of venues that holds one or more venues
     */
    public ListOfVenues(ArrayList<Venue> newVenues)
    {
        venues = newVenues;
    }
    
    /**
     * A method that helps to create a Venue's object providing appropriate informaiton
     * 
     * @param newVanueName a string that indicates the name of a vanue
     * @param newNoOfLaps an integer that indicates the number of laps for a venue
     * @param newAverageLapTime an integer that indicates the average time of laps for a venue
     * @param newChanceOfRain a double that indicates the chance of rain for a venue
     */
    public void createVenue(String newVenueName, int newNoOfLaps, int newAverageLapTime,
                    double newChanceOfRain)
    {
        Venue oneVenue = new Venue(newVenueName, newNoOfLaps, newAverageLapTime, 
                                        newChanceOfRain);
        setVenues(oneVenue);
    }
    
    /**
     * Diaplays the details of all venues for championship
     */
    public void displayListOfVenues()
    {
        for (int index = 0; index < venues.size(); index++)
        {
            System.out.print(index + 1 + ". ");
            System.out.println(venues.get(index).displayVenue());
        }
    }
    
    /**
     * An accessor method that returns the collection of all venues' information
     * 
     * @return an ArrayList that indicates the collection of all venues
     */
    public ArrayList<Venue> getVenues()
    {
        return venues;
    }
    
    /**
     * An accessor method that returns a specific venue's information
     * 
     * @param index an integer that indicates the index of an ArrayList
     * @return an object of Venue class
     */
    public Venue getVenues(int index)
    {
        return venues.get(index);
    }
    
    /**
     * A mutator method that appends a venues's information in the collection
     * 
     * @param an object of Venue class that holds a particular venue's information
     */
    public void setVenues(Venue newVenue)
    {
        venues.add(newVenue);
    }
    
    /**
     * A mutator method that inserts a venuer's information in a specified position(index) of the collection
     * 
     * @param an object of Venue class that holds a particular venue's information
     */
    public void setVenues(int index, Venue newVenue)
    {
        venues.add(index, newVenue);
    }
    
    public int size()
    {
        return venues.size();
    }
}
