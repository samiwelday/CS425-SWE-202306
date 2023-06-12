import java.time.LocalDate;
import java.time.Period;

public class MortgageCalculator {
	enum JobCategory{
		medium, good, excellent, not_known;
	}

	public double computeMaxMortgage(Customer customer) {
		double monthlyIncome = customer.getMonthlyIncome();
		
		if (!isEligibleAge(customer)) {
			return 0;
		}
		
		if (isMarried(customer)) {
			monthlyIncome = computeMonthlyIncomeCouple(customer, monthlyIncome); 
		}
		
		return computeMortgageAmount(monthlyIncome, customer.getProfession());
	}

	private double computeMonthlyIncomeCouple(Customer customer, double monthlyIncome) {
		final double PARTNER_INDEX_RATE = 0.94;
		return monthlyIncome + customer.getMonthlyIncomePartner() * PARTNER_INDEX_RATE;
	}

	private boolean isMarried(Customer customer) {
		return customer.getMaritalStatus() == MaritalStatus.married;
	}
		
	private boolean isEligibleAge(Customer customer) {
		final double MINIMUM_AGE = 18;
		return calculateAge(customer.getBirthdate()) > MINIMUM_AGE;
	}
	
	private int calculateAge(LocalDate birthday) {
		LocalDate today = LocalDate.now();                          
		 
		Period p = Period.between(birthday, today);
		return p.getYears();
	}
	
	private double computeMortgageAmount(double income, String profession) {
		if ( isLowIncome(income)) {
			return computeLowIncomeForProfession(profession);
		}
		if (  isMiddleIncome(income)) {
			return computeMiddleIncomeForProfession(profession);
		}
		if ( isHighIncome(income)) {
			return computeHighIncomeForProfession(profession);
		}
		return 0;
	}
	
	private boolean isLowIncome(double income) {
		return 2000<=income && income<3000;
	}
	
	private boolean isMiddleIncome(double income) {
		return 3000<=income && income<5000;
	}

	private boolean isHighIncome(double income) {
		return 5000<=income;
	}
	
	private double computeLowIncomeForProfession(String profession) {
		if (getJobCategory(profession) == JobCategory.good) return 160000;
		if (getJobCategory(profession) == JobCategory.medium) return 120000;
		if (getJobCategory(profession) == JobCategory.excellent) return 220000;
		return 0;
	}

	private double computeMiddleIncomeForProfession(String profession) {
		if (getJobCategory(profession) == JobCategory.good) return 180000;
		if (getJobCategory(profession) == JobCategory.medium) return 140000;
		if (getJobCategory(profession) == JobCategory.excellent) return 250000;
		return 0;
	}
	
	private double computeHighIncomeForProfession(String profession) {
		if (getJobCategory(profession) == JobCategory.good) return 220000;
		if (getJobCategory(profession) == JobCategory.medium) return 160000;
		if (getJobCategory(profession) == JobCategory.excellent) return 280000;
		return 0;
	}
	
	private JobCategory getJobCategory(String profession) {
		switch (profession) {
		  case "Tester" : case "System Administrator" : case "Technical writer" : return JobCategory.medium;
		  case "Developer" : case "Architect" : case "Scrum master" : return JobCategory.good;
		  case "Department head" : case "Professor" :  return JobCategory.excellent;
		}
		return JobCategory.not_known;
	}


}
