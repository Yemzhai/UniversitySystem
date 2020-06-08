package Intranet;

import java.util.Vector;

public interface SearchStudents {
	
	Student searchByUsername(String username);
	Student searchByID(String ID);
	Vector<Student> searchBySurname(String surname);
	Vector<Student> searchByName(String name);
	Vector<Student> searchBySurnameAndName(String surname, String name);
}
