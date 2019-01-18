import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PigLatinTranslator{
	
	public String translate(String phrase){
		
		String result = "";

		List<String> results = new ArrayList<String>();
		Pattern pattern0 = Pattern.compile("\\S+");
		Matcher matcher0 = pattern0.matcher(phrase);

		while (matcher0.find()) {
			results.add(matcher0.group(0).trim());

		}

		for (String s : results) {
			if (s.startsWith("a") || s.startsWith("e") || s.startsWith("i") || s.startsWith("o") || s.startsWith("u")
					|| s.startsWith("xr") || s.startsWith("yt")) {
				result += s + "ay" + " ";
				continue;

			}

			else {

				Pattern pattern = Pattern.compile("^[^aeiou]*qu");
				Matcher matcher = pattern.matcher(s);

				if (matcher.find()) {

					Pattern pattern2 = Pattern.compile("[^q][^u].$");
					Matcher matcher2 = pattern2.matcher(s);
					if (matcher2.find()) {
						result += matcher2.group(0) + matcher.group(0) + "ay" + " ";
						continue;

					}

				}
				
				if (s.startsWith("y")){
					result+=s.substring(1,s.length())+"y"+"ay"+" ";
					continue;
				}
				

				Pattern pattern3 = Pattern.compile("[aeiouy].*");
				Matcher matcher3 = pattern3.matcher(s);

				if (matcher3.find()) {

					Pattern pattern4 = Pattern.compile("[^aeiouy]*");
					Matcher matcher4 = pattern4.matcher(s);

					if (matcher4.find()) {
						result += matcher3.group(0) + matcher4.group(0) + "ay" + " ";

					}

				}

			}

		}

		return result.substring(0, result.length()-1);

	}

		
		
		
	}
	
