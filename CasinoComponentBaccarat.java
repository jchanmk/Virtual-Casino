import javax.swing.JComponent;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.BasicStroke;
import java.awt.Font;
import java.util.Random;
import java.util.Scanner;
import java.lang.Thread;
import java.lang.InterruptedException;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import javax.swing.ImageIcon;

//import java.lang.Math;
public class CasinoComponentBaccarat extends JComponent     // Class
{		
   int frameW, frameH;
   int chosenOption;
   int playerOption1;
   int playerCard1;
   int dealerCard1;
   int a = 52, b = 52, c = 52, d = 52, e = 52, f = 52, h = 52, j = 52, k = 52, m = 52, c1 = 4, c5 = 4, c25 = 4, c100 = 4;
   int bet, betHold, betHold2, bet100, bet25, bet5, betOne;
   int height100, height25, height5, height1;
   int playerCardHeight = 190;
   int dealerCardHeight = 515;
   boolean more = true;
   boolean more2 = true;
   boolean tie = false;
   boolean dealerCheck = false;
   Random r = new Random();
   ImageIcon[] deck;
   ImageIcon[] chips;
   ArrayList <Integer> playerCardArray = new ArrayList <Integer> ();
   ArrayList <Integer> dealerCardArray = new ArrayList <Integer> ();
   int [] values = {1, 2, 3, 4, 5, 6, 7, 8 , 9, 0, 0, 0, 0,
                    1, 2, 3, 4, 5, 6, 7, 8 , 9, 0, 0, 0, 0, 
                    1, 2, 3, 4, 5, 6, 7, 8 , 9, 0, 0, 0, 0, 
                    1, 2, 3, 4, 5, 6, 7, 8 , 9, 0, 0, 0, 0, 0};
   int playerPoints;
   int dealerPoints;
   String s1 = "YOU WIN!";
   String s2 = "YOU LOSE!";
   String s3 = "  ";
   String s4 = "  ";
   String s5 = "  ";
   String s6 = "  ";
   String s7 = "TIE";
   String s8 = "  ";
   String s9 = "NATURAL!";
   String s10 = "Minimum bet is $10";
   String balanceString = "0";
   String balanceWord = "Balance: $";
   String sCharlie = "  ";
   String sBankrupt1 = "  ";
   String sBankrupt = "Bankrupt!";
   int balance;// = Integer.parseInt(balanceString); 
      ImageIcon[] combos;


   

   public CasinoComponentBaccarat(int fW, int fH, ImageIcon[] cards, ImageIcon[] coins, int wallet, ImageIcon[] slots)
   {
      deck = cards;
      balance = wallet;
      chips = coins;
      frameW = fW;
      frameH = fH;
            combos = slots;

     // Graphics g3 = (Graphics2D) g;
   }
   
   public void update() throws InterruptedException
   {
      do
      {
       //  int balance = Integer.parseInt(balanceString); 
      
      /////////RESET GAME///////
         c100 = 4; c25 = 4; c5 = 4; c1 = 4; playerCardHeight = 190; dealerCardHeight = 515;
         s3 = s5;
         s4 = s5;
         s6 = s5;
         s8 = s5;
         playerCardArray.clear();
         dealerCardArray.clear();
         dealerPoints = 0; playerPoints = 0;
         tie = false;
         dealerCheck = false;
         repaint();
      ///////////////////////////
         Object [] MainOpts = {"Play Baccarat!", "Quit"};     //Main Menu
         chosenOption = JOptionPane.showOptionDialog(null, "Click an option", 
               "Blackjack Options", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
               null, MainOpts, MainOpts[0]);
               
         if(chosenOption == 1)
         {
            break;
         }
         
         Object [] PlayerOpts = {"Player", "Banker", "Tie"};     //Main Menu
         playerOption1 = JOptionPane.showOptionDialog(null, "What would you like to bet on?", 
               "Blackjack Options", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
               null, PlayerOpts, PlayerOpts[0]);
               
               
         String bet1 = JOptionPane.showInputDialog("Place your bet");
         bet = Integer.parseInt(bet1); 
         
         if(bet > balance)
         {
            JOptionPane.showMessageDialog(null, "Insufficient Funds!", "Error", JOptionPane.ERROR_MESSAGE);
            continue;
         }
         else if(bet < 10)
         {
            JOptionPane.showMessageDialog(null, "Minimum bet is $10!", "Error", JOptionPane.ERROR_MESSAGE);
            continue;
         }
         
         //////////////Chips Animation/////////////
         betHold = bet; 
         betHold2 = bet;//original bet needed for calculations later  
        
         bet /= 100;
         if(bet > 0)
         {
            bet100 = bet;
            if (playerOption1 == 0)
            {
               c100 = 3;
               height100 = 480;
            }
            
            else if(playerOption1 == 1)
            {
               c100 = 3;
               height100 = 360;
            }
            else if(playerOption1 == 2)
            {
               c100 = 3;
               height100 = 210;
            }
         }
      
         bet = betHold;
      
         bet %= 100;
         betHold = bet;
      
         bet /= 25;
         if(bet > 0)
         {
            bet25 = bet;
            
            if (playerOption1 == 0)
            {
               c25 = 2;
               height25 = 530;
            }
            else if(playerOption1 == 1)
            {
               c25 = 2;
               height25 = 410;
            }
            else if(playerOption1 == 2)
            {
               c25 = 2;
               height25 = 260;
            }
         }
      
         bet = betHold;
      
         bet %= 25;
         betHold = bet;
      
         bet /= 5;
         if(bet > 0)
         {
            bet5 = bet;
            
            if (playerOption1 == 0)
            {
               c5 = 1;
               height5 = 480;
            }
            else if(playerOption1 == 1)
            {
               c5 = 1;
               height5 = 360;
            }
            else if(playerOption1 == 2)
            {
               c5 = 1;
               height5 = 210;
            }
         }
      
         bet = betHold;
      
         bet %= 5;
         if(bet > 0)
         {
            betOne = bet;
            
            if (playerOption1 == 0)
            {
               c1 = 0;
               height1 = 520;
            }
            else if(playerOption1 == 1)
            {
               c1 = 0;
               height1 = 400;
            }
            else if(playerOption1 == 2)
            {
               c1 = 0;
               height1 = 250;
            }
         }
      
         bet = betHold2;
         repaint();
         
      /////////////Cards dealing/////////////////////
      
         try{Thread.sleep(500);}
         catch(InterruptedException e) {}
         for(int i = 0; i < 2; i++){
            playerCard1 = r.nextInt(52);
            playerCardArray.add(playerCard1);
            
            dealerCard1 = r.nextInt(52);
            dealerCardArray.add(dealerCard1);
            
            playerPoints += values[playerCard1];
            dealerPoints += values[dealerCard1];
            if(playerPoints >= 10)
               playerPoints -= 10;
            
            if(dealerPoints >= 10)
               dealerPoints -= 10;
         }
         //System.out.println(playerPoints + " " + dealerPoints); //Diagnostic Check
         
         if (playerOption1 == 0)
         {
            height100 = 480;
            height25 = 530;
            height5 = 480;
            height1 = 520;
         }
            
         else if(playerOption1 == 1)
         {
            height100 = 360;
            height25 = 410;
            height5 = 360;
            height1 = 400;
         
         
         }
         else if(playerOption1 == 2)
         {
            height100 = 210;
            height25 = 260;
            height5 = 210;
            height1 = 250;
         }
         repaint();
         
         /////Wins /Losses off initial Deal/////////
         if((playerPoints == 8 || playerPoints ==9) && playerPoints == dealerPoints && playerOption1 == 2){  //Tie Win
            s6 = s7;
            s3 = s1; 
            if (playerOption1 == 0)
            {
               height100 = 480;
               height25 = 530;
               height5 = 480;
               height1 = 520;
            }
            
            else if(playerOption1 == 1)
            {
               height100 = 360;
               height25 = 410;
               height5 = 360;
               height1 = 400;
            
            
            }
            else if(playerOption1 == 2)
            {
               height100 = 210;
               height25 = 260;
               height5 = 210;
               height1 = 250;
            }
            tie = true;
            
            bet100 *= 9;
            bet25 *= 9;
            bet5 *= 9;
            betOne *= 9; 
            
            balance += 9*bet;
            repaint();
         }
         else if((playerPoints == 8 || playerPoints ==9) && playerPoints == dealerPoints && playerOption1 != 2){ //Tie lose
            s6 = s7;
            s4 = s2;
            if (playerOption1 == 0)
            {
               height100 = 480;
               height25 = 530;
               height5 = 480;
               height1 = 520;
            }
            
            else if(playerOption1 == 1)
            {
               height100 = 360;
               height25 = 410;
               height5 = 360;
               height1 = 400;
            
            
            }
            else if(playerOption1 == 2)
            {
               height100 = 210;
               height25 = 260;
               height5 = 210;
               height1 = 250;
            }
            balance -= bet;
            bet100 = 0;
            bet25 = 0;
            bet5 = 0;
            betOne = 0; 
            repaint();
            tie = true;
         }
         
         if((playerPoints == 8 || playerPoints == 9) && (playerPoints > dealerPoints) && (playerOption1 == 0) && !tie){ //PLAYER NATURAL WIN
            s3 = s1; //win
            s8 = s9;
            tie = true;
            if (playerOption1 == 0)
            {
               height100 = 480;
               height25 = 530;
               height5 = 480;
               height1 = 520;
            }
            
            else if(playerOption1 == 1)
            {
               height100 = 360;
               height25 = 410;
               height5 = 360;
               height1 = 400;
            
            
            }
            else if(playerOption1 == 2)
            {
               height100 = 210;
               height25 = 260;
               height5 = 210;
               height1 = 250;
            }
            
            bet100 *= 2;
            bet25 *= 2;
            bet5 *= 2;
            betOne *= 2; 
            
            balance += bet;
            repaint();
         }
         else if((playerPoints == 8 || playerPoints == 9) && (playerPoints > dealerPoints) && (playerOption1 != 0) && !tie){  //PLAYER NATURAL LOSE
            s4 = s2;
            s8 = s9;
            tie = true;
            if (playerOption1 == 0)
            {
               height100 = 480;
               height25 = 530;
               height5 = 480;
               height1 = 520;
            }
            
            else if(playerOption1 == 1)
            {
               height100 = 360;
               height25 = 410;
               height5 = 360;
               height1 = 400;
            
            
            }
            else if(playerOption1 == 2)
            {
               height100 = 210;
               height25 = 260;
               height5 = 210;
               height1 = 250;
            }
            
            bet100 = 0;
            bet25 = 0;
            bet5 = 0;
            betOne = 0; 
            
            balance -= bet;
            repaint();
         }
        
         if((dealerPoints == 8 || dealerPoints == 9) && (playerPoints < dealerPoints) && (playerOption1 == 1) && !tie){ //DEALER NATURAL WIN
            s3 = s1;
            s8 = s9;
            tie = true;
            if (playerOption1 == 0)
            {
               height100 = 480;
               height25 = 530;
               height5 = 480;
               height1 = 520;
            }
            
            else if(playerOption1 == 1)
            {
               height100 = 360;
               height25 = 410;
               height5 = 360;
               height1 = 400;
            
            
            }
            else if(playerOption1 == 2)
            {
               height100 = 210;
               height25 = 260;
               height5 = 210;
               height1 = 250;
            }
            
            bet100 *= 2;
            bet25 *= 2;
            bet5 *= 2;
            betOne *= 2; 
            
            balance += bet;
            repaint();
         }
         else if((dealerPoints == 8 || dealerPoints == 9) && (dealerPoints > playerPoints) && (playerOption1 != 1) && !tie){ //DEALER NATURAL LOSE
            s4 = s2;
            s8 = s9;
            tie = true;
            if (playerOption1 == 0)
            {
               height100 = 480;
               height25 = 530;
               height5 = 480;
               height1 = 520;
            }
            
            else if(playerOption1 == 1)
            {
               height100 = 360;
               height25 = 410;
               height5 = 360;
               height1 = 400;
            }
            else if(playerOption1 == 2)
            {
               height100 = 210;
               height25 = 260;
               height5 = 210;
               height1 = 250;
            }
            
            bet100 = 0;
            bet25 = 0;
            bet5 = 0;
            betOne = 0; 
            
            balance -= bet;
            repaint();
         }
      
         if(playerPoints <= 5 && !tie){            //////Player hit or not
            playerCard1 = r.nextInt(52);
            playerCardArray.add(playerCard1);            
            playerPoints += values[playerCard1];
            if(playerPoints >= 10)
               playerPoints -= 10;
            
            if (playerOption1 == 0)
            {
               height100 = 480;
               height25 = 530;
               height5 = 480;
               height1 = 520;
            }
            
            else if(playerOption1 == 1)
            {
               height100 = 360;
               height25 = 410;
               height5 = 360;
               height1 = 400;
            }
            else if(playerOption1 == 2)
            {
               height100 = 210;
               height25 = 260;
               height5 = 210;
               height1 = 250;
            }
            repaint();   
               
         }
        
         if(dealerPoints < 3 && !tie){
            dealerCard1 = r.nextInt(52);
            dealerCardArray.add(dealerCard1);            
            dealerPoints += values[dealerCard1];
            if(dealerPoints >= 10)
               dealerPoints -= 10;
               
            if (playerOption1 == 0)
            {
               height100 = 480;
               height25 = 530;
               height5 = 480;
               height1 = 520;
            }
            
            else if(playerOption1 == 1)
            {
               height100 = 360;
               height25 = 410;
               height5 = 360;
               height1 = 400;
            }
            else if(playerOption1 == 2)
            {
               height100 = 210;
               height25 = 260;
               height5 = 210;
               height1 = 250;
            }
            dealerCheck = true;
            repaint();
         }
        
        //IF PLAYER HITS, THEN DEALER FOLLOWS THESE ACTIONS
         if(playerCardArray.size() == 3){
            if (dealerPoints == 3 && values[playerCard1] != 8 && !dealerCheck)
            {
               dealerCard1 = r.nextInt(52);
               dealerCardArray.add(dealerCard1);            
               dealerPoints += values[dealerCard1];
               if(dealerPoints >= 10)
                  dealerPoints -= 10;
            }
            else if (dealerPoints == 4 && (values[playerCard1]!= 1 || values[playerCard1]!= 8 || values[playerCard1]!= 9 ||values[playerCard1]!= 0) && !tie && !dealerCheck)
            {
               dealerCard1 = r.nextInt(52);
               dealerCardArray.add(dealerCard1);            
               dealerPoints += values[dealerCard1];
               if(dealerPoints >= 10)
                  dealerPoints -= 10;
            }  
            else if (dealerPoints == 5 && (values[playerCard1] ==4 ||values[playerCard1] == 5 ||values[playerCard1]==6 || values[playerCard1] == 7) && !tie && !dealerCheck)
            {
               dealerCard1 = r.nextInt(52);
               dealerCardArray.add(dealerCard1);            
               dealerPoints += values[dealerCard1];
               if(dealerPoints >= 10)
                  dealerPoints -= 10;
            }
            else if (dealerPoints == 6 && (values[playerCard1] == 6 || values[playerCard1] == 7) && !tie && !dealerCheck)
            {
               dealerCard1 = r.nextInt(52);
               dealerCardArray.add(dealerCard1);            
               dealerPoints += values[dealerCard1];
               if(dealerPoints >= 10)
                  dealerPoints -= 10;
            }
            if (playerOption1 == 0)
            {
               height100 = 480;
               height25 = 530;
               height5 = 480;
               height1 = 520;
            }
            
            else if(playerOption1 == 1)
            {
               height100 = 360;
               height25 = 410;
               height5 = 360;
               height1 = 400;
            }
            else if(playerOption1 == 2)
            {
               height100 = 210;
               height25 = 260;
               height5 = 210;
               height1 = 250;
            }
            repaint();
         }
         
         ////////////////////////MESSAGES////////////////////////
         if(playerOption1 == 0 && playerPoints > dealerPoints && !tie) //Win
         {
            s3 = s1;
            balance += bet;
            height100 = 480;
            height25 = 530;
            height5 = 480;
            height1 = 520;
            bet100 *= 2;
            bet25 *= 2;
            bet5 *= 2;
            betOne *= 2; 
            repaint();
         }
         else if(playerPoints == dealerPoints && playerOption1 != 2 && !tie)
         {
            s6 = s7;
         }
         else if(playerOption1 == 1 && playerPoints < dealerPoints && !tie) //Win
         {
            s3 = s1;
            balance += bet;
            height100 = 360;
            height25 = 410;
            height5 = 360;
            height1 = 400;
            bet100 *= 2;
            bet25 *= 2;
            bet5 *= 2;
            betOne *= 2; 
            repaint();
         }
         else if(playerOption1 == 2 && playerPoints == dealerPoints && !tie) //Win on the Tie
         {
            s3 = s1;
            s6 = s7;
            balance += 9*bet;
            height100 = 210;
            height25 = 260;
            height5 = 210;
            height1 = 250;
            bet100 *= 9;
            bet25 *= 9;
            bet5 *= 9;
            betOne *= 9; 
            repaint();
         }
         else if(playerOption1 == 2 && playerPoints != dealerPoints && !tie) //Lose on the Tie
         {
            s4 = s2;
            balance -= bet;
            height100 = 210;
            height25 = 260;
            height5 = 210;
            height1 = 250;
            bet100 = 0;
            bet25 = 0;
            bet5 = 0;
            betOne = 0; 
            repaint();
         }
         else if (((playerOption1 == 0 && dealerPoints>playerPoints) || (playerOption1 == 1 && playerPoints>dealerPoints)) && !tie)
         {
            s4 = s2;
            balance -= bet;
            bet100 = 0;
            bet25 = 0;
            bet5 = 0;
            betOne = 0; 
            if (playerOption1 == 0)
            {
               height100 = 480;
               height25 = 530;
               height5 = 480;
               height1 = 520;
            }
            
            else if(playerOption1 == 1)
            {
               height100 = 360;
               height25 = 410;
               height5 = 360;
               height1 = 400;
            }
            repaint();
         }
      
         if(balance == 0)
         {
            sBankrupt1 = sBankrupt;
            repaint();
            JOptionPane.showMessageDialog(null, "Out of money! Know when to quit!", "Error", JOptionPane.ERROR_MESSAGE);
            break;
         }
         
         
         int again = JOptionPane.showConfirmDialog(null,
               "Would you like to play again?", "Continue?", JOptionPane.YES_NO_OPTION);
         if(again == 1)
         {
            break;
         }
      
      
      }while(true);
      c100 = 4; c25 = 4; c5 = 4; c1 = 4; playerCardHeight = 190; dealerCardHeight = 515;
      s3 = s5;
      s4 = s5;
      s6 = s5;
      s8 = s5;
      playerCardArray.clear();
      dealerCardArray.clear();
      dealerPoints = 0; playerPoints = 0;
      tie = false;
      dealerCheck = false;
      repaint();
      
   }
   public void paintComponent( Graphics g )    // Method: paintComponent
   {
      //background
      Graphics g2 = (Graphics2D) g;
      ImageIcon bg = new ImageIcon("baccarat_table.png");
      bg.setImage(bg.getImage().getScaledInstance(1000, 900, 0));
      bg.paintIcon(this, g2, 0, -100);
      
      //Chips  
      for(int i = 0; i < betOne; i++){
         height1 -= 6;
         Graphics g22 = (Graphics2D) g;
         ImageIcon chip1 = chips[c1];
         chip1.setImage(chip1.getImage().getScaledInstance(120, 120, 0));
         chip1.paintIcon(this, g22, 300, height1);
      }
      
      for(int i = 0; i < bet5; i++){
         height5 -= 6;
         Graphics g23 = (Graphics2D) g;
         ImageIcon chip5 = chips[c5];
         chip5.setImage(chip5.getImage().getScaledInstance(120, 120, 0));
         chip5.paintIcon(this, g23, 530, height5);
      }
      
      for(int i = 0; i < bet25; i++){
         height25 -= 6;
         Graphics g24 = (Graphics2D) g;
         ImageIcon chip25 = chips[c25];
         chip25.setImage(chip25.getImage().getScaledInstance(120, 120, 0));
         chip25.paintIcon(this, g24, 470, height25);
      }
      
      for(int i = 0; i < bet100; i++){
         height100 -= 6;
         Graphics g25 = (Graphics2D) g;
         ImageIcon chip100 = chips[c100];
         chip100.setImage(chip100.getImage().getScaledInstance(120, 120, 0));
         chip100.paintIcon(this, g25, 350, height100);
      }
      
      //Player Deal
      for(int i = 0; i < playerCardArray.size(); i++){
         playerCardHeight += 75;
         Graphics g3 = (Graphics2D) g;
         ImageIcon playerCard = deck [playerCardArray.get(i)];
         playerCard.setImage(playerCard.getImage().getScaledInstance(70, 90, 0));
         playerCard.paintIcon(this, g3, playerCardHeight, 130); 
      }
      //Banker Deal
      for(int i = 0; i < dealerCardArray.size(); i++){
         dealerCardHeight += 75;
         Graphics g3 = (Graphics2D) g;
         ImageIcon playerCard = deck [dealerCardArray.get(i)];
         playerCard.setImage(playerCard.getImage().getScaledInstance(70, 90, 0));
         playerCard.paintIcon(this, g3, dealerCardHeight, 130); 
      }
      
      //Balance message
      Font f3 = new Font ("serif", Font.BOLD, 30);
      Graphics2D g18 = (Graphics2D) g;               //Balance number message
      g18.setColor(Color.WHITE);
      g18.setFont(f3);  
      g18.setStroke(new BasicStroke (10.0F, BasicStroke.CAP_BUTT, 
                                           BasicStroke.JOIN_BEVEL));                                                                        
      g18.drawString(Integer.toString(balance) , 170, 500);
      
      Graphics2D g19 = (Graphics2D) g;               //Balance word message
      g19.setColor(Color.WHITE);
      g19.setFont(f3);  
      g19.setStroke(new BasicStroke (10.0F, BasicStroke.CAP_BUTT, 
                                           BasicStroke.JOIN_BEVEL));                                                                        
      g19.drawString(balanceWord , 30, 500);
      
      //End messages
      Graphics2D g13 = (Graphics2D) g;               //win message
      Font f1 = new Font ("serif", Font.BOLD, 70);
      g13.setColor(Color.WHITE);
      g13.setFont(f1);  
      g13.setStroke(new BasicStroke (10.0F, BasicStroke.CAP_BUTT, 
                                           BasicStroke.JOIN_BEVEL));                                                                        
      g13.drawString(s3, 20,100);
      
      Graphics2D g16 = (Graphics2D) g;               //Natural message
      g16.setColor(Color.YELLOW);
      g16.setFont(f1);  
      g16.setStroke(new BasicStroke (10.0F, BasicStroke.CAP_BUTT, 
                                           BasicStroke.JOIN_BEVEL));                                                                        
      g16.drawString(s8, 40,400);
      
      Graphics2D g14 = (Graphics2D) g;               //lose message
      g14.setColor(Color.WHITE);
      g14.setFont(f1);  
      g14.setStroke(new BasicStroke (10.0F, BasicStroke.CAP_BUTT, 
                                           BasicStroke.JOIN_BEVEL));                                                                        
      g14.drawString(s4, 20,100);
      
      Graphics2D g15 = (Graphics2D) g;               //tie message
      g15.setColor(Color.WHITE);
      g15.setFont(f1);  
      g15.setStroke(new BasicStroke (10.0F, BasicStroke.CAP_BUTT, 
                                           BasicStroke.JOIN_BEVEL));                                                                        
      g14.drawString(s6, 660,100);
   
      
   }
}