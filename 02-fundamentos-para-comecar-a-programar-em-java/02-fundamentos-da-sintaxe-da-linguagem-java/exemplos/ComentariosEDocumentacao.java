/**
 * Classe criada para demonstrar os principais tipos de comentários em Java.
 *
 * Comentários são importantes para explicar partes relevantes do código,
 * facilitar a manutenção e documentar o funcionamento de classes e métodos.
 *
 * @author Assuero Silva Meira
 */
public class ComentariosEDocumentacao {

    /**
     * Método principal da aplicação.
     *
     * @param args argumentos recebidos pela linha de comando
     */
    public static void main(String[] args) {

        // Comentário de uma linha
        System.out.println("Exemplo de comentários em Java.");

        /*
         * Comentário de múltiplas linhas.
         * Pode ser usado para explicar trechos maiores do código.
         */
        System.out.println("Comentários ajudam a tornar o código mais claro.");

        exibirMensagem();
    }

    /**
     * Método responsável por exibir uma mensagem complementar.
     */
    public static void exibirMensagem() {
        System.out.println("Este método também possui documentação.");
    }
}

// comentário

/*
 comentário várias linhas
 comentário várias linhas
*/

/**
 * comentário de documentação - classe ou método
 * comentário de documentação
 * comentário de documentação
 */