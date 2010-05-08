/*
 * @author fabiantheblind http://www.the-moron.net
 * written for FHP SS2010 Urbane Ebenen by Till Nagel
 * for URLDe/Encode see http://mindprod.com/jgloss/urlencoded.html
 * for yql see: http://developer.yahoo.com/yql/
 * for yql querybuilder see : http://www.sergimansilla.com/blog/yql-mashup-with-gwt/
 * for combining see: http://btk.tillnagel.com/tutorials/geo-tagging-placemaker.html
 * 
 */

package main;
import geo.PlacemarkerManager;
import processing.core.PApplet;
import processing.core.PImage;
import processing.xml.XMLElement;
import util.HTMLEncoding;
import util.Querys;
import util.Style;
import util.XmlWriter;
import util.YQLStatements;



public class Main extends PApplet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1643689331016244574L;
	

	public XMLElement xmlResponse;
	public XMLElement xmlNextResponse;

	public PlacemarkerManager pmManager;
	public HTMLEncoding coder = new HTMLEncoding();
	public XmlWriter xmlWriter;
	PImage worldMap;
	public Querys rssQuery = new Querys(this);
	public Querys placemakerQuery = new Querys(this);

	public void setup() {
		pmManager = new PlacemarkerManager(this);
		Style.setPApplet(this);
		YQLStatements.setPApplet(this);
		Style.create();
		worldMap = loadImage("./data/worldmap-equirectangular-s-sw.png");
		size(1200,600);
		
		
		xmlResponse = rssQuery.getResponseFromTable(YQLStatements.myRssQueryUncoded);
		println("got Response from RSS");
		XMLElement[] descrXMLElements = xmlResponse.getChildren("results/item/description");
		println("XMLElements >discription> collected from RSS");
		String myPlaceKey;
		println("look for Placemarks via placemaker");
		
		for(int i =0;i<descrXMLElements.length;i++){
//			xmlWriter.makeXmlFile("myPlaceMarkFile"+i);
			myPlaceKey = descrXMLElements[i].getContent();				
			xmlNextResponse = placemakerQuery.getResponseFromTable(YQLStatements.makePlacesStat(myPlaceKey));	
			println("Got Response from placemaker");
			XMLElement[] finalPlaceXMLElements = xmlNextResponse.getChildren("results/matches/match/place");
			println("XMLElements <place> collected");
			pmManager.init(finalPlaceXMLElements);	
//			xmlWriter.writeXml(xmlNextResponse);
			println("Got all Placemarker in Arraylist");
		 }
	}

	public void draw () {
	
		smooth();
		image(worldMap, 0, 0, worldMap.width, worldMap.height);
		pmManager.drawPlaces();
	
	}
	
	public void keyReleased(){
		
		if (key == 's' || key == 'S') {
			saveFrame("./data/MyImg.jpg");
			
		}	
		if (key == 'e' || key == 'E') {
		exit();			
		}	
		
	}
	
	public static void main(String _args[]) {
		PApplet.main(new String[] { main.Main.class.getName() });
	}
}
