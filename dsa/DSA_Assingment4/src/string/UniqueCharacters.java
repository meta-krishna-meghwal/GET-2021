package string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Class to find out number of unique characters in a string
 * 
 * @created-on 09-03-2021
 * @author krishna.meghwal_meta
 */
public class UniqueCharacters {
	Map<String, Integer> cached = new HashMap<String, Integer>();
	Set<Character> unique;

	/**
	 * Method to get count of unique characters
	 * 
	 * @param String
	 * @return int
	 */
	public int getUniqueCharactersCount(String s) {
		int ans;
		try {
			ans = cached.get(s);
		} catch (Exception e) {
			ans = countUnique(s);
			cached.put(s, ans);
		}
		return ans;
	}

	/**
	 * Method to calculate count of unique characters
	 * 
	 * @param String
	 * @return int
	 */
	public int countUnique(String s) {
		unique = new HashSet<Character>();
		for (int i = 0; i < s.length(); i++) {
			unique.add(s.charAt(i));
		}
		return unique.size();
	}
}
