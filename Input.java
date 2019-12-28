import java.util.Scanner;
import java.io.*;
/**
 * The Input class helps to interact with the user/organizer of championship.
 *
 * @author Farhad Ullah Rezwan
 * @version 1.0 (1.6.2019)
 */
public class Input
{
    /**
     * Constructor for objects of class Input
     */
    public Input()
    {
    }
    
    /**
     * Method that helps to accept string input
     *
     * @param displayMessage message that is displayed in the screen
     * @return a string that user insert using keyboard
     */
    public String acceptStringInput(String displayMessage)
    {
        Scanner input = new Scanner(System.in);
        System.out.println(displayMessage);
        return input.nextLine();
    }
    
    /**
     * Method that helps to accept integer input
     *
     * @param displayMessage message that is displayed in the screen
     * @return an integer that user insert using keyboard
     */
    public int acceptIntegerInput(String displayMessage)
    {
        String tempOutput = "";
        int output = 0;
        boolean correct = false;
        
        Scanner input = new Scanner(System.in);
        
        while (correct == false)
        {
            try
            {
                System.out.println(displayMessage);
                tempOutput = input.nextLine();
                output = Integer.parseInt(tempOutput); 
                correct = true;
            }
            catch(Exception e)
            {
                System.out.println("Opps!!! you are supposed to enter a number");
                correct = false;
            }
        }
        return output;
    }
    
    public String acceptAnyInput(String displayMessage)
    {
        Scanner input = new Scanner(System.in);
        System.out.println(displayMessage);
        return input.nextLine();
    }
}
