package intSet;

/**
 * Class to perform operation on set of numbers in range 1-1000
 * 
 * @author krishna.meghwal_meta
 * @created-on 22-02-2021
 */
public final class intSet {
	private final int[] setOfNumbers = new int[1000];
	private final int size;

	public intSet(int[] setElements) {
		for (int number : setElements) {
			this.setOfNumbers[number - 1] = 1;
		}

		this.size = setElements.length;
	}

	/**
	 * Method to check if the number is between 1-1000
	 * 
	 * @param int
	 * @return boolean
	 */
	public boolean isMember(int x) {
		return (x <= 1000 && x >= 1 && this.setOfNumbers[x - 1] == 1);
	}

	/**
	 * Method to get size
	 * 
	 * @return int
	 */
	public int size() {
		return this.size;
	}

	/**
	 * Method to get numbers
	 * 
	 * @return int[]
	 */
	public int[] getNumbers() {

		int[] answer = new int[this.size];
		int position = 0;
		for (int index = 0; index < 1000 && position < this.size; index++) {
			if (this.setOfNumbers[index] == 1) {
				answer[position] = index + 1;
				position++;
			}
		}

		return answer;
	}

	/**
	 * Method to check for subset
	 * 
	 * @return boolean
	 */
	public boolean isSubSet(intSet s) {
		boolean answer = true;
		int[] values = s.getNumbers();
		for (int number : values) {
			if (this.setOfNumbers[number - 1] != 1) {
				answer = false;
				break;
			}
		}
		return answer;
	}

	/**
	 * Method to get complement numbers
	 * 
	 * @return int[]
	 */
	public intSet getComplement() {
		int[] values = new int[1000 - this.size];
		int j = 0;
		for (int i = 0; i < 1000; i++) {
			if (this.setOfNumbers[i] != 1) {
				values[j] = i + 1;
				j++;
			}
		}
		intSet s = new intSet(values);
		return s;
	}

	/**
	 * Method to get union numbers
	 * 
	 * @param intSet
	 * @param intSet
	 * @return intSet
	 */
	public intSet union(intSet s1, intSet s2) {

		int[] setTempValues = new int[s1.size + s2.size];
		int index = 0;
		for (int i = 0; i < 1000; i++) {
			if (s1.setOfNumbers[i] == 1 || s2.setOfNumbers[i] == 1) {
				setTempValues[index++] = i + 1;
			}
		}
		int[] setValues = new int[index];
		for (int i = 0; i < index; i++) {
			setValues[i] = setTempValues[i];
		}

		return new intSet(setValues);

	}

}
