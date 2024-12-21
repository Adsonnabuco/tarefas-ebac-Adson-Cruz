package br.com.acruz.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
//  Ler do console o nome das pessoas com o sexo separados por vigulas,
//  criar uma nova lista com expressoes lambdas apenas com as mulheres e imprimir essa lista no console.

public class ExercicioMod22 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Pessoa> pessoas = new ArrayList<>();

        System.out.println("Informe os dados (nome e sexo) separados por vírgula. Exemplo: João,M");
        System.out.println("Digite 'fim' para encerrar.");

        while(true){

            String linha = scanner.nextLine();

            if(linha.equalsIgnoreCase("fim")){
                break;
            }

            String[] partes = linha.split(",");
            pessoas.add(new Pessoa(partes[0], partes[1]));

        }

        List<Pessoa> mulheres = pessoas.stream()
                .filter(p -> p.sexo.equalsIgnoreCase("F") || p.sexo.equalsIgnoreCase("Feminino"))
                .collect(Collectors.toList());

        System.out.println("\nLista de mulheres:");
        mulheres.forEach(System.out::println);
        scanner.close();
    }
}