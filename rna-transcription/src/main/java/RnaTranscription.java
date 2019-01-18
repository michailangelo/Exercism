class RnaTranscription {

    String transcribe(String dnaStrand) {
        String result = "";
		char[] chars = dnaStrand.toCharArray();

		for (char c : chars) {

			switch (c) {
			case 'G':
				result += "C";
				break;
			case 'C':
				result += "G";
				break;
			case 'T':
				result += "A";
				break;
			case 'A':
				result += "U";
				break;
			default:
				result += "";

			}
		}

		return result;
    }

}
