package pack1;

public class BusMetroConnection implements TransportService{

	@Override
	public float calculateTime(float currentTime) {
		return nonPeakTimeCalculate(currentTime);
	}

	@Override
	public float nonPeakTimeCalculate(float currentTime) {
		 return TransportService.timeForFifteenthMinute(currentTime,15f)+15+10;
	}
	
	public Recovery recoverMissedConnection(float currentTime){
		Recovery recovery = new Recovery();
		recovery.setTime(TransportService.timeForFifteenthMinute(currentTime,15f)+15+30);
		recovery.setMessage("If you missed a metro from Pentagon. Please use Cab ");
		return recovery;
	}

	@Override
	public float peakTimeCalculate(float currentTime) {
		
		return 0;
	}

}
