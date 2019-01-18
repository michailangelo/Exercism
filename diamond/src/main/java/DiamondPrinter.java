import java.util.List;
import java.util.ArrayList;

class DiamondPrinter {

    List<String> printToList(char a) {
        List<String> result = new ArrayList<String>();
		List<StringBuffer> buffer = new ArrayList<>();
		char b = a;
		char previous = --b;
		int previousToNumber = previous - 64;
		int currentToNumber = a - 64;
		int numberOfDots = previousToNumber + currentToNumber;
		StringBuffer sb;
		int i = 0;
		int j = numberOfDots - 1;

		for (char c = a; c >= 'A'; c--) {
			sb = new StringBuffer(numberOfDots);
			sb.setLength(numberOfDots);
			for (int m = 0; m < numberOfDots; m++)
				sb.setCharAt(m, ' ');
			sb.setCharAt(i, c);
			sb.setCharAt(j, c);
			buffer.add(sb);
			i++;
			j--;

			if (c == 'A') {
				sb.setCharAt(numberOfDots / 2, 'A');

			}

		}
		for (int k = buffer.size() - 1; k >= 0; k--) {
			result.add(buffer.get(k).toString());

		}
		for (int k = result.size() - 2; k >= 0; k--) {
			result.add(result.get(k));

		}

		return result;
    }

}
