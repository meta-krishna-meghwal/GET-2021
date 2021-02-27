package ZooManagement;

/**
 * Class for creating and maintaining peacock structure extends Bird
 * @author krishna.meghwal_meta
 * @since 24-02-2021*/
public class Peacock extends Bird{
	
	public String getSound(){
		return "meoo";
	}
	Peacock(String name, String type, int weight, int height) {
		super(name, type, weight, height);
		
	}

}
