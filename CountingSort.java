import java.util.*;

public class CountingSort {

  static int[] countingSort(int[] array) {
    // First, the method declares a maxValue integer variable to discover what the max value in the array passed to the 
    // method is. 
    int maxValue = 0;

    // The method then loops through the array to find what the max value is and assigns it to the appropriate variable.
    for (int i = 0; i < array.length; i++) {
      maxValue = Math.max(maxValue, array[i]);
    }

    // Once the max value is found, a new, empty array is created with a size equaling the max value (plus 1) found earlier. 
    int[] numOfOccurences = new int[maxValue + 1];

    // The method then loops through and sums each entry in the array and assigns it to the matching index in the newly
    // created array. (e.g. value 85 in the parameter array is assigned to index 85 in the new array).
    for (int i = 0; i < array.length; i++) {
      numOfOccurences[array[i]]++;
    }

    // Once the new array with the number of occurences of each value is created, it then returns that array back to the 
    // calling method. 
    return numOfOccurences;
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    // Read the number of inputs
    int n = in.nextInt();

    int[] array = new int[n];
    // Read the inputs into an array
    for (int i = 0; i < n; i++) {
      array[i] = in.nextInt();
    }
    // result will contain the counts of the numebrs
    int[] result = countingSort(array);
    for (int i = 0; i < result.length; i++) {
      System.out.print(result[i] + (i != result.length - 1 ? " " : ""));
    }
    System.out.println();

    in.close();
  }
}
