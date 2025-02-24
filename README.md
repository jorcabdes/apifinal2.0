Para crear el servicio primero tenemos que crear el archivo .jar. 

Para ello en la parte derecha nos sale el icono de gradle y tenemos que presionar ahí para que se despliegue una pestaña donde seleccionamos la carpeta build y luego doble clic en bootjar. 

Una vez termina de ejecutarse podemos ver el archivo .jar en la carperta build/libs, que en esta misma carpeta vamos a mover el archivo application.properties. 

![Logo](imagenes/apifinal1.png)

Ahora vamos a nuestra máquina vamos a crear el archivo de configuración del servicio y lo vamos a configurar. 

sudo nano /etc/systemd/system/spring-server.service 

![Logo](imagenes/apifinal2.png)

Ahora ya podemos acceder al servicio desde los comandos. 

![Logo](imagenes/apifinal3.png)

Por último, yo tuve que poner un par de líneas extra en el application.properties para poder hacer las llamadas al api. 

![Logo](imagenes/apifinal4.png)
