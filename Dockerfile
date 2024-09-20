FROM eclipse-temurin:11-alpine
COPY backend/target/*.jar application.jar
ENTRYPOINT ["java","-jar","/application.jar"]