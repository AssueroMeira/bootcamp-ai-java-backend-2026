import java.util.Scanner;

public class ExemploAula2 {

    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        System.out.println("Olá, informe seu nome:!");
        var name = scanner.next();
        System.out.println("Informe sua idade:");
        var age = scanner.nextInt();
        System.out.printf("Olá %s, você tem %d anos.\n", name, age);
        scanner.close();
    }

}
