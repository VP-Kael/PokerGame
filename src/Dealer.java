//In this class, the input is List of all players. Then, judge method test
//the category of every player's owned cards by descend order of categories.
//Once the test method return a double value greater than 0, means determine
//the category of this player's cards, then use the DisplayName method of
//that category test method.
//Due to add test object by descend order into List of test function, judge
//method always returns the highest category's score. For example, when one
//player have card 4S,4C,4H,5D,5D. judge method would return score of Full
//House rather than Three Kind or One Pair because it test if the card is Full
//House before Three Kind and One Pair.

import java.util.ArrayList;
import java.util.List;

public class Dealer {
    private static List<CardCategory> cardCategoryGroup =
            new ArrayList<CardCategory>();
    {
        cardCategoryGroup.add(new StraightFlush(new Straight(), new Flush()));
        cardCategoryGroup.add(new FourKind());
        cardCategoryGroup.add(new FullHouse());
        cardCategoryGroup.add(new Flush());
        cardCategoryGroup.add(new Straight());
        cardCategoryGroup.add(new ThreeKind());
        cardCategoryGroup.add(new TwoPair());
        cardCategoryGroup.add(new OnePair());
        cardCategoryGroup.add(new HighCard());
    }
    //add 9 categories into List
    public List<Double> judge(List<Player> players){
        List<Double> playerScore = new ArrayList<Double>();
        //declare a double List for saving scores of all players
        double score;
        CardCategory category;
        for (Player player:players) {
            //to every player
            for (int categoryIndex=0; categoryIndex !=
                    cardCategoryGroup.size();categoryIndex++) {
                //to every category, run test
                category = cardCategoryGroup.get(categoryIndex);
                score = category.test(player.getOwnedCard());
                //get the score of this category's test
                if (score>0) {
                    //find the right category
                    playerScore.add(score);
                    //add player's score to score List
                    System.out.println(player.getName()+": " +
                            category.DisplayName());
                    //output summary of every player
                    break;
                    //no need to run test methods of rest categories
                }
            }
        }
        return playerScore;
    }
}
