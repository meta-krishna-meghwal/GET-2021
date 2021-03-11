package string;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Test class for mass calculation
 * 
 * @created-on 09-03-2021
 * @author krishna.meghwal_meta
 */
public class MassCalculationTest {

	@Test
	public void MassTest() {
		MassCalculation m = new MassCalculation();
		assertEquals(86, m.calculateMass("CHOC(CH3)3"));
	}

}
