package shoppingCart;

import java.util.Scanner;

/**
 * Main class
 * @author krishna.meghwal_meta
 * @since 18-02-2021*/
public class Main {
public static void main(String[] args){
		
		Store store = new Store();
		
		for(int itemNo = 101; itemNo <= 110; itemNo++){
			
			Item item = new Item(itemNo,"Toothpaste",20);
			store.updateStore(item);				
		}
		
		store.displayItems();
		
		ShoppingCart cart = new ShoppingCart();
		Scanner sc = new Scanner(System.in); 
		
		boolean start = true;
				
		while(start == true){
			
			System.out.println("\nEnter 0 to end purchasing. \nEnter 1 to add item to cart.\nEnter 2 to remove item from cart.");
			int choice = sc.nextInt();
			
			if(choice == 0){
				cart.showBill();
				break;
			}else if(choice == 1){
				System.out.println("Enter item number to add to cart: ");
				int itemNo = sc.nextInt();
				if(cart.addItem(Store.allItems.get(itemNo))){
					System.out.println("Item added sucessfully");
				}else{
					System.out.println("Item wan not added sucessfully");
				}
			}else if(choice == 2){
				System.out.println("Enter item number to remove from cart: ");
				int itemNo = sc.nextInt();
				if(cart.removeItem(Store.allItems.get(itemNo))){
					System.out.println("Item removed sucessfully");
				}else{
					System.out.println("Item wan not removed sucessfully");
				}
			}else{
				System.out.println("Choose an option: ");
			}
		}	
	}
}
