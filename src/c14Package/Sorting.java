/**
 *   file: Sorting.java
 */
package c14Package;

import java.util.Vector;

/**
 * Brandon Raines
 * 
 * Sorting Class
 * 
 *
 * 
 * Description: 
 * 
 * 	This is the class containing various codes for diffirent excercises from CHP14
 *
 */
public class Sorting {

	
	// Around page 890
	public static void selectionSort(int[] list) {
		// sort the integer array given using a Selection sort
		
		
		// find the index (location) of the smallest item in the list
		int indexSmallest; // before looping through all elements, first item is smallest
		
		
		
		for( int Index = 0; Index <list.length -1; Index++ ){
			// finds index location of smallest item
			
				indexSmallest = Index;  // save the location of smaller elementsindexSmallest = Index;
		
		// once the for loop is complete, indexSmallest is the location of the first
		
				
				// find smallest item in the rest of list
		for (int minIndex = Index +1; minIndex < list.length; minIndex++)
			if(list[minIndex] < list[indexSmallest])
				indexSmallest = minIndex;
		//once the inner for the loop is complete, smallest is the location of the first
		// smallest element in the list (if values can repeat)
		
		if (Index != indexSmallest) {
			// swap the values if index is not smallest
			
			int temp = list [Index];
			list[Index] = list[indexSmallest];
			list[indexSmallest] = temp;
			}
		}
		
	}
	
	
	
	
		
		public static void insertionSort( int[] list ) {
			
			// This code will sort the int [] list and move items from the left to right
			// it modififies the list in place

		// see chapter 14 for the necessary code to perform an insertion sort

		int firstOutOfOrder, location;

		int temp;

		//Process every element in the list

		for (firstOutOfOrder = 1; firstOutOfOrder < list.length; firstOutOfOrder++)
			
			// if something is out of order it will look for element on the left is larger then element on the right and looks for new spot

			if (list[firstOutOfOrder] < list[firstOutOfOrder - 1]) {

				temp = list[firstOutOfOrder]; // more efficient swapping

				location = firstOutOfOrder;

				do { //shifts elements to the right

					list[location] = list[location - 1];

					location--;

				} while (location > 0 && list[location - 1] > temp);

				list[location] = temp;

			}

			}  // end of insertionSort()
		
		// see chapter 14 for the necessary code to perform an insertion sort
		// include comments
	
	
	
	// Chapter 14 Programming Exercise 1  part 1
	// explain the binarySearch algorithm as described on page 918
	public static int binarySearch(int[] list, int listLength, int searchItem) {
		
		// type in the code for the binary search found on page 918
		// write the code
		
		int first = 0;
		int last = listLength -1;
		int mid;
		boolean found = false;
		
		while (first <= last && !found) {
			mid = (first + last) / 2; // middle location in tjhe list
			if (list[mid]== searchItem)
				found = true; // we are done if we found value
			else 
				if (list[mid] > searchItem) // middle elemnt is greater
					last = mid -1; // next iteration will search left
			
				else
					first = mid + 1; // next iteration will be right half
		}
		
		return found ? first : -1;  // replace this with the correct return statement
	}
	
	
	// Chapter 14 Programming Exercise 2
	public static int remove( int[] intArray, int aLength, int removeItem ) {
		// find and remove the first occurrence of removeItem in intArray
		
		int i = 0;
		boolean found = false;
		while(!found && i <aLength)
			found = intArray[i++] == removeItem; // compare increment
		if(found) {
			while (i < aLength)
				intArray[i-1] = intArray[i++]; // assign, increments
			return aLength - 1; // done
			
		} return aLength; 
		
		
		// display a console error where appropriate
	}
	
	
	// Chapter 14 Programming Exercise 3
	public static int removeAt( int[] intArray, int aLength, int index )  {
		// remove item at location index, reducing the length of the array by 1
		while (index < aLength)
			intArray[index++] = intArray[index+1];
		return aLength-1;
		
		// display an error message where needed
	}
	
	
	// Chapter 14 Programming Exercise 4
	public static void removeAll( int[] intArray, int aLength, int removeItem ) {
		
		// delete all occurrences of removeItem from intArray
	}
	
	
	// Chapter 14 Programming Exercise 9
	public static void insertionSortVector(Vector<String> vString)  {
		
		// add the appropriate Vector type variable to be sorted
		
		// Vectors are similar to ArrayLists
		// iterate through all items in the vector
		
		for (int i = 1; i < vString.size(); i++){
			String temp = vString.get(i);
			int j = i - 1;
			
			// find the correct position for string temp in the vector vString
			while (0 <= j && vString.get(j).compareTo(temp) > 0){
				vString.set(j, vString.get(j -1));
				j --;
			}
			
			vString.set(j + 1, temp);
			
		}
		
	}





	public static int binarySearchDisplay(int[] list, int listLength, int searchItem, String[] sDebug) {
		// TODO Auto-generated method stub
		int first = 0;
		int last = listLength -1;
		int mid;
		boolean found = false;
		String sInfo = "iteration\tfirst\tlast\tmid\tlist[mid] \n";
		int iteration = 1;
		
		while (first <- last && !found){
			mid = (first + last) / 2; // middle location in list
			sInfo += iteration++ + "\t\t" + first + "\t" + last + "\t" + mid + "\t" + list[mid] + "\n";
			
					if (list[mid] == searchItem)
						found = true;
					else 
						if (list[mid] > searchItem) // middle elemnt is greater
							last = mid -1;
						else
							first = mid +1; 
			
		}
		
		sDebug[0] = sInfo;
		//shortcut for if (found) return first; else return -1;
		return found ? first : -1;
	}
	
}
