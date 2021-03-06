package gui;
import java.util.EventObject;


public class FormEvent extends EventObject {

	private String name;
	private String occupation;
	private int ageCategory;
	private String empCategory;
	private String taxId;
	private boolean usCitizen;
	private String gender;
	

	public FormEvent(Object source) {
		super(source);
	}
	
	public FormEvent(Object source, String name, String occupation, int ageCat, 
			String empCat, String taxId, boolean usCitizen, String gender) {
		super(source);
		
		this.name =  name;
		this.occupation = occupation;
		this.ageCategory = ageCat;
		this.empCategory = empCat;
		this.taxId =  taxId;
		this.usCitizen = usCitizen;
		this.gender = gender;
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
	
	public String getEmpCategory() {
		return this.empCategory;
	}

	public int getAgeCategory() {
		return this.ageCategory;
	}

	public String getTaxId() {
		return this.taxId;
	}

	public boolean isUsCitizen() {
		return this.usCitizen;
	}

	public String getGender() {
		return this.gender;
	}
	
	

}
