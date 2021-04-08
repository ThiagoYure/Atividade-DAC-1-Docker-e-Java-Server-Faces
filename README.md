# Atividade-DAC-1-Docker-e-Java-Server-Faces

## Etapa 1/3

### Teste de objetivos de aprendizagem
		1. Qual a diferença entre image e container?
		2. Qual a diferença entre os comandos COPY, EXPOSE e ADD?
		3. Qual a diferença entre os comandos RUN, CMD e ENTRYPOINT?
		4. Qual a diferença entre as estratégias de shell e exec?
		5. Qual a diferença entre os comandos docker stop <container_id> e docker
		kill <container_id>?

## Etapa 2/3
### Recursos
		1. Com este container deve ser possível compilarmos e executarmos uma classe Java.
		2. Com este container deve ser possível executarmos um arquivo .jar que contém a classe
		Java como sendo a classe principal.
		3. Com estes contêineres deve ser possível fazer uma comunicação entre uma aplicação web
		e um banco de dados.
		4. Com este container deve ser possível termos um diretório compartilhado (entre outros
		containers e o host) com os dados persistentes da image do PostgreSQL.
		5. Com estes contêineres deve ser possível executar a aplicação descrita na seção Atividade
		prática.
	
## Etapa 3/3

### Atividade prática
		Desenvolva uma aplicação que realize as operações de CRUD para a entidade Integrante e
		Banda. A funcionalidade precisa estar disponível com UI (interface para o usuário) com um
		template usável. As demais informações podem ser inseridas via script sql.
		
		class Integrante{
			private int id;
			private String nome;
			private LocalDate dataDeNascimento;
			private CPF cpf = new CPF("");
		}
		class Banda{
			private int id;
			private String localDeOrigem;
			private String nomeFantasia;
			private List<Integrante> integrantes;
		}
### Requisitos
		● RF01 - Implementar os métodos acessores para as classes Integrante e Banda;
		● RF02 - Implementar a classe de acesso aos dados;
		● RF03 - Na pasta banda, criar as páginas edit.xhtml e list.xhtml para o arquivo de
		template template.xhtml;
		● RF04 - Criar um Conversor para a classe Integrante;
		● RF05 - Adicionar um selectOneMenu na página edit.xhtml da pasta banda. Deve ser
		selecionar um Integrante e associar sua instância ao atributo integrantes
		da classe Banda
		● RF06 - Criar as páginas para edição e listagem da entidade Integrante;
		● RF07 - Criar uma página que permita realizar uma busca por CPF;
		● RF08 - Criar uma página que permita realizar uma busca por localDeOrigem;
		● RF09 - Realizar o deploy da aplicação no Docker usando uma das images do Payara.
		● RF10 - Realizar o deploy da aplicação usando o Docker Compose.


