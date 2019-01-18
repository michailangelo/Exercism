class ArmstrongNumbers {

	boolean isArmstrongNumber(int numberToCheck) {
		
		int numberOfDigits = String.valueOf(numberToCheck).length();
		char[] digits = String.valueOf(numberToCheck).toCharArray();

		int digit = 0;
		int sum = 0;

		for (int i = 0; i < numberOfDigits; i++) {

			digit = Integer.valueOf((digits[i] + ""));
			sum += Math.pow(digit, numberOfDigits);

		}

		return sum == numberToCheck;

		
		
	}

}
