/*
 * Zachary Snydar
 * 10/11/16
 * Subsets.java
 * This file converts data files of employees to teams
 */
package edu.greenriver.it.subset;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import edu.greenriver.it.employee.Employee;

/**
 * A class with a main method that takes a data file of employees and prints out possible teams with a score over 20.
 * @author Zachary Snydar
 *
 */
public class Subsets
{
	//Fields
	private ArrayList<Employee> employees;
	private static final int MINIMUM_SCORE = 19;
  private static final int EMPLOYEE_STRING_SIZE=3;
  private static final int BASE_TEN_RADIX=10;
	
	//Main Method
	/**
	 * Main method that prints out teams of employees given a data file
	 * @param args Its a main method
	 */
	public static void main(String[] args)
	{
		//Initiate employees and run saveTeams()
		employees = new ArrayList<Employee>();
		saveTeams();
	}
	
	//Helper Methods
	
	/**
	 * This method loads all employees, finds all possible teams, then prints them to the console if they 
	 * have a combined rating of over 20
	 */
	public static void saveTeams()
	{
		
		//load employee objects and instantiate temporary variables
		ArrayList<Employee> employees = loadEmployees();
		ArrayList<Employee> tempTeam = new ArrayList<Employee>();
		int teamsFound=0;
		
		//Find all possible teams using a nested for loop and an and function, 2^n -1 loops.
		for (int i = 0; i<(1<<employees.size());i++)
		{
			for(int j = 0; j<employees.size();j++)
			{
				if((i & (1 << j)) >0)
				{
					tempTeam.add(employees.get(j));
				}
			}
			
			//Find the total team rating
			int teamRating=0;
			for (Employee toRate : tempTeam)
			{
				teamRating+=toRate.getRating();
			}
			
			//If the team has a higher score than 20
			if ( teamRating>MINIMUM_SCORE)
			{
				//Increment teamsFound and print out the team.
				teamsFound++;
				System.out.println("Team Found (Score: "+teamRating+")\n"+tempTeam.toString()+"\n");
			}
			
			//Empty the tempTeam for reuse
			tempTeam.clear();
		}
		
		//Print the total number of teams found
		System.out.println("Total number of teams found: "+teamsFound);
	}
	
	/**
	 * A method that reads a data file and converts individual lines into employee objects
	 * @return an ArrayList<Employee> that contains all employees in the loaded file
	 */
	public static ArrayList<Employee> loadEmployees()
	{
		//Try/Catch for IO manipulation
		try
		{
			//Make the file and the scanner.
			File data = new File("src/even_more_employees.dat");
			Scanner eScanner = new Scanner(data);
			
			//run parseEmployee on each line of the file
			while(eScanner.hasNextLine())
			{
				employees.add(parseEmployee(eScanner.nextLine()));
			}
			//Close dat scanna
			eScanner.close();
		}
		//In case we fudged up
		catch (FileNotFoundException e)
		{
			System.out.println("Error: " +  Thread.currentThread().getStackTrace());
		}
		
		//Return
		return employees;
	}
	
	/**
	 * A method that takes a string and converts it into an Employee object to return
	 * @param employeeText A single string containing the attributes of the employee
	 * @return The employee object created from our input string
	 */
	public static Employee parseEmployee(String employeeText)
	{
		//String array for using .Split
		String[] employeeData = new String[EMPLOYEE_STRING_SIZE];
		//Splitting
		employeeData =  employeeText.split(",");
		//Assigning Variables
		String name=employeeData[EMPLOYEE_STRING_SIZE-EMPLOYEE_STRING_SIZE];
		int rating = Integer.parseInt(employeeData[(EMPLOYEE_STRING_SIZE-EMPLOYEE_STRING_SIZE+)+1].trim(),BASE_TEN_RADIX);
		String hireDate = employeeData[EMPLOYEE_STRING_SIZE-1];
		
		//Making a new employee object and returning it
		Employee temp = new Employee(name,rating,hireDate);
		return temp;
	}
}
