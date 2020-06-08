package Intranet;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Vector;

public class Transcript implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private HashMap<Course, Mark> journal = new HashMap<Course, Mark>();
	
	public HashMap<Course, Mark> getJournal() {
		return journal;
	}
	
	public void setJournal(HashMap<Course, Mark> journal) {
		this.journal = journal;
	}

	
}
