package geo;





import processing.core.PApplet;
import seltar.motion.*;
import visual.Particle;
import visual.Style;

public class PlaceMarker {
	 PApplet p;
	  String name;
	  public float lat;
	  public float lng;
	  public Motion motion;
	  public Particle particle;

	 
	  
	  public PlaceMarker(PApplet CP,String name, float lat, float lng, Motion cMotion) {
	    this.name = name;
	    this.lat = lat;
	    this.lng = lng;
	    motion = cMotion;
	    p = CP;

	  }

/**
	 * @param p2
	 * @param name2
	 * @param lat2
	 * @param lng2
	 * @param myMotion
	 * @param particle
	 */
	public PlaceMarker(PApplet CP, String name, float lat, float lng,
			Motion cMotion, Particle cParticle) {
		// TODO Auto-generated constructor stub
	    this.name = name;
	    this.lat = lat;
	    this.lng = lng;
	    motion = cMotion;
	    p = CP;
	    particle = cParticle;
	}

@SuppressWarnings("static-access")
public void display() {
		p.smooth();

		
		 

	    // Equirectangular projection
//	p.println("in method display call lat lon");
	    float x= p.map(lng, -180, 180, 0, p.width); 
	    float y= p.map(lat, 90, -90, 0, p.height);
		motion.springTo(x, y);
		motion.move();
	    p.textFont(Style.font10); 

	    p.noStroke();
	    p.fill(230, 50);
	    p.ellipse(motion.getX()+Style.addToPosX, motion.getY()+Style.addToPosY, 10, 10);
	    p.fill(128, 200);
	    p.ellipse(motion.getX()+Style.addToPosX, motion.getY()+Style.addToPosY, 5, 5);
	    p.stroke(255,200);
	    p.line(motion.getX()+Style.addToPosX,  motion.getY()+Style.addToPosY, particle.xpos, particle.ypos);
	    p.noStroke();
	    float textX = particle.xpos + Style.addToPosX;
	    float textY = particle.ypos +Style.addToPosY ;   
	    p.fill(5,200);
	    p.text(name,textX+2,textY+3);
	    p.fill(255,240);    
	    p.text(name,textX+2,textY+2);
	    particle.render();
	    particle.move();
	    
	    //	    try {
//	    	p.smooth();
//			book.addText(name, p.floor(x), p.floor(y));
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	      try {
//			book.stepAndDraw();
//;
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

	  }

	public  String toString() {
	    return name + " (" + lat + ", " + lng + ")";
	  }
}
