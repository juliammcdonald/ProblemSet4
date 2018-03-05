/*
FILENAME: Sort.java
WHO: Julia McDonald, Xinhui Xu
WHEN: Sept 16, 2017
WHAT: Assignment 3 Task 3 Subtask 1
*/

public class Sort {  
  
  /*
  * Sorts the integers in the input array in increasing order

  sortArray takes an int array, arrayA.
  after declaring variables maxNum, maxIndex and iterator i and j,
  the outer loops steps through arrayA beginning at the last element.

  initially it assumes that the maximum integer is at index 0.
  then, the inner loop steps from index 1 to the outer loop index j,
  comparing the number at index i to the assumed max number.
  each time the number at index i is larger the current max number,
  the max number and the max index are updated. 
  
  Then, it swaps the value in maxIndex with the value in j, the largest index.
  j is decremented by one.

  It iterates through the entire array, swapping values as needed.
  
  */
  public static void sortArray (int[] arrayA) {
    int maxNum;    // maximum integer so far
    int maxIndex;  // index of maximum integer
    int i, j;
    for (j = arrayA.length - 1; j > 0; j--) {
      maxIndex = 0;
      maxNum = arrayA[0];
      for (i = 1; i <= j; i++) 
        if (arrayA[i] > maxNum) {
          maxNum = arrayA[i];
          maxIndex = i;
        }
      swap(arrayA, maxIndex, j);
    }
  }
  
/** 
  * Exchanges the contents of locations i and j in the input array
  */
  private static void swap (int[] arrayA, int i, int j) {
    int temp = arrayA[i];
    arrayA[i] = arrayA[j];
    arrayA[j] = temp;
  }
  
  /** CUSTOM SORT IN DECREASING ORDER **/
    public static void sortArrayDec (int[] arrayA) {
    int minNum;    // maximum integer so far
    int minIndex;  // index of maximum integer
    int i, j;
    for (j = arrayA.length - 1; j > 0; j--) {
      minIndex = 0;
      minNum = arrayA[0];
      for (i = 1; i <= j; i++) 
        if (arrayA[i] < minNum) {
          minNum = arrayA[i];
          minIndex = i;
        }
      swap(arrayA, minIndex, j);
    }
  }
  
  
}
