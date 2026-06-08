public class ElvisOperator {
    
    public static void main(String[] args) {
        var scanner = new java.util.Scanner(System.in);
        System.out.println("Informe seu nome:");
        var name = scanner.nextLine();
        System.out.println("Informe sua idade:");
        var age = scanner.nextInt();
        scanner.nextLine(); // Consumir a quebra de linha pendente
        System.out.println("Você é emancipado? (s/n)");
        var isEmancipated = scanner.next().equalsIgnoreCase("s");

        var message = age >= 18 ? String.format("Olá %s, você é maior de idade.\n", name) :
                      (age < 18 && isEmancipated) ? String.format("Olá %s, você é emancipado e tem os mesmos direitos de um maior de idade.\n", name) :
                      String.format("Olá %s, você é menor de idade.\n", name);
        System.out.print(message);
        scanner.close();
    }

}
