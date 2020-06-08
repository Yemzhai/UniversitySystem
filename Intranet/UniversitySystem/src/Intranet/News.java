package Intranet;

import java.io.Serializable;

public class News implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String title;
	private String text;
	
	public News(String title,String text) {
		this.title=title;
		this.text=text;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getText() {
		return text;
	}
	//@override
	public String toString() {
		return this.title + ": " + '\n' + this.text;
	}
}
