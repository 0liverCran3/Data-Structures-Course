package assignment3;
/**
 * COSC 2100 – Fall 2020
 * Assignment#3
 * <This class uses methods from ArrayBoundedStack
 * to create a program that undoes and redoes the users imput String>
 * @author Oliver Crane 
 */

import java.io.*;
import java.util.*;

public class StackAssignment{

	public static void main(String[] args) throws IOException {
		
		Scanner inp = new Scanner(System.in);
		String myString = "Marquette";
		int userInput = 1;

		//TODO: (1)Initialize stacks for Undo and Redo
		StackInterface<String> undo;
		StackInterface<String> redo;
		undo = new ArrayBoundedStack<String>();
		redo = new ArrayBoundedStack<String>();

		while (userInput != 0) {
			System.out.println("Current Value of myString "+myString);
			System.out.println("What do you want to do?");
			System.out.println("\t0) Exit");
			System.out.println("\t1) Update");
			
			// isEmpty statements determine if the options 2 and 3 are valid in the program
			//TODO: (2) Only show undo if an update is done
			if(!undo.isEmpty())
				System.out.println("\t2) Undo");
			//TODO: (3) Only show redo if an undo is done
			if(!redo.isEmpty())
				System.out.println("\t3) Redo");
			userInput = inp.nextInt();
			
			//Simple statement makes sure the user does not use a number too large
			//TODO: (4) Check if the user input a valid choice and ask user to input a valid choice if necessary
			if(userInput > 3)
				System.out.println("###Please enter one of the correct choices###"); 
			
			//This if statement updates myString and stores the previous String in undo
			if(userInput == 1) {
				System.out.println("Please enter the new value for myString:");
				//TODO: (5) Complete the implementation for Update choice
				undo.push(myString);
				Scanner str = new Scanner(System.in);
				myString = str.next();
				}
	
				//TODO: (6) Implement the Undo and Redo functionalities with stacks
				//This if statement prints the String at the top of the undo stack and stores the previous String in redo
				if(userInput == 2) {
					if(undo.isEmpty()) {
						System.out.println("###Please enter one of the correct choices###");
					}else {
					redo.push(myString);
					myString = undo.top();
					undo.pop();
					System.out.println("myString UNDONE");
					}
				}
				//This if statement prints the String at the top of the redo stack and stores the previous String in undo
				if(userInput == 3) {
					if(redo.isEmpty()) {
						System.out.println("###Please enter one of the correct choices###");
					}else {
					undo.push(myString);
					myString = redo.top();
					redo.pop();
					System.out.println("myString REDONE");
					}
				}
		}

		System.out.println("**Program Ended Successfully**");
		inp.close();
	}
}