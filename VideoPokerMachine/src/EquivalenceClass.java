import java.util.List;

/**
 * Created by neal on 11/11/15.
 */
public class EquivalenceClass {
    private int id;
    private int groupId;
    private List<Card> cards;
    private float domination;

    public EquivalenceClass() {}

    public EquivalenceClass(int id, int groupId, List<Card> cards, float domination) {
        this.id = id;
        this.groupId = groupId;
        this.cards = cards;
        this.domination = domination;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public float getDomination() {
        return domination;
    }

    public void setDomination(float domination) {
        this.domination = domination;
    }
}
