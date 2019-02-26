import java.util.Map;
import java.util.HashMap;

public class NucleotideCounter{
	private String DNAString;
	
	
	public NucleotideCounter(String DNAString) throws IllegalArgumentException{
		if(!DNAString.matches("[A,C,G,T,\\s]+")&&!DNAString.equals(""))
			throw new IllegalArgumentException();
		this.DNAString = DNAString;	
	}
	
	
	public Map<Character,Integer> nucleotideCounts(){
		Map<Character,Integer> results= new HashMap<>();
		results.put('A',0);
		results.put('C',0);
		results.put('G',0);
		results.put('T',0);
		for(int i=0;i<DNAString.length();i++){
			results.put(DNAString.charAt(i),results.get(DNAString.charAt(i))+1);
		}
		return results;
	}		
}