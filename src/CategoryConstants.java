//In this class, the program sets all the constants in scoring card category
//There are two goals of score algorithm. If categories are different between
//2 players, the more higher category must have higher score; if categories
//are the same, the score must be useful to determine winner
//
//The algorithm is:
//In Straight Flush, return the highest rank times 10^8
//In Four King, return the rank of 4 same cards times 10^7 plus the rank of
//the rest card
//In Full House, return the rank of 3 same cards times 10^6 plus the rank of
//the rank of 2 same cards
//In Flush, return the highest rank times 10^5 plus the second highest rank
//times 10^3 plus the third highest rank times 10^1 plus the fourth highest
//rank times 10^-1 plus the lowest rank times 10^-3
//In Straight, return the highest rank times 10^4
//In Three Kind, return the rank of 3 same cards times 10^3 plus the higher
//rank of the rest two cards times 10^1 plus the lower rank of the rest card
//times 10^-1
//In Two Pair, return the higher rank of 2 pairs times 10^2 plus the lower
//rank of 2 pairs times 10^-1 plus the rank the rest card times 10^-3
//In One Pair, return the rank of pairs time 10^1 plus the highest
//rank of the rest cards times 10^-1 plus the second highest rank of the rest
//cards times 10^-3 plus the lowest rank of the rest cards times 10^-5.
//In High Card, return the highest rank times 10^0 plus the second highest
//rank times 10^-2 plus the third highest rank times 10^-4 plus the forth
//highest rank times 10^-6 plus the lowest rank time 10^-8
//
//In summary, in every category, the score is the sum of every part's rank
//time the base relating to this part.
//
//We can find that in Flush, High Card, Three Kind, Two Pair, One Pair,
//the base are times by 0.01 from the most dominant part to the least.
//So, this program set a constant BASE_TIME = 100, for conveniently calculate
//the base in these categories.
//For example, in Three Kind, the original base is 1000, and this base belongs
//to the most dominant part--rank of triple cards. the lower base should be
//1000/100=10, which belongs to the less dominant part of Three Kind--the
//larger rank of the rest. Then the lower base should be 10/100=0.1, which
//belongs to the smaller rank of the rest.
//
//In the algorithm,
//Most powerful Straight Flush is Flush T,J,Q,K,A, and score is 1400000000
//Least powerful Straight Flush is Flush 2,3,4,5,6, and score is 200000000
//Most powerful Four Kind is A,A,A,A,K, and score is 140000013
//Least powerful Four Kind is 2,2,2,2,3, and score is 20000003
//Most powerful Full House is A,A,A,K,K, and score is 14000013
//Least powerful Full House is 2,2,2,3,3, and score is 2000003
//Most powerful Flush is Flush A,K,Q,J,9, and score is 1413121.109
//Least powerful Flush is Flush 7,5,4,3,2, and score is 705040.302
//Most powerful Straight is A,K,Q,J,T in different suits, and score is 140000
//Least powerful Straight is 6,5,4,3,2 in different suits, and score is 60000
//Most powerful Three Kind is A,A,A,K,Q, and score is 14131.2
//Least powerful Three Kind is 2,2,2,4,3, and score is 2040.3
//Most powerful Two Pair is A,A,K,K,Q, and score is 141.312
//Least powerful Two Pair is 3,3,2,2,4, and score is 30.204
//Most powerful High Card is A,K,Q,J,9, and score is 14.13121109
//Least powerful High Card is 7,5,4,3,2, and score is 7.05040302
//Obviously, there is no overlap between range of score of any two category.
//Therefore, the score of higher category is overwhelming to lower category.
//In the same category, more powerful cards group have higher score.
//
//Because there are 9 categories, the highest category's base constant is 10^8
//and the lowest category's base constant is 1
//Because there 13 ranks of card, in comparision between the same categories,
//when higher rank's base is equal to next higher rank's time 10, the result
//might be confusing. Because 10 is less than 13. Therefore, this program sets
//higher rank's base is equal to next higher rank's time 100 for easily
//understand


public class CategoryConstants {
    public final static double STRAIGHT_FLUSH_BASE = 100000000;
    public final static double FOUR_KIND_BASE = 10000000;
    public final static double FULL_HOUSE_BASE = 1000000;
    public final static double FLUSH_BASE = 100000;
    public final static double STRAIGHT_BASE = 10000;
    public final static double THREE_KIND_BASE = 1000;
    public final static double TWO_PAIR_BASE = 100;
    public final static double ONE_PAIR_BASE = 10;
    public final static double HIGH_CARD_BASE = 1;
    public final static double BASE_TIMES = 100;
}
