//This class is used for determine if the category is Flush

import java.util.List;

public class Flush implements CardCategory{
    private String rRank;
    public double test(List<Card> cards) {
        int rIntRank;
        double categoryScore=0;
        String suit = null;
        for (Card card:cards) {
            if(suit!=null) {
                if (!suit.equals(card.getSuit())) {
                    return categoryScore;
                }
            }else {
                suit = card.getSuit();
            }
        }
        //is Flush
        List<Integer> cardIntRank = CardFunctions.cardSort(cards);
        rIntRank = cardIntRank.get(4);
        //find the highest rank for DisplayName method
        for (int i=4;i>=0;i--){
            categoryScore += cardIntRank.get(i) *
                    CategoryConstants.FLUSH_BASE *
                    Math.pow(CategoryConstants.BASE_TIMES, i-4);
        }
        //for each elements of sorted rank List, categoryScore plus rank time
        //base
        //there are 5 cards, so this loop need do 5 times
        rRank = CardConstants.RANKS.get(
                CardConstants.RANKS_INTEGERS.indexOf(rIntRank));
        //get the highest card's rank in char Type
        return categoryScore;
    }

    public String DisplayName() {
        return RankOutput.rankoutput(rRank)+ "-high flush";
    }
}
