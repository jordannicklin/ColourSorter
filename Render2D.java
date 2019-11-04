

import java.awt.Color;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Render2D extends JPanel{
	public boolean drawTestPoint = false;
	public double testPointX;
	public double testPointY;
	public double viewOffsetX;
	public double viewOffsetY;
	
	//get the color difference between two colors
	public static int getColorDifference(Color c1, Color c2){
		return ((c2.getRed() - c1.getRed())^2 + (c2.getGreen() - c1.getGreen())^2 + (c2.getBlue() - c1.getBlue())^2)^2;
	}
	
	//get if a point is in screen
	public static boolean isInScreen(int x, int y){
		return x > 0 && x < Main.getWidth() && y > 0 && y < Main.getHeight();
	}
	
	public void doRepaint(float intpol){
		this.repaint();
	}
	
	public void paintComponent(Graphics g){
		Graphics2D g2d = (Graphics2D) g.create();
		
		//draw/repaint/clean screen
		//bullshit way to clear the screen, not sure if this is the best way but best not to change it
		g2d.setColor(Color.BLACK);
		g2d.fillRect(0, 0, Main.getWidth(), Main.getHeight());
		
		if(drawTestPoint){
			g2d.setColor(Color.RED);
			g2d.fillOval((int)testPointX - 3, (int)testPointY - 3, 6, 6);
		}
		
		for(int i = 0; i < Main.boardSize; i++)
		{
			Block block = Main.boardBlock.get(i);
			
			block.draw(g2d);
		}
	}
}
