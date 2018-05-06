/*
 * This is a program to demonstrate how to search through a file using Binary
 * Search.
 */

package binarysearchfileread;
import java.io.*;
import java.util.*;
/**
 *
 * @author wilheld
 */
public class BinarySearchFileRead {
    static int numSearches;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList <String> colours = new ArrayList <String>();
        BufferedReader br = null;  // Create a buffered reader to read a file

        try {
            br = new BufferedReader(new FileReader("colours.txt"));//attempt to open the file.
            String word;
            while ((word = br.readLine()) != null ){
                colours.add(word);//As long as there are more lines, read in from the file.
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        String [] colourList = new String[colours.size()];
        colours.toArray(colourList);  //change the ArrayList into an array.


        System.out.println ("Binary search for green: " + binarySearch(colourList, 0, colourList.length-1, "green"));
        System.out.println ("Number of searches: " + numSearches);
        numSearches = 0;

        System.out.println ("Binary search for orange: " + binarySearch(colourList, 0, colourList.length-1, "orange"));
        System.out.println ("Number of searches: " + numSearches);
        numSearches = 0;

        System.out.println ("Binary search for pink: " + binarySearch(colourList, 0, colourList.length-1, "pink"));
        System.out.println ("Number of searches: " + numSearches);
        numSearches = 0;

        System.out.println ("Binary search for salmon: " + binarySearch(colourList, 0, colourList.length-1, "salmon"));
        System.out.println ("Number of searches: " + numSearches);
        numSearches = 0;
    }

    /** precondition: Array A must be sorted in alphabetical order
     * Parameters: A - sorted array
     * left - leftmost index in array
     * right - rightmost index in array
     * V - item to be looked for in the array
     */
     public static Boolean binarySearch(String [] A, int left, int right, String V){
         int middle;
         numSearches ++;
         if (left > right) {//V cannot exist if the index values have passed each other.
             return false;
         }

         middle = (left + right)/2;
         int compare = V.compareTo(A[middle]);//Compare the middle value in the remaining array to V.
         if (compare == 0) { //Item found.
             return true;
         }
         if (compare < 0) {
             return binarySearch(A, left, middle-1, V);//V is to the left of the middle index.
         } else {
             return binarySearch(A, middle + 1, right, V);//V is to the right of the middle index.
         }
     }
}
