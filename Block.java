
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Random;

public class Block {
	int x;
	int y;
	int r;
	int g;
	int b;
	int size;
	Color colour;
	
	public void reset(){
		Random rand = new Random();
		
		this.r = 0;//rand.nextInt(255);
		this.g = rand.nextInt(255);
		this.b = rand.nextInt(255);
		
		size = 2;
		
		this.colour = new Color(this.r, this.g, this.b);
	}
	
	public Block() {
		Random rand = new Random();
		
		this.r = 0;//rand.nextInt(255);
		this.g = rand.nextInt(255);
		this.b = rand.nextInt(255);
		
		size = 2;
		
		this.colour = new Color(this.r, this.g, this.b);
	}
	
	public void draw(Graphics2D g2d){
		this.colour = new Color(this.r, this.g, this.b);
		g2d.setColor(this.colour);
		g2d.fillRect(this.x, this.y, this.size, this.size);
	}
	
	public void sortG(Block nextBlock){
		//System.out.println(nextBlock.g + " " + this.g);
		
		if(nextBlock.g >= this.g){
			//System.out.println("change g");
			
			int tempB = nextBlock.b;
			int tempG = nextBlock.g;
			
			nextBlock.b = this.b;
			nextBlock.g = this.g;
			
			this.b = tempB;
			this.g = tempG;
		}
	}
	
	public void sortB(Block nextBlock){
		//System.out.println(nextBlock.b + " " + this.b);
		
		if(nextBlock.b > this.b){
			//System.out.println("change b");
			
			int tempB = nextBlock.b;
			int tempG = nextBlock.g;
			int tempR = nextBlock.r;
			
			nextBlock.b = this.b;
			nextBlock.r = this.r;
			nextBlock.g = this.g;
			
			this.b = tempB;
			this.g = tempG;
			this.r = tempR;
		}
	}
}
