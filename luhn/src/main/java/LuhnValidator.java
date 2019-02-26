class LuhnValidator {

    boolean isValid(String candidate) {
        boolean isValid = false;
		candidate = candidate.trim();
		candidate = candidate.replaceAll(" ", "");
		if (candidate.length() <= 1)
			return false;
		
		if (candidate.matches(".*\\D+.*"))
			return false;
		
		int[] digits = new int[candidate.length()];
		for (int i = 0; i < candidate.length(); i++)
			digits[i] = Integer.valueOf(candidate.substring(i, i + 1));

		for (int i = digits.length - 2; i >= 0; i = i - 2) {
			if (digits[i] * 2 > 9)
				digits[i] = digits[i] * 2 - 9;
			else
				digits[i] = digits[i] * 2;
		}
		int sum = 0;
		for (int i = 0; i < digits.length; i++)
			sum += digits[i];
		

		if (sum % 10 == 0)
			isValid = true;

		return isValid;
    }

}
