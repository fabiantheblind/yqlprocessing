package geo;

import java.util.ArrayList;

import net.nexttext.Book;



import processing.core.PApplet;
import processing.core.PFont;
import processing.xml.XMLElement;
public class PlacemarkerManager {
	PApplet p;
	public Book book;
//	PFont font;

	public PlacemarkerManager(PApplet CP){
		p=CP;
		placeList = new ArrayList<PlaceMarker>();
	}
	public ArrayList<PlaceMarker> placeList;// = new ArrayList<PlaceMarker>();
	
//	@SuppressWarnings("static-access")
//	private void makeType(){
//		  // create the Book
//	       book = new Book(p);
//
//	      // load and set the font
//	       font = p.createFont("./data/GenBasR.ttf", 11);
//	      p.textFont(font);
//	      p.textAlign(p.CENTER);
//	      p.fill(255,230);
////	      p.stroke(250,100);
////	      p.strokeWeight(1); 
//		  
//	  }
	

	public 	void init(XMLElement[] myElement) {
//		makeType();
		  
		  for (int i = 0; i < myElement.length; i++) {
		    String name = myElement[i].getChild(2).getContent();
		    float lat = new Float(myElement[i].getChild("centroid").getChild("latitude").getContent());
		    float lng = new Float(myElement[i].getChild("centroid").getChild("longitude").getContent());
		    
//		   System.out.println("RawData: "+name +" "+"lat:"+lat+" lon:" + lng);
		    PlaceMarker placeMarker = new PlaceMarker(p,name, lat, lng);
//		    System.out.println("PlacemakerData: "+placeMarker);

		    placeList.add(placeMarker);
//		    println(i + ": " + placeMarker);  
		  }
		}
	
	public void drawPlaces(PFont font){
		
//		System.out.println("Begin Iteration thru Arraylist<PlaceMarker>");
		for(int i = 0; i<placeList.size();i++){
//			System.out.println("Call Method display() from Class PlaceMarker");


			(placeList.get(i)).display(font);
		}

		
		
	}
}
