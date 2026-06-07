import java.time.OffsetDateTime;

public class Exercicio1 {
    
    public static void main(String[] args) {
        var anoAtual = OffsetDateTime.now().getYear();
        var scanner = new java.util.Scanner(System.in);
        System.out.println("Digite seu nome:");
        var nome = scanner.nextLine();
        System.out.println("Digite o ano de seu nascimento:");
        var anoNascimento = scanner.nextInt();
        System.out.printf("Olá %s, você tem %d anos.\n", nome, anoAtual - anoNascimento);
        scanner.close();
    }

}
