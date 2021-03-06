package polynomial;

/**
 * Main Class
 * @author krishna.meghwal_meta
 * @created-on 22-02-2021*/
public class Main {
	
	
	public static void main(String args[]){
		
		Integer[] values1 = {1,2,0,3};
		Integer[] values2 = {1,2};
		Poly p1 = new Poly(values1);
		Poly p2 = new Poly(values2);
		
		Poly p3	= Poly.multiplyPoly(p1, p2);
		Poly p4	= Poly.addPoly(p1, p2);
		System.out.println(p3.toString());
		System.out.println(p4.toString());
		
	}

}
