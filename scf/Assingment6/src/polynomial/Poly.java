package polynomial;

import java.util.Arrays;

/**
 * Class to perform operation on single variable polynomial
 * @author krishna.meghwal_meta
 * @created-on 22-02-2021*/

public final class Poly {
	
	private final Integer [] coefficients;
	private final Integer [] powers;
	private final int length;  
	private final int degree;  
	
	@Override
	public String toString() {
		return "Poly [coefficients=" + Arrays.toString(coefficients)
				+ ", powers=" + Arrays.toString(powers) + ", length=" + length
				+ ", degree=" + degree + "]";
	}


	public Poly(Integer[] poly){
		
		Integer[] tempPowers = new Integer [poly.length];
		Integer[] tempCoefficients = new Integer [poly.length];
		this.degree = poly.length - 1;
		
		int curIndex = 0;
		for(int index = 0; index <= this.degree; index++){
			if(poly[index]!=0){
				tempPowers[curIndex] = index;
				tempCoefficients[curIndex++] = poly[index];
			}
		}
		
		this.length = curIndex;
		this.coefficients = new Integer[this.length];
		this.powers = new Integer[this.length];
		
		System.arraycopy(tempCoefficients, 0, this.coefficients, 0, this.length);
		System.arraycopy(tempPowers, 0, this.powers, 0, this.length);
	}
	
	
	/**
	 * Method to evaluate polynomial
	 * @param float 
	 * @return double 
	 *  */
	public double evaluate(float x){
		double result = 0;
		for(int i = 0; i < this.length; i++){
			result += (this.coefficients[i] * Math.pow(x,this.powers[i]));		
		}
		return result;
	}
	
	
	/**
	 * Method to get power array
	 * @return Integer[]  */
	public Integer[] getPowers(){
		return this.powers;
	}
	
	
	/**
	 * Method to return degree of polynomial
	 * @return int  */
	public int degree(){
		return this.degree;
	}
	
	
	/**
	 * Method to return length of array
	 * @return int  */
	public int length(){
		return this.length;
	}
	
	
	/** Method to get coefficient array
	 * @return Integer[]
	 * */
	public Integer[] getCoefficients(){
		return this.coefficients;
	}
	
	
	/** Method to multiply two polynomial
	 * @param Poly Poly
	 * @return Poly
	 * */
	public static Poly multiplyPoly(Poly p1, Poly p2){
		Integer[] coefficientsP1 = p1.getCoefficients();
		Integer[] powersP1 = p1.getPowers();
		int p1Degree = p1.degree();
		int p1Length = p1.length();
		
		Integer[] coefficientsP2 = p2.getCoefficients();
		Integer[] powersP2 = p2.getPowers();
		int p2Degree = p2.degree();
		int p2Length = p2.length();
		
		int maxLength = p1Degree + p2Degree + 1;
		Integer[] result = new Integer[maxLength];
				
		for(int index = 0; index <maxLength; index++){
			result[index] = 0;
		}
		
		for(int p1Index = 0; p1Index < p1Length; p1Index++){
			int powerP1 = powersP1[p1Index];
			for(int p2Index = 0; p2Index < p2Length; p2Index++){
				int powerP2 = powersP2[p2Index];

				result[powerP1+ powerP2] += coefficientsP1[p1Index]*coefficientsP2[p2Index];
			}
		}
		
		Poly p = new Poly(result);
		
		return p;
	}
	
	
	/** Method to add two polynomial
	 * @param Poly Poly
	 * @return Poly
	 * */
	public static Poly addPoly(Poly p1, Poly p2){
		Integer[] coefficientsP1 = p1.getCoefficients();
		Integer[] powersP1 = p1.getPowers();
		int p1Degree = p1.degree();
		
		Integer[] coefficientsP2 = p2.getCoefficients();
		Integer[] powersP2 = p2.getPowers();
		int p2Degree = p2.degree();
		
		int maxLength = p1Degree > p2Degree ? p1Degree + 1: p2Degree + 1;
		int index1 = 0, index2 = 0;
		
		Integer[] result = new Integer[maxLength];
		

		for(int power = 0; power < maxLength; power++){
			result[power] = 0;
			
			if(index1 < coefficientsP1.length && power == powersP1[index1]){
				result[power] += coefficientsP1[index1++];
			}
			if(index2 < coefficientsP2.length && power == powersP2[index2]){
				result[power] += coefficientsP2[index2++];
			}
		}
		
		Poly p = new Poly(result);
		
		return p;
		
	}
	
	


}
