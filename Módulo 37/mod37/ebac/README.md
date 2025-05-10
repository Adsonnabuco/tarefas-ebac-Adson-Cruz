
# 📦 Maven e Gradle – Módulo 37

## 🔧 Maven

O **Maven** é uma ferramenta de automação de builds e gestão de dependências em projetos Java.

### ✅ Funções principais:

- ✅ Compilação do código
- ✅ Testes automatizados
- ✅ Empacotamento (ZIP, WAR, JAR, EAR)
- ✅ Controlo de versões
- ✅ Geração de JavaDocs
- ✅ Gestão centralizada do projeto via `pom.xml`

---

## 📄 Estrutura do `pom.xml`

No Maven, todas as configurações ficam no ficheiro `pom.xml`.

### Principais tags:

- `<project>`: encapsula as configurações do Maven
- `<modelVersion>`: versão do modelo POM
- `<groupId>`: grupo ou empresa (ex: `br.com.acruz`)
- `<artifactId>`: nome do projeto (ex: `CadastroDeCliente`)
- `<version>`: versão do projeto
- `<packaging>`: tipo do artefato (ex: `jar`, `war`)

---

## 📚 Dependências

As dependências são bibliotecas necessárias no projeto. Com o Maven, não precisas mais adicionar `.jar` manualmente.

### 🧪 Exemplo:

```xml
<dependencies>
  <dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-test</artifactId>
    <scope>test</scope>
  </dependency>
</dependencies>
```

🔍 Consulta dependências em: [https://mvnrepository.com](https://mvnrepository.com)

---

## 🔍 Escopos de Dependência

```markdown
| Escopo     | Descrição                                                                 |
|------------|---------------------------------------------------------------------------|
| compile    | Usado na compilação e execução (padrão)                                   |
| provided   | Disponível na compilação, mas fornecido pelo ambiente de execução         |
| test       | Apenas disponível para testes                                             |
| system     | Similar ao `provided`, mas exige caminho específico (`systemPath`)        |
| runtime    | Usado apenas em tempo de execução                                         |
| import     | Importa dependências de outros `pom.xml`                                  |
```

### Exemplo de `systemPath`:

```xml
<dependency>
  <groupId>com.exemplo</groupId>
  <artifactId>alguma-coisa</artifactId>
  <version>1.0</version>
  <scope>system</scope>
  <systemPath>${basedir}/lib/some-dependency.jar</systemPath>
</dependency>
```

---

## 🏷️ Snapshot vs Release

- **SNAPSHOT**: versão em desenvolvimento
- **RELEASE**: versão final e estável

```xml
<version>0.0.1-SNAPSHOT</version>
<version>1.1</version>
<version>1.1-RELEASE</version>
```

---

## 🎭 Perfis (Profiles)

Permitem configurar diferentes comportamentos para ambientes distintos (ex: produção, testes).

### Exemplo para ignorar testes:

```xml
<profiles>
  <profile>
    <id>skip-tests</id>
    <properties>
      <maven.test.skip>true</maven.test.skip>
    </properties>
  </profile>
</profiles>
```

### Para executar o perfil:

```bash
mvn -Pskip-tests clean package
```

---

## ⚙️ Gradle

**Gradle** é uma ferramenta de build alternativa ao Maven, usando uma DSL em Groovy.

### Criar um novo projeto:

```bash
gradle init --type java-application
```
