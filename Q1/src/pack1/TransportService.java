package pack1;

public interface TransportService {

	float calculateTime(float currentTime);
	float nonPeakTimeCalculate(float currentTime);
	float peakTimeCalculate(float currentTime);
	static float timeForFifteenthMinute(float currentTime, float interval) {
		float currentMinutes =  currentTime%100;
		float timeRemaining = interval - (currentMinutes%interval);
		return timeRemaining==interval?0f:timeRemaining;
	}
	static final String BUS_METRO_CONNECTION="Bus Metro Connection";
	static final String EXPRESS_BUS="Express Bus";
	static final String SHUTTLE_SERVICE="Shuttle Service";
	static final String CAB_SERVICE="Cab Service";
}
