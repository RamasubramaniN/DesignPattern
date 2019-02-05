package com.subex.ramasubramani;

public class DecorativePrinter
{
	public static void main( String[] args )
	{
		System.out.println( "***********************************************************************************************************************************" );
		Printer headerOnly = new PrinterHeaderDecorator( new SimplePrinter() );
		System.out.println( "Header Only Document looks like this : " + headerOnly.printDocument() );
		System.out.println( "Header Only Document's name : " + headerOnly.displayDocumentName() + ", Document type : " + headerOnly.displayDocumentType() );
		System.out.println( "***********************************************************************************************************************************" );

		Printer footerOnly = new PrinterFooterDecorator( new SimplePrinter() );
		System.out.println( "Footer Only Document looks like this : " + footerOnly.printDocument() );
		System.out.println( "Footer Only Document's name : " + footerOnly.displayDocumentName() + ", Document type : " + footerOnly.displayDocumentType() );
		System.out.println( "***********************************************************************************************************************************" );

		Printer headerFooter = new PrinterFooterDecorator( new PrinterHeaderDecorator( new SimplePrinter() ) );
		System.out.println( "Header Footer Document looks like this : " + headerFooter.printDocument() );
		System.out.println( "Header Footer Document's name : " + headerFooter.displayDocumentName() + ", Document type : " + headerFooter.displayDocumentType() );
		System.out.println( "***********************************************************************************************************************************" );
	}
}

interface Printer
{
	String printDocument();

	String displayDocumentName();

	String displayDocumentType();
}

class SimplePrinter implements Printer
{
	@Override
	public String printDocument()
	{
		return " DocumentContent ";
	}

	@Override
	public String displayDocumentName()
	{
		return "Resume";
	}

	@Override
	public String displayDocumentType()
	{
		return "Doc";
	}
}

abstract class PrinterDecorator implements Printer
{
	Printer printer;

	PrinterDecorator( Printer printer )
	{
		this.printer = printer;
	}

	@Override
	public String printDocument()
	{
		return printer.printDocument();
	}
}

class PrinterHeaderDecorator extends PrinterDecorator
{
	PrinterHeaderDecorator( Printer printer )
	{
		super( printer );
	}

	@Override
	public String printDocument()
	{
		return "Header" + this.printer.printDocument();
	}

	@Override
	public String displayDocumentName()
	{
		return this.printer.displayDocumentName();
	}

	@Override
	public String displayDocumentType()
	{
		return this.printer.displayDocumentType();
	}
}

class PrinterFooterDecorator extends PrinterDecorator
{
	PrinterFooterDecorator( Printer printer )
	{
		super( printer );
	}

	@Override
	public String printDocument()
	{
		return this.printer.printDocument() + "Footer";
	}

	@Override
	public String displayDocumentName()
	{
		return this.printer.displayDocumentName();
	}

	@Override
	public String displayDocumentType()
	{
		return this.printer.displayDocumentType();
	}
}