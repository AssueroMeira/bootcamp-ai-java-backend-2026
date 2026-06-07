public class Exercicio3 {
    
    public static void main(String[] args) {
        var scanner = new java.util.Scanner(System.in);
        System.out.println("Digite o valor da base do retêngulo:");
        var base = scanner.nextInt();
        System.out.println("Digite o valor da altura do retêngulo:");
        var altura = scanner.nextInt();
        var areaRetangulo = base * altura;
        System.out.printf("A área do retângulo é: %dm2\n", areaRetangulo);
        scanner.close();
    }

}
