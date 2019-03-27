import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Container;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Image;
import javax.swing.JComponent;
import javax.swing.SwingConstants;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;



public class CasinoFrameNEW           // Class
{


   
   public static void main(String[] args)throws InterruptedException
   {
      int frameWidth = 1000;
      int frameHeight = 700;
      int wallet = 1000; //Starting Cash
      int mainOption;
      boolean more = true;
      ImageIcon[] cards = new ImageIcon[53];
      ImageIcon[] coins = new ImageIcon[5];
      ImageIcon[] slots = new ImageIcon[19];
   
      
      CasinoStartingScreen Stbp = 
         new CasinoStartingScreen(frameWidth, frameHeight, cards, coins, wallet, slots);
      
      
      CasinoComponentBlackJack cbj = 
         new CasinoComponentBlackJack(frameWidth, frameHeight, cards, coins, wallet, slots);
         
      CasinoComponentBaccarat bbj = 
         new CasinoComponentBaccarat(frameWidth, frameHeight, cards, coins, wallet, slots);
      
      CasinoComponentSlotsV2 ccs = 
         new CasinoComponentSlotsV2(frameWidth, frameHeight, cards, coins, wallet, slots);
      
      //Deck Array
      ImageIcon aceSpades = new ImageIcon("ace_of_spades.png"); 
      cards [0] = aceSpades;
      ImageIcon twoSpades = new ImageIcon("2_of_spades.png");
      cards [1] = twoSpades;
      ImageIcon threeSpades = new ImageIcon("3_of_spades.png");
      cards [2] = threeSpades;
      ImageIcon fourSpades = new ImageIcon("4_of_spades.png");
      cards [3] = fourSpades;
      ImageIcon fiveSpades = new ImageIcon("5_of_spades.png");
      cards [4] = fiveSpades;
      ImageIcon sixSpades = new ImageIcon("6_of_spades.png");
      cards [5] = sixSpades;
      ImageIcon sevenSpades = new ImageIcon("7_of_spades.png");
      cards [6] = sevenSpades;
      ImageIcon eightSpades = new ImageIcon("8_of_spades.png");
      cards [7] = eightSpades;   
      ImageIcon nineSpades = new ImageIcon("9_of_spades.png");
      cards [8] = nineSpades;
      ImageIcon tenSpades = new ImageIcon("10_of_spades.png");
      cards [9] = tenSpades;
      ImageIcon jackSpades = new ImageIcon("jack_of_spades.png");
      cards [10] = jackSpades;
      ImageIcon queenSpades = new ImageIcon("queen_of_spades.png");
      cards [11] = queenSpades;
      ImageIcon kingSpades = new ImageIcon("king_of_spades.png");
      cards [12] = kingSpades;
      ImageIcon aceHearts = new ImageIcon("ace_of_hearts.png");
      cards [13] = aceHearts;
      ImageIcon twoHearts = new ImageIcon("2_of_hearts.png");
      cards [14] = twoHearts;
      ImageIcon threeHearts = new ImageIcon("3_of_hearts.png");
      cards [15] = threeHearts;
      ImageIcon fourHearts = new ImageIcon("4_of_hearts.png");
      cards [16] = fourHearts;
      ImageIcon fiveHearts = new ImageIcon("5_of_hearts.png");
      cards [17] = fiveHearts;
      ImageIcon sixHearts = new ImageIcon("6_of_hearts.png");
      cards [18] = sixHearts;
      ImageIcon sevenHearts = new ImageIcon("7_of_hearts.png");
      cards [19] = sevenHearts;
      ImageIcon eightHearts = new ImageIcon("8_of_hearts.png");
      cards [20] = eightHearts;
      ImageIcon nineHearts = new ImageIcon("9_of_hearts.png");
      cards [21] = nineHearts;
      ImageIcon tenHearts = new ImageIcon("10_of_hearts.png");
      cards [22] = tenHearts;
      ImageIcon jackHearts = new ImageIcon("jack_of_hearts.png");
      cards [23] = jackHearts;   
      ImageIcon queenHearts = new ImageIcon("queen_of_hearts.png");
      cards [24] = queenHearts;
      ImageIcon kingHearts = new ImageIcon("king_of_hearts.png");
      cards [25] = kingHearts;
      ImageIcon aceClubs = new ImageIcon("ace_of_clubs.png");
      cards [26] = aceClubs;
      ImageIcon twoClubs = new ImageIcon("2_of_clubs.png");
      cards [27] = twoClubs;
      ImageIcon threeClubs = new ImageIcon("3_of_clubs.png");
      cards [28] = threeClubs;
      ImageIcon fourClubs = new ImageIcon("4_of_clubs.png");
      cards [29] = fourClubs;
      ImageIcon fiveClubs = new ImageIcon("5_of_clubs.png");
      cards [30] = fiveClubs;
      ImageIcon sixClubs = new ImageIcon("6_of_clubs.png");
      cards [31] = sixClubs;   
      ImageIcon sevenClubs = new ImageIcon("7_of_clubs.png");
      cards [32] = sevenClubs;
      ImageIcon eightClubs = new ImageIcon("8_of_clubs.png");
      cards [33] = eightClubs;
      ImageIcon nineClubs = new ImageIcon("9_of_clubs.png");
      cards [34] = nineClubs;
      ImageIcon tenClubs = new ImageIcon("10_of_clubs.png");
      cards [35] = tenClubs;
      ImageIcon jackClubs = new ImageIcon("jack_of_clubs.png");
      cards [36] = jackClubs;
      ImageIcon queenClubs = new ImageIcon("queen_of_clubs.png");
      cards [37] = queenClubs;
      ImageIcon kingClubs = new ImageIcon("king_of_clubs.png");
      cards [38] = kingClubs;
      ImageIcon aceDiamonds = new ImageIcon("ace_of_diamonds.png");
      cards [39] = aceDiamonds;   
      ImageIcon twoDiamonds = new ImageIcon("2_of_diamonds.png");
      cards [40] = twoDiamonds;
      ImageIcon threeDiamonds = new ImageIcon("3_of_diamonds.png");
      cards [41] = threeDiamonds;
      ImageIcon fourDiamonds = new ImageIcon("4_of_diamonds.png");
      cards [42] = fourDiamonds;
      ImageIcon fiveDiamonds = new ImageIcon("5_of_diamonds.png");
      cards [43] = fiveDiamonds;
      ImageIcon sixDiamonds = new ImageIcon("6_of_diamonds.png");
      cards [44] = sixDiamonds;
      ImageIcon sevenDiamonds = new ImageIcon("7_of_diamonds.png");
      cards [45] = sevenDiamonds;
      ImageIcon eightDiamonds = new ImageIcon("8_of_diamonds.png");
      cards [46] = eightDiamonds;
      ImageIcon nineDiamonds = new ImageIcon("9_of_diamonds.png");
      cards [47] = nineDiamonds;
      ImageIcon tenDiamonds = new ImageIcon("10_of_diamonds.png");
      cards [48] = tenDiamonds;
      ImageIcon jackDiamonds = new ImageIcon("jack_of_diamonds.png");
      cards [49] = jackDiamonds;
      ImageIcon queenDiamonds = new ImageIcon("queen_of_diamonds.png");
      cards [50] = queenDiamonds;
      ImageIcon kingDiamonds = new ImageIcon("king_of_diamonds.png");
      cards [51] = kingDiamonds; 
      ImageIcon nothing = new ImageIcon("nothing.jpg");
      cards [52] = nothing;
      
      //Chips Array
      ImageIcon chip1 = new ImageIcon ("Chips - 1.png");
      coins[0] = chip1;
      ImageIcon chip5 = new ImageIcon ("Chips - 5.png");
      coins[1] = chip5;
      ImageIcon chip25 = new ImageIcon ("Chips - 25.png");
      coins[2] = chip25;
      ImageIcon chip100 = new ImageIcon ("Chips - 100.png");
      coins[3] = chip100;
      ImageIcon nothing2 = new ImageIcon ("nothing.png");
      coins[4] = nothing2;
      
      //Slots Array
      ImageIcon numberOne = new ImageIcon("numberone.png"); 
      slots [0] = numberOne;
      ImageIcon numberTwo = new ImageIcon("numbertwo.png");
      slots [1] = numberTwo;
      ImageIcon numberThree = new ImageIcon("numberthree.png");
      slots [2] = numberThree;
      ImageIcon numberFour = new ImageIcon("numberfour.png");
      slots [3] = numberFour;
      ImageIcon numberFive = new ImageIcon("numberfive.png");
      slots [4] = numberFive;
      ImageIcon numberSix = new ImageIcon("numbersix.png");
      slots [5] = numberSix;
      ImageIcon numberSeven = new ImageIcon("numberseven.png");
      slots [6] = numberSeven;
      ImageIcon numberEight = new ImageIcon("numbereight.png");
      slots [7] = numberEight;   
      ImageIcon numberNine = new ImageIcon("numbernine.png");
      slots [8] = numberNine;
      ImageIcon banana = new ImageIcon("banana.png");
      slots [9] = banana;
      ImageIcon strawberry = new ImageIcon("strawberry.gif");
      slots [10] = strawberry;
      ImageIcon lemon = new ImageIcon("lemon.png");
      slots [11] = lemon;
      ImageIcon watermelon = new ImageIcon("watermelon.png");
      slots [12] = watermelon;
      ImageIcon lime = new ImageIcon("lime.png");
      slots [13] = lime;
      ImageIcon cherries = new ImageIcon("cherry.jpg");
      slots [14] = cherries;
      ImageIcon bells = new ImageIcon("bells.png");
      slots [15] = bells;
      ImageIcon blueberry = new ImageIcon("blueberry.jpeg");
      slots [16] = blueberry;
      ImageIcon orange = new ImageIcon("orange.png");
      slots [17] = orange;
      ImageIcon grapes = new ImageIcon("grapes.png");
      slots [18] = grapes;
   
      
      
      while(more){
      
         JFrame frame = new JFrame();
         frame.setSize(1000, 770);
         frame.setTitle("Casino");
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
         frame.add(Stbp);
         frame.setVisible(true);
         Stbp.update();
         
               
         
         Object [] MainOpts = {"BlackJack", "Baccarat", "Slots", "Quit"};     //Main Menu
         mainOption = JOptionPane.showOptionDialog(null, "Welcome to our virtual Casino! What game would you like to play?", 
               "Pick a Game", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
               null, MainOpts, MainOpts[0]);
               
         frame.dispose();
                                
      
         JFrame frame2 = new JFrame();
         frame2.setSize(frameWidth, frameHeight);
         frame2.setTitle("Casino");
         frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
         if(mainOption == 0) {   
            frame2.add(cbj);
            frame2.setVisible(true);
            cbj.update();
            frame2.dispose();
         }
         
         else if(mainOption == 1){
            frame2.add(bbj);
            frame2.setVisible(true);
            bbj.update();
            frame2.dispose();     
         }
         else if(mainOption == 2){ //
            frame2.add(ccs);
            frame2.setVisible(true);
            ccs.update();
            frame2.dispose();     
         }
         else if(mainOption == 3)
         {
            more = false;
         }
      
      }
   }
}
