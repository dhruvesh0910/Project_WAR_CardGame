/**
 * SYST 17796 Project Winter 2019 Base code.
 * Students can modify and extend to implement their game.
 * Add your name as a modifier and the date!
 */
package ca.sheridancollege.project;

/**
 * A class that models each Player in the game. Players have an identifier, which should be unique.
 * @author dancye, 2018
 * @modified by Dhruvesh Hemantkumar Patel - 991580791
 */
public abstract class Player 
{
    private String playerID1, playerID2, playerID3; //the unique ID for this player
    
    /**
     * A constructor that allows you to set the player's unique ID
     * @param player1 the unique ID to assign to player1.
     * @param player2 the unique ID to assign to player2.
     */
    public Player(String player1, String player2)
    {
        playerID1= player1;
        playerID2= player2;
    }
    
    /**
     * A constructor that allows you to set the player's unique ID
     * @param player1 the unique ID to assign to player1.
     * @param player2 the unique ID to assign to player2.
     * @param player3 the unique ID to assign to player3.
     */
    public Player(String player1, String player2, String player3)
    {
        playerID1= player1;
        playerID2= player2;
        playerID3 = player3;
    }
    
    /**
     * @return the playerID1
     */
    public String getPlayerID1() 
    {
        return playerID1;
    }

    /**
     * Ensure that the playerID is unique
     * @param givenID the playerID to set
     */
    public void setPlayerID1(String givenID) 
    {
        playerID1 = givenID;
    }
    
    /**
     * @return the playerID2
     */
    public String getPlayerID2() 
    {
        return playerID2;
    }

    /**
     * Ensure that the playerID2 is unique
     * @param givenID the playerID2 to set
     */
    public void setPlayerID2(String givenID) 
    {
        playerID2= givenID;
    }
    
    /**
     * @return the playerID3
     */
    public String getPlayerID3() 
    {
        return playerID3;
    }

    /**
     * Ensure that the playerID3 is unique
     * @param givenID the playerID3 to set
     */
    public void setPlayerID3(String givenID) 
    {
        playerID3= givenID;
    }
    
    /**
     * The method to be instantiated when you subclass the Player class
     * with your specific type of Player and filled in with logic to play your game.
     */
    public abstract void play();
    
}// end of class
