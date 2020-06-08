package Intranet;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Executor extends Employee implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int rate;
	private ArrayList<Orders> newOrders = new ArrayList<Orders>();
	private ArrayList<Orders> acceptedOrders;
	private ArrayList<Orders> rejectedOrders;
	private ArrayList<Orders> doneOrders;

	public Executor(String name, String surname, Gender gender, String phoneNumber, String email, Date birthday) {
		super(name, surname, gender, phoneNumber, email, birthday);
		this.rate = 0;
	}
	// get new orders from the employee
	public boolean getNewOrders() {
		if(!super.getOrders().isEmpty()) return false;
		else {
			newOrders = super.getOrders();
			return true;
		}
	}
	public ArrayList<Orders> viewNewOrder() {
		getNewOrders();
		return newOrders;
	}
	public boolean acceptOrder(String orderName) {
		for(Orders order : newOrders) {
			if(order.getProblemDescription().equals(orderName)) {
				acceptedOrders.add(order);
				newOrders.remove(order);
				return true;
			}
		}
		return false;
	}
	public boolean rejectOrder(String orderName) {
		for(Orders order : newOrders) {
			if(order.getProblemDescription().equals(orderName)) {
				rejectedOrders.add(order);
				newOrders.remove(order);
				return true;
			}
		}
		return false;
	}
	// view of accepted orders
	public ArrayList<Orders> viewAcceptedOrders() {
		return acceptedOrders;
	}
	// view of rejected orders
	public ArrayList<Orders> viewRejectedOrder() {
		return rejectedOrders;
	}
	// do orders 
	public boolean doOrder(String orderName) {
		for(Orders order : acceptedOrders) {
			if(order.getProblemDescription().equals(orderName)) {
				doneOrders.add(order);
				this.rate++;
				acceptedOrders.remove(order);
				super.getOrders().remove(order);
				return true;
			}
		}
		return false;
	}
	// view done orders
	public ArrayList<Orders> viewDoneOrders() {
		return doneOrders;
	}
	
	
}
