//This class is used for determine if the category is Four Kind

import java.util.List;

public class FourKind implements CardCategory{
    private String rRank;
    public double test(List<Card> cards) {
        int rIntRank;
        double categoryScore=0;
        List<Integer> cardIntRank = CardFunctions.cardSort(cards);
        //In Four Kind, there are only 2 patterns of sorted rank
        //a,a,a,a,b or a,b,b,b,b. But in two patterns, the second element's
        //frequency is 4
        if (CardFunctions.cardCount(cards, cardIntRank.get(1))==4) {
            //the frequency of the second element is 4 now, means Four Kind
            rIntRank = cardIntRank.get(1);
            categoryScore = rIntRank * CategoryConstants.FOUR_KIND_BASE;
            rRank = CardConstants.RANKS.get(
                    CardConstants.RANKS_INTEGERS.indexOf(rIntRank));
            //get the rRank in char Type for DisplayName
            for (int i=0;i<4;i++){
                //this for loop works for remove all duplicate elements in
                //the rIntRank List, so the loop need to run 4 times.
                cardIntRank.remove(cardIntRank.indexOf(rIntRank));
            }
            //the rIntRank List has only the rest element
            categoryScore+=cardIntRank.get(0);
            return categoryScore;
        }
        return categoryScore;
    }
    public String DisplayName() {
        return "Four " + RankOutput.rankoutput(rRank) + "s";
    }
}
