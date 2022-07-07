package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Balanco {
	
	private int dia;
	private double valor;

	public Balanco(int dia, double valor) {
		this.dia = dia;
		this.valor = valor;
	}

	public int getDia() {
		return dia;
	}

	public void setDia(int dia) {
		this.dia = dia;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public static void main(String[] args) {
		String path = "D:\\bleh\\EntrevistaTarget\\src\\application\\in.txt";
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			
			String line = br.readLine();
			double menorValor = 1000000000, maiorValor = 0, diaMenor = 0, diaMaior = 0;
			double soma = 0, media = 0, count = 0;
			Balanco[] vetor = new Balanco[path.length()];

			while (line != null) {
			
				for (int i = 0; i < line.length(); i++) {

					String[] parts = line.split(" - ");
					String part1 = parts[0];
					String part2 = parts[1];

					int dia = Integer.parseInt(part1);
					double valor = Double.parseDouble(part2);

					line = br.readLine();
					vetor[i] = new Balanco(dia, valor);

					soma += valor;

					if (valor != 0)
						count = count + 1;
					if (valor < menorValor && valor != 0) {
						diaMenor = dia;
						menorValor = valor;
					} else if (valor > maiorValor) {
						diaMaior = dia;
						maiorValor = valor;
					}

					if (line == null)
						break;
				}
			}
			media = soma / count;
			System.out.println("Menor valor faturado no mês: R$" + menorValor + ", no dia " + diaMenor);
			System.out.println("Maior valor faturado no mês: R$" + maiorValor + ", no dia " + diaMaior);
			System.out.println("Média de faturamento diário do mês: R$" + media);
		}

		catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}

	}
}
