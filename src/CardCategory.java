//This program sets a reference type of all 9 categories functions

import java.util.List;

public interface CardCategory {
    double test(List<Card> cards);
    //return a double value as the score of one card list
    //the explanation of this double type and calculating method is in
    //CategoryConstants class
    String DisplayName();
    //return a String as the the summary of one card list
    //in DisplayName method of every category test class, use a method to
    //convert char T,J,Q,K,A into String 10,Jack,Queen,King,Ace for output
}
