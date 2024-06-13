import java.util.Scanner;

public class TaregaMod10 {
    public static void main(String args[]) {

        Scanner s = new Scanner(System.in);
        System.out.println("Digite a 1° nota do aluno: ");
        int nota1 = s.nextInt();

        System.out.println("Digite a 2° nota do aluno: ");
        int nota2 = s.nextInt();

        System.out.println("Digite a 3° nota do aluno: ");
        int nota3 = s.nextInt();

        System.out.println("Digite a 4° nota do aluno: ");
        int nota4 = s.nextInt();

        int media = (nota1 + nota2 + nota3 + nota4)/4;

        if (media >= 7) {
            System.out.println("Parabéns você foi aprovado");
        } else if (media >= 5){
            System.out.println("Atenção você está de recuperação");
        }  else {
            System.out.println("Você está reprovado");
        }

    }
}
