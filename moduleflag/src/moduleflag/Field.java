package moduleflag;

import java.awt.Color;
import java.awt.Graphics;

public class Field {
	public Color color = Color.BLUE;
	
	public Field() {	}
	
	public void draw(Graphics g, int x, int y, int w, int h) {
		Color c = g.getColor();
		g.setColor(color);
		g.fillRect(x,y,w,h);
		g.setColor(c);
	}

}
