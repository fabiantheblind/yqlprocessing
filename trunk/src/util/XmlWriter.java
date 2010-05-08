/**
 * @author fabianmoronzirfas
 * known as fabianthelbind
 * 
 * this class doesnt work right now. Why?
 */


package util;

import java.io.PrintWriter;

import processing.xml.XMLElement;

import processing.core.PApplet;



public class XmlWriter {
	public PApplet p;
	public PrintWriter output;
	private String ENCODING = "UTF-8";
	public XmlWriter(PApplet CP){
		p= CP;
	}
	
	public void makeXmlFile(String myFileName){
		 output = p.createWriter("./data/"+myFileName+".xml");
	}
	
	

		public void writeXml(XMLElement myElement){
			
//			 Here u can write Textfiles


//			  for(int i = 0; i<1/*myElement.length*/;i++){
		
//					System.out.println(myElement);
			output.write("<?xml version=\"1.0\" encoding=\""+ENCODING+"\"?>");
			output.write(myElement.toString());
	
//						}
					output.flush();
					output.close();

			  }
		
		
}
