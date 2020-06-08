package Intranet;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Vector;


public abstract class FileOperation {
	
	public static ArrayList<String> BufferedReader(String adminPath) {
		ArrayList<String> logFiles = new ArrayList<String>();
		try {
			BufferedReader br = new BufferedReader(new FileReader(adminPath));
			String readerLogFiles;
			while((readerLogFiles = br.readLine())!=null){
				logFiles.add(readerLogFiles);
			}
			br.close();
		}
		catch(Exception e) {
			
		}
		return logFiles;
	}
	/*
	public static boolean writerLogFiles(User u) {
		
	}*/
	public static boolean Writer(Vector v, String path) {
		try {
			FileOutputStream file = new FileOutputStream(path);
			ObjectOutputStream out = new ObjectOutputStream(file);
			out.writeObject(v);
			out.close();
			file.close();
			return true;
		}
		catch(IOException ex) {
			return false;
		}
	}
	public static Vector<Student> studentReader(String path) throws ClassNotFoundException, NullPointerException{
		Vector<Student> student = null;
		try {
			FileInputStream file = new FileInputStream(path);
			ObjectInputStream in = new ObjectInputStream(file);
			student = (Vector<Student>) in.readObject();
			in.close();
			file.close();
		}
		catch(IOException ex) {
			
		}
		return student;
	}
	
	public static Vector<Teacher> teacherReader(String path) throws ClassNotFoundException, NullPointerException{
		Vector<Teacher> teacher = null;
		try {
			FileInputStream file = new FileInputStream(path);
			ObjectInputStream in = new ObjectInputStream(file);
			teacher = (Vector<Teacher>) in.readObject();
			in.close();
			file.close();
		}
		catch(IOException ex) {
			
		}
		return teacher;
	}
	
	public static Vector<ORManager> orManagerReader(String path) throws ClassNotFoundException{
		Vector<ORManager> orManager = null;
		try {
			FileInputStream file = new FileInputStream(path);
			ObjectInputStream in = new ObjectInputStream(file);
			orManager = (Vector<ORManager>) in.readObject();
			in.close();
			file.close();
		}
		catch(IOException ex) {
			
		}
		return orManager;
	}
	
	public static Vector<DepartmentManager> departmentManagerReader(String path) throws ClassNotFoundException{
		Vector<DepartmentManager> departmentManager = null;
		try {
			FileInputStream file = new FileInputStream(path);
			ObjectInputStream in = new ObjectInputStream(file);
			departmentManager = (Vector<DepartmentManager>) in.readObject();
			in.close();
			file.close();
		}
		catch(IOException ex) {
			
		}
		return departmentManager;
	}
	public static Vector<Executor> executorReader(String path) throws ClassNotFoundException{
		Vector<Executor> executor = null;
		try {
			FileInputStream file = new FileInputStream(path);
			ObjectInputStream in = new ObjectInputStream(file);
			executor = (Vector<Executor>) in.readObject();
			in.close();
			file.close();
		}
		catch(IOException ex) {
			
		}
		return executor;
	}
	public static Vector<Course> courseReader(String path) throws ClassNotFoundException{
		Vector<Course> course = null;
		try {
			FileInputStream file = new FileInputStream(path);
			ObjectInputStream in = new ObjectInputStream(file);
			course = (Vector<Course>) in.readObject();
			in.close();
			file.close();
		}
		catch(IOException ex) {
			
		}
		return course;
	}
	
	
}
