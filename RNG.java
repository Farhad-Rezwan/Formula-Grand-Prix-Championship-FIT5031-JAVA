
/**
 * The RNG class which generates random numbers for a given range
 *
 * @author Farhad Ullah Rezwan
 * @version 1.0 (1.6.2019)
 */
public class RNG
{   
    private int minimumValue;
    private int maximumValue;
    
    /**
     * The default constructor of RNG class, which creates a object of RNG class with
     * maximum value of 10 and minimum value of 1.
     */
    public RNG()
    {
        minimumValue = 1;
        maximumValue = 10;
    }
    
    /**
     * The non-default constructor of RNG class, which creates a object of RNG class with
     * when two integar values are provided.
     * 
     * @param newMinimumValue an integer that indicates maximum value
     * @param newMaximumValue an integer that indicates maximum value
     */
    public RNG(int newMinimumValue, int newMaximumValue)
    {
        minimumValue = newMinimumValue;
        maximumValue = newMaximumValue;
    }
    
    /**
     * displays a random number as a string
     * 
     * @return a String that returns the minimum value for random number
     */
    public String displayRNG()
    {
        String state = "Maximum value = " + getMaximumValue() + ". Minimum value = " +
                        getMinimumValue() + ". Random Number Generated: " + randomNumber();
        return state;
    }
    
    /**
     * returns maximum value of a RNG object
     * 
     * @return an integer that shows the maximum value for random number
     */
    public int getMaximumValue()
    {
        return maximumValue;
    }
    
    /**
     * This method returns minimum value of a RNG object
     * 
     * @return an integer that refers the minimum value for random number
     */
    public int getMinimumValue()
    {
        return minimumValue;
    }
    
    /**
     * Generates and returns random RNG number
     * 
     * @return an integer that is random for a given range
     */
    public int randomNumber()
    {
        int value = minimumValue + (int)(Math.random() * maximumValue);
        return value;
    }
    
    /**
     * stores a maximum value of a RNG object
     * 
     * @param newMaximumValue an integer that indicates maximum value
     */
    public void setMaximumValue(int newMaximumValue)
    {
        maximumValue = newMaximumValue;
    }
    
    /**
     * stores a minimum value of a RNG object
     * 
     * @param newMinimumValue an integer that indicates maximum value
     */
    public void setMinimumVlaue(int newMinimumValue)
    {
        minimumValue = newMinimumValue;
    }
    
}
