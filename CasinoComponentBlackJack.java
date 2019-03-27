import javax.swing.JComponent;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.BasicStroke;
import java.awt.Font;
import java.util.Random;
import java.util.Scanner;
import java.lang.InterruptedException;
import javax.swing.JOptionPane;
import java.util.Scanner;
import java.util.ArrayList;
import javax.swing.ImageIcon;

//import java.lang.Math;
public class CasinoComponentBlackJack extends JComponent     // Class
{		
   int frameW, frameH;
   int chosenOption;
   int playerOption1;
   int playerOption2;
   int playerOption3;
   int a = 52, b = 52, c = 52, d = 52, e = 52, f = 52, h = 52, j = 52, k = 52, m = 52, c1 = 4, c5 = 4, c25 = 4, c100 = 4;

   int bet, betHold, betHold2, bet100, bet25, bet5, betOne;
   int height100, height25, height5, height1;
   boolean more = true;
   boolean more2 = true;
   Random r = new Random();
   ImageIcon[] deck;
   ImageIcon[] chips;
   int [] values = {11, 2, 3, 4, 5, 6, 7, 8 , 9, 10, 10, 10, 10,
                    11, 2, 3, 4, 5, 6, 7, 8 , 9, 10, 10, 10, 10, 
                    11, 2, 3, 4, 5, 6, 7, 8 , 9, 10, 10, 10, 10, 
                    11, 2, 3, 4, 5, 6, 7, 8 , 9, 10, 10, 10, 10, 0};
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
   String s9 = "BLACKJACK!";
   String s10 = "Minimum bet is $10";
   String balanceString = "0";
   String balanceWord = "Balance: $";
   String sCharlie = "  ";
   String sCharlie1 = "5 Card Charlie!";
   String sBankrupt1 = "  ";
   String sBankrupt = "Bankrupt!";
   int balance;
      ImageIcon[] combos;


   

   public CasinoComponentBlackJack(int fW, int fH, ImageIcon[] cards, ImageIcon[] coins, int wallet, ImageIcon[] slots)
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
    //  Scanner in = new Scanner(System.in);
      
      do
      {
         a = 52; b = 52; c = 52; d = 52; e = 52; f = 52; h = 52; j = 52; k = 52; m = 52; c1 = 4; c5 = 4; c25 = 4; c100 = 4; 
         s3 = s5;
         s4 = s5;
         s6 = s5;
         s8 = s5;
         sCharlie = s5;
         playerPoints = 0;
         dealerPoints = 0;
         repaint();
      
         Object [] MainOpts = {"Play Blackjack", "Quit"};     //Main Menu
         chosenOption = JOptionPane.showOptionDialog(null, "Click an option", 
               "Blackjack Options", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
               null, MainOpts, MainOpts[0]);
               
         if(chosenOption == 1)
         {
            break;
         }
               
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
         
         
         
         betHold = bet; 
         betHold2 = bet;//original bet needed for calculations later  
        
         bet /= 100;
         if(bet > 0)
         {
            bet100 = bet;
            c100 = 3;
            height100 = 410;
         }
      
         bet = betHold;
      
         bet %= 100;
         betHold = bet;
      
         bet /= 25;
         if(bet > 0)
         {
            bet25 = bet;
            
            c25 = 2;
            height25 = 390;
         }
      
         bet = betHold;
      
         bet %= 25;
         betHold = bet;
      
         bet /= 5;
         if(bet > 0)
         {
            bet5 = bet;
            c5 = 1;
            height5 = 390;
         }
      
         bet = betHold;
      
         bet %= 5;
         if(bet > 0)
         {
            betOne = bet;
            
         
            c1 = 0;
            height1 = 400;
           
         }
         bet = betHold2;
         repaint();
         try{Thread.sleep(500);}
         catch(InterruptedException e) {}
      
         if(chosenOption == 0)
         {
            a = r.nextInt(52);
            
            do{
               b = r.nextInt(52);
            }while(b == a);                     //No repeats of cards can appear
            
            do{
               c = r.nextInt(52);
            }while(c == a || c == b);
            playerPoints = values [a] + values [b];
            dealerPoints = values [c];
            height100 = 410;
            height25 = 390;
            height5 = 390;
            height1 = 400;
            repaint();
         }
            
       ////////////////////////////////Player deal//////////////////////////////////////////////
      
         do
         {
            if(playerPoints == 21)                    //blackjack
            {
               s8 = s9;
               balance += bet/2;
               height100 = 410;
               height25 = 390;
               height5 = 390;
               height1 = 400;
               
               bet100 *= 1.5;
               bet25 *= 1.5;
               bet5 *= 1.5;
               betOne *= 1.5; 
            System.out.println(playerPoints);
               
               repaint();
               break;
            }
                        
            else if (values[a] == 11 && values[b] == 11)
            {
               playerPoints -= 11;
               values[a] = 1;
               playerPoints += values[a];
            }
                        
             // System.out.println(values[a] + "   " + values[b]);                  //diagnostic check
                        
            Object [] PlayerOpts1 = {"Hit", "Stay"};     //Player options
            playerOption1 = JOptionPane.showOptionDialog(null, "Click an option", 
               "Blackjack Options", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
               null, PlayerOpts1, PlayerOpts1[0]);  
            if (playerOption1 == 0)
            {
               do{
                  e = r.nextInt(52); 
               }while(e == a || e == b || e == c);            //No repeats of cards can appear
               height100 = 410;
               height25 = 390;
               height5 = 390;
               height1 = 400;
               repaint();
               playerPoints += values [e];
               if(playerPoints > 21  && values[e] == 11)              //Change value of Ace to 1
               {
                  playerPoints -= 11;
                  values[e] = 1;
                  playerPoints += values[e]; 
               }
               else if(playerPoints > 21 && values[a] == 11) 
               {
                  playerPoints -= 11;
                  values[a] = 1;
                  playerPoints += values[a]; 
               }
               else if (playerPoints > 21 && values[b] == 11)
               {
                  playerPoints -= 11;
                  values[b] = 1;
                  playerPoints += values[b]; 
               }
               
            }
            else
            {
               break;
            }
         
            if(playerPoints < 22 && playerOption1 == 0)         //If player didnt bust continue
            {
               Object [] PlayerOpts2 = {"Hit", "Stay"};
               playerOption2 = JOptionPane.showOptionDialog(null, "Click an option", 
                  "Blackjack Options", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
                  null, PlayerOpts2, PlayerOpts2[0]);
            }
            else
            {
               break;
            }
         
            if (playerOption2 == 0)
            {
               do{
                  f = r.nextInt(52);
               }while(f == a || f == b || f == e || f == c); //No repeats of cards can appear
               height100 = 410;
               height25 = 390;
               height5 = 390;
               height1 = 400; 
               repaint();
               playerPoints += values [f];
               if(playerPoints > 21  && values[f] == 11)              //Change value of Ace to 1
               {
                  playerPoints -= 11;
                  values[f] = 1;
                  playerPoints += values[f]; 
               }
               else if(playerPoints > 21 && values[e] == 11)              
               {
                  playerPoints -= 11;
                  values[e] = 1;
                  playerPoints += values[e];  
               }
               else if(playerPoints > 21 && values[a] == 11) 
               {
                  playerPoints -= 11;
                  values[a] = 1;
                  playerPoints += values[a]; 
               }
               else if (playerPoints > 21 && values[b] == 11)
               {
                  playerPoints -= 11;
                  values[b] = 1;
                  playerPoints += values[b]; 
               }
            
            }
            else
            {
               break;
            }
         
            if(playerPoints < 22 && playerOption2 == 0)       //If player didnt bust continue
            {
               Object [] PlayerOpts3 = {"Hit", "Stay"};
               playerOption3 = JOptionPane.showOptionDialog(null, "Click an option", 
                  "Blackjack Options", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
                  null, PlayerOpts3, PlayerOpts3[0]);
            }
            else
            {
               break;
            }
            if (playerOption3 == 0)
            {
               do{
                  h = r.nextInt(52);
               }while(h == a || h == b || h == f || h == e || h == c);//No repeats of cards can appear
               height100 = 410;
               height25 = 390;
               height5 = 390;
               height1 = 400;
               repaint();
               playerPoints += values [h];
               more = false;
               if(playerPoints > 21  && values[h] == 11)  //Change value of Ace to 1
               {
                  playerPoints -= 11;
                  values[h] = 1;
                  playerPoints += values[h]; 
               }
               else if(playerPoints > 21  && values[f] == 11)                             
               {
                  playerPoints -= 11;
                  values[f] = 1;
                  playerPoints += values[f]; 
               }
               else if(playerPoints > 21  && values[e] == 11)              
               {
                  playerPoints -= 11;
                  values[e] = 1;
                  playerPoints += values[e]; 
               }
               else if(playerPoints > 21 && values[a] == 11)           
               {
                  playerPoints -= 11;
                  values[a] = 1;
                  playerPoints += values[a]; 
               }
               else if (playerPoints > 21 && values[b] == 11)         
               {
                  playerPoints -= 10;
                  values[b] = 1;
                  playerPoints += values[b]; 
               }
               if(playerPoints < 22)                           //5 card charlie for Player
               {
                  dealerPoints = 22;
                  sCharlie = sCharlie1;
                  height100 = 410;
                  height25 = 390;
                  height5 = 390;
                  height1 = 400;
                  repaint();
               } 
            }
            else
            {
               break;
            }
         
         } while(more);  
         
         if(values[a] + values[b] == 21)      //blackjack
         {
            dealerPoints = 22;
         }
         
         //Player bust (lose) message
         if (playerPoints > 21)
         {
            s4 = s2;
            balance -= bet;
            balanceString = Integer.toString(balance);
            
            bet100 = 0;
            bet25 = 0;
            bet5 = 0;
            betOne = 0; 
         
            height100 = 410;
            height25 = 390;
            height5 = 390;
            height1 = 400;
            repaint();
         }
         
          ////////////////////////////////Dealer Auto deal//////////////////////////////////////////////
           
         if(dealerPoints < 17 && playerPoints < 22)
         {
            do{
               d = r.nextInt(52);
            }while(d == a || d == b || d == f || d == e || d == c || d == h); //No repeats of cards can appear
            
            dealerPoints += values [d];
            
            try{Thread.sleep(300);}
            catch(InterruptedException e) {}
            height100 = 410;
            height25 = 390;
            height5 = 390;
            height1 = 400;
            repaint();
            if(values[c] == 11 && values [d] == 11)
            {
               dealerPoints -= 11;
               values[c] = 1;
               dealerPoints += values[c];
            }
         }
         
         
         if(dealerPoints < 17 && playerPoints < 22)         
         {
            do{
               try{Thread.sleep(300);}
               catch(InterruptedException e) {}
               j = r.nextInt(52);
               
               
            }while(j == a || j == b || j == f || j == e || j == c || j == h || j == d); //No repeats of cards can appear
         
            dealerPoints += values [j];
            height100 = 410;
            height25 = 390;
            height5 = 390;
            height1 = 400;
            repaint();
            if(dealerPoints > 21  && values[j] == 11)              //Change value of Ace to 1
            {
               dealerPoints -= 11;
               values[j] = 1;
               dealerPoints += values[j];
            }
            else if(dealerPoints > 21  && values[d] == 11)              
            {
               dealerPoints -= 11;
               values[d] = 1;
               dealerPoints += values[d];
            }
            else if(dealerPoints > 21 && values[c] == 11)
            {
               dealerPoints -= 11;
               values[c] = 1;
               dealerPoints += values[c];
            }
         }
         
      
         if(dealerPoints < 17 && playerPoints < 22 )
         {
            do{
               try{Thread.sleep(300);}
               catch(InterruptedException e) {}
               k = r.nextInt(52);
            }while(k == a || k == b || k == f || k == e || k == c || k == h || k == d || k == j); //No repeats of cards can appear
            dealerPoints += values [k];
            height100 = 410;
            height25 = 390;
            height5 = 390;
            height1 = 400;
            repaint();
            if(dealerPoints > 21  && values[k] == 11)              //Change value of Ace to 1
            {
               dealerPoints -= 11;
               values[k] = 1;
               dealerPoints += values[k];
            }
            else if(dealerPoints > 21  && values[j] == 11)              
            {
               dealerPoints -= 11;
               values[j] = 1;
               dealerPoints += values[j];
            }
            else if(dealerPoints > 21  && values[d] == 11)              
            {
               dealerPoints -= 11;
               values[d] = 1;
               dealerPoints += values[d];
            }
            else if(dealerPoints > 21 && values[c] == 11)
            {
               dealerPoints -= 11;
               values[c] = 1;
               dealerPoints += values[c];
            }
         }
      
         if(dealerPoints < 17 && playerPoints < 22)
         {
            do{
               try{Thread.sleep(300);}
               catch(InterruptedException e) {}
               m = r.nextInt(52);
            }while(m == a || m == b || m == f || m == e || m == c || m == h || m == d || m == j || m == k); //No repeats of cards can appear
            
            dealerPoints += values [m];
            height100 = 410;
            height25 = 390;
            height5 = 390;
            height1 = 400;
            repaint();
            if(dealerPoints > 21  && values[m] == 11)              //Change value of Ace to 1
            {
               dealerPoints -= 11;
               values[m] = 1;
               dealerPoints += values[m];
            }
            else if(dealerPoints > 21  && values[k] == 11)              
            {
               dealerPoints -= 11;
               values[k] = 1;
               dealerPoints += values[k];
            }
            else if(dealerPoints > 21  && values[j] == 11)              
            {
               dealerPoints -= 11;
               values[j] = 1;
               dealerPoints += values[j];
            }
            else if(dealerPoints > 21  && values[d] == 11)              
            {
               dealerPoints -= 11;
               values[d] = 1;
               dealerPoints += values[d];
            }
            else if(dealerPoints > 21 && values[c] == 11)
            {
               dealerPoints -= 11;
               values[c] = 1;
               dealerPoints += values[c];
            }
            if(dealerPoints < 22)                //5 card charlie for Dealer
            {
               dealerPoints = 21;
               playerPoints = 20;
               sCharlie = sCharlie1;
               height100 = 410;
               height25 = 390;
               height5 = 390;
               height1 = 400;
               repaint();
            } 
         }
         
                 ////////////////////////////////Messages//////////////////////////////////////////////
      
         //Dealer bust (player win) message
         if(dealerPoints > 21)
         {
            s3 = s1;
            balance += bet;
            balanceString = Integer.toString(balance);
            bet100 *= 2;
            bet25 *= 2;
            bet5 *= 2;
            betOne *= 2; 
         
            height100 = 410;
            height25 = 390;
            height5 = 390;
            height1 = 400;
            repaint();
         }
         //final result message
         if(dealerPoints < 22 && playerPoints < 22)
         {
            if(dealerPoints < playerPoints)         //player win
            {
               s3 = s1;
               balance += bet;
               
               bet100 *= 2;
               bet25 *= 2;
               bet5 *= 2;
               betOne *= 2; 
            
               height100 = 410;
               height25 = 390;
               height5 = 390;
               height1 = 400;
               repaint();
            }
         }
         
         if(dealerPoints < 22 && playerPoints < 22)
         {
            if(dealerPoints > playerPoints)           //player lose
            {
               s4 = s2;
               balance -= bet;               
               bet100 = 0;
               bet25 = 0;
               bet5 = 0;
               betOne = 0; 
            
               height100 = 410;
               height25 = 390;
               height5 = 390;
               height1 = 400;
               repaint();
            }
         }
         
         if(dealerPoints < 22 && playerPoints < 22)
         {
            if (dealerPoints == playerPoints)         //tie
            {
               s6 = s7;
               height100 = 410;
               height25 = 390;
               height5 = 390;
               height1 = 400;
               repaint();
            }
         }
            
         {
            if(balance == 0)
            {
               sBankrupt1 = sBankrupt;
               height100 = 410;
               height25 = 390;
               height5 = 390;
               height1 = 400;
               repaint();
               JOptionPane.showMessageDialog(null, "Out of money! Know when to quit!", "Error", JOptionPane.ERROR_MESSAGE);
               break;
            ///////Option to continue//////
               /*
               int buyIn = JOptionPane.showConfirmDialog(null,
               "Out of money! Would you like to buy in $100?", "Buy in?", JOptionPane.YES_NO_OPTION);
               if(buyIn == 0)                                                 //Buy in again
               {
                  balance = 100;
                  balanceString = Integer.toString(balance);
                  sBankrupt1 = s5;
                  s4 = s5;
                  repaint();
               }
               else
               {
               break;
               }
               */
            }
         
            int again = JOptionPane.showConfirmDialog(null,
               "Would you like to play again?", "Continue?", JOptionPane.YES_NO_OPTION);
            if(again == 1)
            {
               break;
            }
         }
      }while(more2); 
   }
   
   public void paintComponent( Graphics g )    // Method: paintComponent
   {
      //background
      Graphics g2 = (Graphics2D) g;
      ImageIcon bg = new ImageIcon("BlackjackTable.png");
      bg.setImage(bg.getImage().getScaledInstance(1000, 1000, 0));
      bg.paintIcon(this, g2, 0, -100);
      
      //End messages
      Graphics2D g13 = (Graphics2D) g;               //win message
      Font f1 = new Font ("serif", Font.BOLD, 70);
      g13.setColor(Color.WHITE);
      g13.setFont(f1);  
      g13.setStroke(new BasicStroke (10.0F, BasicStroke.CAP_BUTT, 
                                           BasicStroke.JOIN_BEVEL));                                                                        
      g13.drawString(s3, 50,100);
      
      
      Graphics2D g14 = (Graphics2D) g;               //lose message
      g14.setColor(Color.WHITE);
      g14.setFont(f1);  
      g14.setStroke(new BasicStroke (10.0F, BasicStroke.CAP_BUTT, 
                                           BasicStroke.JOIN_BEVEL));                                                                        
      g14.drawString(s4, 50,100);
      
      Graphics2D g15 = (Graphics2D) g;               //tie message
      g15.setColor(Color.WHITE);
      g15.setFont(f1);  
      g15.setStroke(new BasicStroke (10.0F, BasicStroke.CAP_BUTT, 
                                           BasicStroke.JOIN_BEVEL));                                                                        
      g14.drawString(s6, 610,100);
      
      Graphics2D g16 = (Graphics2D) g;               //Blackjack message
      g16.setColor(Color.YELLOW);
      g16.setFont(f1);  
      g16.setStroke(new BasicStroke (10.0F, BasicStroke.CAP_BUTT, 
                                           BasicStroke.JOIN_BEVEL));                                                                        
      g16.drawString(s8, 440,100);
      
      Font f2 = new Font ("serif", Font.BOLD, 18);
      Graphics2D g17 = (Graphics2D) g;               //Ace message
      g17.setColor(Color.WHITE);
      g17.setFont(f2);  
      g17.setStroke(new BasicStroke (10.0F, BasicStroke.CAP_BUTT, 
                                           BasicStroke.JOIN_BEVEL));                                                                        
      g17.drawString(s10, 30, 600);
      
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
      
      Graphics2D g20 = (Graphics2D) g;               //5 card charlie message
      g20.setColor(Color.WHITE);
      g20.setFont(f1);  
      g20.setStroke(new BasicStroke (10.0F, BasicStroke.CAP_BUTT, 
                                           BasicStroke.JOIN_BEVEL));                                                                        
      g20.drawString(sCharlie, 50,320);
      
      Graphics2D g21 = (Graphics2D) g;               //Bankrupt message
      g21.setColor(Color.GREEN);
      g21.setFont(f1);  
      g21.setStroke(new BasicStroke (10.0F, BasicStroke.CAP_BUTT, 
                                           BasicStroke.JOIN_BEVEL));                                                                        
      g21.drawString(sBankrupt1, 50, 200);
      
      
      //Automatic deal
      Graphics g3 = (Graphics2D) g;
      ImageIcon playerCard1 = deck [a];
      playerCard1.setImage(playerCard1.getImage().getScaledInstance(70, 90, 0));
      playerCard1.paintIcon(this, g3, 460, 420);  
      
      Graphics g4 = (Graphics2D) g;
      ImageIcon playerCard2 = deck [b];
      playerCard2.setImage(playerCard2.getImage().getScaledInstance(70, 90, 0));
      playerCard2.paintIcon(this, g4, 480, 420);  
     
      Graphics g5 = (Graphics2D) g;
      ImageIcon dealerCard1 = deck [c];
      dealerCard1.setImage(dealerCard1.getImage().getScaledInstance(70, 90, 0));
      dealerCard1.paintIcon(this, g5, 460, 150);  
       
      //Player Option deal
      Graphics g7 = (Graphics2D) g;
      ImageIcon playerCard3 = deck [e];
      playerCard3.setImage(playerCard3.getImage().getScaledInstance(70, 90, 0));
      playerCard3.paintIcon(this, g7, 500, 420);  
       
      Graphics g8 = (Graphics2D) g;
      ImageIcon playerCard4 = deck [f];
      playerCard4.setImage(playerCard4.getImage().getScaledInstance(70, 90, 0));
      playerCard4.paintIcon(this, g8, 520, 420);  
       
      Graphics g9 = (Graphics2D) g;
      ImageIcon playerCard5 = deck [h];
      playerCard5.setImage(playerCard5.getImage().getScaledInstance(70, 90, 0));
      playerCard5.paintIcon(this, g9, 540, 420); 
       
      //Dealer Auto deal
      Graphics g6 = (Graphics2D) g;
      ImageIcon dealerCard2 = deck [d];
      dealerCard2.setImage(dealerCard2.getImage().getScaledInstance(70, 90, 0));
      dealerCard2.paintIcon(this, g6, 480, 150);
      
      Graphics g10 = (Graphics2D) g;
      ImageIcon dealerCard3 = deck [j];
      dealerCard3.setImage(dealerCard3.getImage().getScaledInstance(70, 90, 0));
      dealerCard3.paintIcon(this, g10, 500, 150);
      
      Graphics g11 = (Graphics2D) g;
      ImageIcon dealerCard4 = deck [k];
      dealerCard4.setImage(dealerCard4.getImage().getScaledInstance(70, 90, 0));
      dealerCard4.paintIcon(this, g11, 520, 150);
      
      Graphics g12 = (Graphics2D) g;
      ImageIcon dealerCard5 = deck [m];
      dealerCard5.setImage(dealerCard5.getImage().getScaledInstance(70, 90, 0));
      dealerCard5.paintIcon(this, g12, 540, 150);
      
      //Chips
      for(int i = 0; i < betOne; i++){
         height1 -= 6;
         Graphics g22 = (Graphics2D) g;
         ImageIcon chip1 = chips[c1];
         chip1.setImage(chip1.getImage().getScaledInstance(120, 120, 0));
         chip1.paintIcon(this, g22, 300, height1);
      }
      
      for(int i = 0; i < bet25; i++){
         height25 -= 6;
         Graphics g24 = (Graphics2D) g;
         ImageIcon chip25 = chips[c25];
         chip25.setImage(chip25.getImage().getScaledInstance(120, 120, 0));
         chip25.paintIcon(this, g24, 290, height25);
      }
      
      for(int i = 0; i < bet5; i++){
         height5 -= 6;
         Graphics g23 = (Graphics2D) g;
         ImageIcon chip5 = chips[c5];
         chip5.setImage(chip5.getImage().getScaledInstance(120, 120, 0));
         chip5.paintIcon(this, g23, 300, height5);
      }
      
      for(int i = 0; i < bet100; i++){
         height100 -= 6;
         Graphics g25 = (Graphics2D) g;
         ImageIcon chip100 = chips[c100];
         chip100.setImage(chip100.getImage().getScaledInstance(120, 120, 0));
         chip100.paintIcon(this, g25, 310, height100);
      }
       
   }
   
}