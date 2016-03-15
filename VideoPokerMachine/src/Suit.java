/* Suit.java */
/**
 * Enumeration class for the suits of cards.
 *
 * @author Dr. Jody Paul
 * @version 1.0
 */
public enum Suit {
    HEARTS ("Hearts" , 1),
    CLUBS ("Clubs", 2),
    DIAMONDS ("Diamonds", 3),
    SPADES ("Spades", 4);

    /** The common name of this suit. */
    private final String suitName;

    /** Arbitrary value used for sorting cards by suit */
    private final int suitValue;

    /**
     * Constructor for Suit.
     * @param name the display name for this suit
     */
    Suit(final String name, final int value) {
        this.suitName = name;
        this.suitValue = value;
    }

    /**
     * Provides an integer value for this suit.
     * @return the integer value corresponding to this suit
     */
    public int value() {
        return this.suitValue;
    }

    @Override
    public String toString() {
        return this.suitName;
    }
}