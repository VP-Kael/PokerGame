//In this class, there are two methods which are used in card category
//determine class. cardCount method return frequency of rank for determine
//Four Kind, Full House, Three Kind, Two Pair, and One Pair. cardSort return
//sorted rank int List for conveniently determine

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CardFunctions {
    public static int cardCount(List<Card> cards, int a) {
        int sum = 0;
        for (Card card : cards) {
            sum += card.getIntRank() == a ? 1 : 0;
        }
        return sum;
        //return the frequency of rank a
    }

    public  static List<Integer> cardSort (List<Card> cards){
        List<Integer> cardIntRank = new ArrayList<Integer>();
        for (Card card:cards) {
            cardIntRank.add(card.getIntRank());	//
        }
        //save all ranks of 5 cards into cardIntRank
        Collections.sort(cardIntRank);
        return cardIntRank;
        //return sorted cardIntRank
    }
}
