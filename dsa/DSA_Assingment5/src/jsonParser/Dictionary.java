package jsonParser;

import java.util.List;

/**
 * Interface to provide methods for dictionary
 * 
 * @author krishna.meghwal_meta
 * @created-on 11-03-2021
 */
public interface Dictionary<K extends Comparable<K>, V> {

	public void add(K key, V value);

	public boolean delete(K key);

	public V get(K key);

	public List<TreeDictNode<K, V>> sortAccordingToKey();

	public List<TreeDictNode<K, V>> sortAccordingToKeyConditional(K key1, K key2);

}
