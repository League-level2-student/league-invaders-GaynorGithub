import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager implements ActionListener {
	Rocketship rock;
	ArrayList<Projectile> projectiles;
	ArrayList<Alien> aliens;
	Random rand = new Random();
	
	public ObjectManager(Rocketship r) {
		projectiles = new ArrayList<Projectile>();
		aliens = new ArrayList<Alien>();
		rock = r;
	}
	
	void update() {
		rock.update();
		for (Alien alien : aliens) {
			alien.update();
			if(alien.y < 0 && alien.y > LeagueInvaders.HEIGHT) {
				alien.isAlive = false;
			}
		}
		for (Projectile proj : projectiles) {
			proj.update();
			if(proj.y < 0 && proj.y > LeagueInvaders.HEIGHT) {
				proj.isAlive = false;
			}
		}
	}
	
	void draw(Graphics g) {
		rock.draw(g);
		for (Alien alien : aliens) {
			alien.draw(g);
		}
		for (Projectile proj : projectiles) {
			proj.draw(g);
		}
	}
	
	void checkCollision() {
		for (Alien alien : aliens) {
			if(rock.collisionBox.intersects(alien.collisionBox)) {
				rock.isAlive = false;
				alien.isAlive = false;
			}
			for (Projectile projectile : projectiles) {
				if (projectile.collisionBox.intersects(alien.collisionBox)) {
					projectile.isAlive = false;
					alien.isAlive = false;
				}
			}
			
		}
	}
	
	void purgeObjects() {
		for (int i = 0; i < aliens.size(); i++) {
			if(!aliens.get(i).isAlive) {
				aliens.remove(i);
			}
		}
		for (int i = 0; i < projectiles.size(); i++) {
			if(!projectiles.get(i).isAlive) {
				projectiles.remove(i);
			}
		}
	}
	
	void addProjectile(Projectile p) {
		projectiles.add(p);
	}
	
	void addAlien() {
		aliens.add(new Alien(rand.nextInt(LeagueInvaders.WIDTH),0,50,50));

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		addAlien();
	}
}
