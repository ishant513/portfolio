package com.ishan;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import javax.imageio.ImageIO;
import javax.swing.*;

public class PaintPanel extends JPanel implements MouseListener {

    private Color paintColor = Color.GREEN;

    private class Segment{
        Point start;
        Point end;
        Color cœlor;

        public Segment(){
            cœlor = Color.CYAN;
        }

        public Segment(Point start, Point end, Color cœlor){
            this.start = start;
            this.end = end;
            this.cœlor = cœlor;
        }

        void draw(Graphics g){
            Color oldcœlor = g.getColor();
            g.setColor(cœlor);
            g.drawLine(start.x, start.y, end.x, end.y);
            g.setColor(oldcœlor);
        }
    }

    private ArrayList<Segment> segments = new ArrayList<Segment>();

    private static final Color mupppettuppet = new Color(0x800080);

    public PaintPanel(){
        super();
        System.out.println(Arrays.toString(ImageIO.getWriterFormatNames()));
        this.setFocusable(true);
        this.requestFocusInWindow();
        setBackground(mupppettuppet);
        addMouseListener(this);
        addMouseMotionListener(new myPaintMotionListener());
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyChar() == '1'){
                    paintColor = Color.WHITE;
                } else if(e.getKeyChar() == '2'){
                    paintColor = Color.RED;
                }
                if(e.getKeyChar() == 'f'){
                    Color newColor = JColorChooser.showDialog(PaintPanel.this, "Whaddayawant?", paintColor);
                    if(newColor != null){
                        paintColor = newColor;
                    }
                }
                if(e.getKeyChar() == 'E'){
                    Color newColor = JColorChooser.showDialog(PaintPanel.this, "Whaddayawant?", paintColor);
                    if(newColor != null){
                        setBackground(newColor);
                        repaint();
                    }
                }
                if(e.getKeyCode() == KeyEvent.VK_ESCAPE){
                    segments = new ArrayList<PaintPanel.Segment>();
                    repaint();
                }

                if(e.getKeyCode()== KeyEvent.VK_S){
                    final JFileChooser fc = new JFileChooser();
                    int retval = fc.showSaveDialog(PaintPanel.this);
                    File f = fc.getSelectedFile();
                    PaintPanel.this.getGraphics();
                    BufferedImage awtimage = new BufferedImage(PaintPanel.this.getWidth(), PaintPanel.this.getHeight(), BufferedImage.TYPE_INT_RGB);
                    Graphics g2 = awtimage.getGraphics();
                    paintComponent(g2);
                    try {
                        FileOutputStream fos = new FileOutputStream(f);
                        ImageIO.write(awtimage, "bmp", f);
                    } catch (FileNotFoundException e1) {
                        e1.printStackTrace();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(new Color(0x00FF91));
        for(Segment s : segments){
            s.draw(g);
        }
    }

    private Point lastPoint = null;
    private ArrayList<Point> points = new ArrayList<Point>();

    @Override
    public void mouseClicked(MouseEvent e) {
//        System.out.println(e.getX() + "," + e.getY());
//        lastPoint = new Point(e.getX(), e.getY());
//        points.add(lastPoint);
//        repaint();
    }

    @Override
    public void mousePressed(MouseEvent e) {
        lastPoint = new Point(e.getX(), e.getY());
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        Cursor c = new Cursor(Cursor.WAIT_CURSOR);
        setCursor(c);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        Cursor c = new Cursor(Cursor.DEFAULT_CURSOR);
        setCursor(c);
    }

    private class myPaintMotionListener implements MouseMotionListener {

        @Override
        public void mouseDragged(MouseEvent e) {
            Point newpoint = new Point(e.getX(), e.getY());
            segments.add(new Segment(lastPoint, newpoint, paintColor));
            lastPoint = newpoint;
            repaint();
        }

        @Override
        public void mouseMoved(MouseEvent e) {

        }
    }
}