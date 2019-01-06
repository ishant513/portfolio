package moduleflag;
import java.awt.Color;
import java.awt.Graphics;

public class Star {
	private Color color;
	private final int STAR_POINTS = 10;
	private int[] polygonX = new int[STAR_POINTS];
	private int[] polygonY = new int[STAR_POINTS];
	
	public Star() {
		color = Color.WHITE;
	}
	
	public void draw(Graphics g, int centerX, int centerY, double radius) {
		
		double innerRadius = radius*Math.sin(Math.toRadians(18)/Math.sin(Math.toRadians(54)));
		for (int i = 18; i < 360; i += 72) {
			polygonX[(i-18)/36] = centerX + (int) (radius * Math.cos(Math.toRadians(i)));
			polygonY[(i-18)/36] = centerY - (int) (radius * Math.sin(Math.toRadians(i))); 
		}
		for (int i = 54; i < 360; i += 72) {
			polygonX[(i-18)/36] = centerX + (int) (innerRadius * Math.cos(Math.toRadians(i)));
			polygonY[(i-18)/36] = centerY - (int) (innerRadius * Math.sin(Math.toRadians(i))); 
		}
		Color c = g.getColor();
		g.setColor(color);
		g.fillPolygon(polygonX, polygonY, STAR_POINTS);
		g.setColor(c);
	}

}
