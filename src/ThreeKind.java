//This class is used for determine if the category is Three Kind

import java.util.List;

public class ThreeKind implements CardCategory{
    private String rRank;
    public double test(List<Card> cards) {
        int rIntRank;
        double categoryScore=0;
        List<Integer> cardIntRank = CardFunctions.cardSort(cards);
        //dealer has test Full house before, so if there is one element with
        //frequency 3, it must be Three Kind
        //In sorted rank List, there are 3 patterns of Three Kind:
        //a,a,a,b,c, a,b,b,b,c, and a,b,c,c,c. No matter which patterns, the
        //frequency of the third element is 3.
        rIntRank = cardIntRank.get(2);
        //get the third highest rank
        if (CardFunctions.cardCount(cards, rIntRank)==3) {
            //is Three Kind now
            categoryScore = rIntRank * CategoryConstants.THREE_KIND_BASE;
            rRank = CardConstants.RANKS.get(
                    CardConstants.RANKS_INTEGERS.indexOf(rIntRank));
            for (int i=0;i<3;i++){
                //this for loop works for remove all duplicate elements in
                //the rIntRank List, so the loop need to run 3 times.
                cardIntRank.remove(cardIntRank.indexOf(rIntRank));
            }
            for (int i=1;i>=0;i--){
                categoryScore += cardIntRank.get(i) *
                        CategoryConstants.THREE_KIND_BASE *
                        Math.pow(CategoryConstants.BASE_TIMES, i-2);
            }
            //there are only two elements in the rest cardIntRank List, so
            //this for loop need tun twice
            return categoryScore;
        }
        return categoryScore;
    }
    public String DisplayName() {
        return "Three " + RankOutput.rankoutput(rRank) + "s";
    }
}
