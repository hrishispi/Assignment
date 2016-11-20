package pack1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;

public class ExecuteTask {
	private static Queue<Server> serverQueue;
	private static int serverCount = 5;
	private static int maxTasks =5;
	
	public static void main(String[] args) throws NumberFormatException, IOException, InterruptedException {
		System.out.println("Enter max number of tasks per server ...");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		maxTasks=Integer.parseInt(br.readLine());
		System.out.println("Enter server count");
		serverCount=Integer.parseInt(br.readLine());
		startServers();
		System.out.println("Enter tasks to run on this setup ...");
		new ExecuteTask().run(Integer.parseInt(br.readLine()));
		System.out.println("Everything is now executed ... Lets see the stats");
		for (Server server : serverQueue) {
			System.out.println(server.identifier+" executed "+server.getTotalTasks()+" tasks");
		}
	}

	private void run(int taskCount) throws InterruptedException {
		for (int i = 0; i < taskCount; i++) {
			Tasks task = new Tasks();
			task.identifier= "transaction "+(i+1);
			runTasks(task);	
		}

		
	}

	private void runTasks(Tasks task) throws InterruptedException {
		Server server = serverQueue.poll();
		if(server.getRunningTasks()>maxTasks){
			serverQueue.offer(server);
			System.out.println("waiting on servers ... ");
			Thread.sleep(200);
			runTasks(task);
		}else{
			System.out.println("Running "+task.identifier+" on server"+server.identifier);
			Thread t = new Thread(server);
			t.start();
			serverQueue.offer(server);
		}
		
		
		
	}

	private static void startServers() {
		serverQueue = new PriorityQueue<Server>();
		for (int i = 0; i < serverCount; i++) {
			Server server = new Server();
			server.identifier="washington "+(i+1);
			System.out.println("Server created "+server.identifier);
			serverQueue.offer(server);
		}
		
		
		
	}
}
