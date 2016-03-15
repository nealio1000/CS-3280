// Player.java

/** The person who plays the game and then reports their results
 *  to the game world.
 * @author Neal Friedman
 * @version CS3280 Fall 2015
 */

public class Player {
	private String name = "Neal Friedman"; /* Set your name here! */

    /** Basic Constructor for a Player*/
	public Player(){}

    /** Get the player's name
     *
     * @return A string containing the player's name
     */
	public String getName(){
		return this.name;
	}

    /** Play the game
     *
     * @param timesToPlay The number of times you want to play the game
     * @return Returns the results of the simulation in the form of an array
     */
	public long[] play(long timesToPlay){
        return BoxHypoTester.simulatePlay(timesToPlay);
    }
}