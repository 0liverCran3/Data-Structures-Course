package assignment2;

import java.util.Random;

public class PrefixAverage {
		/*
		 * Copyright 2014, Michael T. Goodrich, Roberto Tamassia, Michael H. Goldwasser
		 *
		 * Developed for use with the book:
		 *
		 *    Data Structures and Algorithms in Java, Sixth Edition
		 *    Michael T. Goodrich, Roberto Tamassia, and Michael H. Goldwasser
		 *    John Wiley & Sons, 2014
		 *
		 * This program is free software: you can redistribute it and/or modify
		 * it under the terms of the GNU General Public License as published by
		 * the Free Software Foundation, either version 3 of the License, or
		 * (at your option) any later version.
		 *
		 * This program is distributed in the hope that it will be useful,
		 * but WITHOUT ANY WARRANTY; without even the implied warranty of
		 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
		 * GNU General Public License for more details.
		 *
		 * You should have received a copy of the GNU General Public License
		 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
		 */

		/**
		 * Demonstration of algorithms for computing the prefix averages of an array.
		 *
		 * @author Michael T. Goodrich
		 * @author Roberto Tamassia
		 * @author Michael H. Goldwasser
		 */

	public static void main(String[] args) {
		Random random = new Random();
		double[] x = new double[100];
		for(int i=0;i< x.length; i++) {
			x[i] =random.nextDouble();
		}
		
	    
		long startTime1 = System.nanoTime();
		double[] b = prefixAverage1(x);
		//	for(int i = 0; i<=b.length-1; i++ ) {
		//        System.out.println(b[i]);
		//	} 
		System.out.println(b[b.length-1]);
		long endTime1 = System.nanoTime();
		System.out.println("1 Took "+(endTime1 - startTime1) + " ns");
		
		long startTime2 = System.nanoTime();
		double[] c = prefixAverage2(x);
		//	for(int i = 0; i<=b.length-1; i++ ) {
		//        System.out.println(b[i]);
		//	} 
		System.out.println(c[c.length-1]);
		long endTime2 = System.nanoTime();
		System.out.println("2 Took "+(endTime2 - startTime2) + " ns");
	}
	
	
		  /** Returns an array a such that, for all j, a[j] equals the average of x[0], ..., x[j]. */
		  public static double[] prefixAverage1(double[] x) {
		    int n = x.length;
		    double[] a = new double[n];    // filled with zeros by default
		    for (int j=0; j < n; j++) {
		      double total = 0;            // begin computing x[0] + ... + x[j]
		      for (int i=0; i <= j; i++)
		        total += x[i];
		      a[j] = total / (j+1);        // record the average
		    }
		    return a;
		  }
		  
		  /** Returns an array a such that, for all j, a[j] equals the average of x[0], ..., x[j]. */
		  public static double[] prefixAverage2(double[] x) {
		    int n = x.length;
		    double[] a = new double[n];    // filled with zeros by default
		    double total = 0;              // compute prefix sum as x[0] + x[1] + ...
		    for (int j=0; j < n; j++) {
		      total += x[j];               // update prefix sum to include x[j]
		      a[j] = total / (j+1);        // compute average based on current sum
		    }
		    return a;
		  }
		  
}
