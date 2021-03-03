package arithmetic;

public class Main {

	public static void main(String[] args) {
		HexCalc h = new HexCalc();
		System.out.println(h.hexAddition("bcd", "bcd"));
		System.out.println(h.hexMultiplication("bcd", "bcd"));
		System.out.println(h.hexSubstraction("bcd", "bcd"));
		System.out.println(h.hexDivision("bcd", "bcd"));
		System.out.println(h.hexToDec("bcd"));
		System.out.println(h.decToHex(3021));
		System.out.println(h.lessThan("bcd", "ccd"));
		System.out.println(h.greaterThan("bcd", "ccd"));
		System.out.println(h.equalsTo("bcd", "ccd"));
	}
}
