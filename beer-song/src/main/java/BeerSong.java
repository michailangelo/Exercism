public class BeerSong{
	public String sing(int start, int end) {
		String result = "";
		String phrase = "of beer on the wall";
		int step = end - 1;

		if (start == 1)
			result = start + " bottle " + phrase + ", " + start + " bottle " + phrase.substring(0, 7)
					+ ".\nTake it down and pass it around, no more bottles " + phrase + ".\n\n";
		else if (start > 1)
			result = String.format(
					start + " bottles " + phrase + ", " + start + " bottles " + phrase.substring(0, 7)
							+ ".\nTake one down and pass it around, " + (start - 1) + " %s " + phrase + ".\n\n",
					(start - 1) == 1 ? "bottle" : "bottles");
		else
			result = "No more bottles " + phrase + ", " + "no more bottles " + phrase.substring(0, 7)
					+ ".\nGo to the store and buy some more, 99 bottles " + phrase + ".\n\n";

		if (step > 0) {
			result += sing(start - 1, end - 1);
			end = end - 1;

		}

		return result;
	}

	public String singSong() {
		return sing(99, 100);
	}
	
}