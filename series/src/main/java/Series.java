import java.util.List;
import java.util.ArrayList;

public class Series{
	private String digits;
	
	public Series(String digits){
		this.digits=digits;
	}
	
	public List<String> slices(int s) throws IllegalArgumentException{
		if(s>digits.length())
			throw new IllegalArgumentException("Slice size is too big.");
		if(s<=0)
			throw new IllegalArgumentException("Slice size is too small.");
		
		List<String> results = new ArrayList<>();
		
		for (int i = 0; i <= digits.length() - s; i++) 
			results.add(digits.substring(i, i + s));

		
		return results;
		
	}
}