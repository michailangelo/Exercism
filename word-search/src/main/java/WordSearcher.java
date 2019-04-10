import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.Optional;
import java.util.List;
import java.util.Collections;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.Optional;

public class WordSearcher {

	public Map<String, Optional<WordLocation>> search(Set<String> set, char[][] char2D) {
		Map<String, Optional<WordLocation>> result = new HashMap<>();
		String leftToRight = "";
		int counterRows = 1;
		StringBuilder sb = new StringBuilder();
		String topBottom = "";
		String diagonal = "";
		for (String s : set) {
			String reverseds = new StringBuilder(s).reverse().toString();
			// traverse the rows
			for (char[] c : char2D) {
				leftToRight = new String(c);

				if (leftToRight.indexOf(s) != -1)
					result.put(s, Optional.of(new WordLocation(new Pair(leftToRight.indexOf(s) + 1, counterRows),
							new Pair(leftToRight.indexOf(s) + s.length(), counterRows))));
				else if (leftToRight.indexOf(reverseds) != -1)
					result.put(s,
							Optional.of(
									new WordLocation(new Pair(leftToRight.indexOf(reverseds) + s.length(), counterRows),
											new Pair(leftToRight.indexOf(reverseds) + 1, counterRows))));

				counterRows++;
			}
			if (result.get(s) == null)
				result.put(s, Optional.empty());
			counterRows = 1;

			// traverse the columns
			for (int j = 0; j < char2D[0].length; j++) {
				for (int i = 0; i < char2D.length; i++) {
					sb.append(char2D[i][j]);
				}
				topBottom = sb.toString();
				if (topBottom.indexOf(s) != -1)
					result.put(s, Optional.of(new WordLocation(new Pair(j + 1, topBottom.indexOf(s) + 1),
							new Pair(j + 1, topBottom.indexOf(s) + s.length()))));
				else if (topBottom.indexOf(reverseds) != -1)
					result.put(s,
							Optional.of(new WordLocation(new Pair(j + 1, topBottom.indexOf(reverseds) + s.length()),
									new Pair(j + 1, topBottom.indexOf(reverseds) + 1))));

				sb = new StringBuilder();

			}
			sb = new StringBuilder();

			if (char2D.length > 1) {
				// traverse diagonal bottomLeftToTopRight
				for (int k = 0; k <= char2D.length - 1; k++) {
					int i = k;
					int j = 0;
					while (i >= 0) {
						sb.append(char2D[i][j]);
						i = i - 1;
						j = j + 1;
					}
					diagonal = sb.toString();
					if (diagonal.indexOf(s) != -1) {
						result.put(s, Optional.of(new WordLocation(
								new Pair(1 + diagonal.indexOf(s), k - diagonal.indexOf(s) + 1),
								new Pair(diagonal.indexOf(s) + s.length(), k - diagonal.indexOf(s) - s.length() + 2))));
					} else if (diagonal.indexOf(reverseds) != -1) {
						Optional.of(new WordLocation(
								new Pair(diagonal.indexOf(reverseds) + s.length() + 1,
										k - diagonal.indexOf(reverseds) + 2 + s.length()),
								new Pair(1 + diagonal.indexOf(reverseds), k - diagonal.indexOf(reverseds) + 1)));
					}
					sb = new StringBuilder();
				}
				sb = new StringBuilder();
				for (int k = 1; k <= char2D[0].length; k++) {
					int i = char2D.length - 1;
					int j = k;
					while (j <= char2D[0].length - 1 && i >= 0) {
						sb.append(char2D[i][j]);
						i = i - 1;
						j = j + 1;
					}
					diagonal = sb.toString();
					if (diagonal.indexOf(s) != -1)
						result.put(s,
								Optional.of(new WordLocation(
										new Pair(k + diagonal.indexOf(s) + 1, char2D.length - diagonal.indexOf(s)),
										new Pair(k + diagonal.indexOf(s) + s.length(),
												char2D.length - diagonal.indexOf(s) - s.length() + 1))));
					else if (diagonal.indexOf(reverseds) != -1) {
						result.put(s,
								Optional.of(new WordLocation(
										new Pair(k + diagonal.indexOf(reverseds) + s.length(),
												char2D.length - diagonal.indexOf(reverseds) - s.length() + 1),
										new Pair(k + diagonal.indexOf(reverseds) + 1,
												char2D.length - diagonal.indexOf(reverseds)))));
					}
					sb = new StringBuilder();

				}

				// traverse diagonal topLeftToBottomRight
				for (int k = char2D.length - 1; k >= 0; k--) {
					int i = k;
					int j = 0;
					while (i < char2D.length && j < char2D.length) {
						sb.append(char2D[i][j]);
						i = i + 1;
						j = j + 1;
					}
					diagonal = sb.toString();

					if (diagonal.indexOf(s) != -1) {
						result.put(s, Optional.of(new WordLocation(
								new Pair(1 + diagonal.indexOf(s), k + diagonal.indexOf(s) + 1),
								new Pair(diagonal.indexOf(s) + s.length(), k + diagonal.indexOf(s) + s.length()))));
					} else if (diagonal.indexOf(reverseds) != -1) {
						result.put(s, Optional.of(new WordLocation(
								new Pair(diagonal.indexOf(reverseds) + s.length(),
										k + diagonal.indexOf(reverseds) + s.length()),
								new Pair(1 + diagonal.indexOf(reverseds), k + diagonal.indexOf(reverseds) + 1))));
					}
					sb = new StringBuilder();
				}
				for (int k = 1; k <= char2D[0].length; k++) {
					int i = 0;
					int j = k;
					while (i < char2D.length && j <= char2D[0].length - 1) {
						sb.append(char2D[i][j]);
						i = i + 1;
						j = j + 1;
					}
					diagonal = sb.toString();
					if (diagonal.indexOf(s) != -1) {
						result.put(s, Optional.of(new WordLocation(
								new Pair(k + diagonal.indexOf(s), diagonal.indexOf(s) + 1),
								new Pair(k + diagonal.indexOf(s) + s.length(), 1 + diagonal.indexOf(s) + s.length()))));
					} else if (diagonal.indexOf(reverseds) != -1) {
						result.put(s, Optional.of(new WordLocation(
								new Pair(diagonal.indexOf(reverseds) + s.length(),
										k + diagonal.indexOf(reverseds) + s.length()),
								new Pair(1 + diagonal.indexOf(reverseds), k + diagonal.indexOf(reverseds) + 1))));
					}

					sb = new StringBuilder();
				}

			}
		}
		return result;

	}
}