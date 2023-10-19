# Documentación de API Buildingcare
Esta documentación proporciona detalles sobre el API de Buildingcare, que se utiliza para gestionar propiedades.

## Endpoints de propiedades
### Listar Todas las Propiedades
__Endpoint:__ `/all`

__Método HTTP:__ GET

__Descripción:__

Este endpoint permite obtener una lista de todas las propiedades disponibles en el sistema.

__Parámetros:__

Ninguno.

__Respuesta Exitosa (200 OK):__

```
{
  "responseCode": "PROP-0000",
  "data": {
    // Lista de propiedades
  }
}`
```
### Obtener Propiedad por ID
__Endpoint:__ `/{id}`

__Método HTTP:__ GET

__Descripción:__

Este endpoint permite obtener información detallada de una propiedad específica mediante su ID.

__Parámetros:__

`{id} (Path variable)` - ID de la propiedad que se desea obtener.
_Respuesta Exitosa (200 OK):_

```
{
  "responseCode": "PROP-0000",
  "data": {
    // Detalles de la propiedad
  }
}
```
### Crear Propiedad
__Endpoint:__ `/`

__Método HTTP:__ POST

__Descripción:__

Este endpoint permite crear una nueva propiedad en el sistema.

__Parámetros:__

`propertyRequest (Request body)` - Datos de la propiedad que se va a crear.
Encabezado Requerido:

`token (Request header)` - Token de autenticación.
__Respuesta Exitosa (200 OK):__

```
{
  "responseCode": "PROP-0001",
  "data": {
    // Detalles de la propiedad creada
  }
}
```
### Actualizar Propiedad
__Endpoint:__ `/{id}`

__Método HTTP:__ PUT

__Descripción:__

Este endpoint permite actualizar los detalles de una propiedad existente.

__Parámetros:__

`{id} (Path variable)` - ID de la propiedad que se va a actualizar.
`propertyRequest (Request body)` - Datos actualizados de la propiedad.
Encabezado Requerido:

`token (Request header)` - Token de autenticación.
__Respuesta Exitosa (200 OK):__

```
{
  "responseCode": "PROP-0002",
  "data": {
    // Detalles de la propiedad actualizada
  }
}
```
### Eliminar Propiedad
__Endpoint:__ `/{id}`

__Método HTTP:__ DELETE

__Descripción:__

Este endpoint permite eliminar una propiedad del sistema.

__Parámetros:__

`{id} (Path variable)` - ID de la propiedad que se va a eliminar.
__Respuesta Exitosa (200 OK):__

```
{
  "responseCode": "PROP-0003",
  "data": null
}
```
Recuerda incluir el token de autenticación en las solicitudes que lo requieran.