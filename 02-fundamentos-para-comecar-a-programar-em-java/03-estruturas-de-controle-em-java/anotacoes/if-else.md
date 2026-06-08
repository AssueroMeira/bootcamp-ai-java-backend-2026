# Anotações — Estruturas Condicionais em Java

## 1. O que são estruturas condicionais?

Estruturas condicionais permitem que o programa tome decisões.

Em vez de executar sempre o mesmo caminho, o programa pode verificar uma condição e escolher qual bloco de código será executado.

Exemplo conceitual:

```text
Se a idade for maior ou igual a 18:
    mostrar mensagem de maioridade
Senão, se a pessoa for emancipada:
    mostrar mensagem de emancipação
Senão:
    mostrar mensagem de menoridade
```

Em Java, isso pode ser feito com:

* `if`;
* `else if`;
* `else`;
* operador ternário `? :`.

---

## 2. Estrutura `if`

O `if` é usado para executar um bloco de código somente se uma condição for verdadeira.

Exemplo:

```java
if (age >= 18) {
    System.out.printf("Olá %s, você é maior de idade.\n", name);
}
```

Nesse exemplo, o bloco só será executado se `age >= 18` for verdadeiro.

A condição:

```java
age >= 18
```

retorna um valor booleano:

```text
true ou false
```

---

## 3. Estrutura `else`

O `else` é executado quando a condição do `if` não é verdadeira.

Exemplo:

```java
if (age >= 18) {
    System.out.printf("Olá %s, você é maior de idade.\n", name);
} else {
    System.out.printf("Olá %s, você é menor de idade.\n", name);
}
```

A lógica é:

```text
Se age >= 18:
    maior de idade
Senão:
    menor de idade
```

---

## 4. Estrutura `else if`

O `else if` permite testar uma segunda condição quando a primeira não foi atendida.

Exemplo:

```java
if (age >= 18) {
    System.out.printf("Olá %s, você é maior de idade.\n", name);
} else if (age < 18 && isEmancipated) {
    System.out.printf("Olá %s, você é emancipado e tem os mesmos direitos de um maior de idade.\n", name);
} else {
    System.out.printf("Olá %s, você é menor de idade.\n", name);
}
```

A lógica é:

```text
Se age >= 18:
    maior de idade
Senão, se age < 18 e isEmancipated for true:
    emancipado
Senão:
    menor de idade
```

---

## 5. Operadores relacionais usados

Operadores relacionais comparam valores.

No código estudado, foram usados:

| Operador | Significado    | Exemplo     |
| -------- | -------------- | ----------- |
| `>=`     | maior ou igual | `age >= 18` |
| `<`      | menor que      | `age < 18`  |

Exemplo:

```java
age >= 18
```

Essa expressão verifica se a idade é maior ou igual a 18.

Se `age` for `18`, o resultado será:

```text
true
```

Se `age` for `16`, o resultado será:

```text
false
```

---

## 6. Operador lógico `&&`

O operador `&&` representa o **E lógico**.

Ele é usado quando duas condições precisam ser verdadeiras ao mesmo tempo.

Exemplo:

```java
age < 18 && isEmancipated
```

Essa condição só será verdadeira se:

```text
age < 18 for true
e
isEmancipated for true
```

Exemplo prático:

```java
int age = 16;
boolean isEmancipated = true;
```

Nesse caso:

```java
age < 18 && isEmancipated
```

será:

```text
true
```

Agora, se a pessoa não for emancipada:

```java
int age = 16;
boolean isEmancipated = false;
```

A expressão será:

```text
false
```

Modelo mental:

```text
true  && true  = true
true  && false = false
false && true  = false
false && false = false
```

---

## 7. Leitura de dados com Scanner

Nos dois códigos, foi usado `Scanner` para ler dados digitados pelo usuário.

```java
var scanner = new java.util.Scanner(System.in);
```

Esse comando cria um objeto `scanner` capaz de ler dados do terminal.

Exemplo de leitura do nome:

```java
System.out.println("Informe seu nome:");
var name = scanner.nextLine();
```

O método `nextLine()` lê uma linha inteira de texto.

Exemplo de leitura da idade:

```java
System.out.println("Informe sua idade:");
var age = scanner.nextInt();
```

O método `nextInt()` lê um número inteiro.

---

## 8. Cuidado ao misturar `nextInt()` e `nextLine()`

Depois de usar `nextInt()`, é comum precisar consumir a quebra de linha pendente.

No código, isso foi feito com:

```java
scanner.nextLine(); // Consumir a quebra de linha pendente
```

Isso é necessário porque o usuário digita a idade e pressiona Enter.

Exemplo:

```text
16 + Enter
```

O `nextInt()` lê apenas o número:

```text
16
```

Mas o Enter fica pendente no buffer.

Por isso, antes de usar uma nova leitura de texto com `nextLine()`, usamos:

```java
scanner.nextLine();
```

Modelo mental:

```text
Usuário digita: 16 + Enter

nextInt()
lê: 16
deixa pendente: Enter

nextLine()
consome o Enter pendente
```

No código atual, após `nextInt()`, foi usado `scanner.nextLine()` para limpar essa quebra de linha antes de continuar a leitura.

---

## 9. Lendo resposta `s/n`

Para saber se a pessoa é emancipada, foi usada esta linha:

```java
var isEmancipated = scanner.next().equalsIgnoreCase("s");
```

Essa linha faz algumas coisas ao mesmo tempo.

Primeiro:

```java
scanner.next()
```

lê a próxima palavra digitada pelo usuário.

Depois:

```java
.equalsIgnoreCase("s")
```

compara o valor digitado com `"s"`, ignorando maiúsculas e minúsculas.

Assim, as respostas abaixo serão consideradas verdadeiras:

```text
s
S
```

Se o usuário digitar `s`, a variável `isEmancipated` receberá:

```text
true
```

Se o usuário digitar `n`, a variável receberá:

```text
false
```

Exemplo:

```java
var isEmancipated = scanner.next().equalsIgnoreCase("s");
```

Equivale, conceitualmente, a:

```text
Leia a resposta do usuário.
Verifique se a resposta é igual a "s".
Se for, isEmancipated será true.
Se não for, isEmancipated será false.
```

---

## 10. Código com `if`, `else if` e `else`

O primeiro código estudado foi:

```java
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
        } else if (age < 18 && isEmancipated) {
            System.out.printf("Olá %s, você é emancipado e tem os mesmos direitos de um maior de idade.\n", name);
        } else {
            System.out.printf("Olá %s, você é menor de idade.\n", name);
        }

        scanner.close();
    }
}
```

Esse código possui três possíveis caminhos:

### Caminho 1 — Maior de idade

```java
if (age >= 18)
```

Se a idade for maior ou igual a 18, o programa exibe:

```text
Olá Nome, você é maior de idade.
```

### Caminho 2 — Menor de idade emancipado

```java
else if (age < 18 && isEmancipated)
```

Se a idade for menor que 18 e a pessoa for emancipada, o programa exibe:

```text
Olá Nome, você é emancipado e tem os mesmos direitos de um maior de idade.
```

### Caminho 3 — Menor de idade

```java
else
```

Se nenhuma das condições anteriores for verdadeira, o programa exibe:

```text
Olá Nome, você é menor de idade.
```

---

## 11. Importância da ordem das condições

A ordem das condições importa.

No código:

```java
if (age >= 18) {
    ...
} else if (age < 18 && isEmancipated) {
    ...
} else {
    ...
}
```

O Java verifica primeiro se a pessoa tem 18 anos ou mais.

Se essa condição for verdadeira, ele executa esse bloco e ignora os demais.

Se for falsa, ele passa para o `else if`.

Se o `else if` também for falso, ele executa o `else`.

Modelo mental:

```text
if       → testa primeiro
else if  → testa somente se o if for falso
else     → executa se nenhuma condição anterior for verdadeira
```

---

## 12. Operador ternário

O segundo código usou o operador ternário.

O operador ternário é uma forma mais curta de escrever uma estrutura condicional simples.

Sua estrutura é:

```java
condicao ? valorSeVerdadeiro : valorSeFalso
```

Exemplo simples:

```java
var message = age >= 18 ? "Maior de idade" : "Menor de idade";
```

A lógica é:

```text
Se age >= 18 for true:
    message recebe "Maior de idade"
Senão:
    message recebe "Menor de idade"
```

---

## 13. Código com operador ternário

O segundo código estudado foi:

```java
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
```

Esse código produz o mesmo resultado do exemplo com `if`, `else if` e `else`.

A diferença é que a decisão foi feita dentro da atribuição da variável `message`.

---

## 14. Entendendo a variável `message`

No código:

```java
var message = age >= 18 ? String.format("Olá %s, você é maior de idade.\n", name) :
              (age < 18 && isEmancipated) ? String.format("Olá %s, você é emancipado e tem os mesmos direitos de um maior de idade.\n", name) :
              String.format("Olá %s, você é menor de idade.\n", name);
```

A variável `message` receberá uma das três mensagens possíveis.

A lógica é:

```text
Se age >= 18:
    message recebe a mensagem de maioridade
Senão, se age < 18 e isEmancipated for true:
    message recebe a mensagem de emancipação
Senão:
    message recebe a mensagem de menoridade
```

Depois, o conteúdo da variável é exibido:

```java
System.out.print(message);
```

---

## 15. `String.format`

No segundo código, foi usado `String.format()`.

Exemplo:

```java
String.format("Olá %s, você é maior de idade.\n", name)
```

O `String.format()` cria uma `String` formatada.

Ele é parecido com o `System.out.printf()`, mas há uma diferença importante:

### `System.out.printf()`

Exibe diretamente a mensagem no terminal.

```java
System.out.printf("Olá %s\n", name);
```

### `String.format()`

Monta a mensagem e retorna uma `String`.

```java
var message = String.format("Olá %s\n", name);
```

Depois, essa mensagem pode ser impressa:

```java
System.out.print(message);
```

---

## 16. Diferença entre `printf`, `print` e `println`

### `System.out.print`

Exibe uma mensagem sem quebrar linha automaticamente.

```java
System.out.print("Olá");
```

### `System.out.println`

Exibe uma mensagem e quebra a linha ao final.

```java
System.out.println("Olá");
```

### `System.out.printf`

Exibe uma mensagem formatada.

```java
System.out.printf("Olá %s\n", name);
```

No primeiro código, foi usado:

```java
System.out.printf(...)
```

No segundo código, foi usado:

```java
System.out.print(message);
```

porque a mensagem já tinha sido montada antes com `String.format()`.

---

## 17. Operador ternário encadeado

No código `ElvisOperator`, foi usado um ternário encadeado.

Exemplo simplificado:

```java
var message = condicao1 ? valor1 :
              condicao2 ? valor2 :
              valor3;
```

Isso significa:

```text
Se condicao1 for verdadeira:
    retorna valor1
Senão, se condicao2 for verdadeira:
    retorna valor2
Senão:
    retorna valor3
```

Apesar de funcionar, o ternário encadeado pode ficar mais difícil de ler quando existem muitas condições.

Para estudo, é importante entender os dois formatos:

* `if / else if / else`: mais claro para fluxos com várias decisões;
* operador ternário: útil para decisões curtas e atribuições simples.

---

## 18. Observação sobre o nome `ElvisOperator`

O arquivo estudado se chama:

```text
ElvisOperator.java
```

Porém, em Java, o operador usado no código é tecnicamente chamado de **operador ternário condicional**.

O formato dele é:

```java
condicao ? valorSeVerdadeiro : valorSeFalso
```

O nome "Elvis operator" costuma aparecer em outras linguagens ou contextos, mas, em Java, o mais adequado é chamar de operador ternário.

---

## 19. Comparando as duas abordagens

### Com `if / else if / else`

Vantagens:

* mais fácil de ler;
* mais indicado para iniciantes;
* melhor para regras com várias etapas;
* facilita colocar comandos diferentes dentro de cada bloco.

Exemplo:

```java
if (age >= 18) {
    System.out.printf("Olá %s, você é maior de idade.\n", name);
} else if (age < 18 && isEmancipated) {
    System.out.printf("Olá %s, você é emancipado e tem os mesmos direitos de um maior de idade.\n", name);
} else {
    System.out.printf("Olá %s, você é menor de idade.\n", name);
}
```

### Com operador ternário

Vantagens:

* código mais curto;
* útil quando o objetivo é atribuir um valor a uma variável;
* bom para condições simples.

Exemplo:

```java
var message = age >= 18 ? "Maior de idade" : "Menor de idade";
```

Desvantagem:

* pode ficar difícil de ler quando existem muitas condições encadeadas.

---

## 20. Sugestão de melhoria lógica

Nos dois códigos, o programa pergunta se a pessoa é emancipada mesmo quando ela tem 18 anos ou mais.

Funciona, mas a pergunta só seria necessária para menores de idade.

Uma forma alternativa seria:

```java
if (age >= 18) {
    System.out.printf("Olá %s, você é maior de idade.\n", name);
} else {
    System.out.println("Você é emancipado? (s/n)");
    var isEmancipated = scanner.next().equalsIgnoreCase("s");

    if (isEmancipated) {
        System.out.printf("Olá %s, você é emancipado e tem os mesmos direitos de um maior de idade.\n", name);
    } else {
        System.out.printf("Olá %s, você é menor de idade.\n", name);
    }
}
```

Essa versão evita perguntar sobre emancipação quando a pessoa já é maior de idade.

---

## 21. Compilação e execução pelo terminal

Para compilar e executar os arquivos estudados, entre na pasta:

```bash
cd ~/bootcamp-ai-java-backend-2026/02-fundamentos-para-comecar-a-programar-em-java/03-estruturas-de-controle-em-java
```

Compile o primeiro arquivo:

```bash
javac EstruturaCondicional.java
```

Execute:

```bash
java EstruturaCondicional
```

Compile o segundo arquivo:

```bash
javac ElvisOperator.java
```

Execute:

```bash
java ElvisOperator
```

Também é possível executar diretamente o arquivo fonte em exercícios simples:

```bash
java EstruturaCondicional.java
```

ou:

```bash
java ElvisOperator.java
```

---

## 22. Sobre o botão Run do VS Code

Ao clicar em `Run`, o VS Code tenta compilar e executar o código automaticamente usando o ambiente configurado pela extensão Java.

Em alguns momentos, o VS Code pode procurar a classe compilada em um classpath interno e não encontrar.

Quando isso acontece, pode aparecer um erro como:

```text
Error: Could not find or load main class EstruturaCondicional
Caused by: java.lang.ClassNotFoundException: EstruturaCondicional
```

Esse erro geralmente indica que o Java não encontrou a classe compilada no local esperado.

Para estudar os fundamentos, o caminho mais seguro é usar o terminal:

```bash
javac NomeDoArquivo.java
java NomeDaClasse
```

Modelo mental:

```text
Arquivo .java  →  javac compila  →  arquivo .class  →  java executa
```

---

## 23. Pontos de atenção

Alguns pontos importantes observados nesta etapa:

* o nome do arquivo deve ser igual ao nome da classe pública;
* `EstruturaCondicional.java` deve conter `public class EstruturaCondicional`;
* `ElvisOperator.java` deve conter `public class ElvisOperator`;
* `if` executa um bloco se a condição for verdadeira;
* `else if` testa uma nova condição quando o `if` anterior foi falso;
* `else` executa quando nenhuma condição anterior foi verdadeira;
* `&&` exige que as duas condições sejam verdadeiras;
* `nextInt()` pode deixar uma quebra de linha pendente;
* `scanner.nextLine()` pode ser usado para consumir essa quebra de linha;
* `equalsIgnoreCase("s")` compara texto ignorando maiúsculas e minúsculas;
* operador ternário é útil, mas deve ser usado com cuidado para não prejudicar a leitura.

---

## 24. Resumo

Nesta etapa, foram praticados os seguintes conceitos:

* estrutura condicional `if`;
* estrutura `else`;
* estrutura `else if`;
* operadores relacionais;
* operador lógico `&&`;
* leitura de dados com `Scanner`;
* leitura de respostas `s/n`;
* conversão de uma resposta textual em valor booleano;
* uso de `equalsIgnoreCase`;
* cuidado com `nextInt()` e `nextLine()`;
* operador ternário;
* ternário encadeado;
* `String.format`;
* diferença entre `printf`, `print` e `println`;
* compilação com `javac`;
* execução com `java`.

Esses conceitos formam a base para criar programas que tomam decisões de acordo com os dados informados pelo usuário.
