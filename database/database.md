# Base de datos

Para crear la imagen con postgres y la DB inicial: 
```
docker build -t condominio_img .
```
Luego, creamos el contenedor:
```
docker run -d --name condominio_ct -p 5432:5432 condominio_img
```
Hacemos correr el contenedor:
```
docker start condominio_ct
```
**Nota:** Para ingresar a la DB:
```
docker exec -it condominio_ct bash
```
entramos a la consola del contenedor, ahora nos conectamos a la base "condominiodb":
```
psql -U user --password --db condominiodb
```
(Pedira una contraseña: 123456 )
* Nota: se sale de esta consola con ctrl+D 2 veces

**Nota** : para ver la tabla usuarios se usará:
```
SELECT * FROM "User";
```
Importante incluir las comillas, en otro caso selecciona todos los usuarios del contenedor postgres.