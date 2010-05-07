package geo;



import processing.core.PApplet;

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


//@SuppressWarnings("static-access")
public void display() {
		
	    // Equirectangular projection
//	p.println("in method display call lat lon");
	    float x= p.map(lng, -180, 180, 0, p.width); 
	    float y= p.map(lat, 90, -90, 0, p.height);
	    
	    p.noStroke();
	    p.fill(255, 0, 0, 50);
	    p.ellipse(x, y, 15, 15);
	    p.fill(255, 0, 0, 200);
	    p.ellipse(x, y, 5, 5);
//	    p.rect(0, 0, p.width, p.height);
	  }

	public  String toString() {
	    return name + " (" + lat + ", " + lng + ")";
	  }
}
