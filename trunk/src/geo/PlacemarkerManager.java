package geo;

import processing.core.PApplet;
import processing.xml.XMLElement;
public class PlacemarkerManager {
	public PApplet p;
	
	public PlacemarkerManager(){
		
		
	}
	
	@SuppressWarnings("static-access")
	public 	void createPlaces(XMLElement[] myElement) {
		
		  
		  for (int i = 0; i < myElement.length; i++) {
		    String name = myElement[i].getChild(2).getContent();
		    float lat = new Float(myElement[i].getChild("centroid").getChild("latitude").getContent());
		    float lng = new Float(myElement[i].getChild("centroid").getChild("longitude").getContent());
		    
		    p.println("RawData: "+name +" "+"lat:"+lat+" lon:" + lng);
		    PlaceMarker placeMarker = new PlaceMarker(name, lat, lng);
		    p.println("PlacemakerData: "+placeMarker);

//		    placeMarkersList.add(placeMarker);

//		    println(i + ": " + placeMarker);  
		  }
		}
}
