package model;

import java.util.Date;

public class Util {

	public static String addQuotes(String text){
		if(text == null)
			return "null";
		else
			return "\"" + text + "\"";
	} 
	
	public static String addQuotes(Date date){
		if(date == null)
			return "null";
		else
			return "\"" + date.toString() + "\"";
	} 
	
	public static String addQuotes(int value){
		return "" + value;
	}

	public static boolean isEmptyOrNull(String text){
		return text == null || text.isEmpty();
	}
}
