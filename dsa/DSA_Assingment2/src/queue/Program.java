package queue;

/**
 * Class to represent a program in college
 * 
 * @created-on 08-03-2021
 * @author krishna.meghwal_meta
 * */
public class Program {
	static int size = 10;
	static int currentSize = 0;
	static Program[] programList = new Program[size];

	String programName;
	int capacity;

	public Program(String name, int capacity) {
		programName = name;
		this.capacity = capacity;
	}

	/**
	 * Method to add a program to the list
	 * 
	 * @param Program
	 */
	static void addProgram(Program p) {
		if (currentSize < size)
			programList[currentSize++] = p;

	}

}
