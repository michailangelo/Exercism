public class House{
	
	public  String verse(int verse) {
		String result = "";
		int offset = 7;
		switch (verse) {
		case 1:
			result = "This is the house that Jack built.";
			break;
		case 2:
			result = "This is the malt " + "that lay in " + verse(verse - 1).substring(offset).trim();
			break;
		case 3:
			result = "This is the rat " + "that ate " + verse(verse - 1).substring(offset).trim();
			break;
		case 4:
			result = "This is the cat " + "that killed " + verse(verse - 1).substring(offset).trim();
			break;
		case 5:
			result = "This is the dog " + "that worried " + verse(verse - 1).substring(offset).trim();
			break;
		case 6:
			result = "This is the cow with the crumpled horn " + "that tossed "
					+ verse(verse - 1).substring(offset).trim();
			break;
		case 7:
			result = "This is the maiden all forlorn " + "that milked " + verse(verse - 1).substring(offset).trim();
			break;
		case 8:
			result = "This is the man all tattered and torn " + "that kissed "
					+ verse(verse - 1).substring(offset).trim();
			break;
		case 9:
			result = "This is the priest all shaven and shorn " + "that married "
					+ verse(verse - 1).substring(offset).trim();
			break;
		case 10:
			result = "This is the rooster that crowed in the morn " + "that woke "
					+ verse(verse - 1).substring(offset).trim();
			break;
		case 11:
			result = "This is the farmer sowing his corn " + "that kept " + verse(verse - 1).substring(offset).trim();
			break;
		case 12:
			result = "This is the horse and the hound and the horn " + "that belonged to "
					+ verse(verse - 1).substring(offset).trim();
			break;

		}
		return result;

	}
	
	public String verses(int startVerse, int endVerse) {
		String result = "";
		for (int i = startVerse; i <= endVerse; i++)
			result += verse(i) + "\n";

		return result.trim();

	}
	
	public String sing() {
		return verses(1, 12);

	}
	
	
	
}