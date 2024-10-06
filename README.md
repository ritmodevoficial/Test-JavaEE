#Aplicação JavaEE para Gerenciamento de Academia
 Esta é uma aplicação web simples em JavaEE para um sistema de gerenciamento de academia. A aplicação utiliza Hibernate para persistência, Primefaces 
 como a implementação do JavaServer Faces, e PostgreSQL como banco de dados.

Recursos
Cadastrar alunos
Gerenciar alunos (incluindo cálculo de IMC, definição de planos e mensalidades)
Gerenciar ficha de treinos

Tecnologias Utilizadas
JavaEE
Hibernate
Primefaces
PostgreSQL
Wildfly (Servidor de Aplicação)
Instalação

1. Clone o repositório:
bash
Copiar código
git clone https://github.com/ritmodevoficial/Test-JavaEE.git

3. Navegue até o diretório do projeto:
bash

Copiar código
cd Test-JavaEE

5. Configure o banco de dados:
Crie um banco de dados PostgreSQL chamado academia_db.
Execute o dump SQL fornecido para configurar as tabelas:
bash
Copiar código
psql -U seu_usuario -d academia_db -f dump.sql

6. Configuração no Wildfly:
Adicione um datasource no Wildfly para conectar ao banco academia_db.
Atualize o arquivo persistence.xml com suas credenciais do banco de dados.

8. Compile e rode a aplicação:
Use Maven para compilar o projeto:
bash
Copiar código
mvn clean install
Implemente o .war gerado no servidor Wildfly.

Funcionalidades Principais
Cadastro de Aluno
Possui validação para alunos menores de idade.
Calcula automaticamente o IMC do aluno com base no peso e altura fornecidos.
Classifica o aluno de acordo com o IMC calculado.
Planos Automáticos
Plano Base: R$ 100,00.
Plano Junior: Desconto de 20% para alunos menores de idade com frequência de 3 dias por semana.
Plano Premium: Desconto de 15% para alunos maiores de idade com frequência de 5 dias por semana.
Plano Melhor Idade: Desconto de 25% para alunos acima de 60 anos com frequência de 3 dias por semana.
