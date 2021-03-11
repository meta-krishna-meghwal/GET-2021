package string;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Class to calculate mass of a chemical formula
 * 
 * @created-on 09-03-2021
 * @author krishna.meghwal_meta
 */
public class MassCalculation {
	static final Map<Character, Integer> masses = new HashMap<Character, Integer>();
	Stack<Character> elements = new Stack<Character>();

	public MassCalculation() {
		masses.put('C', 12);
		masses.put('O', 16);
		masses.put('H', 1);
	}

	/**
	 * Method to calsulate mass of the formula
	 * 
	 * @param String
	 * @return int
	 */
	public int calculateMass(String formula) {
		int totalMass = 0;

		for (int i = 0; i < formula.length(); i++) {
			elements.push(formula.charAt(i));
		}

		boolean inBracket = false;
		int digit = -1;
		int bracketDigit = -1;

		while (elements.size() > 0) {
			char element = elements.pop();

			if (element >= '0' && element <= '9') {
				if (digit == -1)
					digit = Integer.parseInt(String.valueOf(element));
				else {
					digit = (digit * 10)
							+ Integer.parseInt(String.valueOf(element));
				}

				if (bracketDigit != -1 && inBracket) {
					digit *= bracketDigit;
				}
			}

			else if (element == 'C' || element == 'O' || element == 'H') {
				if (digit == -1) {
					if (inBracket) {
						totalMass += bracketDigit * masses.get(element);
					} else {
						totalMass += masses.get(element);
					}
				} else {
					totalMass += digit * (masses.get(element));
					digit = -1;
				}
			} else if (element == ')') {
				inBracket = true;
				if (digit != -1) {
					bracketDigit = digit;
					digit = -1;
				}
			} else if (element == '(') {
				bracketDigit = -1;
				inBracket = false;
			}

		}

		return totalMass;
	}

}
