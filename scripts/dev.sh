#!/bin/bash

cd ..

echo "Fem neteja versions anteriors"

mvn clean

echo "Checking verificació de projecte"

mvn clean verify

echo "Empaquetant aplicació"

mvn clean install

echo "Llençant aplicació"

java -jar backend-web/target/app.jar

#Obrir navegador pel swagger
google-chrome http://localhost:8081/swagger-ui/index.html