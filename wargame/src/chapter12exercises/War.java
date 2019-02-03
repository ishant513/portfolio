package chapter12exercises;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.util.Arrays;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class War extends CardTable{
	
	Image cardBack;
	Card[] deck;

	public static void main(String[] args) {
		JFrame frame = new JFrame("Card Table");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        String cardset = "cardset-oxymoron";
        Canvas canvas = new War(cardset);
        frame.getContentPane().add(canvas);
        frame.pack();
        frame.setVisible(true);
	}
	
	public War(String cardset) {
		super(cardset);
		deck = Card.makeDeck();
		shuffle(deck);
		cardBack = new ImageIcon(cardset + "/back001.gif").getImage();
	}
	
	public static void shuffle(Card[] deck){
		//bogo sort
		for(int i = deck.length - 1; i > 0; i--) {
			Card temp = deck[i];
			int swapIndex = (int)(Math.random()*i);
			deck[i] = deck[swapIndex];
			deck[swapIndex] = temp;
		}
	}
	
	@Override
	public void paint(Graphics g) {
		if(deck[0] == null) {
			System.out.println(Arrays.toString(deck));
		}
		if(deck != null && deck.length > 0 && deck[0] != null) {
			drawCard(g, deck[0].getRank(), deck[0].getSuit(), 0, 0);
			drawBackCard(g, 1, 0);
		}
	}
	
	public void drawBackCard(Graphics g, double x, double y){
		g.drawImage(cardBack, (int) (x * cardWidth),
                    (int) (y * cardHeight),
                    null);
	}
}
//use compareTo to determine which is larger and put those cards in discard pile (new arraylist)