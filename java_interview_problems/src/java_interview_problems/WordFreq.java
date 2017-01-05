package java_interview_problems;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * Print each word from the input, along with the number of times it appears.
 * Print the word/frequency values in alphabetical order and then again in order of their frequency.
 * Do each sort in ascending as well as descending order.
 */

public class WordFreq {

	private String inp;
	private int sign;
	private boolean sortByFreq;

	WordFreq(String inp, boolean ascending, boolean sortByFreq) {
		this.inp = inp;
		this.sign = ascending ? 1 : -1;
		this.sortByFreq = sortByFreq;
	}

	void solve() {
		Map<String, Integer> words = new TreeMap<String, Integer>(new Comparator<String>() {

			@Override
			public int compare(String s1, String s2) {
				return sign * s1.toLowerCase().compareTo(s2.toLowerCase());
			}
			
		});
		for (String word : inp.split("\\s")) {
			if (words.get(word) == null) {
				words.put(word, 0);
			}
			words.put(word, words.get(word) + 1);
		}
		
		Set<String> sortedKeys = words.keySet();
		if (sortByFreq) {
			sortedKeys = sortByValue(words).keySet();
		}
		
		for (String key : sortedKeys) {
			System.out.println("\t" + key + "\tfrequency:" + words.get(key));
		}
		System.out.println();
	}

	public <K, V extends Comparable<? super V>> Map<K, V> sortByValue( Map<K, V> map ) {
		List<Map.Entry<K, V>> list = new LinkedList<Map.Entry<K, V>>(map.entrySet());
		
		Collections.sort(list, new Comparator<Map.Entry<K, V>>() {
			public int compare( Map.Entry<K, V> o1, Map.Entry<K, V> o2 ) {
				return sign * (o1.getValue()).compareTo( o2.getValue() );
			}
		});

		Map<K, V> result = new LinkedHashMap<K, V>();
		
		for (Map.Entry<K, V> entry : list) {
			result.put(entry.getKey(), entry.getValue());
		}
		return result;
	}

	public static void main(String[] args) {
		String inp = "The quick brown fox jumped over a lazy dog two two three three three four four four four";
		System.out.println("Sort by frequency in ascending order:");
		new WordFreq(inp, true, true).solve();
		System.out.println("Sort alphabetically in ascending order:");
		new WordFreq(inp, true, false).solve();
		System.out.println("Sort by frequency in desccending order:");
		new WordFreq(inp, false, true).solve();
		System.out.println("Sort alphabetically in descending order:");
		new WordFreq(inp, false, false).solve();
	}

}
