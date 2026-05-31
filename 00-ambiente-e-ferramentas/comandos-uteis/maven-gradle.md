# Instalação do Maven e Gradle com SDKMAN

## 1. Contexto

Este documento registra a instalação do **Apache Maven** e do **Gradle** no ambiente WSL utilizado para o **Bootcamp AI Java Back-end 2026**.

Após instalar e validar o JDK Amazon Corretto com SDKMAN, o próximo passo do curso foi preparar o ambiente para trabalhar com ferramentas de build Java.

Nesta etapa, foram instaladas duas ferramentas importantes:

* **Maven**
* **Gradle**

Ambas são muito usadas em projetos Java e Spring Boot para gerenciar dependências, compilar o projeto, executar testes e empacotar aplicações.

---

## 2. Ambiente utilizado

* Sistema operacional principal: Windows
* Ambiente de desenvolvimento: WSL 2
* Distribuição: Ubuntu no WSL
* Usuário WSL: `assuero`
* JDK: Amazon Corretto 25.0.3
* Gerenciador de SDKs: SDKMAN
* Editor: Visual Studio Code conectado ao WSL

---

## 3. Por que instalar Maven e Gradle?

Durante o bootcamp, é possível encontrar projetos Java que usam Maven ou Gradle.

A escolha depende do projeto:

```text
Se o projeto tiver pom.xml → usar Maven
Se o projeto tiver build.gradle → usar Gradle
Se o projeto tiver build.gradle.kts → usar Gradle com Kotlin DSL
Se o projeto tiver mvnw → preferir ./mvnw
Se o projeto tiver gradlew → preferir ./gradlew
```

Mesmo quando Maven ou Gradle estão instalados globalmente, muitos projetos profissionais usam os arquivos de wrapper:

* `mvnw`
* `mvnw.cmd`
* `gradlew`
* `gradlew.bat`

Esses wrappers ajudam a garantir que todos os desenvolvedores usem a mesma versão da ferramenta definida pelo projeto.

---

## 4. Diferença básica entre Maven e Gradle

### Maven

O Maven é uma ferramenta tradicional do ecossistema Java.

Ele usa principalmente o arquivo:

```text
pom.xml
```

Esse arquivo define:

* informações do projeto;
* dependências;
* plugins;
* versão do Java;
* comandos de build;
* empacotamento da aplicação.

Exemplo de comando Maven:

```bash
mvn clean install
```

---

### Gradle

O Gradle é uma ferramenta de build mais moderna e flexível.

Ele usa normalmente um destes arquivos:

```text
build.gradle
```

ou:

```text
build.gradle.kts
```

Exemplo de comando Gradle:

```bash
gradle build
```

Quando o projeto usa wrapper, o comando mais comum é:

```bash
./gradlew build
```

---

## 5. Carregamento do SDKMAN

Antes de instalar ou verificar ferramentas instaladas pelo SDKMAN, pode ser necessário carregar o SDKMAN no terminal:

```bash
source "$HOME/.sdkman/bin/sdkman-init.sh"
```

Para confirmar que o SDKMAN está funcionando:

```bash
sdk version
```

---

## 6. Instalação do Maven

O Maven foi instalado com o comando:

```bash
sdk install maven
```

Resultado da instalação:

```text
Downloading: maven 3.9.16

In progress...

################################################################################################################# 100.0%

Installing: maven 3.9.16
Done installing!

Setting maven 3.9.16 as default.
```

Isso indica que o Maven foi instalado com sucesso e definido como versão padrão no SDKMAN.

---

## 7. Verificação da instalação do Maven

Após a instalação, a versão do Maven foi verificada com:

```bash
mvn -version
```

Resultado obtido:

```text
Apache Maven 3.9.16 (2bdd9fddda4b155ebf8000e807eb73fd829a51d5)
Maven home: /home/assuero/.sdkman/candidates/maven/current
Java version: 25.0.3, vendor: Amazon.com Inc., runtime: /home/assuero/.sdkman/candidates/java/25.0.3-amzn
Default locale: en, platform encoding: UTF-8
OS name: "linux", version: "6.6.114.1-microsoft-standard-wsl2", arch: "amd64", family: "unix"
```

Esse resultado confirma que:

* o Maven foi instalado corretamente;
* a versão ativa é a `3.9.16`;
* o Maven está usando o Java Amazon Corretto 25.0.3;
* o Maven está instalado dentro do SDKMAN;
* o ambiente utilizado é Linux/WSL 2.

---

## 8. Instalação do Gradle

O Gradle foi instalado com o comando:

```bash
sdk install gradle
```

Resultado da instalação:

```text
Downloading: gradle 9.5.1

In progress...

################################################################################################################# 100.0%

Installing: gradle 9.5.1
Done installing!

Setting gradle 9.5.1 as default.
```

Isso indica que o Gradle foi instalado com sucesso e definido como versão padrão no SDKMAN.

---

## 9. Verificação da instalação do Gradle

Após a instalação, a versão do Gradle foi verificada com:

```bash
gradle -version
```

Resultado obtido:

```text
Welcome to Gradle 9.5.1!

Here are the highlights of this release:
 - Task provenance in reports and failure messages
 - Type-safe accessors for precompiled Kotlin Settings plugins

For more details see https://docs.gradle.org/9.5.1/release-notes.html


------------------------------------------------------------
Gradle 9.5.1
------------------------------------------------------------

Build time:    2026-05-12 13:19:42 UTC
Revision:      fd78213f09782e62ca4957f9cfd3d90c6c3f1767

Kotlin:        2.3.20
Groovy:        4.0.29
Ant:           Apache Ant(TM) version 1.10.15 compiled on August 25 2024
Launcher JVM:  25.0.3 (Amazon.com Inc. 25.0.3+9-LTS)
Daemon JVM:    /home/assuero/.sdkman/candidates/java/25.0.3-amzn (no Daemon JVM specified, using current Java home)
OS:            Linux 6.6.114.1-microsoft-standard-WSL2 amd64
```

Esse resultado confirma que:

* o Gradle foi instalado corretamente;
* a versão ativa é a `9.5.1`;
* o Gradle está usando o Java Amazon Corretto 25.0.3;
* o ambiente utilizado é Linux/WSL 2.

---

## 10. Comandos utilizados nesta etapa

### Entrar na pasta pessoal

```bash
cd ~
```

### Instalar Maven

```bash
sdk install maven
```

### Instalar Gradle

```bash
sdk install gradle
```

### Verificar Maven

```bash
mvn -version
```

### Verificar Gradle

```bash
gradle -version
```

### Carregar SDKMAN

```bash
source "$HOME/.sdkman/bin/sdkman-init.sh"
```

---

## 11. Como usar Maven em projetos Java

Quando o projeto tiver o arquivo:

```text
pom.xml
```

significa que o projeto usa Maven.

Comandos comuns:

```bash
mvn clean
```

Remove arquivos gerados anteriormente.

```bash
mvn compile
```

Compila o projeto.

```bash
mvn test
```

Executa os testes.

```bash
mvn clean install
```

Limpa, compila, testa e instala o pacote no repositório local Maven.

```bash
mvn spring-boot:run
```

Executa uma aplicação Spring Boot baseada em Maven.

Quando o projeto tiver Maven Wrapper, é preferível usar:

```bash
./mvnw spring-boot:run
```

em vez de:

```bash
mvn spring-boot:run
```

---

## 12. Como usar Gradle em projetos Java

Quando o projeto tiver um dos arquivos abaixo:

```text
build.gradle
```

ou:

```text
build.gradle.kts
```

significa que o projeto usa Gradle.

Comandos comuns:

```bash
gradle clean
```

Remove arquivos gerados anteriormente.

```bash
gradle build
```

Compila, testa e gera o build do projeto.

```bash
gradle test
```

Executa os testes.

```bash
gradle tasks
```

Lista as tarefas disponíveis no projeto.

```bash
gradle bootRun
```

Executa uma aplicação Spring Boot baseada em Gradle.

Quando o projeto tiver Gradle Wrapper, é preferível usar:

```bash
./gradlew bootRun
```

em vez de:

```bash
gradle bootRun
```

---

## 13. Regra prática para o bootcamp

Durante o bootcamp, a regra será:

```text
Projeto com pom.xml → usar Maven
Projeto com build.gradle → usar Gradle
Projeto com build.gradle.kts → usar Gradle
Projeto com mvnw → usar ./mvnw
Projeto com gradlew → usar ./gradlew
```

Em projetos Spring Boot criados pelo Spring Initializr, será possível escolher Maven ou Gradle.

Para fins de estudo, a recomendação inicial é:

```text
Usar Maven quando o curso ou desafio não especificar Gradle.
```

Motivo:

* Maven é muito comum em cursos Java;
* Maven aparece com frequência em projetos Spring Boot;
* o arquivo `pom.xml` é bastante utilizado em exemplos didáticos;
* Maven tende a ser mais direto para quem está iniciando no ecossistema Java Back-end.

Mesmo assim, o Gradle também ficará instalado para acompanhar projetos que usarem essa ferramenta.

---

## 14. Status da etapa

Status:

```text
Concluída
```

Ferramentas instaladas:

```text
Apache Maven 3.9.16
Gradle 9.5.1
```

Java utilizado pelas ferramentas:

```text
Amazon Corretto 25.0.3
```

Ambiente:

```text
WSL 2 / Linux
```

Data do registro:

```text
31/05/2026
```

---

## 15. Próximos passos

Após instalar Maven e Gradle, os próximos passos são:

* criar um primeiro projeto Java simples;
* testar compilação e execução com Maven;
* testar compilação e execução com Gradle;
* registrar exemplos dentro da estrutura do bootcamp;
* iniciar os conteúdos de fundamentos da linguagem Java;
* manter os registros no GitHub com commits frequentes.

---

# Fim do registro
