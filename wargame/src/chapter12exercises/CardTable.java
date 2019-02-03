package chapter12exercises;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class CardTable extends Canvas {

    protected Image[][] images;
    protected int cardWidth, cardHeight;
    
    public CardTable(String cardset) {
        setBackground(new Color(0x088A4B));
        images = new Image[14][4];
        String suits = "cdhs";

        for (int suit = 0; suit <= 3; suit++) {
            char c = suits.charAt(suit);

            for (int rank = 1; rank <= 13; rank++) {
                String s = String.format("%s/%02d%c.gif",
                                         cardset, rank, c);
                images[rank][suit] = new ImageIcon(s).getImage();
            }
        }
        
        cardWidth = images[1][1].getWidth(null);
        cardHeight = images[1][1].getHeight(null);
        setTableSize(14, 4);
    }

    public void setTableSize(double x, double y) {
        setSize((int) (x * cardWidth),
                (int) (y * cardHeight));
    }

    public void drawCard(Graphics g, int rank, int suit, double x, double y) {
        Image image = images[rank][suit];
        g.drawImage(image,
                    (int) (x * cardWidth),
                    (int) (y * cardHeight),
                    null);
    }

    public void paint(Graphics g) {
        for (int rank = 1; rank <= 13; rank++) {
            for (int suit = 0; suit <= 3; suit++) {
                double x = rank - 1 + suit / 5.0;
                double y = suit / 2.0;
                drawCard(g, rank, suit, x, y);
            }
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Card Table");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        String cardset = "cardset-oxymoron";
        Canvas canvas = new CardTable(cardset);
        frame.getContentPane().add(canvas);
        frame.pack();
        frame.setVisible(true);
    }
}