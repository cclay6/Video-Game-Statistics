package OOD_project.gamestats;
import java.util.Comparator;

/**
 * A game object that manages game information
 */
public class Game {
    /**
     * Name of the game
     */
    private String name;

    /**
     * Year the game was released
     */
    private int year;

    /**
     * The platform the game runs on
     */
    private String console;

    /**
     * True if the user is currently playing the game. False otherwise.
     */
    private boolean inProgress;

    /**
     * True if the user has completed the game. False otherwise.
     */
    private boolean completed;

    /**
     * The time it takes to beat the main game in seconds
     */
    private long mainLength;

    /**
     * The time it takes to beat the main game + extras in seconds
     */
    private long mainExtrasLength;

    /**
     * Constructor. Creates a game object.
     * @param name The name of the game.
     * @param year The year the game was released.
     * @param console The platform the game runs on.
     * @param inProgress True if the game is currently being played by the user. False otherwise.
     * @param completed True if the user has completed the game. False otherwise.
     * @param mainLength The length of time it takea to beat the main game in seconds
     * @param mainExtrasLength The length of time it takes to beat the main game + extras in seconds
     */
    public Game(String name, int year, String console, boolean inProgress, boolean completed,
                long mainLength, long mainExtrasLength)
    {

        //Sets parameters of the game object to the values the user has entered
        this.name= name;
        this.year= year;
        this.console= console;
        this.inProgress= inProgress;
        this.completed= completed;
        this.mainLength= mainLength;
        this.mainExtrasLength= mainExtrasLength;

    }

    /**
     * Getter.
     * @return The name of the game.
     */
    public String getName()
    {
        return name;
    }

    /**
     * Getter.
     * @return The year the game was released.
     */
    public int getYear()
    {
        return year;
    }

    /**
     * Getter.
     * @return The platform the game runs on.
     */
    public String getConsole()
    {
        return console;
    }

    /**
     * Getter.
     * @return Whether or not the game is in progress (true or false)
     */
    public boolean getInProgress()
    {
        return inProgress;
    }

    /**
     * Getter.
     * @return Whether or not the game has been completed (true or false)
     */
    public boolean getCompleted()
    {

       return completed;
    }

    /**
     * Getter.
     * @return The length of time it takes to beat the main game in seconds
     */
    public long getMainLength()
    {


        return mainLength;
    }

    /**
     * Getter.
     * @return The length of time is takes to beat the main game + extras in seconds
     */
    public long getMainExtrasLength()
    {

        return mainExtrasLength;
    }

    /**
     * Converts seconds to hours, minutes, and seconds
     */
    private class LengthConverter
    {
        /**
         * The number of whole converted hours from seconds
         */
        private long hours;
        /**
         * The number of whole converted minutes from seconds
         */
        private long minutes;
        /**
         * The number of seconds remaining after conversion to hours and minutes
         */
        private long seconds;

        /**
         * Constructor
         * @param length A length of time in seconds.
         */
        private LengthConverter(long length)
        {
            this.hours= length/3600;
            this.minutes= (length- hours*3600)/60;
            this.seconds= length-hours*3600-minutes*60;
        }

        /**
         * Getter.
         * @return The converted hours
         */
        private long getHours()
        {
            return this.hours;
        }

        /**
         * Getter.
         * @return The converted minutes
         */
        private long getMinutes()
        {
            return this.minutes;
        }

        /**
         * Getter.
         * @return The converted remaining seconds
         */
        private long getSeconds()
        {
            return this.seconds;
        }

        /**
         * Converts the LengthConverter object to a string in Xh Ym Zs format.
         * @return a string in hours, minutes, seconds format
         */
        public String toString(){
            String string=  hours + "h" + " " +
                    minutes + "m" + " " +
                    seconds + "s";

            return string;
        }
    }

    /**
     * Getter
     * @return the mainExtrasLength's hours component of hours, minutes, seconds format
     */
    public long getMainExtrasLengthHours()
    {
        //Converts seconds to whole hours (rounds down)
        long hours= mainExtrasLength/3600;
        return hours;
    }

    /**
     * Getter.
     * @return the mainExtrasLength's minutes component of hours, minutes, seconds format
     */
    public long getMainExtrasLengthMinutes()
    {
        //Converts seconds to whole hours (rounds down)
        long hours= mainExtrasLength/3600;

        //Converts seconds to whole minutes (rounds down) by first subtracting whole hours (in
        // total seconds), and converting the rest of the seconds to whole minutes
        long minutes= (mainExtrasLength- hours*3600)/60;

        //returns the minutes
        return minutes;
    }

    /**
     * Getter.
     * @return the mainExtrasLength's seconds component of hours, minutes, seconds format
     */
    public long getMainExtrasLengthSeconds()
    {
        //Converts seconds to whole hours (rounds down)
        long hours= mainExtrasLength/3600;

        //Converts seconds to whole minutes (rounds down) by first subtracting whole hours (in
        // total seconds), and converting the rest of the seconds to whole minutes
        long minutes= (mainExtrasLength- hours*3600)/60;

        //Subtract the total seconds by the hours (in seconds) and minutes (in seconds).
        //The remaining seconds are the "seconds" unit.
        long seconds= mainExtrasLength-hours*3600-minutes*60;

        //returns the "seconds" unit.
        return seconds;
    }

    /**
     * Getter
     * @return the mainLength's hours component of hours, minutes, seconds format
     */
    public long getMainLengthHours()
    {
        //Converts seconds to whole hours (rounds down)
        long hours= mainLength/3600;

        //returns the hours unit
        return hours;
    }

    /**
     * Getter.
     * @return the mainLength's minutes component of hours, minutes, seconds format
     */
    public long getMainLengthMinutes()
    {
        //Converts seconds to whole hours (rounds down)
        long hours= mainLength/3600;

        //Converts seconds to whole minutes (rounds down) by first subtracting whole hours (in
        // total seconds), and converting the rest of the seconds to whole minutes
        long minutes= (mainLength- hours*3600)/60;

        //returns the minutes unit
        return minutes;
    }

    /**
     * Getter.
     * @return the mainLength's seconds component of hours, minutes, seconds format
     */
    public long getMainLengthSeconds()
    {
        //Converts seconds to whole hours (rounds down)
        long hours= mainLength/3600;

        //Converts seconds to whole minutes (rounds down) by first subtracting whole hours (in
        // total seconds), and converting the rest of the seconds to whole minutes
        long minutes= (mainLength- hours*3600)/60;

        //Subtract the total seconds by the hours (in seconds) and minutes (in seconds).
        //The remaining seconds are the "seconds" unit.
        long seconds= mainLength-hours*3600-minutes*60;

        //retunrs the "seconds" unit
        return seconds;
    }
    /**
     * Converts the contents of the game into a string.
     * @return The game information in the form of a string
     */
    public String toString()
    {
        //Converts the mainLength and mainExtrasLength
        // of types long into objects that derive hours, minutes, and
        //seconds
        LengthConverter mainLengthConverter= new LengthConverter(this.mainLength);
        LengthConverter mainExtrasLengthConverter= new LengthConverter(this.mainExtrasLength);

        //Declare String variables for game object
        String inProgress;
        String completed;

        //convert true to yes and false to no for inProgress and completed
        if (this.inProgress)
            inProgress= "yes";
        else
            inProgress= "no";
        if (this.completed)
          completed= "yes";
        else
            completed= "no";

        //Creates the string of game information
        String info= "Name: " + this.getName() + "\n"
                + "Year: " + this.getYear() + "\n"
                + "Console: " + this.getConsole() + "\n"
                + "In progress: " + inProgress + "\n"
                + "Completed: " + completed + "\n"
                + "Main length: " + mainLengthConverter + "\n"
                + "Main + extras length: " + mainExtrasLengthConverter + "\n";

        return info; //returns the game information
    }

    /**
     * Getter
     * @return main extras length in hours
     */
    public double getMainExtrasLengthInHours()
    {
        //derives the hours form with respect to 1 hours= 3600 seconds
        double hoursForm= this.getMainExtrasLength()/3600.0;

        //returns hours form
        return hoursForm;
    }

    /**
     * Getter
     * @return main length in hours
     */
    public double getMainLengthInHours()
    {
        //derives the hours form with respect to 1 hours= 3600 seconds
        double hoursForm=this.getMainLength()/3600.0;

        //returns hours form
        return hoursForm;
    }

    /**
     * Comparator that tells the list to sort a list of Game objects by the mainLength
     * @return Comparator object that tells the list sort how to sort the contents
     */
    public static Comparator<Game> getCompByMainLength()
    {
        return new Comparator<Game>()
        {
            public int compare(Game game1, Game game2)
            {
                return Long.valueOf(game1.getMainLength()).compareTo(Long.valueOf(
                        game2.getMainLength()));
            }
        };

    }

    /**
     * Comparator that tells the list to sort a list of Game objects by the mainExtrasLength
     * @return Comparator object that tells the list sort how to sort the contents
     */
    public static Comparator<Game> getCompByMainExtrasLength()
    {
        return new Comparator<Game>()
        {
            public int compare(Game game1, Game game2)
            {
                return Long.valueOf(game1.getMainExtrasLength()).compareTo(Long.valueOf(
                        game2.getMainExtrasLength()));
            }
        };
    }

    /**
     * Getter
     * @return main length in XhYmZs format
     */
    public String getMainLengthToStringXhYmZs()
    {
        //create length converter object for converting mainLength to XhYmZs format
        LengthConverter mainLengthConverter= new LengthConverter(this.mainLength);
        return mainLengthConverter.toString();
    }

    /**
     * Getter
     * @return @return main extras length in XhYmZs format
     */
    public String getMainExtrasLengthToStringXhYmZs()
    {
        //create length converter object for converting mainExtrasLength to XhYmZs format
        LengthConverter mainExtrasLengthConverter= new LengthConverter(this.mainExtrasLength);

        //returns a string in XhYmZs format
        return mainExtrasLengthConverter.toString();
    }

}
