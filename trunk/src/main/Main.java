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


import geo.PlaceMarker;
import geo.PlacemarkerManager;
import java.io.UnsupportedEncodingException;
import processing.core.PApplet;
import processing.xml.XMLElement;
import util.HTMLEncoding;
import util.XmlWriter;

import java.util.ArrayList;


public class Main extends PApplet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1643689331016244574L;
	
	public ArrayList<PlaceMarker> placeMarkersList;
//	public ArrayList placeMarkersList = new ArrayList();
	private String keyword = "Mouse";
	public String myRssQueryUncoded = "select * from rss where url='http://www.the-moron.net/blog/?feed=rss2'";
	public  String myFlickrQueryUncoded = "select * from flickr.photos.search where text = '" + keyword + "' limit 9";
	public String myUnderTheRadarMediaUncoded ="select * from rss where url='http://feeds.delicious.com/v2/rss/maasanova'";

	public String myWholeQuery;
	public	String myNextWholeQuery;
	public String yqlApiUrl = "http://query.yahooapis.com/v1/public/yql";
	public XMLElement xmlResponse;
	public XMLElement xmlNextResponse;

	public PlacemarkerManager pmManager = new PlacemarkerManager();
	public HTMLEncoding coder = new HTMLEncoding();
	public XmlWriter xmlWriter;
	
	public void setup() {
		
		size(360,180);
		background(0);
		
		try {
		myWholeQuery = yqlApiUrl + "?q=" + coder.encode(myUnderTheRadarMediaUncoded) + "&amp;format=xml";
//		println(myWholeQuery);
		} catch (UnsupportedEncodingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		println("Sorry an error ocurred during encoding the string");
		}
		xmlResponse = new XMLElement(this, myWholeQuery);
		XMLElement[] descrXMLElements = xmlResponse.getChildren("results/item/description");
//		println(descrXMLElements);
		String	 myPlaceQueryUncoded;
		String myPlaceKey;
	
		for(int i =0;i<descrXMLElements.length;i++){
			 
//			xmlWriter.makeXmlFile("myPlaceMarkFile"+i);
			 myPlaceKey = descrXMLElements[i].getContent();	
			myPlaceQueryUncoded="SELECT * FROM geo.placemaker WHERE documentContent = \""
			+myPlaceKey
			+"\" AND documentType=\"text/plain\"";
					
			try {
			myNextWholeQuery = yqlApiUrl + "?q=" + coder.encode(myPlaceQueryUncoded) + "&amp;format=xml";
			} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			println("Sorry an error ocurred during encoding the string");
			}
			xmlNextResponse = new XMLElement(this, myNextWholeQuery);	
			XMLElement[] finalPlaceXMLElements = xmlNextResponse.getChildren("results/matches/match/place");

//			println(finalPlaceXMLElements);
//			exit();
					  for(int j =0;j<finalPlaceXMLElements.length;j++){
						  pmManager.createPlaces(finalPlaceXMLElements);
						  println(finalPlaceXMLElements);
//						  println(placeMarkersList);
//						  PlaceMarker pm = (PlaceMarker) placeMarkersList.get(j);
//						  pm.display();					
					  	}					  
//						xmlWriter.writeXml(xmlNextResponse);
//						println (xmlNextResponse);
		 }
//		translate(width/2,height/2);
	}

	public void draw () {
//		exit();	
	}
	
	public static void main(String _args[]) {
		PApplet.main(new String[] { main.Main.class.getName() });
	}
}
