/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.*;
import java.util.*;

/**
 *
 * @author nfriedma
 */
public final class HoldStrategyCalculator {

    private static boolean[][] allHoldStrategies = { // true if card in position i is held, false if discarded
            {true,  true,	true,	true,	true}, //Hold 5 (1)

            {false,	true,	true,	true,	true}, // Hold 4 (5)
            {true,	false,	true,	true,	true}, {true,	true,	false,	true,	true},
            {true,	true,	true,	false,	true}, {true,	true,	true,	true,	false},

            {false,	false,	true,	true,	true}, // Hold 3 (10)
            {false,	true,	false,	true,	true}, {false,	true,	true,	false,	true},
            {false,	true,	true,	true,	false}, {true,	false,	false,	true,	true},
            {true,	false,	true,	false,	true}, {true,	false,	true,	true,	false},
            {true,	true,	false,	false,	true}, {true,	true,	false,	true,	false},
            {true,	true,	true,	false,	false},

            {false,	false,	false,	true,	true}, // Hold 2 (10)
            {false,	false,	true,	false,	true}, {false,	false,	true,	true,	false},
            {false,	true,	false,	false,	true}, {false,	true,	false,	true,	false},
            {false,	true,	true,	false,	false}, {true,	false,	false,	false,	true},
            {true,	false,	false,	true,	false}, {true,	false,	true,	false,	false},
            {true,	true,	false,	false,	false},

            {true,	false,	false,	false,	false}, // Hold 1 (5)
            {false,	true,	false,	false,	false}, {false,	false,	true,	false,	false},
            {false,	false,	false,	true,	false}, {false,	false,	false,	false,	true},

            {false,	false,	false,	false,	false} // Hold 0 (1)
    };
    private static boolean[] strategy = new boolean[5];
    
    private HoldStrategyCalculator(){}

    /**
     * Calculates the optimal discard strategy
     * @return the optimal strategy
     */
    public static boolean[] optimalStrategy(Hand hand) {
        boolean[] theOptimalStrategy = new boolean[5];

        for (int i = 0; i < allHoldStrategies.length; i++){
            for(int j = 0; j < allHoldStrategies[i].length; j++){
                if(allHoldStrategies[i][j])
                    System.out.print(hand.getCard(j) + ",\t");
                else
                    System.out.print("*,\t");
            }
            System.out.println();
        }



        
        return theOptimalStrategy;
    }

    public static void generateAllUniqueHands(){

        Deck deck = new Deck();
        Hand hand;
        File file = new File("UniqueHandIds.dat");
        PayoutTable pt = PayoutTable.payoutTable85();

        int bupkis = 0;
        int lowPair = 0;
        int highPair = 0;
        int twoPair = 0;
        int threeKind = 0;
        int fourKind = 0;
        int fullHouse = 0;
        int flush = 0;
        int straight = 0;
        int straightFlush = 0;
        int royalFlush = 0;


        try {
            PrintWriter writer = new PrintWriter(file);

            for (int i = 0; i < 52; i++) {
                int j = i + 1;
                for (; j < 52; j++) {
                    int k = j + 1;
                    for (; k < 52; k++) {
                        int l = k + 1;
                        for (; l < 52; l++) {
                            int m = l + 1;
                            for (; m < 52; m++) {
                                hand = new Hand(Arrays.asList(deck.getCard(i), deck.getCard(j), deck.getCard(k), deck.getCard(l), deck.getCard(m)));
                                //hand.sort();
                                //writer.write(hand.encode() + "\n");

                                HandEvaluator.determinePayout(hand,pt,1);
                                Quality q = hand.getQuality();
                                if(q == Quality.BUPKIS)
                                        bupkis++;
                                else if(q == Quality.LOWPAIR)
                                        lowPair++;
                                else if(q == Quality.HIGHPAIR)
                                        highPair++;
                                else if(q == Quality.TWOPAIR)
                                        twoPair++;
                                else if(q == Quality.THREEKIND)
                                        threeKind++;
                                else if(q == Quality.FOURKIND)
                                        fourKind++;
                                else if(q == Quality.STRAIGHT)
                                        straight++;
                                else if(q == Quality.FULLHOUSE)
                                        fullHouse++;
                                else if(q == Quality.FLUSH)
                                        flush++;
                                else if(q == Quality.STRAIGHTFLUSH)
                                        straightFlush++;
                                else if(q == Quality.ROYALFLUSH)
                                        royalFlush++;
                            }
                        }
                    }
                }
            }
            writer.close();
        }
        catch (IOException e) {
            System.out.println(e);
        }

        System.out.println("Bupkis: " + bupkis);
        System.out.println("Low Pair: " + lowPair);
        System.out.println("High Pair: " + highPair);
        System.out.println("Two Pair: " + twoPair);
        System.out.println("Three of a Kind: " + threeKind);
        System.out.println("Four of a Kind: " + fourKind);
        System.out.println("Full House: " + fullHouse);
        System.out.println("Straight: " + straight);
        System.out.println("Flush: " + flush);
        System.out.println("Straight Flush: " + straightFlush);
        System.out.println("Royal Flush: " + royalFlush);

        System.out.println("Total: " + (bupkis + lowPair + highPair + twoPair + threeKind + fourKind + fullHouse + straight + flush + straightFlush + royalFlush));
        System.out.println("Total (without bupkis and lowPair): " + (highPair + twoPair + threeKind + fourKind + fullHouse + straight + flush + straightFlush + royalFlush));



    }


}
