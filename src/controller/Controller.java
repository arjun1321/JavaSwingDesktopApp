package controller;

import java.util.List;

import model.AgeCategory;
import model.Database;
import model.EmploymentCategory;
import model.Gender;
import model.Person;
import gui.FormEvent;

public class Controller {
	Database db = new Database();
	public List<Person> getPeople() {
		return db.getPeople();
	}
	
	public void addPerson(FormEvent ev) {
		String name = ev.getName();
		String occupation = ev.getOccupation();
		int ageCat = ev.getAgeCategory();
		String empCat = ev.getEmploymentCategory();
		boolean isIndia = ev.isIndiaCitizen();
		String taxId = ev.getTaxId();
		String gender = ev.getGender();
		
		AgeCategory ageCategory = null;
		
		switch(ageCat) {
		case 0: 
			ageCategory = AgeCategory.child;
			break;
		case 1:
			ageCategory = AgeCategory.adult;
			break;
		case 2:
			ageCategory = AgeCategory.senior;
			break;
		}
		
		EmploymentCategory empCategory;
		if(empCat.equals("employed"))
			empCategory = EmploymentCategory.employed;
		else if(empCat.equals("self-employed"))
			empCategory = EmploymentCategory.selfEmployed;
		else if(empCat.equals("unemployed"))
			empCategory = EmploymentCategory.unEmployed;
		else {
			empCategory = EmploymentCategory.other;
			System.err.println(empCat);
		}
			
		Gender genderCat;
		if(gender.equals("male"))
			genderCat = Gender.male;
		else genderCat = Gender.female;
		
		
		Person person = new Person(name, occupation, ageCategory, empCategory, taxId, isIndia, genderCat);
		db.addPerson(person);
	}
}
