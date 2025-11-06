package pl.mortgagecalc;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		final byte MONTHS_IN_YEAR = 12;
		final byte PERCENT = 100;
		
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.print("Principal: ");
			String principalInput = scanner.nextLine().replaceAll("\\s+", "");
			int principal = Integer.parseInt(principalInput);
			
			System.out.print("Annual Intrest Rate(%): ");
			float annualIntrest = scanner.nextFloat();
			float monthlyIntrest = annualIntrest / PERCENT / MONTHS_IN_YEAR;
			
			System.out.print("Period (Years): ");
			byte years = scanner.nextByte();
			int numberOfPayments = years * MONTHS_IN_YEAR;
			
			double pow = Math.pow(1 + monthlyIntrest, numberOfPayments);
			double mortgage = principal
					* (monthlyIntrest * pow)
					/ (pow - 1);
			
			String mortrageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
			System.out.println("Mortrage: " + mortrageFormatted);
		}
	}

}
