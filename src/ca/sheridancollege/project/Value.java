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
public enum Value {
    
    Ace(13), 
    Two(1), 
    Three(2), 
    Four(3), 
    Five(4), 
    Six(5), 
    Seven(6), 
    Eight(7), 
    Nine(8), 
    Ten(9), 
    Jack(10), 
    Queen(11), 
    King(12);
    
    
    private final int value;

    public int getValue() {
        return value;
    }

    private Value(int value) {
        this.value = value;
    }
    
}
