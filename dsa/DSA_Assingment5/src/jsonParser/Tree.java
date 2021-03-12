package jsonParser;

/**
 * Class to create a Binary search tree
 * 
 * @author krishna.meghwal_meta
 * @created-on 11-03-2021
 */
public class Tree<K extends Comparable<K>, V> {

	public TreeDictNode<K, V> root;

	public Tree() {
		root = null;
	}

	/**
	 * Method to insert a node in BST
	 * 
	 * @param TreeDictNode
	 *            <K, V>
	 * @param TreeDictNode
	 *            <K, V>
	 * */
	private void insert(TreeDictNode<K, V> root, TreeDictNode<K, V> node) {

		int r = node.key.compareTo(root.key);

		if (r < 0) {
			if (root.left == null)
				root.left = node;
			else {
				insert(root.left, node);
			}
		} else {
			if (root.right == null)
				root.right = node;
			else {
				insert(root.right, node);
			}
		}
	}

	/**
	 * Method to add a node in BST
	 * 
	 * @param TreeDictNode
	 *            <K, V>
	 */
	public void addNode(TreeDictNode<K, V> node) {
		if (root == null) {
			root = node;

		} else {

			int r = node.key.compareTo(root.key);

			if (r < 0) {
				if (root.left == null)
					root.left = node;
				else {
					insert(root.left, node);
				}
			} else {
				if (root.right == null)
					root.right = node;
				else {
					insert(root.right, node);
				}
			}
		}
	}
}
