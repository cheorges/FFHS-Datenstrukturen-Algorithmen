package ch.ffhs.dua.permutations;

public class Permutations {

   private static int listIndex;
   private static int[][] result;

   /**
    * Erzeugt ein Array von allen Permutationen von {0,1,2,3,...,n-1}.
    *
    * @param n Anzahl Elemente in einer Permutation.
    * @return Ein Array von Permutationen; jede Permutation ist ein Array von Integern.
    */
   public static int[][] permutations(int n) {
      if (n == 0) {
         return new int[0][];
      }

      listIndex = 0;
      result = new int[calculateCombinations(n)][n];

      startPermutation(0, range(n));

      return result;
   }

   private static void startPermutation(int start, int[] numbers) {
      if (start == numbers.length - 1) {
         result[listIndex++] = listCopy(numbers);
      } else {
         for (int index = start; index < numbers.length; index++) {
            swapNumbers(numbers, index, start);
            startPermutation(start + 1, numbers);
            swapNumbers(numbers, index, start);
         }
      }
   }

   private static void swapNumbers(int[] numbers, int i, int j) {
      int temp = numbers[i];
      numbers[i] = numbers[j];
      numbers[j] = temp;
   }

   private static int[] listCopy(int[] numbers) {
      int[] list = new int[numbers.length];

      for (int i = 0; i < numbers.length; i++) {
         list[i] = numbers[i];
      }

      return list;
   }

   private static int calculateCombinations(int n) {
      int combinations = 1;

      for (int index = 1; index <= n; index++) {
         combinations = combinations * index;
      }

      return combinations;
   }

   private static int[] range(int n) {
      int[] range = new int[n];

      for (int index = 0; index < n; index++) {
         range[index] = index;
      }

      return range;
   }

}
