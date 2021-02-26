package shoppingCart;

import java.util.*;

/**
 * Class for Creating store structure
 * @author krishna.meghwal_meta
 * @since 18-02-2021*/
public class Store {
	
	static HashMap<Integer,Item> allItems = new HashMap<Integer,Item>();
	
	/**Method to update items in store
	* @param Item
	*/
	public void updateStore(Item item) {
		allItems.put(item.itemNo,item);
	}
	
	/**Method to update items in store
	* @param Item
	*/
	public void displayItems(){
		System.out.println("Choose from below items: \n");
		for(Integer itemNo : allItems.keySet()){
			Item item = allItems.get(itemNo);
			String displayText = String.valueOf(item.itemNo) + ") " +item.itemName+" Price: " + String.valueOf(item.itemPrice)+" Quantity: "+ String.valueOf(item.itemQuantityInStore);
			System.out.println(displayText);
			
		}
	}
	
	
}
