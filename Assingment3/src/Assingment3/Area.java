package Assingment3;

/**A class Area to calculate areas for different shapes 
 * @author krishna.meghwal_meta
 * @since 25-02-2021*/
public class Area {
	
	/**Method to return area of a Triangle
	 * @param double double
	 * @return double*/
	public static double areaOfTriangle(double height, double bredth){
		double area = 0.0; 
		try{
		 area = 0.5 * (height*bredth);
		}
		catch(ArithmeticException e){
			System.out.println(e);
		}
		return Math.round(area*100)/100;
	}
	
	/**Method to return area of a square
	 * @param double double
	 * @return double*/
	public static double areaOfSquare(double side){
		double area = 0.0; 
		try{ 
			area = side * side;
		}
		catch(ArithmeticException e){
			System.out.println(e);
		}
		return Math.round(area*100)/100;
	}
	
	/**Method to return area of a rectangle
	 * @param double double
	 * @return double*/
	public static double areaOfRectangle(double length, double breadth){
		double area = 0.0; 
		try{  
			 area = length * breadth;
		 }
		 catch(ArithmeticException e){
			 System.out.println(e);
		 }  
		 return Math.round(area*100)/100;
	}
	
	/**Method to return area of a circle
	 * @param double double
	 * @return double*/
	public static double areaOfCircle(double radius){
		double area = 0.0; 
		try{  
		 area = Math.PI * radius * radius;	
		}
		 catch(ArithmeticException e){
			 System.out.println(e);
		 }
		return Math.round(area*100)/100;
	}

}
