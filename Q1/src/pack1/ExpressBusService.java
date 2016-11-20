package pack1;

public class ExpressBusService {
	public float calculateTime(float currentTime) {
		if((currentTime>=0545 && currentTime<=1000)||(currentTime>=1450 && currentTime<=1900)){
			return peakTimeCalculate(currentTime);
		}else{
			return nonPeakTimeCalculate(currentTime);
		}
	}

	private float nonPeakTimeCalculate(float currentTime) {
		return 1000;
	}

	private float peakTimeCalculate(float currentTime) {
		return TransportService.timeForFifteenthMinute(currentTime,15f)+15f;
	}
}
