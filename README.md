# TALLER DISEÑO Y ESTRUCTURACIÓN DE APLICACIONES DISTRIBUIDAS EN INTERNET

En este taller se exploró la arquitectura de las aplicaciones distribuidas, específicamente la de un servidor web y el protocolo HTTP.   El servidor entrega a los clientes web una aplicación que  permite consultar información de películas. Esta información es obtenida de OMDb API. Todos los archivos para la construcción de la aplicación son leídos por el servidor del disco local y retornados en un formato adecuado.

## Diseño de la aplicación

La aplicación está diseñada para cumplir con los requisitos especificados en el enunciado del taller y proporcionar una experiencia de usuario fluida y satisfactoria. A continuación, se describen los principales componentes y características de la aplicación:

- La clase `HttpServer` es responsable de manejar las solicitudes entrantes de los usuarios y coordinar las interacciones entre el cliente y la API externa. Además de esta funcionalidad, también incluye métodos para la lectura de archivos, lo que permite servir contenido estático como archivos `HTML`, `CSS`, `JavaScript` e imágenes en los formatos `PNG` y `JPG`.
- El servidor proporciona a los usuarios un cliente asíncrono al que pueden acceder desde cualquier navegador
- La clase `APIController` realiza la conexión a OMDb API en el método `connectToMoviesAPI`, al cual se le pasa como argumento el título de la película. Si la película es encontrada, se retorna un String con los datos, de lo contrario, se establecen mecanismos para validar si la película no fue encontrada y mostrar al usuario el estado de la consulta.
- La clase `APIController` utiliza una estructura de datos concurrente `ConcurrentHashMap` para almacenar en caché las consultas realizadas a la API. Esto mejora significativamente los tiempos de respuesta al evitar consultas repetidas para las mismas películas.
- La clase `HTMLBuilder` ofrece métodos para construir las respuestas HTML que son enviadas a los usuarios.
- Se agrega el directorio `resources` donde se almacenan los archivos que serán leídos por el servidor.


## Extensión de la aplicación.

-   Ampliar la lógica para incluir soporte para más extensiones de imágenes. Actualmente, la clase maneja extensiones como `PNG` y `JPG`. Se podría extender para agregar soporte para extensiones adicionales como `JPEG`, `GIF`, `WebP`, entre otras.
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
   
     ``` git clone https://github.com/AndresOnate/AREP-TALLER2.git ```

2. Navegue al directorio del proyecto:
   
      ``` cd  AREP-TALLER2 ```

3. Ejecute el siguiente comando para compilar el código:

      ``` mvn compile ```

5.  Ejecute el siguiente comando para empaquetar el proyecto:
   
      ``` mvn package ``` 

6. Para iniciar el servidor, ejecute el siguiente comando:

    ``` java -cp target/LAB2_AREP-1.0-SNAPSHOT.jar edu.escuelaing.arep.app.HttpServer ```

7. Verifique en la linea de comanos que se imprimió el mensaje **Listo para recibir ...**
   
![image](https://github.com/AndresOnate/AREP-TALLER2/assets/63562181/9481e3f9-ce23-4280-912d-65c9fe3bcb8f)


9. De igual forma, puede abrir el proyecto con un IDE y ejecutar el método main de la clase HTTPServer. En la imagen siguiente se muestra el proyecto con el IDE IntelliJ:

![image](https://github.com/AndresOnate/AREP-TALLER2/assets/63562181/28b63961-3560-415c-8081-9a6c04f2a8eb)


## Probando la Aplicación.  

Una vez muestra en la línea de comandos el mensaje **Listo para recibir ...**, se puede ingresar a la aplicación en cualquier navegador con la siguiente URL:

       http://localhost:35000/index.html

Debería ver en pantalla lo siguiente:

![image](https://github.com/AndresOnate/AREP-TALLER2/assets/63562181/4eeed7ea-295a-438f-9a53-f0a2d9951462)


Como puede observar, la aplicación tiene un espacio donde puede ingresar el título de la película. Una vez ingrese el título, presione el botón `Search`, 
La información de la película es mostrada en una tabla.

![image](https://github.com/AndresOnate/AREP-TALLER2/assets/63562181/0e1ae431-d25d-4e03-8937-f0dceb70dee4)


El servidor puede tardar unos segundos mientras obtiene la información del API.  Si desea consultar otra película, ingrese el título y vuelva a dar en el botón. 

Si  la API retorna el error `"{"Response":"False","Error":"Movie not found!"}"`, la aplicación informará a los usuarios:

![image](https://github.com/AndresOnate/AREP-TALLER2/assets/63562181/2c9a2b8c-01e5-4c1f-9c37-dccfccdd107c)

Comprobamos que los recursos estén cargados de forma correcta:

![image](https://github.com/AndresOnate/AREP-TALLER2/assets/63562181/3ee741b9-f24f-401d-abac-3e99b144a06d)


## Ejecutando las Pruebas.  

A continuación se muestra cómo ejecutar las pruebas desde la línea de comandos y un IDE como IntelliJ.

1. Navegue al directorio del proyecto con la línea de comandos.
2. Ejecute el siguiente comando:
   
   ``` mvn test ```
3. Debe mostrarse en pantalla que las pruebas fueron exitosas.

   ![image](https://github.com/AndresOnate/AREP-TALLER2/assets/63562181/a14eef59-15ba-4f74-a8ea-c0749929d6d0)


4. Puede ejecutar las pruebas desde un IDE como IntelliJ:

   ![image](https://github.com/AndresOnate/AREP-TALLER2/assets/63562181/ea3026d1-8d5f-47cf-a576-8fd0cb495d58)


## Construido Con. 

- Maven - Administrador de dependencias

## Versión

1.0.0

## Autores

- Andrés Camilo Oñate Quimbayo

