package edu.gonzaga;

import java.util.Scanner;
import java.awt.*;

public class Player {
    Point loc;
    String character;
    Card hand;
    boolean winner = false;
    int space;
    int label;
    public void setLabel(int x){
        label = x;
    }
    public int getLabel(){
        return label;
    }
    public void setCard(Card cards){
        hand = cards;
    }
    public void setLocation(Point location){
        loc = location;
    }
    public void setCharacter(String name){
        character = name;
    }
    public String getCharacter(){
        return character;
    }
    public Card getCard(){
        return hand;
    }
    public void setWinner(boolean win){
        winner = win;
    }
    public boolean getWinner(){
        return winner;
    }
    boolean checkWinner(){
        if(winner==true){
            return true;
        }
        else{
            return false;
        }
    }
    public void playTurn(Board board){
        System.out.println(this.getCharacter() + "'s turn!");
        drawCardPlayer(board);
        playerMoveSpaces(board);
    }
    public void drawCardPlayer(Board board){
//        System.out.println("Enter to draw card!! ");
//        Scanner scanner = new Scanner(System.in);
//        scanner.nextLine();
        hand = board.drawCard();
    }

    public void playerMoveSpaces(Board board){
        System.out.println(space);
        System.out.println(board.spaces.get(space));
        String card1 = hand.getSquare1();
        String card2 = hand.getSquare2();
        if(hand.specialCard)
        {
            space = board.findNextSpace(card1, 0);
        }
        else
        {
            space = board.findNextSpace(card1, space);
            if(!hand.square2.equals(""))
            {
                space = board.findNextSpace(card2, space);
            }
        }
        loc = board.candyPath.get(space);
        if(space==board.spaces.size()-1){
            winner = true;
        }
        System.out.println(space);
        System.out.println(board.spaces.get(space));
    }
    public Player(){

    }
}
