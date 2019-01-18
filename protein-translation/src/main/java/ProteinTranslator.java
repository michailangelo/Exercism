import java.util.List;
import java.util.ArrayList;

class ProteinTranslator {

    List<String> translate(String rnaSequence) {
		List<String> results = new ArrayList<>();
		char[] chars = rnaSequence.toCharArray();
		String condon = "";
		List<String> condons = new ArrayList<>();

		for (int i = 0; i < chars.length; i++) {
			condon += chars[i];
			if (condon.length() == 3) {
				condons.add(condon);
				condon = "";

			}

		}

		outer: for (String s : condons) {
			switch (s) {
			case "AUG":
				results.add("Methionine");
				break;
			case "UUU":
			case "UUC":
				results.add("Phenylalanine");
				break;
			case "UUA":
			case "UUG":
				results.add("Leucine");
				break;
			case "UCU":
			case "UCC":
			case "UCA":
			case "UCG":
				results.add("Serine");
				break;
			case "UAU":
			case "UAC":
				results.add("Tyrosine");
				break;
			case "UGU":
			case "UGC":
				results.add("Cysteine");
				break;
			case "UGG":
				results.add("Tryptophan");
				break;
			case "UAA":
			case "UAG":
			case "UGA":
				break outer;

			}

		}

		return results;
        
    }
}