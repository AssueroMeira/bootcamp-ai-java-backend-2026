# Instalação do Java com SDKMAN e Amazon Corretto

## 1. Contexto

Este documento registra a configuração inicial do ambiente Java para o **Bootcamp AI Java Back-end 2026**.

O objetivo foi preparar um ambiente de desenvolvimento Java no computador de trabalho, considerando algumas limitações:

- computador Windows;
- uso do WSL como ambiente Linux;
- preferência por não depender de permissões administrativas do Windows;
- instalação do Java por meio do SDKMAN;
- uso do JDK Amazon Corretto;
- integração com o Visual Studio Code.

---

## 2. Ambiente utilizado

- Sistema operacional principal: Windows
- Ambiente de desenvolvimento: WSL
- Distribuição Linux: Ubuntu no WSL
- Editor: Visual Studio Code
- Gerenciador de SDKs: SDKMAN
- JDK instalado: Amazon Corretto
- Usuário no WSL: `assuero`

---

## 3. Problemas encontrados no início

Durante a configuração, alguns problemas apareceram.

### 3.1 Terminal aberto no local errado

Inicialmente, o terminal estava aberto em:

```bash
/mnt/host/c/WINDOWS/System32
```

ou em:

```bash
/mnt/c/WINDOWS/System32
```

Esse local corresponde à pasta `System32` do Windows, acessada pelo WSL.

Esse não é um bom local para criar projetos, instalar arquivos de estudo ou organizar códigos.

O local recomendado para trabalhar no WSL é a pasta pessoal do usuário:

```bash
cd ~
```

No meu caso:

```bash
/home/assuero
```

---

### 3.2 Comando `Ubuntu` executado dentro do Linux

Em determinado momento, ao abrir o terminal WSL, tentei executar:

```bash
Ubuntu
```

O terminal retornou:

```bash
-sh: Ubuntu: not found
```

Isso aconteceu porque o comando `Ubuntu` foi digitado **dentro de um ambiente Linux já aberto**.

O comando para abrir uma distribuição Ubuntu deve ser usado no PowerShell ou no Windows Terminal, não dentro do próprio shell Linux.

Exemplo correto, no PowerShell:

```powershell
wsl -d Ubuntu
```

ou, se a distribuição tiver outro nome:

```powershell
wsl -d Ubuntu-24.04
```

---

### 3.3 Verificação das distribuições WSL instaladas

Para listar as distribuições instaladas no WSL, o comando usado no PowerShell é:

```powershell
wsl -l -v
```

Esse comando mostra algo parecido com:

```text
NAME            STATE           VERSION
Ubuntu          Running         2
```

ou:

```text
Ubuntu-24.04    Running         2
```

A partir disso, é possível abrir a distribuição correta com:

```powershell
wsl -d Ubuntu
```

ou:

```powershell
wsl -d Ubuntu-24.04
```

---

## 4. Problema com senha do `sudo`

Ao tentar atualizar os pacotes do Linux, usei:

```bash
sudo apt update
```

O terminal pediu senha:

```text
[sudo] password for assuero:
```

A senha digitada não foi aceita e apareceu:

```text
sudo: Authentication failed, try again.
sudo: maximum 3 incorrect authentication attempts
```

Importante: a senha do `sudo` no WSL **não necessariamente é a senha do Windows**.

Ela é a senha do usuário Linux criada durante a configuração do WSL.

Também é importante lembrar que, ao digitar a senha no terminal Linux, **nada aparece na tela**:

- não aparecem letras;
- não aparecem bolinhas;
- não aparecem asteriscos.

Isso é normal no terminal Linux.

---

## 5. Redefinição da senha do usuário no WSL

Quando a senha do usuário Linux não é conhecida, uma alternativa é entrar como `root` no WSL a partir do PowerShell.

Primeiro, sair do WSL:

```bash
exit
```

Depois, no PowerShell, verificar o nome da distribuição:

```powershell
wsl -l -v
```

Entrar como `root`, adaptando o nome da distribuição:

```powershell
wsl -d Ubuntu -u root
```

ou:

```powershell
wsl -d Ubuntu-24.04 -u root
```

Dentro do terminal como `root`, redefinir a senha do usuário:

```bash
passwd assuero
```

O terminal pede:

```text
New password:
Retype new password:
```

Depois, garantir que o usuário está no grupo `sudo`:

```bash
usermod -aG sudo assuero
```

Por fim, sair do modo `root`:

```bash
exit
```

Depois disso, é possível entrar novamente no WSL como usuário normal e usar:

```bash
sudo apt update
```

---

## 6. Atualização do sistema e instalação dos pré-requisitos

Com o `sudo` funcionando, entrei na pasta pessoal:

```bash
cd ~
```

Depois atualizei a lista de pacotes:

```bash
sudo apt update
```

Em seguida, instalei os pacotes necessários para o SDKMAN:

```bash
sudo apt install -y curl zip unzip
```

Esses pacotes são importantes porque o SDKMAN precisa de ferramentas básicas para baixar, compactar e descompactar arquivos.

---

## 7. Verificação dos pré-requisitos

Antes ou depois da instalação dos pacotes, é possível verificar se os comandos estão disponíveis usando:

```bash
command -v curl
command -v zip
command -v unzip
```

Quando o comando existe, o terminal retorna o caminho dele.

Exemplo:

```bash
/usr/bin/curl
/usr/bin/zip
/usr/bin/unzip
```

Se nada aparecer, significa que o comando ainda não está instalado.

---

## 8. Instalação do SDKMAN

Com os pré-requisitos instalados, executei o comando de instalação do SDKMAN:

```bash
curl -s "https://get.sdkman.io" | bash
```

Após a instalação, foi necessário carregar o SDKMAN no terminal atual:

```bash
source "$HOME/.sdkman/bin/sdkman-init.sh"
```

Depois, verifiquei a instalação com:

```bash
sdk version
```

Resultado obtido:

```text
SDKMAN!
script: 5.23.0
native: 0.7.34 (linux x86_64)
```

Esse resultado confirmou que o SDKMAN foi instalado corretamente.

---

## 9. Instalação do JDK Amazon Corretto

Com o SDKMAN funcionando, instalei o Java Amazon Corretto.

Comando utilizado:

```bash
sdk install java -amzn
```

O SDKMAN instalou a versão disponível do Amazon Corretto e configurou o Java no ambiente WSL.

---

## 10. Carregando o SDKMAN em novas sessões

Em alguns casos, ao abrir um novo terminal, pode ser necessário carregar o SDKMAN manualmente com:

```bash
source "$HOME/.sdkman/bin/sdkman-init.sh"
```

Depois, conferir:

```bash
sdk version
```

Se o comando `sdk version` funcionar, o SDKMAN está carregado corretamente.

---

## 11. Verificação da instalação do Java

Após instalar o Corretto, verifiquei a versão do Java:

```bash
java -version
```

Resultado obtido:

```text
openjdk version "25.0.3" 2026-04-21 LTS
OpenJDK Runtime Environment Corretto-25.0.3.9.1 (build 25.0.3+9-LTS)
OpenJDK 64-Bit Server VM Corretto-25.0.3.9.1 (build 25.0.3+9-LTS, mixed mode, sharing)
```

Também verifiquei o compilador Java:

```bash
javac -version
```

Resultado obtido:

```text
javac 25.0.3
```

Esses dois comandos confirmam que o ambiente Java está funcionando:

- `java` executa programas Java;
- `javac` compila arquivos `.java`.

---

## 12. Verificação do Java ativo no SDKMAN

Para conferir qual versão do Java está ativa no SDKMAN, posso usar:

```bash
sdk current java
```

Resultado esperado:

```text
Using java version 25.0.3-amzn
```

Caso existam várias versões instaladas, o SDKMAN permite alternar entre elas.

---

## 13. Teste com o primeiro programa Java

Para testar o funcionamento do Java, criei uma pasta de estudo:

```bash
mkdir -p ~/projetos-java/hello-java
cd ~/projetos-java/hello-java
```

Depois criei o arquivo:

```bash
nano Hello.java
```

Conteúdo do arquivo:

```java
public class Hello {
    public static void main(String[] args) {
        System.out.println("Java funcionando com Amazon Corretto no WSL!");
    }
}
```

Para salvar no `nano`:

```text
Ctrl + O
Enter
Ctrl + X
```

Depois compilei o arquivo:

```bash
javac Hello.java
```

Esse comando gerou o arquivo:

```text
Hello.class
```

Depois executei o programa:

```bash
java Hello
```

Resultado esperado:

```text
Java funcionando com Amazon Corretto no WSL!
```

Esse teste confirmou que o Java estava funcionando corretamente no WSL.

---

## 14. Integração com o Visual Studio Code

Após configurar o Java no WSL, abri o projeto no VS Code usando:

```bash
code .
```

O VS Code abriu conectado ao ambiente WSL, identificado na interface como:

```text
WSL: Ubuntu
```

Isso é importante porque, ao trabalhar conectado ao WSL, o VS Code utiliza o Java instalado dentro do Linux, e não o Java do Windows.

---

## 15. Observação sobre onde salvar os projetos

Não é recomendado criar projetos dentro de:

```bash
/mnt/c/WINDOWS/System32
```

Esse diretório pertence ao Windows e não deve ser usado para projetos de desenvolvimento.

O local recomendado para os projetos do bootcamp é dentro da pasta pessoal do WSL, por exemplo:

```bash
/home/assuero
```

ou usando o atalho:

```bash
~
```

Exemplo de pasta do bootcamp:

```bash
~/bootcamp-ai-java-backend-2026
```

---

## 16. Estrutura do repositório do bootcamp

O repositório criado para organizar os estudos foi:

```text
bootcamp-ai-java-backend-2026
```

A ideia é usar esse repositório como portfólio de aprendizagem, reunindo:

- anotações;
- exemplos;
- exercícios;
- desafios;
- projetos;
- diário de bordo;
- certificados;
- materiais de apoio.

A estrutura foi organizada de acordo com os módulos reais do bootcamp.

---

## 17. Comandos principais utilizados

### Entrar na pasta pessoal

```bash
cd ~
```

### Atualizar pacotes no Ubuntu/WSL

```bash
sudo apt update
```

### Instalar dependências básicas

```bash
sudo apt install -y curl zip unzip
```

### Instalar SDKMAN

```bash
curl -s "https://get.sdkman.io" | bash
```

### Carregar SDKMAN

```bash
source "$HOME/.sdkman/bin/sdkman-init.sh"
```

### Verificar SDKMAN

```bash
sdk version
```

### Instalar Amazon Corretto

```bash
sdk install java -amzn
```

### Verificar Java

```bash
java -version
```

### Verificar compilador Java

```bash
javac -version
```

### Verificar Java ativo no SDKMAN

```bash
sdk current java
```

### Abrir projeto no VS Code conectado ao WSL

```bash
code .
```

---

## 18. Resultado final da configuração

Ao final da configuração, o ambiente ficou funcional com:

```text
SDKMAN instalado
Amazon Corretto instalado
Java funcionando
Javac funcionando
VS Code conectado ao WSL
Primeiro programa Java compilado e executado
```

Versões verificadas:

```text
SDKMAN!
script: 5.23.0
native: 0.7.34 (linux x86_64)
```

```text
openjdk version "25.0.3" 2026-04-21 LTS
OpenJDK Runtime Environment Corretto-25.0.3.9.1
OpenJDK 64-Bit Server VM Corretto-25.0.3.9.1
```

```text
javac 25.0.3
```

---

## 19. Aprendizados registrados

Durante essa configuração, aprendi que:

- o WSL permite usar um ambiente Linux dentro do Windows;
- o SDKMAN é uma ferramenta útil para instalar e gerenciar versões do Java;
- o Amazon Corretto é uma distribuição do OpenJDK mantida pela Amazon;
- o JDK inclui o compilador `javac`;
- o comando `java` executa programas Java;
- o comando `javac` compila arquivos Java;
- o VS Code pode ser conectado diretamente ao WSL;
- projetos devem ser salvos preferencialmente dentro da pasta pessoal do Linux, e não dentro de `System32`;
- a senha do `sudo` no WSL pode ser diferente da senha do Windows;
- quando o terminal pede senha no Linux, ele não mostra caracteres enquanto digitamos.

---

## 20. Pendências após esta etapa

Após a instalação do ambiente Java, as próximas etapas são:

- organizar o repositório do bootcamp;
- criar o `README.md` principal;
- criar o `.gitignore`;
- fazer o primeiro commit;
- conectar o repositório local ao GitHub;
- iniciar os estudos do módulo de fundamentos Java;
- salvar exemplos e desafios nas pastas correspondentes.

---

## 21. Status

Status desta etapa:

```text
Concluída
```

Data do registro:

```text
31/05/2026
```

---

# Como salvar e sair deste arquivo no nano

Depois de colar todo este conteúdo no arquivo, salvar com:

```text
Ctrl + O
Enter
```

Depois sair do editor com:

```text
Ctrl + X
```

Fim da anotação.
