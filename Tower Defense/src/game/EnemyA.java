/**
 * this class defines enemyA 
 * 
 * @author  Clarissa Seebohm
 * @version November 14, 2022
 */

package game;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;

import path.Path;

public class EnemyA extends GameObject {
	
	private double percentage;
    BufferedImage image;
    Path path;
    State state;
    
    /**
     * this constructor makes one EnemyA object, the default percentage is zero
     * the enemy is visible and not expired
     * 
     * @param Path
     * @param BufferedImage
     */
    public EnemyA(Path path, BufferedImage enemyA, State state)
    {
    	this.percentage = 0;
        
        isVisible = true;
        isExpired = false;
        
        this.image = enemyA;
        this.path = path;
        this.state = state;
    }

    /**
     * this method updates the percentage after a certain time has elapsed
     * 
     * @param double timeElapsed
     */
	public void update(double timeElapsed) {
		//update the percentage by .1 percent
		percentage += 0.001;
		
		if(percentage >= (1)){
			//expire current enemy
            isExpired = true;

            //spawn new enemy
            state.addGameObject(new EnemyA(path, image, state));

            //lose life
            state.changeLives(-1);
        }
	}

    /**
     * this method draws enemyA at the percentage along the path
     * 
     * @param Graphics g 
     */
	public void draw(Graphics g) {
		Point p = path.convertToCoordinates(percentage);
		g.drawImage(image, p.x - 10, p.y - 10, null);	
	}
}
