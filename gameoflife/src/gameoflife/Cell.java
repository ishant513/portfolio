package gameoflife;

import java.awt.Color;

import java.awt.Graphics;



public class Cell {

   private int myX, myY;

   private boolean myAlive;

   private int myNeighbors;

   private boolean myAliveNextTurn;

   private Color myColor;

   private final Color DEFAULT_ALIVE = Color.ORANGE;

   private final Color DEFAULT_DEAD = Color.GRAY;

   public Cell(int x, int y) {
       this(x, y, false, Color.GRAY);
   }

   public Cell(int row, int col, boolean alive, Color color) {
       myAlive = alive;
       myColor = color;
       myX = col;
       myY = row;
   }

   public boolean getAlive() {
       return myAlive;
   }

   public int getX() {
       return myX;
   }
   
   public int getY() {
       return myY;
   }

   public Color getColor() {
       return myColor;
   }

   public void setAlive(boolean alive) {
       if (alive) {
           setAlive(true, DEFAULT_ALIVE);
       } else {
           setAlive(false, DEFAULT_DEAD);
       }
   }



   public void setAlive(boolean alive, Color color) {
       myColor = color;
       myAlive = alive;
   }


   public void setAliveNextTurn(boolean alive) {
       myAliveNextTurn = alive;
   }

   public boolean getAliveNextTurn() {
       return myAliveNextTurn;
   }

   public void setColor(Color color) {
       myColor = color;
   }



   public int getNeighbors(Cell[][] cells) {
       calcNeighbors(cells);
       return myNeighbors;
   }



   public void calcNeighbors(Cell[][] cells) {
       myNeighbors = 0;
       for (int i = 0; i < 3; i++) {
           for (int j = 0; j < 3; j++) {
               if (!(i == 1 && j == 1)) {
                   myNeighbors += (cells[(i + myY - 1 + 80) % 80][(j + myX - 1 + 100) % 100].getAlive() ? 1 : 0);
               }
           }
       }
   }



   public void draw(int x_offset, int y_offset, int width, int height, Graphics g) {
       int xleft = x_offset + 1 + (myX * (width + 1));
       int xright = x_offset + width + (myX * (width + 1));
       int ytop = y_offset + 1 + (myY * (height + 1));
       int ybottom = y_offset + height + (myY * (height + 1));
       Color temp = g.getColor();
       g.setColor(myColor);
       g.fillRect(xleft, ytop, width, height);
   }
}