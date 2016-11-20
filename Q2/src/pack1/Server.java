package pack1;

public class Server implements Comparable<Server>,Runnable {
	
	private int runningTasks;
	public int getRunningTasks() {
		return runningTasks;
	}

	public void setRunningTasks(int runningTasks) {
		this.runningTasks = runningTasks;
	}
	
	private int totalTasks;

	public int getTotalTasks() {
		return totalTasks;
	}

	public void setTotalTasks(int totalTasks) {
		this.totalTasks = totalTasks;
	}

	public String identifier;

	@Override
	public void run() {
		totalTasks=totalTasks+1;
		try {
			runningTasks=runningTasks+1;
			// This is where the process starts
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		runningTasks=runningTasks-1;
		
	}

	// Get the server with least running tasks
	@Override
	public int compareTo(Server o) {
		return this.getRunningTasks()-o.getRunningTasks();
	}

}
