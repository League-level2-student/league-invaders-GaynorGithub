import java.awt.Dimension;
import java.awt.event.KeyEvent;


import javax.swing.JFrame;

public class LeagueInvaders {
	JFrame frame;
	final static int HEIGHT = 800; 
	final static int WIDTH = 500;
	GamePanel game;
	
	
	//Constructor
	public LeagueInvaders() {
		frame = new JFrame();
		game = new GamePanel();
	}
	
	//main method
	public static void main(String[] args) {
		LeagueInvaders invade = new LeagueInvaders();
		invade.setup();
	}
	
	//creates frame and general setup
	void setup() {
		frame.add(game);
		frame.addKeyListener(game);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setPreferredSize(new Dimension(WIDTH, HEIGHT));
        frame.pack();
        game.startGame();
	}

	
	
	
	
	
	
	
	
	
	
}
