package application;

import java.util.Scanner;

public class InverterString {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Digite uma palavra ou frase para ser invertida.");
		String palavra = sc.nextLine();
		
		for (int i = palavra.length() - 1; i >= 0; i--) {
			char s = palavra.charAt(i);
			System.out.print(s);
		}
		sc.close();

	}
}
