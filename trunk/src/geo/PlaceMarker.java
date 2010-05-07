package geo;




import net.nexttext.Book;
import processing.core.PApplet;
import processing.core.PFont;
import seltar.motion.*;
import util.Style;

public class PlaceMarker {
	 PApplet p;
	  String name;
	  public float lat;
	  public float lng;
	  public Motion motion;

	 
	  
	  public PlaceMarker(PApplet CP,String name, float lat, float lng, Motion cMotion) {
	    this.name = name;
	    this.lat = lat;
	    this.lng = lng;
	    motion = cMotion;
	    p = CP;

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
	    p.ellipse(motion.getX()+p.random(-1,1), motion.getY()+p.random(-1,1), 10, 10);
	    p.fill(128, 200);
	    p.ellipse(motion.getX()+p.random(-1,1), motion.getY()+p.random(-1,1), 5, 5);
	    
	    float textX =motion.getX()+p.random(-1,1) ;
	    float textY =motion.getY()+p.random(-1,1) ;   
	    p.fill(5,200);
	    p.text(name,textX+2,textY+3);
	    p.fill(255,240);    
	    p.text(name,textX+2,textY+2);
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
