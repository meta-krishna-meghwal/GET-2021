package jsonParser;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import employee.CustomQueue;

/**
 * Class to implement dictionary interface
 * 
 * @author krishna.meghwal_meta
 * @created-on 11-03-2021
 */
public class Dict implements Dictionary<Integer, String> {
	public Tree<Integer, String> dictTree = new Tree<Integer, String>();

	public Dict(String str) throws Exception {
		JSONObject json = new JSONObject(str);
		JSONArray ja = names(json);
		for (int i = 0; i < ja.length(); i++) {
			String value = json.getString(String.valueOf(ja.get(i)));
			Integer key = Integer.parseInt(String.valueOf(ja.get(i)));
			add(key, value);
		}

	}

	/**
	 * Method to get all the keys from a JSONObject
	 * 
	 * @param JSONObject
	 * @return JSONArray
	 */
	private static JSONArray names(JSONObject json) {
		JSONArray ja = new JSONArray();
		@SuppressWarnings("unchecked")
		Iterator<String> keys = json.keys();
		while (keys.hasNext()) {
			ja.put(keys.next());
		}
		return ja.length() == 0 ? null : ja;
	}

	/**
	 * Method to add a key-value pair in dictionary
	 * 
	 * @param Integer
	 * @param String
	 */
	@Override
	public void add(Integer key, String value) {
		TreeDictNode<Integer, String> node = new TreeDictNode<Integer, String>(
				key, value);
		dictTree.addNode(node);

	}

	/**
	 * Method to get minimum value in right node
	 * 
	 * @param TreeDictNode
	 *            <Integer, String>
	 * @return int
	 */
	int minValue(TreeDictNode<Integer, String> root) {
		int minv = root.key;
		while (root.left != null) {
			minv = root.left.key;
			root = root.left;
		}
		return minv;
	}

	/**
	 * Method to recursively delete a node from Binary search tree
	 * 
	 * @param TreeDictNode
	 *            <Integer, String>
	 * @param Integer
	 * @return TreeDictNode<Integer, String>
	 */
	TreeDictNode<Integer, String> deleteRecursive(
			TreeDictNode<Integer, String> root, Integer key) {

		if (root == null)
			return root;

		if (key < root.key)
			root.left = deleteRecursive(root.left, key);
		else if (key > root.key)
			root.right = deleteRecursive(root.right, key);

		else {
			if (root.left == null)
				return root.right;
			else if (root.right == null)
				return root.left;
			root.key = minValue(root.right);

			root.right = deleteRecursive(root.right, root.key);
		}

		return root;
	}

	/**
	 * Method to get value from a key in dictionary
	 * 
	 * @param Integer
	 * @param TreeDictNode
	 *            <Integer, String>
	 * @return String
	 * @*/
	private static String getValue(TreeDictNode<Integer, String> root,
			Integer key) {
		CustomQueue<TreeDictNode<Integer, String>> queue = new CustomQueue<TreeDictNode<Integer, String>>();
		queue.enQueue(root);
		queue.enQueue(null);
		TreeDictNode<Integer, String> temp;
		while (queue.size > 1) {
			temp = queue.deQueue();
			if (temp == null) {
				queue.enQueue(null);
			} else {

				if (temp.key == key) {
					return temp.value;
				}
				if (temp.left != null)
					queue.enQueue(temp.left);
				if (temp.right != null)
					queue.enQueue(temp.right);
			}

		}

		return null;
	}

	/**
	 * Method to print dictionary
	 * 
	 * @param TreeDictNode
	 *            <Integer, String>
	 */
	static void printDict(TreeDictNode<Integer, String> root) {
		if (root != null) {
			printDict(root.left);
			System.out.print(root.key + " : " + root.value + '\n');
			printDict(root.right);
		}
	}

	/**
	 * Method to get list of nodes in sorted order
	 * 
	 * @param TreeDictNode
	 *            <Integer, String>
	 * @param List
	 *            <TreeDictNode<Integer, String>>
	 */
	private static void getNode(TreeDictNode<Integer, String> root,
			List<TreeDictNode<Integer, String>> nodes) {
		if (root != null) {
			getNode(root.left, nodes);
			nodes.add(root);
			getNode(root.right, nodes);
		}
	}

	/**
	 * Method to get list of nodes in sorted order in a range
	 * 
	 * @param TreeDictNode
	 *            <Integer, String>
	 * @param List
	 *            <TreeDictNode<Integer, String>>
	 * @param int
	 * @param key
	 */
	private static void getNodeConditional(TreeDictNode<Integer, String> root,
			List<TreeDictNode<Integer, String>> nodes, int key1, int key2) {

		if (root != null) {
			getNodeConditional(root.left, nodes, key1, key2);
			if (root.key >= key1 && root.key <= key2)
				nodes.add(root);
			getNodeConditional(root.right, nodes, key1, key2);
		}
	}

	/**
	 * Wrapper method for deleting a node
	 * 
	 * @param Integer
	 * @return boolean
	 */
	@Override
	public boolean delete(Integer key) {
		dictTree.root = deleteRecursive(dictTree.root, key);
		return false;
	}

	/**
	 * Wrapper method for getting value
	 * 
	 * @param Integer
	 * @return String
	 */
	@Override
	public String get(Integer key) {
		return getValue(dictTree.root, key);
	}

	/**
	 * Wrapper method for getting List of nodes in sorted order
	 * 
	 * 
	 * @return List<TreeDictNode<Integer, String>>
	 */
	@Override
	public List<TreeDictNode<Integer, String>> sortAccordingToKey() {
		List<TreeDictNode<Integer, String>> nodes = new ArrayList<TreeDictNode<Integer, String>>();
		getNode(dictTree.root, nodes);
		return nodes;
	}

	/**
	 * Wrapper method for getting List of nodes in sorted order in a range
	 * 
	 * 
	 * @return List<TreeDictNode<Integer, String>>
	 */
	@Override
	public List<TreeDictNode<Integer, String>> sortAccordingToKeyConditional(
			Integer key1, Integer key2) {
		List<TreeDictNode<Integer, String>> nodes = new ArrayList<TreeDictNode<Integer, String>>();
		getNodeConditional(dictTree.root, nodes, key1, key2);
		return nodes;
	}

}
