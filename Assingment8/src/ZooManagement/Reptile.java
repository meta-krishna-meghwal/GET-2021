package ZooManagement;

/**
 * Class for creating and maintaining reptile structure extends Animal
 * @author krishna.meghwal_meta
 * @since 24-02-2021*/
public abstract class Reptile extends Animal {
	String type = "Reptile";
	public  Reptile (String name, String type, int weight, int height) {
		super(name,type,weight,height);
	}

}