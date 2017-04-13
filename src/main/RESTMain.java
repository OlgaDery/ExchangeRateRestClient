/**
 * 
 */
package main;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.StatusType;

/**
 * @author Olga
 * calls the Rest web service at the url defined below
 */
public class RESTMain {

	/**
	 * calls the web service and displays the response
	 */
	
	public static final String REST_URL = "https://currency-api.appspot.com/api/USD/EUR.json";
	public static final int OK_STATUS = Response.Status.OK.getStatusCode();
	
	public static void main(String[] args) 
	{
		// calls the service and receives the response object
		Response response = ClientBuilder.newClient()
				.target(REST_URL)
				.request(MediaType.APPLICATION_JSON)
				.get();
		
		//process the response obj
		StatusType status = response.getStatusInfo();
		int statusCode = status.getStatusCode();
		
		if (statusCode == OK_STATUS) 
		{
			System.out.println(response.readEntity(String.class));
		} else {
			System.out.printf("Service returned status: \"%d %s\"\n", statusCode, status.getReasonPhrase());
		}
	}

}
