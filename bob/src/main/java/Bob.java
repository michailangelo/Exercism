public class Bob{
	
	public String hey(String s){
		if (s.trim().endsWith("?"))
			if (s.equals(s.toUpperCase()) && s.matches(".*[a-zA-Z].*"))
				return "Calm down, I know what I'm doing!";
			else
				return "Sure.";
		if (s.trim().equals(s.toUpperCase()) && s.matches(".*[a-zA-Z].*"))
			return "Whoa, chill out!";
		if (s.trim().equals(""))
			return "Fine. Be that way!";

		return "Whatever.";
	}
	
	
	
	
}