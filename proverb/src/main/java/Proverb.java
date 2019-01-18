class Proverb {
	private String[] words;

    Proverb(String[] words) {
        this.words = words;
    }

    String recite() {
        String result = "";
		if(words.length==0)
			return"";
		for (int i = 0; i < words.length; i++) {
			if (i == words.length - 1)
				break;
			result += String.format("For want of a %s the %s was lost.", words[i], words[i + 1]) + "\n";
		}
		result += String.format("And all for the want of a %s.", words[0]);

		return result;
    }

}
