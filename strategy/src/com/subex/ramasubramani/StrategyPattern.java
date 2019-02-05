package com.subex.ramasubramani;


//Pattern:
//Define a family of algorithms, encapsulate each one, and make them interchangeable.
//Strategy lets the algorithm vary independently from clients that use it.

//Objective :
//Principle 1 : Always program to an interface not to an implementation,So,at run time we can change the behaviour(Aggregation)
//Principle 2 : Separate methods which are varying from which remains constant 
//Principle 3 : Favour composition over inheritance
//Principle 4 : Identify which method must be implemented in all child classes and keep it in parent class as abstract method
//here the assumption is, this method implementation is unique for each child class, i.e. we don't need to think about reusable code.

//Explanation:
//Here duck class has one behaviour'swim',this is common across all kinds of ducks.
//So,the implementation itself is kept in Parent(Duck) class.
//Some ducks can fly and some ducks cannot fly.
//Assume 100 kinds of ducks can fly and 100 kinds of ducks cannot fly.
//If we keep fly() implementation in parent(duck) class, 
//all these 200 classes need to override and 100 classes will have one implementation("Fly with wings")
//and other 100 classes have another implementation "Duck cannot fly"
//If I need to fix one bug in the second implementation,code maintenance is tough here.
// because i need to modify all 100 classes and also there is no code reusability here
//So, created concrete class for each behaviour to give the implementation to that method, to achieve code reusability
//Display() method anyway is unique for each kind of class,so let the sub class implement it, so created abstract method
// in parent(Duck)to force all duck classes to must implement display method
//Finally we have used aggregation, i.e. we programmed for interface
//Duck class has two interfaces as its instance member fly & quack.
//So, we can change the behaviour at run time by assigning different behaviours,
//But if it is composition i.e. if duck class has behaviour class instance, we will not be able to change the behaviour at run time.

//In the future we can introduce new "Fly Behaviours", by creating a new class which implement "FlyBehaviour"
//So, things are more flexible here, behaviours are separated, so can create any kind of duck with any kind of behaviours in the future.

//Advantages
//When you have many related classes that differ only in behaviour.
//Strategy pattern provides a way to configure a class with one of many behaviours.
//Strategy pattern can be used when you have different variants of an algorithm. Each variant can be encapsulated within a strategy.
//The Strategy pattern offers an alternative to conditional statements for selecting desired behaviour. 
//When different behaviours are Encapsulating different behaviours in different Strategy classes 
//eliminates the need for conditional statements.
//Hierarchies of Strategy classes can be used to define a family of algorithms or behaviours for contexts to reuse.
//Encapsulating the algorithm in separate Strategy classes lets you vary the algorithm independently of its context.

//Disadvantages :
//Strategy pattern increases the number of objects in an application.
public class StrategyPattern
{
	public static void main( String[] args )
	{
		System.out.println( "**********Model Duck Section***********" );
		ModelDuck modelDuck = new ModelDuck();
		modelDuck.setFlyBehavior( new FlyWithWings() );
		modelDuck.setQuackBehavior( new Quack() );
		modelDuck.display();
		modelDuck.swim();
		modelDuck.flyBehavior.fly();
		modelDuck.quackBehavior.quack();

		//Changing behavior dynamically at run time
		modelDuck.setQuackBehavior( new Squeak() );
		System.out.println( "Changing behavior dynamically at run time : Aggregation" );
		modelDuck.quackBehavior.quack();

		System.out.println( "**********Model Duck Section***********" );
		MallordDuck mallordDuck = new MallordDuck( new FlyNoWay(), new MuteQuack() );
		mallordDuck.display();
		mallordDuck.swim();
		mallordDuck.flyBehavior.fly();
		mallordDuck.quackBehavior.quack();
		//Changing behavior dynamically at run time
		mallordDuck.setFlyBehavior( new FlyWithWings() );
		System.out.println( "Changing behavior dynamically at run time : Aggregation" );
		mallordDuck.flyBehavior.fly();
	}
}

abstract class Duck
{
	FlyBehavior flyBehavior;
	QuackBehavior quackBehavior;

	Duck()
	{
		System.out.println( "Creating Duck" );
	}

	Duck( FlyBehavior flyBehavior, QuackBehavior quackBehavior )
	{
		this.flyBehavior = flyBehavior;
		this.quackBehavior = quackBehavior;
	}

	public void swim()
	{
		System.out.println( "Duck is swimming" );
	}

	public void setFlyBehavior( FlyBehavior flyBehavior )
	{
		this.flyBehavior = flyBehavior;
	}

	public void setQuackBehavior( QuackBehavior quackBehavior )
	{
		this.quackBehavior = quackBehavior;
	}

	public abstract void display();

}

class ModelDuck extends Duck
{
	ModelDuck()
	{
		System.out.println( "Creating Model Duck" );
	}

	ModelDuck( FlyBehavior flyBehavior, QuackBehavior quackBehavior )
	{
		super( flyBehavior, quackBehavior );
		System.out.println( "Creating Model Duck" );
	}

	@Override
	public void display()
	{
		System.out.println( "Displaying Model Duck" );
	}
}

class MallordDuck extends Duck
{

	@Override
	public void display()
	{
		System.out.println( "Displaying Mallord Duck" );
	}

	MallordDuck()
	{
		System.out.println( "Creating Model Duck" );
	}

	MallordDuck( FlyBehavior flyBehavior, QuackBehavior quackBehavior )
	{
		super( flyBehavior, quackBehavior );
		System.out.println( "Creating Model Duck" );
	}

}

interface FlyBehavior
{
	public void fly();
}

interface QuackBehavior
{
	public void quack();
}

class FlyWithWings implements FlyBehavior
{
	@Override
	public void fly()
	{
		System.out.println( "Duck Flying with wings" );
	}
}

class FlyNoWay implements FlyBehavior
{
	@Override
	public void fly()
	{
		System.out.println( "Duck cannot fly" );
	}
}

class Quack implements QuackBehavior
{
	@Override
	public void quack()
	{
		System.out.println( "Duck is Quacking" );
	}
}

class MuteQuack implements QuackBehavior
{

	@Override
	public void quack()
	{
		System.out.println( "Duck cannot quack" );
	}

}

class Squeak implements QuackBehavior
{

	@Override
	public void quack()
	{
		System.out.println( "Duck is squeaking" );
	}

}