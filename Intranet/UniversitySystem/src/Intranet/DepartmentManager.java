package Intranet;

import java.io.Serializable;
import java.util.Date;

public class DepartmentManager extends Employee implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Faculty faculty;
	public DepartmentManager(String name, String surname, Gender gender, String phoneNumber, String email,
			Date birthday, Faculty faculty) {
		super(name, surname, gender, phoneNumber, email, birthday);
		this.faculty = faculty;
	}
	
	public boolean addCourseRegistration(String nameOfCourse) {
		for(Course course : Database.vectorForRegister) {
			if(course.getName().equals(nameOfCourse) && getFaculty().equals(course.getFacultyOfCourse())) {
				Database.vectorForRegister.add(course);
				return true;
			}
		}
		return false;
	}
	
	public boolean addNews(String title,String text) {
		News news = new News(title, text);
		Database.vectorOfNews.add(news);
		return true;
	}

	public boolean deleteNews(String title) {
		for(News news : Database.vectorOfNews) {
			if(news.getTitle().equals(title)) {
				Database.vectorOfNews.remove(news);
				return true;
			}
		}
		return false;
	}
	public String showNews() {
		String viewNews = null;
		for(News news : Database.vectorOfNews) {
			viewNews += news.toString() + '\n';
		}
		return viewNews;
	}
	public Faculty getFaculty() {
		return faculty;
	}
	
}
