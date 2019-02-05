package com.subex.ramasubramani;

public class IcecreamDecorator
{
	public static void main( String[] args )
	{
		Icecream icecream = new HoneyDecorator( new NuttyDecorator( new SimpleIcecream() ) );
		System.out.println( icecream.makeIcecream() );

	}
}

interface Icecream
{
	public String makeIcecream();
}

class SimpleIcecream implements Icecream
{

	@Override
	public String makeIcecream()
	{
		return "Base Icecream";
	}

}

abstract class DecoratorIcecream implements Icecream
{

	protected Icecream specialIcecream;

	public DecoratorIcecream( Icecream specialIcecream )
	{
		this.specialIcecream = specialIcecream;
	}

	public String makeIcecream()
	{
		return specialIcecream.makeIcecream();
	}
}

class NuttyDecorator extends DecoratorIcecream
{

	public NuttyDecorator( Icecream specialIcecream )
	{
		super( specialIcecream );
	}

	public String makeIcecream()
	{
		return specialIcecream.makeIcecream() + addNuts();
	}

	private String addNuts()
	{
		return " + cruncy nuts";
	}
}

class HoneyDecorator extends DecoratorIcecream
{

	public HoneyDecorator( Icecream specialIcecream )
	{
		super( specialIcecream );
	}

	public String makeIcecream()
	{
		return specialIcecream.makeIcecream() + addHoney();
	}

	private String addHoney()
	{
		return " + sweet honey";
	}
}
