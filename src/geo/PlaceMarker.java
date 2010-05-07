package geo;

import processing.core.PApplet;

public class PlaceMarker {
	public PApplet p;
	  String name;
	  float lat;
	  float lng;

	  public PlaceMarker(String name, float lat, float lng) {
	    this.name = name;
	    this.lat = lat;
	    this.lng = lng;


	  }


@SuppressWarnings("static-access")
public void display() {
	    // Equirectangular projection
	    float x = p.map(lng, -180, 180, 0, p.width); 
	    float y = p.map(lat, 90, -90, 0, p.height);
	    
	    p.noStroke();
	    p.fill(255, 0, 0, 50);
	    p.ellipse(x, y, 15, 15);
	    p.fill(255, 0, 0, 200);
	    p.ellipse(x, y, 5, 5);
	  }

	public  String toString() {
	    return name + " (" + lat + ", " + lng + ")";
	  }
}
