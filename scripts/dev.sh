#!/bin/bash

echo "Checking verificació de projecte"

mvn clean verify

echo "Empaquetant aplicació"

mvn clean compile

echo "Llençant aplicació"

java -jar ../smap-backend-web/target/app.jar

#Obrir navegador pel swagger
google-chrome http://localhost:8081/swagger-ui/index.html