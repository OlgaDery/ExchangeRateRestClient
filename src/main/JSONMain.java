/**
 * 
 */
package main;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.StringReader;

import javax.json.Json;
import javax.json.stream.JsonParser;
import javax.json.stream.JsonParser.Event;

/**
 * @author Olga
 *
 */
public class JSONMain {

	/**
	 * parses the JSON coming from https://currency-api.appspot.com/api/USD/EUR.json
	 */
	public static final String FILENAME = "rate-exchange.json";
	
	public static void main(String[] args) throws FileNotFoundException 
	{
		// parse and displays the JSON file
		 
	    JsonParser parser = Json.createParser(new FileReader(FILENAME));
	    Event event = null;
	 
	    while (parser.hasNext()) {
	       event = parser.next();
	       if (event == Event.KEY_NAME && parser.getString().equalsIgnoreCase("source")) {
	          event = parser.next();
	          System.out.println("source ==> " + parser.getString());
	       } else if (event == Event.KEY_NAME && parser.getString().equalsIgnoreCase("target")) {
	          event = parser.next();
	          System.out.println("target ==> " + parser.getString());
	       } else if (event == Event.KEY_NAME && parser.getString().equalsIgnoreCase("rate")){
	    	   event = parser.next();
		       System.out.println("rate ==> " + parser.getBigDecimal());
	       } else if (event == Event.END_OBJECT) {
	          // do nothing
	       }
	    }
	    parser.close();

	}

}
