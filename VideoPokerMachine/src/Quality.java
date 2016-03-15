/* Quality.java */
/**
 * Enumeration of qualifying hands.
 *
 * @author Dr. Jody Paul
 * @version 1.0
 */
public enum Quality {
    BUPKIS ("Bupkis"),
    LOWPAIR ("Low Pair"),
    HIGHPAIR ("High Pair"),
    TWOPAIR ("Two Pair"),
    THREEKIND ("Three of a Kind"),
    STRAIGHT ("Straight"),
    FLUSH ("Flush"),
    FULLHOUSE ("Full House"),
    FOURKIND ("Four of a Kind"),
    STRAIGHTFLUSH ("Straight Flush"),
    ROYALFLUSH ("Royal Flush"),
    SPECIAL1 ("Four of a Kind [2-4]"),
    SPECIAL2 ("Four of a Kind [Aces]");

    /** Common name for this qualifying hand. */
    private String handName;

    /**
     * Constructor that associates common name.
     * @param name the display name for this quality
     */
    Quality(final String name) {
        this.handName = name;
    }

    @Override
    public String toString() {
        return this.handName;
    }
}