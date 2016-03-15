/* Rank.java */
/**
 * Enumeration class for the ranks of cards.
 * Integer values: Ace = 1, ..., King = 13
 * @author Dr. Jody Paul
 * @version 1.0
 */
public enum Rank {
    ACE ("Ace", 1),
    TWO ("Two", 2),
    THREE ("Three", 3),
    FOUR ("Four", 4),
    FIVE ("Five", 5),
    SIX ("Six", 6),
    SEVEN ("Seven", 7),
    EIGHT ("Eight", 8),
    NINE ("Nine", 9),
    TEN ("Ten", 10),
    JACK ("Jack", 11),
    QUEEN ("Queen", 12),
    KING ("King", 13);

    /** The common name of this rank. */
    private final String rankName;

    /** The integer value of this rank. */
    private final int rankValue;

    /**
     * Constructs rank with specified name and value.
     * @param name the common name of this rank
     * @param value the integer value of this rank
     */
    Rank(final String name, final int value) {
        this.rankName = name;
        this.rankValue = value;
    }

    /**
     * Accesses the integer value of this rank.
     * @return the integer value corresponding to this rank
     */
    public int value() {
        return this.rankValue;
    }

    @Override
    public String toString() {
        return this.rankName;
    }
}