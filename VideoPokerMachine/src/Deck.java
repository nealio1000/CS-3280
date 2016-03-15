/* Deck.java */
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
/**
 * Represents a deck of playing cards.
 * @author Dr. Jody Paul
 * @version 1.1
 */
public class Deck implements Iterable<Card> {
    /** Number of cards in a full deck. */
    public static final int DECK_SIZE
            = Suit.values().length * Rank.values().length;

    /** List of cards in this deck. */
    private List<Card> cardList = new ArrayList<>(DECK_SIZE);

    /** Constructor that yields an ordered deck of cards. */
    public Deck() {
        for (Suit s : Suit.values()) {
            for (Rank r : Rank.values()) {
                this.cardList.add(new Card(r, s));
            }
        }
    }

    /**
     * Deck copy constructor.
     * Shallow copy: uses the same card references as the original.
     * @param inDeck the deck to be copied
     */
    public Deck(final Deck inDeck) {
        for (Card c : inDeck) {
            this.cardList.add(c);
        }
    }

    /**
     * Returns the number of Cards in this Deck.
     * @return the size of this deck
     */
    public final int size() {
        return this.cardList.size();
    }

    /**
     * Returns the card at a specified position in this deck.
     * @param which the location of the desired card
     * @return the card at the specified location
     */
    public final Card getCard(final int which) {
        return cardList.get(which);
    }

    /**
     * Specifies the card at a given position by exchanging cards.
     * Puts the card currently at that position into the position
     * vacated by the specified card.
     * <p><b>Precondition:</b><br>
     * The specified card must already exist within the deck.
     *
     *  @param  which   Location in which to put specified card
     *  @param  inCard  The specified Card
     *  @return The card now at the indicated location
     */
    public final Card setCard(final int which, final Card inCard) {
        // Find inCard's current location.
        int inCardIndex = this.cardList.indexOf(inCard);
        // Swap the two cards.
        Card tempCard = this.cardList.get(which);
        this.cardList.set(which, this.cardList.get(inCardIndex));
        this.cardList.set(inCardIndex, tempCard);
        return this.cardList.get(which);
    }

    @Override
    public final Iterator<Card> iterator() {
        return this.cardList.iterator();
    }

    /**
     * Removes the card from the beginning of the deck.
     * @return the card that was at the beginning of the deck;
     *         null if deck contains no cards
     */
    public final Card deal() {
        if (this.cardList.size() < 1) {
            return null;
        }
        return this.cardList.remove(0);
    }



    /**
     * Performs a simple shuffle by exchanging cards.
     * Uses {@link java.util.Collections.shuffle()}
     */
    public final void shuffle() {
        java.util.Collections.shuffle(this.cardList);
    }

    /**
     * Returns string representation of every card in this deck
     * and in the order they appear in the deck.
     * @return displayable string for this deck
     */
    public final String showAll() {
        String deckString = "";
        for (Card c : this.cardList) {
            deckString += c + "   ";
        }
        return deckString;
    }


    public List<Card> getCardList() {
        return cardList;
    }

    /**
     * Internal unit testing.
     * @param args ignored
     */
    public static void main(final String[] args) {
        System.out.println("DECK_SIZE = " + DECK_SIZE);
        Deck localDeck = new Deck();
        System.out.println("New Deck.  Top card: " + localDeck.getCard(0));
        localDeck.shuffle();
        System.out.println("Shuffled.  Top card: " + localDeck.getCard(0));
        localDeck.shuffle();
        System.out.println("Shuffled.  Top card: " + localDeck.getCard(0));
    }
}