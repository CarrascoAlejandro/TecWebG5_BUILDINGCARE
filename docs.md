# Documentación de API Buildingcare
Esta documentación proporciona detalles sobre el API de Buildingcare, que se utiliza para gestionar propiedades.

## Endpoints de Usuario
### Iniciar Sesión (Login)
__Endpoint:__ `/login`

__Método HTTP:__ POST

__Descripción:__

Este endpoint permite a los usuarios iniciar sesión en el sistema proporcionando sus credenciales de inicio de sesión.

__Parámetros:__

`userRequest (Request body)` - Datos de inicio de sesión del usuario, que incluyen el nombre de usuario y la contraseña.
__Respuesta Exitosa (200 OK):__

En caso de una autenticación exitosa, el servidor devolverá la información del usuario:

```
{
  "responseCode": "PROP-0001",
  "data": {
    // Datos del usuario autenticado
  }
}
```
Si el inicio de sesión falla debido a credenciales incorrectas o cualquier otro error, la respuesta será vacía:

```
{
  "responseCode": "PROP-0001",
  "data": null
}
```
En el caso de un error no controlado durante el inicio de sesión, la respuesta también será vacía.

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
}
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
### Obtener Propiedades por Usuario
__Endpoint:__ `/owner/{id}`

__Método HTTP:__ GET

__Descripción:__

Este endpoint permite obtener una lista de todas las propiedades que pertenecen a un usuario específico.

__Parámetros:__

`{id} (Path variable)` - ID del usuario cuyas propiedades se desean obtener.
_Respuesta Exitosa (200 OK):_

```
{
  "responseCode": "PROP-0000",
  "data": {
    // Lista de propiedades
  }
}
```
### Filtrar Propiedades según tipo y sección
__Endpoint:__ `/`

__Método HTTP:__ GET

__Descripción:__

Este endpoint permite obtener una lista de propiedades que coinciden con los criterios de búsqueda especificados.

__Parámetros:__

`type (Query parameter)` - Tipo de propiedad que se desea buscar.
`section (Query parameter)` - Sección de la propiedad que se desea buscar.
_Respuesta Exitosa (200 OK):_

```
{
  "responseCode": "PROP-0000",
  "data": {
    // Lista de propiedades
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
_Respuesta Exitosa (200 OK):_

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
_Respuesta Exitosa (200 OK):_

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
_Respuesta Exitosa (200 OK):_

```
{
  "responseCode": "PROP-0003",
  "data": null
}
```
Recuerda incluir el token de autenticación en las solicitudes que lo requieran.

## Endpoints de sección
### Listar Todas las Secciones
__Endpoint:__ `/all`

__Método HTTP:__ GET

__Descripción:__ Este endpoint permite obtener una lista de todas las secciones disponibles en el sistema.

__Parámetros:__ Ninguno.

_Respuesta Exitosa (200 OK):_

```
{
  "responseCode": "PROP-0000",
  "data": {
    // Lista de secciones
  }
}
```

## Endpoints de Publicación
### Listar Todas las Publicaciones
__Endpoint:__ `/all`

__Método HTTP:__ GET

__Descripción:__ Este endpoint permite obtener una lista de todas las publicaciones disponibles en el sistema.

__Parámetros:__ Ninguno.

_Respuesta Exitosa (200 OK):_

```
{
  "responseCode": "PROP-0000",
  "data": {
    // Lista de publicaciones
  }
}
```
### Obtener Publicación por ID
__Endpoint:__ `/{id}`

__Método HTTP:__ GET

__Descripción:__ Este endpoint permite obtener información detallada de una publicación específica mediante su ID.

__Parámetros:__ `{id} (Path variable)` - ID de la publicación que se desea obtener.

_Respuesta Exitosa (200 OK):_

```
{
  "responseCode": "PROP-0000",
  "data": {
    // Detalles de la publicación
  }
}
```
### Obtener todas las publicaciones urgentes
__Endpoint:__ `/urgent`

__Método HTTP:__ GET

__Descripción:__ 
Este endpoint permite obtener una lista de todas las publicaciones urgentes disponibles en el sistema.

__Parámetros:__ Ninguno.

_Respuesta Exitosa (200 OK):_

```
{
  "responseCode": "PROP-0000",
  "data": {
    // Lista de publicaciones
  }
}
```
### Obtener todas las publicaciones resueltas
__Endpoint:__ `/done`

__Método HTTP:__ GET

__Descripción:__
Este endpoint permite obtener una lista de todas las publicaciones resueltas disponibles en el sistema.

__Parámetros:__ Ninguno.

_Respuesta Exitosa (200 OK):_

```
{
  "responseCode": "PROP-0000",
  "data": {
    // Lista de publicaciones
  }
}
```
### Obtener todas las publicaciones hijas de una publicación especificada
__!OJO!__ Este endpoint no está implementado aún en el backend.
__Endpoint:__ `/{id}/children`

__Método HTTP:__ GET

__Descripción:__ Este endpoint permite obtener una lista de todas las publicaciones hijas de una publicación especificada. ***Nota:*** *Las publicaciones hijas son aquellas que se crean como respuesta a una publicación existente.*

__Parámetros:__ `{id} (Path variable)` - ID de la publicación cuyas publicaciones hijas se desean obtener.

_Respuesta Exitosa (200 OK):_

```
{
  "responseCode": "PROP-0000",
  "data": {
    // Lista de publicaciones
  }
}
```
### Crear Publicación
__Endpoint:__ `/`

__Método HTTP:__ POST

__Descripción:__ Este endpoint permite crear una nueva publicación en el sistema.

__Parámetros:__ `postRequest (Request body)` - Datos de la publicación que se va a crear.

Encabezado Requerido: `token (Request header)` - Token de autenticación.

_Respuesta Exitosa (200 OK):_

```
{
  "responseCode": "PROP-0001",
  "data": {
    // Detalles de la publicación creada
  }
}
```
### Actualizar Publicación
__Endpoint:__ `/{id}`

__Método HTTP:__ PUT

__Descripción:__ Este endpoint permite actualizar los detalles de una publicación existente.

__Parámetros:__ `{id} (Path variable)` - ID de la publicación que se va a actualizar.

`postRequest (Request body)` - Datos actualizados de la publicación.

_Respuesta Exitosa (200 OK):_

```
{
  "responseCode": "PROP-0002",
  "data": {
    // Detalles de la publicación actualizada
  }
}
```
### Eliminar Publicación
__Endpoint:__ `/{id}`

__Método HTTP:__ DELETE

__Descripción:__ Este endpoint permite eliminar una publicación del sistema.

__Parámetros:__ `{id} (Path variable)` - ID de la publicación que se va a eliminar.

_Respuesta Exitosa (200 OK):_

```
{
  "responseCode": "PROP-0003",
  "data": null
}
```
### Marcar publicación como completada
__Endpoint:__ `/{id}/done`

__Método HTTP:__ PUT

__Descripción:__ Este endpoint permite marcar una publicación como completada.

__Parámetros:__ `{id} (Path variable)` - ID de la publicación que se va a marcar como completada.

_Respuesta Exitosa (200 OK):_

```
{
  "responseCode": "PROP-0002",
  "data": {
    // Detalles de la publicación actualizada
  }
}
```
### Marcar publicación como urgente
__Endpoint:__ `/{id}/urgent`

__Método HTTP:__ PUT

__Descripción:__ Este endpoint permite marcar una publicación como urgente.

__Parámetros:__ `{id} (Path variable)` - ID de la publicación que se va a marcar como urgente.

_Respuesta Exitosa (200 OK):_

```
{
  "responseCode": "PROP-0002",
  "data": {
    // Detalles de la publicación actualizada
  }
}
```

Recuerda incluir el token de autenticación en las solicitudes que lo requieran.

