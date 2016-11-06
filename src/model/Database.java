package model;

import java.io.File;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Collections;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import java.sql.Connection;

public class Database {
	private List<Person> people;
	private java.sql.Connection con;
	
	public Database() {
		people = new LinkedList<Person>();
	}
	
	public void addPerson(Person person) {
		people.add(person);
	}
	
	public void removePerson(int index) {
		people.remove(index);
	}
	
	public void connect() throws Exception {
		if(con != null) return;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new Exception("Driver not found");
		}
		
		String url = "jdbc:mysql://localhost:3306/swingtest";
		con = DriverManager.getConnection(url, "root", "");
		
		System.out.println("Connected: " + con);
	}
	
	public void disConnect() {
		if(con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				System.out.println("can't close connection");
			}
		}
	}
	
	public List<Person> getPeople() {
		return (List<Person>) Collections.unmodifiableList(people);
	}
	
	public void saveToFile(File file) throws IOException {
		FileOutputStream fos = new FileOutputStream(file);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		Person[] persons = people.toArray(new Person[people.size()]);
		oos.writeObject(persons);
		oos.close();
	}
	
	public void loadFromFile(File file) throws IOException {
		FileInputStream fis = new FileInputStream(file);
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		try {
			Person[] person = (Person[]) ois.readObject();
			people.clear();
			people.addAll(Arrays.asList(person));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		ois.close();
	}
}
