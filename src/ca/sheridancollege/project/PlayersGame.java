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
            System.out.println("p1-->"+p1.size());
            System.out.println("p2 -->"+p2.size());
            System.out.println("p3 -->"+p3.size());
            System.out.println("-------------------");
            System.out.println(play3());
            //System.out.println(p1.get(1));
            //System.out.println(p1.get(1).getValue().getValue());
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
            System.out.println("p1-->"+p1.size());
            System.out.println("p2 -->"+p2.size());
            System.out.println("-------------------");
            System.out.println(gameStart(p1,p2));
            System.out.println("p1-->"+p1.size());
            System.out.println("p2 -->"+p2.size());
            //System.out.println(p1.get(1));
            //System.out.println(p1.get(1).getValue().getValue());
        }
    }
    
    public String play3()
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
            check3();
            j=0;
            System.out.println("p1-->"+p1.size());
            System.out.println("p2 -->"+p2.size());
            System.out.println("p3 -->"+p3.size());
            
            if(p1.size()<1 && p2.size()>1 && p3.size()>1)
            {
                gameStart(p2,p3);
            }
            else if(p1.size()>1 && p2.size()<1 && p3.size()>1)
            {
                gameStart(p1,p3);
            }
            else if(p1.size()>1 && p2.size()>1 && p3.size()<1)
            {
                gameStart(p1,p2);
            }
        }
        if(!p1.isEmpty() && p2.isEmpty() && p3.isEmpty())
        {
            s = super.getPlayerID1()+" Player 1 win the game.";
            //p1.addAll(temp);
        }
        else if(p1.isEmpty() && !p2.isEmpty() && p3.isEmpty())
        {
            s = super.getPlayerID2()+" Player 2 win the game.";
            //p2.addAll(temp);
        }
        else
        {
            s = super.getPlayerID3()+" Player 3 win the game.";
        }
        return s;
       
           
       
    }
    
    public String gameStart(ArrayList<Card> p1, ArrayList<Card> p2)
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
        /*int c=i-1;
        for(int k=0;k<p1.size()-i-1;k++)
        {
            p1.add(k,p1.get(c));
            c++;
        }
        c=i-1;
        for(int k=0;k<p2.size()-i-1;k++)
        {
            p2.add(k,p2.get(c));
            c++;
        }*/
    }
    
    public void check3()
    {
        System.out.println("temp -->" +temp.size());
        System.out.println("i -->" +i);
        if(temp.get(j-1).getValue().getValue() < temp.get(j-2).getValue().getValue() && temp.get(j-2).getValue().getValue() < temp.get(j-3).getValue().getValue())
            {
               // System.out.println(temp.get(j-1).getValue().getValue());
                //System.out.println(temp.get(j-2).getValue().getValue());
                System.out.println("p1 won");
                for(int k=0;k<temp.size();k++) {
                    p1.add(temp.get(k));
                    
                }
                temp.clear();
            }
            else if(temp.get(j-1).getValue().getValue() < temp.get(j-2).getValue().getValue() && temp.get(j-2).getValue().getValue() > temp.get(j-3).getValue().getValue())
            {
                System.out.println("p2 won");
                for(int k=0;k<temp.size();k++) {
                    p2.add(temp.get(k));
                    
                }
                temp.clear();
            }
            else if(temp.get(j-1).getValue().getValue() > temp.get(j-2).getValue().getValue() && temp.get(j-2).getValue().getValue() > temp.get(j-3).getValue().getValue())
            {
                System.out.println("p3 won");
                for(int k=0;k<temp.size();k++) {
                    p3.add(temp.get(k));
                    
                }
                temp.clear();
            }
            else
            {
                System.out.println("p1-->"+p1.size());
                System.out.println("p2 -->"+p2.size());
                System.out.println("p3 -->"+p3.size());
                System.out.println("War Begins: ");
                if(p1.size()<=3)
                {
                    gameStart(p2,p3);
                }
                else if(p2.size()<=3)
                {
                    gameStart(p1,p3);
                }
                else if(p3.size()<=3)
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
                check3();         
                }
            }
        /*int c=i-1;
        for(int k=0;k<p1.size()-i-1;k++)
        {
            p1.add(k,p1.get(c));
            c++;
        }
        c=i-1;
        for(int k=0;k<p2.size()-i-1;k++)
        {
            p2.add(k,p2.get(c));
            c++;
        }*/
    }
    
    
    
 /*   
    public String gameStart()
    {
        
        Iterator<Card> iterator1 = p1.iterator();
        Iterator<Card> iterator2 = p2.iterator();
        int index = 0,i=0;
        while(iterator1.hasNext() && iterator2.hasNext())
        {
            if(index == p1.size())
            {
                for(int c=0;c<temp.size();c++)
                {
                    p2.add(temp.get(c));
                }
            }
            else if(index == p2.size())
            {
                for(int c=0;c<temp.size();c++)
                {
                    p1.add(temp.get(c));
                }
            }
        else {
            //temp.add(iterator1.next());
            temp.add(p1.get(index));
            i++;
            temp.add(p2.get(index));
            i++;
            p1.remove(index);
            p2.remove(index);
            index++;
            
            if(temp.get(i-2).getValue().getValue() > temp.get(i-1).getValue().getValue())
            {
                System.out.println("inside if");
                p1.add(temp.get(i-2));
                p1.add(temp.get(i-1));
                temp.remove(--i);
                temp.remove(--i);
                
            }
            else if(temp.get(i-2).getValue().getValue() < temp.get(i-1).getValue().getValue())
            {
                System.out.println("inside else..if");
                p2.add(temp.get(i-2));
                p2.add(temp.get(i-1));
                temp.remove(--i);
                temp.remove(--i);
            }
            else
            {
                System.out.println("inside else");
               int j=0;
                do
                {
                    if(index == p1.size())
                    {
                        for(int c=0;c<temp.size();c++)
                        {
                            p2.add(temp.get(c));
                        }
                    }
                    else if(index == p2.size())
                    {
                        for(int c=0;c<temp.size();c++)
                        {
                            p1.add(temp.get(c));
                        }
                    }
                    else {
                    System.out.println("inside do..while loop");
                    temp.add(p1.get(index));
                    i++;
                    temp.add(p2.get(index));
                    i++;
                
                    p1.remove(index);
                    p2.remove(index);
                    index++;
                
                    temp.add(p1.get(index));
                    i++;
                    temp.add(p2.get(index));
                    i++;
                
                    p1.remove(index);
                    p2.remove(index);
                    index++;
                    
                   // Iterator<Card> iteratorTemp = temp.iterator();
                    
                    if(temp.get(i-2).getValue().getValue() > temp.get(i-1).getValue().getValue())
                    {
                        /*int i=0;
                        while(iteratorTemp.hasNext())
                        {
                            p1.add(temp.get(i));
                            temp.remove(i);
                            i++;
                        }*/
      /*                  
                        for(int k=0;k<((j+1)*4)+2;k++)
                        {
                            p1.add(temp.get((i-k)-1));
                            //temp.remove((i-j)-k);
                            //temp.remove((i-k)-1);
                        }
                        
                        
                        /*p1.add(temp.get(i-6));
                        p1.add(temp.get(i-5));
                        p1.add(temp.get(i-4));
                        p1.add(temp.get(i-3));
                        p1.add(temp.get(i-2));
                        p1.add(temp.get(i-1));*/
      /*              }
                    else if(temp.get(i-2).getValue().getValue() < temp.get(i-1).getValue().getValue())
                    {
                        for(int k=0;k<((j+1)*4)+2;k++)
                        {
                            p2.add(temp.get((i-k)-1));
                           //temp.remove(((i-j)-k)-1);
                           //temp.remove((i-k)-1);
                        }
                       
                        
                        /*p2.add(temp.get(i-6));
                        p2.add(temp.get(i-5));
                        p2.add(temp.get(i-4));
                        p2.add(temp.get(i-3));
                        p2.add(temp.get(i-2));
                        p2.add(temp.get(i-1));*/
     /*               }
                    }
                    j++;
                    System.out.println(i);
                }while(temp.get(i-2).getValue().getValue() == temp.get(i-1).getValue().getValue());
                
                for(int k=0;k<((j+1)*4)+2;k++)
                {
                    //p2.add(temp.get((i-k)-1));
                    //temp.remove(((i-j)-k)-1);
                    temp.remove(k-i);
                }
            }
            i=0;
            //iterator1 = p1.iterator();
            //iterator2 = p2.iterator();
        }
        }
        
        if(p2.size()==-1)
        {
            return "Player 1 Won Game.";
        }
        else if(p1.size()==-1)
        {
            return "Player 2 Won Game.";
        }
        else
            return "null";
    }
    
    
    */
    
}
