/* Hand.java */
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
/**
 * A poker hand made of cards.
 * @author Dr. Jody Paul & Neal Friedman
 * @version 1.0
 */
public class Hand implements Iterable<Card> {
    /** The number of cards in the hand. */
    static final int HAND_SIZE = 5;

    /** Encoding constant to use six bits per card. */
    static final int ENCODER = 64;

    /** Cards in this hand. */
    private List<Card> cards = new ArrayList<>();

    /** The hand Quality */
    private Quality myQuality = Quality.BUPKIS;

    /**
     * Constructs a hand from a default deck of cards.
     */
    public Hand() {this(new Deck());}

    /**
     * Hand copy constructor.
     * Uses references to the original cards.
     * @param orig the hand to be copied
     */
    public Hand(final Hand orig) {
        for (Card c : orig) {
            this.cards.add(c);
        }
    }

    /**
     * Constructs hand from list of cards
     * @param c list of cards
     */
    public Hand(List<Card> c){
        this.cards = c;
    }

    /**
     * Creates a new hand from the beginning of a deck.
     * @param fromDeck the deck from which to draw cards
     */
    public Hand(final Deck fromDeck) {
        for (int i = 0; i < HAND_SIZE; i++) {
            this.cards.add(fromDeck.getCard(i));
        }
    }

    /**
     * Creates a new hand given a deck and a starting position
     *     within that deck.
     * @param fromDeck the deck from which to draw cards
     * @param start the starting index of cards in the deck
     */
    public Hand(final Deck fromDeck, final int start) {
        for (int i = 0; i < HAND_SIZE; i++) {
            this.cards.add(fromDeck.getCard(i + start));
        }
    }

    /**
     * Creates a new hand given a hand encoding.
     * @param encoding the encoding of the desired hand
     */
    public Hand(final long encoding) {
        long carrier = encoding;
        int  currentCard;

        for (int i = HAND_SIZE - 1; i >= 0; i--) {
            currentCard = (int) carrier % ENCODER;
            this.cards.add(new Card(currentCard));
            carrier = (carrier - currentCard) / ENCODER;
        }
    }

    @Override
    public final Iterator<Card> iterator() {
        return cards.iterator();
    }

    @Override
    public final boolean equals(final Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj.getClass().equals(this.getClass()))) {
            return false;
        }
        Hand hobj = (Hand) obj;
        for (int i = 0; i < Hand.getSize(); i++) {
            if (!this.cards.get(i).equals(hobj.cards.get(i))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public final int hashCode() {
        int code = 0;
        for (Card c : this.cards) {
            code += c.hashCode();
        }
        return code;
    }

    /**
     * Retrieves the card at a given position within this hand.
     * <p><b>Precondition: </b>
     *     <CODE>0 &le; which &le; HAND_SIZE</CODE></p>
     * @param which the index of the desired card
     * @return the card at the specified index
     *         or at index 0 if precondition is not met
     */
    public final Card getCard(final int which) {
        if (0 <= which && which < HAND_SIZE) {
            return this.cards.get(which);
        }
        return this.cards.get(0);
    }

    /**
     * Sets a specified card of this hand.
     * <p><b>Precondition: </b>
     *     <CODE>0 &le; which &le; HAND_SIZE</CODE></p>
     * @param which the index of the card to change
     * @param newCard the card to be placed at the specified index
     */
    public final void setCard(final int which, final Card newCard) {
        if (0 <= which && which < HAND_SIZE) {
            cards.set(which, newCard);
        }
    }

    /**
     * Setter for hand's quality
     * @param q the Quality
     */
    public final void setQuality(Quality q){
        this.myQuality = q;
    }

    /**
     * Getter for hand's quality
     * @return the hand's quality
     */
    public final Quality getQuality(){
        return this.myQuality;
    }


    /**
     * Returns the number of cards that make up a hand.
     * @return the size of a hand
     */
    public static int getSize() {
        return HAND_SIZE;
    }

    /**
     * Sorts this hand by ascending card rank and suit
     */
    public final void sort() {
        int min;
        Card temp;

        for (int i = 0; i < HAND_SIZE; i++) {
            min = i;
            for (int j = i; j < HAND_SIZE; j++) {
                if (((this.cards.get(j)).suit().compareTo((this.cards.get(min)).suit()) < 0) &&
                        ((this.cards.get(j)).rank().compareTo((this.cards.get(min)).rank()) == 0))
                    min = j;
            }
            temp = this.cards.get(i);
            this.cards.set(i, this.cards.get(min));
            this.cards.set(min, temp);
        }
    }

    /**
     * Encodes this hand as a long integer.
     * <p>&sum; cardID[i] * ENCODER<SUP>i</SUP> ,&nbsp;  &forall;i &#8717; 0 &le; i &lt; HAND_SIZE</p>
     * @return the encoding of this hand
     */
    public final long encode() {
        long encoding = 0;
        for (int i = HAND_SIZE - 1; i >= 0; i--) {
            encoding = (ENCODER * encoding) + this.cards.get(i).cardID();
        }
        return encoding;
    }

    @Override
    public final String toString() {
        String s = "";
        for (int i = 0; i < HAND_SIZE; i++) {
            s += "[" + cards.get(i) + "]";
        }
        return s;
    }

    /**
     * Displays a visual representation of this hand on System.out.
     */
    public final void show() {
        show(HAND_SIZE);
    }

    /**
     * Displays a visual representation of the
     *      first cards of this hand on {@link System.out}.
     * @param count the number of cards to show
     */
    public final void show(final int count) {
        for (int i = 0; i < count; i++) {
            System.out.println("Card[" + i + "]: " + cards.get(i));
        }
    }

    /** Arbitrary hand index for internal testing. */
    private static final int TEST_START_INDEX = 19;
    /**
     * Internal unit testing.
     * @param args ignored
     */
    public static void main(final String[] args) {
        Hand localHand = new Hand(new Deck());
        localHand.show();
        System.out.println("  Hand encoding: " + localHand.encode());
        localHand = new Hand(new Deck(), TEST_START_INDEX);
        localHand.show();
        System.out.println("  Hand encoding: " + localHand.encode());
    }
}