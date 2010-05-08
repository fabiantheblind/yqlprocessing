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
import java.util.ArrayList;

import geo.PlacemarkerManager;
import processing.core.PApplet;
import processing.core.PImage;
import processing.xml.XMLElement;
import util.*;
import visual.Particle;
import visual.Style;



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
	public PImage worldMap;
	public Querys rssQuery = new Querys(this);
	public Querys placemakerQuery = new Querys(this);
	
//	This is for the Particles
	public float force=100; //attraction/repulsion force
	public Particle[] particles;

	public int selectedindex=-1;

	public void setup() {
		Particle.initParticles();
		Style.setPApplet(this);
		YQLStatements.setPApplet(this);
		pmManager = new PlacemarkerManager(this);

		Style.create();
		worldMap = loadImage("./data/worldmap-equirectangular-s-sw.png");
		size(1200,600);
		
		
		xmlResponse = rssQuery.getResponseFromTable(YQLStatements.myRssQueryUncoded);
//		println("got Response from RSS");
		XMLElement[] descrXMLElements = xmlResponse.getChildren("results/item/description");
//		println("XMLElements >discription> collected from RSS");
		String myText;
//		println("look for Placemarks via placemaker");
//		xmlWriter = new XmlWriter(this);
//		xmlWriter.makeXmlFile("myPlaceMarkFile");
		for(int i =0;i<descrXMLElements.length;i++){
		    if (i%1==0){ Particle.particlesList.add(new Particle(this,random(width/10, 9*width/10), random(height/10, 9*height/10), 1, 0, 0));
		    }else {Particle.particlesList.add(new Particle(this,random(width/10, 9*width/10),random(height/10, 9*height/10),-1, 0, 0));
		    }

			myText = descrXMLElements[i].getContent();				
			xmlNextResponse = placemakerQuery.getResponseFromTable(YQLStatements.makePlacesStat(myText));	
//			println("Got Response from placemaker");
			XMLElement[] finalPlaceXMLElements = xmlNextResponse.getChildren("results/matches/match/place");
//			println("XMLElements <place> collected");
//			println(finalPlaceXMLElements);
			
			pmManager.init(finalPlaceXMLElements,Particle.particlesList.get(i));	
//			try {
//				xmlWriter.writeXml((xmlNextResponse.getChildren("results/matches/match/place"))[i]);
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//				
//			}
//			println("Got all Placemarker in Arraylist");
		 }
		
		
//		 particles = new Particle[numparticles];
//		  for(int i=0; i<numparticles; i++)
//		  {
//		    if (i%2==0) particles[i] = new Particle(this,random(width/10, 9*width/10), random(height/10, 9*height/10), 1, 0, 0);
//		    else particles[i]= new Particle(this,random(width/10, 9*width/10),random(height/10, 9*height/10),-1, 0, 0);
//		 println("first for() loop in setup()");
//		  }
		  
		  for(int i=0; i<Particle.numparticles; i++)
		  {
		    if (i%2==0) Particle.particlesList.add(new Particle(this,random(width/10, 9*width/10), random(height/10, 9*height/10), 1, 0, 0));
		    else Particle.particlesList.add(new Particle(this,random(width/10, 9*width/10),random(height/10, 9*height/10),-1, 0, 0));
		 println("first for() loop in setup()");
		  }
	}

	public void draw () {
	Style.createMovement();
	background(0);
		smooth();
//		image(worldMap, 0, 0, worldMap.width, worldMap.height);
		pmManager.drawPlaces();
		visualParticle();
		fill(0,200);
//		  for(int i=0; i<Particle.numparticles; i++)
//		  {
//		   
//		    float xaccel=0, yaccel=0;
//		    for(int j=0; j<Particle.numparticles; j++)
//		    {
//		      float ijdist = dist(Particle.particlesList.get(i).xpos, Particle.particlesList.get(i).ypos, Particle.particlesList.get(j).xpos, Particle.particlesList.get(j).ypos);
//		      float theta = atan2(Particle.particlesList.get(i).ypos-Particle.particlesList.get(j).ypos, Particle.particlesList.get(i).xpos-Particle.particlesList.get(j).xpos);
//		        
//		       
//		        
//		        if(ijdist>20) //attractive or repulsive forces depending on charges
//		        {
//		          xaccel+=  Particle.particlesList.get(i).charge * Particle.particlesList.get(j).charge * (force/(ijdist*ijdist)) * cos(theta); 
//		          yaccel+=  Particle.particlesList.get(i).charge * Particle.particlesList.get(j).charge * (force/(ijdist*ijdist)) * sin(theta); 
//		        }
//		        
//		        else if(ijdist>0.1f) 
//		        {
//		          xaccel+=  (force/(pow(ijdist,4))) * cos(theta); 
//		          yaccel+=  (force/(pow(ijdist,4))) * sin(theta); 
//		        } 
//		        
//		        
//		        Particle.particlesList.get(i).xspeed+=xaccel;
//		        Particle.particlesList.get(i).yspeed+=yaccel;
//		   }
//		   if(Particle.particlesList.get(i).affected)
//		   {
//			   Particle.particlesList.get(i).move();
//		   }
//		   Particle.particlesList.get(i).render();
//		  }
		  
//		rect(0,0,width,height);
	
	}
	
	public void visualParticle(){
		  for(int i=0; i<Particle.numparticles; i++)
		  {
		   
		    float xaccel=0, yaccel=0;
		    for(int j=0; j<Particle.numparticles; j++)
		    {
		      float ijdist = dist(Particle.particlesList.get(i).xpos, Particle.particlesList.get(i).ypos, Particle.particlesList.get(j).xpos, Particle.particlesList.get(j).ypos);
		      float theta = atan2(Particle.particlesList.get(i).ypos-Particle.particlesList.get(j).ypos, Particle.particlesList.get(i).xpos-Particle.particlesList.get(j).xpos);
		        
		       
		        
		        if(ijdist>20) //attractive or repulsive forces depending on charges
		        {
		          xaccel+=  Particle.particlesList.get(i).charge * Particle.particlesList.get(j).charge * (force/(ijdist*ijdist)) * cos(theta); 
		          yaccel+=  Particle.particlesList.get(i).charge * Particle.particlesList.get(j).charge * (force/(ijdist*ijdist)) * sin(theta); 
		        }
		        
		        else if(ijdist>0.1f) 
		        {
		          xaccel+=  (force/(pow(ijdist,4))) * cos(theta); 
		          yaccel+=  (force/(pow(ijdist,4))) * sin(theta); 
		        } 
		        
		        
		        Particle.particlesList.get(i).xspeed+=xaccel;
		        Particle.particlesList.get(i).yspeed+=yaccel;
		   }
		   if(Particle.particlesList.get(i).affected)
		   {
			   Particle.particlesList.get(i).move();
		   }
		   Particle.particlesList.get(i).render();
		  }
		
	}
	public void mousePressed()
	{
	   for(int i=0; i<Particle.numparticles; i++)
	   {
	     if (dist(mouseX, mouseY, Particle.particlesList.get(i).xpos, Particle.particlesList.get(i).ypos)<8)
	     {
	       selectedindex=i;
	       Particle.particlesList.get(selectedindex).affected=false;
	       break;
	     }
	   }
	   
	   if (selectedindex==-1)
	   {
	     float randno= (int)random(0, 2);
	     if (randno==0) 
	     {
	    	 Particle.particlesList.add(new Particle(this, mouseX, mouseY, 1, 0, 0));
//	       particles = (Particle[])append(particles, new Particle(this, mouseX, mouseY, 1, 0, 0)) ;
	     }else{ 
	    	 Particle.particlesList.add(new Particle(this, mouseX, mouseY, -1, 0, 0));
//	    	particles= (Particle[])append(particles, new Particle( this,mouseX, mouseY, -1, 0, 0));
	     }
	     Particle.numparticles++;
	   } 
	   
	}

	public void mouseDragged()
	{
	   if(selectedindex!=-1)
	   {
		
		   Particle.particlesList.get(selectedindex) .xpos=mouseX;
		   Particle.particlesList.get(selectedindex) .ypos=mouseY;
	   }  
	}

	public void mouseReleased()
	{
	  if(selectedindex!=-1)
	  {
		  
		   Particle.particlesList.get(selectedindex).xspeed = mouseX-pmouseX;
		   Particle.particlesList.get(selectedindex).yspeed = mouseY-pmouseY;
		   Particle.particlesList.get(selectedindex).affected=true;
	  }
	    selectedindex=-1;
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
