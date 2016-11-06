package model;

import java.io.Serializable;

public class Person implements Serializable{
	private static final long serialVersionUID = -6414705322368139288L;

	private static int count = 1;
	
	private int id; 
	private String name;
	private String occupation;
	private AgeCategory ageCategory;
	private EmploymentCategory empCat; 
	private String taxId;
	private boolean indiaCitizen;
	private Gender gender;
	
	public Person(String name, String occupation, AgeCategory ageCategory,
			EmploymentCategory empCat, String taxId, boolean indiaCitizen, Gender gender) {
		
		this.name = name;
		this.occupation = occupation;
		this.ageCategory = ageCategory;
		this.empCat = empCat;
		this.taxId = taxId;
		this.indiaCitizen = indiaCitizen;
		this.gender = gender;
		
		this.id = count;
		count++;
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
	public EmploymentCategory getEmpCat() {
		return empCat;
	}
	public void setEmpCat(EmploymentCategory empCat) {
		this.empCat = empCat;
	}
	public String getTaxId() {
		return taxId;
	}
	public void setTaxId(String taxId) {
		this.taxId = taxId;
	}
	public boolean isIndiaCitizen() {
		return indiaCitizen;
	}
	public void setIndiaCitizen(boolean indiaCitizen) {
		this.indiaCitizen = indiaCitizen;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	
	
	
	

}
