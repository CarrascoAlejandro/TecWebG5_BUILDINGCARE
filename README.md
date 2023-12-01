# TecWebG5_BUILDINGCARE

## Proyecto final de Tecnologías Web - Grupo 5 - Sitio Web para Condominio

_Autores:_
- Carrasco Céspedes Miguel Alejandro
- Martínez Acarapi Fabiola Alejandra
- Montero Garrido Diana Aneliz
- Tapia Lazarte Juan Ignacio
- Zizold Sempertegui Gabriela Zulema Britta

### Descripción General del Proyecto:

#### Propósito:
El proyecto busca diseñar e implementar un sistema web para la gestión administrativa de los condominios. Este sistema está diseñado para ser una herramienta integral que aborde los desafíos y necesidades de la administración de condominios. Al centralizar y automatizar estos procesos, se espera mejorar la eficiencia, transparencia, control y satisfacción tanto para los administradores como para los residentes de los condominios.

#### Funcionalidad:

1. **Login y Seguridad:**
   - Provee un sistema de login seguro para los usuarios.
   - Ofrece distintos niveles de acceso basados en roles de usuario.
   - Permite la creación de cuentas para residentes y vendedores.

2. **Gestión de Propiedades:**
   - Mostrar un tablero de anuncios para gestionar propiedades en venta o alquiler.
   - Registro detallado de propiedades incluyendo información del propietario, inquilino y cuotas.
   - Vista especializada para propiedades rentadas y detalles del inquilino.

3. **Contabilidad y Finanzas:**
   - Registro y seguimiento de gastos comunes, pagos de alquiler y cuotas de mantenimiento.
   - Generación de estados financieros para mantener una contabilidad transparente y accesible.

4. **Reservas y Alquileres:**
   - Permite a los usuarios reservar espacios disponibles en el condominio.

5. **Reserva de Servicios:**
   - Facilita la reserva de servicios ofrecidos por la administración del condominio.

6. **Gestión de Documentos:**
   - Herramienta para gestionar documentos vitales como reglamentos, contratos y actas.

7. **Gestión de Mantenimiento:**
   - Programación y seguimiento de mantenimientos preventivos y correctivos.
   - Permite a los usuarios reportar áreas que requieren mantenimiento.

8. **Encuestas y Votaciones:**
   - Facilita la creación y participación en encuestas y votaciones para decisiones conjuntas.

9. **Privacidad y Seguridad:**
   - Registro detallado de ingresos y salidas para garantizar la seguridad de la propiedad.
   - Herramientas administrativas para gestionar propiedades, usuarios y comunicación.
   - Registro de actividad para rastrear acciones de los usuarios y asegurar la integridad del sistema.

10. **Soporte y Capacitación:**
   - Provee un manual de usuario para facilitar el entendimiento y uso óptimo del sistema.
     

### Objetivos

- Simplificar la actualización del catálogo de condominios.
- Facilitar procesos de pagos seguros.
- Proveer información actualizada vía blog.
- Simplificar solicitudes de mantenimiento.
- Facilidad al momento de la moderación.

### Consideraciones

A continuación se explica detalladamente las consideraciones necesarias para la comprensión de las funcionalidades del sistema:

1. **Restricción de Registro de Usuarios:** El sistema web estará configurado para que solo los usuarios autorizados, es decir, los residentes del condominio, puedan crear una cuenta. Esto garantiza la seguridad y la exclusividad de acceso.
2. **Registro de Pagos de Propiedades:** El sistema mantendrá un registro de los pagos relacionados con las propiedades dentro del condominio. Esto incluye el seguimiento de los pagos de los propietarios por conceptos como cuotas de mantenimiento, impuestos, o cualquier otro gasto asociado.
3. **Gestión de Condominios en General:** El sistema está diseñado para abordar las necesidades de gestión de condominios en su totalidad. Esto implica ofrecer una plataforma que permita a los administradores y propietarios gestionar eficazmente las operaciones, comunicaciones y registros dentro del condominio.
4. **Registro de Pagos sin Federación:** El sistema no incluirá un sistema de federación de pagos, lo que significa que los pagos no se realizarán a través de la plataforma. En su lugar, el sistema actuará como un registro de los pagos efectuados fuera de la plataforma, proporcionando un historial completo de transacciones.
5. **Publicaciones Públicas para Usuarios:** Las publicaciones en el sistema serán accesibles para todos los usuarios, lo que fomentará la transparencia y la comunicación dentro de la comunidad del condominio. Esto incluye anuncios, noticias y otros mensajes relevantes.
6. **Propietario Único por Propiedad:** Cada propiedad dentro del condominio solo podrá tener un propietario registrado en el sistema. Esto facilita la gestión de la propiedad y asegura que la información esté actualizada y precisa.


### Tecnologías

Las tecnologias usadas en el desarrollo backend de este proyecto son:

1. **Java 17:** Es un lenguaje de programación ampliamente utilizado para codificar aplicaciones web. Ha sido una opción popular entre los desarrolladores durante más de dos décadas, con millones de aplicaciones Java en uso en la actualidad. Java es un lenguaje multiplataforma, orientado a objetos y centrado en la red que se puede utilizar como una plataforma en sí mismo. Es un lenguaje de programación rápido, seguro y confiable para codificarlo todo, desde aplicaciones móviles y software empresarial hasta aplicaciones de macrodatos y tecnologías del servidor.
2. **PostgreSQL:** Es un sistema de gestión de bases de datos relacional de código abierto. Se utiliza para almacenar y administrar datos estructurados y no estructurados. Ofrece capacidades avanzadas para consultas complejas, integridad de datos, y soporta múltiples tipos de datos. Se utiliza ampliamente en aplicaciones web, análisis de datos, y aplicaciones empresariales debido a su confiabilidad, rendimiento y funcionalidades avanzadas.
3. **GitHub:** Es una plataforma en línea que facilita el alojamiento y la colaboración en proyectos de desarrollo de software utilizando el control de versiones con Git. Sirve como un espacio donde los desarrolladores pueden almacenar, compartir, colaborar y gestionar cambios en el código de manera eficiente, lo que permite un seguimiento de versiones, colaboración remota y control de flujo de trabajo en equipos de desarrollo.
4.  **Spring Boot:** Es un marco de trabajo (framework) de desarrollo de aplicaciones en Java que simplifica la creación de aplicaciones basadas en Spring al facilitar la configuración y el desarrollo. Sirve para crear aplicaciones Java de manera rápida, con configuraciones automáticas, integración sencilla de bibliotecas y un entorno de desarrollo más ágil.
5.  **Maven:** Es una herramienta de gestión de proyectos de software que se utiliza principalmente para la construcción, el manejo de dependencias y la automatización de tareas en el desarrollo de aplicaciones. Sirve para simplificar y estandarizar el proceso de construcción de software, gestionar bibliotecas y facilitar el flujo de trabajo en proyectos de programación.
6.  **Docker:** Es una plataforma de contenedores que permite empaquetar, distribuir y ejecutar aplicaciones en entornos aislados llamados contenedores. Sirve para simplificar el desarrollo, la implementación y la administración de aplicaciones al garantizar que funcionen de manera consistente en diferentes entornos, desde el desarrollo hasta la producción.
