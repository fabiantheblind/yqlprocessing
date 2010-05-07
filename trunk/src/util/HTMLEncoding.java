package util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class HTMLEncoding {

	public String encode (String myStringToEncode) throws UnsupportedEncodingException{
		myStringToEncode = URLEncoder.encode(myStringToEncode, "UTF-8");
		String myReplace = myStringToEncode.replaceAll("'", "%22").replaceAll("=", "%3D");

		String myResult = myReplace;
		return myResult;
		
	}
	
	public String decode (String myStringToDecode) throws UnsupportedEncodingException{
//		String myReplace = myStringToDecode.replaceAll("%3D", "=").replaceAll("%22", "'");
		myStringToDecode = URLDecoder.decode(myStringToDecode, "UTF-8");

		String myResult = myStringToDecode;
		return myResult;
		
	}
}
