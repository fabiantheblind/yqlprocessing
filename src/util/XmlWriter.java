package util;

import java.io.PrintWriter;

import processing.xml.XMLElement;

import processing.core.PApplet;



public class XmlWriter {
	public PApplet p;
	public PrintWriter output;
	
	public XmlWriter(){
		
	}
	
	public void makeXmlFile(String myFileName){
		 output = p.createWriter("./data/"+myFileName+".xml");
	}
	
	

		public void writeXml(XMLElement myElement){
			
//			 Here u can write Textfiles


			  for(int i = 0; i<1/*myElement.length*/;i++){
					
						
//					System.out.println(myElement);
					output.println(myElement);
					
					
					

						}
					output.flush();
					output.close();

			  }
		
		
}
