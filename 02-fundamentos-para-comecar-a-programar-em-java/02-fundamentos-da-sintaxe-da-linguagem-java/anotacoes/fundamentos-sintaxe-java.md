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

## 2. Classe

A classe é uma estrutura que organiza o código.

```java
public class EstruturaBasica {
}
```

Quando a classe é public, o nome do arquivo deve ser igual ao nome da classe.

Exemplo:
EstruturaBasica.java

## 3. Método main

O método main é o ponto de entrada do programa Java.

```java
public static void main(String[] args)
```

## 4. Variáveis

Variáveis armazenam valores.

```java
int idade = 35;
String nome = "Assuero";
```

## 5. Tipos primitivos

Alguns tipos primitivos importantes:

- int: números inteiros
- double: números com casas decimais
- char: um único caractere
- boolean: verdadeiro ou falso

## 6. String

String é usada para textos.

```java
String nome = "Assuero";
```

## 7. Comentários

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

## 8. Métodos

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

## 9. Escopo

Escopo define onde uma variável pode ser acessada.

Variável local:
```java
public static void exemplo() {
    String mensagem = "Olá";
}
```
A variável mensagem só existe dentro do método exemplo.

## 10. Resumo

Nesta aula, os principais conceitos foram:

- Classe
- Método main
- Variáveis
- Tipos
- Comentários
- Métodos
- Escopo