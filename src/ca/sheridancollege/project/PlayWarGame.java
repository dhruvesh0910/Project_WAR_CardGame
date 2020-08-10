/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project;

import java.util.Scanner;

/**
 *
 * @author Dhruvesh Patel
 */
public class PlayWarGame {
    public static void main(String args[])
    {
        System.out.print("Enter number of card in card deck: ");
        Scanner in = new Scanner(System.in);
        int cardDeckSize = in.nextInt();
        CardDeck card[] = new CardDeck[cardDeckSize];
        int i = 0;
        for(Card.Suits s: Card.Suits.values())
                {
                    for(Value v: Value.values())
                    {
                        //Creating objects using constructor and 
                        //assigning values of emun fields 
                        //from list of possible discrete values
                        card[i] = (new CardDeck(s,v));
                        GroupOfCards.cards.add(card[i]);
                        i++;
                    }
                }//end outter for
        
        
       /* for(i=0;i<GroupOfCards.getCards().size();i++)
        {
            System.out.println(GroupOfCards.getCards().get(i).toString());
        }
        
        GroupOfCards.shuffle();
        
        for(i=0;i<GroupOfCards.getCards().size();i++)
        {
            System.out.println(GroupOfCards.getCards().get(i).toString());
        }*/
       
        System.out.print("Enter number of players: ");
        int numPlayers = in.nextInt();
        
        
        System.out.print("Enter name of player1: ");
        String player1 = in.next();
        
        System.out.print("Enter name of player2: ");
        String player2 = in.next();
        
        PlayersGame pg1 = new PlayersGame(numPlayers,player1,player2);//(numPlayers,player1,player2);
        pg1.play();
        
        
    }
}
