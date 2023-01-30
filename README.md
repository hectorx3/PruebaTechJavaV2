Instalar las siguientes herramientas:

node js 16+

gradle 7.5

java 11

docker

docker-compose

intellj Idea

BACK-END (Micronaut y postgresql)

Una vez instalado y comprobado que las variables de ambiente como java, 
gradle, etc apunten a la version mencionadas, continuamos con los siguientes pasos

Abrimos la terminal a nivel raiz del proyecto y ejecutamos los siguientes comandos:

./gradlew build

NOTA: En caso de existir carpeta build en el proyecto raiz ejecutar antes este comando:

./gradlew clean (Despues se puede ejecutar el gradlew build)

Al final debe salir un mensage de BUILD SUCCESSFUL

Ejecutando la aplicacion

Iniciar los servicios de base de datos, y web app docker con los siguientes comandos:

docker-compose up -d

NOTA 1: Revisar los servicios despues de 5 segundos con el comando: docker-compose ps

NOTA 2: Revisando la columna de State los 3 deben decir Up,
en caso contrario se mostrara Exit, para ello solo hay que reiniciar el servicio con el siguiente comando:

docker-compose up -d 

Posteriormente, se vuelve a revisar que en la columna State diga UP.

Para detener todos los servicios ejecutamos el siguiente comando:

docker-compose down

Endpoints configurados
GET - http://localhost:8080/escuela/boleta/1

POST - http://localhost:8080/escuela/calificaciones
Content type = application/json
Body =
{
"idMateria": 2,
"idAlumno": 1,
"calificacion": 8
}

PUT - http://localhost:8080/escuela/calificaciones/1
Content type = application/json
Body =
{
"calificacion": 7
}

DELETE - http://localhost:8080/escuela/calificaciones/1

Anexo

Comando para recrear imagen de docker

docker-compose up -d --force-recreate --build mi_contenedor_name

NOTA: Este comando es bueno en caso de modificar el back

FRONT-END (Angular)

Ubicarse dentro de la carpeta PruebaTecnicaAngular, teniendo npm instalado usar el comando:

npm install

Posteriormente usar el comando:

npm run start

Abrir el navegador http://localhost:4200/

Y listo comenzar a usar!