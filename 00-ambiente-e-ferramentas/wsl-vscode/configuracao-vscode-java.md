# Configuração do VS Code para Desenvolvimento Java no WSL

## 1. Contexto

Este documento registra a configuração do **Visual Studio Code** para desenvolvimento Java no ambiente do **Bootcamp AI Java Back-end 2026**.

Nesta etapa, o objetivo foi deixar o VS Code pronto para desenvolver projetos Java usando:

* Windows como sistema operacional principal;
* WSL 2 com Ubuntu como ambiente Linux;
* JDK Amazon Corretto instalado via SDKMAN;
* Maven e Gradle instalados via SDKMAN;
* Git e GitHub para versionamento;
* VS Code conectado ao ambiente WSL.

---

## 2. Situação inicial

O VS Code já estava conectado ao WSL, identificado no canto inferior esquerdo como:

```text
WSL: Ubuntu
```

Isso confirmou que o editor estava usando o ambiente Linux do WSL, e não diretamente o ambiente do Windows.

Esse ponto é importante porque as ferramentas Java foram instaladas dentro do WSL:

```text
Java
Javac
Maven
Gradle
SDKMAN
Git
```

---

## 3. Pasta inicialmente aberta

No início, o VS Code estava aberto na pasta:

```text
HELLO-JAVA [WSL: UBUNTU]
```

Essa pasta havia sido usada apenas para testar o primeiro programa Java.

No entanto, para organizar os estudos do bootcamp, a pasta principal correta é:

```text
bootcamp-ai-java-backend-2026
```

Portanto, a orientação foi abrir o repositório principal do bootcamp no VS Code.

---

## 4. Abrindo o repositório correto no VS Code

No terminal do WSL, o comando usado para entrar na pasta do bootcamp foi:

```bash
cd ~/bootcamp-ai-java-backend-2026
```

Depois, para abrir o VS Code diretamente na pasta correta:

```bash
code .
```

O objetivo era deixar o Explorer do VS Code mostrando o repositório principal:

```text
BOOTCAMP-AI-JAVA-BACKEND-2026 [WSL: UBUNTU]
```

Essa será a pasta principal de trabalho durante o bootcamp.

---

## 5. Verificação do ambiente pelo terminal integrado

No terminal integrado do VS Code, os comandos abaixo podem ser usados para verificar se o ambiente está correto:

```bash
pwd
```

Resultado esperado:

```text
/home/assuero/bootcamp-ai-java-backend-2026
```

Depois, verificar as ferramentas principais:

```bash
java -version
javac -version
mvn -version
gradle -version
git status
```

Esses comandos confirmam que:

* o Java está instalado;
* o compilador `javac` está disponível;
* o Maven está instalado;
* o Gradle está instalado;
* o Git está controlando o repositório.

---

## 6. Carregamento do SDKMAN

Caso algum comando como `java`, `mvn` ou `gradle` não seja reconhecido no terminal do VS Code, o SDKMAN pode ser carregado manualmente com:

```bash
source "$HOME/.sdkman/bin/sdkman-init.sh"
```

Depois, testar novamente:

```bash
java -version
mvn -version
gradle -version
```

O SDKMAN normalmente adiciona automaticamente sua configuração ao arquivo `~/.bashrc`.

O trecho esperado no final do `~/.bashrc` é:

```bash
#THIS MUST BE AT THE END OF THE FILE FOR SDKMAN TO WORK!!!
export SDKMAN_DIR="$HOME/.sdkman"
[[ -s "$HOME/.sdkman/bin/sdkman-init.sh" ]] && source "$HOME/.sdkman/bin/sdkman-init.sh"
```

---

## 7. Extensões recomendadas no VS Code

Para desenvolver em Java no VS Code, a principal extensão recomendada é:

```text
Extension Pack for Java
```

Essa extensão reúne recursos importantes para:

* escrever código Java;
* executar programas Java;
* depurar código;
* trabalhar com projetos Java;
* reconhecer projetos Maven;
* organizar dependências;
* executar testes.

Como o bootcamp também utilizará Spring Boot, também foi recomendada a instalação da extensão:

```text
Spring Boot Extension Pack
```

Essa extensão será útil nas etapas futuras com Spring Boot, APIs REST, banco de dados e segurança.

Extensões úteis, mas opcionais:

```text
Markdown All in One
GitLens
GitHub Pull Requests
Prettier - Code formatter
```

---

## 8. Observação importante sobre extensões no WSL

Como o VS Code está conectado ao WSL, as extensões precisam estar disponíveis no ambiente:

```text
WSL: Ubuntu
```

Ao instalar uma extensão, o VS Code pode mostrar opções como:

```text
Install in WSL: Ubuntu
```

ou:

```text
Installed in WSL: Ubuntu
```

Para desenvolvimento Java neste ambiente, é importante que as extensões estejam funcionando no lado WSL.

---

## 9. Configuração básica do VS Code

Foi aberto o arquivo de configurações do VS Code em formato JSON.

Caminho usado no VS Code:

```text
Ctrl + Shift + P
Preferences: Open User Settings (JSON)
```

A ideia era adicionar configurações úteis para estudo e desenvolvimento Java.

Configurações recomendadas:

```json
"files.autoSave": "afterDelay",
"editor.formatOnSave": true,
"editor.tabSize": 4,
"editor.rulers": [
    100
],
"terminal.integrated.defaultProfile.linux": "bash",
"java.configuration.updateBuildConfiguration": "automatic"
```

Essas configurações têm os seguintes objetivos:

* salvar arquivos automaticamente;
* formatar código ao salvar;
* usar indentação de 4 espaços, comum em Java;
* exibir uma régua visual na coluna 100;
* usar `bash` como terminal padrão no Linux/WSL;
* permitir atualização automática da configuração de projetos Java.

---

## 10. Erro encontrado no arquivo `settings.json`

Durante a configuração, ocorreu um erro porque foi colado um novo bloco JSON dentro do bloco principal.

O erro foi causado por uma estrutura parecida com esta:

```json
{
    "configuracao.existente": "valor",
    {
        "files.autoSave": "afterDelay",
        "editor.formatOnSave": true
    }
}
```

Esse formato é inválido.

Em JSON, o arquivo deve ter apenas um objeto principal:

```json
{
    "chave1": "valor1",
    "chave2": "valor2",
    "chave3": "valor3"
}
```

Portanto, as novas configurações devem ser inseridas no mesmo nível das configurações existentes, antes da última chave `}`.

---

## 11. Correção aplicada no `settings.json`

A correção consistiu em remover o segundo bloco `{ }` e manter todas as configurações dentro do objeto principal.

Exemplo correto:

```json
{
    "editor.fontSize": 18,
    "window.zoomLevel": 1,
    "workbench.startupEditor": "none",
    "files.autoSave": "afterDelay",
    "editor.formatOnSave": true,
    "editor.tabSize": 4,
    "editor.rulers": [
        100
    ],
    "terminal.integrated.defaultProfile.linux": "bash",
    "java.configuration.updateBuildConfiguration": "automatic"
}
```

---

## 12. Alertas encontrados sobre o Prettier

Após corrigir a estrutura do JSON, apareceram alertas relacionados ao formatador:

```json
"esbenp.prettier-vscode"
```

O VS Code indicou que esse valor não era aceito porque a extensão **Prettier - Code formatter** não estava instalada ou não estava ativa no ambiente atual.

Os alertas estavam relacionados a trechos como:

```json
"[css]": {
    "editor.defaultFormatter": "esbenp.prettier-vscode"
}
```

```json
"[json]": {
    "editor.defaultFormatter": "esbenp.prettier-vscode"
}
```

```json
"[html]": {
    "editor.defaultFormatter": "esbenp.prettier-vscode"
}
```

---

## 13. Solução recomendada para os alertas

Como o foco atual do bootcamp é Java Back-end, a solução mais simples foi usar os formatadores nativos do VS Code.

Os trechos com Prettier podem ser substituídos por:

```json
"[css]": {
    "editor.defaultFormatter": "vscode.css-language-features"
},
"[json]": {
    "editor.defaultFormatter": "vscode.json-language-features"
},
"[html]": {
    "editor.defaultFormatter": "vscode.html-language-features"
}
```

Com isso, os alertas desaparecem sem a necessidade de instalar o Prettier neste momento.

---

## 14. Configuração consolidada dos formatadores

A configuração dos formatadores pode ficar assim:

```json
"[javascript]": {
    "editor.defaultFormatter": "vscode.typescript-language-features"
},
"[jsonc]": {
    "editor.defaultFormatter": "vscode.json-language-features"
},
"[css]": {
    "editor.defaultFormatter": "vscode.css-language-features"
},
"[javascriptreact]": {
    "editor.defaultFormatter": "vscode.typescript-language-features"
},
"[json]": {
    "editor.defaultFormatter": "vscode.json-language-features"
},
"[html]": {
    "editor.defaultFormatter": "vscode.html-language-features"
},
"[typescript]": {
    "editor.defaultFormatter": "vscode.typescript-language-features"
},
"[typescriptreact]": {
    "editor.defaultFormatter": "vscode.typescript-language-features"
}
```

---

## 15. Alternativa: instalar o Prettier

Outra possibilidade seria instalar a extensão:

```text
Prettier - Code formatter
```

ID da extensão:

```text
esbenp.prettier-vscode
```

Nesse caso, seria possível manter o valor:

```json
"esbenp.prettier-vscode"
```

Porém, para esta etapa do bootcamp Java, essa instalação não é obrigatória.

A recomendação atual foi manter os formatadores nativos do VS Code.

---

## 16. Criação do primeiro exemplo Java no repositório

Para testar o VS Code com Java dentro da estrutura do bootcamp, foi criado o primeiro exemplo no módulo de fundamentos.

Pasta sugerida:

```text
02-fundamentos-para-comecar-a-programar-em-java/01-introducao-ao-java-e-ambiente-de-desenvolvimento/exemplos/hello-world
```

Comando para criar a pasta:

```bash
mkdir -p 02-fundamentos-para-comecar-a-programar-em-java/01-introducao-ao-java-e-ambiente-de-desenvolvimento/exemplos/hello-world
```

Comando para entrar na pasta:

```bash
cd 02-fundamentos-para-comecar-a-programar-em-java/01-introducao-ao-java-e-ambiente-de-desenvolvimento/exemplos/hello-world
```

Arquivo criado:

```text
HelloWorld.java
```

Conteúdo do arquivo:

```java
public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Olá, Java! Ambiente configurado no VS Code com WSL.");
    }
}
```

---

## 17. Compilação e execução do exemplo

Para compilar:

```bash
javac HelloWorld.java
```

Esse comando gera um arquivo:

```text
HelloWorld.class
```

Para executar:

```bash
java HelloWorld
```

Resultado esperado:

```text
Olá, Java! Ambiente configurado no VS Code com WSL.
```

---

## 18. Sobre o arquivo `.class`

Ao compilar um arquivo `.java`, o Java gera um arquivo `.class`.

Exemplo:

```text
HelloWorld.java
HelloWorld.class
```

O arquivo `.java` contém o código-fonte.

O arquivo `.class` contém o bytecode gerado pelo compilador.

No repositório, arquivos `.class` não devem ser versionados. Por isso, o `.gitignore` contém:

```gitignore
*.class
```

---

## 19. Fluxo de trabalho no VS Code

A partir desta etapa, o fluxo recomendado é:

```text
1. Abrir o repositório principal no VS Code com WSL
2. Criar ou editar arquivos
3. Testar o código pelo terminal integrado
4. Criar anotações em Markdown
5. Conferir alterações com git status
6. Fazer commit
7. Enviar para o GitHub com git push
```

Comandos principais:

```bash
cd ~/bootcamp-ai-java-backend-2026
code .
```

Durante o desenvolvimento:

```bash
git status
git add .
git commit -m "mensagem do commit"
git push
```

---

## 20. Status da etapa

Status:

```text
Concluída parcialmente
```

Itens concluídos:

```text
VS Code conectado ao WSL
Repositório principal criado e publicado no GitHub
Java instalado e funcionando
Maven instalado
Gradle instalado
Configuração inicial do settings.json revisada
Problema de JSON inválido identificado e corrigido
Alertas de formatador identificados
Solução com formatadores nativos recomendada
```

Itens pendentes ou em andamento:

```text
Confirmar instalação das extensões Java no WSL
Confirmar instalação do Spring Boot Extension Pack
Testar execução do HelloWorld pelo botão Run do VS Code
Commitar esta documentação no GitHub
```

---

## 21. Comandos úteis desta etapa

### Abrir terminal integrado

```text
Ctrl + `
```

### Abrir configurações JSON do VS Code

```text
Ctrl + Shift + P
Preferences: Open User Settings (JSON)
```

### Recarregar janela do VS Code

```text
Ctrl + Shift + P
Developer: Reload Window
```

### Verificar ambiente

```bash
java -version
javac -version
mvn -version
gradle -version
git status
```

### Abrir repositório no VS Code

```bash
cd ~/bootcamp-ai-java-backend-2026
code .
```

---

## 22. Próximos passos

Os próximos passos são:

* finalizar a instalação das extensões Java no WSL, se ainda não estiverem instaladas;
* testar o botão `Run` no arquivo `HelloWorld.java`;
* registrar os primeiros aprendizados do módulo de Introdução ao Java;
* continuar salvando as anotações e exemplos no GitHub;
* seguir com os conteúdos de fundamentos da sintaxe Java.

---

# Fim do registro
