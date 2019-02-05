package com.subex.ramasubramani;

import java.util.HashMap;

public class Factory
{
	private HashMap<Integer, Class> shapesMap = new HashMap<Integer, Class>();

	private static Factory singletonInstance;

	private Factory()
	{

	}

	public static Factory getInstance()
	{
		if ( singletonInstance == null )
		{
			synchronized ( Factory.class )
			{
				if ( singletonInstance == null )
				{
					singletonInstance = new Factory();
				}
			}
		}
		return singletonInstance;
	}

	protected Factory readResolve()
	{
		return singletonInstance;//To avoid serialization duplicates of singleton
	}

	public void registerShape( Integer shapeId, Class shapeClass )
	{
		shapesMap.put( shapeId, shapeClass );
	}

	public Shape getShape( int shapeId ) throws InstantiationException, IllegalAccessException
	{
		Class< ? extends Shape> shapeClass = shapesMap.get( shapeId );
		return shapeClass.newInstance();
	}

}

abstract class Shape
{

}

class Square extends Shape
{
	static
	{
		Factory.getInstance().registerShape( 1, Square.class );
	}

	Square()
	{
		System.out.println( "Square instance has been created" );
	}
}

class Rectangle extends Shape
{
	static
	{
		Factory.getInstance().registerShape( 2, Rectangle.class );
	}

	Rectangle()
	{
		System.out.println( "Rectangle instance has been created" );
	}
}

class Circle extends Shape
{
	static
	{
		Factory.getInstance().registerShape( 3, Circle.class );
	}

	Circle()
	{
		System.out.println( "Circle instance has been created" );
	}
}