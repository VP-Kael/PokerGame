//In Card Class, this program sets two properties of card: suit and rank.
//There is a function for create new card object, and two functions for return
//suit and rank of card object

public class Card {
    private String suit;
    private int rank;
    private Card() {}
    public static Card createCard(String rank, String suit) {
        Card card = new Card();
        card.suit = suit;
        card.rank = CardConstants.RANKS_INTEGERS.get(
                CardConstants.RANKS.indexOf(rank));
        //change char rank into int rank by CardConstants
        return card;
    }
    public String getSuit() {
        return suit;
    }
    public int getIntRank() {
        return rank;
    }
}
