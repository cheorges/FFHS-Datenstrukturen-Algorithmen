package ch.ffhs.dua.sort;

public class InsertSort {
   /**
    * Sortiert ein Array durch Einfügen
    *
    * @param array Das zu sortierende Array.
    */
   public static void sort(int[] array) {
      if (array.length < 1)
         return;

      sort(array, 0, array.length - 1);
   }

   /**
    * Sortiert einen durch zwei Grenzen angebenen Teil eines Arrays durch Einfügen.
    * Arrayelemente ausserhalb der Grenzen werden nicht verschoben.
    *
    * @param array
    * @param start Index des ersten  Elementes des Teils, das Sortiert werden muss.
    * @param end   Index des letzten Elementes des Teils, das sortiert werden muss.
    */
   public static void sort(int[] array, int start, int end) {
      for (int index = start + 1; index <= end; index++) {
         int currentValue = array[index];
         int previous = index - 1;

         // Verschiebe previous Element um eine Stelle nach rechts, solange es grösser als das aktuelle Element ist.
         while (previous >= start && array[previous] > currentValue) {
            array[previous + 1] = array[previous];
            previous--;
         }

         array[previous + 1] = currentValue;
      }
   }

}
