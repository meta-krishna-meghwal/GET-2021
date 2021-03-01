package jUnitTesting;

import java.util.ArrayList;
import java.util.List;

/**
 * Class to perform operation on array
 * 
 * @created-on 01-03-2021
 * @author krishna.meghwal_meta
 */
public class ArrOperation {
	public int[] numbers;

	public ArrOperation(int[] values) {
		numbers = values;
	}

	/**
	 * Method return's the size of the largest mirror section found in the input
	 * array
	 * 
	 * @return int
	 */
	public int largestMirror() {

		assert numbers.length > 0 : "Empty Array";
		int length = numbers.length, count = 0, maxCount = 0;

		for (int index = 0; index < length; index++) {
			count = 0;
			for (int revIndex = length - 1; revIndex >= 0
					&& index + count < length; revIndex--) {
				if (numbers[index + count] == numbers[revIndex]) {
					count++;
				} else {
					if (count > 0) {
						maxCount = Math.max(count, maxCount);
						count = 0;
					}
				}
			}
			maxCount = Math.max(count, maxCount);
		}
		return maxCount;
	}

	/**
	 * Return the number of clumps in the input array.
	 * 
	 * @return int
	 */
	public int clumps() {
		assert numbers.length == 0 : "Empty Array";
		int noOfClump = 0;
		boolean cont = false;
		for (int i = 1; i < numbers.length; i++) {
			if (numbers[i - 1] == numbers[i] && !cont) {
				cont = true;
				noOfClump++;
			} else if (numbers[i - 1] != numbers[i]) {
				cont = false;
			}
		}
		return noOfClump;
	}

	/**
	 * Method to check if two number has same frequency in array
	 * 
	 * @param int x
	 * @param int y
	 * @return boolean
	 */
	public boolean countXY(int x, int y) {
		int countX = 0;
		int countY = 0;
		for (int index = 0; index < numbers.length; index++) {

			if (numbers[index] == x) {
				countX++;
			}
			if (numbers[index] == y) {
				countY++;
			}
		}
		return countX == countY;
	}

	/**
	 * Return an array that contains exactly the same numbers as the input
	 * array, but rearranged so that every X is immediately followed by a Y.
	 * 
	 * @param int x
	 * @param int y
	 * @return int[]
	 */
	public int[] fixXY(int x, int y) throws AssertionError {

		assert numbers.length > 0 : "Empty Array";
		assert numbers[numbers.length - 1] != x : "X occurs at the last index of the array";
		assert countXY(x, y) : "there are unequal numbers of X and Y in the input array";

		int index = 0;

		List<Integer> indexOfX = new ArrayList<Integer>();
		List<Integer> indexOfY = new ArrayList<Integer>();

		while (index < numbers.length) {
			if (numbers[index] == x) {
				if (numbers[index + 1] == x) {
					throw new AssertionError("two adjacents X values are there");
				}

				if (numbers[index + 1] == y) {
					index += 2;
					continue;
				}

				if (indexOfY.size() > 0) {
					int temp = numbers[indexOfY.get(0)];
					numbers[indexOfY.get(0)] = numbers[index + 1];
					numbers[index + 1] = temp;
					index += 2;
					indexOfY.remove(0);
				} else {
					indexOfX.add(index);
					index += 1;
				}
			} else if (numbers[index] == y) {
				if (indexOfX.size() > 0) {
					int temp = numbers[indexOfX.get(0) + 1];
					numbers[indexOfX.get(0) + 1] = numbers[index];
					numbers[index] = temp;
					index += 1;
					indexOfX.remove(0);
				} else {
					indexOfY.add(index);
					index += 1;
				}
			} else {
				index += 1;
			}
		}
		return numbers;
	}

	/**
	 * Return the index if there is a place to split the input array so that the
	 * sum of the numbers on one side is equal to the sum of the numbers on the
	 * other side else return -1
	 * 
	 * @return int
	 */
	public int splitArray() {
		assert numbers.length == 0 : "Empty Array";
		int totalSum = 0;
		for (int index = 0; index < numbers.length; index++) {
			totalSum += numbers[index];
		}
		int leftSum = 0;

		for (int index = 0; index < numbers.length; index++) {
			leftSum += numbers[index];
			totalSum -= numbers[index];
			if (leftSum == totalSum) {
				return index + 1;
			}
		}
		return -1;
	}

}
