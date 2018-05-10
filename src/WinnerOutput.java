//This class is designed for output the summary of result

import java.util.List;
import java.util.Collections;
import java.util.ArrayList;

public class WinnerOutput {
    public void winneroutput(List<Double> playerScore) {
        if (playerScore.size()==1) {
            return;
            //if there is only one player, no need run this class any more
        }
        //there are many players
        double max = Collections.max(playerScore);
        //find the max score of player score List
        if (Collections.frequency(playerScore, max)==1) {
            //there are only one max score
            System.out.printf("Player %d wins.%n",
                    playerScore.indexOf(max)+1);
            //output "Player 1 wins." directly
            //because the index of element starting from 0, so output index+1
        }else if(Collections.frequency(playerScore, max)==2) {
            //there are two max score
            System.out.printf("Players %d and %d draw.%n",
                    playerScore.indexOf(max)+1,
                    playerScore.lastIndexOf(max)+1);
            //indexOf() return the first winner and lastIndexOf() return the
            //second winner
        }else {
            //there are more than two winners. And the required format is
            //"Players 1, 2, 3 and 4 draws."
            //The last two winners' output format is "%d and %d draws.",
            //the other's format is "%d, ";
            List<Integer> drawPlayers = new ArrayList<Integer>();
            for (int i=0;i<playerScore.size();i++) {
                if (playerScore.get(i)==max) {
                    drawPlayers.add(i+1);
                }
            }
            //find all winners and save into drawPlayers List. For example,
            //player 1,2,3,4,7 are winners.
            System.out.print("Players ");
            //now, the output is "Players "
            for (int i=0;i<drawPlayers.size()-2;i++) {
                System.out.printf("%d, ", drawPlayers.get(i));
                //output every winner except the last two winners
            }
            //now, the output is "Players 1, 2, 3,"
            System.out.printf("%d and %d draw.%n",
                    drawPlayers.get(drawPlayers.size()-2),
                    drawPlayers.get(drawPlayers.size()-1));
            //output the last two winners
            //now, the output is "Players 1, 2, 3, 4 and 7 draws."
        }
    }
}
