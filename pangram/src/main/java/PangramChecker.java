public class PangramChecker {

    public boolean isPangram(String input) {
		
		input = input.toLowerCase();

		if (input.length() < 26)
			return false;
		int i = 0;
		for (char c = 'a'; c <= 'z'; c++) {
			i = input.indexOf(c);
			if (i == -1)
				return false;
		}
		return true;
        
    }

}
