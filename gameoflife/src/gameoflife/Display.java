package gameoflife;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JButton;
import javax.swing.JComponent;

public class Display extends JComponent implements MouseListener, MouseMotionListener {
   public static final int ROWS = 80;
   public static final int COLS = 100;
   public static Cell[][] cell = new Cell[ROWS][COLS];
   private final int X_GRID_OFFSET = 25;
   private final int Y_GRID_OFFSET = 40;
   private final int CELL_WIDTH = 5;
   private final int CELL_HEIGHT = 5;
   private final int DISPLAY_WIDTH;
   private final int DISPLAY_HEIGHT;
   private StartButton startStop;
   private boolean paintloop = false;
   

   public Display(int width, int height) {
       DISPLAY_WIDTH = width;
       DISPLAY_HEIGHT = height;
       init();
   }


   public void init() {
       setSize(DISPLAY_WIDTH, DISPLAY_HEIGHT);
       initCells();

       addMouseListener(this);
       addMouseMotionListener(this);
       startStop = new StartButton();
       startStop.setBounds(100, 550, 100, 36);
       add(startStop);
       startStop.setVisible(true);
       repaint();
   }


   public void paintComponent(Graphics g) {
       final int TIME_BETWEEN_REPLOTS = 50; // change to your liking

       g.setColor(Color.BLACK);
       drawGrid(g);
       drawCells(g);
       drawButtons();

       if (paintloop) {
           try {
               Thread.sleep(TIME_BETWEEN_REPLOTS);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }

           nextGeneration();

           repaint();
       }
   }


   public void initCells() {
       for (int row = 0; row < ROWS; row++) {
           for (int col = 0; col < COLS; col++) {
               cell[row][col] = new Cell(row, col);
           }
       }

       cell[36][22].setAlive(true);
       cell[36][23].setAlive(true);
       cell[36][24].setAlive(true);
       cell[35][24].setAlive(true);
       cell[34][23].setAlive(true);

   }


   public void togglePaintLoop() {
       paintloop = !paintloop;
   }


   public void setPaintLoop(boolean value) {
       paintloop = value;
   }


   void drawGrid(Graphics g) {
       for (int row = 0; row <= ROWS; row++) {
           g.drawLine(X_GRID_OFFSET,
                   Y_GRID_OFFSET + (row * (CELL_HEIGHT + 1)), X_GRID_OFFSET
                           + COLS * (CELL_WIDTH + 1), Y_GRID_OFFSET
                           + (row * (CELL_HEIGHT + 1)));
       }
       for (int col = 0; col <= COLS; col++) {
           g.drawLine(X_GRID_OFFSET + (col * (CELL_WIDTH + 1)), Y_GRID_OFFSET,
                   X_GRID_OFFSET + (col * (CELL_WIDTH + 1)), Y_GRID_OFFSET
                           + ROWS * (CELL_HEIGHT + 1));
       }
   }


   void drawCells(Graphics g) {
       // Have each cell draw itself
       for (int row = 0; row < ROWS; row++) {
           for (int col = 0; col < COLS; col++) {
               // The cell cannot know for certain the offsets nor the height
               // and width; it has been set up to know its own position, so
               // that need not be passed as an argument to the draw method
               cell[row][col].draw(X_GRID_OFFSET, Y_GRID_OFFSET, CELL_WIDTH, CELL_HEIGHT, g);
           }
       }
   }


   private void drawButtons() {
       startStop.repaint();
       //step.repaint();
   }

   private void moveOverByOne() {
       boolean[][] grid = new boolean[80][100];

       for (int i = 0; i < 80; i++) {
           for (int j = 0; j < 100; j++) {
               if (cell[i][j].getAlive()) {
                   grid[i][j] = true;
               }
           }
       }

       for (int i = 0; i < 80; i++) {
           for (int j = 0; j < 100; j++)
               cell[i][j].setAlive(false);
       }

       for (int i = 0; i < 80; i++) {
           for (int j = 0; j < 100; j++) {
               if (grid[i][j]) {
                   cell[i][j + 1].setAlive(true);
               }
           }
       }
   }

   private void nextGeneration() {

       boolean[][] grid = new boolean[80][100];

       for (int i = 0; i < 80; i++) {
           for (int j = 0; j < 100; j++) {
               int n = cell[i][j].getNeighbors(cell);
               System.out.println(n);

               if (cell[i][j].getAlive()) {
                   if (n == 2 || n == 3)
                       grid[i][j] = true;
               } else {
                   if (n == 3)
                       grid[i][j] = true;
               }
           }
       }

       for (int i = 0; i < 80; i++) {
           for (int j = 0; j < 100; j++) {
               cell[i][j].setAlive(false);

               if (grid[i][j])
                   cell[i][j].setAlive(true);
           }
       }

   }


   public void mouseClicked(MouseEvent arg0) {

   }


   public void mouseEntered(MouseEvent arg0) {

   }


   public void mouseExited(MouseEvent arg0) {

   }


   public void mousePressed(MouseEvent arg0) {

   }


   public void mouseReleased(MouseEvent arg0) {

   }


   public void mouseDragged(MouseEvent arg0) {

   }

   public void mouseMoved(MouseEvent arg0) {

   }

   private class StartButton extends JButton implements ActionListener {
       StartButton() {
           super("Start");
           addActionListener(this);
       }

       public void actionPerformed(ActionEvent arg0) {
           // nextGeneration();
           if (this.getText().equals("Start")) {
               togglePaintLoop();
               setText("Stop");
           } else {
               togglePaintLoop();
               setText("Start");
           }
           repaint();
       }
   }

   /*
   private class StepButton extends JButton implements ActionListener {
       StepButton() {
           super("Step");
           addActionListener(this);
       }

       public void actionPerformed(ActionEvent arg0) {
           moveOverByOne();

           repaint();
       }
   }
   */
}
