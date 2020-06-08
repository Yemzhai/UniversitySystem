package Intranet;

import java.io.Serializable;
import java.util.Date;

public class ORManager extends Employee implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ORManager(String name, String surname, Gender gender, String phoneNumber, String email, Date birthday) {
		super(name, surname, gender, phoneNumber, email, birthday);
	}
	/*public boolean constructExamSchedule() {
		
	}*/
}
