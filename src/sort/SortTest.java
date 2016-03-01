/**
 * 
 */
package sort;

import static org.junit.Assert.*;		

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.apache.commons.lang3.time.StopWatch;

/**
 * @author Naresh
 *
 */

public class SortTest {

// Declare Word[] arrays of sizes 16,256, and 4096 respectively
	private static Word[] wordArray16 = new Word[16];
	private static Word[] wordArray256 = new Word[256];
	private static Word[] wordArray4096 = new Word[4096];
	
// Declare word objects 	
	private static Word word16;
	private static Word word256;
	private static Word word4096;
	
	StopWatch sw = new StopWatch();		// Declare an instance of a StopWatch object, which will be used later 

/* The string arrays that are attained by parsing the Word[] arrays, and has the form 
 * [string,number,string,number,...,number]   **NOTE: the 'numbers' are strings 
 */	
	static String[] array1,array2,array3;  
	

/* Declare 15 variables to store the running times of the algorithms for 16 word arrays, 256 word arrays and 4096
 * word arrays 
 */	
	static long t11, t12, t13, t21, t22, t23, t31, t32, t33, t41, t42, t43, t51, t52, t53;
	
	@Before
	public void run() {
	
/*
 * Since the 16 Word[] arrays have been parsed into a 32 string element String array[], iterate through the String[]
 * array and create new word objects for each iteration (which contains a pair of a string and an integer), and 
 * append it onto the 16 Word[] array for each iteration 
 */
			int l = 0;	//initialize counter to 0
			for (int i = 0; i < (array1.length); i+=2) {
			word16 = new Word(array1[i],Integer.parseInt(array1[i+1]));
			wordArray16[l] = word16;
			l++;
			}

/*
 * Since the 256 Word[] arrays have been parsed into a 512 string element String array[], iterate through the String[]
 * array and create new word objects for each iteration (which contains a pair of a string and an integer), and 
 * append it onto the 265 Word[] array for each iteration 
 */
			 l = 0;
			 for (int i = 0; i < (array2.length); i+=2) {
					word256 = new Word(array2[i],Integer.parseInt(array2[i+1]));
					wordArray256[l] = word256;
					l++;
			}
			 
/*
 * Since the 4096 Word[] arrays have been parsed into a 8192 string element String array[], iterate through the String[]
 * array and create new word objects for each iteration (which contains a pair of a string and an integer), and 
 * append it onto the 4096 Word[] array for each iteration 
 */
 			 l = 0;
 			 for (int i = 0; i < (array3.length); i+=2) {
					word4096 = new Word(array3[i],Integer.parseInt(array3[i+1]));
					wordArray4096[l] = word4096;
					l++;
				}			
}
	@BeforeClass
	public static void setUpBeforeClass() throws FileNotFoundException {
		
		 Scanner input	=	new Scanner(new File("Data/a2_in.txt")); // The text file to read the test cases
		 int checkLine = 1;		//counter to denote first line of text file

		 while(input.hasNextLine()) {		//Do until the input text file has another line to follow
			 String line = input.nextLine();
			
/* First line of input text file corresponds to the 16 Word[] array.
 * Perform the following string operations to get the array in the form [string,int,string,int,....,int]
 * Store result in array1
 */
			 if (checkLine == 1) {
				 String temp = line.replace("{","");
				 temp = temp.replace("}", "");
				 array1 = temp.split(",");				
			 }
		
/* Second line of input text file corresponds to the 256 Word[] array.
 * Perform the following string operations to get the array in the form [string,int,string,int,....,int]
 * Store result in array2
 */
			 if (checkLine == 2) {
				 String temp2 = line.replace("{","");
				 temp2 = temp2.replace("}", "");
				 array2 = temp2.split(",");		
			 }

/* Third line of input text file corresponds to the 4096 Word[] array.
 * Perform the following string operations to get the array in the form [string,int,string,int,....,int]
 * Store result in array3
 */
			 if (checkLine == 3) {
				 String temp3 = line.replace("{","");
				 temp3 = temp3.replace("}", "");
				 array3 = temp3.split(",");
			 }
		checkLine++;		//increment current line counter
		}
	input.close();		//close input text file
	}
	
/**
 * @throws Exception
 */
	@AfterClass
	public static void teardown() throws Exception {
		
		 PrintStream output =	new PrintStream(new File("Data/a2_out.txt")); // The text file to store results		

/**
 * The following code is to sort the running times attained by using the 5 different sorts in ascending order. 
 * Create three Word[] arrays (one with 16 words, one with 256 words, and one with 4096 words).
 * Each word contains a pair(one is a string, denoting the type of sort, and the other is an integer, denoting its
 * corresponding running time).
 */
		 Word[] orderFor16 = new Word[]{new Word("simple insertion sort",(int)t11), new Word("comparable insertion sort",(int)t21), new Word("binary insertion sort",(int)t31), new Word("merge sort",(int)t41), new Word("heap sort",(int)t51)};
		 Word[] orderFor256 = new Word[]{new Word("simple insertion sort",(int)t12), new Word("comparable insertion sort",(int)t22), new Word("binary insertion sort",(int)t32), new Word("merge sort",(int)t42), new Word("heap sort",(int)t52)};
		 Word[] orderFor4096 = new Word[]{new Word("simple insertion sort",(int)t13), new Word("comparable insertion sort",(int)t23), new Word("binary insertion sort",(int)t33), new Word("merge sort",(int)t43), new Word("heap sort",(int)t53)};
		 
		 Merge.sortMerge(orderFor16);
		 Merge.sortMerge(orderFor256);
		 Merge.sortMerge(orderFor4096);
		 
/**
 * The formatting done to the strings to be displayed in the output.txt file, as per the requirements of the
 * assignment		 
 */		 
		 String a = Arrays.toString(orderFor16).replace(", ","ns,");
		 a = a.replace("[", "");
		 a = a.replace("]","");
		 
		 String b = Arrays.toString(orderFor256).replace(", ","ns,");
		 b = b.replace("[", "");
		 b = b.replace("]","");
		 
		 String c = Arrays.toString(orderFor4096).replace(", ","ns,");
		 c = c.replace("[", "");
		 c = c.replace("]","");
		 
		 output.println("16," + a + "ns");			//Prints the running times of sorting 16 words(using the 5 sorting algorithms), in ascending order
		 output.println("256," + b + "ns");			//Prints the running times of sorting 256 words(using the 5 sorting algorithms), in ascending order 
		 output.println("4096," + c + "ns");		//Prints the running times of sorting 4096 words(using the 5 different algorithms, in ascending order
	
		 output.println("\n\nEXPLANATION:\n\nFrom the results, we can see that the 16 Word[] array is sorted the fastest using \nbinary insertion sort, the 256[] Word array is sorted the fastest using merge sort, \nand the 4096 word[] array is also sorted the fastest using merge sort. I ran the \ntests over 10 times to check for consistency of the algorithms and running times. \nTherefore in general, for a small array(tested with the 16 word[] array in our case), \nbinary insertion sort is the most preferable, for medium sized arrays(tested with the 256[] \nword array in our case) as well as for large sized arrays(tested with the 4096[] word array \n, merge sort is the most preferred sorting algorithm. Another thing noted is that even though \n binary insertion sort is the fastest for small and medium sized arrays, it is the slowest \nfor large size arrays. ");
	}

	@Test
	public void testSortInsert() throws FileNotFoundException {

//Starts stop watch, performs simple insertion sort on 16 word array, stores result in t11, stops and resets timer
		sw.start();
		Insertion.sortInsert(wordArray16);
		sw.stop();
		t11 = sw.getNanoTime();
		sw.reset();

//Starts stop watch, performs simple insertion sort on 256 word array, stores result in t12, stops and resets timer
		sw.start();
		Insertion.sortInsert(wordArray256);
		sw.stop();
		t12 = sw.getNanoTime();
		sw.reset();

//Starts stop watch, performs simple insertion sort on 4096 word array, stores result in t13, stops and resets timer
		sw.start();
		Insertion.sortInsert(wordArray4096);
		sw.stop();
		t13 = sw.getNanoTime();
		sw.reset();
		
		assertTrue(Insertion.isSorted(wordArray16));
		assertTrue(Insertion.isSorted(wordArray256));
		assertTrue(Insertion.isSorted(wordArray4096));
	}
	
	@Test
	public void testInsertComparable() throws FileNotFoundException {

//Starts stop watch, performs comparable insertion sort on 16 word array, stores result in t21, stops and resets 
//timer
		sw.start();
		Insertion.sortComparable(wordArray16);
		sw.stop();
		t21 = sw.getNanoTime();
		sw.reset();

//Starts stop watch, performs comparable insertion sort on 256 word array, stores result in t22, stops and resets
//timer
		sw.start();
		Insertion.sortComparable(wordArray256);
		sw.stop();
		t22 = sw.getNanoTime();
		sw.reset();

//Starts stop watch, performs comparable insertion sort on 4096 word array, stores result in t23, stops and resets
//timer
		sw.start();
		Insertion.sortComparable(wordArray4096);
		sw.stop();
		t23 = sw.getNanoTime();
		sw.reset();
		
		assertTrue(Insertion.isSorted(wordArray16));
		assertTrue(Insertion.isSorted(wordArray256));
		assertTrue(Insertion.isSorted(wordArray4096));
	}
	
	@Test
	public void testInsertBinary() throws FileNotFoundException {

//Starts stop watch, performs binary insertion sort on 16 word array, stores result in t31, stops and resets timer
		sw.start();
		Insertion.sortBinary(wordArray16);
		sw.stop();
		t31 = sw.getNanoTime();
		sw.reset();

//Starts stop watch, performs binary insertion sort on 256 word array, stores result in t32, stops and resets timer
		sw.start();
		Insertion.sortBinary(wordArray256);
		sw.stop();
		t32 = sw.getNanoTime();
		sw.reset();

//Starts stop watch, performs binary insertion sort on 4096 word array, stores result in t33, stops and resets timer
		sw.start();
		Insertion.sortBinary(wordArray4096);
		sw.stop();
		t33 = sw.getNanoTime();
		sw.reset();
		
		assertTrue(Insertion.isSorted(wordArray16));
		assertTrue(Insertion.isSorted(wordArray256));
		assertTrue(Insertion.isSorted(wordArray4096));
	}
	
	@Test
	public void testMerge() throws FileNotFoundException {

//Starts stop watch, performs merge sort on 16 word array, stores result in t41, stops and resets timer
		sw.start();		Merge.sortMerge(wordArray16);		sw.stop();		t41 = sw.getNanoTime();
		sw.reset();
//Starts stop watch, performs merge sort on 256 word array, stores result in t42, stops and resets timer
		sw.start();		Merge.sortMerge(wordArray256);		sw.stop();
		t42 = sw.getNanoTime();		sw.reset();		
//Starts stop watch, performs merge sort on 4096 word array, stores result in t43, stops and resets timer
		sw.start();		Merge.sortMerge(wordArray4096);		sw.stop();		t43 = sw.getNanoTime();
		sw.reset();
		
		assertTrue(Merge.isSorted(wordArray16));
		assertTrue(Merge.isSorted(wordArray256));
		assertTrue(Merge.isSorted(wordArray4096));		
	}				@Test	public void testHeapSort() throws FileNotFoundException {
//Starts stop watch, performs heap sort on 16 word array, stores result in t51, stops and resets timer		sw.start();		Heap.sortHeap(wordArray16);		sw.stop();		t51 = sw.getNanoTime();
		sw.reset();		
//Starts stop watch, performs heap sort on 256 word array, stores result in t52, stops and resets timer
		sw.start();		Heap.sortHeap(wordArray256);		sw.stop();
		t52 = sw.getNanoTime();		sw.reset();
		
//Starts stop watch, performs heap sort on 4096 word array, stores result in t53, stops and resets timer
		sw.start();		Heap.sortHeap(wordArray4096);		sw.stop();		t53 = sw.getNanoTime();
		sw.reset();
		
		assertTrue(Heap.isSorted(wordArray16));
		assertTrue(Heap.isSorted(wordArray256));
		assertTrue(Heap.isSorted(wordArray4096));
	}
}