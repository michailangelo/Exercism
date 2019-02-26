import java.util.Map;
import java.util.HashMap;

public class RomanNumeral{
	private int number;
	
	
	public RomanNumeral(int number){
		this.number=number;
	}
	
	public String getRomanNumeral(){
		StringBuilder sb = new StringBuilder();
		int thousands = 0;
		int hundrends = 0;
		int decimals = 0;
		Map<Integer, String> numberToRoman = new HashMap<>();
		numberToRoman.put(0, "");
		numberToRoman.put(1, "I");
		numberToRoman.put(2, "II");
		numberToRoman.put(3, "III");
		numberToRoman.put(4, "IV");
		numberToRoman.put(5, "V");
		numberToRoman.put(6, "VI");
		numberToRoman.put(7, "VII");
		numberToRoman.put(8, "VIII");
		numberToRoman.put(9, "IX");
		numberToRoman.put(10, "X");
		numberToRoman.put(50, "L");
		numberToRoman.put(100, "C");
		numberToRoman.put(500, "D");
		numberToRoman.put(1000, "M");
		if (numberToRoman.containsKey(number))
			return numberToRoman.get(number);
		
		thousands = number / 1000;
		number = number - thousands * 1000;
		hundrends = number / 100;
		number = number - hundrends * 100;
		decimals = number / 10;
		number = number - decimals * 10;

		for (int i = 0; i < thousands; i++)
			sb.append(numberToRoman.get(1000));

		if (hundrends < 4)
			for (int i = 0; i < hundrends; i++)
				sb.append(numberToRoman.get(100));
		else if (hundrends == 4) {
			sb.append(numberToRoman.get(100));
			sb.append(numberToRoman.get(500));
		} else if (hundrends == 5)
			sb.append(numberToRoman.get(500));
		else if (hundrends == 9) {
			sb.append(numberToRoman.get(100));
			sb.append(numberToRoman.get(1000));
		}
		else {
			sb.append(numberToRoman.get(500));
			for (int i = 5; i < hundrends; i++)
				sb.append(numberToRoman.get(100));
		}

		if (decimals < 4)
			for (int i = 0; i < decimals; i++)
				sb.append(numberToRoman.get(10));
		else if (decimals == 4) {
			sb.append(numberToRoman.get(10));
			sb.append(numberToRoman.get(50));
		} else if (decimals == 5)
			sb.append(numberToRoman.get(50));
		else if (decimals == 9) {
			sb.append(numberToRoman.get(10));
			sb.append(numberToRoman.get(100));
		}
		else {
			sb.append(numberToRoman.get(50));
			for (int i = 5; i < decimals; i++)
				sb.append(numberToRoman.get(10));
		}

		sb.append(numberToRoman.get(number));

		return sb.toString();
		
	}
}