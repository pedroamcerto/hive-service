![HIVE Logo](./assets/HIVE.png)
---
# Hive Service
Obs: Este documento te ajudará a corrigir esta tarefa.


1. [O que é a Hive](#sobre)
2. [Explicação do projeto](#projeto)
3. [Como iniciar a aplicação](#aplicacao) 
4. **[Requisitos GS](#requisitos)**

---

## Sobre
<div id="sobre"></div>
A HIVE é uma startup disruptiva que está redefinindo a forma como combatemos a devastação ambiental causada pelas queimadas no Brasil e no mundo. Por meio do uso avançado de drones autônomos integrados a inteligência artificial de última geração, oferecemos uma solução tecnológica robusta, eficiente e escalável para o reflorestamento rápido e inteligente de áreas críticas. Nosso compromisso é ambicioso: garantir a regeneração sustentável das florestas e a preservação dos ecossistemas, assegurando a continuidade da vida e o equilíbrio climático global até 2050.

---

## Projeto
<div id="projeto"></div>
Este projeto é a representação de um dos serviços principais do nosso negócio: O registro de missões e a associação de créditos de carbono ligados a ela. Esse controle é essencial para que quando um drone chegar de uma missão ele já registrar todos os créditos que foram gerados. Esses créditos são a principal fonte de renda da nossa solução, e precisam de auditoria para emissão do certificado de cada crédito.

---

## Como iniciar a aplicação
<div id="aplicacao"></div>
Para iniciar a aplicação, siga os seguintes passos:

### Pré-requisitos

- **Java 17**: A aplicação foi desenvolvida utilizando o Java 17. Certifique-se de que o Java esteja instalado corretamente na sua máquina. Você pode verificar a versão do Java com o comando:

```bash
  java -version
```

Maven: A aplicação usa Maven para gerenciamento de dependências. Verifique se o Maven está instalado executando:

```bash
mvn -version
```
### Passos para rodar a aplicação:

#### 1. Clone o repositório.
Se você ainda não clonou o repositório, faça isso utilizando o Git:

```bash
git clone https://github.com/pedroamcerto/hive-service.git
cd hive-service
```
#### 2. Compilar e Rodar a aplicação com Maven:

Para compilar e rodar a aplicação, basta executar o seguinte comando dentro do diretório do projeto:

```bash
mvn spring-boot:run
```

Isso irá compilar o projeto e iniciar o servidor Spring Boot.

A classe principal:

A classe principal da aplicação é HiveServiceApplication, localizada no pacote com.hive. Ela é a responsável por iniciar o contexto do Spring Boot e a execução da aplicação.


[HiveServiceApplication:](./src/main/java/com/hive/HiveServiceApplication.java)
```java
package com.hive;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HiveServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(HiveServiceApplication.class, args);
    }
}
```

#### 3. Acessando a aplicação:

Após rodar o comando mvn spring-boot:run, a aplicação estará acessível no navegador no endereço padrão:
```
http://localhost:8080
```
Caso queira rodar a aplicação em outra porta, é possível configurar isso no arquivo [application.yml](./src/main/resources/application.yml):
```properties
server:
    port=8081
```

#### 4. Verificando se a aplicação está funcionando:

Para verificar se a aplicação iniciou corretamente, acesse a URL mencionada acima e verifique se o serviço responde conforme esperado. Além disso, você pode verificar no terminal por mensagens de log indicando que o Spring Boot iniciou corretamente.

#### 5. Testando

Para testar abra e importe o arquivo [SWAGGER](hive_swagger) para sua aplicação de chamadas REST. Recomendação: Insomnia.

---

## Requisitos Global Solution
<div id="requisitos"></div>

**1 e 2 no PDF enviado no Teams.**


Crie um projeto Java e implemente todas as classes, conforme o diagrama de classes desenvolvido no tópico anterior.:

- [Projeto](src)


Desenvolva no mínimo três métodos operacionais (diferentes dos getters & setters) que recebam algum parâmetro e retorne algum valor. Adicione Javadoc acima dos métodos para descrever a sua função, seus parâmetros e retorno. Desenvolva pelo menos um método com sobrecarga e outro com sobrescrita.

- [Sobrecarga](./src/main/java/com/hive/utils/mission/MissionUtils.java)
- [Sobrescrita](./src/main/java/com/hive/core/annotations/validators/DateValidator.java)
- [Outro método](./src/main/java/com/hive/core/annotations/validators/DateRangeValidator.java)

**Obs:** A aplicação conta com JavaDoc nas principais classes e métodos, e também possui diversos outros métodos que contem requisitos como os descritos, fique a vontade para explorar o restante do projeto! :)

<br>

Implemente uma classe com o método main para o usuário informar os valores para os objetos criados e depois exiba os valores dos atributos. Pode utilizar o Scanner ou JOptionPane.

Conforme combinado com o professor, desenvolvemos a aplicação utilizando Spring. Para interagir com a aplicação, você pode realizar requisições HTTP. Além disso, disponibilizamos uma collection para facilitar os testes, evitando a necessidade de buscar manualmente os endpoints: [Collection](./hive_swagger).


<br>


---

A **Hive** nasce com um propósito claro: utilizar a tecnologia de drones autônomos para **combater a devastação ambiental** causada pelas queimadas e **promover o reflorestamento** de maneira eficiente e escalável. Acreditamos que, ao unir inovação tecnológica e sustentabilidade, podemos criar um futuro mais verde e equilibrado para o planeta.

Nosso time de fundadores, Pedro Certo (556268), Fabiano Zague (555524) e Lorran dos Santos (558982), está comprometido com a implementação de soluções que gerem impacto real e positivo para as florestas e os ecossistemas ao redor do mundo. Cada passo dado no desenvolvimento desta plataforma é uma contribuição para um mundo mais sustentável e resiliente às mudanças climáticas.

Agradecemos pela sua contribuição e pelo interesse em nossa solução. Estamos entusiasmados com o futuro da Hive e as possibilidades de impactar positivamente a preservação ambiental.



<center>
    <img src="./assets/parceiros.png">
</center>


