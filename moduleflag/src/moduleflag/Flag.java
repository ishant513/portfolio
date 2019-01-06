package moduleflag;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JApplet;

public class Flag extends JApplet {
	private final int STRIPES = 13;
	private final int STARS = 50;
	private final double A = 1.0;
	private final double B = 1.9;
	private final double C = 7.0 / STRIPES;
	private final double D = .76;
	private final double E = .054;
	private final double F = .054;
	private final double G = .063;
	private final double H = .063;
	private final double K = .0616;
	private final double L = 1.0 / STRIPES;
	private double flag_width;
	private double flag_height;
	private double stripe_height;

	public void init() {
		setSize(760, 400);
		repaint();
	}

	public void paint(Graphics g) {
		flag_width = getWidth();
		flag_height = getHeight();
		if ((B/A) * flag_height > flag_width) {
			flag_height = (flag_width / (B / A));
		} else {
			flag_width = (flag_height * (B / A));
		}
		stripe_height = flag_height / STRIPES;
		drawBackground(g);
		drawStripes(g);
		drawField(g);
		drawStars(g);
	}

	private void drawBackground(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0,0,getWidth(),getHeight());
	}

	public void drawStripes(Graphics g) {
		Stripe red = new Stripe(Color.RED);
		Stripe white = new Stripe(Color.WHITE);
		Stripe s;
		for (int i = 0; i < STRIPES; i++) {
			s = i % 2 == 0 ? red : white;
			s.draw(g, 1, (int) (i * stripe_height + 1),
					(int) (flag_width - 1), (int) (stripe_height - 1));
		}
	}

	public void drawField(Graphics g) {
		Field f = new Field();
		int w = (int) (flag_width * D / B);
		int h = (int) (stripe_height * 7) - 1;
		f.draw(g, 1, 1, w, h);
	}

	public void drawStars(Graphics g) {
		double xOffset = (G / B * flag_width);
		double yOffset = (E / A * flag_height);

		double xSpacer = (H / B * flag_width);
		double ySpacer = (F / A * flag_height);

		double radius = (K / B / 2 * flag_width);
		final int MAJOR_ROWS = 5;
		final int MAJOR_STARS = 6;
		final int MINOR_ROWS = 4;
		final int MINOR_STARS = 5;

		Star s = new Star();

		for (int row = 0; row < MAJOR_ROWS; row++) {
			for (int col = 0; col < MAJOR_STARS; col++) {
				s.draw(g, (int) (xOffset + col * 2 * xSpacer),
						(int) (yOffset + row * 2 * ySpacer), radius);
			}
		}
		for (int row = 0; row < MINOR_ROWS; row++) {
			for (int col = 0; col < MINOR_STARS; col++) {
				s.draw(g, (int) (xOffset + xSpacer + col * 2 * xSpacer),
						(int) (yOffset + ySpacer + row * 2 * ySpacer), radius);
			}
		}
	}
}
