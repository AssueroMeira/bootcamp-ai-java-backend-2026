public class Exercicio2 {
    
    public static void main(String[] args) {
        var scanner = new java.util.Scanner(System.in);
        System.out.println("Digite o tamanho do lado do quadrado:");
        var lado = scanner.nextInt();
        var areaQuadrado = lado * lado;
        System.out.printf("A área do quadrado é: %dm2\n", areaQuadrado);
        scanner.close();
    }

}
