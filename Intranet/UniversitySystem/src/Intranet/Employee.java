package Intranet;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;

public abstract class Employee extends User implements SearchStudents, Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static ArrayList<Orders> orders = new ArrayList<Orders>();
	
	public Employee(String name, String surname, Gender gender, String phoneNumber, String email, Date birthday) {
		super(name, surname, gender, phoneNumber, email, birthday);
		// TODO Auto-generated constructor stub
	}

	public ArrayList<Orders> getOrders() {
		return orders;
	}

	public void setOrders(ArrayList<Orders> orders) {
		this.orders = orders;
	}

	@Override
	public Student searchByUsername(String username) {
		Student s = null;
		for(Student student : Database.vectorOfStudent) {
			if(student.getUsername().equals(username)) {
				s = student;
			}
		}
		return s;
	}

	@Override
	public Student searchByID(String ID) {
		Student s = null;
		for(Student student : Database.vectorOfStudent) {
			if(student.getID().equals(ID)) 
				s = student;
		}
		return s;
	}

	@Override
	public Vector<Student> searchBySurname(String surname) {
		Vector<Student> v = new Vector<Student>();
		for(Student student : Database.vectorOfStudent) {
			if(student.getSurname().equals(surname))
				v.add(student);
		}
		return v;
	}

	@Override
	public Vector<Student> searchByName(String name) {
		Vector<Student> v = new Vector<Student>();
		for(Student student : Database.vectorOfStudent) {
			if(student.getName().equals(name))
				v.add(student);
		}
		return v;
	}

	@Override
	public Vector<Student> searchBySurnameAndName(String surname, String name) {
		Vector<Student> v = new Vector<Student>();
		for(Student student : Database.vectorOfStudent) {
			if(student.getSurname().equals(surname) && student.getName().equals(name))
				v.add(student);
		}
		return v;
	}
	public boolean sendOrderToExecutor(String order) {
		orders.add(new Orders(order));
		return true;
	}
	
	public static ArrayList<Orders> getOrdersArrayList(){
		return orders;
	}
	public static void setOrdersArrayList(ArrayList<Orders> newOrders){
		orders = newOrders;
	}
	
}
