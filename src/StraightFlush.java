//This class is used for determine if the category is Straight Flush

import java.util.List;

public class StraightFlush implements CardCategory{
    private String rRank;
    private Straight straight;
    private Flush flush;
    //declare one Straight object and one Flush object
    public StraightFlush(Straight straight, Flush flush) {
        this.straight = straight;
        this.flush = flush;
    }
    public double test(List<Card> cards) {
        int rIntRank;
        double categoryScore=0;
        if (straight.test(cards)>0 && flush.test(cards)>0) {
            //is Straight and Flush
            rIntRank = (int)(straight.test(cards) /
                    CategoryConstants.STRAIGHT_BASE);
            //calculate the highest rank by straight's score
            categoryScore = rIntRank * CategoryConstants.STRAIGHT_FLUSH_BASE;
            //calculate the score of Straight Flush
            rRank = CardConstants.RANKS.get(
                    CardConstants.RANKS_INTEGERS.indexOf(rIntRank));
            return categoryScore;
        }
        return categoryScore;
    }
    public String DisplayName() {
        return RankOutput.rankoutput(rRank) + "-high straight flush";
    }
}
