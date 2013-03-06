package controllers;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

import models.Airport;
import models.AirportStatus;
import models.AirportStatusArray;
import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

import org.codehaus.jackson.map.ObjectMapper;

import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;



public class Airports extends Controller {
	
	final static Form<Airport> airportForm = form(Airport.class);

	public static Result show(){
		
		List<Airport>airports = getAirports();
		return ok(views.html.airport.airport.render(airports));
	}
	public static List<Airport> getAirports(){ 
		BufferedReader reader = null;
		CacheManager mgr = null;
		try{
			mgr = CacheManager.getCacheManager("TestCache");
			System.out.println("Got the Mgr");
		}catch(Exception e){
			//if instance isn't there get the initial value
			mgr = new CacheManager("/Users/glennrenfro/Documents/workspace-sts-2.9.2.RELEASE/SIEhCacheTestApp/configs/ehcache-dist.xml" );
			System.out.println("Created the mgr");
		}
		if(mgr==null){
			mgr = new CacheManager("/Users/glennrenfro/Documents/workspace-sts-2.9.2.RELEASE/SIEhCacheTestApp/configs/ehcache-dist.xml" );
		}
		Cache c = mgr.getCache("airports_cache");


		List<String> airports = c.getKeys();
		List<Airport>result = new ArrayList<Airport>();
		try{
		Iterator<String>iter = airports.iterator();
		while(iter.hasNext()){
			String val = iter.next();//reader.readLine();
			System.out.println(val);
			StringTokenizer tok = new StringTokenizer(val, ",");
			tok.nextToken();//skip rank
			Airport airport = new Airport();
			airport.code = tok.nextToken().substring(1);//get AirportCode
			airport.name = tok.nextToken();
			airport.city = tok.nextToken();
			airport.state = tok.nextToken();
			airport.delay = getDelayStatus(mgr,airport.code);
			airport.status = getStatus(mgr,airport.code);
			if(airport.status == null){
				airport.status = "Not Available";
			}

			System.out.println("*******************************************"+airport.delay+"*****");
			if(tok.hasMoreTokens()){
				airport.latitude=Float.valueOf(tok.nextToken()).floatValue();
				airport.longitude=Float.valueOf(tok.nextToken()).floatValue();
				result.add(airport);
			}
			
		}
		}catch(Exception ex){
			System.out.println("OOPS");
			ex.printStackTrace();
		}finally{
			try{
			if (reader!=null){
				reader.close();
			}
			}
			catch(Exception e){
				
			}
		}
		return result;
	}
	public static String getStatus(CacheManager mgr,String airportCode){
		ObjectMapper mapper = new ObjectMapper();

		String result = null;
		Cache statusCache = mgr.getCache("mycache");
		Element element = statusCache.get(airportCode);
		AirportStatus status ;
		if(element!=null){
			result = (String)element.getValue();
			try{
				status = mapper.readValue(result, AirportStatus.class);
				System.out.println(status);
				result = status.toString();
			}catch(Exception ex){
				try{
					AirportStatusArray statusArray = mapper.readValue(result, AirportStatusArray.class);
					System.out.println(statusArray); 
					result = statusArray.toString();
				}catch(Exception ex2){
					
				}
			}
		}
		return result;
	}
	public static String getDelayStatus(CacheManager mgr,String airportCode){
		ObjectMapper mapper = new ObjectMapper();

		String result = null;
		Cache statusCache = mgr.getCache("mycache");
		Element element = statusCache.get(airportCode);
		AirportStatus status ;
		if(element!=null){
			result = (String)element.getValue();
			try{
				status = mapper.readValue(result, AirportStatus.class);
				System.out.println(status.delay);
				result = status.delay;
			}catch(Exception ex){
				try{
					AirportStatusArray statusArray = mapper.readValue(result, AirportStatusArray.class);
					System.out.println(statusArray.delay); 
					result = statusArray.delay;
				}catch(Exception ex2){
					
				}
			}
		}
		return result;
	}
}
