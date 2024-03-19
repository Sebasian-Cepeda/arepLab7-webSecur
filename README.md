
# TALLER7, ARQUITECTURA DE SEGURIDAD
# Descripción 
Se plantea una arquitectura segura usando un ssl, haciendo un login en el cual no se envia la contraseña si no el hash de esta.
## Video probando instancia EC2
Para este video tenga encuenta que se requiere tener dentro de la maquina, mvn, java y git

https://github.com/Sebasian-Cepeda/arepLab7-webSecur/assets/89321404/52dc6801-58eb-40ff-ad87-159343aa5911


## DESARROLLADO CON
* [Java version 17](https://www.oracle.com/co/java/technologies/downloads/) - Lenguaje de programación usado.
* [Maven](https://maven.apache.org/download.cgi) - Gestor de dependencias del proyecto
* [Git](https://git-scm.com/downloads) - Gestion de versiones del proyecto

## Pasos para ejecutar
1. Debemos clonar este repositorio
```bash
git clone https://github.com/Sebasian-Cepeda/arepLab7-webSecur.git
```
2. Hacemos un "cd" al repositorio clonado
```bash
cd arepLab7-webSecur
```
4. Compilamos el proyecto con el siguiente comando
```bash
mvn clean install
```
5. Escribimos el siguiente comando para correr la clase main la cual estara en el puerto 5000 y se encargara de mostrar el login y enviar la petición post.
```bash
java -cp "target/classes;target/dependency/*" com.websecure.Main
```
6. Escribimos el siguiente comando para correr la clase Server la cual estara en el puerto 4567 y se encargara de validara si los datos son correctos o no.
```bash
java -cp "target/classes;target/dependency/*" com.websecure.Server
```
7. Abrir en el brawser de preferencia la siguiente ruta (si es posible en pestaña de incognito para evitar problemas con el ssl, si no usa incognito debe permitir el acceso no seguro pues el brawser no conoce el ssl que usamos)
```bash
https://localhost:5000/
```

![image](https://github.com/Sebasian-Cepeda/arepLab7-webSecur/assets/89321404/9b32d6d5-abd3-4efb-ab27-225a6fef066f)

8.Ahora puede probar usuarios y contraseñas (tener en cuenta que el unico usuario registrado es "admin" y su contraseña es "admin" es decir que cualquier otro intento no funcionara)
   Si se usa los datos correctos se obtiene el siguiente mensaje(eso se puede expandir para obtener un homePage o alguna info que sea del usuario como si fuera un login "normal")
   
   ![image](https://github.com/Sebasian-Cepeda/arepLab7-webSecur/assets/89321404/75ac080e-1f06-4182-81f1-f647b643f05d)

   Si se usa una contraseña incorrecta se tiene el siguiente mensaje
   ![image](https://github.com/Sebasian-Cepeda/arepLab7-webSecur/assets/89321404/c4e4177f-bc5b-456f-bb3c-bb24f31e5d15)

   Si se usa un usuario que no existe se obtiene el siguiente mensaje
   ![image](https://github.com/Sebasian-Cepeda/arepLab7-webSecur/assets/89321404/e6af5ca4-f12f-4743-a518-ad5d198167d9) 

9. podemos observar como se comunica usando el ssl
   
   ![image](https://github.com/Sebasian-Cepeda/arepLab7-webSecur/assets/89321404/8bf3ff2a-c06e-4755-8f67-89c403cbe54f)

10. podemos ver como compara los hash para validar si los datos son correctos o no
    ![image](https://github.com/Sebasian-Cepeda/arepLab7-webSecur/assets/89321404/4a3db812-183d-4bec-90f3-75a5855064c9)


11. podemos ver como se saca el hash
    ![image](https://github.com/Sebasian-Cepeda/arepLab7-webSecur/assets/89321404/dd842e6b-c68a-4bfd-85b1-2551f55184b1)


# Diseño
 Frontend:
  El frontend se compone de un formulario HTML que permite a los usuarios ingresar su nombre de usuario y contraseña.
  El formulario está diseñado para enviar los datos de inicio de sesión al servidor utilizando una solicitud POST.
  Hay un script app.js que maneja la lógica del formulario, incluida la validación y el envío de datos al servidor.
  
 Backend (Java con Spark framework):
  El backend está escrito en Java utilizando el framework Spark.
  La clase Main es la clase principal que configura y ejecuta el servidor.
  Se ha asegurado la comunicación HTTPS utilizando un certificado (ecikeystore.p12) y una contraseña asociada.
  La clase Server maneja las solicitudes HTTP, en particular la solicitud de inicio de sesión (/login).
  Los nombres de usuario y contraseñas se almacenan en un mapa en memoria (users). Aquí, solo hay un usuario de ejemplo "admin" con su contraseña hash (este mapa hace la simulacipon de una base de datos).
  
Seguridad:
  La comunicación entre el cliente y el servidor se asegura mediante HTTPS.
  Las contraseñas se almacenan como hashes SHA-256 para mayor seguridad.
  Se ha implementado una función de hash (hashSha256) en la clase HashAutentication para generar y verificar contraseñas seguras.
  
Funcionamiento del inicio de sesión:
  Cuando un usuario intenta iniciar sesión, los datos del formulario se envían al servidor.
  En el servidor, se verifica si el usuario y la contraseña coinciden con los almacenados en el mapa users.
  Si las credenciales son válidas, se devuelve un mensaje de "acceso permitido"; de lo contrario, se devuelve un mensaje de "contraseña incorrecta" o "usuario no existente".
  
Clase SecureURLReader:
  Esta clase proporciona métodos para leer una URL de manera segura, utilizando un TrustStore personalizado para establecer la confianza en el servidor.
  Se utiliza para realizar una llamada HTTPS al servidor de autenticación desde otra parte de la aplicación.
  En resumen, este sistema presenta un diseño simple pero funcional para proporcionar un servicio de inicio de sesión seguro en una aplicación web, utilizando HTTPS para la comunicación segura y almacenando contraseñas de forma segura mediante hash (se garantiza autenticación, autorización e integridad de usuarios).
## AUTOR
Juan Sebastian Cepeda saray



