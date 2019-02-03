package chapter12exercises;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Card {

    public static final String[] RANKS = {
        null, "Ace", "2", "3", "4", "5", "6", "7",
        "8", "9", "10", "Jack", "Queen", "King"};

    public static final String[] SUITS = {
        "Clubs", "Diamonds", "Hearts", "Spades"};

    final int rank;

    private final int suit;

    public Card(int rank, int suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public int compareTo(Card that) {
        if (this.suit < that.suit) {
            return -1;
        }
        if (this.suit > that.suit) {
            return 1;
        }
        if(this.rank == 1){
        	return 1;
        }
        if (this.rank < that.rank) {
            return -1;
        }
        if (this.rank > that.rank) {
            return 1;
        }
        return 0;
    }

    public boolean equals(Card that) {
        return this.rank == that.rank
            && this.suit == that.suit;
    }

    public int getRank() {
        return this.rank;
    }

    public int getSuit() {
        return this.suit;
    }

    public int position() {
        return this.suit * 13 + this.rank - 1;
    }

    public String toString() {
        return RANKS[this.rank] + " of " + SUITS[this.suit];
    }
    
    public static Card[] makeDeck() {
    	Card[] cards = new Card[52];
    	int index = 0;
		for (int suit = 0; suit <= 3; suit++) {
			for (int rank = 1; rank <= 13; rank++) {
				cards[index] = new Card(rank, suit);
		        index++;
		    }
		}
		return cards;
    }
    
    public static int[] suitHist(Card[] cards) {
    	int[] hist = new int[4];
    	for(int i = 0; i < cards.length; i++) {
    		hist[cards[i].suit]++;
    	}
    	return hist;
    }
    
    public static boolean hasFlush(Card[] hand) {
    	for(int x = 0; x < hand.length; x++) {
    		for(int y = 0; y < hand.length; y ++) {
    			if(hand[x].suit != hand[y].suit) {
    				return false;
    			}
    		}
    	}
    	
    	return true;
    }
    
    static Image[][] images = new Image[14][4];
    
    public static void image2darr(){
    	String cardset = "cardset-oxymoron";
    	String suits = "cdhs";

    	for (int suit = 0; suit <= 3; suit++) {
    	    char c = suits.charAt(suit);

    	    for (int rank = 1; rank <= 13; rank++) {
    	        String s = String.format("%s/%02d%c.gif",
    	                                 cardset, rank, c);
    	        images[rank][suit] = new ImageIcon(s).getImage();
    	    }
    	}
    }
}