# Histórias de Usuário

## 1. Cadastro de Aluno
**Como** um aluno  
**Eu quero** me cadastrar no sistema  
**Para** poder acessar as vantagens e funcionalidades oferecidas pela minha instituição

### Critérios de Aceitação:
- O aluno deve preencher nome, email, CPF, RG, endereço, instituição de ensino e curso no momento do cadastro.
- O sistema deve permitir selecionar a instituição de ensino a partir de uma lista pré-cadastrada.

---

## 2. Autenticação de Aluno, Professor e Empresa
**Como** um usuário (Aluno, Professor ou Empresa Parceira)  
**Eu quero** me autenticar no sistema com meu login e senha  
**Para** acessar as funcionalidades do sistema

### Critérios de Aceitação:
- O sistema deve permitir o login para alunos, professores e empresas parceiras.
- O login deve ser feito através de um nome de usuário (email) e senha.

---

## 3. Resgatar Vantagens
**Como** um aluno  
**Eu quero** resgatar vantagens oferecidas pelas empresas parceiras  
**Para** utilizar os benefícios oferecidos por moedas acumuladas

### Critérios de Aceitação:
- O aluno deve ser capaz de resgatar vantagens cadastradas por empresas.
- O saldo do aluno deve ser atualizado após o resgate.
- Um email com o cupom deve ser enviado para o aluno e para a empresa parceira.

---

## 4. Enviar Moedas para Alunos
**Como** um professor  
**Eu quero** enviar moedas para meus alunos  
**Para** recompensar seu bom comportamento ou participação

### Critérios de Aceitação:
- O professor deve ser capaz de enviar moedas para qualquer aluno que esteja vinculado à sua instituição.
- O saldo de moedas do professor deve ser atualizado após o envio.
- O aluno deve ser notificado via email sobre o recebimento das moedas.
- O professor deve ter saldo suficiente de moedas para realizar o envio.

---

## 5. Consultar Saldo e Transações (Aluno)
**Como** um aluno  
**Eu quero** consultar meu saldo de moedas e o histórico de transações  
**Para** entender quantas moedas eu tenho e o que fiz com elas

### Critérios de Aceitação:
- O aluno deve ser capaz de ver o saldo total de moedas.
- O aluno deve poder visualizar o histórico de transações, incluindo resgates e recebimento de moedas.

---

## 6. Consultar Saldo e Transações (Professor)
**Como** um professor  
**Eu quero** consultar o saldo de moedas e o histórico de transações  
**Para** ver quantas moedas ainda posso distribuir e a quem enviei moedas

### Critérios de Aceitação:
- O professor deve ser capaz de ver o saldo total de moedas.
- O professor deve poder visualizar o histórico de transações, incluindo envios de moedas para alunos.

---

## 7. Cadastrar Empresa Parceira
**Como** uma empresa parceira  
**Eu quero** me cadastrar no sistema  
**Para** poder oferecer vantagens aos alunos

### Critérios de Aceitação:
- A empresa deve preencher nome, email e CNPJ no momento do cadastro.
- O sistema deve permitir que a empresa parceira se autentique após o cadastro.

---

## 8. Cadastrar Vantagens
**Como** uma empresa parceira  
**Eu quero** cadastrar as vantagens que ofereço aos alunos  
**Para** permitir que os alunos resgatem essas vantagens utilizando moedas

### Critérios de Aceitação:
- A empresa parceira deve ser capaz de cadastrar vantagens, incluindo descrição, custo em moedas e foto.
- As vantagens devem estar disponíveis para alunos resgatarem.

---

## 9. Notificação por Email ao Resgatar Vantagens
**Como** um aluno e uma empresa parceira  
**Eu quero** receber uma notificação por email ao resgatar uma vantagem  
**Para** obter o cupom com o código necessário para utilizar a vantagem

### Critérios de Aceitação:
- O sistema deve enviar um email com um cupom para o aluno ao resgatar uma vantagem.
- O sistema também deve enviar uma notificação para a empresa parceira com os detalhes do resgate e o cupom.

---

## 10. Distribuição de Moedas por Semestre (Professor)
**Como** um sistema  
**Eu quero** distribuir 1000 moedas para cada professor no início de cada semestre  
**Para** que eles possam distribuir essas moedas aos alunos

### Critérios de Aceitação:
- O sistema deve automaticamente adicionar 1000 moedas ao saldo de cada professor no início de cada semestre.
- As moedas não distribuídas pelo professor em um semestre devem ser acumuladas para o próximo semestre.

---

## 11. Selecionar Instituição de Ensino (Aluno)
**Como** um aluno  
**Eu quero** selecionar minha instituição de ensino ao me cadastrar  
**Para** associar meu perfil à minha instituição

### Critérios de Aceitação:
- O aluno deve ser capaz de selecionar sua instituição de ensino a partir de uma lista pré-cadastrada.
