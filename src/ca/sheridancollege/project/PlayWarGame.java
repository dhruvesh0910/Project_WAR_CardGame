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
        System.out.println("Card in CardDeck for WAR game is 52.");
        Scanner in = new Scanner(System.in);
        int cardDeckSize = 52;
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
        int numPlayers;
        System.out.print("Enter number of players (2 or 3): ");
        numPlayers= in.nextInt();
        while(numPlayers != 2 && numPlayers != 3)
        {
            System.out.println("Choose number of players between 2 and 3 !!!!!!!!");
            System.out.print("Enter number of players (2 or 3): ");
            numPlayers= in.nextInt();
        }
        
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
