/* PayoutTable.java */
import java.util.Map;
import java.util.EnumMap;
/**
 * Establishes a payout table associated with hand qualities.
 * @author Dr. Jody Paul
 * @version 1.0
 */
public class PayoutTable {
    /** Maximum number of elements in a PayoutTable. */
    public static final int TABLE_SIZE = Quality.values().length;

    /**
     * This payout table.
     * Key corresponds to the hand qualification.
     * Value corresponds to the payout for a hand with that qualification.
     */
    private EnumMap<Quality, Integer> payouts =
            new EnumMap<Quality, Integer>(Quality.class);

    /**
     * Creates empty payout table.
     */
    public PayoutTable() {
    }

    /**
     * Creates payout table for Jacks or Better 8-5 machine.
     * @return payout table for Jacks-or-Better 8-5 (no progressive)
     */
    public static PayoutTable payoutTable85() {
        PayoutTable pt = new PayoutTable();
        pt.putPayout(Quality.BUPKIS, 0);
        pt.putPayout(Quality.LOWPAIR, 0);
        pt.putPayout(Quality.HIGHPAIR, 1);
        pt.putPayout(Quality.TWOPAIR, 2);
        pt.putPayout(Quality.THREEKIND, 3);
        pt.putPayout(Quality.STRAIGHT, 4);
        pt.putPayout(Quality.FLUSH, 5);
        pt.putPayout(Quality.FULLHOUSE, 8);
        pt.putPayout(Quality.FOURKIND, 25);
        pt.putPayout(Quality.STRAIGHTFLUSH, 50);
        pt.putPayout(Quality.ROYALFLUSH, 250);
        pt.putPayout(Quality.SPECIAL1, 25);
        pt.putPayout(Quality.SPECIAL2, 25);
        return pt;
    }

    /**
     * Payout table copy constructor.
     * Shallow copy (values not cloned).
     * @param orig the table to be copied
     */
    public PayoutTable(final PayoutTable orig) {
        this.payouts = orig.payouts.clone();
    }

    /**
     * Constructs payout table according to the hand qualities
     *     and payouts given as parameters.
     *  @param  quals Ordered hand qualities
     *  @param  pays  Corresponding payout multipliers
     */
    public PayoutTable(final Quality[] quals, final int[] pays) {
        for (int i = 0; i < quals.length && i < pays.length; i++) {
            this.payouts.put(quals[i], pays[i]);
        }
    }

    /**
     * Updates (adds or replaces) entry in this payout table.
     * @param quality the hand quality
     * @param multiplier the payout multiplier for the associated hand quality
     */
    public final void putPayout(final Quality quality, final int multiplier) {
        this.payouts.put(quality, multiplier);
    }

    /**
     * Retrieves the appropriate payout for a specified quality.
     *  @param  quality the quality to look up
     *  @return the payout multiplier associated with the quality,
     *          or <code>0</code> if no payout for the quality
     */
    public int getPayout(final Quality quality) {
        if (this.payouts.get(quality) == null) {
            return 0;
        }
        return this.payouts.get(quality);
    }

    /**
     * Accesses this payout table as a Map&lt;Quality, Integer&gt;.
     * @return this payout table
     */
    public final Map<Quality, Integer> table() {
        return this.payouts;
    }

    @Override
    public String toString() {
        String result = "";
        for (Quality q : this.payouts.keySet()) {
            result += q + ": " + this.payouts.get(q) + "\n";
        }
        return result;
    }
}