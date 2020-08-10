/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project;

/**
 *
 * @author Dhruvesh Patel
 */
public class DeclareWinner extends Game{

    String winnerName;
    public DeclareWinner(String name)
    {
        super("War Game");
        winnerName = name;
    }
    
    @Override
    public void play() {
        
    }

    @Override
    public void declareWinner() {
        System.out.println("---------------------------------------------------");
        System.out.println(super.getGameName());
        System.out.println(winnerName+" won the Game.");
        System.out.println("---------------------------------------------------");
    }
    
}
