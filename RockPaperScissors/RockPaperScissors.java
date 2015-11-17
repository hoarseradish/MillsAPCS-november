
/**
 * Write a description of class RockPaperScissors here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
public class RockPaperScissors
{
    public static void main (String[] args) {
        System.out.println("rock paper or scissor ?");
        computerRPS();
    }

    public static void computerRPS (){
        Scanner input = new Scanner(System.in);
        String move = input.nextLine();
        while (move != "stop") {
            int userMove = move.length; // rock = 4, paper= 5, scissor = 7
            int computerMove = randomNumber;
            int win = 0;
            int totalGames = 0;
            while ( computerMove == 6) {
                computerMove = randomNumber;
            }
            if (userMove == 8) {
                userMove = 7;
            }
            if (userMove == computerMove) {
               System.out.println ("It's a Tie!);
            }
            if (userMove == 4) {
                if (computerMove == 5) {
                    System.out.pritnln("Rock loses to paper, You win!");
                }
                if (computerMove == 7 ) {
                    System.out.println("Rock beats scissors, You win!");
                }
            }
            if (userMove == 5) {
                if (computerMove == 4) {
                    System.out.println("Paper beats rock, You win!");
                }
                if (computerMove == 7 ) {
                    System.out.println("Paper loses to scissor, You lose!");
                }
            }
            if (userMove == 7) {
                if (computerMove = 4) {
                    System.out.println("Scissor loses to rock, You lose!");
                }
                if (computerMove = 5) {
                    System.out.println("Scissor beats paper, You win!");
            }
            
            move = in.nexLine();
        }
    }
    public static int randomNumber () {
        Random rand = newRandom; 
        return (rand.nextIn(3) + 4);       
    }
}
