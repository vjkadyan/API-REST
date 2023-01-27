FROM openjdk:8
EXPOSE 8080
ADD deploys/apirest.jar apirest.jar 
ENTRYPOINT ["java","-jar","/apirest.jar"]