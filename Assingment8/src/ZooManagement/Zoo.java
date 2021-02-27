package ZooManagement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Class for creating and maintaining zoo structure
 * @author krishna.meghwal_meta
 * @since 24-02-2021*/
public class Zoo {
	
	Map<String, List<Zone>> zooChart = new HashMap<String, List<Zone>>();
	Map<Integer, List<Integer>> animalIds = new HashMap<Integer, List<Integer>>(); 
	
	static final int noOfZones = 15;
	static  int numberOfZonesCreated = 0;
	
	
	/** Initialization of zooChart for each category 
	 * @param String[]  */
	public Zoo(String[] types){
		for(String s: types){
			List<Zone> zones = new ArrayList<Zone>();
			this.zooChart.put(s, zones);
		}	
	}
	
	/** Method for adding an animal to the zoo
	 * @param Animal
	 * @return boolean*/
	public boolean addAnimal(Animal animal){
		
		String type = animal.animalType;	
		Zone zone = getZone(type);
		Cage cage = null;
		
		if(numberOfZonesCreated == noOfZones && zone.isZoneFull()){
			return false;
		}
		else{				
			if(zone != null)
				cage = zone.getCage();			
					
			if(cage != null){
				cage.addAnimal(animal);
				List<Integer> location = new ArrayList<Integer>();
				location.add(zone.zoneId);
				location.add(cage.cageId);				
				animalIds.put(animal.animalId,location);
				System.out.println(location.toString());				
			}		
			return true;
		}			
	}
	
	/** Method to add a zone in the zoo according to its category
	 * @param String
	 * @return Zone
	 */
	public Zone addZone(String type) {
		Zone zone = null;
		if(numberOfZonesCreated < noOfZones){
			numberOfZonesCreated++;
			zone = new Zone(type);
			zooChart.get(type).add(zone);
		}
		return zone;
	}

	/**Method to get a zone of a particular category 
	 * Returns last zone added
	 * @param String
	 * @return Zone*/
	public Zone getZone(String type){
		List<Zone> zones = zooChart.get(type);
		Zone zone = null;
		if(zones.size()==0){
			zone = new Zone(type);
			zones.add(zone);
		}else{
			int lastZone = zones.size() - 1;
			zone = zones.get(lastZone);	
		}	
		
		if(zone.isZoneFull()){
			zone = addZone(type);
		}
		return zone;	
	}
	
	/** Method for removing an animal from the zoo
	 * @param Animal
	 * @return boolean*/
	public boolean removeAnimal(Animal animal){
		
		boolean answer = false;
		if(animalIds.size() > 0){
		
			List<Integer> location = animalIds.get(animal.animalId);
			int zoneId = location.get(0);
			int cageId = location.get(1);
			
			List<Zone> zones = zooChart.get(animal.animalType);
			int totalZones = zones.size();
			
			Zone zone = null;
			Cage cage = null;
			for(int i=0; i< totalZones; i++){
				if(zones.get(i).zoneId == zoneId){
					zone = zones.get(i);
					break;
				}
			}
			if(zone != null){
				cage = zone.getCageToRemoveAnimal(cageId);
			}	
			if(cage != null){
				answer = cage.removeAnimal(animal);
			}
			return answer;
		}

		return answer;
	}
}
