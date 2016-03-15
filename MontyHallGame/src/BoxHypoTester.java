// BoxHypoTester.java

import java.util.Random;

/**
 * Required class for the 3-box game simulation.
 * @author Neal Friedman
 * @version CS3280 Fall 2015
 */
public class BoxHypoTester {
    /**
     * Required method for the 3-box game simulation.
     * Determines the outcomes of the 3-box game strategies.
     * @param numberOfGames the number of games to be simulated
     * @return the number of wins for each strategy;
     * [0] corresponds to the "keep original box" strategy
     * [1] corresponds to the "switch to new box" strategy
     */
     public static long[] simulatePlay(final long numberOfGames){
        Random gen = new Random();
        long stayWins = 0;
        long switchWins = 0;
        for(long plays = 0;plays < numberOfGames;plays++ ){
            int[] doors = {0,0,0};// Initialize the game
            doors[gen.nextInt(3)] = 1; // Put prize in a box chosen randomly
            int choice = gen.nextInt(3); // Contestant chooses a box randomly
            int shown; //the shown door
            do{
                shown = gen.nextInt(3);
                //don't show the winner or the choice
            }while(doors[shown] == 1 || shown == choice);

            stayWins += doors[choice];//if you won by staying, count it

            //the switched (last remaining) door is (3 - choice - shown), because 0+1+2=3
            switchWins += doors[3 - choice - shown];
        }

        return new long[]{stayWins, switchWins};
    }

    /** Hidden constructor because this is a utility class. */
    private BoxHypoTester() { }
}