# TALLER 1: APLICACIONES DISTRIBUIDAS (HTTP, SOCKETS, HTML, JS,MAVEN, GIT)

En este taller se implementó un servidor que funciona como gateway para encapsular llamadas a servicios web externos. La aplicación que entrega el servidor a los clientes web permite consultar información de películas de cine, esta información es obtenida de OMDb API.

## Diseño de la aplicación

Se construye la aplicación de tal forma que cumpla con los requisitos especificados en el enunciado del taller.

- La clase `HttpServer` contiene la lógica del servidor. Recibe las solicitudes de los usuarios y hace el llamado a la API.
- El servidor entrega a los usuarios un cliente asíncrono al cual pueden acceder desde cualquier navegador.
- Al realizar una consulta desde la aplicación, el servidor hace el llamado a una API externa.
- La respuesta que es dada por la API es validada para devolver al usuario la información correcta. En caso de que la película no se encuentra en la API, se mostrará al usuario un mensaje adecuado.
- La clase `APIController` realiza la conexión a OMDb API en el método `connectToMoviesAPI`, al cual se le pasa como argumento el título de la película. Si la película es encontrada, se retorna un String con los datos, de lo contrario, se establecen mecanismos para validar si la película no fue encontrada y mostrar al usuario el estado de la consulta.
- `APIController` almacena en una estructura de datos concurrente `ConcurrentHashMap` un caché de las consultas hechas a la API, lo que acorta considerablemente los tiempos de respuesta.
- La clase `HTMLBuilder` ofrece métodos para construir las respuestas HTML que son enviadas a los usuarios.

## Extensión de la aplicación.

-  La clase `APIController` implementa la interface `MovieAPI`,  lo que permitirá cambiar fácilmente la API de películas o agregar nuevas funcionalidades.
-  De igual forma, el atributo `GET_URL` de la clase `APIController` permite cambiar de proveedor de forma sencilla, solo debe ajustar la URL de forma que permita acceder a los recursos.
-  El caché puede ser implementado mediante servicios Cloud como Redis en Azure.


## Guía de Inicio

Las siguientes instrucciones le permitirán descargar una copia y ejecutar la aplicación en su máquina local.

### Prerrequisitos

- Java versión 8 OpenJDK
- Maven
- Git

## Instalación 

1. Ubíquese sobre el directorio donde desea realizar la descarga y ejecute el siguiente comando:
   
     ``` git clone https://github.com/AndresOnate/AREP-TALLER1.git ```

2. Navegue al directorio del proyecto:
   
      ``` cd  AREP-TALLER1 ```

3. Ejecute el siguiente comando para compilar el código:

      ``` mvn compile ```

5.  Ejecute el siguiente comando para empaquetar el proyecto:
   
      ``` mvn package ``` 

6. Para iniciar el servidor, ejecute el siguiente comando:

    ``` java -cp target/LAB1_AREP-1.0-SNAPSHOT.jar edu.escuelaing.arep.app.HttpServer ```

7. Verifique en la linea de comanos que se imprimió el mensaje **Listo para recibir ...**

![image](https://github.com/AndresOnate/AREP-TALLER1/assets/63562181/ed3ca723-c5db-4c29-98ec-4fb5dea3287b)

8. De igual forma, puede abrir el proyecto con un IDE y ejecutar el método main de la clase HTTPServer. En la imagen siguiente se muestra el proyecto con el IDE IntelliJ:

![image](https://github.com/AndresOnate/AREP-TALLER1/assets/63562181/b0cc4c7c-d574-4c2a-bc4d-b059e1fe939c)

## Probando la Aplicación.  

Una vez muestra en la línea de comandos el mensaje **Listo para recibir ...**, se puede ingresar a la aplicación en cualquier navegador con la siguiente URL:

       http://localhost:35000/

Debería ver en pantalla lo siguiente:

![image](https://github.com/AndresOnate/AREP-TALLER1/assets/63562181/e714baba-5970-4b20-841c-441e59a1a87f)

Como puede observar, la aplicación tiene un espacio donde puede ingresar el título de la película. Una vez ingrese el título, presione el botón `Search`, 
La información de la película es mostrada en una tabla.

![image](https://github.com/AndresOnate/AREP-TALLER1/assets/63562181/2f65c2e5-b14b-4449-98af-4bde4b6f6662)

El servidor puede tardar unos segundos mientras obtiene la información del API.  Si desea consultar otra película, ingrese el título y vuelva a dar en el botón. 

Si  la API retorna el error `"{"Response":"False","Error":"Movie not found!"}"`, la aplicación informará a los usuarios:

![image](https://github.com/AndresOnate/AREP-TALLER1/assets/63562181/af768ff7-53ec-437f-a880-300ed1cee002)

## Ejecutando las Pruebas.  

A continuación se muestra cómo ejecutar las pruebas desde la línea de comandos y un IDE como IntelliJ.

1. Navegue al directorio del proyecto con la línea de comandos.
2. Ejecute el siguiente comando:
   
   ``` mvn test ```
3. Debe mostrarse en pantalla que las pruebas fueron exitosas.

   ![image](https://github.com/AndresOnate/AREP-TALLER1/assets/63562181/dfa43a9e-6c48-474a-95f2-89a070904051)

4. Puede ejecutar las pruebas desde un IDE como IntelliJ:

   ![image](https://github.com/AndresOnate/AREP-TALLER1/assets/63562181/68fbe63e-15e1-4564-b37b-947f620f0754)

## Construido Con. 

- Maven - Administrador de dependencias

## Versión

1.0.0

## Autores

- Andrés Camilo Oñate Quimbayo

