package visual;

import processing.core.PApplet;
import processing.core.PFont;


public class Style {

	public static PApplet p;
	
	public static PFont font10;
	public static PFont font11;
	public static float posModulatorX;
	public static float posModulatorY;
	public static float addToPosX;
	public static float addToPosY;
	
	public static void setPApplet(PApplet _p){
		p = _p;
	 }
	
	public static void create(){
		
		font10 = p.createFont("./data/GenBasR.ttf", 10f);
		font11 = p.createFont("./data/GenBasR.ttf", 11f);		
	

	}
	
	public static void createMovement(){
		posModulatorX = 42*p.cos(p.PI);
		posModulatorY = 42*p.cos(p.PI);
		addToPosX = p.map(posModulatorX, -42, 42, -3, 3);
		addToPosY = p.map(posModulatorY, -42, 10, -3, 3);	
	};
}
