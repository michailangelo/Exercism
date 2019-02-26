import java.util.Arrays;
import java.util.Collections;
class LargestSeriesProductCalculator {
	private String inputNumber;
	
    LargestSeriesProductCalculator(String inputNumber) throws IllegalArgumentException {
		if(inputNumber.matches(".*\\D+.*"))
			throw new IllegalArgumentException("String to search may only contain digits.");
		
        this.inputNumber=inputNumber;
    }

    long calculateLargestProductForSeriesLength(int numberOfDigits) throws IllegalArgumentException {
		if(numberOfDigits<0)
			throw new IllegalArgumentException("Series length must be non-negative.");
		
		if(numberOfDigits>inputNumber.length())
			throw new IllegalArgumentException("Series length must be less than or equal to the length of the string to search.");
		long result = 0;
		String candidate = "";
		long product = 1;
		Long[] products = new Long[inputNumber.length() - numberOfDigits + 1];
		for (int i = 0; i <= inputNumber.length() - numberOfDigits; i++) {
			candidate = inputNumber.substring(i, i + numberOfDigits);
			for (int j = 0; j < candidate.length(); j++) {
				product *= Long.valueOf(candidate.substring(j, j + 1));
			}
			products[i] = product;
			product = 1;

		}
		result = Collections.max(Arrays.asList(products));

		return result;
        
    }
}
