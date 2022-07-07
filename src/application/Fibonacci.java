package application;

import java.util.Locale;
import java.util.Scanner;

public class Fibonacci {

	static long fibo(int n) {

		if (n < 2) {
			return n;
		} else {
			return fibo(n - 1) + fibo(n - 2);
		}
	}

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		try (Scanner sc = new Scanner(System.in)) {
			int entrada = sc.nextInt();
			int i = 0;

			for (;;) {
				if (entrada == fibo(i)) {
					System.out.println("O número " + entrada + " está na sequência de Fibonacci.");
					break;
				} else if (entrada < fibo(i)) {
					System.out.println("O número " + entrada + " não está na sequência de Fibonacci.");
					break;
				}
				i++;
			}
			sc.close();
		}
	}
}
