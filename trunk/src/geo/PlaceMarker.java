package geo;




import net.nexttext.Book;
import processing.core.PApplet;
import processing.core.PFont;

public class PlaceMarker {
	 PApplet p;
	  String name;
	  public float lat;
	  public float lng;

	 
	  
	  public PlaceMarker(PApplet CP,String name, float lat, float lng) {
	    this.name = name;
	    this.lat = lat;
	    this.lng = lng;
	    p = CP;

	  }

@SuppressWarnings("static-access")
public void display(PFont font) {
	p.smooth();

	    // Equirectangular projection
//	p.println("in method display call lat lon");
	    float x= p.map(lng, -180, 180, 0, p.width); 
	    float y= p.map(lat, 90, -90, 0, p.height);
	    p.textFont(font); 

	    p.noStroke();
	    p.fill(230, 50);
	    p.ellipse(x, y, 10, 10);
	    p.fill(128, 200);
	    p.ellipse(x, y, 5, 5);
	    p.fill(255,230);
	    p.text(name,x,y);
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
