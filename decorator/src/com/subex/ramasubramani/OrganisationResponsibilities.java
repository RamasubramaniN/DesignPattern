package com.subex.ramasubramani;

import java.util.Date;

public class OrganisationResponsibilities
{
	//Suppose when a team member needs to perform his tasks as well as lead's tasks, we cannot change the behaviour dynamically
	//If you have rice, sambar, rasam & vegetables using decorator pattern we can pick any combination at run time.
	//can introduce additional functionality at runtime and can retain old functionality also
	public static void main( String[] args )
	{
		System.out.println( "***********************************************************************************************************************************" );
		Manager manager = new Manager( new BasicEmployee( "Ramasubramani" ) );
		System.out.println( manager.gatherRequirement() );
		System.out.println( manager.joinDate( new Date() ) );
		System.out.println( manager.leavingDate( new Date() ) );

		System.out.println( "***********************************************************************************************************************************" );
		Lead lead = new Lead( new BasicEmployee( "Ramasubramani" ) );
		System.out.println( lead.managePeople() );
		System.out.println( lead.joinDate( new Date() ) );
		System.out.println( lead.leavingDate( new Date() ) );

		System.out.println( "***********************************************************************************************************************************" );
		Developer developer = new Developer( new BasicEmployee( "Ramasubramani" ) );
		System.out.println( developer.doTask() );
		System.out.println( developer.joinDate( new Date() ) );
		System.out.println( developer.leavingDate( new Date() ) );
		System.out.println( "***********************************************************************************************************************************" );
	}
}

interface Employee
{
	String joinDate( Date joiningDate );

	String leavingDate( Date leavingDate );

	String getName();
}

class BasicEmployee implements Employee
{
	private String name;

	BasicEmployee( String name )
	{
		this.name = name;
	}

	@Override
	public String getName()
	{
		return name;
	}

	@Override
	public String joinDate( Date joiningDate )
	{
		return this.getName() + " joined the company on " + joiningDate;
	}

	@Override
	public String leavingDate( Date lastDay )
	{
		return this.getName() + " left the company on " + lastDay;
	}

}

abstract class SpecificTypeOfEmployee implements Employee
{
	Employee employee;

	public SpecificTypeOfEmployee( Employee employee )
	{
		this.employee = employee;
	}

	@Override
	public String joinDate( Date joiningDate )
	{
		return this.employee.joinDate( joiningDate );
	}

	@Override
	public String leavingDate( Date leavingDate )
	{
		return this.employee.leavingDate( leavingDate );
	}

	@Override
	public String getName()
	{
		return this.employee.getName();
	}

}

class Developer extends SpecificTypeOfEmployee
{
	public Developer( Employee employee )
	{
		super( employee );
	}

	public String doTask()
	{
		return super.employee.getName() + " is doing assigned tasks";
	}
}

class Lead extends SpecificTypeOfEmployee
{
	public Lead( Employee employee )
	{
		super( employee );
	}

	public String managePeople()
	{
		return super.employee.getName() + " is managing developers";
	}
}

class Manager extends SpecificTypeOfEmployee
{
	public Manager( Employee employee )
	{
		super( employee );
	}

	public String gatherRequirement()
	{
		return super.employee.getName() + " is gathering requirements for the project";
	}
}