import java.util.regex.Matcher;
import java.util.regex.Pattern;

class IsbnVerifier {
	

    boolean isValid(String stringToVerify) {
       boolean isValid = false;
		String s = stringToVerify.replaceAll("-", "").trim();
		if (s.length() != 10)
			return false;

		if (!s.substring(s.length() - 1).matches("\\d|X"))
			return false;

		Pattern p = Pattern.compile("[a-zA-Z]");
		Matcher m = p.matcher(s.substring(0, s.length() - 1));
		if (m.find())
			return false;
		if (s.substring(s.length() - 1).equals("X"))
			s = s.substring(0, s.length() - 1) + "10";

		int x1 = Integer.valueOf(s.substring(0, 1));
		int x2 = Integer.valueOf(s.substring(1, 2));
		int x3 = Integer.valueOf(s.substring(2, 3));
		int x4 = Integer.valueOf(s.substring(3, 4));
		int x5 = Integer.valueOf(s.substring(4, 5));
		int x6 = Integer.valueOf(s.substring(5, 6));
		int x7 = Integer.valueOf(s.substring(6, 7));
		int x8 = Integer.valueOf(s.substring(7, 8));
		int x9 = Integer.valueOf(s.substring(8, 9));
		int x10 = Integer.valueOf(s.substring(9));

		isValid = (x1 * 10 + x2 * 9 + x3 * 8 + x4 * 7 + x5 * 6 + x6 * 5 + x7 * 4 + x8 * 3 + x9 * 2 + x10 * 1) % 11 == 0;

		return isValid;
    }

}
