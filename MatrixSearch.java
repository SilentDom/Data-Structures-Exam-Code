import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class MatrixSearch {

	// This method converts a list of integers to an array of integers
	public static int[] convertIntegers(List<Integer> integers) {
		int[] ret = new int[integers.size()];
		Iterator<Integer> iterator = integers.iterator();
		for (int i = 0; i < ret.length; i++) {
			ret[i] = iterator.next().intValue();
		}
		return ret;
	}

	// Search for a key in a matrix and returns all the indices in an array
	// The indices are converted into a linear form.
	public static int[] linearSearchExtended(int[][] numbers, int key) {
		// First, the program initializes a list and adds the 2-D array values to it for
		// the convertIntegers method.
		List<Integer> inputList = new ArrayList<Integer>();
		for (int i = 0; i < numbers.length; i++) {
			for (int j = 0; j < numbers[i].length; j++) {
				inputList.add(numbers[i][j]);
			}
		}
		// The program then assigns that new 1-D array to a value for checking for the
		// key. Additionally, an ArrayList 'foundIndices' is declared to store the found indices. 
		int[] newArray = convertIntegers(inputList);
		List<Integer> foundIndices = new ArrayList<Integer>();

		// Program iterates through the 1-D array to find the key, then adds the index to a new ArrayList for ease of 
		// manipulation. Once the for loop is done, it calls the convertIntegers method on the foundIndices variable to 
		// convert it back to a 1-D array to correctly output the index the values were found at. 
		for (int i = 0; i < newArray.length; i++) {
			if (newArray[i] == key) {
				foundIndices.add(i);
			}
		}
		if (foundIndices.size() > 0) {
			return convertIntegers(foundIndices);
		} else {
			return new int[] {};
		}
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int nRow, nColumn = 0;
		do {
			nRow = input.nextInt();
			nColumn = input.nextInt();
		} while (nRow <= 0 || nColumn <= 0);
		int[][] numbers = new int[nRow][nColumn];
		for (int i = 0; i < nRow; i++) {
			for (int j = 0; j < nColumn; j++) {
				numbers[i][j] = input.nextInt();
			}
		}

		int key = input.nextInt();

		int[] allIndices = linearSearchExtended(numbers, key);

		if (allIndices.length == 0) {
			System.out.printf("%d not found!%n", key);
		} else {
			System.out.printf("Found %d at index: ", key);
			for (int i = 0; i < allIndices.length; i++) {
				System.out.printf("%d ", allIndices[i]);
			}
		}
	}
}
