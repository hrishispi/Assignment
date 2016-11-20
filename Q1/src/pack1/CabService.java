package pack1;

public class CabService implements TransportService {
	public float calculateTime(float currentTime) {
		if((currentTime>=0600 && currentTime<=1000)||(currentTime>=1500 && currentTime<=2000)){
			return peakTimeCalculate(currentTime);
		}else{
			return nonPeakTimeCalculate(currentTime);
		}
	}

	@Override
	public float nonPeakTimeCalculate(float currentTime) {
		return 30;
	}

	@Override
	public float peakTimeCalculate(float currentTime) {
		return 60;
	}
}
