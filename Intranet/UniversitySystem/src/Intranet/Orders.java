package Intranet;

import java.io.Serializable;
import java.sql.Date;
import java.util.Calendar;

public class Orders implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String problemDescription;
	private Date sendedDate;
	
	public Orders(String problemDescription) {
		super();
		this.problemDescription = problemDescription;
		this.sendedDate = (Date) Calendar.getInstance().getTime();
	}

	public String getProblemDescription() {
		return problemDescription;
	}

	public void setProblemDescription(String problemDescription) {
		this.problemDescription = problemDescription;
	}

	public Date getSendedDate() {
		return sendedDate;
	}

	public void setSendedDate(Date sendedDate) {
		this.sendedDate = sendedDate;
	}

	@Override
	public String toString() {
		return "Orders [problemDescription=" + problemDescription + ", sendedDate=" + sendedDate + "]";
	}
	
	
}
