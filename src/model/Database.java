package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Database {

	private List<Person> people;
	private Connection con;
	
	public Database() {
		people = new LinkedList<Person>();
	}
	
	public void add(Person person) {
		people.add(person);
		
	}
	
	public void removePerson(int index) {
		people.remove(index);
	}
	
	public List<Person> getPeople() {
		return people;
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
			Person[] persons = (Person[]) ois.readObject();
			
			people.clear();
			
			people.addAll(Arrays.asList(persons));
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ois.close();
		
	}

	public void connect() throws Exception {
		// TODO Auto-generated method stub
		if (con != null) {
			return;
		}
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			throw new Exception("Driver not found");
		}
		
		String url = "jdbc:mysql://localhost:3306/swingtest";
		
		con = DriverManager.getConnection(url, "swingtest", "swingtestpassword");
		
	}

	public void disconnect() {
		// TODO Auto-generated method stub
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				System.out.println("Cannot close connection");
			}
		}
	}
	
	public void save() throws SQLException {
		String checkSql =  "select count(*) as count from people where id=?";
		
		PreparedStatement checkStmt =  con.prepareStatement( checkSql );
		
		for (Person person: people) {
			int id = person.getId();
			
			checkStmt.setInt(1, id); 
			
			ResultSet checkResult = checkStmt.executeQuery();
			checkResult.next();
			
			int count = checkResult.getInt(1);
			
			System.out.println("Count for person with ID " + id + " is " + count);
		}
		
		checkStmt.close();
	}
	
}
