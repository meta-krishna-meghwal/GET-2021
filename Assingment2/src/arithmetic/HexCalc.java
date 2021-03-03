package arithmetic;

import java.util.HashMap;
import java.util.Map;

/**
 * Class to perform operation on hexadecimal numbers
 * 
 * @author krishna.meghwal_meta
 * @created-on 19-02-2021
 */
public class HexCalc {
	private static int base = 16;
	Map<Character, Integer> hexMap = new HashMap<Character, Integer>();

	public HexCalc() {
		char[] hexArray = { 'A', 'B', 'C', 'D', 'E', 'F' };
		for (int i = 0; i < base; i++) {
			if (i < 10) {
				char c = (char) (i + '0');
				hexMap.put(c, i);
			} else {
				hexMap.put(hexArray[i - 10], i);
			}
		}
	}

	/**
	 * Method to convert hexadecimal to decimal
	 * 
	 * @param String
	 * @return int
	 */
	public int hexToDec(String hexString) {
		int decimal = 0;
		int length = hexString.length();
		int i = 0;
		for (int power = length - 1; power >= 0; power--) {
			char c = (char) ((int) hexString.charAt(i) - 32);
			Integer p = hexMap.get(c);
			decimal += (p * Math.pow(16, power));
			i++;
		}
		return decimal;
	}

	/**
	 * Method to convert hexadecimal to decimal
	 * 
	 * @param int
	 * @return String
	 */
	public String decToHex(int decimal) {

		int rem;
		String hex = "";
		char hexchars[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
				'A', 'B', 'C', 'D', 'E', 'F' };
		while (decimal > 0) {
			rem = decimal % 16;
			hex = hexchars[rem] + hex;
			decimal = decimal / 16;
		}
		return hex;
	}

	/**
	 * Method to add hexadecimal numbers
	 * 
	 * @param String
	 * @param String
	 * @return String
	 */
	public String hexAddition(String number1, String number2) {
		String answer = "";
		int num1 = this.hexToDec(number1);
		int num2 = this.hexToDec(number2);
		answer = this.decToHex(num1 + num2);
		return answer;
	}

	/**
	 * Method to substract hexadecimal numbers
	 * 
	 * @param String
	 * @param String
	 * @return String
	 */
	public String hexSubstraction(String number1, String number2) {
		String answer = "";
		int num1 = this.hexToDec(number1);
		int num2 = this.hexToDec(number2);
		
		answer = this.decToHex(num1 - num2);
		if(answer.length() == 0){
			answer = "0";
		}
		return answer;
	}

	/**
	 * Method to Multiply hexadecimal numbers
	 * 
	 * @param String
	 * @param String
	 * @return String
	 */
	public String hexMultiplication(String number1, String number2) {
		String answer = "";
		int num1 = this.hexToDec(number1);
		int num2 = this.hexToDec(number2);

		answer = this.decToHex(num1 * num2);
		return answer;
	}

	/**
	 * Method to division hexadecimal numbers
	 * 
	 * @param String
	 * @param String
	 * @return String
	 */
	public String hexDivision(String number1, String number2) {
		String answer = "";
		int num1 = this.hexToDec(number1);
		int num2 = this.hexToDec(number2);

		answer = this.decToHex(num1 / num2);
		return answer;
	}

	/**
	 * Method to compare if a number1 is less than number2
	 * 
	 * @param String
	 * @param String
	 * @return boolean
	 */
	public boolean lessThan(String number1, String number2) {

		boolean answer = false;
		if (number1.length() < number2.length()) {
			answer = true;
		} else if (number1.length() > number2.length()) {
			answer = false;
		} else {
			int n = number1.length();
			for (int i = 0; i < n; i++) {
				if (number1.charAt(i) < number2.charAt(i)) {
					answer = true;
					break;
				} else if (number1.charAt(i) > number2.charAt(i)) {
					answer = false;
					break;
				}
			}
		}
		return answer;
	}

	/**
	 * Method to compare if a number1 is greater than number2
	 * 
	 * @param String
	 * @param String
	 * @return boolean
	 */
	public boolean greaterThan(String number1, String number2) {
		boolean answer = false;

		if (number1.length() > number2.length()) {
			answer = true;
		} else if (number1.length() < number2.length()) {
			answer = false;
		} else {
			int n = number1.length();

			for (int i = 0; i < n; i++) {
				if (number1.charAt(i) > number2.charAt(i)) {
					answer = true;
					break;
				} else if (number1.charAt(i) < number2.charAt(i)) {
					answer = false;
					break;
				}
			}
		}
		return answer;
	}

	/**
	 * Method to compare if a number1 is equal to number2
	 * 
	 * @param String
	 * @param String
	 * @return boolean
	 */
	public boolean equalsTo(String number1, String number2) {

		if (number1.length() != number2.length()) {
			return false;
		} else {
			int n = number1.length();

			for (int i = 0; i < n; i++) {
				if (number1.charAt(i) != number2.charAt(i)) {
					return false;
				}
			}
		}
		return true;

	}

}
