import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

public class MortgageTest {

	@Test
	public void test1() {
		MortgageCalculator mc = new MortgageCalculator();
		LocalDate birthday = LocalDate.of(1967, 5, 2); 
		Customer customer = new Customer(birthday, 3000, 0, "Architect", MaritalStatus.single);
		double result = mc.computeMaxMortgage(customer);
	    assertEquals(180000, result, 0.001);
	}
	
	@Test
	public void test2() {
		MortgageCalculator mc = new MortgageCalculator();
		LocalDate birthday = LocalDate.of(2001, 5, 2);  
		Customer customer = new Customer(birthday, 3000, 0, "Architect", MaritalStatus.single);
		double result = mc.computeMaxMortgage(customer);
	    assertEquals(0, result, 0.001);
	}
	
	@Test
	public void test3() {
		MortgageCalculator mc = new MortgageCalculator();
		LocalDate birthday = LocalDate.of(1977, 12, 2); 
		Customer customer = new Customer(birthday, 4000, 2000, "Developer", MaritalStatus.married);
		double result = mc.computeMaxMortgage(customer);
	    assertEquals(220000, result, 0.001);
	}
	
	@Test
	public void test4() {
		MortgageCalculator mc = new MortgageCalculator();
		LocalDate birthday = LocalDate.of(1954, 5, 12);  
		Customer customer = new Customer(birthday, 5500, 0, "Professor", MaritalStatus.single);
		double result = mc.computeMaxMortgage(customer);
	    assertEquals(280000, result, 0.001);
	}

}
