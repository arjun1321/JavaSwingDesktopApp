import java.sql.SQLException;

import model.AgeCategory;
import model.Database;
import model.EmploymentCategory;
import model.Gender;
import model.Person;


public class TestDatabase {

	public static void main(String[] args) {
		System.out.println("Running database");
		Database db = new Database();
		
		try {
			db.connect();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		db.addPerson(new Person("Arjun kumar", "developer", AgeCategory.adult, EmploymentCategory.employed,
				"1111", true, Gender.male));
		db.addPerson(new Person("Geeta gupta", "game developer", AgeCategory.adult, EmploymentCategory.selfEmployed,
				null, true, Gender.female));
		
		try {
			db.save();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			db.load();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		db.disConnect();

	}

}
