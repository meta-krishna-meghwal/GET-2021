package jsonParser;

/**
 * Class to provide structure for node of a tree
 * 
 * @author krishna.meghwal_meta
 * @created-on 11-03-2021
 */
public class TreeDictNode<K extends Comparable<K>, V> {
	public K key;
	public V value;
	public TreeDictNode<K, V> left = null;
	public TreeDictNode<K, V> right = null;

	public TreeDictNode(K key, V value) {
		this.key = key;
		this.value = value;
	}

}
