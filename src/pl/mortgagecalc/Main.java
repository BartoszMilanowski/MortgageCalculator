package pl.mortgagecalc;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		final byte MONTHS_IN_YEAR = 12;
		final byte PERCENT = 100;

//		try (Scanner scanner = new Scanner(System.in)) {
//			System.out.print("Principal (1K - 1M): ");
//			String principalInput = scanner.nextLine().replaceAll("\\s+", "");
//			int principal = Integer.parseInt(principalInput);
//			
//			System.out.print("Annual Intrest Rate(%): ");
//			float annualIntrest = scanner.nextFloat();
//			float monthlyIntrest = annualIntrest / PERCENT / MONTHS_IN_YEAR;
//			
//			System.out.print("Period (Years): ");
//			byte years = scanner.nextByte();
//			int numberOfPayments = years * MONTHS_IN_YEAR;
//			
//			double pow = Math.pow(1 + monthlyIntrest, numberOfPayments);
//			double mortgage = principal
//					* (monthlyIntrest * pow)
//					/ (pow - 1);
//			
//			String mortrageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
//			System.out.println("Mortrage: " + mortrageFormatted);
//		}

		Scanner scanner = new Scanner(System.in);

		int principal;

		float annualIntrest;
		float monthlyIntrest;

		byte years;
		int numberOfPayments;

		while (true) {

			System.out.print("Principal (1K - 1M): ");
			String principalInputString = scanner.nextLine().replaceAll("\\s+", "");
			principal = Integer.parseInt(principalInputString);

			if (principal < 1000 || principal > 1000000) {
				System.out.println("Enter number between 1 000 and 1 000 000");
				continue;
			}
			break;

		}

		while (true) {

			System.out.print("Annual Intrest Rate(%): ");
			annualIntrest = scanner.nextFloat();

			if (annualIntrest <= 0 || annualIntrest > 30) {
				System.out.println("Enter a value greater than 0 and less than or equal to 30");
				continue;
			}
			break;
		}

		monthlyIntrest = annualIntrest / PERCENT / MONTHS_IN_YEAR;

		while (true) {
			System.out.print("Period (Years): ");
			years = scanner.nextByte();

			if (years < 1 || years > 30) {
				System.out.println("Enter a value between 1 and 30");
				continue;
			}
			break;
		}

		numberOfPayments = years * MONTHS_IN_YEAR;

		scanner.close();

		double pow = Math.pow(1 + monthlyIntrest, numberOfPayments);
		double mortgage = principal * (monthlyIntrest * pow) / (pow - 1);

		String mortrageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
		System.out.println("Mortrage: " + mortrageFormatted);

	}
}
