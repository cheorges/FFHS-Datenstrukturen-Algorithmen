package ch.ffhs.dua.tree;

import java.util.Iterator;
import java.util.Stack;

/**
 * Ein Iterator, der in Depth-First Reihenfolge alle Werte
 * der Knoten eines Baumes ausgibt.
 *
 * @param <N> Typ des Knotenwertes.
 */
public class TreeIterator<N> implements Iterator<N> {

   private Stack<TreeNode<N>> stack = new Stack();
   private TreeNode<N> treeNode;

   /**
    * Erzeugt einen neuen neuen Baum-Knoten-Iterator
    *
    * @param root Die Wurzel des zu traversierenden Baumes.
    */
   public TreeIterator(TreeNode<N> root) {
      if (root == null)
         return;

      stack.push(root);
      treeNode = stack.pop();
   }

   @Override
   public boolean hasNext() {
      return !stack.isEmpty();
   }

   @Override
   public N next() {
      TreeNode<N> current = treeNode;

      for (int index = treeNode.children().size(); index > 0; index--) {
         stack.push(treeNode.children().get(index - 1));
      }

      if (hasNext()) {
         treeNode = stack.pop();
      }

      return current.value();
   }

   // remove() muss nicht implementiert werden.
}
