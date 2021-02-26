package arithmetic;

public class HexCalc {
	private static int base = 16;
	
	/**  Method to convert hexadecimal to decimal
	 * @param String 
	 * @return int*/
	public int hexToDec(String hexString){
		int decimal = Integer.parseInt(hexString,base); 
		return decimal;
	}
	
	
	/**  Method to convert hexadecimal to decimal
	 * @param int 
	 * @return String */
	public String decToHex(int decimal){
		String hexString = Integer.toHexString(decimal); 
		return hexString;
	}
	
	/**  Method to add hexadecimal numbers 
	 * @param String String
	 * @return String */
	public String hexAddition(String number1,String number2){
		String answer = "";
		int num1 = this.hexToDec(number1);
		int num2 = this.hexToDec(number2);
		
		answer = this.decToHex(num1 + num2);
		return answer;
	}
	
	/**  Method to substract hexadecimal numbers 
	 * @param String String
	 * @return String */
	public String hexSubstraction(String number1,String number2){
		String answer = "";
		int num1 = this.hexToDec(number1);
		int num2 = this.hexToDec(number2);
		
		answer = this.decToHex(num1 - num2);
		return answer;
	}
	
	/**  Method to Multiply hexadecimal numbers 
	 * @param String String
	 * @return String */
	public String hexMultiplication(String number1,String number2){
		String answer = "";
		int num1 = this.hexToDec(number1);
		int num2 = this.hexToDec(number2);
		
		answer = this.decToHex(num1 * num2);
		return answer;
	}
	
	/**  Method to division hexadecimal numbers 
	 * @param String String
	 * @return String */
	public String hexDivision(String number1,String number2){
		String answer = "";
		int num1 = this.hexToDec(number1);
		int num2 = this.hexToDec(number2);
		
		answer = this.decToHex(num1 / num2);
		return answer;
	}
	
	/**Method to compare if a number1 is less than number2
	 * @param String String
	 * @return boolean */
	public boolean lessThan(String number1,String number2){
		
		boolean answer = false;		
		if(number1.length()  < number2.length()){
			answer = true;
		}else if(number1.length() > number2.length()){
			answer = false;
		}else{
			int n = number1.length();
			for(int i=0;i<n;i++){
				if(number1.charAt(i) < number2.charAt(i)){
					answer = true;
					break;
				}else if(number1.charAt(i) > number2.charAt(i)){
					answer = false;
					break;
				}
			}
		}
		return answer;
	}
	
	/**Method to compare if a number1 is greater than number2
	 * @param String String
	 * @return boolean */
	public boolean greaterThan(String number1,String number2){
		boolean answer = false;
		
		if(number1.length()  > number2.length()){
			answer = true;
		}else if(number1.length() < number2.length()){
			answer = false;
		}else{
			int n = number1.length();
			
			for(int i=0;i<n;i++){
				if(number1.charAt(i) > number2.charAt(i)){
					answer = true;
					break;
				}else if(number1.charAt(i) < number2.charAt(i)){
					answer = false;
					break;
				}
			}
		}
		return answer;
	}
	
	/**Method to compare if a number1 is equal to number2
	 * @param String String
	 * @return boolean */
	public boolean equalsTo(String number1,String number2){		
		return number1.equals(number2);
	}
	
}
