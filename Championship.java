import java.util.Scanner;
import java.util.ArrayList;
/**
 * The Championship class manages the ovarall race
 *
 * @author Farhad Ullah Rezwan
 * @version 1.0 (1.6.2019)
 */
public class Championship
{
    private ListOfDrivers drivers;
    private ListOfVenues venues;
    /**
     * Constructor for objects of class Championship
     */
    public Championship()
    {
        drivers = new ListOfDrivers();
        venues = new ListOfVenues();
    }

    /**
     * Non-default constructor for objects of class Championship
     * 
     * @param newDrivers helps to set new driver list into the championship
     * @param newVenues helps to set new venue list into the championship
     */
    public Championship(ListOfDrivers newDrivers, ListOfVenues newVenues)
    {
        drivers = newDrivers;
        venues = newVenues;
    }
    
    /**
     * helps to assign penalty for races as per ranks
     * 
     * @return returns an integer which represents the time penalty for a rank
     */
    
    public int assignPenaltyForRace(int newRank)
    {
        int penalty = 0;
        switch (newRank)
        {
            case 1: penalty = 0; break;
            case 2: penalty = 3; break;
            case 3: penalty = 5; break;
            case 4: penalty = 7; break;
            default:
                penalty = 10; break;
        }
        return penalty;
    }
    
    /**
     * This method assigns points for each venu races after the sort is done for
     * drivers by accumulated total time for a venue.
     */
    public void assignPointsForARace()
    {
        Input input = new Input();
        RNG random = new RNG(1,2);
        int[] points = new int [6];
        points[0] = 8;
        points[1] = 5;
        points[2] = 3;
        points[3] = 1;
        points[4] = 0;
        points[5] = 0; 
        for(int index = 0; index < 4; index++)
        {
            if(drivers.getDrivers(index).getAccumulatedTime() != drivers.getDrivers(index + 1).getAccumulatedTime())
            {
                drivers.getDrivers(index).setAccumulatedScore(drivers.getDrivers(index).getAccumulatedScore() + 
                                                                    (points[index]));
            }
            else
            {
                System.out.println(drivers.getDrivers(index).getName() + " and " + drivers.getDrivers(index + 1).getName() +
                                        " have same accumulated time for the venue, so the position " + (index + 1) + 
                                        " is randomly generating now...");
                input.acceptAnyInput("Press enter to Assign now,");
                if(random.randomNumber() == 1)
                {
                    System.out.println("Seems like " + drivers.getDrivers(index).getName() + " is the luckier one");
                    drivers.getDrivers(index).setAccumulatedScore(drivers.getDrivers(index).getAccumulatedScore()  
                                                                  + points[index]);
                    drivers.getDrivers(index + 1).setAccumulatedScore(drivers.getDrivers(index +1).getAccumulatedScore() 
                                                                            + points[index + 1]);
                    index++;
                }
                else
                {
                    System.out.println("Seems like " + drivers.getDrivers(index + 1).getName() + " is the luckier one");
                    drivers.getDrivers(index + 1).setAccumulatedScore(drivers.getDrivers(index +1).getAccumulatedScore() 
                                                        + points[index]);
                    drivers.getDrivers(index).setAccumulatedScore(drivers.getDrivers(index +1).getAccumulatedScore() 
                                                                    + points[index + 1]);
                    index++;
                }
            }
            
            System.out.println(drivers.getDrivers(index).getName() + " got " + points[index] + " points");
            
            
        }
        input.acceptAnyInput("Press enter > next step,");
    }
    
    
    /**
     * Assigns random time penalty for the faults in the game
     * 
     * @param driverIndex an integer that represents a driver's index number.
     * @return an intager which represents time penalty as per major or minor fault.
     */
    public int assignRandomEventTimePenalty(int driverIndex)
    {
        RNG random = new RNG(1,100);
        int randomEventPercentage = random.randomNumber();
        int penalty = 0;
        
        if (randomEventPercentage <=5) //minor fault
        {
            penalty = 20;
            System.out.println(drivers.getDrivers(driverIndex).getName() + " has faced a minor fault, 20 seconds is added in his time");
        }
        
        if (randomEventPercentage > 5 && randomEventPercentage <= 8) //major
        {
            penalty = 120;
            System.out.println(drivers.getDrivers(driverIndex).getName() + " has faced a major fault, 120 seconds is added in his time");
        }
    
        if (randomEventPercentage == 9) //uncoverable fault
        {
            System.out.println(drivers.getDrivers(driverIndex).getName() + " has faced an uncoverable mechanical fault, and is out of the race");
            drivers.getDrivers(driverIndex).setEligibleToRace(false);
            penalty = 10001;
        }
        
        return penalty;
    }
    /**
     * This method helps to generate the special skill benefit in second for the a particular driver
     * using random number and in accordance with lap number.
     * 
     * @param indexNoLap an integer that represents the index number for.
     * @param driverIndex an integer value that represents the index numbur for the driver.
     * @return returns an integer value which represent second which will be deducted from the drivers lap time
     */
    public int assignSpecialSkillBenefit(int indexNoLap, int driverIndex)
    {
        int benefit = 0;
        if (drivers.getDrivers(driverIndex).getSpecialSkill().trim().equalsIgnoreCase("Braking"))
        {
            RNG randomA = new RNG(1,8);
            int randomSecA = randomA.randomNumber();
            benefit = randomSecA;
            System.out.println(" braking skill applied for the driver, finished the lap " + randomSecA+ " seconds earlier");
        }
        
        if (drivers.getDrivers(driverIndex).getSpecialSkill().trim().equalsIgnoreCase("Cornering"))
        {
            RNG randomB = new RNG(1,8);
            int randomSecB = randomB.randomNumber();
            benefit = randomSecB;
            System.out.println(" Cornering skill applied for the driver, finished the lap " + randomSecB+ " seconds earlier");
        }
        
        if (drivers.getDrivers(driverIndex).getSpecialSkill().trim().equalsIgnoreCase("Overtaking") && (indexNoLap + 1) % 3 == 0)
        {
            RNG randomC = new RNG(1,11);
            int randomSecC = randomC.randomNumber() + 9;
            benefit = randomSecC;
            System.out.println(" Overtaking skill applied for the driver, finished the lap " + randomSecC+ " seconds earlier");
        }
        return benefit;
    }
    
    /**
     * This method interacts with the organiser and helps to generate number of races
     * at the begaining of championship
     * 
     * @return an integer value that indicate number of races for the championship
     */
    public int countRaces()
    {
        int totalRaces = 0;
        boolean proceed = false;
        
        Input objectInput = new Input();
        Validation validate = new Validation();
        
        
        while(proceed == false)
        {
            totalRaces = objectInput.acceptIntegerInput("Please enter the number of races to be played" +
                                                        " for championship \n (between 3 and 5): ");
            if(validate.numberRangeWithError(totalRaces, 5, 3))
                proceed = true;
            else
                proceed = false;
        }
        return totalRaces;
    }
    
    /**
     * An accessor method to get the list of drivers for the championship
     *
     * @return list of drivers for the championship
     */
    public ListOfDrivers getDrivers()
    {
        return drivers;
    }
    
    /**
     * An accessor method to get the list of venues for the championship
     * 
     * @return list of venues for the championship
     */
    public ListOfVenues getVenues()
    {
        return venues;
    }
    
    /**
     * Mehotd to sort the drivers in accordence to the ranking
     * 
     * @return an array list of drivers which are temporary, sorted drivers list
     */
    public ListOfDrivers sortForGridDrivers()
    {
        ListOfDrivers tempDrivers = new ListOfDrivers();
        while (drivers.size() != 0)
        {
            if(drivers.size() != 0)
            {
                int index = 0;
                int[] rankingIndexes = new int [drivers.size()];
                
                for (int x = 0; x < drivers.size(); x++)
                {
                    rankingIndexes[x] = drivers.getDrivers(index).getRanking();
                    index++;
                }
                
                int totalDrivers = drivers.size();
                int smallest = rankingIndexes[0]; // java.lang.ArrayIndexOutOfBoundsException
                for (int y = 1; y < totalDrivers; y++)
                {
                    if (rankingIndexes[y] < smallest)
                    {
                        smallest = rankingIndexes[y];
                        totalDrivers--;
                    }
                }
            
                for (int z = 0; z < drivers.size(); z++)
                {
                    if (drivers.getDrivers(z).getRanking() == smallest)
                    {
                        tempDrivers.setDrivers(drivers.getDrivers(z));
                        drivers.getDrivers().remove(z);
                    }
                }
            }
        }
        return tempDrivers;
    }
    
    /**
     * helps to interact with organizer for selecting venues
     * 
     * @return an arry of integer that represents the selected venues index numbers;
     */
    public int[] selectVenues(int howMany)
    {
        Input select = new Input();
        Validation valid = new Validation();
        int[] number = new int[howMany];
        boolean x = false;
        while(!x)
        {
            System.out.println();
            int temp = select.acceptIntegerInput("Select first vanue (Enter number):");
            if(valid.numberRange(temp, venues.size(), 1))
            {
                number[0] = temp;
                x = true;
            }
            else
            {
                System.out.println("Oops!!! there is no venue with this number, choose again");
                x = false;
            }
        }
        
        for(int count = 1; count < howMany; count++)
        {
            boolean y = false;
            while(!y)
            {   System.out.println();
                int temp2 = select.acceptIntegerInput("Select venue number " + (count + 1) + "(Enter number):");
                if(!valid.hasIntInArray(temp2, number))
                {
                    if(valid.numberRange(temp2, venues.size(), 1))
                    {
                        number[count] = temp2;
                        y = true;
                    }
                    else
                    {
                        System.out.println("Oops!!! there is no venue with this number, choose again");
                        y = false;
                    }
                }
                else
                {
                    if(temp2 == 0)
                        System.out.println("Oops!!! there is no venue with this number, choose again");
                    else
                        System.out.println("Oops!!! you already choosen this, select different!");
                    y = false;
                }
            }
        }
        
        for(int count2 = 0; count2 < howMany; count2++)
        {
            number[count2] -= 1;
        }
        return number;
    }
    
    /**
     * This method helps to display grid position
     */
    public void showGridPositions()
    {
        showLineWithIcons(79, "*"); 
        showLineForHeader(80, "GRID POSITION");
        showLineWithIcons(79, "*"); 
        System.out.println();
        drivers.displayListOfDrivers();
    }
    
    /**
     * This method helps to show the selected venues from the users
     * 
     * @param newSelectedVenues a arraylist of integer that represents the index of selected venues
     */
    void showSelectedVenues(int[] newSelectedVenues)
    {
        System.out.println();
        showLineWithIcons(79, "*"); 
        String a = ("-Choosen Venues for Formula 9131 Grand Prix Championship this Season-");
        String b = ("| V# | (no of laps) | (avarage lap time) | (chanse of rain) |");
        showLineForHeader(80, a);
        showLineForHeader(80, b);
        for(int index = 0; index < newSelectedVenues.length; index++)
        {
            showLineWithIcons(79, "~"); 
            String c = ( "--- " + (venues.getVenues(newSelectedVenues[index]).getVenueName() + " ---"));
            String d = (("| " + (newSelectedVenues[index] + 1) + "."));
            String e = (" " + "| ( " + 
                                venues.getVenues(newSelectedVenues[index]).getNoOfLaps() + " rounds ) |");
            String f = (" " + "  ( " + 
                                venues.getVenues(newSelectedVenues[index]).getAverageLapTime() + " seconds )   |");
            String g = (" " + "    ( " + 
                                venues.getVenues(newSelectedVenues[index]).getChanceOfRain() + " )     |");
            String h = d + e + f + g;
            showLineForHeader(80, c);
            showLineForHeader(80, h);
        }
        showLineWithIcons(79, "*");
        System.out.println();
        System.out.println();
    }
    
    /**
     * This method helps to hold the venues that the organisers selected for the championship
     * 
     * @return An array list of venues which are applicable for the championships
     * 
     * @param newSelectedVenues represents an array that shows selected indexes of venues
     */
    public ListOfVenues userSelectedVenues(int[] newSelectedVenues)
    {
        ListOfVenues tempVenues = new ListOfVenues();
        for(int index = 0; index < newSelectedVenues.length; index++)
        {
            tempVenues.setVenues(venues.getVenues(newSelectedVenues[index]));
        }
        
        return tempVenues;
    }
    
    
    
    
    /**
     * read driver file has to be once otherwise the driver number will be appended
     */
    public void readDriverFile()
    {
        int countError = 0;
        Validation valid = new Validation();
        FileIO driversInfo = new FileIO("drivers.txt");
        String[] driverInfoString = driversInfo.readFile().split("\\n");
        
        for(int count = 0; count < driverInfoString.length; count++)
        {
            try
            {
                String[] oneDriverInfo = driverInfoString[count].split(",");
                if(valid.stringIsBlank(oneDriverInfo[0]))
                {    
                    if(oneDriverInfo[2].trim().equalsIgnoreCase("Braking") || 
                        oneDriverInfo[2].trim().equalsIgnoreCase("Cornering") ||
                        oneDriverInfo[2].trim().equalsIgnoreCase("Overtaking"))
                    {   
                        if(valid.numberRange(Integer.parseInt(oneDriverInfo[1]),1000,0))
                        {
                            drivers.createDriver(oneDriverInfo[0], Integer.parseInt(oneDriverInfo[1]), 
                                                    oneDriverInfo[2],true, 0, 0);
                        }
                        else
                        {    
                            System.out.println("ERROR: (driver's information: " + driverInfoString[count] + ")");
                            System.out.println("    Driver ranking has to be a valid number");
                            countError++;
                        }
                    }
                    else
                    {
                        System.out.println("ERROR: (driver's information: " + driverInfoString[count] + ")");
                            System.out.println("    Driver must have one of these skills (Braking/Cornering/Overtaking)");
                        countError++;
                    }        
                }
                else
                {
                    System.out.println("ERROR: (driver's information: " + driverInfoString[count] + ")");
                    System.out.println("    Driver name cannot be blank");
                    countError++;
                }
            }
            catch (Exception e)
            {
                countError++;
                System.out.println("ERROR: (driver's information: " + driverInfoString[count] + ")");
                System.out.println("    This driver's information has exception error");
            }
        }
        
        if(countError > 0)
            if((driverInfoString.length - countError) >= 2)
            {
                System.out.println();
                System.out.println("Some driver's information in drivers.txt file is incorrect.");
                System.out.println("However, the program will still run with drivers whose information \n" + 
                                "  is correctly saved in the file");
            }
            else
            {
                System.out.println();
                System.out.println("Most of the driver's information in the file is incorrect, \n" +
                                        "   game cannot be proceed with one driver");
            }
        else
            {
                System.out.println("Drivers' information is successfully loaded for the championship");
            }
        drivers.displayListOfDrivers();
    }
    
    /**
     * read driver file has to be once otherwise the driver number will be appended
     */
    public void readVenueFile()
    {
        int countError = 0;
        Validation valid = new Validation();
        FileIO venuesInfo = new FileIO("venues.txt");
        String[] venuesInfoString = venuesInfo.readFile().split("\\n");
        
        for(int count = 0; count < venuesInfoString.length; count++)
        {
            try
            {
                String[] oneVenueInfo = venuesInfoString[count].split(",");
                if(valid.stringIsBlank(oneVenueInfo[0]))
                {    
                    if(valid.numberRange(Integer.parseInt(oneVenueInfo[1]),1000,0))
                    {
                        if(valid.numberRange(Integer.parseInt(oneVenueInfo[2]),90,60))
                        {
                            if(valid.doubleRange(Double.parseDouble(oneVenueInfo[3]),1.00,00.00))
                            {
                                venues.createVenue(oneVenueInfo[0], Integer.parseInt(oneVenueInfo[1]), 
                                                    Integer.parseInt(oneVenueInfo[2]), Double.parseDouble(oneVenueInfo[3]));
                            }
                            else
                            {
                                System.out.println("ERROR: (Venue's information: " + venuesInfoString[count] + ")");
                                System.out.println("    Venue chance of rain has to be a double betwen 0.00 and 100.00");
                                countError++;
                            }
                        }
                        else
                        {
                            System.out.println("ERROR: (Venue's information: " + venuesInfoString[count] + ")");
                            System.out.println("    Venue average lap time has to be a number betwen 60 and 90");
                            countError++;
                        }
                    }
                    else
                    {    
                        System.out.println("ERROR: (Venue's information: " + venuesInfoString[count] + ")");
                        System.out.println("    Venue number of laps has to be a valid number");
                        countError++;
                    }  
                }
                else
                {
                    System.out.println("ERROR: (vanue's information: " + venuesInfoString[count] + ")");
                    System.out.println("    Venue name cannot be blank");
                    countError++;
                }
            }
            catch (Exception e)
            {
                countError++;
                System.out.println("ERROR: (Venue's information: " + venuesInfoString[count] + ")");
                System.out.println("    This venue's information has exception error");
            }
        }
        
        if(countError > 0)
            if((venuesInfoString.length - countError) >= 3)
            {
                System.out.println();
                System.out.println("Some venue's information in venues.txt file is incorrect.");
                System.out.println("However, the program will still run with venues whose information \n" + 
                                "   is correctly saved in the file");
            }
            else
            {
                System.out.println();
                System.out.println("Most of the venue's information in venue.txt file is incorrect, \n" +
                                        "   game cannot be proceed with less then three venues");
            }
        else
            {
                System.out.println("Venues' information is successfully loaded for the championship");
            }
        venues.displayListOfVenues();
    }
    
    /**
     * This method runs to manage each laps, displays the drivers lap time summary assigning penalty for grid position, and random event
     * and benefit for special skills, and displays the lap leading position summary.
     * 
     * @param newVenueLaps an integer value represents how many laps are there for the venue
     * @param newVenueAvgT an integer value represents average time for a venue
     * @param newVenueChRain a double that represents chances of rain for a venue
     * 
     */
    public void raceForLaps(int newVenueLaps, int newVenueAvgT, double newVenueChRain)
    {
        Input ip = new Input();
        Scanner input = new Scanner(System.in);
        System.out.println();
        System.out.println("VRMMM>>>>> VRMMMMM>>>>>>> VRMMM>>>>>>>>>");
        System.out.println(">>>>>>>>>>>Race Just Started>>>>>>>>>>>>");
        ip.acceptAnyInput("Press enter to witness the race.");
        for(int lapIndex = 0; lapIndex < newVenueLaps; lapIndex++)
        {
            int[] lapTime = new int [drivers.size()];
            showLineWithIcons(79, "~");
            String a = ("........Lap number " + (lapIndex + 1) + " out of " + newVenueLaps + ".........");
            showLineForHeader(80, a);
            showLineWithIcons(79, "~");
            System.out.println("\n");
            if (lapIndex == 0)
            {
                for (int dNo = 0; dNo < drivers.size(); dNo++)
                {
                    int rank = drivers.getDrivers(dNo).getRanking();
                    lapTime[dNo] = assignPenaltyForRace(rank);
                }
            }
            
            for (int dNo = 0; dNo < drivers.size(); dNo++)
            {
                lapTime[dNo] = lapTime[dNo] + newVenueAvgT;
            }
            
            for (int dNo = 0; dNo < drivers.size(); dNo++)
            {
                String b =(drivers.getDrivers(dNo).getName());
                showLineForHeader(80, b);
                if(drivers.getDrivers(dNo).getEligibleToRace())
                {
                    lapTime[dNo] = lapTime[dNo] + assignRandomEventTimePenalty(dNo); // false hoyle ki korbo???
                    if(drivers.getDrivers(dNo).getEligibleToRace())
                    {
                        lapTime[dNo] = lapTime[dNo] - assignSpecialSkillBenefit(lapIndex, dNo);
                        System.out.print("Total Lap Time for Driver is:   ");
                        System.out.println(lapTime[dNo]);
                        System.out.println();
                        if((dNo + 1) != drivers.size())
                        {
                            System.out.println("Press Enter  > Next Player");
                            input.nextLine();
                        }
                    }
                    else
                    {
                        if((dNo + 1) != drivers.size())
                        {
                            System.out.println("Press Enter  > Next Player");
                            input.nextLine();
                        }
                    }
                }
                else
                {
                    System.out.print(drivers.getDrivers(dNo).getName());
                    System.out.println(" Is out of race");
                    if((dNo + 1) != drivers.size())
                    {
                        System.out.println("Press Enter  > Next Player");
                        input.nextLine();
                    }
                }
            }
            
            System.out.println();
            System.out.println();
            ip.acceptAnyInput("Enter to see leading positions for this lap");
            showLineWithIcons(79, "~");
            String x = ("........Leading Position for lap : " + (lapIndex + 1) + "........");
            showLineForHeader(80, x);
            showLineWithIcons(79, "~");
            
            int lapPlayerPosition = 0;
            for(int z = 0; z < 10000; z++)
            {
                Validation valid = new Validation();
                if(valid.hasIntInArray(z, lapTime))
                {
                    lapPlayerPosition++;
                    System.out.println("position: " + lapPlayerPosition);
                    int dNo;
                    do
                    {
                        for(dNo = 0; dNo < drivers.size(); dNo++)
                        {
                            if(z == lapTime[dNo])
                            {
                                System.out.print("    " + drivers.getDrivers(dNo).getName());
                                System.out.println(" with " + lapTime[dNo] + " second Laptime ");
                            }
                            
                        }
                    }while(dNo == (drivers.size() -1 ));
                }
            }
            
            if ((lapIndex + 1) !=  newVenueLaps)
            {
                System.out.println("");
                System.out.println("Press enter to begin lap No: " + (lapIndex + 2) + "");
                input.nextLine();
                for (int dNo = 0; dNo < drivers.size(); dNo++)
                {
                    drivers.getDrivers(dNo).setAccumulatedTime(drivers.getDrivers(dNo).getAccumulatedTime() + lapTime[dNo]);
                }
            }
            else
            {
                System.out.println("Press enter to view Points allocation for lap");
                input.nextLine();//accumulated points calculate hobe
                for (int dNo = 0; dNo < drivers.size(); dNo++)
                {
                    drivers.getDrivers(dNo).setAccumulatedTime(drivers.getDrivers(dNo).getAccumulatedTime() + lapTime[dNo]);
                }
                
            }
        }
        setDrivers(sortForVenues());
        showLineWithIcons(80, "~");
        ip.acceptAnyInput("Press enter to see points allocation for this race");
        System.out.println();
        showLineWithIcons(80, "~");
        assignPointsForARace();
        showPointsPositions();
        showLineWithIcons(80, "~");
        changeRankings();
        ip.acceptAnyInput("Press enter > next step");
    }
    
    public void changeRankings()
    {
    
    
    
    
    
    
    
    
    }
    
    /**
     * This method loops the number of races in to the selected venues starting with showing
     * venue summary at the begaining.
     * 
     * @param selectedVenues number indexes for selected venues from list of venues as an array
     */
    public void raceForVenue(int[] selectedVenues)
    {
        Input input = new Input();
        input.acceptAnyInput("Press Enter To Begin The Championship");
        System.out.println();
        for(int index = 0; index < selectedVenues.length; index++)
        {
            String vanueName = venues.getVenues(selectedVenues[index]).getVenueName();
            int venueNoLaps = venues.getVenues(selectedVenues[index]).getNoOfLaps();
            int venueAvgTime = venues.getVenues(selectedVenues[index]).getAverageLapTime();
            double venueChanceRain = venues.getVenues(selectedVenues[index]).getChanceOfRain();
            System.out.println();
            System.out.print('\u000C');
            showLineWithIcons(80, "-");
            String a = "Wellcome to the Venue No: " + (index + 1) + " Venue Summary...";
            showLineForHeader(80, a);
            String b = ("| V# | (no of laps) | (avarage lap time) | (chanse of rain) |");
            showLineForHeader(80, b);
            String c = ( ".  " + vanueName + "     ");
            String d = ("| " + (selectedVenues[index] + 1) + ("| ( " + venueNoLaps + " rounds ) |" + " " 
                                + "  ( " + venueAvgTime + " seconds )   |" 
                                + " " + "    ( " + venueChanceRain + " )     |"));
            showLineForHeader(80, c);
            showLineForHeader(80, d);
            showLineWithIcons(79, "-");
            
            for (int dNo = 0; dNo < drivers.size(); dNo++)
            {
                drivers.getDrivers(dNo).setEligibleToRace(true);
            }
            
            System.out.println();
            setDrivers(sortForGridDrivers());
            input.acceptAnyInput("Press Enter to See Grid Position");
            System.out.println();
            showGridPositions();
            
            raceForLaps(venueNoLaps, venueAvgTime, venueChanceRain);
            
            for (int dNo = 0; dNo < drivers.size(); dNo++)
            {
               drivers.getDrivers(dNo).setAccumulatedTime(0);
            }
               
        }
    }
    
    /**
     * A mutator method to set drivers
     * 
     * @param ListOfDrivers an arraylist of drivers that represents multiple drivers objects
     */
    public void setDrivers(ListOfDrivers newDrivers)
    {
        drivers = newDrivers;
    }
    
    /**
     * A mutator method for venues
     * 
     * @param ListOfVenues an arraylist of drivers that represents multiple venues objects
     */
    public void setVenues(ListOfVenues newVenues)
    {
        venues = newVenues;
    }
    
    /**
     * This method helps to sort and set the drivers in accordance to the accumulated time for drivers after each race
     * 
     * @return returns an array list of drivers which is sorted in accordance to Accumulated time for a particular race
     */
    public ListOfDrivers sortForVenues()
    {
        ListOfDrivers tempDrivers = new ListOfDrivers();
        while (drivers.size() != 0)
        {
            if(drivers.size() != 0)
            {
                int index = 0;
                int[] rankingIndexes = new int [drivers.size()];
                
                for (int x = 0; x < drivers.size(); x++)
                {
                    rankingIndexes[x] = drivers.getDrivers(index).getAccumulatedTime();
                    index++;
                }
                
                int totalDrivers = drivers.size();
                int smallest = rankingIndexes[0];
                for (int y = 1; y < totalDrivers; y++)
                {
                    if (rankingIndexes[y] < smallest)
                    {
                        smallest = rankingIndexes[y];
                        totalDrivers--;
                    }
                }
            
                for (int z = 0; z < drivers.size(); z++)
                {
                    if (drivers.getDrivers(z).getAccumulatedTime() == smallest)
                    {
                        tempDrivers.setDrivers(drivers.getDrivers(z));
                        drivers.getDrivers().remove(z);
                    }
                }
            }
        }
        return tempDrivers;
    }
    
    
    /**
     * helps to show points positions and points allocaiton summary for all drivers
     * 
     */
    public void showPointsPositions()
    {
        showLineWithIcons(79, "*"); 
        showLineForHeader(80, "Point Allocation Summary");
        showLineWithIcons(79, "*"); 
        System.out.println();
        drivers.displayListOfDrivers();
    }
    
    
    
    /**
     * Displays line with a certain icon
     */
    private void showLineWithIcons(int numbers, String icon)
    {
        StringBuffer buffer = new StringBuffer(icon);
        for (int count = 0; count < numbers; count++)
            buffer.append(icon);
        System.out.println(buffer);
    }
    
    /**
     * Display's a header with a line of icons.
     * 
     */
    private void showLineForHeader(int numbers, String heading)
    {
        StringBuffer buffer = new StringBuffer();
        int y = heading.length();
        int remaining = numbers - y;
        for (int count = 0; count < remaining/2 ; count++)
            buffer.append("*");
        buffer.append(heading);
        for (int count = 0; count < (remaining + 1)/2 ; count++)
            buffer.append("*");
        System.out.println(buffer);
    }
    
    /**
     * Helps to sort the drivers at the end an accordance to the accumulated score
     * 
     * @returns list of drivers who are sorted in accordance to the accumjulated score
     */
    public ListOfDrivers sortChampionshipReasult()
    {
        ListOfDrivers tempDrivers = new ListOfDrivers();
        while (drivers.size() != 0)
        {
            if(drivers.size() != 0)
            {
                int index = 0;
                int[] rankingIndexes = new int [drivers.size()];
                
                for (int x = 0; x < drivers.size(); x++)
                {
                    rankingIndexes[x] = drivers.getDrivers(index).getAccumulatedScore();
                    index++;
                }
                
                int totalDrivers = drivers.size();
                int highest = rankingIndexes[0]; // java.lang.ArrayIndexOutOfBoundsException
                for (int y = 1; y < totalDrivers; y++)
                {
                    if (rankingIndexes[y] > highest)
                    {
                        highest = rankingIndexes[y];
                        totalDrivers--;
                    }
                }
            
                for (int z = 0; z < drivers.size(); z++)
                {
                    if (drivers.getDrivers(z).getAccumulatedScore() == highest)
                    {
                        tempDrivers.setDrivers(drivers.getDrivers(z));
                        drivers.getDrivers().remove(z);
                    }
                }
            }
        }
        return tempDrivers;
    }
    
    /**
     * This method helps to manage the game flow for the Championship races, while doing so it 
     * records number of races and selected venue indexes as a local veriable throughout one championship game.
     */
    public void startProgram()
    {
        welcomeMessage();
        int howMany = countRaces();
        Input input = new Input();
        input.acceptAnyInput("Press Enter to read Drivers file");
        showLineWithIcons(80, "~");
        showLineForHeader(80, "Drivers File");
        showLineWithIcons(80, "~");
        readDriverFile();
        System.out.println();
        input.acceptAnyInput("Press Enter to read Venues file");
        showLineWithIcons(80, "~");
        showLineForHeader(80, "Venues File");
        showLineWithIcons(80, "~");
        readVenueFile();
        int[] selectedVenues = selectVenues(howMany);
        showSelectedVenues(selectedVenues);
        setDrivers(sortForGridDrivers());
        raceForVenue(selectedVenues);
        setDrivers(sortChampionshipReasult());
        showResultChampionship();
    }
    
    public void showResultChampionship()
    {
        System.out.print('\u000C');
        showLineWithIcons(79, "*"); 
        showLineForHeader(80, "Championship Result");
        showLineWithIcons(79, "*"); 
        System.out.println();
        System.out.print("Congratualations!!!!!!! Champion Driver: ");
        System.out.print(drivers.getDrivers(0).getName());
        System.out.print(", with Accumulated Score of: ");
        System.out.println(drivers.getDrivers(0).getAccumulatedScore());
        System.out.println();
        System.out.println("Other Drivers information is as below");
        for(int i = 1; i < drivers.size(); i++)
        {
            System.out.println("Position: " + (i + 1) + ".");
            System.out.print("      " + drivers.getDrivers(i).getName());
            System.out.print(" (Accumulated Score: ");
            System.out.print(drivers.getDrivers(i).getAccumulatedScore());
            System.out.println(". )");
        }
        
    }
    
    /**
     * Displays welcome message at the begining of each championship
     */
    private void welcomeMessage()
    {
        showLineWithIcons(79, "~");
        showLineForHeader(80, "   WELCOME TO   ");
        showLineForHeader(80, "   Formula 9131 Grand Prix Championship TO   ");
        showLineWithIcons(79, "~");
    }
}