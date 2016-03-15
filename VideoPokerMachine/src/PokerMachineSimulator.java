/* PokerMachineSimulator.java */
/**
 * A poker hand evaluator
 * @author Neal Friedman
 * @version 0.2
 */
public class PokerMachineSimulator{
    private static int count = 1;

    public static void main (String[] args){
        test();
        //game();
    }

    /**
     * Run some test hands
     */
    public static void test(){
        Deck deck = new Deck();
        long startTime = System.currentTimeMillis();
        HoldStrategyCalculator.generateAllUniqueHands();



//        Hand theHand = new Hand(deck);
//        Hand theHand2 = new Hand(deck);
        Hand theHand3 = new Hand(deck);
//        Hand theHand4 = new Hand(deck);
//        Hand theHand5 = new Hand(deck);
//        Hand theHand6 = new Hand(deck);
//        Hand theHand7 = new Hand(deck);
//        Hand theHand8 = new Hand(deck);
//        Hand theHand9 = new Hand(deck);

       // HoldStrategyCalculator.optimalStrategy(theHand3);

//        // Test for out of order equality
//        theHand.setCard(0, new Card(Rank.TWO,Suit.CLUBS));
//        theHand.setCard(1, new Card(Rank.JACK,Suit.DIAMONDS));
//        theHand.setCard(2, new Card(Rank.TWO,Suit.HEARTS));
//        theHand.setCard(3, new Card(Rank.JACK,Suit.CLUBS));
//        theHand.setCard(4, new Card(Rank.THREE,Suit.CLUBS));
//        theHand2.setCard(2, new Card(Rank.TWO, Suit.CLUBS));
//        theHand2.setCard(3, new Card(Rank.JACK, Suit.CLUBS));
//        theHand2.setCard(0, new Card(Rank.TWO,Suit.HEARTS));
//        theHand2.setCard(1, new Card(Rank.JACK,Suit.DIAMONDS));
//        theHand2.setCard(4, new Card(Rank.THREE, Suit.CLUBS));
//        theHand.sort();
//        theHand2.sort();
//        theHand.show();
//        System.out.println();
//        theHand2.show();
//        if(theHand.encode() == theHand2.encode())
//            System.out.println("The Hands are equal");
//        else
//            System.out.println("The Hands are NOT equal");

//        // TEST FOR TWO PAIR
//        theHand.setCard(0, new Card(Rank.TWO,Suit.CLUBS));
//        theHand.setCard(1, new Card(Rank.JACK,Suit.DIAMONDS));
//        theHand.setCard(2, new Card(Rank.TWO,Suit.HEARTS));
//        theHand.setCard(3, new Card(Rank.JACK,Suit.HEARTS));
//        theHand.setCard(4, new Card(Rank.THREE,Suit.CLUBS));
//        test(theHand);
//        //**********************************
//
//        //Test For Flush
//        theHand2.setCard(0, new Card(Rank.TWO, Suit.CLUBS));
//        theHand2.setCard(1, new Card(Rank.JACK, Suit.CLUBS));
//        theHand2.setCard(2, new Card(Rank.FIVE, Suit.CLUBS));
//        theHand2.setCard(3, new Card(Rank.QUEEN, Suit.CLUBS));
//        theHand2.setCard(4, new Card(Rank.THREE, Suit.CLUBS));
//        test(theHand2);
//        //****************************
//
//        //Test for Straight
//        theHand3.setCard(0, new Card(Rank.ACE, Suit.SPADES));
//        theHand3.setCard(1, new Card(Rank.JACK, Suit.DIAMONDS));
//        theHand3.setCard(2, new Card(Rank.QUEEN, Suit.CLUBS));
//        theHand3.setCard(3, new Card(Rank.KING, Suit.HEARTS));
//        theHand3.setCard(4, new Card(Rank.TEN, Suit.CLUBS));
//        test(theHand3);
//        //********************************
//
        // Test for Royal Flush
//        theHand4.setCard(0, new Card(Rank.KING, Suit.CLUBS));
//        theHand4.setCard(1, new Card(Rank.JACK, Suit.CLUBS));
//        theHand4.setCard(2, new Card(Rank.TEN, Suit.CLUBS));
//        theHand4.setCard(3, new Card(Rank.QUEEN, Suit.CLUBS));
//        theHand4.setCard(4, new Card(Rank.ACE, Suit.CLUBS));
//        test(theHand4);
//        System.out.println(theHand4.getQuality().toString());
        // ********************************
//
//        // Test for one pair
//        theHand5.setCard(0, new Card(Rank.KING, Suit.CLUBS));
//        theHand5.setCard(1, new Card(Rank.KING, Suit.HEARTS));
//        theHand5.setCard(2, new Card(Rank.TEN, Suit.CLUBS));
//        theHand5.setCard(3, new Card(Rank.QUEEN, Suit.CLUBS));
//        theHand5.setCard(4, new Card(Rank.ACE, Suit.CLUBS));
//        test(theHand5);
//        // ********************************
//
//        // Test for three of a kind
//        theHand6.setCard(0, new Card(Rank.TEN, Suit.DIAMONDS));
//        theHand6.setCard(1, new Card(Rank.JACK, Suit.CLUBS));
//        theHand6.setCard(2, new Card(Rank.TEN, Suit.CLUBS));
//        theHand6.setCard(3, new Card(Rank.TEN, Suit.HEARTS));
//        theHand6.setCard(4, new Card(Rank.ACE, Suit.CLUBS));
//        test(theHand6);
//        // ********************************
//
//        // Test for four of a kind
//        theHand7.setCard(0, new Card(Rank.TEN, Suit.DIAMONDS));
//        theHand7.setCard(1, new Card(Rank.TEN, Suit.SPADES));
//        theHand7.setCard(2, new Card(Rank.TEN, Suit.CLUBS));
//        theHand7.setCard(3, new Card(Rank.TEN, Suit.HEARTS));
//        theHand7.setCard(4, new Card(Rank.ACE, Suit.CLUBS));
//        test(theHand7);
//        // ********************************
//
//        // Test for Straight Flush
//        theHand8.setCard(0, new Card(Rank.EIGHT, Suit.CLUBS));
//        theHand8.setCard(1, new Card(Rank.FIVE, Suit.CLUBS));
//        theHand8.setCard(2, new Card(Rank.SEVEN, Suit.CLUBS));
//        theHand8.setCard(3, new Card(Rank.NINE, Suit.CLUBS));
//        theHand8.setCard(4, new Card(Rank.SIX, Suit.CLUBS));
//        test(theHand8);
//        // ********************************
//
//        // Test for a bad hand.. will this even be possible if I use my hand and deck constructor correctly...
//        theHand9.setCard(0, new Card(Rank.TEN, Suit.DIAMONDS));
//        theHand9.setCard(1, new Card(Rank.TEN, Suit.DIAMONDS));
//        theHand9.setCard(2, new Card(Rank.TEN, Suit.CLUBS));
//        theHand9.setCard(3, new Card(Rank.TEN, Suit.CLUBS));
//        theHand9.setCard(4, new Card(Rank.ACE, Suit.CLUBS));
//        test(theHand9);

        long totalTime = System.currentTimeMillis() - startTime;
        if(totalTime > 1000)
            System.out.println("\nCompleted in: " + (totalTime / 1000) + " s");
        else
            System.out.println("\nCompleted in: " + totalTime + " ms");
    }

    /**
     * test each of the hands in here
     * @param myHand the hand to be tested
     */
    public static void test(Hand myHand){
        int payout;

        System.out.println("\nYour hand: ");
        PayoutTable pt = PayoutTable.payoutTable85(); // get a payout table
        Player neal = new Player(5); // Make a player with a bet amount
        myHand.show();
        System.out.println("\n------ Testing hand " + count + " -------");
        //HandEvaluator ev = new HandEvaluator();
        payout = HandEvaluator.determinePayout(myHand, pt, neal.placeBet());
       // payout = ev.determinePayout(myHand, pt, neal.placeBet());
        System.out.println("This hand's payout is: " + payout);

        count++;
    }

    /**
     * Attempt to simulate one full game
     *
     * TO DO: Discard strategy / optimal play
     */
    public static void game(){
        int payout;

        //HandEvaluator ev = new HandEvaluator(); // make a hand evaluator
        PayoutTable pt = PayoutTable.payoutTable85(); // get a payout table
        Player neal = new Player(5); // Make a player with a bet amount
        Deck deck = new Deck();  // make a deck
        deck.shuffle();         // shuffle the deck
        Hand hand = new Hand();
        for(int i = 0; i < Hand.HAND_SIZE; i++) // deal top 5 cards of the deck into a hand
            hand.setCard(i, deck.deal());

        hand.show();
        //**** PICK CARDS TO DISCARD *****//
        // *** REPLACE DISCARDED CARDS WITH NEW ONES FROM DECK[5] - DISCARD_SIZE ****//
        payout = HandEvaluator.determinePayout(hand, pt, neal.placeBet()); // evaluate hand for payout based on initial bid

        System.out.println("\nThis hand's payout is: " + payout);
        HoldStrategyCalculator.optimalStrategy(hand);
    }
}
