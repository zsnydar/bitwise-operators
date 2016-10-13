/*
 * Zachary Snydar
 * 10/11/16
 * Employee.java
 * This file defines Employee objects
 */
package edu.greenriver.it.employee;

/**
 * An employee object with a name, rating, and hiredate
 * @author Zachary Snydar
 *
 */
public class Employee 
{
	//Fields
	private String name;
	private int rating;
	private String hireDate;
	
	//Constructor
	
	/**
	 * Constructor for an employee object, takes name, rating, and hiredate, and assigns them
	 * @param name The name of the employee as a string
	 * @param rating The rating of the employee as an int
	 * @param hireDate The hire date of the employee as a string.
	 */
	public Employee(String name, int rating, String hireDate)
	{
		this.name=name;
		this.rating=rating;
		this.hireDate=hireDate;
	}
	
	//Getters/Setters
	
	/**
	 * 
	 * @return name The name of the employee
	 */
	public String getName() {
		return name;
	}

	/**
	 * 
	 * @param name The new name assigned to the employee
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * 
	 * @return rating The employee's rating
	 */
	public int getRating() {
		return rating;
	}

	/**
	 * 
	 * @param rating The new rating assigned to employee
	 */
	public void setRating(int rating) {
		this.rating = rating;
	}
	
	/**
	 * 
	 * @return hireDate the employee's hiredate
	 */
	public String getHireDate() {
		return hireDate;
	}

	/**
	 * 
	 * @param hireDate the new hiredate assigned to employee
	 */
	public void setHireDate(String hireDate) {
		this.hireDate = hireDate;
	}
	
	/**
	 * A toString method that prints the name and rating of the employee.
	 */
	public String toString()
	{
		return name + " - " + rating;
	}
}
