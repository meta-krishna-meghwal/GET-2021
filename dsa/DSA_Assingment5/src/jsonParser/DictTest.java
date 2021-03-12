package jsonParser;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class DictTest {
	String string = "{\"1\": \"JavaScript\", \"2\": \"Python\", \"3\": \"Java\"}";
	Dict dict;

	@Before
	public void addAndConstructureTest() throws Exception {
		dict = new Dict(string);
		dict.add(10, "C++");
		dict.add(13, "Ruby");
		dict.add(12, "C");
		dict.add(7, "HTML");
		dict.add(90, "CSS");
		dict.add(73, "Scala");
	}

	@Test
	public void deleteTest() {
		Dict.printDict(dict.dictTree.root);
		dict.delete(10);
		Dict.printDict(dict.dictTree.root);
	}

	@Test
	public void SortedTest() {
		List<TreeDictNode<Integer, String>> nodes = dict.sortAccordingToKey();
		for (int i = 0; i < nodes.size() - 1; i++) {
			assertTrue(nodes.get(i).key <= nodes.get(i + 1).key);
		}
	}

	@Test
	public void GetNodeTest() {
		String value = dict.get(10);
		assertEquals(0, value.compareTo("C++"));
	}

	@Test
	public void SortedConditionalTest() {
		List<TreeDictNode<Integer, String>> nodes = dict
				.sortAccordingToKeyConditional(10, 90);
		for (int i = 0; i < nodes.size() - 1; i++) {
			assertTrue(nodes.get(i).key <= nodes.get(i + 1).key
					&& nodes.get(i).key >= 10 && nodes.get(i).key <= 90);
		}
	}
}
