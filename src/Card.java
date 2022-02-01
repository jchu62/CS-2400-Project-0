// Jesse Chu
// CS 1400
// Assignment 5
// 4/6/2021
public class Card {
    String face;
    String suit;
    int num;
    public Card(String f, String s, int n){
        face = f;
        suit = s;
        num = n;
    }
    public String getFace(){
        return face;
    }
    public String getSuit(){
        return suit;
    }
    public int getNum(){
        return num;
    }
}
