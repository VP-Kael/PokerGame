//Author:   Muyuan Zhu <muyuanz@student.unimeln.edu.au>
//Purpose:  Play 5-card Poker Game and determine the winner of several players
//
//Firstly, computer must be sure all the input card is valid
//Then, we start a virtual game. Every player has 5 cards from input
//There are 9 categories of 5 cards: Straight-Flush, Four Kind, Full House,
//Flush, Straight, Three Kins, Two Pair, One Pair, High Card. Computer gets
//all arguments and change them into cards and deliver to virtual players.
//Next, this program judges which category are these players.
//Last, this program determine the all winners and output them no matter how
//many winners.


import java.util.ArrayList;
import java.util.List;

public class Poker {
    public final static int PLAYER_HAND_CARD_NUM = 5;
    public static void main(String[] args) {
        int error = JudgeInput.judge(args);
        //Use judge function to judge if input is perfect
        if (error<-1) {
            System.out.printf("Error: wrong number of arguments;"
                    + " must be a multiple of %d%n", PLAYER_HAND_CARD_NUM);
            System.exit(0);
            //kill the program
        }
        else if (error>-1) {
            System.out.printf("Error: invalid card name '%s'%n", args[error]);
            System.exit(0);
            //kill the program
        }
        //now all the arguments are acceptable
        List<Player> allPlayers = new ArrayList<Player>();
        //create a list of player
        Player newPlayer;
        //create one new player object
        int playerNumber =args.length/PLAYER_HAND_CARD_NUM, n, m;
        String playerName, newRank, newSuit;
        for (n=0;n<playerNumber;n++) {
            //this for loop is used to adding player to allPlayers
            playerName = String.format("Player %d", n+1);
            newPlayer = new Player(playerName);
            allPlayers.add(newPlayer);
            for (m=0; m<PLAYER_HAND_CARD_NUM; m++) {
                //this for loop is used to adding card to player
                //integer n and m mean the mth card of nth player
                newRank = args[n*PLAYER_HAND_CARD_NUM+m].
                        toUpperCase().substring(0,1);
                newSuit = args[n*PLAYER_HAND_CARD_NUM+m].
                        toUpperCase().substring(1);
                allPlayers.get(n).addCard(Card.createCard(newRank, newSuit));
                //add UpperCase rank and suit of new card to player object
            }
        }
        //delivery all arguments to player list
        Dealer dealer = new Dealer();
        //create one new Dealer object
        List<Double> playerScore = dealer.judge(allPlayers);
        //determine card category of players, return result as a double list
        WinnerOutput winner = new WinnerOutput();
        //create one new WinnerOutput object
        winner.winneroutput(playerScore);
        //print the summary of results
    }
}
