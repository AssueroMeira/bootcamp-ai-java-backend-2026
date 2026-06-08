public class EstruturaCondicional {

    public static void main(String[] args) {
        var scanner = new java.util.Scanner(System.in);
        System.out.println("Informe seu nome:");
        var name = scanner.nextLine();
        System.out.println("Informe sua idade:");
        var age = scanner.nextInt();
        scanner.nextLine(); // Consumir a quebra de linha pendente
        System.out.println("Você é emancipado? (s/n)");
        var isEmancipated = scanner.next().equalsIgnoreCase("s");

        if (age >= 18) {
            System.out.printf("Olá %s, você é maior de idade.\n", name);
        } else if (age < 18 &&isEmancipated) {
            System.out.printf("Olá %s, você é emancipado e tem os mesmos direitos de um maior de idade.\n", name);
        } else {
            System.out.printf("Olá %s, você é menor de idade.\n", name);
        }
        scanner.close();
    }

}
