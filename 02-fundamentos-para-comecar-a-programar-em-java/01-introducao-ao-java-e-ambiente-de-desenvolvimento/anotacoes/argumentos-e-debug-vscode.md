# Argumentos no método main e Debug no VS Code

## 1. Contexto

Este documento registra os aprendizados da aula sobre execução de programas Java com argumentos e uso do recurso de Debug no Visual Studio Code.

A aula faz parte do módulo:

```text
Fundamentos para Começar a Programar em Java
```

Dentro do curso:

```text
Introdução ao Java e seu Ambiente de Desenvolvimento
```

O objetivo da prática foi entender:

* como funciona o parâmetro `String[] args` no método `main`;
* como passar argumentos ao executar um programa Java;
* como configurar argumentos no arquivo `launch.json`;
* como usar o Debug do VS Code;
* como interpretar variáveis, pilha de chamadas e breakpoints;
* como entender erros gerados durante a execução.

---

## 2. Código estudado

O código utilizado na aula foi um exemplo simples chamado `HelloWorld.java`.

```java
public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Olá, Java! Ambiente configurado no VS Code com WSL.");
        System.out.println("Este é o meu primeiro programa em " + args[0]);
    }
}
```

Esse código imprime uma primeira mensagem fixa e depois imprime uma segunda mensagem usando o primeiro argumento recebido pelo programa.

---

## 3. O que é o método `main`

Em Java, o método `main` é o ponto de entrada do programa.

```java
public static void main(String[] args)
```

É por ele que a execução começa.

Cada parte tem um significado:

```text
public
```

Indica que o método pode ser acessado pela JVM.

```text
static
```

Permite que o método seja executado sem criar um objeto da classe.

```text
void
```

Indica que o método não retorna nenhum valor.

```text
main
```

É o nome padrão do método inicial de execução em Java.

```text
String[] args
```

É um array de textos que recebe argumentos passados na execução do programa.

---

## 4. O que é `args`

O parâmetro `args` representa os argumentos recebidos pelo programa no momento da execução.

Exemplo:

```bash
java HelloWorld Java
```

Nesse caso:

```java
args[0] = "Java"
```

Se o programa for executado assim:

```bash
java HelloWorld Bootcamp
```

Então:

```java
args[0] = "Bootcamp"
```

Se for executado assim:

```bash
java HelloWorld Assuero
```

Então:

```java
args[0] = "Assuero"
```

---

## 5. Entendendo `args[0]`

Em Java, arrays começam na posição zero.

Portanto:

```java
args[0]
```

significa:

```text
primeiro argumento passado para o programa
```

Exemplo com um argumento:

```bash
java HelloWorld Java
```

O array `args` terá:

```text
args[0] = Java
```

Exemplo com dois argumentos:

```bash
java HelloWorld Java Backend
```

O array `args` terá:

```text
args[0] = Java
args[1] = Backend
```

---

## 6. Erro encontrado durante a execução

Ao executar o programa sem passar argumentos, apareceu o erro:

```text
Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: Index 0 out of bounds for length 0
        at HelloWorld.main(HelloWorld.java:4)
```

Esse erro aconteceu porque o código tentou acessar:

```java
args[0]
```

Mas nenhum argumento foi passado na execução.

Ou seja, o array `args` estava vazio.

```text
args.length = 0
```

Como não existia posição zero, o Java lançou a exceção:

```text
ArrayIndexOutOfBoundsException
```

---

## 7. Interpretação do erro

A mensagem:

```text
Index 0 out of bounds for length 0
```

pode ser interpretada assim:

```text
O programa tentou acessar o índice 0 de um array que tem tamanho 0.
```

No contexto do programa:

```text
O programa tentou acessar args[0], mas nenhum argumento foi informado.
```

A linha indicada foi:

```text
HelloWorld.java:4
```

Isso mostrou que o problema estava na linha que usa:

```java
args[0]
```

---

## 8. Execução correta com argumento

Para executar corretamente, é necessário passar um argumento.

Exemplo:

```bash
java HelloWorld Java
```

Resultado obtido:

```text
Olá, Java! Ambiente configurado no VS Code com WSL.
Este é o meu primeiro programa em Java
```

No VS Code, a execução com argumento também funcionou quando o `launch.json` foi configurado.

---

## 9. Ajuste de espaço na concatenação

Durante a prática, a mensagem apareceu assim:

```text
Este é o meu primeiro programa emJava
```

Isso aconteceu porque o código estava assim:

```java
System.out.println("Este é o meu primeiro programa em" + args[0]);
```

Faltou um espaço depois da palavra `em`.

A forma corrigida é:

```java
System.out.println("Este é o meu primeiro programa em " + args[0]);
```

Com isso, o resultado fica:

```text
Este é o meu primeiro programa em Java
```

---

## 10. Configuração do `launch.json`

Para passar argumentos pelo VS Code, foi utilizado o arquivo:

```text
.vscode/launch.json
```

Configuração utilizada:

```json
{
    "version": "0.2.0",
    "configurations": [
        {
            "type": "java",
            "name": "HelloWorld",
            "request": "launch",
            "mainClass": "HelloWorld",
            "projectName": "bootcamp-ai-java-backend-2026_78e84dd9",
            "args": ["Java"]
        },
        {
            "type": "java",
            "name": "Current File",
            "request": "launch",
            "mainClass": "${file}"
        }
    ]
}
```

A configuração chamada:

```text
HelloWorld
```

executa a classe `HelloWorld` passando o argumento:

```text
Java
```

A configuração chamada:

```text
Current File
```

executa o arquivo atual, mas não passa argumentos.

Por isso, ao usar `Current File`, o programa pode gerar erro se o código depender de `args[0]`.

---

## 11. Diferença entre `HelloWorld` e `Current File`

### Configuração `HelloWorld`

```json
{
    "type": "java",
    "name": "HelloWorld",
    "request": "launch",
    "mainClass": "HelloWorld",
    "projectName": "bootcamp-ai-java-backend-2026_78e84dd9",
    "args": ["Java"]
}
```

Essa configuração é específica para a classe `HelloWorld`.

Ela passa o argumento:

```text
Java
```

Por isso, o código consegue acessar:

```java
args[0]
```

sem erro.

---

### Configuração `Current File`

```json
{
    "type": "java",
    "name": "Current File",
    "request": "launch",
    "mainClass": "${file}"
}
```

Essa configuração executa o arquivo Java aberto no momento.

Porém, ela não passa argumentos.

Por isso, se o código usar:

```java
args[0]
```

e nenhum argumento for informado, ocorrerá:

```text
ArrayIndexOutOfBoundsException
```

---

## 12. Como evitar erro ao usar `args[0]`

Uma forma mais segura de escrever o programa é verificar se existe argumento antes de acessar `args[0]`.

Exemplo:

```java
public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Olá, Java! Ambiente configurado no VS Code com WSL.");

        if (args.length > 0) {
            System.out.println("Este é o meu primeiro programa em " + args[0]);
        } else {
            System.out.println("Nenhum argumento foi informado.");
            System.out.println("Exemplo de uso: java HelloWorld Java");
        }
    }
}
```

Essa versão evita o erro porque primeiro verifica:

```java
args.length > 0
```

Somente se houver argumento é que acessa:

```java
args[0]
```

---

## 13. Comando gerado pelo VS Code ao executar com argumento

Quando executei pelo VS Code com o argumento `Java`, o terminal mostrou um comando semelhante a este:

```bash
/usr/bin/env /home/assuero/.sdkman/candidates/java/25.0.3-amzn/bin/java -XX:+ShowCodeDetailsInExceptionMessages -cp /home/assuero/.vscode-server/data/User/workspaceStorage/199eea7677d1c5f567183ae24bf35e34/redhat.java/jdt_ws/bootcamp-ai-java-backend-2026_78e84dd9/bin HelloWorld Java
```

O trecho mais importante é o final:

```bash
HelloWorld Java
```

Isso significa que o VS Code executou a classe `HelloWorld` passando o argumento `Java`.

---

## 14. Resultado da execução com argumento

Resultado obtido:

```text
Olá, Java! Ambiente configurado no VS Code com WSL.
Este é o meu primeiro programa emJava
```

Depois foi identificado que faltou um espaço no código.

A correção foi:

```java
System.out.println("Este é o meu primeiro programa em " + args[0]);
```

Resultado esperado após a correção:

```text
Olá, Java! Ambiente configurado no VS Code com WSL.
Este é o meu primeiro programa em Java
```

---

## 15. Introdução ao Debug

Além de executar o programa normalmente, também foi estudado o uso do Debug no VS Code.

O Debug permite acompanhar a execução do programa passo a passo.

Com ele, é possível:

* pausar a execução em uma linha específica;
* observar valores das variáveis;
* acompanhar a pilha de chamadas;
* avançar linha por linha;
* entrar em métodos;
* sair de métodos;
* identificar onde um erro acontece;
* entender melhor o fluxo do programa.

---

## 16. Breakpoint

Um breakpoint é um ponto de parada.

Ele é colocado clicando à esquerda do número da linha no VS Code.

Quando o programa chega naquela linha, a execução pausa.

Isso permite observar o estado do programa naquele momento.

Exemplo de uso:

```text
Colocar um breakpoint na linha do System.out.println
```

Quando o programa chegar nessa linha, o VS Code pausa e mostra as variáveis disponíveis.

---

## 17. Painel Run and Debug

Durante o Debug, o VS Code apresenta o painel:

```text
Run and Debug
```

Esse painel mostra informações importantes sobre a execução do programa.

As principais áreas vistas foram:

* Variables;
* Watch;
* Call Stack;
* Breakpoints.

---

## 18. Variables

A seção `Variables` mostra as variáveis disponíveis no ponto em que o programa está pausado.

Na imagem da prática, apareceu a seção:

```text
Local
```

Dentro dela, apareceu uma variável como:

```text
x = "Olá, Java! Ambiente configurado no VS Code com WSL."
```

Isso ocorreu porque o Debug parou dentro da execução de um método relacionado ao `println`.

Também apareceu:

```text
this = PrintStream@12
```

Isso indica que a execução estava passando por um objeto interno usado pelo Java para imprimir texto no terminal.

---

## 19. Watch

A seção `Watch` permite acompanhar expressões específicas.

Por exemplo, em um programa com argumentos, seria possível adicionar expressões como:

```java
args.length
```

```java
args[0]
```

Essas expressões ajudam a verificar:

* se argumentos foram passados;
* quantos argumentos existem;
* qual é o valor do primeiro argumento.

Exemplo de interpretação:

```text
args.length = 1
args[0] = "Java"
```

Se nenhum argumento for passado:

```text
args.length = 0
```

Nesse caso, acessar `args[0]` gera erro.

---

## 20. Call Stack

A seção `Call Stack` mostra a pilha de chamadas do programa.

Na prática, apareceu algo como:

```text
Thread [main]
PrintStream.println(String)
HelloWorld.main(String[])
```

Isso indica que o programa começou no método:

```java
HelloWorld.main(String[])
```

Depois chamou:

```java
System.out.println(...)
```

Internamente, o Java executou:

```text
PrintStream.println(String)
```

A pilha de chamadas ajuda a entender o caminho percorrido pelo programa até o ponto onde ele está pausado.

---

## 21. Breakpoints

A seção `Breakpoints` mostra todos os pontos de parada configurados.

Na prática, apareceu um breakpoint no arquivo:

```text
HelloWorld.java
```

Também existem opções como:

```text
Uncaught Exceptions
Caught Exceptions
```

Essas opções permitem pausar o programa automaticamente quando exceções são lançadas.

---

## 22. Uncaught Exceptions

A opção `Uncaught Exceptions` faz o Debug parar quando ocorre uma exceção não tratada pelo programa.

Exemplo:

```text
ArrayIndexOutOfBoundsException
```

Esse erro ocorreu porque o programa tentou acessar:

```java
args[0]
```

sem argumento informado.

Como o erro não foi tratado com `try/catch`, ele é uma exceção não capturada.

---

## 23. Caught Exceptions

A opção `Caught Exceptions` faz o Debug parar mesmo quando a exceção é tratada pelo programa.

Esse recurso pode ser útil em programas mais avançados, quando existem blocos:

```java
try {
    // código
} catch (Exception e) {
    // tratamento
}
```

Nesta etapa inicial, o foco principal foi entender a exceção não tratada.

---

## 24. Botões principais do Debug

Durante o Debug, o VS Code apresenta botões no topo da tela.

Os principais são:

```text
Continue
Step Over
Step Into
Step Out
Restart
Stop
```

---

### Continue

Continua a execução até o próximo breakpoint ou até o fim do programa.

Uso:

```text
Quando quero deixar o programa seguir normalmente.
```

---

### Step Over

Executa a linha atual e vai para a próxima linha, sem entrar nos detalhes internos dos métodos chamados.

Uso:

```text
Quando quero avançar linha por linha no meu código.
```

Exemplo:

```java
System.out.println("Olá, Java!");
```

Com `Step Over`, o VS Code executa o `println`, mas não entra nos detalhes internos da classe `PrintStream`.

---

### Step Into

Entra dentro do método chamado na linha atual.

Uso:

```text
Quando quero entender o que acontece dentro de um método.
```

Ao usar `Step Into` em:

```java
System.out.println("Olá, Java!");
```

o Debug pode entrar em código interno do Java, como:

```text
PrintStream.println(String)
```

Isso explica por que apareceu o arquivo `PrintStream.java` durante o Debug.

---

### Step Out

Sai do método atual e volta para o ponto anterior da chamada.

Uso:

```text
Quando entrei em um método interno e quero voltar para o meu código.
```

---

### Restart

Reinicia a execução do programa em modo Debug.

Uso:

```text
Quando quero testar novamente desde o início.
```

---

### Stop

Encerra a sessão de Debug.

Uso:

```text
Quando quero parar completamente a execução.
```

---

## 25. Por que apareceu `PrintStream.java`

Durante o Debug, ao usar recursos como `Step Into`, o VS Code pode entrar em métodos internos da biblioteca Java.

O comando:

```java
System.out.println(...)
```

usa internamente a classe:

```java
java.io.PrintStream
```

Por isso, ao depurar, pode aparecer um arquivo chamado:

```text
PrintStream.java
```

Isso não significa que o programa esteja errado.

Significa apenas que o Debug entrou no código interno usado pelo Java para imprimir mensagens no terminal.

Para voltar ao código próprio, pode-se usar:

```text
Step Out
```

ou continuar a execução até o próximo breakpoint no arquivo `HelloWorld.java`.

---

## 26. Comando gerado pelo VS Code em modo Debug

Quando o VS Code executa o programa em modo Debug, ele adiciona parâmetros específicos ao comando Java.

Exemplo observado:

```bash
/usr/bin/env /home/assuero/.sdkman/candidates/java/25.0.3-amzn/bin/java -agentlib:jdwp=transport=dt_socket,server=n,suspend=y,address=localhost:43003 -XX:+ShowCodeDetailsInExceptionMessages -cp /home/assuero/.vscode-server/data/User/workspaceStorage/199eea7677d1c5f567183ae24bf35e34/redhat.java/jdt_ws/bootcamp-ai-java-backend-2026_78e84dd9/bin HelloWorld
```

O trecho mais importante para entender o Debug é:

```bash
-agentlib:jdwp=transport=dt_socket,server=n,suspend=y,address=localhost:43003
```

Esse trecho indica que o Java foi iniciado com suporte ao protocolo de depuração.

---

## 27. O que é JDWP

JDWP significa:

```text
Java Debug Wire Protocol
```

É um protocolo usado para permitir que uma ferramenta, como o VS Code, controle a execução do programa Java em modo Debug.

Na prática, isso permite:

* pausar o programa;
* inspecionar variáveis;
* avançar linha por linha;
* acompanhar chamadas;
* interromper a execução.

---

## 28. Interpretação do comando de Debug

No comando de Debug:

```bash
-agentlib:jdwp=transport=dt_socket,server=n,suspend=y,address=localhost:43003
```

Os principais trechos são:

```text
-agentlib:jdwp
```

Ativa a biblioteca de Debug do Java.

```text
transport=dt_socket
```

Indica que a comunicação do Debug usa socket.

```text
server=n
```

Indica que a JVM não está atuando como servidor de Debug; ela se conecta ao depurador.

```text
suspend=y
```

Indica que a execução pode iniciar pausada, esperando o depurador.

```text
address=localhost:43003
```

Indica o endereço local usado para a comunicação entre o VS Code e a JVM.

---

## 29. Breakpoints condicionais

A aula também apresentou o conceito de breakpoint condicional.

Um breakpoint condicional é um ponto de parada que só pausa o programa se uma condição for verdadeira.

Exemplo conceitual:

```text
Pausar somente se args.length == 0
```

ou:

```text
Pausar somente se args[0].equals("Java")
```

Isso é útil quando o programa passa várias vezes por uma linha, mas só queremos parar em uma situação específica.

---

## 30. Exemplo de breakpoint condicional para esta aula

Um exemplo que poderia ser testado neste programa:

```java
System.out.println("Este é o meu primeiro programa em " + args[0]);
```

Condição do breakpoint:

```java
args.length == 0
```

Nesse caso, o Debug pausaria quando nenhum argumento fosse passado.

Outro exemplo:

```java
args.length > 0 && args[0].equals("Java")
```

Nesse caso, o Debug pausaria somente se o primeiro argumento fosse:

```text
Java
```

---

## 31. Como criar breakpoint condicional no VS Code

Passos:

```text
1. Clicar com o botão direito sobre o breakpoint.
2. Escolher Edit Breakpoint.
3. Selecionar Expression.
4. Digitar a condição.
5. Pressionar Enter.
```

Exemplo de expressão:

```java
args.length > 0 && args[0].equals("Java")
```

Quando a condição for verdadeira, o programa pausa naquela linha.

Quando a condição for falsa, o programa continua normalmente.

---

## 32. Erro observado ao executar sem argumento em Debug

Ao executar o programa em modo Debug sem passar argumento, ocorreu novamente:

```text
Olá, Java! Ambiente configurado no VS Code com WSL.
Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: Index 0 out of bounds for length 0
        at HelloWorld.main(HelloWorld.java:4)
```

Esse erro reforçou o aprendizado:

```text
Se o programa usa args[0], é necessário passar ao menos um argumento.
```

Ou então o código deve verificar:

```java
args.length > 0
```

antes de acessar o argumento.

---

## 33. Versão mais segura do código

Para evitar o erro, uma versão mais segura do código é:

```java
public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Olá, Java! Ambiente configurado no VS Code com WSL.");

        if (args.length > 0) {
            System.out.println("Este é o meu primeiro programa em " + args[0]);
        } else {
            System.out.println("Nenhum argumento foi informado.");
            System.out.println("Configure um argumento no launch.json ou execute: java HelloWorld Java");
        }
    }
}
```

Essa versão é mais robusta porque verifica se existe argumento antes de tentar acessar a posição zero.

---

## 34. O que foi aprendido nesta etapa

Nesta aula, aprendi que:

* `String[] args` recebe argumentos passados na execução do programa;
* `args[0]` representa o primeiro argumento;
* arrays em Java começam no índice zero;
* se nenhum argumento for passado, `args.length` será igual a zero;
* acessar `args[0]` sem argumento causa `ArrayIndexOutOfBoundsException`;
* o `launch.json` permite configurar a execução de programas no VS Code;
* a propriedade `"args": ["Java"]` passa argumentos para o programa;
* a configuração `Current File` não passa argumentos por padrão;
* o Debug permite pausar e examinar a execução do programa;
* `Variables` mostra variáveis locais;
* `Watch` permite acompanhar expressões;
* `Call Stack` mostra a sequência de chamadas;
* `Breakpoints` define onde o programa deve pausar;
* `Step Into` pode entrar em código interno do Java;
* `Step Over` é melhor para avançar sem entrar nos detalhes internos;
* `Step Out` permite sair de métodos internos e voltar ao código próprio;
* breakpoints condicionais permitem pausar apenas quando uma condição é verdadeira.

---

## 35. Cuidados para as próximas aulas

Para evitar erros parecidos:

```text
1. Conferir se o programa espera argumentos.
2. Verificar se o launch.json está passando os argumentos necessários.
3. Usar args.length antes de acessar args[0].
4. Preferir Step Over quando não quiser entrar no código interno do Java.
5. Usar Step Out se entrar acidentalmente em classes como PrintStream.
6. Ler com atenção a linha indicada no erro.
```

---

## 36. Status da etapa

Status:

```text
Concluída
```

Conteúdos praticados:

```text
Argumentos no método main
Configuração do launch.json
Execução com argumentos
Debug no VS Code
Breakpoints
Call Stack
Variables
Watch
Exceções por ausência de argumentos
```

Arquivo principal da prática:

```text
HelloWorld.java
```

Arquivo de configuração usado:

```text
.vscode/launch.json
```

Data do registro:

```text
31/05/2026
```

---

# Fim do registro
