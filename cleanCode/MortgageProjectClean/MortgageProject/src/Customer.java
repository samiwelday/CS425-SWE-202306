import java.time.LocalDate;

public class Customer {
	private LocalDate birthdate;
	private double monthlyIncome;
	private double monthlyIncomePartner;
	private String profession;
	private MaritalStatus maritalStatus;

	
	public Customer(LocalDate birthdate, double monthlyIncome, double monthlyIncomePartner, String profession,
			MaritalStatus maritalStatus) {
		super();
		this.birthdate = birthdate;
		this.monthlyIncome = monthlyIncome;
		this.monthlyIncomePartner = monthlyIncomePartner;
		this.profession = profession;
		this.maritalStatus = maritalStatus;
	}
	
	public LocalDate getBirthdate() {
		return birthdate;
	}
	public double getMonthlyIncome() {
		return monthlyIncome;
	}
	public double getMonthlyIncomePartner() {
		return monthlyIncomePartner;
	}
	public String getProfession() {
		return profession;
	}
	public MaritalStatus getMaritalStatus() {
		return maritalStatus;
	}



}
