/*
 * TicketTest.java 23 Jan 2024
 *
 *
 * \u00A9 Copyright 2024 Joan S�culi
 * Email: jseculi@escoladeltreball.org
 *
 * This is free software, licensed under the GNU General Public License v3.
 * See http://www.gnu.org/licenses/gpl.html for more information.
 */
package ticket;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import java.lang.reflect.Method;

class TicketTest {

	static Ticket t;
	static Tax tax;
	

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		t = new Ticket();

	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testTotal() throws Exception {

		float[][] items1 = { { 1, 1, 3.80f }, 
				{ 2, 1, 2.0f }, 
				{ 3, 3, 2.20f }, 
				{ 4, 5, 2.90f },
				{ 5, 10, 3.20f },
				{ 6, 12, 3.70f },
				{ 7, 5, 3.10f }, 
				{ 8, 7, 3.60f }, 
				{ 9, 12, 2.70f }, 
				};

		// https://www.educative.io/answers/how-to-use-junit-5-to-test-for-private-methods

		//Ticket t = new Ticket();
		
		Method total = Ticket.class.getDeclaredMethod("total", float[][].class);
		total.setAccessible(true);
		float result = (float) total.invoke(t, items1);
		assertEquals(176.40, result, 0.01);
	}

	@Test
	void testTotalUnit() throws Exception {
		//Ticket t = new Ticket();
		Method totalUnit = Ticket.class.getDeclaredMethod("totalUnit", float[].class);
		totalUnit.setAccessible(true);
		
		float[] item1 = { 1, 1, 3.80f };
		float result = (float) totalUnit.invoke(t, item1);
		
		assertEquals(3.80f, result, 0.01);

		float[] item2 = { 2, 1, 2.0f };
		result = (float) totalUnit.invoke(t, item2);
		assertEquals(2.0f, result, 0.01);
		
		float[] item3 = { 3, 3, 2.20f };
		result = (float) totalUnit.invoke(t, item3);
		assertEquals(6.6f, result, 0.01);
		
		float[] item4 = { 4, 5, 2.90f };
		result = (float) totalUnit.invoke(t, item4);
		assertEquals(14.5f, result, 0.01);
		
	}
	
	@Test
	@Disabled
	void testGenerateTicket() {
		
		String expected = "Ticket                   Date:     23.01.24  19:00:53\r\n"
				+ "-----------------------------------------------------\n"
				+ "Product:                 Units  Price Unit      Total\n"
				+ "-----------------------------------------------------\n"
				+ "Coffee large                 1        3.80      3.80€\n"
				+ "Expresso                     1        2.00      2.00€\n"
				+ "Coffee latte                 3        2.20      6.60€\n"
				+ "Macchiato                    5        2.90     14.50€\n"
				+ "Chocolate                   10        3.20     32.00€\n"
				+ "Frappuccino                 12        3.70     44.40€\n"
				+ "Coffee mocha                 5        3.10     15.50€\n"
				+ "Americano                    7        3.60     25.20€\n"
				+ "Brewed coffee               12        2.70     32.40€\n"
				+ "-----------------------------------------------------\n"
				+ "TAX:                     30.61€\n"
				+ "-----------------------------------------------------\n"
				+ "TOTAL WITHOUT TAX:      145.79€\n"
				+ "-----------------------------------------------------\n"
				+ "TOTAL:                                        176.40€\n";
		
		float[][] items1 = { { 1, 1, 3.80f }, 
				{ 2, 1, 2.0f }, 
				{ 3, 3, 2.20f }, 
				{ 4, 5, 2.90f },
				{ 5, 10, 3.20f },
				{ 6, 12, 3.70f },
				{ 7, 5, 3.10f }, 
				{ 8, 7, 3.60f }, 
				{ 9, 12, 2.70f }, 
				};
		
		String actual = t.generateTicket(items1);
		
		assertEquals(expected.substring(55), actual.substring(55));
		//assertTrue(expected.substring(55).equals(actual.substring(55)));
	}
	
	@Test
	void testTax1() throws Exception {
		//Ticket t = new Ticket();
		Method tax = Tax.class.getDeclaredMethod("tax", float.class, float.class);
		tax.setAccessible(true);
		
		
		float result = (float) tax.invoke(tax, 121, 0.21f);
		assertEquals(result, 21, 0.01);
	}
	
	@Test
	void testTax2() throws Exception {
		//Ticket t = new Ticket();
		Method tax = Tax.class.getDeclaredMethod("tax", float.class, float.class);
		tax.setAccessible(true);
		
		
		float result = (float) tax.invoke(tax, 350, 0.21f);
		assertEquals(result, 60.74, 0.01);
	}
	
	@Test
	void testTax3() throws Exception {
		//Ticket t = new Ticket();
		Method tax = Tax.class.getDeclaredMethod("tax", float.class, float.class);
		tax.setAccessible(true);
		
		
		float result = (float) tax.invoke(tax, 256.75f, 0.21f);
		assertEquals(result, 44.559, 0.01);
	}
	
}