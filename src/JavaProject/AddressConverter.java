package JavaProject;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.codehaus.jackson.map.ObjectMapper;


public class AddressConverter {
	private static final String URL = "https://maps.googleapis.com/maps/api/geocode/json";
 /*
  * Here the fullAddress String is in format like
  * "address,city,state,zipcode". Here address means "street number + route"
  * .
  */
	public GoogleReturn convertToLatLong(String fullAddress) throws IOException {
		URL url = new URL(URL + "?address="
				+ URLEncoder.encode(fullAddress, "UTF-8") + "&key=AIzaSyC4QTwPmYrSISdVjJXw6YXUaWJVp-G6fFw");
		URLConnection conn = url.openConnection();

		InputStream in = conn.getInputStream() ;
		ObjectMapper mapper = new ObjectMapper();
		GoogleReturn response = (GoogleReturn)mapper.readValue(in,GoogleReturn.class);
		in.close();
		return response;
	}
 
	public GoogleReturn convertFromLatLong(String latlongString) throws IOException {
		URL url = new URL(URL + "?latlng="
				+ URLEncoder.encode(latlongString, "UTF-8") + "&key=AIzaSyC4QTwPmYrSISdVjJXw6YXUaWJVp-G6fFw");
		URLConnection conn = url.openConnection();
	
		InputStream in = conn.getInputStream() ;
		ObjectMapper mapper = new ObjectMapper();
		GoogleReturn response = (GoogleReturn)mapper.readValue(in,GoogleReturn.class);
		in.close();
		return response;
	 }
	
	 @SuppressWarnings("rawtypes")
	 public void fetchLatLong(String string) throws IOException {
		 //ArrayList latlong[];
		 int i;
		 /*for(i = 0; i < Array.getLength(string); i++)
		 {*/
			 GoogleReturn res = new AddressConverter().convertToLatLong(string);
			 if(res.getStatus().equals("OK"))
			 {
				 for(Result result : res.getResults())
				 {
					 String lat = result.getGeometry().getLocation().getLat();
					 System.out.println(lat);
					 String lng = result.getGeometry().getLocation().getLng();
					 System.out.println(lng);
				 }
			 }
			 else
			 {
				 System.out.println(res.getStatus());
			 }
		 //}
	 }
}