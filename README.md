# PARCIAL 02 AREP



![](img/arq.png)



# Desarrollo

Luego de realizar las aplicaciones de Calculadora y el balanceador de carga, se debe instanciar dos maquinas EC2 y subir en ambas
los archivos correspondientes:

1. Descargar el par de llaves donde realizaremos la conexión.
2. Subir los archivos con sftp y el comando put:


![](img/putcalculadora.png)

3. Se descomprime el archivo con unzip y se ejecuta con el comando:

![](img/corriendo.png)

4. Al ingresar nos muestra el resultado esperado para coseno de 0:

![](img/aws1.png)


5. Repetimos el mismo proceso para la app anterior. No olvidar configurar reglas de entrada:
![](img/corriendo.png)

![](img/aws2.png)

Prueba con el proxy local:

![](img/local.png)

![](img/cos1.png)

![](img/exp2.png)


Se realiza una tercer instancia para el PROXY en un EC2:

1. Crear y descargar las llaves.
2. Configurar reglas de seguridad.
3. Comprimir el archivo, usar sftp y el comando put para enviar.
4. Installar JVM, ejecutar el servidor Proxy y conectarse:




## Autores

**Zuly Valentina Vargas Ramírez**

## Licencia

Este proyecto esta bajo la licencia GNU(General Public License) los detalles se encuentran en el archivo [LICENSE](LICENSE.txt).
