//In player class, this program sets two properties of player: String name and
//List<Card> owned cards. There is a construct function and two functions for
//returning player's property in this class.

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private List<Card> ownedCards = new ArrayList<Card>();
    public Player(String name) {
        this.name = name;
    }
    public void addCard(Card card) {
        ownedCards.add(card);
    }
    public List<Card> getOwnedCard(){
        return ownedCards;
    }
    public String getName() {
        return name;
    }
}
