package ch.ffhs.dua.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Traverser-Klasse für Breitensuche.
 * Ein Traverser mit Breitensuche besucht zuerst die Wurzel, 
 * dann die Kinder der Wurzel, dann die Enkel usw.
 *
 * @param <N>
 */
public abstract class BreadthFirstTraverser<N> {

	/**
	 * Methode zum Traversieren eines Baumes.
	 * @param node Wurzelknoten des Baumes.
	 */
	public void traverse(TreeNode<N> node) {
		if (node == null)
			return;

		visitNode(node.value());
		Queue<TreeNode<N>> queue = new LinkedList();
		queue.addAll(node.children());

		while (!queue.isEmpty()) {
			TreeNode<N> treeNode = queue.poll();
			visitNode(treeNode.value());

			for (int index = 0; index < treeNode.children().size(); index++) {
				queue.add(treeNode.children().get(index));
			}
		}
	}
	
	/**
	 * Diese Methode gibt an, was beim travsersieren gemacht werden sollte.
	 * @param value
	 */
	protected abstract void visitNode(N value);
}
