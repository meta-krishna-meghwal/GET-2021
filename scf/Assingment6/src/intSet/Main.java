package intSet;

import java.util.Arrays;

public class Main {

	public static void main(String[] args){
		
		int [] numbers = {1,12,17,13,61,21,32,23,45,67,123,5,42,90,89};
		intSet s = new intSet(numbers);
		int [] n = {1,12,999};
		intSet s2 = new intSet(n);
		System.out.println(Arrays.toString(s.union(s,s2).getNumbers()));
		
	}
}
