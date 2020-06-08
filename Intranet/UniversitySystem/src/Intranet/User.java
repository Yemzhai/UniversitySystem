package Intranet;

import java.io.Serializable;
import java.util.*;
public abstract class User implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	private String name;
	private String surname;
	private Gender gender;
	private String phoneNumber;
	private String email;
	private String ID;
	private Date birthday;
	private static int cnt;
	{
		cnt++;
	}
	public User(String name, String surname, Gender gender, String phoneNumber,
			String email, Date birthday) {
		super();
		this.name = name;
		this.surname = surname;
		this.gender = gender;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.birthday = birthday;
		this.username = giveUsername();
		this.password = "kbtu111";
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", name=" + name + ", surname=" + surname
				+ ", gender=" + gender + ", phoneNumber=" + phoneNumber + ", email=" + email + ", ID=" + ID
				+ ", birthday=" + birthday + "]";
	}
	private static String giveUsername() {
		return "username_" + cnt;
	}
	
}
