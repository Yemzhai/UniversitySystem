package Intranet;
import java.io.Serializable;
import java.util.*;

public class Student extends User implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int yearOfStudy;
	private int entranceYear;
	private Faculty facultyOfStudent;
	private Transcript transcript;
	public ArrayList<Course> passedCourses = new ArrayList<Course>();
	public ArrayList<Course> currentCourses = new ArrayList<Course>();
	public ArrayList<Course> expectedCourses = new ArrayList<Course>();
	
	
	public Student(String name, String surname, Gender gender, String phoneNumber, String email, Date birthday,
			int yearOfStudy, int entranceYear, Faculty facultyOfStudent) {
		super(name, surname, gender, phoneNumber, email, birthday);
		this.yearOfStudy = yearOfStudy;
		this.entranceYear = entranceYear;
		this.facultyOfStudent = facultyOfStudent;
	}
	public String viewCoursesForRegistration() {
		String registrationCourses = null;
		for(Course course : Database.vectorForRegister) {
			if(course.getFacultyOfCourse().equals(this.facultyOfStudent))
				registrationCourses += course.toString();
		}
		return registrationCourses;
	}
	public boolean registorForCourses(String courseName) {
		for(Course course : Database.vectorForRegister) {
			if(course.getFacultyOfCourse().equals(this.facultyOfStudent)) {
				expectedCourses.add(course);
				return true;
			}
		}
		return false;
	}
	public String viewCourseFiles(String courseName) {
		String courseFiles = null;
		for(CourseFiles courseFile : Database.vectorOfCourseFiles) {
			if(courseFile.getCourseName().equals(courseName)) {
				courseFiles+=courseFile.toString() + '\n';
			}
		}
		return courseFiles;
	}
	@Override
	public String toString() {
		return "Surname: " + getSurname() + " Name: " + getName() + " Year of Study: " + yearOfStudy + " Faculty: " + facultyOfStudent;
	}

	public int getYearOfStudy() {
		return yearOfStudy;
	}

	public void setYearOfStudy(int yearOfStudy) {
		this.yearOfStudy = yearOfStudy;
	}

	public int getEntranceYear() {
		return entranceYear;
	}

	public void setEntranceYear(int entranceYear) {
		this.entranceYear = entranceYear;
	}

	public Faculty getFacultyOfStudent() {
		return facultyOfStudent;
	}

	public void setFacultyOfStudent(Faculty facultyOfStudent) {
		this.facultyOfStudent = facultyOfStudent;
	}

	public Transcript getTranscript() {
		return transcript;
	}

	public void setTranscript(Transcript transcript) {
		this.transcript = transcript;
	}
	// this method show only passed courses
	public String showTranscript() {
		String viewTranscript = null;
		int sumOfCredits = 0;
		double totalGPA = 0;
		for(Course course : passedCourses) {
			sumOfCredits+=course.getAmountOfCredits();
			totalGPA+=(double)course.getAmountOfCredits() * transcript.getJournal().get(course).getTotal();
			viewTranscript+=course.getPressMark() + " " + course.getName() + " " + course.getAmountOfCredits() + 
					transcript.getJournal().get(course).getTotal() + " " + transcript.getJournal().get(course).charGrade() + " " + 
					transcript.getJournal().get(course).getGPA() + '\n';
		}
		viewTranscript+="Taken " + sumOfCredits + ". GPA" + totalGPA/sumOfCredits + '\n';
		return viewTranscript;
	}
	// show marks of current courses (view of attestation in one semester)
	public String showMarksOfCurrentCourses() {
		String viewMarks = null;
		for(Course course : currentCourses) {
			viewMarks+=course.getName() + " " + transcript.getJournal().get(course).getFirstAttestation() + " " + 
		transcript.getJournal().get(course).getSecondAttestation() + " " +  transcript.getJournal().get(course).getFinalScore() + '\n';		
		}
		return viewMarks;
	}
	// information about teachers when you click one courses
	public String viewInfoAboutTeacher(String NameOfSpecificCourse) {
		String informationAboutTeacher = null;
		for(Course course : passedCourses) {
			if(course.getName().equals(NameOfSpecificCourse)) {
				for(Teacher teacher : course.getCourseTeacher()) {
					informationAboutTeacher += teacher.toString() + '\n';
				}
			}
		}
		for(Course course : currentCourses) {
			if(course.getName().equals(NameOfSpecificCourse)) {
				for(Teacher teacher : course.getCourseTeacher()) {
					informationAboutTeacher += teacher.toString() + '\n';
				}
			}
		}
		for(Course course : expectedCourses) {
			if(course.getName().equals(NameOfSpecificCourse)) {
				for(Teacher teacher : course.getCourseTeacher()) {
					informationAboutTeacher += teacher.toString() + '\n';
				}
			}
		}
		return informationAboutTeacher;
	}
	
}
