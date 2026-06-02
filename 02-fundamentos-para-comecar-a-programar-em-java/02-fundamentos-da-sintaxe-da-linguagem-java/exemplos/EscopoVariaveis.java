public class EscopoVariaveis {
// Uma variável static criada na classe pode ser acessada por métodos static da mesma classe
    static String linguagem = "Java";

    public static void main(String[] args) {

        String nome = "Assuero";

        System.out.println("Nome dentro do método main: " + nome);
        System.out.println("Linguagem acessada no main: " + linguagem);

        exibirLinguagem();

        // A variável 'mensagem' não pode ser acessada aqui,
        // pois ela foi criada dentro do método exibirMensagemLocal.
        exibirMensagemLocal();
    }

    public static void exibirLinguagem() {
        System.out.println("Linguagem acessada em outro método: " + linguagem);
    }

    public static void exibirMensagemLocal() {
        // Uma variável criada dentro de um método só existe dentro daquele método:
        String mensagem = "Esta variável existe apenas dentro deste método.";
        System.out.println(mensagem);
    }
}