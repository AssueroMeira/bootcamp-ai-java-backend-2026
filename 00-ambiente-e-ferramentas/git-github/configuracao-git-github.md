# Configuração do Git, GitHub e Publicação do Repositório

## 1. Contexto

Este documento registra a configuração do Git e a publicação inicial do repositório do **Bootcamp AI Java Back-end 2026** no GitHub.

O objetivo desta etapa foi:

* configurar o Git no ambiente WSL;
* criar o controle de versão local do projeto;
* conectar o repositório local ao GitHub;
* resolver a autenticação com o GitHub;
* realizar o primeiro `push` para publicar o repositório remoto;
* registrar o fluxo básico de versionamento que será usado durante o bootcamp.

---

## 2. Informações do repositório

Nome do repositório:

```text
bootcamp-ai-java-backend-2026
```

Usuário GitHub:

```text
AssueroMeira
```

E-mail configurado no Git:

```text
assueromeira@gmail.com
```

URL do repositório remoto:

```text
https://github.com/AssueroMeira/bootcamp-ai-java-backend-2026.git
```

Visibilidade do repositório:

```text
Public
```

Objetivo do repositório:

```text
Documentar minha evolução, anotações, exercícios e projetos do Bootcamp AI Java Back-end 2026.
```

---

## 3. Verificação da pasta do projeto

Antes de iniciar a configuração do Git, foi necessário confirmar se o terminal estava na pasta correta do projeto.

Comando utilizado:

```bash
pwd
```

Pasta esperada:

```text
/home/assuero/bootcamp-ai-java-backend-2026
```

Caso o terminal não estivesse na pasta correta, o comando para entrar no repositório seria:

```bash
cd ~/bootcamp-ai-java-backend-2026
```

---

## 4. Estrutura inicial do repositório

A estrutura inicial foi criada conforme os módulos reais do bootcamp:

```text
bootcamp-ai-java-backend-2026/
├── 00-ambiente-e-ferramentas/
├── 01-copilotos-com-ia-no-desenvolvimento-de-solucoes/
├── 02-fundamentos-para-comecar-a-programar-em-java/
├── 03-programando-o-mundo-real-com-orientacao-a-objetos-no-java/
├── 04-boas-praticas-padroes-e-dados-no-java/
├── 05-produtividade-com-spring-boot/
├── 06-projeto-final-assistente-virtual-inteligente-por-voz/
├── certificados/
├── diario-de-bordo/
├── materiais-de-apoio/
├── .gitignore
└── README.md
```

Essa estrutura tem como finalidade organizar:

* anotações;
* exemplos;
* exercícios;
* desafios;
* projetos;
* certificados;
* materiais de apoio;
* diário de bordo da evolução no bootcamp.

---

## 5. Criação do arquivo `.gitignore`

Foi criado um arquivo `.gitignore` para evitar que arquivos desnecessários sejam enviados para o GitHub.

Conteúdo utilizado:

```gitignore
# Java
*.class
*.jar
*.war
*.ear

# Maven
target/
.mvn/wrapper/maven-wrapper.jar

# Gradle
.gradle/
build/

# VS Code
.vscode/

# IntelliJ IDEA
.idea/
*.iml

# Eclipse
.project
.classpath
.settings/

# Sistema operacional
.DS_Store
Thumbs.db

# Logs
*.log

# Temporários
tmp/
temp/
```

Esse arquivo é importante porque evita versionar arquivos gerados automaticamente, como:

* arquivos `.class`;
* pastas `target/`;
* pastas `build/`;
* configurações locais de IDEs;
* arquivos temporários;
* logs.

---

## 6. Criação de arquivos `.gitkeep`

Como o Git não versiona pastas vazias, foi utilizado o comando abaixo para criar arquivos `.gitkeep` nas pastas sem conteúdo:

```bash
find . -type d -empty -exec touch {}/.gitkeep \;
```

Isso permitiu que toda a estrutura de diretórios fosse salva no repositório.

---

## 7. Inicialização do Git

O repositório local foi inicializado com:

```bash
git init
```

Esse comando cria a pasta oculta `.git`, que passa a controlar o histórico de versões do projeto.

Para verificar o estado do repositório, foi usado:

```bash
git status
```

---

## 8. Configuração do usuário Git

O Git foi configurado com o nome e e-mail do autor dos commits.

Comandos utilizados:

```bash
git config --global user.name "Assuero Silva Meira"
git config --global user.email "assueromeira@gmail.com"
```

Para conferir a configuração:

```bash
git config --global --list
```

Resultado esperado:

```text
user.name=Assuero Silva Meira
user.email=assueromeira@gmail.com
```

---

## 9. Primeiro commit local

Após criar os arquivos e pastas iniciais, os arquivos foram adicionados à área de preparação do Git.

Comando utilizado:

```bash
git add .
```

Depois foi realizado o primeiro commit:

```bash
git commit -m "chore: cria estrutura inicial do bootcamp AI Java backend"
```

A mensagem do commit seguiu o padrão:

```text
tipo: descrição objetiva da alteração
```

Neste caso:

* `chore`: usado para configuração, estrutura ou tarefas de manutenção;
* descrição: criação da estrutura inicial do bootcamp.

---

## 10. Criação do repositório no GitHub

No GitHub, foi criado um novo repositório com as seguintes configurações:

```text
Repository name:
bootcamp-ai-java-backend-2026
```

Descrição:

```text
Repositório para documentar minha evolução, anotações, exercícios e projetos do Bootcamp AI Java Back-end 2026.
```

Visibilidade:

```text
Public
```

As opções abaixo não foram marcadas, pois os arquivos já existiam localmente:

```text
Add a README file
Add .gitignore
Choose a license
```

---

## 11. Configuração da branch principal

A branch principal foi renomeada para `main`:

```bash
git branch -M main
```

Esse comando garante que a branch principal local siga o padrão atual mais comum no GitHub.

---

## 12. Conexão com o repositório remoto

O repositório local foi conectado ao repositório remoto no GitHub com:

```bash
git remote add origin https://github.com/AssueroMeira/bootcamp-ai-java-backend-2026.git
```

Para verificar se a conexão foi configurada corretamente:

```bash
git remote -v
```

Resultado esperado:

```text
origin  https://github.com/AssueroMeira/bootcamp-ai-java-backend-2026.git (fetch)
origin  https://github.com/AssueroMeira/bootcamp-ai-java-backend-2026.git (push)
```

---

## 13. Problema encontrado na autenticação

Ao tentar enviar o projeto para o GitHub com:

```bash
git push -u origin main
```

O terminal solicitou:

```text
Username for 'https://github.com':
```

Foi informado:

```text
AssueroMeira
```

Depois o terminal solicitou senha:

```text
Password for 'https://AssueroMeira@github.com':
```

Ao tentar usar a senha comum da conta GitHub, apareceu o erro:

```text
remote: Invalid username or token. Password authentication is not supported for Git operations.
fatal: Authentication failed for 'https://github.com/AssueroMeira/bootcamp-ai-java-backend-2026.git/'
```

Esse erro ocorreu porque o GitHub não aceita mais senha comum da conta para operações Git via HTTPS.

Para fazer `push` por HTTPS, é necessário usar um **Personal Access Token**, também chamado de **PAT**, no lugar da senha.

---

## 14. Criação do token de acesso pessoal no GitHub

Para resolver o problema, foi necessário criar um token no GitHub.

Caminho utilizado no GitHub:

```text
Foto do perfil → Settings → Developer settings → Personal access tokens
```

Foi criado um token para permitir o envio do repositório local para o GitHub.

Configuração sugerida para o token:

```text
Note:
bootcamp-ai-java-backend-2026-wsl

Expiration:
90 days ou 1 year

Scopes:
repo
```

Observação importante:

```text
O token deve ser guardado em local seguro e nunca deve ser compartilhado publicamente.
```

O token foi usado no terminal no campo `Password`, no lugar da senha comum da conta GitHub.

---

## 15. Primeiro push para o GitHub

Após criar o token, o comando de envio foi executado novamente:

```bash
git push -u origin main
```

O terminal solicitou o usuário:

```text
Username for 'https://github.com':
```

Foi informado:

```text
AssueroMeira
```

Depois solicitou a senha:

```text
Password for 'https://AssueroMeira@github.com':
```

Neste campo foi colado o token de acesso pessoal.

O terminal não mostrou os caracteres digitados ou colados. Isso é normal em campos de senha no terminal.

---

## 16. Resultado do push

O envio foi concluído com sucesso.

Resultado obtido no terminal:

```text
Enumerating objects: 15, done.
Counting objects: 100% (15/15), done.
Delta compression using up to 8 threads
Compressing objects: 100% (13/13), done.
Writing objects: 100% (15/15), 7.18 KiB | 2.39 MiB/s, done.
Total 15 (delta 0), reused 0 (delta 0), pack-reused 0 (from 0)
To https://github.com/AssueroMeira/bootcamp-ai-java-backend-2026.git
 * [new branch]      main -> main
branch 'main' set up to track 'origin/main'.
```

Esse resultado indica que:

* os arquivos locais foram enviados para o GitHub;
* a branch `main` foi criada no repositório remoto;
* a branch local `main` passou a acompanhar a branch remota `origin/main`.

---

## 17. Configuração do cache de credenciais

Após o push, foi configurado o cache de credenciais do Git:

```bash
git config --global credential.helper cache
```

Esse comando permite que o Git mantenha a autenticação em cache temporariamente, evitando pedir usuário e token a todo momento.

Observação:

```text
Em computador de trabalho, é mais seguro usar cache temporário do que salvar credenciais permanentemente em arquivo.
```

---

## 18. Verificação no GitHub

Após o push, o repositório apareceu corretamente no GitHub com:

```text
1 Commit
1 Branch
README.md
.gitignore
pastas do bootcamp
```

A estrutura publicada incluiu:

```text
00-ambiente-e-ferramentas
01-copilotos-com-ia-no-desenvolvimento-de-solucoes
02-fundamentos-para-comecar-a-programar-em-java
03-programando-o-mundo-real-com-orientacao-a-objetos-no-java
04-boas-praticas-padroes-e-dados-no-java
05-produtividade-com-spring-boot
06-projeto-final-assistente-virtual-inteligente-por-voz
certificados
diario-de-bordo
materiais-de-apoio
.gitignore
README.md
```

Isso confirmou que o repositório local foi publicado corretamente.

---

## 19. Comandos principais desta etapa

### Verificar pasta atual

```bash
pwd
```

### Entrar no repositório

```bash
cd ~/bootcamp-ai-java-backend-2026
```

### Configurar nome no Git

```bash
git config --global user.name "Assuero Silva Meira"
```

### Configurar e-mail no Git

```bash
git config --global user.email "assueromeira@gmail.com"
```

### Conferir configuração

```bash
git config --global --list
```

### Inicializar Git

```bash
git init
```

### Verificar status

```bash
git status
```

### Adicionar arquivos

```bash
git add .
```

### Fazer commit

```bash
git commit -m "chore: cria estrutura inicial do bootcamp AI Java backend"
```

### Renomear branch principal

```bash
git branch -M main
```

### Adicionar repositório remoto

```bash
git remote add origin https://github.com/AssueroMeira/bootcamp-ai-java-backend-2026.git
```

### Conferir remoto

```bash
git remote -v
```

### Enviar para o GitHub

```bash
git push -u origin main
```

### Configurar cache de credenciais

```bash
git config --global credential.helper cache
```

---

## 20. Fluxo básico para os próximos estudos

A partir de agora, sempre que houver alterações no projeto, o fluxo básico será:

```bash
git status
git add .
git commit -m "mensagem do commit"
git push
```

Exemplo para adicionar anotações:

```bash
git status
git add .
git commit -m "docs: adiciona anotacoes sobre configuracao do ambiente"
git push
```

Exemplo para adicionar exercício Java:

```bash
git status
git add .
git commit -m "feat: adiciona primeiro exemplo em Java"
git push
```

Exemplo para corrigir algum arquivo:

```bash
git status
git add .
git commit -m "fix: corrige anotacao sobre instalacao do SDKMAN"
git push
```

---

## 21. Padrão de mensagens de commit

Durante o bootcamp, posso usar um padrão simples baseado em Conventional Commits:

```text
docs: alterações em documentação e anotações
feat: novo exemplo, exercício, desafio ou funcionalidade
fix: correção de erro
chore: configuração, organização ou manutenção
refactor: melhoria de código sem mudar comportamento
test: criação ou ajuste de testes
```

Exemplos:

```bash
git commit -m "docs: adiciona diario de bordo da semana 01"
```

```bash
git commit -m "feat: adiciona exemplo hello world em Java"
```

```bash
git commit -m "chore: organiza pastas do modulo de fundamentos Java"
```

---

## 22. Cuidados importantes

### Não versionar arquivos sensíveis

Nunca enviar para o GitHub:

```text
senhas
tokens
chaves privadas
arquivos .env com credenciais
dados pessoais sensíveis
```

### Não colar token em arquivos do projeto

O token criado para autenticação no GitHub não deve ser salvo em nenhum arquivo do repositório.

### Conferir sempre o status antes do commit

Antes de fazer commit, usar:

```bash
git status
```

Esse comando ajuda a conferir quais arquivos serão enviados.

### Ler o que será enviado

Quando houver dúvida, usar:

```bash
git diff
```

Esse comando mostra as alterações feitas antes de adicionar ao commit.

---

## 23. Status da etapa

Status:

```text
Concluída
```

Resultado:

```text
Repositório local criado, versionado e publicado no GitHub com sucesso.
```

Data do registro:

```text
31/05/2026
```

---

## 24. Próximas etapas

As próximas etapas do bootcamp são:

* registrar a configuração do VS Code com WSL;
* criar o primeiro exemplo Java dentro da estrutura do bootcamp;
* criar ou atualizar o diário de bordo da semana 01;
* iniciar o módulo de fundamentos Java;
* salvar anotações e exercícios com commits frequentes;
* manter o GitHub atualizado com a evolução do bootcamp.

---

# Fim do registro
