package fcfs;

/**
 * Main Class
 * @author krishna.meghwal_meta
 * @since 19-02-2021
 */
public class Main {
	
	public static void main(String[] args){
		
		int [][] processes = {{0,5},{10,20},{21,10}};
		JobScheduler p = new JobScheduler(processes);
		
		int [] c = p.completionTime();
		
		for(int i:c){
			System.out.println(i);
		}

	}
}
