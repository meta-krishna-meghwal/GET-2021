package intSet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class intSet {
	private final int [] setOfNumbers = new int[1000];
	private final int size;
	
	/**  Method to convert int to Integer
	 * @param int []
	 * @return List<Integer> 
	 */
	private static List<Integer> toConvertInteger(int[] ids) {
		List<Integer> newArray = new ArrayList<Integer>();
		     for (int index = 0; index < ids.length; index++) {
		       newArray.add(Integer.valueOf(ids[index]));
		     }
		   return newArray;
		}
	
	/**  Method to convert Integer to int
	 * @param Integer []
	 * @return int[] */
	private static int[] toInt(Integer[] WrapperArray) {
		   int[] newArray = new int[WrapperArray.length];
		      for (int index = 0; index < WrapperArray.length; index++) {
		         newArray[index] = WrapperArray[index].intValue();
		      }
		   return newArray;
		}
	
	
	public intSet(int[] setElements){
		for(int number : setElements){
			this.setOfNumbers[number - 1] = 1;
		}
		
		this.size = setElements.length;
	}
	
	/**  Method to check if the number is between 1-1000
	 * @param int 
	 * @return boolean */
	public boolean isMember(int x){
		return (x <= 1000 && x >= 1 && this.setOfNumbers[x-1] == 1);
	}
	
	/** Method to get size
	 @return int */
	public int size(){
		return this.size;
	}
	
	/** Method to get numbers
	 @return int[] */
	public int[] getNumbers(){
		
		int[] answer = new int [this.size];
		int position = 0;
		for(int index=0; index < 1000; index++){
			if(this.setOfNumbers[index]==1){
				answer[position] = index + 1;
				position++;
			}
		}
		
		return this.setOfNumbers;		
	}
	
	public boolean isSubSet(intSet s){
		boolean answer = true;
		int [] values = s.getNumbers();
		for(int number:values){
			if(this.setOfNumbers[ number -1] != 1){
				answer = false;
				break;
			}
		}
		return answer;
	}
	
	/** Method to get complement numbers
	 @return int[] */
	public intSet getComplement(){
		int [] values = new int[1000 - this.size];
		int j = 0;
		for(int i=0; i < 1000; i++){
			if(this.setOfNumbers[i] != 1){
				values[j] = i + 1;
				j++;
			}
		}
		intSet s = new intSet(values);
		return s;
	}
	
	/** Method to get union numbers
	 * @param intSet intSet
	 @return intSet */
	public intSet union(intSet s1, intSet s2){
	
		List<Integer> numbers1 = toConvertInteger(s1.getNumbers());
		List<Integer>  numbers2 = toConvertInteger(s2.getNumbers());
		
		Set<Integer> unionOfArrays = new HashSet<>();
		unionOfArrays.addAll(numbers1);
		unionOfArrays.addAll(numbers2);
		Integer[] unionArray = {};
        unionArray = unionOfArrays.toArray(unionArray);
        int[] numbers = toInt(unionArray);
        intSet s = new intSet(numbers);
        
        return s;
		
	}
	
	
}
