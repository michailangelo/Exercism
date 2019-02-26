public class PhoneNumber{
	private String number;
	
	public PhoneNumber(String number) throws IllegalArgumentException{
		if(!number.matches("[0-9,+,\\s,(,),\\-,\\.]+"))
			throw new IllegalArgumentException("Illegal character in phone number. Only digits, spaces, parentheses, hyphens or dots accepted.");
		
		number=number.replaceAll("[+,\\s,(,),\\-,\\.]+","");
		
		if(number.length()!=10&&number.length()!=11)
			throw new IllegalArgumentException("Number must be 10 or 11 digits");
		if(number.length()==11&&!number.substring(0,1).equals("1"))
			throw new IllegalArgumentException("Can only have 11 digits if number starts with '1'");
		if(number.length()==11)
			number = number.substring(1,number.length());
		
		if(!number.substring(0,3).matches("[2-9]+")||!number.substring(3,6).matches("[2-9]+"))
			throw new IllegalArgumentException("Illegal Area Or Exchange Code. Only 2-9 are valid digits");
		
		this.number = number;
	}

public String getNumber(){
	return number;
	
}
}