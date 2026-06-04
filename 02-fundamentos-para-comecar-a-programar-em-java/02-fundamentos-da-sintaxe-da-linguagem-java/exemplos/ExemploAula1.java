import java.util.Scanner;

public class ExemploAula1 {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Olá, informe seu nome:!");
        String name = scanner.next();
        System.out.println("Informe sua idade:");
        int age = scanner.nextInt();
        System.out.printf("Olá %s, você tem %d anos.\n", name, age);
        scanner.close();
    }
}
