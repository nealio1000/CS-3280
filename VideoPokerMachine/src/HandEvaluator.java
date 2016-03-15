/* HandEvaluator.java */
/**
 * A poker hand evaluator
 * @author Neal Friedman
 * @version 0.2
 */
public final class HandEvaluator {

    private static int[] rankCounts; 
    private static boolean isFlush, isStraight;
    private static int biggerMultipleSize, smallerMultipleSize;
    private static int biggerRank, smallerRank, topStraightValue;

    /**
     * Private Constructor for Hand Evaluator Utility Class
     */
    private HandEvaluator(){}

    /**
     * Given a hand, determine its payout. This is the main access method for this class.
     * @param theHand the hand
     * @param thePayoutTable the payout table
     * @param bid the player's bid
     * @return the payout
     */
    public static int determinePayout(Hand theHand, PayoutTable thePayoutTable, int bid){
       
        // initialize values since everything is static
        rankCounts = new int[14];
        isFlush = true;
        isStraight = false;
        biggerMultipleSize = 1;
        smallerMultipleSize = 1;
        biggerRank = 0;
        smallerRank = 0;
        topStraightValue = 0;
        
        countRanks(theHand);
        checkMultiples();
        checkStraight();
        checkFlush(theHand);
        
        return bid * thePayoutTable.getPayout(determineValue(theHand));
    }

    /**
     * Determines the value of the hand. I.e. pair, flush, straight, full house, etc.
     * @param myHand the hand
     */
    private static Quality determineValue(Hand myHand){
        if(biggerMultipleSize == 1) {                               // no pairs
            myHand.setQuality(Quality.BUPKIS);
           // System.out.println("No multiples");
        }
        if(biggerMultipleSize == 2 && smallerMultipleSize == 1 ) {  // one pair
           // System.out.println("You got one pair of " + Rank.values()[biggerRank-1] + "s\n");

            if(biggerRank < 11)
                myHand.setQuality(Quality.LOWPAIR);
            else
                myHand.setQuality(Quality.HIGHPAIR);
        }
        if(biggerMultipleSize == 2 && smallerMultipleSize == 2 ) {
           // System.out.println("You got two pairs!\nBigger pair: " + Rank.values()[biggerRank - 1]
          //          + "\nSmaller pair: " + Rank.values()[smallerRank - 1]);
            myHand.setQuality(Quality.TWOPAIR);
        }
        if(biggerMultipleSize == 3 && smallerMultipleSize == 1 ) {
          //  System.out.println("You got three of a kind of: " + Rank.values()[biggerRank - 1] + "s\n");
            myHand.setQuality(Quality.THREEKIND);
        }
        if (isStraight && !isFlush) {
          //  System.out.println("You got a straight with a high of: " + Rank.values()[topStraightValue-1] + "\n");
            myHand.setQuality(Quality.STRAIGHT);
        }
        if (isFlush && !isStraight) {
          //  System.out.println("You got a flush!\n");
            myHand.setQuality(Quality.FLUSH);
        }
        if (biggerMultipleSize == 3 && smallerMultipleSize == 2) {
           // System.out.println("You got a full house!\n" +
           //         "Three of: " + Rank.values()[biggerRank - 1] +
           //         "\nTwo of: " + Rank.values()[smallerRank - 1]);
            myHand.setQuality(Quality.FULLHOUSE);
        }
        if (biggerMultipleSize == 4 && smallerMultipleSize == 1 ) {
           // System.out.println("You got four of a kind of: " + Rank.values()[biggerRank - 1] + "\n");
            myHand.setQuality(Quality.FOURKIND);
        }
        if (isStraight && isFlush && topStraightValue == 1) {
          //  System.out.println("You got a royal flush!!!!!\n");
            myHand.setQuality(Quality.ROYALFLUSH);
        }
        else if (isStraight && isFlush && topStraightValue != 1) {
           // System.out.println("You got a straight flush!\n");
            myHand.setQuality(Quality.STRAIGHTFLUSH);
        }
        return myHand.getQuality();
    }

    /**
     * Counts how many of each rank appear in your hand
     * @param hand The hand who's cards are being counted
     */
    private static void countRanks(Hand hand){
        for(int i = 0; i < Hand.HAND_SIZE; i++)
            rankCounts[hand.getCard(i).rank().value()]++;
    }

    /**
     * Check if the hand has a flush
     * @param hand The hand you are checking for a flush
     */
    private static void checkFlush(Hand hand){
        for(int i = 0; i < Hand.HAND_SIZE; i++)
            if (hand.getCard(i).suit() != hand.getCard(i+1).suit())
                isFlush = false;
    }

    /**
     * Check if the hand has any multiples
     */
    private static void checkMultiples(){
        for (int i = 13; i > 0; i--) {
            if (rankCounts[i] > biggerMultipleSize) { // theres a bigger guy than you thought previously
                if (biggerMultipleSize != 1){  // copy bigger pair into smaller pair
                    smallerMultipleSize = biggerMultipleSize;
                    smallerRank = biggerRank;
                }
                biggerMultipleSize = rankCounts[i]; // make bigger pair the new higher count
                biggerRank = i;
            }
            else if (rankCounts[i] > smallerMultipleSize) {  // theres a  new, bigger, smallpair
                smallerMultipleSize = rankCounts[i];
                smallerRank = i;
            }
        }
    }

    /**
     * Check if the hand has a straight
     */
    public static void checkStraight(){
        for (int i = 1; i < 10; i++) //can't have straight with lowest value of more than 10
        {
            if (rankCounts[i] == 1 && rankCounts[i + 1] == 1 && rankCounts[i + 2] == 1
                    && rankCounts[i + 3] == 1 && rankCounts[i + 4] == 1)
            {
                isStraight = true;
                topStraightValue = i + 4;
                break;
            }
        }

        if (rankCounts[10] == 1 && rankCounts[11] == 1 && rankCounts[12] == 1
                && rankCounts[13] == 1 && rankCounts[1] == 1) //ace high
        {
            isStraight = true;
            topStraightValue = 1; //higher than king
        }
    }
}
