class ReverseString {

    String reverse(String inputString) {
		String result = "";
		char[] chars = inputString.toCharArray();

		for (int i = chars.length - 1; i >= 0; i--) {

			result += chars[i];
		}

		return result;
        
    }
  
}