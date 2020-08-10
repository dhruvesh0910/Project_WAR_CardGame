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
import java.util.Iterator;


/**
 *
 * @author Dhruvesh Patel
 */
public class PlayersGame extends Player {

    private int numPlayer;
    public int i=0,j=0;
    
    String s;
    
    ArrayList<Card> temp = new ArrayList();
    
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
            System.out.println("p1-->"+p1.size());
            System.out.println("p2 -->"+p2.size());
            System.out.println("-------------------");
            System.out.println(gameStart());
            System.out.println("p1-->"+p1.size());
            System.out.println("p2 -->"+p2.size());
            //System.out.println(p1.get(1));
            //System.out.println(p1.get(1).getValue().getValue());
        }
    }
  
    public String gameStart()
    {
        
        
        //while(!p1.isEmpty() && !p2.isEmpty())
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
            check();
            j=0;
            System.out.println("p1-->"+p1.size());
            System.out.println("p2 -->"+p2.size());
            
        }
        if(!p1.isEmpty())
        {
            s = super.getPlayerID1()+" Player 1 win the game.";
            //p1.addAll(temp);
        }
        else
        {
            s = super.getPlayerID2()+" Player 2 win the game.";
            //p2.addAll(temp);
        }
        return s;
    }
    public void check()
    {
        System.out.println("temp -->" +temp.size());
        System.out.println("i -->" +i);
        if(temp.get(j-1).getValue().getValue() < temp.get(j-2).getValue().getValue())
            {
               // System.out.println(temp.get(j-1).getValue().getValue());
                //System.out.println(temp.get(j-2).getValue().getValue());
                System.out.println("p1 won");
                for(int k=0;k<temp.size();k++) {
                    p1.add(temp.get(k));
                    
                }
                temp.clear();
            }
            else if(temp.get(j-1).getValue().getValue() > temp.get(j-2).getValue().getValue())
            {
                System.out.println("p2 won");
                for(int k=0;k<temp.size();k++) {
                    p2.add(temp.get(k));
                    
                }
                temp.clear();
            }
            else
            {
                System.out.println("p1-->"+p1.size());
            System.out.println("p2 -->"+p2.size());
                System.out.println("War Begins: ");
                if(p1.size()<=5)
                {
                    s = super.getPlayerID2()+ " Player 2 win the game.";
                    p2.addAll(temp);
                    temp.clear();
                }
                else if(p2.size()<=5)
                {
                    s = super.getPlayerID1()+ " Player 1 win the game.";
                    p1.addAll(temp);
                    temp.clear();
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
                check();         
                }
            }
    }
  
}
