//This class is used for determine if the category is Flush

import java.util.List;

public class FullHouse implements CardCategory{
    private String r1Rank, r2Rank;
    public double test(List<Card> cards) {
        int r1IntRank,r2IntRank;
        double categoryScore=0;
        List<Integer> cardIntRank = CardFunctions.cardSort(cards);
        //if is Full House, the pattern of sorted rank is a,a,a,b,b
        //or a,a,b,b,b
        r1IntRank=cardIntRank.get(0);
        //r1IntRank is the smallest element
        r2IntRank=cardIntRank.get(cardIntRank.size()-1);
        //r2IntRank is the largest element
        if (CardFunctions.cardCount(cards, r1IntRank)==2 &&
                CardFunctions.cardCount(cards, r2IntRank)==3) {
            //pattern is a,a,b,b,b
            categoryScore = r2IntRank *
                    CategoryConstants.FULL_HOUSE_BASE+r1IntRank;
            r1Rank = CardConstants.RANKS.get(
                    CardConstants.RANKS_INTEGERS.indexOf(r2IntRank));
            r2Rank = CardConstants.RANKS.get(
                    CardConstants.RANKS_INTEGERS.indexOf(r1IntRank));
            //r1Rank is the rank of b in this pattern, in char Type
            //r2Rank is the rank of a in this pattern, in char Type
            return categoryScore;
        }else if(CardFunctions.cardCount(cards, r1IntRank)==3 &&
                CardFunctions.cardCount(cards, r2IntRank)==2) {
            //pattern is a,a,a,b,b
            categoryScore = r1IntRank *
                    CategoryConstants.FULL_HOUSE_BASE+r2IntRank;
            r1Rank = CardConstants.RANKS.get(
                    CardConstants.RANKS_INTEGERS.indexOf(r1IntRank));
            r2Rank = CardConstants.RANKS.get(
                    CardConstants.RANKS_INTEGERS.indexOf(r2IntRank));
            //r1Rank is the rank of a in this pattern, in char Type
            //r2Rank is the rank of b in this pattern, in char Type
            return categoryScore;
        }
        return categoryScore;
    }
    public String DisplayName() {
        return RankOutput.rankoutput(r1Rank) +
                "s full of " + RankOutput.rankoutput(r2Rank) + "s";
    }
}
