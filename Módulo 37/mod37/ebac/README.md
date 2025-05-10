MAVEN

O Maven é uma ferramenta de integração de projetos ou seja um gerenciador de dependências controla as versões de forma geral consegue executar testes, e gerar relatórios de produtividade.

Suas principais tarefas:

Compilação de código.
Teste de Código-Fonte.
Empacotar o código-fonte em um artefato(ZIP, WAR, JAR ou EAR).
Lida com o controle de releases dos artefatos.
Gerar JavaDocs.
Gerenciar o projeto.
Pom.xml
Ao utilizar o Maven, configuramos todas as nossas configurações no arquivo "pom.xml" esse arquivo que fornece todas as configurações necessárias para o projeto.

Pasted image 20250509203202.png

Nesse pom.xml contém algumas tag's irei explicar algumas delas

** Essa tag encapsula toda as informações relacionadas ao nosso projeto Maven.

Representa qual é a versão do pom estamos utilizando.

É o nome base da empresa ou grupo que criou o projeto.
Ex:br.com.acruz

É o nome do projeto em sí. Ex: CadastroDeCliente.

Representa a versão que está sendo utilizada.

informa que após a compilação retornará um tipo de arquivo.

Dependências
Basicamente as dependências são como as bibliotecas, ou seja anteriormente era necessário adicionar as bibliotecas manualmente, baixando os arquivos .jars e adicionando no projeto.
Porém como falamos anteriormente ao utilizar o maven ele consegue gerenciar isso para nós, ou seja não sendo mais necessário fazer o download desses arquivos .jar's
porém faz-se necessário configurar qual será a biblioteca/dependências que vc quer utilizar no seu projeto.

Para adicionar uma dependência no projeto você poderá consultar toda a estrutura da sua biblioteca por exemplo digamos que eu queria adicionar a dependências do Hibernate, basta irmos no nosso arquivo pom.xml, e adicionar a (Dependency) dentro das nossas dependencies especificando o groudIp, artifactId e a version:

Basicamente as dependências são como as bibliotecas, ou seja anteriormente era necessário adicionar as bibliotecas manualmente, baixando os arquivos .jars e adicionando no projeto.

Porém como falamos anteriormente ao utilizar o maven ele consegue gerenciar isso para nós, ou seja não sendo mais necessário fazer o download desses arquivos .jar's
porém faz-se necessário configurar qual será a biblioteca/dependências que vc quer utilizar no seu projeto.

Para adicionar uma dependência no projeto você poderá consultar toda a estrutura da sua biblioteca por exemplo digamos que eu queria adicionar a dependências do Hibernate, basta irmos no nosso arquivo pom.xml, e adicionar a (Dependency) dentro das nossas dependencies especificando o groudIp, artifactId e a version:

<dependencies>
	<dependency>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-test</artifactId>
		<scope>test</scope>
	</dependency>
</dependencies>

Como saber qual groupId, artifactId, version, scope. Voce pode acessar o site do maven repository e buscar pela dependência desejada. mvnrepository.com

Escopo de Dependências.
Escopo vai nos auxiliar com relação a quantidade de dependências trazidas pelo maven.
Temos 6 tipos de escopos, são eles:

Compile, Runtime, Test, Provided, System, e Import.

Compile.
Significa que é um scopo padrão, ou seja vai prover a depedência na hora que eu for compilar essa aplicação.

Provided
Significa que vai está no tempo de compilação, mas quando tiver no deploy ou em um servidor, ele na compilação vai manter sua versão, porém se eu subir para um servidor ou algum local onde já contem, ele vai atualizar para versão mais atual entre as duas máquinas.

Test
Dependências estão disponíveis apenas no momento da execução dos testes.

System
Semelhante ao escopo provided, mas sua unica diferença é que é necessário declarar explicitamente onde a dependência pode ser encontrada no sistema usando a tag systemPath.

<systemPath>${basedir}/lib/some-dependency.jar</systemPath>

Runtime
As depedências estarão disponíveis no tempo de execução mas não no tempo de compilação.

Snapshot e Release
Basicamente esses termos também são encontrados no nosso arquivo pom.xml, normalmente localizado proximo no artifactId do projeto, dentro da tag version.

Snapshot - Basicamente quer dizer que esse projeto ainda está em desenvolvimento ou seja é possível que encontro bug's no decorrer do projeto em sí.

Release - Diferentemente da Snapshot quer dizer que algo já foi lançado, ou seja já foi disponibilizado para o cliente pode aparecer tanto omitindo o nome e deixando apenas um numero de versão, ou pode está explicitamente escrito como release e um número de versão:

<version>0.0.1-SNAPSHOT</version>
<version>1.1</version> | <version>1.1-RELEASE</version>

Perfil ou Profiles
São configurações personalizadas, sendo possível criar perfis específicos para cada ambiente , como por exemplo: Produção, Homologação, Tests.

Exemplo de um profile para pular a execução dos testes:

<profiles>
	<profile>
		<id>Skip-tests</id>
		<properties>
			<maven.test.skip>true</maven.test.skip> {Propriedade para pular os testes}
		</properties>
	<profile>
</profiles>

Como executar esse profile:

Trecho para executar o perfil:
mvn -Pskip-tests clean packege

Gradle
É uma ferramenta open source onde permite configurar arquivos de build por DSL(Domain Specific Language) baseada no groovy.

Para iniciar um projeto em Gradle, é necessário baixar o gradle, e após isso na pasta desejada aplicar o código:

Trecho:
gradle init --type java-application.