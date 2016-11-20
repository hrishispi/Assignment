package pack1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Implementation {
	public static void main(String[] args) throws NumberFormatException, IOException {
		new Implementation().run();
	}
	
	public void run() throws NumberFormatException, IOException {
		System.out.println("Enter time of Day");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		float currentTime = Float.parseFloat(br.readLine());
		calculateFastestRoute(currentTime);
		
	}

	private void calculateFastestRoute(float currentTime) {
		Map<Float, String> routeMap = processAvailableRoutes(currentTime);
		float fastestTime=0;
		String fastestRoute = "";
		List<Float> timeList = new ArrayList<Float>();
		timeList.addAll(routeMap.keySet());
		Collections.sort(timeList);
		fastestTime=timeList.get(0);
		fastestRoute=routeMap.get(fastestTime);
		System.out.println("Fastest Time "+fastestTime+" mins"+" using "+fastestRoute);
		if(fastestRoute.equals(TransportService.BUS_METRO_CONNECTION)){
			Recovery recovery = new BusMetroConnection().recoverMissedConnection(currentTime);
			System.out.println(recovery.getMessage()+" Time required for missed connection is " +recovery.getTime());
		}
	}

	private Map<Float, String> processAvailableRoutes(float currentTime) {
		Map<Float, String> routeMap = new HashMap<Float, String>();
		routeMap.put(new BusMetroConnection().calculateTime(currentTime), TransportService.BUS_METRO_CONNECTION);
		routeMap.put(new CabService().calculateTime(currentTime), TransportService.CAB_SERVICE);
		routeMap.put(new ExpressBusService().calculateTime(currentTime), TransportService.EXPRESS_BUS);
		routeMap.put(new ShuttleService().calculateTime(currentTime), TransportService.SHUTTLE_SERVICE);
		return routeMap;
	}
}
