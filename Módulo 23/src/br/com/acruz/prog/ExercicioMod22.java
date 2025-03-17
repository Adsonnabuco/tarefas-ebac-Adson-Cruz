package br.com.acruz.prog;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

//  Teremos como base o Projeto do módulo anterior e  iremos fazer um teste
//  para garantir que todos da lista realmente são do sexo feminino/mulheres.

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

        List<Pessoa> mulheres = filtrarMulheres(pessoas);

        System.out.println("\nLista de mulheres:");
        mulheres.forEach(System.out::println);
        scanner.close();
    }

    public static List<Pessoa> filtrarMulheres(List<Pessoa> pessoas) {
        return pessoas.stream()
                .filter(p -> p.sexo.equalsIgnoreCase("F") || p.sexo.equalsIgnoreCase("Feminino"))
                .collect(Collectors.toList());
    }

}