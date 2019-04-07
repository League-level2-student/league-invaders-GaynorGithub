import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener{
	Timer timer;
	GameObject obj;
	final int MENU_STATE = 0;
	final int GAME_STATE = 1;
	final int END_STATE = 2;
	int currentState = MENU_STATE;
	Font titleFont;
	Font subFont;
	
	public GamePanel() {
		timer = new Timer(1000/60, this);
		obj = new GameObject(1,1,1,1);
		titleFont = new Font("Arial", Font.PLAIN, 48);
		subFont = new Font("Arial", Font.PLAIN, 24);
	}
	
	void startGame() {
		timer.start();
	}
	
	void updateMenuState() {
		
	}
	
	void updateGameState() {
		
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
		g.drawString("Press ENTER to start", 20, 350);
		g.drawString("Press SPACE for instructions", 20, 500);
		
	}
	
	void drawGameState(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
	}
	
	void drawEndState(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
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
		if(e.getKeyCode() == 10) {
			currentState++;
		}
		if(currentState > END_STATE){
            currentState = MENU_STATE;
        }
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Key Released");
	}
}
