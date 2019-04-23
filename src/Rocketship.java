import java.awt.Color;
import java.awt.Graphics;

public class Rocketship extends GameObject{

	
	
	
	public Rocketship(int x, int y, int width, int height) {
		super(x, y, width, height);
		speed = 5;
		
	}
	
	void update() {
		
	}
	
	void draw(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(x, y, width, height);
	}
	
	public Projectile getProjectile() {
        return new Projectile(x+width/2, y, 10, 10);
	} 
	
	void up() {
		y-=speed;
		
		
	}
	void down() {
		y+=speed;
		
	}
	void left() {
		x-=speed;
		
	}
	void right() {
		x+=speed;
		
	}
	
}
