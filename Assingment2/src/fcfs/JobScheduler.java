package fcfs;

/**
 * Class to implement first come first serve scheduling algorithm
 * 
 * @author krishna.meghwal_meta
 * @created-on 19-02-2021
 */
public class JobScheduler {

	public int[][] processes;
	public int length;

	public JobScheduler(int[][] processes) {
		this.processes = processes;
		this.length = processes.length;
	}

	/**
	 * Method to calculate completion time
	 * 
	 * @return int[]
	 */
	public int[] completionTime() {
		int[] completion = new int[this.length];

		int lastExecutedTime = 0;
		for (int i = 0; i < this.length; i++) {
			if (this.processes[i][0] > lastExecutedTime) {
				lastExecutedTime = this.processes[i][0];
			}

			completion[i] = this.processes[i][1] + lastExecutedTime;
			lastExecutedTime += this.processes[i][1];
		}

		return completion;
	}

	/**
	 * Method to calculate turn around time
	 * 
	 * @return int[]
	 */
	public int[] turnAroundTime() {
		int answer[] = new int[this.length];
		int lastExecutedTime = 0;
		int completionTime;

		for (int i = 0; i < this.length; i++) {
			if (this.processes[i][0] > lastExecutedTime) {
				lastExecutedTime = this.processes[i][0];

			}
			completionTime = this.processes[i][1] + lastExecutedTime;
			lastExecutedTime += this.processes[i][1];
			answer[i] = completionTime - this.processes[i][0];
		}
		return answer;

	}

	/**
	 * Method to calculate waiting time
	 * 
	 * @return int[]
	 */
	public int[] waitingTime() {
		int answer[] = new int[this.length];
		int lastExecutedTime = 0;
		int TurnAroundTime;
		int completionTime;
		for (int i = 0; i < this.length; i++) {
			if (this.processes[i][0] > lastExecutedTime) {
				lastExecutedTime = this.processes[i][0];

			}
			completionTime = this.processes[i][1] + lastExecutedTime;
			lastExecutedTime += this.processes[i][1];
			TurnAroundTime = completionTime - this.processes[i][0];
			answer[i] = TurnAroundTime - this.processes[i][1];

		}

		return answer;

	}

	/**
	 * Method to calculate average waiting time
	 * 
	 * @return int[]
	 */
	public int averageWaitingTime() {
		int avgWait;
		int totalWait = 0;
		int waitArray[] = this.waitingTime();
		for (int x : waitArray) {
			totalWait += x;
		}

		avgWait = totalWait / this.length;

		return avgWait;
	}

	/**
	 * Method to calculate maximum waiting time
	 * 
	 * @return int[]
	 */
	public int MaxWaitingTime() {
		int MaxWait = 0;
		int waitArray[] = this.waitingTime();
		for (int x : waitArray) {
			MaxWait = Math.max(MaxWait, x);
		}

		return MaxWait;

	}

}
