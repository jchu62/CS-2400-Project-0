// Jesse Chu
// CS 1400
// Assignment 5
// 4/6/2021
import java.util.Collections;
import java.util.Arrays;

public class Deck {
    Card[] fullDeck = new Card[52];
    public Deck() {
        for (int i = 0; i < fullDeck.length; i++) {
            String face = "";
            String suit = "";
            int num = 0;
                switch (i%13 + 1) {
                    case 1:
                        face = "Ace";
                        num = 11;
                        break;
                    case 2:
                        face = "Two";
                        num = 2;
                        break;
                    case 3:
                        face = "Three";
                        num = 3;
                        break;
                    case 4:
                        face = "Four";
                        num = 4;
                        break;
                    case 5:
                        face = "Five";
                        num = 5;
                        break;
                    case 6:
                        face = "Six";
                        num = 6;
                        break;
                    case 7:
                        face = "Seven";
                        num = 7;
                        break;
                    case 8:
                        face = "Eight";
                        num = 8;
                        break;
                    case 9:
                        face = "Nine";
                        num = 9;
                        break;
                    case 10:
                        face = "Ten";
                        num = 10;
                        break;
                    case 11:
                        face = "Jack";
                        num = 11;
                        break;
                    case 12:
                        face = "Queen";
                        num = 12;
                        break;
                    case 13:
                        face = "King";
                        num = 13;
                        break;
                }

                    switch (i%4 + 1) {
                        case 1:
                            suit = "Hearts";
                            break;
                        case 2:
                            suit = "Spades";
                            break;
                        case 3:
                            suit = "Diamonds";
                            break;
                        case 4:
                            suit = "Clovers";

                }
                fullDeck[i] = new Card(face, suit, num);
            }
        }
    public Card drawCard(int number){

        return fullDeck[number];
    }
    public void shuffle(){
        Collections.shuffle(Arrays.asList(fullDeck));
    }

}
