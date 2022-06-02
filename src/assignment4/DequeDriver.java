/**
 * COSC 2100 – Fall 2020
 * Assignment#4
 * Interactive driver program to maintain a sorted deque.
 * @author <COSC 2100 Instructors>
 */

package assignment4;

import java.io.*;
import java.util.*;
import support.DLLNode;

public class DequeDriver {

	public static void main(String[] args) throws IOException {
		
		Scanner inp = new Scanner(System.in);
		Integer userInput = 1;

		DEQueue<Integer> myQueue = new DEQueue<Integer>();

		while (userInput != 0) {
			System.out.println("Current Deque: " + myQueue.toString());
			System.out.println("Choose an operation - 0:quit, 1:insert, 2:delete");

			userInput = inp.nextInt();
			if (userInput < 0 || userInput > 2) {
				System.out.println("###  Please enter a correct input option  ###");
				continue;
			}

			if(userInput == 1) {
				System.out.println("Enter the integer you want to insert in the deque:");
				myQueue.insert(inp.nextInt());
			}

			if(userInput == 2) {
				System.out.println("Enter the integer you want to delete from the deque:");
				myQueue.delete(inp.nextInt());
			}
		}

		System.out.println("**Program Ended Successfully**");
		inp.close();
	}
}