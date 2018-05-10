//This class is used for determine if the category is Straight

import java.util.List;

public class Straight implements CardCategory{
    private String rRank;
    public double test(List<Card> cards) {
        int rIntRank;
        double categoryScore=0;
        List<Integer> cardIntRank = CardFunctions.cardSort(cards);
        for (int i=1;i!=cardIntRank.size();i++) {
            if (cardIntRank.get(i)-cardIntRank.get(i-1)!=1) {
                return categoryScore;
            }
        }
        //is Straight now
        rIntRank = cardIntRank.get(cardIntRank.size()-1);
        categoryScore = rIntRank * CategoryConstants.STRAIGHT_BASE;
        rRank = CardConstants.RANKS.get(
                CardConstants.RANKS_INTEGERS.indexOf(rIntRank));
        //get the rRank for DisplayName method
        return categoryScore;
    }
    public String DisplayName() {
        return RankOutput.rankoutput(rRank) + "-high straight";
    }
}
