/**
 * SYST 17796 Project Winter 2019 Base code.
 * Students can modify and extend to implement their game.
 * Add your name as a modifier and the date!
 */
package ca.sheridancollege.project;

import java.util.*;

/**
 * A class to be used as the base Card class for the project. Must be general
 * enough to be instantiated for any Card game. Students wishing to add to the code 
 * should remember to add themselves as a modifier.
 * @author dancye, 2018
 * @modified by Dhruvesh Hemantkumar Patel - 991580791
 */
public abstract class Card 
{
    //default modifier for child classes
    
    /**
     * Students should implement this method for their specific children classes 
     * @return a String representation of a card. Could be an UNO card, a regular playing card etc.
     */
    
    @Override
    public String toString()
    {
        return suit+" -- >"+value;
    }
     
    // Enum class for the suits
    public enum Suits{Heart, Diamond, Spades, Clubs};
    
    private Suits suit;
    private Value value;
    
    // Parameterized Constructor for the class card 
    public Card(Suits s, Value v)
    {
        suit = s;
        value = v;
    }//end of method
    
    // public getters for the value and suits
    public Value getValue() {
		return this.value;
	}//end of method

	
    public Suits getSuit() {
		return this.suit;
        }//end of method
    
    
    
}//end of class
