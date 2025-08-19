package desafio;

import java.io.*;
import java.util.*;

public class desafio_dna {
	 public static void main(String[] args) {
		 
	        String arquivoEntrada = "C:\\Users\\leomi\\eclipse-workspace\\POO_Desafio_DNA\\src\\desafio\\Imput\\dna-0.txt"; 
	        String arquivoSaida = "C:\\Users\\leomi\\eclipse-workspace\\POO_Desafio_DNA\\src\\desafio\\Output\\dna-0_output.txt";

	        int totalFitas = 0;
	        int fitasValidas = 0;
	        int fitasInvalidas = 0;


	        List<String> fitasInvalidasLista = new ArrayList<>();

	        try (
	            BufferedReader br = new BufferedReader(new FileReader(arquivoEntrada));
	            BufferedWriter bw = new BufferedWriter(new FileWriter(arquivoSaida))
	        ) {
	            String linha;
	            int numeroLinha = 0;


	            while ((linha = br.readLine()) != null) {
	                numeroLinha++;
	                totalFitas++;


	                if (linha.matches("[ATCG]+")) {

	                    StringBuilder complementar = new StringBuilder();
	                    for (char c : linha.toCharArray()) {
	                        switch (c) {
	                            case 'A': complementar.append('T'); break;
	                            case 'T': complementar.append('A'); break;
	                            case 'C': complementar.append('G'); break;
	                            case 'G': complementar.append('C'); break;
	                        }
	                    }

	                    bw.write(complementar.toString());
	                    bw.newLine();
	                    fitasValidas++;
	                } else {

	                    String invalida = "****FITA INVALIDA - " + linha;
	                    bw.write(invalida);
	                    bw.newLine();
	                    fitasInvalidas++;
	                    fitasInvalidasLista.add("Linha " + numeroLinha + ": " + linha);
	                }
	            }

	        } catch (IOException e) {
	            e.printStackTrace();
	        }


	        System.out.println("Total de fitas: " + totalFitas);
	        System.out.println("Fitas válidas: " + fitasValidas);
	        System.out.println("Fitas inválidas: " + fitasInvalidas);

	        if (!fitasInvalidasLista.isEmpty()) {
	            System.out.println("\nLista de fitas inválidas:");
	            for (String f : fitasInvalidasLista) {
	                System.out.println(f);
	            }
	        }
	    }
}
