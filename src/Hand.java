// Jesse Chu
// CS 1400
// Assignment 5
// 4/6/2021
import java.util.ArrayList;

public class Hand {
    ArrayList<Card> hand = new ArrayList<Card>();
    public Hand(){
        hand = new ArrayList<Card>();
    }
    public void addCard(Card input){
        hand.add(input);
    }
    public int calculateHandValue(){
        int counter = 0;
        for (int i = 0; i < hand.size(); i++){
            counter += hand.get(i).getNum();
        }
        return counter;
    }
    public int findSize(){
        return hand.size();
    }
    public Card getCard(int n){
        return hand.get(n);
    }

}
