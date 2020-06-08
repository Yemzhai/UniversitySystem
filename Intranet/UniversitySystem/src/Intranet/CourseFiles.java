package Intranet;

import java.io.Serializable;

public class CourseFiles implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String courseName;
	private String nameOfCourseFile;
	private String data;
	public CourseFiles(String courseName, String nameOfCourseFile, String data) {
		super();
		this.courseName = courseName;
		this.nameOfCourseFile = nameOfCourseFile;
		this.data = data;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getNameOfCourseFile() {
		return nameOfCourseFile;
	}
	public void setNameOfCourseFile(String nameOfCourseFile) {
		this.nameOfCourseFile = nameOfCourseFile;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "CourseFiles [courseName=" + courseName + ", nameOfCourseFile=" + nameOfCourseFile + ", data=" + data
				+ "]";
	}
	
}
