package JavaProject;

import com.teamdev.jxbrowser.chromium.*;
import com.teamdev.jxbrowser.chromium.swing.*;

import javax.swing.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
 
public final class GoogleMap {
	public void initMap(ArrayList<String> array) throws InterruptedException	{
       final Browser browser = new Browser(BrowserContext.defaultContext());
       BrowserView browserView = new BrowserView(browser);
 
       JFrame frame = new JFrame("file.html");
       frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
       frame.add(browserView, BorderLayout.CENTER);
       frame.setSize(900, 500);
       frame.setLocationRelativeTo(null);
       frame.setVisible(true);
       String mapKey = "AIzaSyBgCp6i8HrezFB6e-u9y-KSoeSKOK4IhzE";
       //String geoCodeAPI = "AIzaSyC4QTwPmYrSISdVjJXw6YXUaWJVp-G6fFw";
       //browser.loadURL("file:///F:/Faisal/Languages/Projects/KludgeTech/Meeto/JavaProject/src/JavaProject/map.html");
       // browser.loadURL("https://maps.googleapis.com/maps/api/geocode/json?address=" + array.get(i) + "&key=" + geoCodeAPI);
       int i;
       String area = "var area = [";
       for(i = 0; i < array.size(); i ++)
       {
    	   if(array.size() == 0)
    		   area += "'" + array.get(i) + "'";
    	   else if(i != array.size())
    		   area += "'" + array.get(i) + "', ";
    	   else 
    		   area += "'" + array.get(i) + "'";
       }
       area += "]";
       browser.loadHTML("<html>\n"
   			+ "	<head>\n"
   			+ "		<meta name=\"viewport\" content=\"initial-scale=1.0, user-scalable=no\"/>\n"
   			+ "		<style type=\"text/css\">\n"
   			+ "			html { height: 100% }\n"
   			+ "			body { height: 100%; margin: 0; padding: 0 }\n"
   			+ "			#map-canvas { height: 100% }\n"
   			+ "		</style>\n"
   			+ "		<script type=\"text/javascript\"\n"
   			+ "			src = \"https://maps.googleapis.com/maps/api/js?key=AIzaSyBgCp6i8HrezFB6e-u9y-KSoeSKOK4IhzE\">\n"
            + "		</script>\n"
            /*+ "   <script type=\"text/javascript\">\n"
            + "     var map;\n"
            + "     function initialize() {\n"
            + "       var mapOptions = {\n"
            + "         center: new google.maps.LatLng(48.209331, 16.381302),\n"
            + "         zoom: 4\n"
            + "       };\n"
            + "      var marker, i;\n"
            + "      for (i = 0; i < area.length ; i++) {\n" 
            + "         marker = new google.maps.Marker({\n"
            + "         position: new  google.maps.LatLng(area,\n"
            + "         map: map\n"
            + "       });\n"
            + "     var marker = new google.maps.Marker({\n"
            + "    position:  new google.maps.LatLng(48.209331, 16.381302),\n"
            + "    map: map,\n"
            + "    title: 'Hello World!'\n"
            + "});"
            + "     }\n"
            + "     google.maps.event.addDomListener(window, 'load', initialize);\n"
            + "\n"
            + "   </script>\n"*/
        	+ "	</head>\n"
   			+ "	<body>\n"
   			+ "		<div id=\"map-canvas\"></div>\n"
   			+ "	</body>\n"
   			+ "</html>");
       while (browser.isLoading()) {
           TimeUnit.MILLISECONDS.wait(50);
       }
	}
	
	/*public void geocodeMap(ArrayList<String> array) throws InterruptedException	{
	       final Browser browser = new Browser(BrowserContext.defaultContext());
	       BrowserView browserView = new BrowserView(browser);
	 
	       JFrame frame = new JFrame("file.html");
	       frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	       frame.add(browserView, BorderLayout.CENTER);
	       frame.setSize(900, 500);
	       frame.setLocationRelativeTo(null);
	       frame.setVisible(true);
	       //String mapKey = "AIzaSyBgCp6i8HrezFB6e-u9y-KSoeSKOK4IhzE";
	       String geoCodeAPI = "AIzaSyC4QTwPmYrSISdVjJXw6YXUaWJVp-G6fFw";
	       for(i = 0; i < array.size(); i++)	{
	    	  // browser.loadURL("https://maps.googleapis.com/maps/api/geocode/json?address=" + array.get(i) + "&key=" + geoCodeAPI);
	    	   JSValue lat = browser.executeJavaScriptAndReturnValue("$.getJSON(\"https://maps.googleapis.com/maps/api/geocode/json?address=\" + array.get(i) + \"&key=\" + geoCodeAPI");
	    	   System.out.println(lat);
	       }
	       browser.loadURL("file:///F:/Faisal/Languages/Projects/KludgeTech/Meeto/JavaProject/src/JavaProject/map.html");
	       browser.loadHTML("<html>\n"
	   			+ "	<head>\n"
	   			+ "		<script src=\"jquery.js\"></script>\n"
	   			+ "		<script type=\"text/javascript\">\n"
	   			+ " 		$.getJSON(\"https://maps.googleapis.com/maps/api/geocode/json?address=\" + array.get(i) + \"&key=\" + geoCodeAPI + \"/\", function(element){\n"	
	   			+ " 			var lat = element.results[0].location.lat;\n"	
	   			+ "		    	document.getElementById(\"map-canvas\").innerHTML = lat;\n"
	   			+ " 		});\n"
	   			+ "		</script>\n"
	        	+ "	</head>\n"
	   			+ "	<body>\n"
	   			+ "		<div id=\"map-canvas\"></div>\n"
	   			+ "	</body>\n"
	   			+ "</html>");
	       while (browser.isLoading()) {
	           TimeUnit.MILLISECONDS.wait(50);
	       }
		}*/
}