package Search;

/**
 * Class to implements methods that search element in an array
 * 
 * @author krishna.meghwal_meta
 * @created-on 01-03-2021
 * */
public class Search {

	/**
	 * Method that perform recursive linear search
	 *
	 * @param int[] array : array of elements
	 * @param int lowIndex : lowest index of the array
	 * @param int highIndex : highest index of the array
	 * @param int x : element to search in array
	 * @return int : return index of the element or -1 if not found
	 */
	private static int recursiveLinearSearch(int[] array, int lowIndex,
			int highIndex, int x) {
		if (lowIndex > highIndex) {
			return -1;
		}

		if (array[lowIndex] == x) {
			return lowIndex;
		}
		if (array[highIndex] == x) {
			return highIndex;
		}

		return recursiveLinearSearch(array, lowIndex + 1, highIndex - 1, x);
	}

	/**
	 * Method for linear search
	 *
	 * @param int[] array : array of elements
	 * @param int x : element to search in array
	 * @return int : return index of the element or -1 if not found
	 */
	static int linearSearch(int[] array, int x) {

		return recursiveLinearSearch(array, 0, array.length - 1, x);
	}

	/**
	 * Method that perform recursive binary search
	 *
	 * @param int[] array : array of elements
	 * @param int lowIndex : lowest index of the array
	 * @param int highIndex : highest index of the array
	 * @param int x : element to search in array
	 * @return int : return index of the element or -1 if not found
	 */
	static int recursiveBinarySearch(int[] array, int lowIndex, int highIndex,
			int x) {

		if (highIndex >= lowIndex && lowIndex < array.length - 1) {

			int mid = lowIndex + (highIndex - lowIndex) / 2;

			if (array[mid] == x)
				return mid;

			if (array[mid] > x)
				return recursiveBinarySearch(array, lowIndex, mid - 1, x);

			return recursiveBinarySearch(array, mid + 1, highIndex, x);
		}
		return -1;
	}

	/**
	 * Method for binary search
	 *
	 * @param int[] array : array of elements
	 * @param int x : element to search in array
	 * @return int : return index of the element or -1 if not found
	 */
	static int binarySearch(int[] array, int x) {
		return recursiveBinarySearch(array, 0, array.length - 1, x);
	}
}
