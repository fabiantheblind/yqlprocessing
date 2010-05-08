package util;

import java.io.UnsupportedEncodingException;

import processing.core.PApplet;
import processing.xml.XMLElement;

public class Querys {

	public Querys(PApplet CP) {
		// TODO Auto-generated constructor stub
		p = CP;
	}
	private String myQuery;
	private String yqlApiUrl = "http://query.yahooapis.com/v1/public/yql";
	private XMLElement xmlResponse;
	private HTMLEncoding coder = new HTMLEncoding();
	public PApplet p;


	
	@SuppressWarnings("static-access")
	public XMLElement getResponseFromTable(String yqlStatement){
		
		try {
			myQuery = yqlApiUrl + "?q=" + coder.encode(yqlStatement) + "&amp;format=xml";
			p.println("ENcoding Query RSS");
			} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			p.println("Sorry an error ocurred during encoding the string");
			}
		
		return xmlResponse = new XMLElement(p, myQuery);
	}

}
