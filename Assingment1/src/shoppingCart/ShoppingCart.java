package shoppingCart;

import java.util.HashMap;
import java.util.Map;


/**
 * Class for Creating shopping cart structure
 * @author krishna.meghwal_meta
 * @since 18-02-2021*/

public class ShoppingCart {
		
	public Map<Integer,Item> items = new HashMap<Integer,Item>();
	private int totalAmount = 0,totalItems = 0;
	/**Method to add item to the shopping cart
	 * @param Item
	 * @return boolean
	*/
	public boolean addItem(Item item){
		if(item.itemQuantityInStore > 0){
			item.itemQuantityInStore--;
			item.itemQuantityInCart++;
			totalItems += 1;
			totalAmount += item.itemPrice;
			items.put(item.itemNo,item);
			return true;
		}
		return false;
	}
	
	/**Method to remove item from the shopping cart
	 * @param Item
	 * @return boolean
	*/
	public boolean removeItem(Item item){
		if(item.itemQuantityInCart>0){
			item.itemQuantityInCart--;
			item.itemQuantityInStore++;
			totalAmount -= item.itemPrice;
			totalItems -= 1;
			items.remove(item.itemNo);
			return true;
		}
		return false;
	}
	/**Method to get total amount of the cart
	 * @return int
	*/
	public int getTotalAmount(){
		return totalAmount;
	}
	
	/**Method to get total number of items in the cart
	 * @return int
	*/
	public int getTotalItems(){
		return totalItems;
	}
	
	/**Method to show bill
	*/
	public void showBill(){
		System.out.println("Items in the cart: \n");
		
		for(Integer itemNo : items.keySet()){
			
			Item item = items.get(itemNo);
			String displayText = String.valueOf(item.itemNo) + " " +item.itemName+ " " + String.valueOf(item.itemPrice)+" Quantity: "+String.valueOf(item.itemQuantityInCart) + ".\n";
			System.out.println(displayText);
			
		}
		System.out.println("Toatl items: " + String.valueOf(totalItems) + " Total amount: " + String.valueOf(totalAmount));
		System.out.println("Happy purchasing!!\n");
	}
}
