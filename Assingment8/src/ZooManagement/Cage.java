package ZooManagement;

import java.util.ArrayList;
import java.util.List;

/**
 * Class for creating and maintaining cage structure
 * @author krishna.meghwal_meta
 * @since 24-02-2021*/
public class Cage {
	private List<Animal> animalList = new ArrayList<Animal>(); 
	private int numberOfAnimalAdded = 0;
	private int numberOfAnimalsAllowed = 10;
	public int cageId;
	
	/**Method to check if a cage is full
	 * @return boolean */
	public Cage(){
		cageId = (int)(Math.random()*1000);
	}
	
	/**Method to remove an animal from animal list.
	 * @param Animal
	 * @return boolean
	 */
	public  boolean removeAnimal(Animal animal){
			for(int i=0; i < animalList.size(); i++){
				if(animalList.get(i).animalId == animal.animalId){
					animalList.remove(i);
					numberOfAnimalAdded--;
					numberOfAnimalsAllowed++;
					return true;
				}
			}
		return false;
	}
	
	/**Method to check if a cage is full
	 * @return boolean*/
	public boolean isCageFull() {
		if(numberOfAnimalAdded == numberOfAnimalsAllowed)
			return true;
		
		return false;
	}
	/**Method to add an animal to a cage
	 *  @param Animal */
	public void addAnimal(Animal animal) {
		if(!isCageFull()){
			numberOfAnimalAdded++;
			animalList.add(animal);
		}
		
	}

}
