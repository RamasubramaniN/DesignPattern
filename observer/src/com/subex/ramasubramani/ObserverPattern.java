package com.subex.ramasubramani;

import java.util.ArrayList;

//Observer Pattern : 
//Define a one-to-many dependency between objects so that when one object changes state,
//all its dependents are notified and updated automatically.



//Take news as Subject. People are subscribers. If they subscribe they will get notified everyday with new news
//If they stop subscription, they will not get notified. Here news is the subject. 
//In the below example, StockMarket is the 'Subject'. Whenever there is a change in Subject, some other objects should be notified
//But later these objects can ask to stop the notification,
//"TV Channel", "Newspaper" and "Internet" or observers. Whenever there is a change in the subject observers are getting notified
//Here observer and subject are loosely coupled, because subject does not about the observer it notifies,it only knows which method to call
//It just knows list of objects to be notified.
//We can plug in new observers at any time(create a class which implements observer interface)
//we can remove existing observers also to stop the notification
//Code changes in observer class will not affect "Subject" and it will not affect other observer classes also
//Code changes to Subject will not affect any observers


//When two objects are loosely coupled, they can interact, but have very little knowledge of each other
//The observer pattern provides an object design where objects and observers are loosely coupled.

//When To Use : 
//In a mailing list, where every time an event happens (a new product, a gathering, etc.)
//a message is sent to the people subscribed to the list.
//When a change to one object requires changing others, and you don't know how many objects need to be changed.
//When an object should be able to notify other objects without making assumptions about who these objects are (avoid tight-coupling).
//We can add/remove observers at any time without changes in 'subject' code.
//Pros and Cons : 
//Loose coupling between Subject and Observer: The subject knows only a list of observers,
//that implement the Observer interface, it does not know the concrete implementation of the Observer.
//Broadcast communication: An event notification is broadcast observers irrespective of the number of Observers
//Unexpected updates: The can be blind to the cost of changing the subject.

public class ObserverPattern
{
	public static void main( String[] args )
	{
		StockMarket stockMarket = new StockMarket();

		Newspaper newsPaper = new Newspaper( stockMarket );
		Internet internet = new Internet( stockMarket );
		NewsChannel newsChannel = new NewsChannel( stockMarket );

		System.out.println( "********Day1*********" );
		stockMarket.setChangedValues( new Double( 18000.56 ), new Double( 5000.65 ) );

		System.out.println( "********Day2*********" );
		stockMarket.setChangedValues( new Double( 18090.56 ), new Double( 5550.65 ) );
	}

}

interface Subject
{
	public void addObserver( Observer observer );

	public void removeObserver( Observer observer );

	public void notifyObservers();
}

class StockMarket implements Subject
{
	private Double bse;
	private Double nse;
	ArrayList<Observer> listObserver;

	public StockMarket()
	{
		listObserver = new ArrayList<Observer>();
	}

	@Override
	public void addObserver( Observer observer )
	{
		listObserver.add( observer );
		Arrays.binar
	}

	@Override
	public void removeObserver( Observer observer )
	{
		listObserver.remove( observer );
	}

	@Override
	public void notifyObservers()
	{
		for ( Observer observer : listObserver )
			observer.update( bse, nse );
	}

	private void stateChanged()
	{
		notifyObservers();
	}

	public void setChangedValues( Double bse, Double nse )
	{
		this.bse = bse;
		this.nse = nse;
		stateChanged();
	}

}

interface Observer
{
	public void update( Double bse, Double nse );
}

interface DisplayElement
{
	public void display();
}

class Newspaper implements Observer, DisplayElement
{
	private Double bse;
	private Double nse;

	public Newspaper( Subject subject )
	{
		subject.addObserver( this );
	}

	@Override
	public void update( Double bse, Double nse )
	{
		this.bse = bse;
		this.nse = nse;
		display();
	}

	@Override
	public void display()
	{
		System.out.println( "Deccan Herald : Today's news BSE : " + bse + ", NSE : " + nse );
	}

}

class NewsChannel implements Observer, DisplayElement
{
	private Double bse;
	private Double nse;

	NewsChannel( Subject subject )
	{
		subject.addObserver( this );
	}

	@Override
	public void update( Double bse, Double nse )
	{
		this.bse = bse;
		this.nse = nse;
		display();
	}

	@Override
	public void display()
	{
		System.out.println( "Times Channel : Today's news BSE : " + bse + ", NSE : " + nse );
	}

}

class Internet implements Observer, DisplayElement
{
	private Double bse;
	private Double nse;

	Internet( Subject subject )
	{
		subject.addObserver( this );
	}

	@Override
	public void update( Double bse, Double nse )
	{
		this.bse = bse;
		this.nse = nse;
		display();
	}

	@Override
	public void display()
	{
		System.out.println( "News Online Website : Today's news BSE : " + bse + ", NSE : " + nse );
	}
}