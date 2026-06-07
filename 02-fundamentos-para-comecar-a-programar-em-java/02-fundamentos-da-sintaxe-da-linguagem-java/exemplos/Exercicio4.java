public class Exercicio4 {
 
    public static void main(String[] args) {
        var scanner = new java.util.Scanner(System.in);
        System.out.println("Digite seu nome:");
        var nome1 = scanner.nextLine();
        System.out.printf("Olá, %s! Digite sua idade.\n", nome1);
        var idade1 = scanner.nextInt();
        scanner.nextLine(); // Consumir a quebra de linha pendente
        System.out.println("Digite outro nome:");
        var nome2 = scanner.nextLine();
        System.out.printf("Olá, %s! Digite sua idade.\n", nome2);
        var idade2 = scanner.nextInt();
        scanner.nextLine(); // Consumir a quebra de linha pendente
        var diferencaIdade = Math.abs(idade1 - idade2);
        System.out.printf("A diferença de idade entre %s e %s é de %d anos.\n", nome1, nome2, diferencaIdade);
        scanner.close();
    }

}
