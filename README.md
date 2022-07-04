# Ecommerce App

El proyecto contenido en este repositorio se trata de una prueba técnica para un proceso de selección.

Ha sido desarrollado usando Java 11. Para desplegarlo, basta con descargar el directorio con el código fuente y ejecutar
~~~ bash
mvn clean install
~~~

y
~~~ bash
mvn spring-boot:run
~~~

Este servicio solo tiene configurado un endpoint, accesible desde GET http://localhost:8080/ecommerce/product/price con el siguiente body 
~~~ JSON
{
	"productId":  35455,
	"brandId":  1,
	"date":  "2020-06-16T21:00:00+02:00"
}
~~~

~~~bash
curl --location --request GET 'http://localhost:8080/ecommerce/product/price' \
--header 'Content-Type: application/json' \
--data-raw '{
"productId": 35455,
"brandId": 1,
"date": "2020-06-16T21:00:00+02:00"
}'
~~~
