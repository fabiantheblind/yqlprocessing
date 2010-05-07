package geo;

import java.util.ArrayList;



import processing.core.PApplet;
import processing.xml.XMLElement;
public class PlacemarkerManager {


	public PlacemarkerManager(PApplet p){
		
		placeList = new ArrayList<PlaceMarker>();
	}
	public ArrayList<PlaceMarker> placeList;// = new ArrayList<PlaceMarker>();
	
	

	public 	void init(XMLElement[] myElement) {
		
		  
		  for (int i = 0; i < myElement.length; i++) {
		    String name = myElement[i].getChild(2).getContent();
		    float lat = new Float(myElement[i].getChild("centroid").getChild("latitude").getContent());
		    float lng = new Float(myElement[i].getChild("centroid").getChild("longitude").getContent());
		    
//		   System.out.println("RawData: "+name +" "+"lat:"+lat+" lon:" + lng);
		    PlaceMarker placeMarker = new PlaceMarker(name, lat, lng);
//		    System.out.println("PlacemakerData: "+placeMarker);

		    placeList.add(placeMarker);

//		    println(i + ": " + placeMarker);  
		  }
		}
	
	public void drawPlaces(){
		System.out.println("Begin Iteration thru Arraylist<PlaceMarker>");
		for(int i = 0; i<placeList.size();i++){
			System.out.println("Call Method display() from Class PlaceMarker");
			(placeList.get(i)).display();
		}
		
		
	}
}
