class IsogramChecker {

    boolean isIsogram(String phrase) {
		
		char[] characters = phrase.toLowerCase().toCharArray();

		for (int i = 0; i < characters.length; i++) {
			for (int j = i + 1; j < characters.length; j++) {
				if (characters[i] == characters[j]) {
					if (characters[i] != '-' && characters[i] != ' ')
						return false;

				}

			}

		}

		return true;
       
    }

}
