// GameWorld.java

/**
 * This is the world in which the player and the box game exist.
 * Set the number of times to play and the player will play the game
 * that many times. After the simulation the results are displayed.
 * @author Neal Friedman
 * @version CS3280 Fall 2015
 */
public class GameWorld{
    private static final long numberOfPlays = 30000000; /* Set the number of times to run the simulation here! */

    /** The main method for running the program
     *
     * @param args Unused arguments
     */
	public static void main(String[] args) {
        Player neal = new Player();
		long[] results = neal.play(numberOfPlays);

        System.out.println( neal.getName() + " Won by keeping the original box " + results[0] + " times.\n" +
                neal.getName() + " Won by switching to the new box " + results[1] + " times.");

        System.out.println("The percent of wins when staying is:  " +
                (((float)results[0] / (float)numberOfPlays))* 100);
        System.out.println("The percent of wins when switching is: " +
                (((float)results[1] / (float)numberOfPlays)) * 100);

        float ratio = (float)results[1] / (float)results[0];

        System.out.println("Switching is " + ratio + " times better than staying");

        System.out.println("Good Job " + neal.getName() + "!");
	}
}