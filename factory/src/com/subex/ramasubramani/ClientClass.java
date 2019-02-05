package com.subex.ramasubramani;

public class ClientClass
{
	//Assume you have a software you click on some tab, based on tab name it draws appropriate shape in the screen
	//Currently you have only two shapes, square and rectangle, so you have hard coded, if tab name ='square'
	//new Square(), if tab name is 'rectangle' new Rectangle(). But what if tomorrow some new shapes come. you need to go and
	//add one more if class this violates 'Method should be open for extension but not for modification'. To avoid this
	//Use factory class to create objects for you and one important thing is, 'The factory should not know what kind of objects it create'
	//i.e. there should be loose coupling between factory and actual classes.
	public static void main( String[] args )
	{
		loadAllProductClassesForRegistration();

		ClientUsage cu1 = new ClientUsage();
		ClientUsage cu2 = new ClientUsage();
		ClientUsage cu3 = new ClientUsage();
		try
		{
			//You can make use of this type of factory pattern only if the language we use supports reflection
			cu1.setShape( Factory.getInstance().getShape( 1 ) );//you can directly pass class objects also, i.e. even simple, no need to maintain map
			cu2.setShape( Factory.getInstance().getShape( 2 ) );
			cu3.setShape( Factory.getInstance().getShape( 3 ) );
		}
		catch ( InstantiationException e )
		{
			new RuntimeException( "Unable to create shapes" );
		}
		catch ( IllegalAccessException e )
		{
			new RuntimeException( "Unable to create shapes" );
		}

	}

	private static void loadAllProductClassesForRegistration()
	{
		
		//This executes static() block of every class, so that every class will do registration with the factory class.
		try
		{
			Class.forName( "com.subex.ramasubramani.Square" );
			Class.forName( "com.subex.ramasubramani.Circle" );
			Class.forName( "com.subex.ramasubramani.Rectangle" );
		}
		catch ( ClassNotFoundException e )
		{
			new RuntimeException( "Class files are not found" );
		}

	}

}

class ClientUsage
{
	private Shape shape;

	public Shape getShape()
	{
		return shape;
	}

	public void setShape( Shape shape )
	{
		this.shape = shape;
	}
}
