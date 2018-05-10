//This class is used for determine if the category is Flush

import java.util.List;

public class OnePair implements CardCategory{
    private String rRank;
    public double test(List<Card> cards) {
        int rIntRank;
        double categoryScore=0;
        List<Integer> cardIntRank = CardFunctions.cardSort(cards);
        for (Card card:cards) {
            if (CardFunctions.cardCount(cards, card.getIntRank())==2) {
                //Because the Dealer has tested Full House and Two Pair,
                //Therefore, the category is One Pair as long as there is a
                //element with frequency 2
                rIntRank = card.getIntRank();
                categoryScore = (int)(rIntRank *
                        CategoryConstants.ONE_PAIR_BASE);
                rRank = CardConstants.RANKS.get(
                        CardConstants.RANKS_INTEGERS.indexOf(rIntRank));
                //get rRank in char Type for DisplayName
                for (int i=0;i<2;i++) {
                    //this for loop works for remove all duplicate elements in
                    //the rIntRank List, so the loop need to run 2 times.
                    cardIntRank.remove(cardIntRank.indexOf(rIntRank));
                }
                for (int i=2;i>=0;i--){
                    categoryScore += cardIntRank.get(i) *
                            CategoryConstants.ONE_PAIR_BASE *
                            Math.pow(CategoryConstants.BASE_TIMES, i-3);
                }
                //there are only three elements in the rest cardIntRank List,
                //so this for loop need tun three times
                return categoryScore;
            }
        }
        return categoryScore;
    }
    public String DisplayName() {
        return "Pair of " + RankOutput.rankoutput(rRank) + "s";
    }
}
