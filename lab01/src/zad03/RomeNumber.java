package zad03;

import javax.naming.directory.InvalidAttributesException;

public class RomeNumber {

	private int n;

	public RomeNumber(int n)
	{
		this.n = n;
	}
	
	Hashmap<String,Integer> romanNumeralMap = new Hashmap<String,Integer>{};
	romanNumeralMap = "M",  1000,
            "CM", 900,
            "D",  500,
            "CD", 400,
            "C",  100,
            "XC", 90,
            "L",  50,
            "XL", 40,
            "X",  10,
            "IX", 9,
            "V",  5,
            "IV", 4,
            "I",  1
	@Override
	public String toString(){
		
		String result = new String();
		if(!(0 < n && n < 4000))
	        throw new InvalidAttributesException();
		
	    result = "";
	    for numeral, integer in romanNumeralMap:
	        while n >= integer:
	            result += numeral
	            n -= integer
	    return result
		return result;
	}
}
