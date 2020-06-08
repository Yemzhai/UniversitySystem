package Intranet;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;

public class Database implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static  Vector<Student> vectorOfStudent = new Vector<>();
	public static Vector<Teacher> vectorOfTeacher = new Vector<>();
	public static Vector<DepartmentManager> vectorOfDepartmentManager = new Vector<>();
	public static Vector<ORManager> vectorOfOrManager = new Vector<>();
	public static Vector<Executor> vectorOfExecutor = new Vector<>();
	public static Vector<Course> vectorOfCourses = new Vector<>();
	
	public static Vector<News> vectorOfNews = new Vector<>();
	public static Vector<Course> vectorForRegister = new Vector<>();
	public static Vector<CourseFiles> vectorOfCourseFiles = new Vector<>();
	
	
	private static final String STUDENTS = "C:\\Users\\Bekzat Bekturgan\\Desktop\\Intranet\\UniversitySystem\\students.txt";
	private static final String TEACHERS = "C:\\Users\\Bekzat Bekturgan\\Desktop\\Intranet\\UniversitySystem\\teachers.txt";
	private static final String DEPARTMENTMANAGERS = "C:\\Users\\Bekzat Bekturgan\\Desktop\\Intranet\\UniversitySystem\\departmentManagers.txt";
	private static final String ORMANAGERS = "C:\\Users\\Bekzat Bekturgan\\Desktop\\Intranet\\UniversitySystem\\ormanagers.txt";
	private static final String EXECUTORS = "C:\\Users\\Bekzat Bekturgan\\Desktop\\Intranet\\UniversitySystem\\executors.txt";
	private static final String COURSES = "C:\\Users\\Bekzat Bekturgan\\Desktop\\Intranet\\UniversitySystem\\courses.txt";
	private static final String NEWS = "C:\\Users\\Bekzat Bekturgan\\Desktop\\Intranet\\UniversitySystem\\news.txt";
	private static final String REGISTRATIONCOURSES = "C:\\Users\\Bekzat Bekturgan\\Desktop\\Intranet\\UniversitySystem\\registrationcourses.txt";
	private static final String COURSEFILES = "C:\\Users\\Bekzat Bekturgan\\Desktop\\Intranet\\UniversitySystem\\coursefiles.txt";
	private static final String	ORDERS = "C:\\Users\\Bekzat Bekturgan\\Desktop\\Intranet\\UniversitySystem\\orders.txt";
	
	/*
	public Vector<Student> vectorOfNonStaticStudent;
	public void convertFromStatic() {
		for(Student student : vectorOfStudent) {
			vectorOfNonStaticStudent.add(student);
		}
		Vector<Teacher> vectorOfNonStaticTeacher = null;
		for(Teacher teacher : vectorOfTeacher) {
			vectorOfNonStaticTeacher.add(teacher);
		}
		Vector<DepartmentManager> vectorOfNonStaticDepartmentManager = null;
		for(DepartmentManager departmentManager : vectorOfDepartmentManager) {
			vectorOfNonStaticDepartmentManager.add(departmentManager);
		}
		Vector<ORManager> vectorOfNonStaticOrManager = null;
		for(ORManager orManager : vectorOfOrManager) {
			vectorOfNonStaticOrManager.add(orManager);
		}
		Vector<Executor> vectorOfNonStaticExecutor = null;
		for(Executor executor : vectorOfExecutor) {
			vectorOfNonStaticExecutor.add(executor);
		}
	}*/
	// may change for to foreach
	/*public static boolean isUsernameExist(String username) throws NullPointerException {
		if(!vectorOfStudent.isEmpty()) {
			for(int i = 0; i < vectorOfStudent.size(); i++) {
				if(vectorOfStudent.get(i).getUsername().equals(username)) return false;
			}
		}
		if(!vectorOfTeacher.isEmpty()) {
			for(int i = 0; i < vectorOfTeacher.size(); i++) {
				if(vectorOfTeacher.get(i).getUsername().equals(username)) return false;
			}
		}
		if(!vectorOfDepartmentManager.isEmpty()) {
			for(int i = 0; i < vectorOfDepartmentManager.size(); i++) {
				if(vectorOfDepartmentManager.get(i).getUsername().equals(username)) return false;
			}
		}
		if(!vectorOfOrManager.isEmpty()) {
			for(int i = 0; i < vectorOfOrManager.size(); i++) {
				if(vectorOfOrManager.get(i).getUsername().equals(username)) return false;
			}
		}
		if(!vectorOfExecutor.isEmpty()) {
			for(int i = 0; i < vectorOfExecutor.size(); i++) {
				if(vectorOfExecutor.get(i).getUsername().equals(username)) return false;
			}
		}
		return true;
	}*/
	public static boolean isCourseExist(String courseName) {
		for(Course course: vectorOfCourses) {
			if(course.getName().equals(courseName)) return true;
		}
		return false;
	}
	
//  SERIALIZAION
    public static void saveData() {
        saveManagers();
        saveOrManagers();
        saveTeachers();
        saveStudents();
        saveExecutors();
        saveNews();
        saveCourseFiles();
        saveCoursesForRegistration();
        saveCourses();
        saveOrders();
    }
    private static void saveOrders() {
    	try {
            ObjectOutputStream oot = new ObjectOutputStream(new FileOutputStream(ORDERS));
            
            oot.writeObject(Employee.getOrdersArrayList());
            oot.flush();
            oot.close();
        }
        catch (FileNotFoundException e) {
            System.out.println(ORDERS + ": " + "File except");
        }
        catch (IOException e) {
            System.out.println(ORDERS + ": " + "File io");
        }
		
	}
    private static void saveCourses() {
    	try {
            ObjectOutputStream oot = new ObjectOutputStream(new FileOutputStream(COURSES));
            
            oot.writeObject(vectorOfCourses);
            oot.flush();
            oot.close();
        }
        catch (FileNotFoundException e) {
            System.out.println(COURSES + ": " + "File except");
        }
        catch (IOException e) {
            System.out.println(COURSES + ": " + "File io");
        }
		
	}
	private static void saveNews() {
        try {
            ObjectOutputStream oot = new ObjectOutputStream(new FileOutputStream(NEWS));
            
            oot.writeObject(vectorOfNews);
            oot.flush();
            oot.close();
        }
        catch (FileNotFoundException e) {
            System.out.println(NEWS + ": " + "File except");
        }
        catch (IOException e) {
            System.out.println(NEWS + ": " + "File io");
        }
    }
    private static void saveCourseFiles() {
        try {
            ObjectOutputStream oot = new ObjectOutputStream(new FileOutputStream(COURSEFILES));
            
            oot.writeObject(vectorOfCourseFiles);
            oot.flush();
            oot.close();
        }
        catch (FileNotFoundException e) {
            System.out.println(COURSEFILES + ": " + "File except");
        }
        catch (IOException e) {
            System.out.println(COURSEFILES + ": " + "File io");
        }
    }
    private static void saveCoursesForRegistration() {
        try {
            ObjectOutputStream oot = new ObjectOutputStream(new FileOutputStream(REGISTRATIONCOURSES));
            
            oot.writeObject(vectorForRegister);
            oot.flush();
            oot.close();
        }
        catch (FileNotFoundException e) {
            System.out.println(REGISTRATIONCOURSES + ": " + "File except");
        }
        catch (IOException e) {
            System.out.println(REGISTRATIONCOURSES + ": " + "File io");
        }
    }
    
    private static void saveStudents() {
        try {
            ObjectOutputStream oot = new ObjectOutputStream(new FileOutputStream(STUDENTS));
            
            oot.writeObject(vectorOfStudent);
            oot.flush();
            oot.close();
        }
        catch (FileNotFoundException e) {
            System.out.println(STUDENTS + ": " + "File except");
        }
        catch (IOException e) {
            System.out.println(STUDENTS + ": " + "File io");
        }
    }

    private static void saveTeachers() {
        try {
            ObjectOutputStream oot = new ObjectOutputStream(new FileOutputStream(TEACHERS));

            oot.writeObject(vectorOfTeacher);

            oot.flush();
            oot.close();
        }
        catch (FileNotFoundException e) {
            System.out.println(TEACHERS + ": " + "Except file");
        }
        catch (IOException e) {
            System.out.println(TEACHERS + ": " + "Except io");
        }
    }

    private static void saveManagers() {
        try {
            ObjectOutputStream oot = new ObjectOutputStream(new FileOutputStream(DEPARTMENTMANAGERS));

            oot.writeObject(vectorOfDepartmentManager);

            oot.flush();
            oot.close();
        }
        catch (FileNotFoundException e) {
            System.out.println(DEPARTMENTMANAGERS + ": " + "Except file");
        }
        catch (IOException e) {
            System.out.println(DEPARTMENTMANAGERS + ": " + "File io");
        }
    }

    private static void saveOrManagers() {
        try {
            ObjectOutputStream oot = new ObjectOutputStream(new FileOutputStream(ORMANAGERS));
            
            oot.writeObject(vectorOfOrManager);

            oot.flush();
            oot.close();
        }
        catch (FileNotFoundException e) {
            System.out.println(ORMANAGERS + ": " + "Except File");
        }
        catch (IOException e) {
            System.out.println(ORMANAGERS + ": " + "File io");
        }
    }

    private static void saveExecutors() {
        try {
            ObjectOutputStream oot = new ObjectOutputStream(new FileOutputStream(EXECUTORS));

            oot.writeObject(vectorOfExecutor);

            oot.flush();
            oot.close();
        }
        catch (FileNotFoundException e) {
            System.out.println(EXECUTORS + ": " + "File except");
        }
        catch (IOException e) {
            System.out.println(EXECUTORS + ": " + "File io");
        }
    }
//  DESERIALIZATION
    public static void loadData() {
        loadStudents();
        loadTeachers();
        loadExecutors();
        loadManagers();
        loadOrManagers();
        loadNews();
        loadCourses();
        loadCourseFiles();
        loadCoursesForRegistration();
        loadOrders();
        
    }

    private static void loadOrders() {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ORDERS));

            Employee.setOrdersArrayList((ArrayList<Orders>)ois.readObject());

            ois.close();

        }
        catch (ClassNotFoundException e) {
            System.out.println(ORDERS + ": " + "Class except");
        }
        catch (FileNotFoundException e) {
            System.out.println(ORDERS + ": " + "File except");
        }
        catch (IOException e) {
            System.out.println(ORDERS + ": " + "File io");
        }
    }

    private static void loadCoursesForRegistration() {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(REGISTRATIONCOURSES));

            vectorForRegister = (Vector<Course>) ois.readObject();

            ois.close();

        }
        catch (ClassNotFoundException e) {
            System.out.println(REGISTRATIONCOURSES + ": " + "Class except");
        }
        catch (FileNotFoundException e) {
            System.out.println(REGISTRATIONCOURSES + ": " + "File except");
        }
        catch (IOException e) {
            System.out.println(REGISTRATIONCOURSES + ": " + "File io");
        }
    }

    private static void loadCourseFiles() {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(COURSEFILES));

            vectorOfCourseFiles = (Vector<CourseFiles>) ois.readObject();

            ois.close();

        }
        catch (ClassNotFoundException e) {
            System.out.println(COURSEFILES + ": " + "Class except");
        }
        catch (FileNotFoundException e) {
            System.out.println(COURSEFILES + ": " + "File except");
        }
        catch (IOException e) {
            System.out.println(COURSEFILES + ": " + "File io");
        }
    }

    private static void loadCourses() {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(COURSES));

            vectorOfCourses = (Vector<Course>) ois.readObject();

            ois.close();

        }
        catch (ClassNotFoundException e) {
            System.out.println(COURSES + ": " + "Class except");
        }
        catch (FileNotFoundException e) {
            System.out.println(COURSES + ": " + "File except");
        }
        catch (IOException e) {
            System.out.println(COURSES + ": " + "File io");
        }
    }

    private static void loadNews() {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(NEWS));

            vectorOfNews = (Vector<News>) ois.readObject();

            ois.close();

        }
        catch (ClassNotFoundException e) {
            System.out.println(NEWS + ": " + "Class except");
        }
        catch (FileNotFoundException e) {
            System.out.println(NEWS + ": " + "File except");
        }
        catch (IOException e) {
            System.out.println(NEWS + ": " + "File io");
        }
    }

    private static void loadStudents() {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(STUDENTS));

            vectorOfStudent = (Vector<Student>) ois.readObject();

            ois.close();

        }
        catch (ClassNotFoundException e) {
            System.out.println(STUDENTS + ": " + "Class except");
        }
        catch (FileNotFoundException e) {
            System.out.println(STUDENTS + ": " + "File except");
        }
        catch (IOException e) {
            System.out.println(STUDENTS + ": " + "File io");
        }
    }

    private static void loadTeachers() {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(TEACHERS));

            vectorOfTeacher = (Vector<Teacher>) ois.readObject();

            ois.close();

        }
        catch (ClassNotFoundException e) {
            System.out.println(TEACHERS + ": " + "Class except");
        }
        catch (FileNotFoundException e) {
            System.out.println(TEACHERS + ": " + "File Except");
        }
        catch (IOException e) {
            System.out.println(TEACHERS + ": " + "File io");
        }
    }

    private static void loadManagers() {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(DEPARTMENTMANAGERS));

            vectorOfDepartmentManager = (Vector<DepartmentManager>) ois.readObject();

            ois.close();
        }
        catch (ClassNotFoundException e) {
            System.out.println(DEPARTMENTMANAGERS + ": " + "class except");
        }
        catch (FileNotFoundException e) {
            System.out.println(DEPARTMENTMANAGERS + ": " + "file except");
        }
        catch (IOException e) {
            System.out.println(DEPARTMENTMANAGERS + ": " + "file io");
        }
    }

    private static void loadOrManagers() {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ORMANAGERS));

            vectorOfOrManager = (Vector<ORManager>) ois.readObject();

            ois.close();

        }
        catch (ClassNotFoundException e) {
            System.out.println(ORMANAGERS + ": " + "class except");
        }
        catch (FileNotFoundException e) {
            System.out.println(ORMANAGERS + ": " + "file except");
        }
        catch (IOException e) {
            System.out.println(ORMANAGERS + ": " + "file io");
        }
    }

    private static void loadExecutors() {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(EXECUTORS));

            vectorOfExecutor = (Vector<Executor>) ois.readObject();

            ois.close();

        }
        catch (ClassNotFoundException e) {
            System.out.println(EXECUTORS + ": " + "class except");
        }
        catch (FileNotFoundException e) {
            System.out.println(EXECUTORS + ": " + "file except");
        }
        catch (IOException e) {
            System.out.println(EXECUTORS + ": " + "file io");
        }
    }
    

    /*
	public static void start() throws Throwable, NullPointerException {
		
		vectorOfStudent = Serialize.deserialize(FileOperation.Reader(STUDENTS));
		vectorOfTeacher = Serialize.deserialize(FileOperation.Reader(TEACHERS));
		vectorOfOrManager =	Serialize.deserialize(FileOperation.Reader(ORMANAGERS));
		vectorOfDepartmentManager = Serialize.deserialize(FileOperation.Reader(DEPARTMENTMANAGERS));
		vectorOfExecutor = Serialize.deserialize(FileOperation.Reader(EXECUTORS));
		vectorOfCourses = Serialize.deserialize(FileOperation.Reader(COURSES));
		*/
    /*
		vectorOfStudent = (Vector<Student>)FileOperation.studentReader(STUDENTS);
		vectorOfTeacher = (Vector<Teacher>)FileOperation.teacherReader(TEACHERS);
		vectorOfOrManager = (Vector<ORManager>)FileOperation.orManagerReader(ORMANAGERS);
		vectorOfDepartmentManager = (Vector<DepartmentManager>)FileOperation.departmentManagerReader(DEPARTMENTMANAGERS);
		vectorOfExecutor = (Vector<Executor>)FileOperation.executorReader(EXECUTORS);
		vectorOfCourses = (Vector<Course>)FileOperation.courseReader(COURSES);
	}*/
	
}


