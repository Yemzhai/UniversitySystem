package Intranet;

import java.io.Serializable;
import java.util.ArrayList;

public class Course implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private String description;
	private int amountOfCredits;
	private String pressMark;
	private ArrayList<Teacher> courseTeacher = new ArrayList<>();
	private ArrayList<Student> listStudents = new ArrayList<>();
	private Faculty facultyOfCourse;
	
	public Course(String name, String description, int amountOfCredits, String pressMark) {
		super();
		this.name = name;
		this.description = description;
		this.amountOfCredits = amountOfCredits;
		this.pressMark = pressMark;
	}
	public Faculty getFacultyOfCourse() {
		return this.facultyOfCourse;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getAmountOfCredits() {
		return amountOfCredits;
	}
	public void setAmountOfCredits(int amountOfCredits) {
		this.amountOfCredits = amountOfCredits;
	}
	public String getPressMark() {
		return pressMark;
	}
	public void setPressMark(String pressMark) {
		this.pressMark = pressMark;
	}
	public ArrayList<Student> getListStudents() {
		return listStudents;
	}
	public void setListStudents(ArrayList<Student> listStudents) {
		this.listStudents = listStudents;
	}
	public ArrayList<Teacher> getCourseTeacher() {
		return courseTeacher;
	}
	public void setCourseTeacher(ArrayList<Teacher> courseTeacher) {
		this.courseTeacher = courseTeacher;
	}
	public String toString() {
		return "Name: " + this.name + " " + "Amount of credits: " + this.amountOfCredits + " " + "Press mark: " + this.pressMark + " " + "Description: " + this.description;
	}
	
	
	
}
