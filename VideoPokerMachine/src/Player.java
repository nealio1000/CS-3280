/**
 * A poker hand evaluator
 * @author Neal Friedman
 * @version 0.2
 */
public class Player {

    /** Bet Amount */
    private int bet = 5;

    /** Player name */
    private String name = "Neal";

    private Hand playerHand;

    public Hand getPlayerHand() {
        return playerHand;
    }

    public void setPlayerHand(Hand playerHand) {
        this.playerHand = playerHand;
    }

    /** Discard Strategy */
    public boolean[] discardStrategy;

    /** Basic empty Player constructor **/
    public Player(){}

    /** Constructs a player with a bet amount **/
    public Player(int betAmount){
        this.bet = betAmount;
    }

    /** Constructs a player with a bet amount and name**/
    public Player(int betAmount, String theName){
        this.bet = betAmount;
        this.name = theName;
    }

    /**
     * Get the players bid
     * @return an integer containing the Player's bid amount
     */
    public int placeBet(){
        return this.bet;
    }

    /**
     * Get the player's name
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Set the player's name
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the player's bet amount
     * @return the bet amount
     */
    public int getBet() {
        return bet;
    }

    /**
     * Set the player's bet amount
     * @param bet the bet amount
     */
    public void setBet(int bet) {
        this.bet = bet;
    }
    
    public void pickDiscardStrategy(){
        discardStrategy = HoldStrategyCalculator.optimalStrategy(this.playerHand);
    }
}
