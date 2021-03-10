package priorityQueue;

public class Bowler {
	public int id,bowlsLeft;
	
	public Bowler(int id,int bowlsLeft){
		this.id = id;
		this.bowlsLeft = bowlsLeft;
	}

	@Override
	public String toString() {
		return "Bowler [id=" + id + ", bowlsLeft=" + bowlsLeft + "]";
	}

}
