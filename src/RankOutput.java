//In this class, program set a function to change char T,J,Q,K,A into String
//10,Jack,Queen,King,Ace for output the summary of result

public class RankOutput {
    public static String rankoutput(String rRank) {
        switch (rRank) {
            case "T":
                return "10";
            case "J":
                return "Jack";
            case "Q":
                return "Queen";
            case "K":
                return "King";
            case "A":
                return "Ace";
            default:
                return rRank;
        }
    }
}
