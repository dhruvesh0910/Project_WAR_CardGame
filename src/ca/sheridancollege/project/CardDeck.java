/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project;

/**
 * This is the Deck class which inherits all the data from card class
 * @author Dhruvesh Patel
 */
public class CardDeck extends Card {
    
    //Parameterized Constructor
    CardDeck(Card.Suits s, Value v)
    {
        super(s,v);
    }
    
}//end of class
