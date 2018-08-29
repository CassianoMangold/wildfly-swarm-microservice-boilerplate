FROM openjdk:8
MAINTAINER cassiano@treasy.com.br

WORKDIR /swarm-microservice-boilerplate

EXPOSE 8080

CMD java -jar /swarm-microservice-boilerplate/swarm-microservice-boilerplate-thorntail.jar -Dswarm.datasources.data-sources.mangoldDS.user-name=$SWARM_DS_USERNAME -Dswarm.datasources.data-sources.mangoldDS.password=$SWARM_DS_PASSWORD -Dswarm.datasources.data-sources.mangoldDS.connection-url=$SWARM_DS_CONNECTION_URL -Duser.language=pt -Duser.country=BR -Duser.timezone=America/Sao_Paulo -Djava.net.preferIPv4Stack=true -Djava.net.preferIPv4Addresses=true