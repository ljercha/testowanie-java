package zad04;

import java.util.LinkedList;
import java.util.Random;


public class GraLab02 implements Psikus {
	

	@Override
	public Integer cyfrokrad(Integer liczba) {
		if(liczba >= 0 && liczba < 10)
			return null;
		
		Random random = new Random();
		String result = liczba.toString();
		StringBuilder sb = new StringBuilder(result);
		sb.deleteCharAt(random.nextInt(result.length()));
		return Integer.parseInt(sb.toString());
	}

	@Override
	public Integer hultajchochla(Integer liczba) throws NieudanyPsikusException {
		if(liczba >= 0 && liczba < 10)
			throw new NieudanyPsikusException();
		
		Random random = new Random();
		String result = liczba.toString();
		StringBuilder sb = new StringBuilder(result);
		int firstRandom = random.nextInt(result.length());
		
		int secondRandom = random.nextInt(result.length());
		while(secondRandom == firstRandom)
		{
			secondRandom = random.nextInt(result.length());
		}
		char firstNumber = sb.charAt(firstRandom);
		sb.setCharAt(firstRandom, sb.charAt(secondRandom));
		sb.setCharAt(secondRandom, firstNumber);
		return Integer.parseInt(sb.toString());
	}

	@Override
	public Integer nieksztaltek(Integer liczba) {
		Random random = new Random();
		String result = liczba.toString();
		StringBuilder sb = new StringBuilder(result);
		
		if(!(result.contains("3") || result.contains("7") || result.contains("6")))
			return liczba;
		
		int firstRandom = random.nextInt(result.length());
		
		while(sb.charAt(firstRandom) != '3' ||
				sb.charAt(firstRandom) != '7' ||
				sb.charAt(firstRandom) != '6')
		{
			firstRandom = random.nextInt(result.length());
		}
			
//		switch (sb.charAt(firstRandom)) {
//		case '3':
//			sb.setCharAt(firstRandom,'8');
//			break;
//		case '7':
//			sb.setCharAt(firstRandom,'1');
//			break;
//		case '6':
//			sb.setCharAt(firstRandom,'9');
//			break;
//		}
		
		return Integer.parseInt(sb.toString());

	}

		
}
