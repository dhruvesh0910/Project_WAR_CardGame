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
        
       
        System.out.print("Enter number of players: ");
        int numPlayers = in.nextInt();
       
        String player[] = new String[numPlayers];
        
        for(int j=0; j<numPlayers; j++)
        {
            System.out.println("Enter Player"+(j+1)+" name : ");
            player[j] = in.next();
        }
        
        if(numPlayers == 2)
        {
            PlayersGame pg1 = new PlayersGame(numPlayers,player[0],player[1]);
            pg1.play();
        }
        
        if(numPlayers == 3)
        {
            PlayersGame pg1 = new PlayersGame(numPlayers,player[0],player[1],player[2]);
            pg1.play();
        }
        
    }
}
