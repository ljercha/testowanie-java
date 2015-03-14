package zad03;

import java.util.LinkedHashMap;
import java.util.Map;

public class RomeNumber {

	LinkedHashMap<String,Integer> romanNumeralMap = new LinkedHashMap<String,Integer>();
	private int n;

	public RomeNumber(int n)
	{
		this.n = n;
		romanNumeralMap.put("M",  1000);
		romanNumeralMap.put("CM", 900);
		romanNumeralMap.put("D",  500);
		romanNumeralMap.put("CD", 400);
		romanNumeralMap.put("C",  100);
		romanNumeralMap.put("XC", 90);
		romanNumeralMap.put("L",  50);
		romanNumeralMap.put("XL", 40);
		romanNumeralMap.put("X",  10);
		romanNumeralMap.put("IX", 9);
		romanNumeralMap.put("V",  5);
		romanNumeralMap.put("IV", 4);
		romanNumeralMap.put("I",  1);
	}
	
	@Override
	public String toString(){
		
		if(!(0 < n && n < 4000))
	        throw new Error("Liczba wychodzi poza zakres liczb rzymskich");
		
		String result = new String();
		
	    result = "";
	    for (Map.Entry<String, Integer> entry : romanNumeralMap.entrySet()) {
	        while(n >= entry.getValue())
	        	{
	        		result += entry.getKey();
	        		n -= entry.getValue();
	        	}
	    }
	    return result;

	}
}
