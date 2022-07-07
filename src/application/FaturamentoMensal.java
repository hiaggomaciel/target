package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class FaturamentoMensal {
	private String estado;
	private double valor;

	public FaturamentoMensal(String estado, double valor) {
		this.estado = estado;
		this.valor = valor;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
	
	@Override
	public String toString() {
		return "Estado: " + estado + ", faturamento: " + valor;
	}

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		String path = "D:\\bleh\\EntrevistaTarget\\src\\application\\mensal.txt";
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
		String line = br.readLine();
		double soma = 0;
		List<FaturamentoMensal> list = new ArrayList<>();
			
			while (line != null) {

				for (int i = 0; i < path.length(); i++) {

					String[] parts = line.split(" -" + " ");
					String part1 = parts[0];
					String part2 = parts[1];
					double valor = Double.parseDouble(part2);
					
					line = br.readLine();
					FaturamentoMensal cp = new FaturamentoMensal(part1, valor);
					
					list.add(cp);
					soma = soma + valor;
					if (line == null)break;
					//System.out.println(list.size());
				}
				for (FaturamentoMensal emp : list) {
					double per = 0;
					per = emp.getValor()/soma;
					System.out.println("O estado " + emp.getEstado() + " teve " + String.format("%.3f", per) + "% do total mensal da distribuidora.");
					
				}
			}
			System.out.println();
			System.out.println("Valor mensal apurado: " + soma);
		}
		catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		

	}
	
	
}
