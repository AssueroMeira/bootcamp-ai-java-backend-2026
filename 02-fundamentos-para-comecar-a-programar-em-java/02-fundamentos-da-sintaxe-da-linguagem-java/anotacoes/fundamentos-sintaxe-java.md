# Anotações — Fundamentos da Sintaxe Java

## 1. Estrutura básica

Todo programa Java geralmente começa com uma classe.

```java
public class NomeDaClasse {
    public static void main(String[] args) {
        System.out.println("Olá, Java!");
    }
}
```

Essa estrutura possui três elementos importantes:

- `class`: indica a criação de uma classe;
- `main`: indica o ponto de entrada do programa;
- `System.out.println`: exibe uma mensagem no terminal.

## 2. Classe

A classe é uma estrutura que organiza o código.

```java
public class EstruturaBasica {
}
```

Quando a classe é `public`, o nome do arquivo deve ser igual ao nome da classe.

Exemplo:

```text
EstruturaBasica.java
```

Neste caso, o arquivo deve conter uma classe pública chamada `EstruturaBasica`.

## 3. Método main

O método `main` é o ponto de entrada do programa Java.

```java
public static void main(String[] args)
```

É a partir dele que a execução do programa começa.

Exemplo:

```java
public class EstruturaBasica {
    public static void main(String[] args) {
        System.out.println("Programa iniciado!");
    }
}
```

## 4. Variáveis

Variáveis armazenam valores.

```java
int idade = 35;
String nome = "Assuero";
```

Cada variável possui:

- um tipo;
- um nome;
- um valor.

Exemplo:

```java
int idade = 35;
```

Nesse caso:

- `int` é o tipo da variável;
- `idade` é o nome da variável;
- `35` é o valor armazenado.

## 5. Tipos primitivos

Alguns tipos primitivos importantes:

- `int`: números inteiros;
- `double`: números com casas decimais;
- `char`: um único caractere;
- `boolean`: verdadeiro ou falso.

Exemplos:

```java
int idade = 35;
double altura = 1.83;
char inicial = 'A';
boolean estudante = true;
```

## 6. String

`String` é usada para textos.

```java
String nome = "Assuero";
```

Apesar de ser muito usada como tipo de dado textual, `String` não é um tipo primitivo. Ela é uma classe da linguagem Java.

Exemplo:

```java
String mensagem = "Olá, Java!";
System.out.println(mensagem);
```

## 7. Entrada de dados com Scanner

A classe `Scanner` permite ler dados digitados pelo usuário no terminal.

Para usar `Scanner`, é possível importar a classe no início do arquivo:

```java
import java.util.Scanner;
```

Exemplo usando declaração explícita:

```java
import java.util.Scanner;

public class ExemploAula1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Olá, informe seu nome:");
        String name = scanner.next();

        System.out.println("Informe sua idade:");
        int age = scanner.nextInt();

        System.out.printf("Olá %s, você tem %d anos.\n", name, age);

        scanner.close();
    }
}
```

Também é possível usar o nome completo da classe sem fazer o `import`:

```java
var scanner = new java.util.Scanner(System.in);
```

Nesse exemplo:

- `new Scanner(System.in)` cria um objeto capaz de ler informações do teclado;
- `scanner.next()` lê uma palavra digitada pelo usuário;
- `scanner.nextLine()` lê uma linha inteira digitada pelo usuário;
- `scanner.nextInt()` lê um número inteiro;
- `scanner.close()` fecha o recurso de leitura.

## 8. Diferença entre next, nextLine e nextInt

O `Scanner` possui métodos diferentes para ler dados do teclado.

### `next()`

Lê apenas uma palavra, ou seja, lê até encontrar um espaço.

Exemplo:

```java
var nome = scanner.next();
```

Se o usuário digitar:

```text
Assuero Silva
```

O `next()` vai ler apenas:

```text
Assuero
```

### `nextLine()`

Lê a linha inteira digitada pelo usuário.

Exemplo:

```java
var nome = scanner.nextLine();
```

Se o usuário digitar:

```text
Assuero Silva
```

O `nextLine()` vai ler:

```text
Assuero Silva
```

### `nextInt()`

Lê um número inteiro.

Exemplo:

```java
var idade = scanner.nextInt();
```

Se o usuário digitar:

```text
42
```

O `nextInt()` lê o número `42`.

## 9. Atenção ao usar nextInt antes de nextLine

Um cuidado importante aparece quando usamos `nextInt()` antes de `nextLine()`.

O `nextInt()` lê apenas o número, mas não consome a quebra de linha gerada pelo Enter.

Exemplo:

```java
var idade = scanner.nextInt();
var nome = scanner.nextLine();
```

Nesse caso, o `nextLine()` pode capturar a quebra de linha pendente e não esperar o usuário digitar o próximo texto.

Modelo mental:

```text
Usuário digita: 42 + Enter

nextInt()
lê: 42
deixa pendente: Enter

nextLine()
lê o Enter pendente
resultado: texto vazio
```

Para resolver, usamos um `nextLine()` extra depois do `nextInt()`:

```java
var idade = scanner.nextInt();
scanner.nextLine(); // consome a quebra de linha pendente

System.out.println("Digite seu nome:");
var nome = scanner.nextLine();
```

Esse cuidado foi necessário no `Exercicio4`, porque o programa lê uma idade com `nextInt()` e, depois, lê outro nome com `nextLine()`.

## 10. Declaração explícita de variáveis

Na declaração explícita, o tipo da variável é informado diretamente no código.

Exemplo:

```java
Scanner scanner = new Scanner(System.in);
String name = scanner.next();
int age = scanner.nextInt();
```

Nesse caso:

| Variável  | Tipo declarado | Valor recebido           |
| --------- | -------------- | ------------------------ |
| `scanner` | `Scanner`      | `new Scanner(System.in)` |
| `name`    | `String`       | `scanner.next()`         |
| `age`     | `int`          | `scanner.nextInt()`      |

Essa forma é muito útil para quem está começando, porque deixa claro qual tipo de dado cada variável armazena.

## 11. Inferência de tipo com var

A partir do Java 10, é possível usar `var` para declarar variáveis locais.

Exemplo:

```java
import java.util.Scanner;

public class ExemploAula2 {

    public static void main(String[] args) {
        var scanner = new Scanner(System.in);

        System.out.println("Olá, informe seu nome:");
        var name = scanner.next();

        System.out.println("Informe sua idade:");
        var age = scanner.nextInt();

        System.out.printf("Olá %s, você tem %d anos.\n", name, age);

        scanner.close();
    }
}
```

O `var` permite que o compilador descubra o tipo da variável a partir do valor atribuído.

Exemplo:

```java
var name = scanner.next();
```

Como `scanner.next()` retorna uma `String`, o compilador entende que `name` é do tipo `String`.

Ou seja, o código acima equivale a:

```java
String name = scanner.next();
```

Outro exemplo:

```java
var age = scanner.nextInt();
```

Como `scanner.nextInt()` retorna um `int`, o compilador entende que `age` é do tipo `int`.

Ou seja, o código acima equivale a:

```java
int age = scanner.nextInt();
```

## 12. O uso de var não elimina a tipagem

O uso de `var` não significa que Java deixou de ter tipos.

Java continua sendo uma linguagem fortemente tipada.

A diferença é que, com `var`, o tipo é inferido pelo compilador.

Exemplo:

```java
var age = scanner.nextInt();
```

Nesse caso, `age` será uma variável do tipo `int`.

Depois disso, não é possível atribuir um texto a ela:

```java
age = "quarenta";
```

Esse código gera erro, porque `age` foi inferida como `int`, e `"quarenta"` é uma `String`.

Portanto, `var` não cria uma variável sem tipo. Ele apenas evita escrever o tipo quando o compilador consegue identificar esse tipo automaticamente.

## 13. Comparando declaração explícita e var

Declaração explícita:

```java
String name = scanner.next();
int age = scanner.nextInt();
```

Declaração com `var`:

```java
var name = scanner.next();
var age = scanner.nextInt();
```

As duas formas estão corretas.

A declaração explícita é mais clara para estudar os tipos.

O `var` deixa o código mais curto, mas deve ser usado quando o tipo da variável é fácil de entender pelo contexto.

## 14. Saída formatada com printf

O método `System.out.printf` permite exibir mensagens formatadas.

Exemplo:

```java
System.out.printf("Olá %s, você tem %d anos.\n", name, age);
```

Nesse exemplo:

- `%s` é usado para texto (`String`);
- `%d` é usado para número inteiro;
- `\n` quebra a linha ao final da mensagem.

Se `name` for `"Assuero"` e `age` for `35`, a saída será:

```text
Olá Assuero, você tem 35 anos.
```

Também é possível usar vários marcadores na mesma mensagem:

```java
System.out.printf("A diferença de idade entre %s e %s é de %d anos.\n", nome1, nome2, diferencaIdade);
```

Nesse caso:

- o primeiro `%s` será substituído por `nome1`;
- o segundo `%s` será substituído por `nome2`;
- o `%d` será substituído por `diferencaIdade`.

## 15. Operadores aritméticos

Operadores aritméticos permitem realizar cálculos.

Alguns operadores importantes:

| Operador | Significado         | Exemplo |
| -------- | ------------------- | ------- |
| `+`      | adição              | `a + b` |
| `-`      | subtração           | `a - b` |
| `*`      | multiplicação       | `a * b` |
| `/`      | divisão             | `a / b` |
| `%`      | resto da divisão    | `a % b` |

Exemplo do cálculo da área de um quadrado:

```java
var areaQuadrado = lado * lado;
```

Exemplo do cálculo da área de um retângulo:

```java
var areaRetangulo = base * altura;
```

## 16. Usando classes da biblioteca Java

Além das classes criadas pelo programador, Java possui várias classes prontas em sua biblioteca padrão.

Um exemplo usado nos exercícios foi `OffsetDateTime`.

```java
import java.time.OffsetDateTime;

var anoAtual = OffsetDateTime.now().getYear();
```

Nesse trecho:

- `OffsetDateTime.now()` obtém a data e hora atual;
- `.getYear()` extrai apenas o ano atual.

Isso permite calcular a idade aproximada a partir do ano de nascimento:

```java
var idade = anoAtual - anoNascimento;
```

Outro exemplo usado foi `Math.abs()`:

```java
var diferencaIdade = Math.abs(idade1 - idade2);
```

O método `Math.abs()` retorna o valor absoluto de um número.

Assim, se a diferença for negativa, o resultado será convertido para positivo.

Exemplo:

```text
35 - 42 = -7
Math.abs(-7) = 7
```

## 17. Comentários

Comentário de uma linha:

```java
// Isto é um comentário
```

Comentário de múltiplas linhas:

```java
/*
 Isto é um comentário
 com várias linhas
*/
```

Comentário de documentação:

```java
/**
 * Documenta classes e métodos.
 */
```

Comentários ajudam a explicar partes importantes do código.

Exemplo usado no exercício:

```java
scanner.nextLine(); // Consumir a quebra de linha pendente
```

Esse comentário explica por que foi necessário chamar `nextLine()` depois de `nextInt()`.

## 18. Métodos

Métodos organizam ações do programa.

Exemplo sem retorno:

```java
public static void saudacao() {
    System.out.println("Olá!");
}
```

Exemplo com retorno:

```java
public static int somar(int a, int b) {
    return a + b;
}
```

Um método pode:

- executar uma ação;
- receber parâmetros;
- retornar um valor;
- organizar melhor o código.

Nos exercícios atuais, todos os programas executam suas instruções dentro do método `main`.

## 19. Escopo

Escopo define onde uma variável pode ser acessada.

Variável local:

```java
public static void exemplo() {
    String mensagem = "Olá";
}
```

A variável `mensagem` só existe dentro do método `exemplo`.

Fora desse método, ela não pode ser acessada.

Exemplo:

```java
public static void exemplo() {
    String mensagem = "Olá";
    System.out.println(mensagem);
}
```

Neste caso, `mensagem` funciona apenas dentro do bloco onde foi declarada.

Nos exercícios, variáveis como `nome`, `anoNascimento`, `lado`, `base`, `altura`, `idade1` e `idade2` são variáveis locais, pois foram declaradas dentro do método `main`.

## 20. Exercícios realizados

Nesta etapa, foram desenvolvidos quatro exercícios práticos para fixar a sintaxe básica da linguagem Java.

### Exercicio1 — Nome, ano de nascimento e idade aproximada

Objetivo: ler o nome do usuário, ler o ano de nascimento e calcular a idade aproximada com base no ano atual.

```java
import java.time.OffsetDateTime;

public class Exercicio1 {

    public static void main(String[] args) {
        var anoAtual = OffsetDateTime.now().getYear();
        var scanner = new java.util.Scanner(System.in);

        System.out.println("Digite seu nome:");
        var nome = scanner.nextLine();

        System.out.println("Digite o ano de seu nascimento:");
        var anoNascimento = scanner.nextInt();

        System.out.printf("Olá %s, você tem %d anos.\n", nome, anoAtual - anoNascimento);

        scanner.close();
    }
}
```

Conceitos praticados:

- importação de classe com `import`;
- uso de `OffsetDateTime.now().getYear()`;
- leitura de texto com `nextLine()`;
- leitura de inteiro com `nextInt()`;
- cálculo com subtração;
- saída formatada com `printf`.

Observação: esse cálculo considera apenas o ano atual menos o ano de nascimento. Portanto, é uma idade aproximada, pois não verifica se a pessoa já fez aniversário no ano atual.

### Exercicio2 — Área do quadrado

Objetivo: ler o tamanho do lado de um quadrado e calcular sua área.

```java
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
```

Conceitos praticados:

- leitura de número inteiro;
- multiplicação;
- armazenamento do resultado em variável;
- saída formatada.

Fórmula usada:

```text
área do quadrado = lado * lado
```

Observação: em textos matemáticos, a unidade de área costuma ser escrita como `m²`. No terminal, foi usado `m2` por simplicidade.

### Exercicio3 — Área do retângulo

Objetivo: ler a base e a altura de um retângulo e calcular sua área.

```java
public class Exercicio3 {

    public static void main(String[] args) {
        var scanner = new java.util.Scanner(System.in);

        System.out.println("Digite o valor da base do retângulo:");
        var base = scanner.nextInt();

        System.out.println("Digite o valor da altura do retângulo:");
        var altura = scanner.nextInt();

        var areaRetangulo = base * altura;

        System.out.printf("A área do retângulo é: %dm2\n", areaRetangulo);

        scanner.close();
    }
}
```

Conceitos praticados:

- leitura de dois números inteiros;
- multiplicação entre variáveis;
- cálculo de área;
- saída formatada.

Fórmula usada:

```text
área do retângulo = base * altura
```

### Exercicio4 — Diferença de idade entre duas pessoas

Objetivo: ler o nome e a idade de duas pessoas e calcular a diferença entre as idades.

```java
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
```

Conceitos praticados:

- leitura de texto com `nextLine()`;
- leitura de inteiro com `nextInt()`;
- cuidado com a quebra de linha pendente após `nextInt()`;
- cálculo de diferença;
- uso de `Math.abs()` para obter valor absoluto;
- saída formatada com múltiplos valores.

Ponto importante:

```java
scanner.nextLine(); // Consumir a quebra de linha pendente
```

Esse comando foi necessário porque, após `nextInt()`, o Enter digitado pelo usuário fica pendente no buffer. Sem esse cuidado, o próximo `nextLine()` poderia ler uma linha vazia.

## 21. Resumo

Nesta aula, os principais conceitos foram:

- Classe
- Método `main`
- Variáveis
- Tipos primitivos
- `String`
- Entrada de dados com `Scanner`
- Diferença entre `next()`, `nextLine()` e `nextInt()`
- Cuidado ao misturar `nextInt()` com `nextLine()`
- Declaração explícita de variáveis
- Inferência de tipo com `var`
- Diferença entre declarar o tipo e deixar o compilador inferir
- Saída formatada com `printf`
- Operadores aritméticos
- Uso de classes prontas, como `OffsetDateTime` e `Math`
- Comentários
- Métodos
- Escopo
- Exercícios práticos de cálculo e entrada de dados

## 22. Observação importante sobre var

O `var` pode ser entendido como uma forma de escrever menos código quando o tipo já está evidente.

Por exemplo:

```java
var name = scanner.next();
```

O método `next()` retorna uma `String`.

Por isso, o compilador entende que `name` é uma `String`.

Já neste exemplo:

```java
var age = scanner.nextInt();
```

O método `nextInt()` retorna um `int`.

Por isso, o compilador entende que `age` é um `int`.

Portanto, o uso de `var` faz sentido quando o valor atribuído deixa claro qual será o tipo da variável.

## 23. Próximos pontos de atenção

Para os próximos exercícios, vale observar:

- quando usar `next()` e quando usar `nextLine()`;
- quando limpar a quebra de linha pendente após `nextInt()`;
- quando usar `int` e quando usar `double`;
- como melhorar a mensagem exibida ao usuário;
- como validar entradas inválidas;
- como separar melhor o código em métodos quando os exercícios ficarem maiores.
