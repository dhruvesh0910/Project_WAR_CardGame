/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project;

/**
 * This class declare the winner name.
 * @author Dhruvesh Patel
 */
public class DeclareWinner extends Game{

    String winnerName; //declaration of string variable.
    
    /**
     * parameterize constructor to set the name of the game and name of the winner.
     * @param name set name of the winner
     */
    public DeclareWinner(String name)
    {
        super("War Game");
        winnerName = name;
    }
    
    @Override
    public void play() {
        
    }

    /**
     * declare name of the winner
     */
    @Override
    public void declareWinner() {
        System.out.println("---------------------------------------------------");
        System.out.println(super.getGameName());
        System.out.println(winnerName+" won the Game.");
        System.out.println("---------------------------------------------------");
    }// end of declareWinner method.
    
}// end of class
