//This class is used for calculate the score of High Card
//and return the summary in DisplayName method

import java.util.List;

public class HighCard implements CardCategory{
    private String rRank;
    public double test(List<Card> cards) {
        int rIntRank;
        double categoryScore=0;
        List<Integer> cardIntRank = CardFunctions.cardSort(cards);
        rIntRank = cardIntRank.get(4);
        //rIntRank is the biggest element of cardIntRank
        rRank = CardConstants.RANKS.get(
                CardConstants.RANKS_INTEGERS.indexOf(rIntRank));
        for (int i=4;i>=0;i--){
            categoryScore += cardIntRank.get(i) *
                    CategoryConstants.HIGH_CARD_BASE *
                    Math.pow(CategoryConstants.BASE_TIMES, i-4);
        }
        //for each elements of sorted rank List, categoryScore plus rank time
        //base
        //there are 5 cards, so this loop need do 5 times
        return categoryScore;
    }
    public String DisplayName() {
        return RankOutput.rankoutput(rRank)+"-high";
    }
}
