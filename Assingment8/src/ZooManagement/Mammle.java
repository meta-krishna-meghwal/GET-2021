package ZooManagement;

/**
 * Class for creating and maintaining Mammle structure extends Animal
 * @author krishna.meghwal_meta
 * @since 24-02-2021*/
public abstract class Mammle extends Animal {
	String type = "Mammal";
	public  Mammle (String name, String type, int weight, int height) {
		super(name,type,weight,height);
	}

}
