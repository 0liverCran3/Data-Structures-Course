/**
 * COSC 2100 - Fall 2020
 * Assignment#1
 * <This class functions well at taking the users input for a file and 
 * the amount of lines they want to be copied into x amount of new files.>
 * @author <Oliver Crane>
 */
package assignment1;

import java.io.*;
import java.util.Scanner;


public class BookSplit {
	
	public static void main(String[] args) throws IOException {
		//takes user input for their file choice and the amount of lines they want in the new file.
		Scanner s1 = new Scanner(System.in);
		Scanner s2 = new Scanner(System.in);
		System.out.print("Enter the input file name (without extension): ");
		String file = s1.nextLine();
		System.out.print("How many lines do you want in each output file? ");
		String lines = s2.nextLine();
		
		BufferedReader br; 
		
		try{ 
			//tracks what new file we are on.
			int fileTracker = 1;
			//lineTracker is a very important int, tracks the amount of lines the user inputs in the while loop. 
			int lineTracker = 0;
			
			br = new BufferedReader(new FileReader(file+".txt"));
			System.out.println("Files generated: ");
			PrintWriter newFile = null;
			String q;
			String l = br.readLine();
			//the loop statement goes through every line in the file thats given.
			while((q = l) != null) {
				//if the lineTracker is 0 it creates a new file to store the next set of the user input line #.
				if(lineTracker == 0) {
					newFile = new PrintWriter(file+"-"+fileTracker+".txt");
					System.out.println(file+"-"+fileTracker+".txt");
					lineTracker++;
					l = br.readLine();
					newFile.println(q);
				}
				//if the lineTracker is the same as the user inputed line #, the new file closes and restarts the lineTracker at 0.
				else if(lineTracker == Integer.parseInt(lines)) {
					lineTracker = lineTracker - Integer.parseInt(lines);
					fileTracker++;
					newFile.close();
				}
				else {
					//if the lineTracker is not 0 or equal to the user inputed line #, the fileTracker adds another line to the new file.
					l = br.readLine();
					lineTracker++;
					newFile.println(q);
				}
			}
			newFile.close();
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("**BookSplit completed Successfully**");
	}
	
}
