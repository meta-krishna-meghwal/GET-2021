package shoppingCart;

/**
 * Class for Creating item structure
 * @author krishna.meghwal_meta
 * @since 18-02-2021*/
public class Item {
	public String itemName;
	public int itemPrice,itemNo,itemQuantityInCart, itemQuantityInStore;
	
	public Item(int number,String name,int price){
		itemName = name;
		itemPrice = price;
		itemNo = number;
		itemQuantityInCart = 0;
		itemQuantityInStore = 5;
		
	}
}
