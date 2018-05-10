//In this class, judge function works for returning if there is anything
//mistake existing within the input. When return -2, means the length of
//arguments is wrong; when return -1, means all the input is correct; when
//return any integer i greater than -1, means args[i] is the first error
//argument.

public class JudgeInput {
    public static int judge(String[] args) {
        if (args.length == 0 || args.length % Poker.PLAYER_HAND_CARD_NUM != 0)
            //length of arguments is wrong
            return -2;
        String rank, suit;
        for (int i=0; i<args.length; i++) {
            rank = args[i].toUpperCase().substring(0,1);
            suit = args[i].toUpperCase().substring(1,2);
            //rank and suit is upper case char of input
            if (!(CardConstants.RANKS.contains(rank) &&
                    CardConstants.SUITS.contains(suit))) {
                //rank or suit of args[i] is error
                return i;
            }
        }
        return -1;
    }
}
