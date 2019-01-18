import java.util.List;
import java.util.Arrays;

class Acronym {
	
	String phrase;

    Acronym(String phrase) {
        this.phrase=phrase;
    }

    String getAcronym() {
		String result = "";
		List<String> words = Arrays.asList(phrase.split("\\s+|-+"));

		for (String s : words) {

			if (s.equals(""))
				continue;
			result += (s.charAt(0) + "").toUpperCase();

		}

		return result;
		
        
    }

}
