package model;

public class Person {
	private static int count = 0;
	
	private int id;
	private String name;
	private String occupation;
	private AgeCategory ageCategory;
	private EmploymentCategory empCategory;
	private String taxId;
	private boolean usCitizen;
	private Gender gender;
	
	public Person(String name, String occupation, AgeCategory ageCategory,
			EmploymentCategory empCategory, String taxtId, boolean usCitizen, 
			Gender gender) {
		
		this.name =  name;
		this.occupation = occupation;
		this.ageCategory = ageCategory;
		this.empCategory =  empCategory;
		
		this.usCitizen = usCitizen;
		
		if (this.usCitizen) {
			this.taxId = taxtId;
		} else {
			this.taxId = "";
		}
		
		this.gender = gender;
		
		this.id = count;
		this.count++;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getOccupation() {
		return occupation;
	}
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	public AgeCategory getAgeCategory() {
		return ageCategory;
	}
	public void setAgeCategory(AgeCategory ageCategory) {
		this.ageCategory = ageCategory;
	}
	public EmploymentCategory getEmpCategory() {
		return empCategory;
	}
	public void setEmpCategory(EmploymentCategory empCategory) {
		this.empCategory = empCategory;
	}
	public String getTaxId() {
		return taxId;
	}
	public void setTaxId(String taxId) {
		this.taxId = taxId;
	}
	public boolean isUsCitizen() {
		return usCitizen;
	}
	public void setUsCitizen(boolean usCitizen) {
		this.usCitizen = usCitizen;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	
	
}
