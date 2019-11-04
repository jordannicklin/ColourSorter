

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JFrame;

public class Main {
	final public static JFrame window = new JFrame("colour sorter");
	final public static Render2D render2D = new Render2D();
	final public static GameLoop gameLoop = new GameLoop();
	
	public static ArrayList<Block> boardBlock = new ArrayList<Block>();
	public static ArrayList<Integer> keysPressed = new ArrayList<Integer>();
	
	public static int boardSize = 0;
	
	public static void main(String[] args){		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		
		int width = 600;
		int height = 600;
		
		window.setSize(width, height);
		window.setLocation(screenSize.width / 2 - width / 2, screenSize.height / 2 - height / 2);
		window.setVisible(true);
		//window.setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		window.add(render2D);
		
		window.addKeyListener(new KeyListener() {
			public void keyTyped(KeyEvent e) {}
			
			public void keyReleased(KeyEvent e) {
				keysPressed.remove(keysPressed.indexOf(e.getKeyCode()));
				
				System.out.println("Key released: " + e.getKeyCode() + ". Total keys pressed: " + keysPressed.size());
			}
			
			public void keyPressed(KeyEvent e) {
				if(!keysPressed.contains(e.getKeyCode())){
					keysPressed.add(e.getKeyCode());
					
					System.out.println("Key pressed: " + e.getKeyCode() + ". Total keys pressed: " + keysPressed.size());
				}
			}
		});
		
		window.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent windowEvent){
				System.exit(0);
			}
		});
		
		createBoard();
		
		gameLoop.startLoop(); //Initiate game logic
	}
	
	public static int getWidth(){
		return window.getContentPane().getWidth();
	}
	
	public static int getHeight(){
		return window.getContentPane().getHeight();
	}
	
	public static void createBoard() {
		for(int boardY = 0; boardY < getHeight(); boardY += 2)
		{
			for(int boardX = 0; boardX < getWidth(); boardX += 2)
			{
				Block temp = new Block();
				
				temp.y = boardY;
				temp.x = boardX;
				
				boardBlock.add(temp);
			}
		}
		
		boardSize = (getHeight()/2-1) * (getWidth()/2-1);
	}
}