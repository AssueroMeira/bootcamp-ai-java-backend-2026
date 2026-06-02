public class Metodos {

    public static void main(String[] args) {

        saudacao();

        String nome = "Assuero";
        saudacaoPersonalizada(nome);

        int resultadoSomar = somar(5, 10);
        System.out.println("Resultado da soma: " + resultadoSomar);
    }
// Método sem retorno
    public static void saudacao() {
        System.out.println("Olá! Bem-vindo ao curso de Java.");
    }
// Método com parâmetros
    public static void saudacaoPersonalizada(String nome) {
        System.out.println("Olá, " + nome + "! Bem-vindo ao curso de Java.");
    }
// Método com retorno
    public static int somar(int a, int b) {
        return a + b;
    }
}

/*
** Este código demonstra a definição e uso de métodos em Java.
** Métodos são blocos de código que realizam uma tarefa específica e podem ser reutilizados
** em diferentes partes do programa. O método 'main' é o ponto de entrada da aplicação, e os outros métodos são chamados a partir dele.
** O que estudamos aqui:
** - Método sem retorno
** - Método com parâmetros
** - Método com retorno
*/
