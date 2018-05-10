//This class is used for determine if the category is Two Pair

import java.util.List;

public class TwoPair implements CardCategory{
    private String r1Rank, r2Rank;
    public double  test(List<Card> cards) {
        int r1IntRank,r2IntRank;
        double categoryScore=0;
        List<Integer> cardIntRank = CardFunctions.cardSort(cards);
        //in Two Pair, there are three patterns of sorted rank List
        //a,a,b,b,c, a,a,b,c,c, and a,b,b,c,c. But in these three patterns,
        //the second element and the forth element is always the rank of
        //smaller pair and larger pair respectively
        r1IntRank=cardIntRank.get(1);
        r2IntRank=cardIntRank.get(3);
        //get the ranks of two pairs.
        if (CardFunctions.cardCount(cards, r1IntRank)==2 &&
                CardFunctions.cardCount(cards, r2IntRank)==2) {
            categoryScore = r2IntRank * CategoryConstants.TWO_PAIR_BASE +
                    r1IntRank;
            r1Rank = CardConstants.RANKS.get(
                    CardConstants.RANKS_INTEGERS.indexOf(r2IntRank));
            r2Rank = CardConstants.RANKS.get(
                    CardConstants.RANKS_INTEGERS.indexOf(r1IntRank));
            for (int i=0;i<2;i++) {
                //this for loop works for remove all duplicate elements in
                //the rIntRank List, so the loop need to run 2 times.
                cardIntRank.remove(cardIntRank.indexOf(r1IntRank));
                cardIntRank.remove(cardIntRank.indexOf(r2IntRank));
            }
            categoryScore+=cardIntRank.get(0) *
                    CategoryConstants.TWO_PAIR_BASE *
                    Math.pow(CategoryConstants.BASE_TIMES, -2);
            //the rest of cardIntRank is the third dominant part of Two Pair
            //So, the base of this rank is TWO_PAIR_BASE divided by BASE_TIMES
            //twice
            return categoryScore;
        }
        return categoryScore;
    }
    public String DisplayName() {
        return RankOutput.rankoutput(r1Rank) + "s over " +
                RankOutput.rankoutput(r2Rank) + "s";
    }
}
