package Intranet;
import java.io.Serializable;
import java.util.*;
public class Teacher extends Employee implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Course> teacherCourses = new ArrayList<Course>();
	
	public Teacher(String name, String surname, Gender gender, String phoneNumber, String email, Date birthday) {
		super(name, surname, gender, phoneNumber, email, birthday);
		// TODO Auto-generated constructor stub
	}


	public ArrayList<Course> getTeacherCourses() {
		return teacherCourses;
	}


	public void setTeacherCourses(ArrayList<Course> teacherCourses) {
		this.teacherCourses = teacherCourses;
	}

	public String toString() {
		return getName() + " " + getSurname() + " " + getEmail();
	}
	public boolean addCourse(Course addedCourse) {
		if(!Database.isCourseExist(addedCourse.getName())) {
			Database.vectorOfCourses.add(addedCourse);
			teacherCourses.add(addedCourse);
			return true;
		}
		return false;
	}
	// show all courses that have in university system DONE*****
	public Vector<Course> viewCourses(){
		return Database.vectorOfCourses;
	}
	// show only teacher studied courses
	public ArrayList<Course> viewOwnCourses(){
		return teacherCourses;
	}
	// show list of students in one course
	public ArrayList<Student> showStudents(String courseName){
		ArrayList<Student> listOfStudents = null;
		for(Course c : teacherCourses) {
			if(c.getName().equals(courseName)) {
				listOfStudents = c.getListStudents();
			}
		}
		return listOfStudents;
	}
	public boolean addCourseFiles(String courseName, CourseFiles courseFiles) {
		for(Course course : teacherCourses) {
			if(course.getName().equals(courseName)) {
				Database.vectorOfCourseFiles.add(courseFiles);
				return true;
			}
		}
		return false;
	}
	// DONE WITHOUT EXCEPTIONS******************
	public boolean putMarks(String courseName, String studentUsername, String attestation, double grade) {
		for(Course c: teacherCourses) {
			if(c.getName().equals(courseName)) {
				for(Student s : c.getListStudents()) {
					if(s.getUsername().equals(studentUsername)) {
						if(attestation.equals("first")) {
							s.getTranscript().getJournal().get(c).setFirstAttestation(grade);
							return true;
						}	
						else if(attestation.equals("second")) {
							s.getTranscript().getJournal().get(c).setSecondAttestation(grade);
							return true;
						}
						else if(attestation.equals("final")) {
							s.getTranscript().getJournal().get(c).setFinalScore(grade);
							return true;
						}	
					}	
				}
			}
		}
		return false;
	}	
}
