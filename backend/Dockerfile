# Usar una imagen base de Gradle con JDK
FROM gradle:jdk17-focal

# Copiar el código fuente al contenedor
COPY --chown=gradle:gradle . /home/gradle/src

# Establecer el directorio de trabajo
WORKDIR /home/gradle/src

# Construir la aplicación
RUN gradle bootJar --no-daemon 

# Exponer el puerto 8080
EXPOSE 8080

RUN ls /home/gradle/src/build/libs/

# Ejecutar la aplicación
ENTRYPOINT ["java","-jar","/home/gradle/src/build/libs/backend-0.0.1-SNAPSHOT.jar"]
