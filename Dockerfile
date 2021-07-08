FROM maven:3.6-jdk-8 AS pilha

RUN mkdir -p ./home/pilha

WORKDIR ./home/pilha

COPY / .

RUN mvn dependency:tree && mvn clean package

FROM adoptopenjdk/openjdk11:alpine-jre

COPY --from=pilha /home/pilha/target/*.jar Pilha-0.0.1-SNAPSHOT.jar

CMD ["java", "-jar", "Pilha-0.0.1-SNAPSHOT.jar"]

HEALTHCHECK --interval=25s --timeout=3s --retries=2 CMD wget --spider http://localhost:8080/

