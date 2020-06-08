package Intranet;

import java.io.Serializable;

public class Mark implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private double firstAttestation;
	private double secondAttestation;
	private double finalScore;
	private double total;
	
	
	public Mark() {
		super();
		this.firstAttestation = 0;
		this.secondAttestation = 0;
		this.finalScore = 0;
		this.total = 0;
	}
	public double getFirstAttestation() {
		return firstAttestation;
	}
	public void setFirstAttestation(double firstAttestation) {
		this.firstAttestation = firstAttestation;
	}
	public double getSecondAttestation() {
		return secondAttestation;
	}
	public void setSecondAttestation(double secondAttestation) {
		this.secondAttestation = secondAttestation;
	}
	public double getFinalScore() {
		return finalScore;
	}
	public void setFinalScore(double finalScore) {
		this.finalScore = finalScore;
	}
	public double getTotal() {
		total = firstAttestation + secondAttestation + finalScore;
		return  total;
	}
	public String charGrade() {
		if(total <= 100 && total >= 95) return "A";
		else if(total <= 94 && total >= 90) return "A-";
		else if(total <= 89 && total >= 85) return "B+";
		else if(total <= 84 && total >= 80) return "B";
		else if(total <= 79 && total >= 75) return "B-";
		else if(total <= 74 && total >= 70) return "C+";
		else if(total <= 69 && total >= 65) return "C";
		else if(total <= 64 && total >= 60) return "C-";
		else if(total <= 59 && total >= 55) return "D+";
		else if(total <= 54 && total >= 50) return "D";
		else return "F";
	}
	public double getGPA() {
		if(total <= 100 && total >= 95) return 4.00;
		else if(total <= 94 && total >= 90) return 3.67;
		else if(total <= 89 && total >= 85) return 3.33;
		else if(total <= 84 && total >= 80) return 3.00;
		else if(total <= 79 && total >= 75) return 2.67;
		else if(total <= 74 && total >= 70) return 2.33;
		else if(total <= 69 && total >= 65) return 2.00;
		else if(total <= 64 && total >= 60) return 1.67;
		else if(total <= 59 && total >= 55) return 1.33;
		else if(total <= 54 && total >= 50) return 1.00;
		else return 0;
	}
	
}
