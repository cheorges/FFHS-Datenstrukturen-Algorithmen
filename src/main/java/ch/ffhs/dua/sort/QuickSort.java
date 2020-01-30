package ch.ffhs.dua.sort;

import java.util.concurrent.ThreadLocalRandom;

public class QuickSort {

   /**
    * Sortiert ein Array durch Quicksort.
    *
    * @param array Zu sortierendes Array.
    */
   public static void sort(int[] array) {
      if (array.length < 1)
         return;

      sort(array, 0, array.length - 1);
   }

   /**
    * Sortiert ein Teilstück eines Arrays durch Quicksort.
    *
    * @param array ZU sortierenden Array
    * @param start Index des ersten Elementes des Teils, das sortiert werden muss.
    * @param end   Index des letzen Elementes des Teils, das sortiert werden muss.
    */
   public static void sort(int[] array, int start, int end) {
      if (start < end) {
         int partition = partition(array, start, end, findPivot(array, start, end));
         sort(array, start, partition);
         sort(array, partition + 1, end);
      }
   }

   /**
    * Schwellwert, bei welcher Arraygrösse in der Rekursion InsertSort
    * statt Quicksort aufgerufen werden sollte.
    * <p>
    * Durch ausprobieren von Werten.
    */
   static int THRESHOLD = 300; // TODO finden Sie einen sinnvollen Wert

   /**
    * Modifiziertes Quicksorts.
    * Wenn die Grösse des zu sortierenden Arrays in der Rekursion
    * einen Schwellwert unterschreitet, wird InsertSort statt Quicksort
    * aufgerufen.
    *
    * @param array Zu sortierendes Array
    */
   public static void sortPlus(int[] array) {
      if (array.length < 1)
         return;

      sortPlus(array, 0, array.length - 1);
   }

   /**
    * Modifiziertes Quicksorts zum SOrtieren eines Teilstücks eines Arrays.
    * Wenn die Grösse des zu sortierenden Arrays in der Rekursion
    * einen Schwellwert unterschreitet, wird InsertSort statt Quicksort
    * aufgerufen.
    *
    * @param array Zu sortierendes Array
    * @param start Index des ersten  Elementes des zu sortierenden teilstücks.
    * @param end   Index des letzten Elementes des zu sortierenden teilstücks.
    */
   public static void sortPlus(int[] array, int start, int end) {
      if (end - start < THRESHOLD) {
         InsertSort:
         sort(array, start, end);
      } else {
         sort(array, start, end);
      }
   }

   /**
    * Hilfsmethode für Quicksort.
    * Ein Teilstück eines Arrays wird geteilt, so dass alle Elemente,
    * die kleiner als ein gewisses Pivot-Elements sind, links stehen
    * und alle Elemente, die grösser als das Pivot-Element rechts stehen.
    *
    * @param array Array zum Umordnen.
    * @param start Indes des ersten  Elements des Teilstücks, das geteilt werden muss.
    * @param end   Index des letztes Elements des Teilstücks, das geteilt werden muss.
    * @param piv   Index des PiotElements
    * @return Index des Piot-Element nach der Partitionierung.
    */
   static int partition(int[] array, int start, int end, int piv) {
      int pivoElement = array[piv];
      int left = start - 1;
      int right = end + 1;

      while (true) {
         left++;
         while (left < end && array[left] < pivoElement) {
            left++;
         }
         right--;
         while (right > start && array[right] > pivoElement) {
            right--;
         }

         if (left < right) {
            swap(array, left, right);
         } else {
            return right;
         }
      }
   }

   /**
    * Hilfsmethode zum Vertauschen zweier Array-Elemente
    *
    * @param array
    * @param a
    * @param b
    */
   static void swap(int[] array, int a, int b) {
      int tmp = array[a];
      array[a] = array[b];
      array[b] = tmp;
   }

   /**
    * Hilfsmethode zum Finden eines Pivot-Elementes für Quicksort.
    * Zu einem Array und den zwei Indices start und end wird
    * der Index eines möglichen Pivot-Elementes angegeben
    *
    * @param array
    * @param start
    * @param end
    * @return Index eines Pivot-Elementes
    */
   static int findPivot(int[] array, int start, int end) {
      return ThreadLocalRandom.current().nextInt(start, end);
   }
}
