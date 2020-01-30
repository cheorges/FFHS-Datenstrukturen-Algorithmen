package ch.ffhs.dua.tree;

import java.util.Stack;

/**
 * Klasse zum Traversieren eines Baumes mit Tiefensuche.
 * Diese Implementierung verwende keine Rekursion, sondern einen Stack.
 *
 * @param <N>
 */
public abstract class DepthFirstTraverserStack<N> {
	/**
	 * Traversiert einen Baum mit Tiefensuche.
	 * @param root Die Wurzel des zu traversierenden Baumes.
	 */
	public void traverse(TreeNode<N> root) {
		if(root ==  null) return;

		Stack<TreeNode<N>> stack = new Stack();
		stack.push(root);

		while(!stack.empty()){
			TreeNode<N> treeNode = stack.pop();
			visitNode(treeNode.value());

			for(int index = treeNode.children().size(); index > 0; index--) {
				stack.push(treeNode.children().get(index - 1));
			}
		}
	}
	
	/**
	 * Operation auf einem Knoten bei der Traversierung; 
	 * die Operation wird durchgeführt,
	 * bevor die Nachkommen besucht werden.
	 * @param value
	 */
	abstract protected void visitNode(N value);   

}   
