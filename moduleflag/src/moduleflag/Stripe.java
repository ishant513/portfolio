package moduleflag;
import java.awt.*;

public class Stripe {
	public Color color;
	
	public Stripe(Color c) {
		color = c;
	}
	
	public void draw(Graphics g, int x, int y, int w, int h) {
		Color c = g.getColor();
		g.setColor(color);
		g.fillRect(x,y,w,h);
		g.setColor(c);
	}
}
