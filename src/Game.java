// Jesse Chu
// CS 1400
// Assignment 5
// 4/6/2021
import java.util.Scanner;

public class Game{
    public static void main(String [] args){
        Deck deck = new Deck();
        deck.shuffle();
        Scanner scanner = new Scanner(System.in);
        String testString = "";
        int cardTracker = 0;
        boolean keepPlaying = true;
        int timesWon = 0;
        double gamesPlayed = 0.0;
        System.out.println("Welcome to Blackjack! Type ready when you are ready!");
        System.out.println("Note that you MUST type ready exactly as written - you cannot capitalize ready!");
        testString = scanner.nextLine();
        while (testString.compareTo("ready") != 0){
            System.out.println("Try again!");
            testString = scanner.nextLine();
        }
        System.out.println("Great! Let's get started now!");
        while (keepPlaying){
            Hand playerHand = new Hand();
            Hand dealerHand = new Hand();
            System.out.println("Let's draw!");
            playerHand.addCard(deck.drawCard(cardTracker));
            cardTracker++;
            playerHand.addCard(deck.drawCard(cardTracker));
            cardTracker++;
            dealerHand.addCard(deck.drawCard(cardTracker));
            cardTracker++;
            dealerHand.addCard(deck.drawCard(cardTracker));
            cardTracker++;
            showHand(playerHand);
            while (winCheck(playerHand)){
                System.out.println("Do you wish to hit? Note that you must correctly type hit.");
                testString = scanner.nextLine();
                if (testString.compareTo("hit") != 0){
                    System.out.println("Now it's the dealer's turn!");
                    break;
                }
                else{
                    System.out.println("Hit taken!");
                    playerHand.addCard(deck.drawCard(cardTracker));
                    cardTracker++;
                    showHand(playerHand);
                }
            }
            if (winCheck(playerHand)){
                showHand(dealerHand);
                while (dealerHand.calculateHandValue() <= playerHand.calculateHandValue() && winCheck(dealerHand)){
                    System.out.println("The dealer hits!");
                    dealerHand.addCard(deck.drawCard(cardTracker));
                    cardTracker++;
                    showHand(dealerHand);
                }
                if (dealerHand.calculateHandValue() == 21){
                    System.out.println("You lost due to the dealer getting 21!");

                }
                else if (dealerHand.calculateHandValue() > playerHand.calculateHandValue() && winCheck(dealerHand)){
                    System.out.println("The dealer had more score than you, so you lose! Sorry!");

                }
                else if (winCheck(dealerHand) == false){
                    System.out.println("You win! The dealer busted!");
                    timesWon++;
                }
                else {
                    System.out.println("Huh. This shouldn't happen.");
                    showHand(playerHand);
                    showHand(dealerHand);

                }
            }
            else {
                System.out.println("You busted! You lose!");

            }
            gamesPlayed++;
            calcWinStats(timesWon, gamesPlayed);
            keepPlaying = retry();
            deck.shuffle();
            cardTracker = 0;
        }
        System.out.println("Thanks for the games!");
    }
    public static void showHand (Hand h){
        System.out.println("The cards are ");
        for (int i = 0; i < h.findSize(); i++){
            System.out.println(h.getCard(i).getFace() + " of "  + h.getCard(i).getSuit());
        }
        System.out.println("The total value is " + h.calculateHandValue());

    }
    public static boolean winCheck(Hand h){
        if (h.calculateHandValue() > 21){
            return false;
        }
        else {
            return true;
        }
    }
    public static boolean retry(){
        String s = "";
        Scanner scan = new Scanner (System.in);
        System.out.println("Would you like to retry? Type yes if you do. The game will automatically end if you do not type yes.");
        s = scan.nextLine();
        if (s.compareTo("yes") != 0){
            return false;
        }
        else {
            return true;
        }
    }
    public static void calcWinStats(int gamesWon, double gamesPlayed){
        System.out.println("You have won " + gamesWon + " amount of times, and your win percentage is " + gamesWon/gamesPlayed * 100.0 + "%" + " out of " + gamesPlayed + " games.");
    }
}
