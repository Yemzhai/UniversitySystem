package Intranet;
import java.io.Serializable;
import java.util.*;

public class Admin implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	private static final String adminPath = "C:\\Users\\Bekzat Bekturgan\\Desktop\\Intranet\\UniversitySystem\\adminPath.txt"; // логин, пароль для аккаунта админ
	private static final String pathLogFiles = "C:\\Users\\Bekzat Bekturgan\\Desktop\\Intranet\\UniversitySystem\\logFiles.txt"; // путь к log files
	
	
	// main methods of admin
	// add users DONE********************************
	public boolean addUsers(User user, String type){
		if(type.equals("student")) {
			Student student = (Student)user;
			if(!Database.vectorOfStudent.contains(student)) {
				Database.vectorOfStudent.add(student);
				return true;
			}
		}
		else if(type.equals("teacher")) {
			Teacher teacher = (Teacher)user;
			if(!Database.vectorOfTeacher.contains(teacher)) {
				Database.vectorOfTeacher.add(teacher);
				return true;
			}
		}
		else if(type.equals("ormanager")) {
			ORManager ormanager = (ORManager)user;
			if(!Database.vectorOfOrManager.contains(ormanager)) {
				Database.vectorOfOrManager.add(ormanager);
				return true;
			}
		}
		else if(type.equals("departmentmanager")) {
			DepartmentManager departmentManager = (DepartmentManager)user;
			if(!Database.vectorOfDepartmentManager.contains(departmentManager)) {
				Database.vectorOfDepartmentManager.add(departmentManager);
				return true;
			}
		}
		else if(type.equals("executor")) {
			Executor executor = (Executor)user;
			if(!Database.vectorOfExecutor.contains(executor)) {
				Database.vectorOfExecutor.add(executor);
				return true;
			}
		}
		return false;
	}
	// remove User DONE**************
	public boolean removeUsers(User user, String type) {
		if(type.equals("student")) {
			Student student = (Student)user;
			if(Database.vectorOfStudent.contains(student)) {
				Database.vectorOfStudent.remove(student);
				return true;
			}
		}
		else if(type.equals("teacher")) {
			Teacher teacher = (Teacher)user;
			if(Database.vectorOfTeacher.contains(teacher)) {
				Database.vectorOfTeacher.remove(teacher);
				return true;
			}
		}
		else if(type.equals("ormanager")) {
			ORManager ormanager = (ORManager)user;
			if(Database.vectorOfOrManager.contains(ormanager)) {
				Database.vectorOfOrManager.remove(ormanager);
				return true;
			}
		}
		else if(type.equals("departmentmanager")) {
			DepartmentManager departmentManager = (DepartmentManager)user;
			if(Database.vectorOfDepartmentManager.contains(departmentManager)) {
				Database.vectorOfDepartmentManager.remove(departmentManager);
				return true;
			}
		}
		else if(type.equals("executor")) {
			Executor executor = (Executor)user;
			if(Database.vectorOfExecutor.contains(executor)) {
				Database.vectorOfExecutor.remove(executor);
				return true;
			}
		}
		return false;
	}
	
	// TO DO******************
	/*public boolean setUsers(User user, String type) {
		if(type.equals("student")) {
			Student student = (Student)user;
			if(Database.isUsernameExist(student.getUsername())) {
				Database.vectorOfStudent
				return true;
			}
		}
		else if(type.equals("teacher")) {
			Teacher teacher = (Teacher)user;
			if(Database.isUsernameExist(teacher.getUsername())) {
				Database.vectorOfTeacher.remove(teacher);
				return true;
			}
		}
		else if(type.equals("ormanager")) {
			ORManager ormanager = (ORManager)user;
			if(Database.isUsernameExist(ormanager.getUsername())) {
				Database.vectorOfOrManager.remove(ormanager);
				return true;
			}
		}
		else if(type.equals("departmentmanager")) {
			DepartmentManager departmentManager = (DepartmentManager)user;
			if(Database.isUsernameExist(departmentManager.getUsername())) {
				Database.vectorOfDepartmentManager.remove(departmentManager);
				return true;
			}
		}
		else if(type.equals("executor")) {
			Executor executor = (Executor)user;
			if(Database.isUsernameExist(executor.getUsername())) {
				Database.vectorOfExecutor.remove(executor);
				return true;
			}
		}
		return false;
	}
	*/
	// DONE************** // works 100%
	public ArrayList<String> seeLogFiles(){
		return FileOperation.BufferedReader(pathLogFiles);
	}
	
	
	// check username and password which given from console with single username and password
	// DONE****************
	public boolean checkAdminData(String username, String password){
		ArrayList<String> adminData = FileOperation.BufferedReader(adminPath);
		this.username = adminData.get(0);
		this.password =	adminData.get(1);
		
		if(this.username.equals(getHash(username)) && this.password.equals(getHash(password))) return true;
		return false;
	}
	
	
	// надо потом реализацию придумать
	private String getHash(String hashing) {
		String result = hashing;
		return result;
	}
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Admin other = (Admin) obj;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
	
	
	
	
}	
