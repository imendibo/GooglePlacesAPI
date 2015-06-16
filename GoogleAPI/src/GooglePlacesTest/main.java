package GooglePlacesTest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;






import com.bittenpotato.patatabrava.gplacesAPI.places.GooglePlaces;
import com.bittenpotato.patatabrava.gplacesAPI.places.Param;
import com.bittenpotato.patatabrava.gplacesAPI.places.Place;
import com.inspirience.restapi.HttpUtils;
import com.inspirience.restapi.RequestMethod;
import com.inspirience.restapi.RestClient;

public class main {
	GooglePlaces client;
	String apiKey;
	public static void main(String[] args) {
		new main();
	}
	public main(){
		double latitude = 41.409785;
		double longitude = 2.157978;
		int radius = 100;
//		apiKey = "AIzaSyCKkCUQpj5FjHlnNk11xO1fb7B3dE2EEZE";
		apiKey = "AIzaSyAtlHoRyWHiGglsyUBM5Ww7VKonCPcZjXI";
		
		client = new GooglePlaces(apiKey);
		
//		List<Place> places = client.getNearbyPlaces(latitude, longitude, radius, GooglePlaces.MAXIMUM_RESULTS);
//		List<Place> places = client.getPlacesByRadar(latitude, longitude, radius, GooglePlaces.MAXIMUM_RESULTS);
//		List<Place> places = client.getNearbyPlacesRankedByDistance(latitude, longitude, 10);
//		List<Place> places = client.getNearbyPlacesRankedByDistance(latitude, longitude, 5);
//		
		Param[] params = new Param[1];
		
//		params[0] = new Param("location");
//		params[0].value("41.409785,2.157978");
//		params[1] = new Param("types");
//		params[1].value("food|cafe");
//		params[2] = new Param("rankby");
//		params[2].value("distance");
//		params[0] = new Param("type");
//		params[0].value("food");
//		params[1] = new Param("rankby");
//		params[1].value("distance");
//		
//		List<Place> places = client.getNearbyPlaces(latitude, longitude, radius, GooglePlaces.MAXIMUM_RESULTS, params);
//		List<Place> places = client.getPlacesByRadar(latitude, longitude, GooglePlaces.MAXIMUM_RESULTS, params);
		
		String type = "food";
		String rank = "distance";
		List<Place> places = client.getCustomPlaces(latitude, longitude, type, rank, GooglePlaces.MAXIMUM_RESULTS);

		
//		
//		getPLaceByQuery();
		
		printPlaces(places);
		
		
	}
	
	
	private void printPlaces(List<Place> places) {
		for (Place place : places) {
		    Place detailedplace = place.getDetails(); // sends a GET request for more details

		    System.out.println("Name: " + detailedplace.getName());
		    System.out.println("Phone: " + detailedplace.getPhoneNumber());
		    System.out.println("International Phone: " + detailedplace.getInternationalPhoneNumber());
		    System.out.println("Website: " + detailedplace.getWebsite());
		    System.out.println("Always Opened: " + detailedplace.isAlwaysOpened());
		    System.out.println("Status: " + detailedplace.getStatus());
		    System.out.println("Google Place URL: " + detailedplace.getGoogleUrl());
		    System.out.println("Price: " + detailedplace.getPrice());
		    System.out.println("Address: " + detailedplace.getAddress());
		    System.out.println("Vicinity: " + detailedplace.getVicinity());
		    System.out.println("Reviews: " + detailedplace.getReviews().size());
		    System.out.println("Hours:\n " + detailedplace.getHours());
		}
		
	}
	private void getPLaceByQuery() {
		
        RestClient restClient = new RestClient("https://maps.googleapis.com/maps/api/place/nearbysearch/output");
        restClient.addParam("location","41.409785,2.157978");
        restClient.addParam("radius","100");
        restClient.addParam("types","food");
        restClient.addParam("rankby","distance");
        restClient.addParam("key", "AIzaSyBL1aZQC6yDiWaMp_HF0Vagc8IluLGKbyU");
        
        
        	
        try {
        	restClient.execute(RequestMethod.GET);
			HttpUtils.checkResponseCode(restClient);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
        System.out.println(restClient.getResponse());
        Place place = Place.parseDetails(client, restClient.getResponse());
        
        System.out.println(place.getName());
//        List<Place> places = JSONplacesParser.parseNearbyVenuesSearch(restClient.getResponse());
			
	}
}
