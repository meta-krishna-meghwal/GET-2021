package ZooManagement;

import java.util.ArrayList;
import java.util.List;

/**
 *Main Class for creating and maintaining zoo
 * @author krishna.meghwal_meta
 * @since 24-02-2021*/
public class Main {	
	public static void main(String[] args){	
		
		String[] types = {"Bird","Reptile","Mammal"};
		List<Animal> animalList = new ArrayList<Animal>();
		Zoo zoo = new Zoo(types);
		for(int i=0; i < 50; i++){
			Animal animal = new Lion("King","Mammal",12,10);
			animalList.add(animal);			
			zoo.addAnimal(animal);		
			}
		
		System.out.println(zoo.removeAnimal(animalList.get(8)));
	}
}
