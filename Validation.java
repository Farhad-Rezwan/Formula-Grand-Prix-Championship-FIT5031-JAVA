
/**
 * The validation class which validates information
 *
 * @author Farhad Ullah Rezwan
 * @version 1.0 (1.6.2019)
 */
public class Validation
{
    /**
     * Constructor for objects of class Validation
     */
    public Validation()
    {
    }

    /**
     * Method to check a double value which is within a range or not
     *
     * @param double a double number for which the check is done
     * @param max a double number which represents the maximum value for range
     * @param min a double number which represents the minimum value for range
     * @return a boolean value which indicates a double within range or not
     */
    public boolean doubleRange(double number, double max, double min)
    {
        if(number <= max && number >= min)
            return true;
        else
        {
            return false;
        }
    }
    
    /**
     * Method to check a double value which is within a range or not with error
     *
     * @param double a double number for which the check is done
     * @param max a double number which represents the maximum value for range
     * @param min a double number which represents the minimum value for range
     * @return a boolean value which indicates a double within range or not
     */
    public boolean doubleRangeWithError(double number, double max, double min)
    {
        if(number <= max && number >= min)
            return true;
        else
        {
            System.out.println("ERROR: " + "\"" + number + "\"" + " is invalid input, Must be within the range.");
            return false;
        }
    }
    
    /**
     * Method to check a number which is within a range or not
     *
     * @param number a number for which the check is done
     * @param max a number which represents the maximum value for range
     * @param min a number which represents the minimum value for range
     * @return a boolean value which indicates a number within range or not
     */
    public boolean numberRange(int number, int max, int min)
    {
        if(number <= max && number >= min)
            return true;
        else
        {
            return false;
        }
    }
    
    /**
     * Method to check a number which is within a range or not with error message
     *
     * @param number a number for which the check is done
     * @param max a number which represents the maximum value for range
     * @param min a number which represents the minimum value for range
     * @return a boolean value which indicates a number within range or not
     */
    public boolean numberRangeWithError(int number, int max, int min)
    {
        if(number <= max && number >= min)
            return true;
        else
        {
            System.out.println("ERROR: " + "\"" + number + "\"" + " is invalid input, Must be within the range.");
            return false;
        }
    }
    
    /**
     * Method to check a string is blank or not
     *
     * @param String a string for which the check is done
     * @return a boolean value to indicate a string is blank or not
     */
    public boolean stringIsBlank(String string)
    {
        if(string.trim().length() == string.length() && string.length() != 0)
        {
            return true;
        }
        else 
        {
            return false;
        }
    }
    
    /**
     * Method to check weather an integer included in an array or not
     *
     * @param x an integer for which the check is done
     * @param array an array for which the check is done
     * @return a boolean value to indicate a string is blank or not
     */
    public boolean hasIntInArray(int x, int[] array)
    {
        boolean y = false;
        for(int element : array)
        {    
            if(element == x)
                y = true;
        }
        return y;
    }
}