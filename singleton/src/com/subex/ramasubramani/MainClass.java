package com.subex.ramasubramani;

import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class MainClass
{
	public static void main( String[] args ) throws IOException, ClassNotFoundException
	{
		/*Singleton s1 = Singleton.getInstance();

		//Doing serialization
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream( bos );
		oos.writeObject( s1 
		ByteArrayInputStream bis = new ByteArrayInputStream( bos.toByteArray() );
		ObjectInputStream ois = new ObjectInputStream( bis );
		Singleton s2 = ( Singleton ) ois.readObject();

		System.out.println( s1 == s2 );//returns true, only if readResolve() method is properly implemented. 
		//This is the only approach to prevent creating new objects during serialisation.
		//But still on a remote machine different objects are created?????.
		*/
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		
		System.out.println();
		
		char[] allChar = input.toCharArray();
		int[] output = new int[26];
		
		for(int i =0; i< 26; i++){
			output[i] = 0;
		}
		
		for(int i=0; i< allChar.length; i++){
			int ascii = (int) allChar[i];
			if(ascii >= 97 && ascii <=122) {
				ascii -= 32;
			}
			if(ascii >= 65 && ascii <=90) {
				output[ascii-65]++;
			}
			
		}
		print(output);
		StringTokenizer s;
		/*while(s.hasMoreTokens()){
			Integer.valueOf(s.nextToken())
		}*/
		for(int i=0; i<=1000; i++){
			if((i%2==1)&&(i%3==1)&&(i%4==1)&&(i%5==1)&&(i%6==1)&&(i%7==0)){
				System.out.println(i);
			}
		}
		
		
	/*	char[] allChar = input.toCharArray();
		char[] output = new char[allChar.length];
		int endIndex = 0;
		for(int i=0; i< allChar.length; i++){
			int ascii = (int) allChar[i];
			if(48 <= ascii && 57>= ascii){
				output[endIndex++] = allChar[i];
			} else {
				if(endIndex > 0){
					print(output, endIndex);
					endIndex = 0;
				}
			}
		}*/
	}
	
	private static void print(int a[]) {
		for(int i = 0 ; i<26; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}
	
	/*private static void print(char[] abc, int endIndex) {
		for(int i = 0 ; i<endIndex; i++) {
			System.out.print(abc[i]);
		}
		System.out.println();
	}
*/
}
