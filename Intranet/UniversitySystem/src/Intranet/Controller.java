package Intranet;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
public class Controller implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Mode mode;
	private static Admin admin;
	private static User user;
	private static Teacher teacher;
	private static Student student;
	private static DepartmentManager departmentManager;
	private static ORManager orManager;
	private static Executor executor;
	//single Scanner
	private static final Scanner sc = new Scanner(System.in);
	//Start of the system
	
	public Controller() {
		Database.loadData();
	}
	public void begin() throws Throwable {
		// process of choosing mode for system
		int modeForSystem = 0;
		while(modeForSystem!=1 && modeForSystem != 2) {
			System.out.println("Choose one of two:" + '\n' + "1.Enter like USER" + '\n' + "2.Enter like ADMIN" + '\n' + "Please, write 1 or 2");
			modeForSystem = sc.nextInt();
		}
		if(modeForSystem==1 || modeForSystem==2) {
			System.out.println("Username: ");
			String username = sc.next();
			System.out.println("Password: ");
			String password = sc.next();
			switch(modeForSystem) {
			case 1:
				enterLikeUser(username, password);
				break;
			case 2:
				enterLikeAdmin(username, password);
				break;
			}
		}
		Database.saveData();
	}
	private static void enterLikeAdmin(String username, String password) throws Exception {
		admin = new Admin();
		while(!admin.checkAdminData(username, password)) {
			System.out.println("Wrong username or password, please, try again");
			System.out.println("Username: ");
			String usernameForMistake = sc.next();
			System.out.println("Password: ");
			String passwordForMistake = sc.next();
			username = usernameForMistake;
			password = passwordForMistake;
		}
		if(admin.checkAdminData(username, password)){
			int selecter = 0;
			while(selecter!=5) { 
				System.out.println("1. Add user to the University System");
				System.out.println("2. Remove user from the University System");
				System.out.println("3. Change user's datas");
				System.out.println("4. See log file");
				System.out.println("5. Exit");
				System.out.println("Please, choose 1, 2, 3, 4, 5");
				selecter = sc.nextInt(); 
				switch(selecter) {		
					case 1:	int selecterMode = 0;
							while(selecterMode!=6) {
								System.out.println("Choose one of the five");
								System.out.println("1. Add student");
								System.out.println("2. Add teacher");
								System.out.println("3. Add department manager");
								System.out.println("4. Add OR manager");
								System.out.println("5. Add executor");
								System.out.println("6. Exit");
								selecterMode = sc.nextInt();// to this moment program works;
								switch(selecterMode) {
									case 1: student = (Student) enterData("student");
											if(admin.addUsers(student, "student")) 
												System.out.println("Student is added");
											else System.out.println("error");
											break;
									case 2: teacher = (Teacher)enterData("teacher");
											if(admin.addUsers(teacher, "teacher"))
												System.out.println("Teacher is added");
											break;
									case 3: departmentManager = (DepartmentManager)enterData("departmentmanager");
											if(admin.addUsers(departmentManager, "departmentmanager"))
												System.out.println("Department Manager is added");
											else System.out.println("Error");
											break;
									case 4: orManager = (ORManager)enterData("ormanager");
											if(admin.addUsers(orManager, "ormanager"))
												System.out.println("OR Manager is added");
											else System.out.println("Error");
											break;
									case 5: executor = (Executor)enterData("executor");
											if(admin.addUsers(executor, "executor"))
												System.out.println("Executor is added");
											else System.out.println("Error");
											break;
								}
							}
							break;
							// TO DO
					case 2: int selecterModeForRemoveUsers = 0;
							while(selecterModeForRemoveUsers!=6) {
								System.out.println("Choose one of the five");
								System.out.println("1. Remove student");
								System.out.println("2. Remove teacher");
								System.out.println("3. Remove department manager");
								System.out.println("4. Remove OR manager");
								System.out.println("5. Remove executor");
								System.out.println("6. Exit");
								selecterMode = sc.nextInt();
								switch(selecterModeForRemoveUsers) {
								case 1: 
								}
							}
							break;
					case 3: for(int i = 0; i < admin.seeLogFiles().size(); i++) {
								System.out.println(admin.seeLogFiles().get(i));
							}
							break;
					case 4: System.out.println(admin.seeLogFiles());
							break;
				}
			}
			
		}
	}
	private static void enterLikeUser(String username, String password) {
		Vector<User> vectorOfAllUsers = new Vector<>();
		System.out.println(vectorOfAllUsers.size());
		vectorOfAllUsers.addAll(Database.vectorOfStudent);
		vectorOfAllUsers.addAll(Database.vectorOfDepartmentManager);
		vectorOfAllUsers.addAll(Database.vectorOfTeacher);
		vectorOfAllUsers.addAll(Database.vectorOfOrManager);
		vectorOfAllUsers.addAll(Database.vectorOfExecutor);
		boolean found = false;
		for(User u : vectorOfAllUsers) {
			if(u.getUsername().equals(username) && u.getPassword().equals(password)) {
				user = u;
				System.out.println(u.getUsername());
				System.out.println(u.getPassword());
				found = true;
			}
		}
		while(!found) {
			System.out.println("Wrong username or password, please, try again");
			System.out.println("Username: ");
			String usernameForMistake = sc.next();
			System.out.println("Password: ");
			String passwordForMistake = sc.next();
			for(User u : vectorOfAllUsers) {
				if(u.getUsername().equals(usernameForMistake) && u.getPassword().equals(passwordForMistake)) {
					user = u;
					found = true;
				}
			}
		}
		switch(user.getClass().toString().split(" ")[1]) {
		case "Intranet.Student":
			EnterUser.sessionStudent(user);
			break;
		case "Intranet.Teacher":
			EnterUser.sessionTeacher(user);
			break;
		case "Intranet.Departmentmanager":
			EnterUser.sessionDepartmentManager(user);
			break;
		case "Intranet.Ormanager":
			EnterUser.sessionOrManager(user);
			break;
		case "Intranet.Executor":
			EnterUser.sessionExecutor(user);
			break;
		}
	}
	// converter from string to gender
	// works 100%
	private static Gender getGender(String gender) {
		if(gender.toLowerCase().equals("male")) return Gender.MALE;
		else return Gender.FEMALE;
	}
	// converter from string to enumiration faculty
	// works 100%
	private static Faculty getFaculty(String faculty) {
		if(faculty.toLowerCase().equals("fit")) return Faculty.FIT;
		else if(faculty.toLowerCase().equals("bs")) return Faculty.BS;
		else if(faculty.toLowerCase().equals("kma")) return Faculty.KMA;
		else if(faculty.toLowerCase().equals("smc")) return Faculty.SMC;
		else if(faculty.toLowerCase().equals("ise")) return Faculty.ISE;
		else return Faculty.EOGS;
	}
	// for enter data of user when admin add the user
	// works 100%
	private static User enterData(String type) throws ParseException {
		System.out.println("Surname: ");
		String surname = sc.next();
		System.out.println("Name: ");
		String name = sc.next();
		System.out.println("Male or Female: ");
		String gender = sc.next();
		Gender genderEnum = getGender(gender);
		System.out.println("Phone number: ");
		String phoneNumber = sc.next();
		System.out.println("Email: ");
		String email = sc.next();
		System.out.println("Birthday: ");
		String birthday = sc.next();
		Date dateBirthday=new SimpleDateFormat("dd/MM/yyyy").parse(birthday);
		if(type.equals("student")) {
			System.out.println("Year of study: ");
			int yearOfStudy = sc.nextInt();
			System.out.println("Entrance year: ");
			int entranceYear = sc.nextInt();
			System.out.println("Faculty: ");
			String faculty = sc.next();
			Faculty facultyEnum = getFaculty(faculty);
			if(phoneNumber.length()==12) {
				student = new Student(name, surname, genderEnum, phoneNumber, email, dateBirthday, yearOfStudy, entranceYear, facultyEnum);
			}
			return student;
		}
		else if(type.equals("teacher")) {
			teacher = new Teacher(name, surname, genderEnum, phoneNumber, email, dateBirthday);
			return teacher;
		}
		else if(type.equals("departmentmanager")) {
			System.out.println("Faculty: ");
			String faculty = sc.next();
			Faculty facultyEnum = getFaculty(faculty);
			departmentManager = new DepartmentManager(name, surname, genderEnum, phoneNumber, email, dateBirthday, facultyEnum);
			return departmentManager;
		}
		else if(type.equals("ormanager")) {
			orManager = new ORManager(name, surname, genderEnum, phoneNumber, email, dateBirthday);
			return orManager;
		}
		else {
			executor = new Executor(name, surname, genderEnum, phoneNumber, email, dateBirthday);
			return executor;
		}
		
	}
}
