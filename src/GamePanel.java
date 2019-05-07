import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener{
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;	
	Timer timer;
	Timer alienSpawn;
	final int MENU_STATE = 0;
	final int GAME_STATE = 1;
	final int END_STATE = 2;
	int currentState = MENU_STATE;
	Font titleFont;
	Font subFont;
	Rocketship rock = new Rocketship(250,700,50,50);
	boolean movingUp = false;
	boolean movingDown = false;
	boolean movingLeft = false;
	boolean movingRight = false;
	ObjectManager ob = new ObjectManager(rock);
	
	public GamePanel() {
		timer = new Timer(1000/60, this);
		timer.start();
		titleFont = new Font("Arial", Font.PLAIN, 48);
		subFont = new Font("Arial", Font.PLAIN, 24);
		if (needImage) {
		    loadImage ("space.png");
		}
	}
	
	void startGame() {
		alienSpawn = new Timer(1000 , ob);
	    alienSpawn.start();
	}
	
	void updateMenuState() {
		
	}
	
	void updateGameState() {
		ob.update();
		if(movingUp && rock.y > 0) {
			rock.up();
		}
		else if(movingDown && rock.y < LeagueInvaders.HEIGHT - rock.height) {
			rock.down();
		}
		else if(movingLeft && rock.x > 0) {
			rock.left();
		}
		else if(movingRight && rock.x < LeagueInvaders.WIDTH - rock.width) {
			rock.right();
		}
		
	}
	
	void updateEndState() {
		
	}
	
	void drawMenuState(Graphics g) {
		
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		g.setColor(Color.YELLOW);
		g.setFont(titleFont);
		g.drawString("LEAGUE INVADERS", 20, 200);
		g.setFont(subFont);
		g.drawString("Press ENTER to start", 130, 350);
		g.drawString("Press SPACE for instructions", 90, 500);
		
	}
	
	void drawGameState(Graphics g) {
		if (gotImage) {
			g.drawImage(image, 0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT, null);
		} else {
			g.setColor(Color.black);
			g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		}
		ob.draw(g);
		
		
	}
	
	void drawEndState(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		g.setColor(Color.BLACK);
		g.setFont(titleFont);
		g.drawString("Game Over", 120, 200);
		g.setFont(subFont);
		g.drawString("You killed " + "0" + " enemies", 135, 350);
		g.drawString("Press ENTER to restart", 120, 500);
	}
	
	void loadImage(String imageFile) {
	    if (needImage) {
	        try {
	            image = ImageIO.read(this.getClass().getResourceAsStream(imageFile));
		    gotImage = true;
	        } catch (Exception e) {
	            
	        }
	        needImage = false;
	    }
	}

	
	@Override

	public void paintComponent(Graphics g){  
		if(currentState == MENU_STATE){
            drawMenuState(g);
		} else if(currentState == GAME_STATE){
            drawGameState(g);
    		} else if(currentState == END_STATE){
            drawEndState(g);
    		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(currentState == MENU_STATE){
            updateMenuState();
		} else if(currentState == GAME_STATE){
            updateGameState();
    		} else if(currentState == END_STATE){
            updateEndState();
    		}
		
		repaint();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Key Typed");
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Key Pressed");
		if(e.getKeyCode() == KeyEvent.VK_ENTER) {
			currentState++;
		}
		if(currentState > END_STATE){
            currentState = MENU_STATE;
        }
		
		if(e.getKeyCode() == KeyEvent.VK_UP) {
			
			movingUp = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			
			movingDown = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			
			movingLeft = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			
			movingRight = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_SPACE) {
			ob.addProjectile(rock.getProjectile());
		}
		
		
		
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Key Released");
		if(e.getKeyCode() == KeyEvent.VK_UP) {
			
			movingUp = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			
			movingDown = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			
			movingLeft = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			
			movingRight = false;
		}
	}
}
