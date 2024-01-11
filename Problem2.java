import java.util.Arrays;
import java.util.Scanner;

/*
 * Given three sorted arrays, you will write a method to merge these three arrays and return the merged sorted array. 
 * 
 * Example input: A = [23, 29, 31, 37]
 * B = [4, 9, 16, 25, 36]
 * C = [8, 27, 64, 125]
 * 
 * The output will be [4, 8, 9, 16, 23, 25, 27, 29, 31, 36, 37, 64, 125]
 * 
 */

public class Problem2 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		// System.out.println("Enter the size of the first array");
		int size1 = input.nextInt();
		int[] firstArray = new int[size1];

		// System.out.println("Enter the elements of the first array: ");
		for (int i = 0; i < size1; i++) {
			firstArray[i] = input.nextInt();
		}

		// System.out.println("Enter the size of the second array");
		int size2 = input.nextInt();
		int[] secondArray = new int[size2];

		// System.out.println("Enter the elements of the second array: ");
		for (int i = 0; i < size2; i++) {
			secondArray[i] = input.nextInt();
		}

		// System.out.println("Enter the size of the third array");
		int size3 = input.nextInt();
		int[] thirdArray = new int[size3];

		// System.out.println("Enter the elements of the third array: ");
		for (int i = 0; i < size3; i++) {
			thirdArray[i] = input.nextInt();
		}

		int[] result = mergeSortedArrays(firstArray, secondArray, thirdArray);

		System.out.println("Merged sorted array: ");
		for (int item : result) {
			System.out.printf("%d ", item);
		}
		input.close();
	}

	private static int[] mergeSortedArrays(int[] a, int[] b, int[] c) {
		// First, the program initializes an array w/ a size equivalent to all the parameter arrays combined.
		int[] mergedSortedArray = new int[a.length + b.length + c.length];
		int i, j, k, l;

		// Counter variables for the while loops to sort the big array
		i = 0;
		j = 0;
		k = 0;
		l = 0;

		// Several while loops are used to check what the lowest value is from each of the 3 parameter arrays, 
		// whichever value is lower is added to the big array then the next value(s) are checked until the big array is full and completely sorted. 
		while(i < a.length && j < b.length && k < c.length) {
			if (a[i] <= b[j] && a[i] <= c[k]) {
				mergedSortedArray[l] = a[i];
				i++;
				l++;
			} else if (b[j] <= a[i] && b[j] <= c[k]) {
				mergedSortedArray[l] = b[j];
				l++;
				j++;
			} else {
				mergedSortedArray[l] = c[k];
				l++;
				k++;
			}
		}
		while (i < a.length && j < b.length) {
			if (a[i] <= b[j]) {
				mergedSortedArray[l] = a[i];
				i++;
				l++;
			} else {
				mergedSortedArray[l] = b[j];
				j++;
				l++;
			}
		}
		while (i < a.length && k < c.length) {
			if (a[i] <= c[k]) {
				mergedSortedArray[l] = a[i];
				i++;
				l++;
			} else {
				mergedSortedArray[l] = c[k];
				k++;
				l++;
			}
		}
		while (j < b.length && k < c.length) {
			if (b[j] <= c[k]) {
				mergedSortedArray[l] = b[j];
				j++;
				l++;
			} else {
				mergedSortedArray[l] = c[k];
				k++;
				l++;
			}
		}
		while (i < a.length) {
			mergedSortedArray[l] = a[i];
			i++;
			l++;
		}
		while (j < b.length) {
			mergedSortedArray[l] = b[j];
			j++;
			l++;
		}
		while (k < c.length) {
			mergedSortedArray[l] = c[k];
			k++;
			l++;
		}
		return mergedSortedArray;
	}
}
