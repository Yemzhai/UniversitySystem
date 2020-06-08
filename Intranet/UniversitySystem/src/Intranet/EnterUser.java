package Intranet;
import java.io.Serializable;
import java.util.*;

public abstract class EnterUser implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Scanner sc = new Scanner(System.in);
	public static void sessionStudent(User user) {
		Student student = (Student)user;
		System.out.println("You are logged as student!");
		int selecter = 0;
		while(selecter!=8) {
			System.out.println("1. Change password");
			System.out.println("2. View transcript");
			System.out.println("3. View journal");
			System.out.println("4. View information about teacher for specific course");
			System.out.println("5. View course files");
			System.out.println("6. View courses for registration");
			System.out.println("7. Registration for courses");
			System.out.println("8. Exit");
			selecter = sc.nextInt();
			switch(selecter) {
			case 1: System.out.println("Enter new password:");
					student.setPassword(sc.next());
					break;
			case 2: System.out.println(student.showTranscript());
					break;
			case 3: System.out.println(student.showMarksOfCurrentCourses());
					break;
			case 4: System.out.println("Enter name of the course");
					System.out.println(student.viewInfoAboutTeacher(sc.next()));
					break;
			case 5: System.out.println("Enter name of the course");
					System.out.println(student.viewCourseFiles(sc.next()));
					break;
			case 6: System.out.println(student.viewCoursesForRegistration());
					break;
			case 7: for(Course course : Database.vectorForRegister) {
						System.out.println(course.toString());
						System.out.println("Would you register for this course? (Please, enter Yes or No)");
						String desicion = sc.next().toLowerCase();
						if(desicion.equals("yes"))
							if(student.registorForCourses(course.getName()))
								System.out.println("Course added for registration");
					}
					break;
			}
		}
	}
	public static void sessionTeacher(User user) {
		Teacher teacher = (Teacher)user;
		System.out.println("You are logged as teacher!");
		int selecter = 0;
		while(selecter != 10) {
			System.out.println("1. Change password");
			System.out.println("2. View courses");
			System.out.println("3. View own courses");
			System.out.println("4. Add course");
			System.out.println("5. Put marks");
			System.out.println("6. View students");
			System.out.println("7. Search student");
			System.out.println("8. Send order to executor");
			System.out.println("9. Add course files");
			System.out.println("10. Exit");
			selecter = sc.nextInt();
			switch(selecter) {
			case 1: System.out.println("Enter new password");
					teacher.setPassword(sc.next());
					break;
			case 2: for(Course course : teacher.viewCourses()) {
						System.out.println(course.getName());
					}
			case 3:	for(Course course : teacher.viewOwnCourses()) {
						System.out.println(course.getName());
					}
			case 4: System.out.println("Enter name:");
					String courseName = sc.next();
					System.out.println("Description of the course");
					String description = sc.next();
					System.out.println("Enter amount of credits");
					int amountOfCredits = sc.nextInt();
					System.out.println("Enter pressmark");
					String pressMark = sc.next();
					if(teacher.addCourse(new Course(courseName, description, amountOfCredits, pressMark)))
						System.out.println("Course added");
					break;
			case 5:	System.out.println("Enter course name");
					String courseNameForMark = sc.next();
					System.out.println("Enter username of the student");
					String studentUsername = sc.next();
					System.out.println("Enter which attestation of final: (first), (second), (final)");
					String attestation = sc.next();
					System.out.println("Enter mark");
					double mark = sc.nextDouble();
					if(teacher.putMarks(courseNameForMark, studentUsername, attestation, mark))
						System.out.println("Mark is putted");
					break;
			case 6:	System.out.println("Enter course name");
					String courseNameForStudents = sc.next();
					for(Student student : teacher.showStudents(courseNameForStudents)) {
						System.out.println(student.getName() + " " + student.getSurname());
					}
					break;
			case 7:	int selecterForSearch = 0;
					while(selecter!=6) {
						System.out.println("1.Search by username");
						System.out.println("2. Search by ID");
						System.out.println("3. Search by name");
						System.out.println("4. Search by surname");
						System.out.println("5. Seacrh by surname and name");
						selecterForSearch = sc.nextInt();
						switch(selecterForSearch) {
						case 1: System.out.println("Enter username of the student");
								String usernameOfTheStudent = sc.next();
								System.out.println(teacher.searchByUsername(usernameOfTheStudent));
								break;
						case 2: System.out.println("Enter ID of the student");
								String id = sc.next();
								System.out.println(teacher.searchByID(id));
								break;
						case 3: System.out.println("Enter name of the student");
								String nameOfTheStudent = sc.next();
								for(Student student : teacher.searchByName(nameOfTheStudent)) {
									System.out.println(student.toString());
								}
								break;
						case 4: System.out.println("Enter surname of the student");
								String surnameOfTheStudent = sc.next();
								for(Student student : teacher.searchBySurname(surnameOfTheStudent)) {
									System.out.println(student.toString());
								}
								break;
						case 5: System.out.println("Enter surname of the student");
								String surname = sc.next();
								System.out.println("Enter name of the student");
								String name = sc.next();
								for(Student student : teacher.searchBySurnameAndName(surname, name)) {
									System.out.println(student.toString());
								}
								break;
						}
					}
			case 8:	System.out.println("Write your problem, please");
					String order = sc.next();
					if(teacher.sendOrderToExecutor(order)) System.out.println("Order is sended");
					break;
			case 9: System.out.println("Enter name of the course");
					String courseNameForCourseFiles = sc.next();
					System.out.println("Enter name of the course file");
					String courseFileName = sc.next();
					System.out.println("Load your file (in this program, please, write anything)");
					String data = sc.next();
					if(teacher.addCourseFiles(courseNameForCourseFiles, new CourseFiles(courseNameForCourseFiles, courseFileName, data)))
						System.out.println("Course file is added");
					break;
			}
		}
	}
	public static void sessionOrManager(User user) {
		ORManager orManager = (ORManager)user;
		System.out.println("You are logged as OR manager");
		int selecter = 0;
		while(selecter!=2) {
			System.out.println("1. Change password");
			System.out.println("2. Exit");
			selecter = sc.nextInt();
			switch(selecter) {
			case 1: System.out.println("Enter new password");
					orManager.setPassword(sc.next());
					break;
			}
		}
		
	}
	public static void sessionDepartmentManager(User user) {
		DepartmentManager departmentManager = (DepartmentManager)user;
		System.out.println("You are logged as Department Manager");
		int selecter = 0;
		while(selecter != 8) {
			System.out.println("1. Change password");
			System.out.println("2. Give courses for registration");
			System.out.println("3. Search students");
			System.out.println("4. Send order to exectutor");
			System.out.println("5. Send news");
			System.out.println("6. Show news");
			System.out.println("7. Delete news");
			System.out.println("8. Exit");
			selecter = sc.nextInt();
			switch(selecter) {
			case 1: System.out.println("Enter new password");
					departmentManager.setPassword(sc.next());
					break;
			case 2: 
			case 3:	int selecterForSearch = 0;
			while(selecter!=6) {		
				System.out.println("1.Search by username");
				System.out.println("2. Search by ID");
				System.out.println("3. Search by name");
				System.out.println("4. Search by surname");
				System.out.println("5. Seacrh by surname and name");
				selecterForSearch = sc.nextInt();
				switch(selecterForSearch) {
				case 1: System.out.println("Enter username of the student");
						String usernameOfTheStudent = sc.next();
						System.out.println(departmentManager.searchByUsername(usernameOfTheStudent));
						break;
				case 2: System.out.println("Enter ID of the student");
						String id = sc.next();
						System.out.println(departmentManager.searchByID(id));
						break;
				case 3: System.out.println("Enter name of the student");
						String nameOfTheStudent = sc.next();
						for(Student student : departmentManager.searchByName(nameOfTheStudent)) {
							System.out.println(student.toString());
						}
						break;
				case 4: System.out.println("Enter surname of the student");
						String surnameOfTheStudent = sc.next();
						for(Student student : departmentManager.searchBySurname(surnameOfTheStudent)) {
							System.out.println(student.toString());
						}
						break;
				case 5: System.out.println("Enter surname of the student");
						String surname = sc.next();
						System.out.println("Enter name of the student");
						String name = sc.next();
						for(Student student : departmentManager.searchBySurnameAndName(surname, name)) {
							System.out.println(student.toString());
						}
						break;
					}
				}
			case 4: System.out.println("Enter your order to the executor");
					departmentManager.sendOrderToExecutor(sc.next());
					break;
			case 5: System.out.println("Enter title of the news");
					String title = sc.next();
					System.out.println("Enter text of the news");
					String text = sc.next();
					if(departmentManager.addNews(title, text))
						System.out.println("News is added");
					break;
			case 6:	System.out.println(departmentManager.showNews());
					break;
			case 7: System.out.println(departmentManager.showNews());
					System.out.println("Enter title of the news which would you delete");
					String titleOfNews = sc.next();
					if(departmentManager.deleteNews(titleOfNews))
						System.out.println("News is deleted");
					break;
			}
		}
	}
	public static void sessionExecutor(User user) {
		Executor executor = (Executor)user;
		System.out.println("You are logged as Executor");
		int selecter = 0;
		while(selecter != 8) {
			System.out.println("1. View new orders");
			System.out.println("2. View accepted orders");
			System.out.println("3. View rejected orders");
			System.out.println("4. View done orders");
			System.out.println("5. Change password");
			System.out.println("6. Do order");
			System.out.println("7. Accept or reject new orders");
			System.out.println("8. Exit");
			selecter = sc.nextInt();
			switch(selecter) {
			case 1: for(Orders order : executor.viewNewOrder()) {
						System.out.println(order.toString());
					}
					break;
			case 2: for(Orders order : executor.viewAcceptedOrders()) {
						System.out.println(order.toString());
					}
					break;
			case 3: for(Orders order : executor.viewRejectedOrder()) {
						System.out.println(order.toString());
					}
					break;
			case 4: for(Orders order : executor.viewDoneOrders()) {
						System.out.println(order.toString());
					}
					break;
			case 5: System.out.println("Enter new password");
					executor.setPassword(sc.next());
					break;
			case 6: for(Orders order : executor.viewAcceptedOrders()) {
						System.out.println(order.toString());
					}
					System.out.println("Enter the name of the order");
					String nameOrder = sc.next();
					if(executor.doOrder(nameOrder))
						System.out.println("Order is done");
					break;
			case 7: for(Orders order : executor.viewNewOrder()) {
						System.out.println(order.toString());
						System.out.println("Would accept or reject this order? (Please, write accept or reject)");
						String decision = sc.next();
						if(decision.equals("accept")) {
							if(executor.acceptOrder(order.getProblemDescription())) {
								System.out.println("Order added to accepted orders");
							}
						}
						else if(decision.equals("reject")) {
							if(executor.rejectOrder(order.getProblemDescription())) {
								System.out.println("Order added to rejected orders");
							}
						}
					}
					break;
			}
		}
	}
}
