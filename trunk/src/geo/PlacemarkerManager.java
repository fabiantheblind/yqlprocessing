/**
 * @author fabianmoronzirfas
 * known as fabianthelbind
 * this Class builds Placemarkers from an YQL placemaker query Response
 * init() needs input from this
 * Querys.getResponseFromTable(String YQLStatements.makePlacesStat(String incomingTXT));
 * the Response is an xmlElement with this structure:
 * 
 *  <place xmlns="http://wherein.yahooapis.com/v1/schema">
 *   <woeId xmlns="http://wherein.yahooapis.com/v1/schema">55959686</woeId>
 *     <type xmlns="http://wherein.yahooapis.com/v1/schema">Sea</type>
 *     <name xmlns="http://wherein.yahooapis.com/v1/schema">Gulf of Mexico</name>
 *     <centroid xmlns="http://wherein.yahooapis.com/v1/schema">
 *         <latitude xmlns="http://wherein.yahooapis.com/v1/schema">24.2785</latitude>
 *         <longitude xmlns="http://wherein.yahooapis.com/v1/schema">-89.1588</longitude>
 *     </centroid>
 * </place>
 */

package geo;

import java.util.ArrayList;
import processing.core.PApplet;
import processing.xml.XMLElement;
import seltar.motion.Motion;

import visual.Particle;

public class PlacemarkerManager {
	PApplet p;
	public Motion myMotion;
	public ArrayList<PlaceMarker> placeList;// = new ArrayList<PlaceMarker>();
	public Particle[] placeParticle;

	public PlacemarkerManager(PApplet CP){
		p=CP;
		placeList = new ArrayList<PlaceMarker>();
	}
	

	@SuppressWarnings("static-access")
	public 	void init(XMLElement[] myElement,Particle particle) {
		
	
		
		for (int i = 0; i < myElement.length; i++) {
			 {

				 
//				    if (i%2==0) placeParticle[i] = new Particle(p,p.random(p.width/10, 9*p.width/10), p.random(p.height/10, 9*p.height/10), 1, 0, 0);
//				    else placeParticle[i]= new Particle(p,p.random(p.width/10, 9*p.width/10),p.random(p.height/10, 9*p.height/10),-1, 0, 0);
			
				  
		    String name = myElement[i].getChild(2).getContent();
		    float lat = new Float(myElement[i].getChild("centroid").getChild("latitude").getContent());
		    float lng = new Float(myElement[i].getChild("centroid").getChild("longitude").getContent());
		    myMotion = new Motion(p.width/2,p.height/2);
		    myMotion.setDamping(0.01f);
//		   System.out.println("RawData: "+name +" "+"lat:"+lat+" lon:" + lng);
		    PlaceMarker placeMarker = new PlaceMarker(p,name, lat, lng, myMotion,particle);
//		    System.out.println("PlacemakerData: "+placeMarker);
		    placeList.add(placeMarker);
//		    println(i + ": " + placeMarker);  
			 }
			}
	}
	
	public void drawPlaces(){
//		System.out.println("Begin Iteration thru Arraylist<PlaceMarker>");
		for(int i = 0; i<placeList.size();i++){
//			System.out.println("Call Method display() from Class PlaceMarker");
			(placeList.get(i)).display();
			}
	}
}
