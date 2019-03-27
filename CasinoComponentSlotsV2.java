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
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.BorderLayout;

public class CasinoComponentSlotsV2 extends JComponent     // Class
{    
   int frameW, frameH;
   int chosenOption;
   int playerOption1;
   int playerOption2;
   int playerOption3;
   int playerOption4;
   int z = 0, a = 19, b = 2, c = 3, d = 4, e = 5, f = 6, g = 7, h = 8, i = 9;
   int watermelon=10 ;
   int grapes = 10;
   int banana = 10;
   int cherry = 11;
   int lime = 13;
   int lemon = 14;
   int strawberry = 15;
   int orange = 16;
   int bells = 17;
   int wildcard = 18;
   ImageIcon[] combos;
   Random r = new Random();
   String payout = "Payout:";
   String win = "JACKPOT!!!";
   String bet = "Select Number of Credits to Play:";
   String partialwin = "Two Image Combo!";
   String lose = "YOU LOSE!";
   String s3 = "  ";
   String s4 = "  ";
   String s5 = "  ";
   String s6 = "  ";
   String balanceWord = "Balance: $";
   String s8 = "  ";
   int balance = 1000;
   String sBankrupt1 = "  ";
   String sBankrupt = "Bankrupt!";
   //int [] values = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9,
//
   int values = 20;
   int gamblerCredits;
   //int amount = Integer.parseInt(balanceString);
   int combo = 0;
   boolean playing = false;
   boolean enough = false;
   boolean settingup = true;
   boolean notvisible = true;
   boolean visible = false;
   ImageIcon firstimage;
   ImageIcon secondimage;
   ImageIcon thirdimage;
   int firstrandom = r.nextInt(19); // how to get a random image from the arrayList without a specific one
   int secondrandom = r.nextInt(19);
   int thirdrandom = r.nextInt(19);
   private static JPanel labelPanel = new JPanel();
   private static JFrame buttonFrame = new JFrame("Button Frame");
   ImageIcon[] deck;
   ImageIcon[] chips;
  
  
   public CasinoComponentSlotsV2 (int fW, int fH, ImageIcon[] cards, ImageIcon[] coins, int wallet, ImageIcon[] slots)
   {
      deck = cards;
      balance = wallet;
      chips = coins;
      frameW = fW;
      frameH = fH;
      combos = slots;
   }
     
   public void update() throws InterruptedException
   {
        
        
      Scanner in = new Scanner(System.in);
      gamblerCredits = 100;
        
        
      while (settingup)
      {
           s3 = s6;
           s4 = s6;
           s5 = s6;
           repaint();
           
         String wager1 = JOptionPane.showInputDialog("Bet your number of Credits you choose:");
         int wager = Integer.parseInt(wager1);
        // System.out.println(wager);
              
         notvisible = false;
               
             
                
         if(wager > balance)
         {
                    
            JOptionPane.showMessageDialog(null, "Insufficient Credits!", "Error", JOptionPane.ERROR_MESSAGE);
            continue;
         }
              
              
         else if(wager < 2)
         {
                    
            JOptionPane.showMessageDialog(null, "Minimum bet is 2 Credits!", "Error", JOptionPane.ERROR_MESSAGE);
            continue;
         }
                
           
         for(int i = 1; i < 15; i++){
            try{Thread.sleep(30*i);}
            catch(InterruptedException e) {}
            firstrandom = r.nextInt(19) ; // how to get a random image from the arrayList without a specific one
            secondrandom = r.nextInt(19);
            thirdrandom = r.nextInt(19);
            repaint();
         }
                     
         if ((firstrandom  == secondrandom) && (firstrandom == thirdrandom))
         {  balance += wager*100;
            s3 = win;
            repaint();
         } 
                                       //case 2 :
        else if ((firstrandom  != secondrandom) && (firstrandom != thirdrandom) && (secondrandom != thirdrandom))
         {
            balance -= wager;
            s4 = lose;
            
         }
                                        
         else if ((firstrandom  == secondrandom) || (firstrandom == thirdrandom) ||(thirdrandom  == secondrandom)) 
         { 
            balance += wager;
            s5 = partialwin;
            repaint();
         }
                                       
         firstimage = combos[firstrandom];
         secondimage = combos[secondrandom];
         thirdimage = combos[thirdrandom];  
                                   
        // System.out.println(balance);
                       
            try{Thread.sleep(1500);}
            catch(InterruptedException e) {}    
         if (balance == 0)
         {
                               
            sBankrupt1 = sBankrupt;
            repaint();
            JOptionPane.showMessageDialog(null, "Out of credits! Know when to quit!", "Error", JOptionPane.ERROR_MESSAGE);
            break;
         }    
         
          try{Thread.sleep(1500);}
            catch(InterruptedException e) {}
                 
                   int again = JOptionPane.showConfirmDialog(null,
               "Would you like to play again?", "Continue?", JOptionPane.YES_NO_OPTION);
            if(again == 1)
            {
               break;
            }
              
      } //while loop end
   }
   
           
           
        
       
       
   public void paintComponent( Graphics g )    // Method: paintComponent
   {
         //background
      Graphics g2 = (Graphics2D) g;
      ImageIcon bg = new ImageIcon("slotsmachine - NEW.png");
      bg.setImage(bg.getImage().getScaledInstance(1000, 1000, 0));
      bg.paintIcon(this, g2, 0, -100);
     
     
      //End messages
      Graphics2D g13 = (Graphics2D) g;               //win message
      Font f1 = new Font ("Times New Roman", Font.BOLD, 60);
      g13.setColor(Color.GREEN);
      g13.setFont(f1); 
      g13.setStroke(new BasicStroke (10.0F, BasicStroke.CAP_BUTT,
                                           BasicStroke.JOIN_BEVEL));                                                                       
      g13.drawString(s3, 250,150);
     
           Font f2 = new Font ("Times New Roman", Font.BOLD, 50);

      Graphics2D g9 = (Graphics2D) g;               //partialwin message
      g9.setColor(Color.GREEN);
      g9.setFont(f2); 
      g9.setStroke(new BasicStroke (10.0F, BasicStroke.CAP_BUTT,
                                           BasicStroke.JOIN_BEVEL));                                                                       
      g13.drawString(s5, 255, 150);
   
     
      Graphics2D g14 = (Graphics2D) g;               //lose message
      g14.setColor(Color.WHITE);
      g14.setFont(f1); 
      g14.setStroke(new BasicStroke (10.0F, BasicStroke.CAP_BUTT,
                                           BasicStroke.JOIN_BEVEL));                                                                       
      g14.drawString(s4, 290, 150);
     
      Font f3 = new Font ("serif", Font.BOLD, 30);
      Graphics2D g18 = (Graphics2D) g;               //Balance number message
      g18.setColor(Color.BLACK);
      g18.setFont(f3); 
      g18.setStroke(new BasicStroke (10.0F, BasicStroke.CAP_BUTT,
                                           BasicStroke.JOIN_BEVEL));                                                                       
      g18.drawString(Integer.toString(balance) , 170, 600);
     
      Graphics2D g19 = (Graphics2D) g;               //Balance word message
      g19.setColor(Color.BLACK);
      g19.setFont(f3); 
      g19.setStroke(new BasicStroke (10.0F, BasicStroke.CAP_BUTT,
                                           BasicStroke.JOIN_BEVEL));                                                                       
      g19.drawString(balanceWord , 30, 600);
     
                                                                      
     
      Graphics2D g21 = (Graphics2D) g;               //Bankrupt message
      g21.setColor(Color.GREEN);
      g21.setFont(f1); 
      g21.setStroke(new BasicStroke (10.0F, BasicStroke.CAP_BUTT,
                                           BasicStroke.JOIN_BEVEL));                                                                       
      g21.drawString(s5, 220, 400);
     
            
      //Player Option deal
     
                /*if (notvisible)
            { 
            
               Graphics g7 = (Graphics2D) g;
               ImageIcon positionone = combos [19];
               positionone.setImage(positionone.getImage().getScaledInstance(70, 90, 0));
               positionone.paintIcon(this, g7, 200, 420); 
               
               Graphics g8 = (Graphics2D) g;
               ImageIcon positiontwo = combos [19];
               positiontwo.setImage(positiontwo.getImage().getScaledInstance(70, 90, 0));
               positiontwo.paintIcon(this, g8, 400, 420); 
               
               Graphics g9 = (Graphics2D) g;
               ImageIcon positionthree = combos [19];
               positionthree.setImage(positionthree.getImage().getScaledInstance(70, 90, 0));
               positionthree.paintIcon(this, g9, 600, 420);
              
   
            */
              
      Graphics g10 = (Graphics2D) g;
      ImageIcon visiblepositionone = combos [firstrandom];
      visiblepositionone.setImage(visiblepositionone.getImage().getScaledInstance(70, 90, 0));
      visiblepositionone.paintIcon(this, g10, 230, 370); 
                     
      Graphics g11 = (Graphics2D) g;
      ImageIcon visiblepositiontwo = combos [secondrandom];
      visiblepositiontwo.setImage(visiblepositiontwo.getImage().getScaledInstance(70, 90, 0));
      visiblepositiontwo.paintIcon(this, g11, 420, 370); 
                     
      Graphics g12 = (Graphics2D) g;
      ImageIcon visiblepositionthree = combos [thirdrandom];
      visiblepositionthree.setImage(visiblepositionthree.getImage().getScaledInstance(70, 90, 0));
      visiblepositionthree.paintIcon(this, g12, 610, 370);
        
     
     
   }
                  
}
     
   //}

   /*public static void main(String[] args)
   {
      final JButton button1 = new JButton("Mooooooooo....");
      //final JButton button1 = new JButton("Button 1");
      final JButton button2 = new JButton("Button 2");
      button2.setPreferredSize(new Dimension(80,50));

      final JButton button3 = new JButton("Button 3");
      JPanel buttonPanel = new JPanel();
      GridLayout g13 = new GridLayout(3,1,10,10);
      buttonPanel.setLayout(g13);
      buttonPanel.add(button1);
      buttonPanel.add(button2);
      buttonPanel.add(button3);

    }*/
