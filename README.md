#  Clínica Odontológica API REST

Esta es una aplicacación destinada a permitir administrar la reserva de turnos para una
clínica odontológica.

● Administración de datos de odontólogos: listar, agregar, modificar y eliminar
odontólogos. Registrar apellido, nombre y matrícula de los mismos.

● Administración de datos de los pacientes: listar, agregar, modificar y eliminar
pacientes. De cada uno se almacenan: nombre, apellido, domicilio, DNI y fecha de
alta.

● Registrar turno: se tiene que poder permitir asignar a un paciente un turno con
un odontólogo en una determinada fecha.

Como motor de base de datos se usa H2, versión 2.1.210 que arroja errores en la consola de Intellij, cuando se ejecuta la aplicación por motivos de compatibilidad con la versión de H2, pero no impide el funcionamiento de la aplicación y permite poder consultar la base por consola desde [localhost:8080/h2-console](http://localhost:8080/h2-console)  con los siguientes parámetros:

JDBC URL = jdbc:h2:~/clinica_odontologica

User Name = sa

Password = ( sin password )

La base de datos se va a crear cuando se ejecute la aplicación por primera vez, y para la carga de datos se usa el test de la clase Turno Service, que carga tanto odontólogos, pacientes, con sus respectivos domicilios, y turnos.

● Login: validar el ingreso al sistema mediante un login con usuario y password. Un usuario podrá tener un único rol y los mismos se
ingresarán directamente en la base de datos.
La carga de los usuarios a la base de datos se hace al ejecutar la aplicación desde DataLoader.
Hay dos usuarios configurados para la carga:

### Usuario 1:

Name = User;

User Name = user;

Email = user@gmail.com;

Password = password2;

Roles = USER;

###  Usuario 2:

Name = Admin;

User Name = admin;

Email = admin@gmail.com;

Password = password;

Roles = ADMIN;

####  *Para poder loguearse es necesario ingresar como User Name el emeil registrado y el password

● Vistas: las mismas están en un archivo aparte, FrontEnd_Clinica_odontologica-main.zip, por que decidí hacerlas con React, y aun no sé cómo unir los archivos.
para ejecutarla puede descomprimir el archivo y ejecutar los comandos:

##  Instalar Dependencias

    npm install

##  Levantar el proyecto en el navegador en el puerto localhost:3000

    npm start

##  Las vistas también están en alojadas GitHub Pages.
Pero por motivos que desconozco, GitHub no renderiza el login ni las imágenes de la presentación, pero se puede ver la parte de las consultas a la API de turnos, paciente, y odontólogos. ( Por cuestiones de tiempo no pude terminar con la parte de poder generar un nuevo turno y actualizar un turno existente en las vistas )

[Acceso a Vistas de Clínica Odontológica](https://laura-2950.github.io/FrontEnd_Clinica_odontologica/)

##  Aclaración: 
Por un problema con las vistas es que no existen restricciones de acceso por rol, ya que no pude resolver el manejo de las cookies con la autenticación básica de Spring Security



