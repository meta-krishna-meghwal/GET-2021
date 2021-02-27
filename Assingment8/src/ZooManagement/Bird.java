package ZooManagement;

/**
 * Class for creating and maintaining bird structure extends Animal
 * @author krishna.meghwal_meta
 * @since 24-02-2021*/
public abstract class Bird extends Animal{
	String type = "Bird";
	Bird(String name, String type, int weight, int height) {
		super(name, type, weight, height);
	}
	
}
