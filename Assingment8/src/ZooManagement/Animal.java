package ZooManagement;

/**
 * Class for creating and maintaining Animal structure
 * @author krishna.meghwal_meta
 * @since 24-02-2021*/
public abstract class Animal {
	String animalName;
	String animalType;
	int animalId;
	int animalHeight;
	int animalWeight;
	
	Animal(String name, String type, int weight,int height){
		animalName = name;
		animalHeight = height;
		animalWeight = weight;
		animalType = type;
		animalId= (int) (Math.random()* 1000);
	}
	
	/**Abstract method for getting sound of an animal
	 *@return String */
	abstract public String getSound();
	
	

}
