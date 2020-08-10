/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project;

//import static ca.sheridancollege.project.GroupOfCards.cards;
import java.util.ArrayList;
//import java.util.Collection;
import java.util.Collections;


/**
 *
 * @author Dhruvesh Patel
 */
public class PlayersGame extends Player {

    private int numPlayer;
    public int i=0,j=0;
    DeclareWinner dw;
    
    String s;
    
    ArrayList<Card> temp = new ArrayList();
    ArrayList<Card> temp1 = new ArrayList();
    
    ArrayList<Card> p1 = new ArrayList();
    ArrayList<Card> p2 = new ArrayList();
    ArrayList<Card> p3 = new ArrayList();

    public PlayersGame(int numPlayer, String player1,String player2) {
        super(player1,player2);
        this.numPlayer = numPlayer;
    }
    
    public PlayersGame(int numPlayer, String player1,String player2, String player3) {
        super(player1,player2,player3);
        this.numPlayer = numPlayer;
    }
    
    public int getNumPlayer() {
        return numPlayer;
    }

    public void setNumPlayer(int numPlayer) {
        this.numPlayer = numPlayer;
    }
    
    
    @Override
    public void play()
    {
        if(numPlayer == 3)
        {
             GroupOfCards.shuffle();
        
            int t=0;
            while(t<17)
            {
                p1.add(GroupOfCards.getCards().get(t));
                System.out.println(p1.get(t));
                t++;
            }
            System.out.println("-------------------");
            while(t>16 && t<34)
            {
                p2.add(t-17,GroupOfCards.getCards().get(t));
                System.out.println(p2.get(t-17));
                t++;
            }
            System.out.println("-------------------");
            while(t>33 && t<51)
            {
                p3.add(t-34,GroupOfCards.getCards().get(t));
                System.out.println(p3.get(t-34));
                t++;
            }
            System.out.println("-------------------");
            System.out.println(super.getPlayerID1()+" has "+p1.size()+" Cards in deck");
            System.out.println(super.getPlayerID2()+" has "+p2.size()+" Cards in deck");
            System.out.println(super.getPlayerID3()+" has "+p3.size()+" Cards in deck");
            System.out.println("-------------------");
            System.out.println(gameStart(p1,p2,p3));
            System.out.println(super.getPlayerID1()+" has "+p1.size()+" Cards in deck");
            System.out.println(super.getPlayerID2()+" has "+p2.size()+" Cards in deck");
            System.out.println(super.getPlayerID3()+" has "+p3.size()+" Cards in deck");
           
            dw.declareWinner();
        }
            
        if(numPlayer == 2)
        {
            
            GroupOfCards.shuffle();
        
            int t=0;
            while(t<26)
            {
                p1.add(GroupOfCards.getCards().get(t));
                System.out.println(p1.get(t));
                t++;
            }
            System.out.println("-------------------");
            while(t>25 && t<52)
            {
                p2.add(t-26,GroupOfCards.getCards().get(t));
                System.out.println(p2.get(t-26));
                t++;
            }
            System.out.println("-------------------");
            System.out.println(super.getPlayerID1()+" has "+p1.size()+" Cards in deck");
            System.out.println(super.getPlayerID2()+" has "+p2.size()+" Cards in deck");
            System.out.println("-------------------");
            System.out.println(gameStart(p1,p2));
            System.out.println(super.getPlayerID1()+" has "+p1.size()+" Cards in deck");
            System.out.println(super.getPlayerID2()+" has "+p2.size()+" Cards in deck");
            
            dw.declareWinner();
        }
    }
     /**
      * code for two players
      * @param p1
      * @param p2
      * @return 
      */    
    public String gameStart(ArrayList<Card> p1, ArrayList<Card> p2)
    {

        while(p1.size()>0 && p2.size()>0)
        {
            Collections.shuffle(p1);
            Collections.shuffle(p2);
            //System.out.println(p1.get(13));
            i=0;
            j=0;
            temp.add(p1.get(i));
            j++;
           
            temp.add(p2.get(i));
            j++;
            
            p1.remove(i);
            p2.remove(i);
            
            i++;
            checkForTwoPlayers();
            j=0;
            
            
        }
        if(!p1.isEmpty())
        {
            s = super.getPlayerID1()+" won the game.";
            p1.addAll(temp);
            dw = new DeclareWinner(super.getPlayerID1());
        }
        else
        {
            s = super.getPlayerID2()+" won the game.";
            p2.addAll(temp);
            dw = new DeclareWinner(super.getPlayerID2());
        }
        return s;
    }
    public void checkForTwoPlayers()
    {
        System.out.println("There are "+temp.size()+" cards on table for playing.");
        System.out.println("i -->" +i);
        if(temp.get(j-1).getValue().getValue() < temp.get(j-2).getValue().getValue())
            {
               // System.out.println(temp.get(j-1).getValue().getValue());
                //System.out.println(temp.get(j-2).getValue().getValue());
                System.out.println(super.getPlayerID1()+" won this round.");
                for(int k=0;k<temp.size();k++) {
                    p1.add(temp.get(k));
                    
                }
                temp.clear();
            }
            else if(temp.get(j-1).getValue().getValue() > temp.get(j-2).getValue().getValue())
            {
                System.out.println(super.getPlayerID2()+" won this round.");
                for(int k=0;k<temp.size();k++) {
                    p2.add(temp.get(k));
                    
                }
                temp.clear();
            }
            else
            {
                System.out.println(super.getPlayerID1()+" has "+p1.size()+" Cards in deck");
                System.out.println(super.getPlayerID2()+" has "+p2.size()+" Cards in deck");
                System.out.println("War Begins: ");
                if(p1.size()<=5)
                {
                    s = super.getPlayerID2()+ " won the game.";
                    p2.addAll(temp);
                    temp.clear();
                    dw = new DeclareWinner(super.getPlayerID2());
                }
                else if(p2.size()<=5)
                {
                    s = super.getPlayerID1()+ " won the game.";
                    p1.addAll(temp);
                    temp.clear();
                    dw = new DeclareWinner(super.getPlayerID1());
                }
                else {
                for(int k=0;k<3;k++)
                {
                    temp.add(p1.get(i));
                    p1.remove(i);
                    j++;
           
                    temp.add(p2.get(i));
                    p2.remove(i);
                    j++;
                    
                    i++;
                }
                checkForTwoPlayers();         
                }
            }
    }
    
    /**
     * Code for three players
     * @param p1
     * @param p2
     * @param p3
     * @return 
     */
    public String gameStart(ArrayList<Card> p1, ArrayList<Card> p2, ArrayList<Card> p3)
    {
        while(p1.size()>0 && p2.size()>0 && p3.size()>0)
        {
            Collections.shuffle(p1);
            Collections.shuffle(p2);
            Collections.shuffle(p3);
            //System.out.println(p1.get(13));
            i=0;
            j=0;
            temp.add(p1.get(i));
            j++;
           
            temp.add(p2.get(i));
            j++;
            
            temp.add(p3.get(i));
            j++;
            
            p1.remove(i);
            p2.remove(i);
            p3.remove(i);
            
            i++;
            checkForThreePlayers();
            j=0;
            
            if(p1.size()<1 && p2.size()>1 && p3.size()>1)
            {
                temp1.addAll(p1);
                gameStart(p2,p3);
            }
            else if(p1.size()>1 && p2.size()<1 && p3.size()>1)
            {
                temp1.addAll(p2);
                gameStart(p1,p3);
            }
            else if(p1.size()>1 && p2.size()>1 && p3.size()<1)
            {
                temp1.addAll(p3);
                gameStart(p1,p2);
            }
            
            
                System.out.println(super.getPlayerID1()+" has "+p1.size()+" Cards in deck");
                System.out.println(super.getPlayerID2()+" has "+p2.size()+" Cards in deck");
                System.out.println(super.getPlayerID3()+" has "+p3.size()+" Cards in deck");
           
        }
        if(!p1.isEmpty() && p2.isEmpty() && p3.isEmpty())
        {
            s = super.getPlayerID1()+" won the game.";
            p1.addAll(temp1);
            dw = new DeclareWinner(super.getPlayerID1());
        }
        else if(p1.isEmpty() && !p2.isEmpty() && p3.isEmpty())
        {
            s = super.getPlayerID2()+" won the game.";
            p2.addAll(temp1);
            dw = new DeclareWinner(super.getPlayerID2());
        }
        else
        {
            s = super.getPlayerID3()+" won the game.";
            p3.addAll(temp1);
            dw = new DeclareWinner(super.getPlayerID3());
        }
        return s;
       
           
       
    }
    
    public void checkForThreePlayers()
    {
        System.out.println("There are "+temp.size()+" cards on table for playing.");
        System.out.println("i -->" +i);
        if(temp.get(j-1).getValue().getValue() < temp.get(j-2).getValue().getValue() && temp.get(j-2).getValue().getValue() < temp.get(j-3).getValue().getValue())
            {
                System.out.println(super.getPlayerID1()+" won this round.");
                for(int k=0;k<temp.size();k++) {
                    p1.add(temp.get(k));
                    
                }
                temp.clear();
            }
            else if(temp.get(j-1).getValue().getValue() < temp.get(j-2).getValue().getValue() && temp.get(j-2).getValue().getValue() > temp.get(j-3).getValue().getValue())
            {
                System.out.println(super.getPlayerID2()+" won this round.");
                for(int k=0;k<temp.size();k++) {
                    p2.add(temp.get(k));
                    
                }
                temp.clear();
            }
            else if(temp.get(j-1).getValue().getValue() > temp.get(j-2).getValue().getValue() && temp.get(j-2).getValue().getValue() > temp.get(j-3).getValue().getValue())
            {
                System.out.println(super.getPlayerID3()+" won this round.");
                for(int k=0;k<temp.size();k++) {
                    p3.add(temp.get(k));
                    
                }
                temp.clear();
            }
            else
            {
                System.out.println(super.getPlayerID1()+" has "+p1.size()+" Cards in deck");
                System.out.println(super.getPlayerID2()+" has "+p2.size()+" Cards in deck");
                System.out.println(super.getPlayerID3()+" has "+p3.size()+" Cards in deck");
                System.out.println("War Begins: ");
                if(p1.size()<=5)
                {
                    gameStart(p2,p3);
                }
                else if(p2.size()<=5)
                {
                    gameStart(p1,p3);
                }
                else if(p3.size()<=5)
                {
                    gameStart(p1,p2);
                }
                else {
                for(int k=0;k<3;k++)
                {
                    temp.add(p1.get(k));
                    p1.remove(k);
                    j++;
           
                    temp.add(p2.get(k));
                    p2.remove(k);
                    j++;
                    
                    temp.add(p3.get(k));
                    p3.remove(k);
                    j++;
                    
                    i++;
                }
                checkForThreePlayers();         
                }
            }
    }
}
