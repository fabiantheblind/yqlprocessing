package util;

import processing.core.PApplet;
import processing.core.PFont;


public class Style {

	public static PApplet p;
	
	public static PFont font10;
	public static PFont font11;
	
	
	public static void setPApplet(PApplet _p){
		p = _p;
	 }
	
	public static void create(){
		
		font10 = p.createFont("./data/GenBasR.ttf", 10f);
		font11 = p.createFont("./data/GenBasR.ttf", 11f);		
		
		
	}
}
