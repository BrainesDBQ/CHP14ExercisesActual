/**
 *   file: JFrameMain.java
 */
package c14Package;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * @author Brandon Raines
 * 
 *  Chapter 14 Excercises 
 *
 */
public class JFrameMain extends JFrame {

	private JPanel contentPane;
	
	// Global variables
	int[] myList;  // this will contain integers to be sorted
	private JTextField textFieldSearch;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameMain frame = new JFrameMain();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JFrameMain() {
		setTitle("Brandon Raines Chapter 14 Exercises");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1131, 728);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(632, 75, 439, 565);
		contentPane.add(scrollPane);
		
		JTextArea txtAreaSortoutput = new JTextArea();
		scrollPane.setViewportView(txtAreaSortoutput);
		txtAreaSortoutput.setFont(new Font("Monospaced", Font.PLAIN, 24));
		txtAreaSortoutput.setText("SortOutput here...");

		
		
		JButton btnSorting1 = new JButton("Sorting 1");
		btnSorting1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnSorting1.setBounds(12, 75, 220, 53);
		contentPane.add(btnSorting1);
		btnSorting1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// Simple sorting practice
				// create an array to be processed
				// integers first - call it list
				
				// statically initialize the list
				int[] list = { 16, 30, 24, 7, 62, 45, 5, 55 };
				
				// list all elements before sort
				txtAreaSortoutput.append("list[] before sort ...\n ");
				for (int i=0; i<list.length; i++)
					txtAreaSortoutput.append(list[i] + ", ");
				// send this list to our sorting class
				Sorting.selectionSort(list);
				
				// display the results somewhere
				txtAreaSortoutput.append("\n" + list.toString() + "\n"); // the lazy way to display an array
				for( int i=0; i<list.length; i++)
					txtAreaSortoutput.append(list[i] + ", ");
				txtAreaSortoutput.append("\n \n");
			}
		});
		
		textFieldSearch = new JTextField();
		textFieldSearch.setBounds(458, 261, 86, 49);
		contentPane.add(textFieldSearch);
		textFieldSearch.setColumns(10);
		

		Label label = new Label("This program demonstrates sorting of arrays and lists.");
		label.setFont(new Font("Dialog", Font.PLAIN, 18));
		label.setBounds(10, 10, 1061, 59);
		contentPane.add(label);
		
		JButton btnExerciseBinary = new JButton("Exercise 14-1 Binary Search test");
		btnExerciseBinary.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// sort myList
				// display the first 50 items in the list
				// search for an item in myList
				int iSearch = Integer.parseInt(textFieldSearch.getText());
				// display the result of the search
				String[] sArray = {"search info"};
				
				// make sure list is not null
				if (null !=myList){
					int iResult = Sorting.binarySearchDisplay(myList, myList.length, iSearch, sArray);
							txtAreaSortoutput.append(sArray[0]);
				}
			}
		});
		btnExerciseBinary.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnExerciseBinary.setBounds(12, 257, 432, 53);
		contentPane.add(btnExerciseBinary);
		
		JButton btnCreateAList = new JButton("Create an int[] list");
		btnCreateAList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//creates random numbers in the Array myList
				myList = new int [1000];
				for (int i = 0; i < myList.length; i++)
						myList[i] = (int) (Math.random() * 1000+1);
						
						// Display the first 50 values of my list in the output area
						String str = "myList[] - First 50 Random Numbers: \n";
							for (int i = 0; i < 50; i++)
								str += myList[i] + ", ";
							txtAreaSortoutput.append("\n" + str);
						
				
				// build an array of random integers between 1 and 1000
				
				// Write the code to generate a list of random numbers
				// allocate 1000 items in myList
				// put the values in myList using the Math.random() method
				// display the first 50 values of myList in the output JTextArea
				
				
			}
		});
		btnCreateAList.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnCreateAList.setBounds(12, 141, 248, 53);
		contentPane.add(btnCreateAList);
		
		JButton btnExerciseRemove = new JButton("Exercise 14-2 remove() test");
		btnExerciseRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// create a test array 
				int[] testArray = {1,2,3,4,5,6,7};
				txtAreaSortoutput.append("\n Test Array: \n");
				for (int i = 0; i < testArray.length; i++)
						txtAreaSortoutput.append(testArray[i] + ",");
				
				// remove an item
				
				int newLength = remove(testArray, testArray.length, 4);
				
				if (newLength == testArray.length)
						txtAreaSortoutput.append("\n item 4 not found! \n");
				
				else {
					txtAreaSortoutput.append("\n after removing 4: \n");
					for (int i = 0; i < newLength; i++)
						txtAreaSortoutput.append(testArray[i] + ", ");
					
				}
		
				
			}
		});
		btnExerciseRemove.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnExerciseRemove.setBounds(12, 323, 551, 53);
		contentPane.add(btnExerciseRemove);
		
		JButton btnExerciseRemoveat = new JButton("Exercise 14-3 removeAt() test");
		btnExerciseRemoveat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// create a test array 
				int[] testArray = {1,2,3,4,5,6,7};
				txtAreaSortoutput.append("\n Test Array: \n");
				for (int i = 0; i < testArray.length; i++)
						txtAreaSortoutput.append(testArray[i] + ",");
				
				// remove an item
				
				int newLength = removeAt(testArray, testArray.length, 4);
				
				if (newLength == testArray.length)
						txtAreaSortoutput.append("\n item 4 not found! \n");
				
				else {
					txtAreaSortoutput.append("\n after removing 4: \n");
					for (int i = 0; i < newLength; i++)
						txtAreaSortoutput.append(testArray[i] + ", ");
				
			}
			}
		});
		btnExerciseRemoveat.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnExerciseRemoveat.setBounds(12, 389, 551, 53);
		contentPane.add(btnExerciseRemoveat);
		
		JButton btnExerciseRemoveall = new JButton("Exercise 14-4 removeAll() test");
		btnExerciseRemoveall.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnExerciseRemoveall.setBounds(12, 455, 551, 53);
		contentPane.add(btnExerciseRemoveall);
		
		JButton btnExerciseInsertionsort = new JButton("Exercise 14-9 insertionSort() test");
		btnExerciseInsertionsort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				long clock_start = System.nanoTime();
				
				
				//Makes sure my list has been filled with random numbers
				if (null != myList){
					
				
				Sorting.insertionSort(myList);
				
				long clock_end = System.nanoTime();
				
				// Display the first 50 values of my list in the output area
				String str = "myList[] - First 50 Random Numbers: \n";
					for (int i = 0; i < 50; i++)
						str += myList[i] + ", ";
					txtAreaSortoutput.append("\n" + str);
					txtAreaSortoutput.append("\n Time to run: " + (clock_end - clock_start) + "\n");
					
				
		
					
					
					
				}
				
				else{
					txtAreaSortoutput.append("\n Create Array List First");
				}
				
				
			}
		});
		btnExerciseInsertionsort.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnExerciseInsertionsort.setBounds(12, 521, 551, 53);
		contentPane.add(btnExerciseInsertionsort);
		
		JButton btnExerciseInsertionsortvector = new JButton("Exercise 14-10 insertionSortVector() test");
		btnExerciseInsertionsortvector.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//test a Vector<String> Sort
				
				// create a test vector of Strings
				
				String[] sArray = {"z", "y", "x", "d", "c", "b", "a"};
				Vector<String> vStr = new Vector<String>(Arrays.asList(sArray));
				
				// Display the contents of my vector before the sort
				txtAreaSortoutput.append("\n Vector before sort: \n [");
				for( String str : vStr)
					txtAreaSortoutput.append(str + " ");
				txtAreaSortoutput.append("] \n");
				
				Sorting.insertionSortVector(vStr);
				
				// display the contents of my vector after sort
				txtAreaSortoutput.append("Vector after sort: \n [");
				for( String str: vStr)
					txtAreaSortoutput.append(str + " ");
					txtAreaSortoutput.append("]\n");
				
				
				
				
			}
		});
		btnExerciseInsertionsortvector.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnExerciseInsertionsortvector.setBounds(12, 587, 551, 53);
		contentPane.add(btnExerciseInsertionsortvector);
		
		JButton btnCreateAVector = new JButton("Create a Vector list");
		btnCreateAVector.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
			}
		});
		btnCreateAVector.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnCreateAVector.setBounds(315, 141, 248, 53);
		contentPane.add(btnCreateAVector);
	}
	
	int remove(int[] a, int len, int rval){
		boolean found = false;
		int i = 0;
		while (! found && i  < len){
			
			//comparing I value to increment to I once found true it will stop, if i gets to big/bigger then length it will stop
				found = rval == a[i++];
				
		}
		int j = i - 1; // set j to location of rval in array a
		if (found) {
			
			// i is pointing to the position of the element 1 to the right of value we want to remove
			while (i < len)
				a[j++] = a[i++];
			return len - 1;
		
			
		}
		
		return len;
		
	}
	
	int removeAt(int[] a, int len, int rLocation){
	
			
			//comparing I value to increment to I once found true it will stop, if i gets to big/bigger then length it will stop
for ( int i=rLocation; i<len-1;i++){
	a[i] = a[i+1];
		
			
		}
		
		return len-1;
	
}
}
