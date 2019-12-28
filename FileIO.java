import java.io.*;
import java.util.Scanner;
/**
 * The FileIO class helps to read and write from text files
 *
 * @author Farhad Ullah Rezwan
 * @version 1.0 (1.6.2019)
 */
public class FileIO
{
    private String filename;
    /**
     * Constructor for objects of class FileIO
     */
    public FileIO()
    {
        filename = "";
    }
    
    /**
     * Non-default constructor for objects of class FileIO
     */
    public FileIO(String newFileName)
    {
        filename = newFileName;
    }
    
    /**
     * Method to access the file name
     *
     * @return a string value that indicate a filename for read or write
     */
    public String getFileName()
    {
        return filename;
    }
    
    /**
     * Method to assign the file name
     *
     * @param newFileName a string that indicate a new filename to read
     */
    public void setFileName(String newFileName)
    {
        filename = newFileName;
    }
    
    /**
     * Method helps to read a file line by line
     *
     * @return a string which is read fro a text file
     */
    public String readFile()
    {
        String contents = "";
        if(filename.trim().length() > 0)
        {
            try
            {
                FileReader inputFile = new FileReader(filename);
                Scanner parser = new Scanner(inputFile);
                
                while(parser.hasNextLine())
                {
                    contents += parser.nextLine();
                    contents += "\n";
                }
                inputFile.close();
            }
            catch(IOException e)
            {                       
                System.out.println("I/O error Occur");
                System.out.println("File does not exist or corrupted");
            }
        }
        else 
        {
            System.out.println("Enter a correct filename");
        }
        return contents;
    }
    
    public void writeFile(String contents)
    {
        try
        {
            if(filename.trim().length() > 0)
            {
                PrintWriter output = new PrintWriter(filename);
                output.println(contents);
                output.close();
            }
            else
                System.out.println("Enter a filename");
        }
        catch(IOException e)
        {
            System.out.println("IO error occur");
        }
        
    }
}
