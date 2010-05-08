/**
 * 
 */
package util;

import processing.core.PApplet;

/**
 * @author fabianmoronzirfas
 *
 */
public class YQLStatements {
	public static PApplet p;
	
	public static String myRssQueryUncoded = "select * from rss where url='http://earthobservatory.nasa.gov/Feeds/rss/eo2.rss'";
	public static String keyword = "Mouse";
	public static String myFlickrQueryUncoded = "select * from flickr.photos.search where text = '" + keyword + "' limit 9";
	public static String myUnderTheRadarMediaUncoded ="select * from rss where url='http://feeds.delicious.com/v2/rss/maasanova'";
	public static String yqlStatement;

	public static void setPApplet(PApplet _p){
		p = _p;
	 }
	
	public static String makePlacesStat(String incomingTXT){
		
		yqlStatement="SELECT * FROM geo.placemaker WHERE documentContent = \""
			+incomingTXT
			+"\" AND documentType=\"text/plain\"";
		
		return yqlStatement;
	}
		
	
}
