import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.HashMap;
public class Anagram{
	
	String word;
	
	public Anagram(String s){
		
		word=s;
		
	}
	
	
	public List<String> match(List<String> strings) {
		word = word.trim().toLowerCase();
		char[] chars = word.toCharArray();
		
		
		HashMap<Character, Integer> wordCharCountMap = new HashMap<Character, Integer>();

		for (char c : chars) {
			if (wordCharCountMap.containsKey(c)) {

				wordCharCountMap.put(c, wordCharCountMap.get(c) + 1);
			} else {

				wordCharCountMap.put(c, 1);
			}
		}
		
		

		List<String> results = new ArrayList<String>();

		for (String s : strings) {
			s = s.trim();

			Character[] charObjectArray = s.toLowerCase().chars().mapToObj(c -> (char) c).toArray(Character[]::new);
			List<Character> characterObjects = Arrays.asList(charObjectArray);

			if (s.length() != word.length() || s.equalsIgnoreCase(word)) {
				continue;
			}

			boolean flag = false;
			for (int i = 0; i < chars.length; i++) {
				if (!characterObjects.contains(chars[i])) {
					flag = true;
					break;

				}

			}
			
			
			HashMap<Character, Integer> stringCharCountMap = new HashMap<Character, Integer>();

			for (Character c : charObjectArray) {
				if (stringCharCountMap.containsKey(c)) {

					stringCharCountMap.put(c, stringCharCountMap.get(c) + 1);
				} else {

					stringCharCountMap.put(c, 1);
				}
			}

			if (!wordCharCountMap.equals(stringCharCountMap))
				continue;
			

			if (!flag)
				results.add(s);

		}

		return results;

	}
	
	
	
}