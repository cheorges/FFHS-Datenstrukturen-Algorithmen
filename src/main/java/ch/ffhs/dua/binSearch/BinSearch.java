package ch.ffhs.dua.binSearch;


public class BinSearch {

    public static final int NOT_EXIST = -1;
    /**
    * Findet für einen aufsteigend geordneten Array zu einer Zahl value
    * den kleinsten und den grössten Index.
    *
    * @param array
    * @param value
    * @return Ein Paar mit kleinestem und grösstem Index oder
    * null, wenn der gegebene Wert im array nicht vorkommt.
    */
   public static Pair search(int[] array, int value) {
      int firstPosition = searchFirstElementPosition(array, value);
      int lastPosition = searchLastElementPosition(array, value);

      if (firstPosition == NOT_EXIST && lastPosition == NOT_EXIST) {
         return null;
      }

      return new Pair(firstPosition, lastPosition);
   }

   private static int searchFirstElementPosition(int[] array, int value) {
      int leftIndex = 0, rightIndex = array.length - 1;

      while (leftIndex <= rightIndex) {
         int index = (leftIndex + rightIndex) / 2;

         if ((index == 0 || array[index - 1] < value) && array[index] == value) {
            return index;
         } else if (array[index] < value) {
            leftIndex = index + 1;
         } else {
            rightIndex = index - 1;
         }
      }

      return NOT_EXIST;
   }

   private static int searchLastElementPosition(int[] array, int value) {
      int leftIndex = 0, rightIndex = array.length - 1;

      while (leftIndex <= rightIndex) {
         int index = (leftIndex + rightIndex) / 2;

         if ((index == rightIndex || array[index + 1] > value) && array[index] == value) {
            return index;
         } else if (array[index] > value) {
            rightIndex = index - 1;
         } else {
            leftIndex = index + 1;
         }
      }
      return NOT_EXIST;
   }

}
