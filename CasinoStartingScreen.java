import javax.swing.JComponent;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.BasicStroke;
import java.awt.Font;
import javax.swing.ImageIcon;


public class CasinoStartingScreen extends JComponent     // Class
{		
   int frameW, frameH;

   ImageIcon[] deck;
      ImageIcon[] combos;

   ImageIcon[] chips;
   int balance;
   
   public CasinoStartingScreen(int fW, int fH, ImageIcon[] cards, ImageIcon[] coins, int wallet, ImageIcon[] slots)
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
   //while(true){
   // }
   
   }
   public void paintComponent( Graphics g )
       // Method: paintComponent
   {
        //background
      Graphics g2 = (Graphics2D) g;
      ImageIcon Stbp = new ImageIcon("Titlepg.jpg");
      Stbp.setImage(Stbp.getImage().getScaledInstance(1000, 1000, 0));
      Stbp.paintIcon(this, g2, 0, -100);
   }
}