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

Para usar `Scanner`, é necessário importar a classe:

```java
import java.util.Scanner;
```

Exemplo:

```java
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
```

Nesse exemplo:

- `new Scanner(System.in)` cria um objeto capaz de ler informações do teclado;
- `scanner.next()` lê uma palavra digitada pelo usuário;
- `scanner.nextInt()` lê um número inteiro;
- `scanner.close()` fecha o recurso de leitura.

## 8. Declaração explícita de variáveis

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

## 9. Inferência de tipo com var

A partir do Java 10, é possível usar `var` para declarar variáveis locais.

Exemplo:

```java
import java.util.Scanner;

public class ExemploAula2 {

    public static void main(String[] args) {
        var scanner = new Scanner(System.in);

        System.out.println("Olá, informe seu nome:!");
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

## 10. O uso de var não elimina a tipagem

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

## 11. Comparando declaração explícita e var

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

## 12. Saída formatada com printf

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

## 13. Comentários

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

## 14. Métodos

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

## 15. Escopo

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

## 16. Resumo

Nesta aula, os principais conceitos foram:

- Classe
- Método `main`
- Variáveis
- Tipos primitivos
- `String`
- Entrada de dados com `Scanner`
- Declaração explícita de variáveis
- Inferência de tipo com `var`
- Diferença entre declarar o tipo e deixar o compilador inferir
- Saída formatada com `printf`
- Comentários
- Métodos
- Escopo

## 17. Observação importante sobre var

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
