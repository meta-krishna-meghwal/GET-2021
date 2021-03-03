package mathematicalFunctions;

/**
 * Class to perform mathematical operations
 * 
 * @author krishna.meghwal_meta
 * @created-on 01-03-2021
 * */
public class mathematicalFunctions {

	/**
	 * Method to find lcm of two numbers
	 * 
	 * @param int x
	 * @param int y
	 * @return int
	 * */
	static int lcmOfTwoNumbers(int x, int y) {

		return (x * y / hcfOfTwoNumbers(x, y));
	}

	/**
	 * Method to find hcf of two numbers
	 * 
	 * @param int x
	 * @param int y
	 * @return int
	 * */
	static int hcfOfTwoNumbers(int x, int y) {
		if (x == 0) {
			return y;
		} else {
			return hcfOfTwoNumbers(y % x, x);
		}
	}

}
