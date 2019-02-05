package com.subex.ramasubramani;

//Builder pattern is very useful to create a complex object step by step
//Using Builder pattern we can build different representations of complex object
//Where the process of construction is same. But it has different implementation 
//to create each part of the object to generate various representations of object
//It is different from factory pattern, irrespective of whatever be the complexity of pattern, factory pattern
//constructs the object in a single step, Just we are returning the object directly in builder pattern where object
//has its predefined implementation.
public class BuilderPattern
{
	public static void main( String[] args )
	{
		SandHouseBuilder sandHouseBuilder = new SandHouseBuilder();
		CivilEngineer civilEngineer = new CivilEngineer( sandHouseBuilder );
		civilEngineer.ConstructHouse();
		civilEngineer.getHouse();
		System.out.println( civilEngineer.getHouse() );

		WoodenHouseBuilder woodenHouseBuilder = new WoodenHouseBuilder();
		civilEngineer.setHouseBuilder( woodenHouseBuilder );
		civilEngineer.ConstructHouse();
		civilEngineer.getHouse();
		System.out.println( civilEngineer.getHouse() );

		IceHouseBuilder iceHouseBuilder = new IceHouseBuilder();
		civilEngineer.setHouseBuilder( iceHouseBuilder );
		civilEngineer.ConstructHouse();
		civilEngineer.getHouse();
		System.out.println( civilEngineer.getHouse() );
	}
}

class House
{
	String basement;
	String structrue;
	String roof;
	String interior;

	public void setBasement( String basement )
	{
		this.basement = basement;
	}

	public void setStructrue( String structrue )
	{
		this.structrue = structrue;
	}

	public void setRoof( String roof )
	{
		this.roof = roof;
	}

	public void setInterior( String interior )
	{
		this.interior = interior;
	}

	@Override
	public String toString()
	{
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append( "This House Consists of :\n1)" + this.basement + "\n2)" + this.interior + "\n3)" + this.roof + "\n4)" + this.structrue + "\n" );
		return stringBuilder.toString();
	}
}

interface HouseBuilder
{
	public void constructBasement();

	public void constructStructure();

	public void constructRoof();

	public void constructInterior();

	public House getHouse();
}

class SandHouseBuilder implements HouseBuilder
{
	private House house;

	public SandHouseBuilder()
	{
		this.house = new House();
	}

	@Override
	public void constructBasement()
	{
		// Constructing basement with sand here. So, there will be some calculations here, This may be 
		//complex step but this is not shown here.
		this.house.setBasement( "Sand Basement" );
	}

	@Override
	public void constructStructure()
	{
		// Constructing basement with sand here. So, there will be some calculations here, This may be 
		//complex step but this is not shown here.
		this.house.setStructrue( "Sand Structure" );
	}

	@Override
	public void constructRoof()
	{
		// Constructing basement with sand here. So, there will be some calculations here, This may be 
		//complex step but this is not shown here.
		this.house.setRoof( "Sand Roof" );
	}

	@Override
	public void constructInterior()
	{
		// Constructing basement with sand here. So, there will be some calculations here, This may be 
		//complex step but this is not shown here.
		this.house.setInterior( "Sand Interior" );
	}

	@Override
	public House getHouse()
	{
		return this.house;
	}
}

class WoodenHouseBuilder implements HouseBuilder
{
	House house;

	public WoodenHouseBuilder()
	{
		this.house = new House();
	}

	@Override
	public void constructBasement()
	{
		// Constructing basement with wooden here. So, there will be some calculations here, This may be 
		//complex step but this is not shown here.
		this.house.setBasement( "Wooden Basement" );
	}

	@Override
	public void constructStructure()
	{
		// Constructing basement with wooden here. So, there will be some calculations here, This may be 
		//complex step but this is not shown here.
		this.house.setStructrue( "Wooden Structure" );
	}

	@Override
	public void constructRoof()
	{
		// Constructing basement with wooden here. So, there will be some calculations here, This may be 
		//complex step but this is not shown here.
		this.house.setRoof( "Wooden Roof" );
	}

	@Override
	public void constructInterior()
	{
		// Constructing basement with wooden here. So, there will be some calculations here, This may be 
		//complex step but this is not shown here.
		this.house.setInterior( "Wooden Interior" );
	}

	@Override
	public House getHouse()
	{
		return this.house;
	}

}

class IceHouseBuilder implements HouseBuilder
{
	House house;

	public IceHouseBuilder()
	{
		this.house = new House();
	}

	@Override
	public void constructBasement()
	{
		// Constructing basement with wooden here. So, there will be some calculations here, This may be 
		//complex step but this is not shown here.
		this.house.setBasement( "Ice Basement" );
	}

	@Override
	public void constructStructure()
	{
		// Constructing basement with wooden here. So, there will be some calculations here, This may be 
		//complex step but this is not shown here.
		this.house.setStructrue( "Ice Structure" );
	}

	@Override
	public void constructRoof()
	{
		// Constructing basement with wooden here. So, there will be some calculations here, This may be 
		//complex step but this is not shown here.
		this.house.setRoof( "Ice Roof" );
	}

	@Override
	public void constructInterior()
	{
		// Constructing basement with wooden here. So, there will be some calculations here, This may be 
		//complex step but this is not shown here.
		this.house.setInterior( "Ice Interior" );
	}

	@Override
	public House getHouse()
	{
		return this.house;
	}

}

class CivilEngineer
{
	HouseBuilder houseBuilder;

	CivilEngineer( HouseBuilder houseBuilder )
	{
		this.houseBuilder = houseBuilder;
	}

	public void setHouseBuilder( HouseBuilder houseBuilder )
	{
		this.houseBuilder = houseBuilder;
	}

	public void ConstructHouse()
	{
		this.houseBuilder.constructBasement();
		this.houseBuilder.constructInterior();
		this.houseBuilder.constructRoof();
		this.houseBuilder.constructStructure();
	}

	public House getHouse()
	{
		return this.houseBuilder.getHouse();
	}
}
