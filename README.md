# Projeto de Microsserviços


####Projeto desenvolvido a partir do curso de _[Microservices and Distributed Systems](https://www.amigoscode.com/p/microservices)_ do site e canal do youtube Amigos Code.
O projeto consiste em microsserviços que recebem e validam informações de um cliente e envia notificações de forma assíncrona para outro microsserviço.
Imagens do docker são geradas ao executar o comando package do maven, assim todos os microsserviços podem ser excutados por containers do docker, além do projeto contar com profiles para execução local e/ou com kubernetes.

Stack utilizada: Java 17, Spring boot, Spring Cloud, PostgreSQL, Docker, Eureka Server (Não necessário caso utilizar o Kubernetes), RabbitMQ, Zipkin e Kubernetes. 
