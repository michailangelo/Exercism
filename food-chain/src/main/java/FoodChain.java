public class FoodChain{
	public String verse(int verse){
		String result = "I know an old lady who swallowed ";
		String common1 = "She swallowed the ";
		String common2 = "to catch ";
		switch (verse) {
		case 1:
			result += "a fly.\nI don't know why she swallowed the fly. Perhaps she'll die.";
			break;
		case 2:
			result += "a spider.\nIt wriggled and jiggled and tickled inside her.\n" + common1 + "spider " + common2
					+ "the fly.\n" + verse(verse - 1).substring(verse(verse - 1).indexOf("\n")).trim();
			break;
		case 3:
			result += "a bird.\nHow absurd to swallow a bird!\n" + common1 + "bird " + common2
					+ "the spider that wriggled and jiggled and tickled inside her.\n"
					+ verse(verse - 1).substring(verse(verse - 1).indexOf("\nS")).trim();
			break;
		case 4:
			result += "a cat.\nImagine that, to swallow a cat!\n" + common1 + "cat " + common2 + "the bird.\n"
					+ verse(verse - 1).substring(verse(verse - 1).indexOf("\nS")).trim();
			break;
		case 5:
			result += "a dog.\nWhat a hog, to swallow a dog!\n" + common1 + "dog " + common2 + "the cat.\n"
					+ verse(verse - 1).substring(verse(verse - 1).indexOf("\nS")).trim();
			break;
		case 6:
			result += "a goat.\nJust opened her throat and swallowed a goat!\n" + common1 + "goat " + common2 + "the dog.\n"
					+ verse(verse - 1).substring(verse(verse - 1).indexOf("\nS")).trim();
			break;
		case 7:
			result += "a cow.\nI don't know how she swallowed a cow!\n" + common1 + "cow " + common2 + "the goat.\n"
					+ verse(verse - 1).substring(verse(verse - 1).indexOf("\nS")).trim();
			break;
		case 8:
			result += "a horse.\nShe's dead, of course!";
			break;

		}

		return result;
	}
	
	public String verses(int startVerse,int endVerse){
		String result = "";
		for (int i = startVerse; i <= endVerse; i++)
			result += verse(i) + "\n"+"\n";

		return result.trim();

	}
	
}