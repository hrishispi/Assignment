package pack1;

public class ShuttleService implements TransportService{

	@Override
	public float calculateTime(float currentTime) {
		if((currentTime<=1430 && 1430-currentTime<15)||(currentTime<=1030 && 1030-currentTime<15)){
			return peakTimeCalculate(currentTime);
		}
		return nonPeakTimeCalculate(currentTime);
	}

	@Override
	public float nonPeakTimeCalculate(float currentTime) {
		return 1000;
	}

	@Override
	public float peakTimeCalculate(float currentTime) {
		return TransportService.timeForFifteenthMinute(currentTime,15f)+15f;
	}
	
}
