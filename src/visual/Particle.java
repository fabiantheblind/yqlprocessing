
package visual;

import java.util.ArrayList;

import processing.core.PApplet;

/**
 * @author Giles Whitaker & a Bit by Blindfish
 * found here: http://www.openprocessing.org/visuals/?visualID=6456
 * and here: http://processing.org/discourse/yabb2/YaBB.pl?num=1260390935/0
 * edited by fabiantheblind
 */
public class Particle {
	  public float xpos;
	  public float ypos;
	  public int charge; //charge is +1 or -1
	  public float xspeed, yspeed;
	  public boolean affected=true;
	  PApplet p;
	  public float dragfactor=0.60f; //stop speeds from accumumulating too much
	public static ArrayList<Particle> particlesList;
	public static int numparticles=2;

	  
	  
	  public Particle(PApplet CP, float xpos, float ypos, int charge, float xspeed, float yspeed)
	  {
	    this.xpos=xpos;
	    this.ypos=ypos;
	    this.charge=charge;
	    this.xspeed = xspeed;
	    this.yspeed = yspeed;
	    p = CP;
	    p.println("a Particle");
	  }
	  

	  public void render()
	  {
		  p.stroke(255);
		  p.fill(0);
	     p.ellipse(xpos, ypos, 15, 15);
	     p.line (xpos - 3, ypos, xpos + 3, ypos);
	     if(charge==1) p.line (xpos, ypos-3, xpos, ypos+3);
	  }
	  
	   public void move()
	   {
	     xpos+=xspeed;
	     ypos+=yspeed;
	     xspeed*=dragfactor;
	     yspeed*=dragfactor;
	     if (xpos> p.width) xpos-=p.width;
	     else if (xpos < 0) xpos+=p.width;
	     if (ypos> p.height) ypos-=p.height;
	     else if (ypos < 0) ypos+=p.height;
	  
	     
	     
	   }

	/**
	 * 
	 */
	public static void initParticles() {
		// TODO Auto-generated method stub
		particlesList = new ArrayList<Particle>(numparticles);

	}
}
