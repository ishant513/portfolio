package convexHUll;

import java.awt.*;
import javax.swing.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main extends JPanel {
	
	/**
	 * there must only be 8 points
	 */
	private static final long serialVersionUID = 1L;
	static int[][] coordinates = new int[8][2]; //was 4
	
	public static void genCoords() throws FileNotFoundException  {
		
		Scanner input = new Scanner(new FileInputStream("coordinates2.txt"));
		
		int coordinate;
		for (int i = 0; i < 8; i++) { 
			System.out.println(coordinates[0][0]);
			for (int y = 0; y < 2; y++) { //gets X and Y
				coordinate = input.nextInt();
				coordinates[i][y] = coordinate;
				System.out.println(coordinate);
			}
		}
		input.close();
	}
	
	public void paintComponent(Graphics g) {
		g.drawString("Convex Hull - FD", 400, 700);
		g.setColor(Color.black);
		
		for (int x = 1; x <= 8; x++) {
			if (x == 8) {
				g.drawLine(coordinates[0][0], coordinates[0][1], coordinates[7][0], coordinates[7][1]);
				
			} else {
				g.drawLine(coordinates[x - 1][0], coordinates[x - 1][1], coordinates[x][0], coordinates[x][1]);
			}
		}
		
		for (int z = 0; z < 8; z++) {
			g.drawString(coordinates[z][0] + " , " + coordinates[z][1], coordinates[z][0], coordinates[z][1]);
		}
		
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		JFrame.setDefaultLookAndFeelDecorated(true);
		JFrame frame = new JFrame("Simple Window");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBackground(Color.white);
		frame.setSize(800, 800);
		
		genCoords();
		
		Main panel = new Main();
		frame.add(panel); 
		frame.setVisible(true);
	}
}
