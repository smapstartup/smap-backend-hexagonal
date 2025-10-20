#!/bin/bash

echo "Checking verificació de projecte"

mvn clean verify

echo "Empaquetant aplicació"

mvn clean compile

## Exportem el secret perquè no llenci error per NULL
#export SECURITY_JWT_SECRET=smap-super-secret-env-var-1234567890-allargo-una-mica-mes-perque-passi-de-32-caracters
#
#
## Comprovem que SECURITY_JWT_SECRET està definit
#if [ -z "$SECURITY_JWT_SECRET" ]; then
#  echo "[ERROR] La variable d'entorn SECURITY_JWT_SECRET no està definida!"
#  echo "No es pot arrencar l'aplicació sense aquesta clau secreta."
#  echo "Exporta-la abans d'executar aquest script:"
#  echo ""
#  echo "  export SECURITY_JWT_SECRET=la-teva-clau-super-secreta"
#  echo ""
#  echo "O bé afegeix-la a aquest script manualment per entorns controlats."
#  exit 1
#fi

#echo "[INFO] Iniciant aplicació amb secret definit..."

echo "Llençant aplicació"

java -jar ../smap-backend-web/target/app.jar

#Obrir navegador pel swagger
google-chrome http://localhost:8080/swagger-ui/index.html