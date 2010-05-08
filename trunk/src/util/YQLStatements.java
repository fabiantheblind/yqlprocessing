/**
 * This Class builds basic YQL ( Yahoo! Query Language ) Statements
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
//	public static String keyword = "Mouse";
//	public static String myFlickrQueryUncoded = "select * from flickr.photos.search where text = '" + keyword + "' limit 9";
	public static String myUnderTheRadarMediaUncoded ="select * from rss where url='http://feeds.delicious.com/v2/rss/maasanova'";
	private static String yqlPlaceStatement;
	private static String yqlFlickrStatement;

	public static void setPApplet(PApplet _p){
		p = _p;
	 }
	
	public static String makePlacesStat(String incomingTXT){
		yqlPlaceStatement="SELECT * FROM geo.placemaker WHERE documentContent = \""
			+incomingTXT
			+"\" AND documentType=\"text/plain\"";
		
		return yqlPlaceStatement;
	}
	
	public static String makeFlickrStat(String keyWord, int limit){		
		yqlFlickrStatement="select * from flickr.photos.search where text = '" + keyWord + "' limit "+limit;
		
		return yqlFlickrStatement;
	}
	
}
