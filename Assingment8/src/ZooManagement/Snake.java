package ZooManagement;

/**
 * Class for creating and maintaining snake structure extends Reptile
 * @author krishna.meghwal_meta
 * @since 24-02-2021*/
public class Snake extends Reptile {
	
	public String getSound(){
		return "hiss";
	}
	public Snake(String name, String type, int weight, int height) {
		super(name, type, weight, height);
		
	}
	
	

}
