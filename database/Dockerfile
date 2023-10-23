# Usa la última imagen estable de PostgreSQL desde el repositorio oficial
FROM postgres:latest

# Opcional: Define variables de entorno para configurar PostgreSQL
ENV POSTGRES_USER=user
ENV POSTGRES_PASSWORD=123456
ENV POSTGRES_DB=condominiodb

# Opcional: Expón el puerto en el que PostgreSQL escucha (predeterminado es 5432)
EXPOSE 5432
#Fabi 5433

# Opcional: Establece la zona horaria
# ENV TZ=America/New_York

# Opcional: Define cualquier otra configuración personalizada que necesites

# Ejecuta el contenedor de PostgreSQL
# CMD ["postgres"]

# Si deseas ejecutar otro comando, como una aplicación que se conecta a PostgreSQL, 
# puedes reemplazar la línea anterior con algo como:
# CMD ["mi_aplicacion_que_conecta_con_postgres"]
