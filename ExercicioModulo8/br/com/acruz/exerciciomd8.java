package br.com.acruz;

public class exerciciomd8 {

    //Abaixo é possivel trocar as variaveis das notas de 1 a 4, para números decimais. Não somente números Inteiros.
    //Se houvese necessidade de colar somente números inteiros. Poderia trocar os tipos das variaveis notas1-4 e Media para "int" ao invez de double.
    public static void main(String[] args) {
        double nota1 = 10;
        double nota2 = 5.5;
        double nota3 = 6.5;
        double nota4 = 3.7;

        double Media = (nota1 + nota2 + nota3 + nota4)/4;
        System.out.println("A média das notas: " + nota1 + " / " + nota2 + " / " + nota3 + " / " + nota4);
        System.out.println("É igual a: " + Media);
    }
}
