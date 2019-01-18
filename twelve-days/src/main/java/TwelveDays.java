import java.util.List;
import java.util.ArrayList;

class TwelveDays {
    String verse(int verseNumber) {
        String result = "";
		String numbering = "", animal = "";
		List<String> animalsList = new ArrayList<>();
		animalsList.add("a Partridge in a Pear Tree.");
		animalsList.add("two Turtle Doves, and ");
		animalsList.add("three French Hens, ");
		animalsList.add("four Calling Birds, ");
		animalsList.add("five Gold Rings, ");
		animalsList.add("six Geese-a-Laying, ");
		animalsList.add("seven Swans-a-Swimming, ");
		animalsList.add("eight Maids-a-Milking, ");
		animalsList.add("nine Ladies Dancing, ");
		animalsList.add("ten Lords-a-Leaping, ");
		animalsList.add("eleven Pipers Piping, ");
		animalsList.add("twelve Drummers Drumming, ");

		switch (verseNumber) {
		case 1:
			numbering = "first";
			break;
		case 2:
			numbering = "second";
			break;
		case 3:
			numbering = "third";
			break;
		case 4:
			numbering = "fourth";
			break;
		case 5:
			numbering = "fifth";
			break;
		case 6:
			numbering = "sixth";
			break;
		case 7:
			numbering = "seventh";
			break;
		case 8:
			numbering = "eighth";
			break;
		case 9:
			numbering = "ninth";
			break;
		case 10:
			numbering = "tenth";
			break;
		case 11:
			numbering = "eleventh";
			break;
		case 12:
			numbering = "twelfth";
			break;

		}

		for (int i = verseNumber - 1; i >= 0; i--) {
			animal += animalsList.get(i);

		}

		result = String.format("On the %s day of Christmas my true love gave to me: %s\n", numbering, animal);

		return result;

    }

    String verses(int startVerse, int endVerse) {
		String result="";
        for(int i=startVerse; i<=endVerse;i++){
			result+=verse(i)+"\n";
		}
		result=result.trim();
		return result+"\n";
    }
    
    String sing() {
        return verses(1,12);
    }
}
