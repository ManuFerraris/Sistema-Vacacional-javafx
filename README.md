# Sistema de Gestión Vacacional - Coca-Cola (JavaFX Migration)

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![JavaFX](https://img.shields.io/badge/JavaFX-blue?style=for-the-badge&logo=java&logoColor=white)
![CSS3](https://img.shields.io/badge/CSS3-1572B6?style=for-the-badge&logo=css3&logoColor=white)

## Descripción del Proyecto
Este proyecto es una aplicación de escritorio profesional desarrollada para automatizar el cálculo de días de vacaciones de los empleados de Coca-Cola, basándose en su departamento y años de antigüedad. 

Originalmente concebido como un sistema legacy, este software ha sido **completamente migrado y rediseñado** de Swing a **JavaFX**, implementando una arquitectura modular, lógica basada en Programación Orientada a Objetos (POO) y una interfaz de usuario moderna estilizada con CSS.

## Desafíos Técnicos y Aprendizajes
* **Migración Legacy:** Transición de componentes antiguos a una interfaz moderna y reactiva.
* **Arquitectura POO:** Implementación de **Polimorfismo** y **Herencia** para gestionar las diferentes reglas de negocio por departamento (Atención al Cliente, Logística y Gerencia).
* **UI/UX con CSS:** Personalización total de componentes de JavaFX mediante hojas de estilo externas para lograr la identidad visual corporativa.
* **Gestión de Navegación:** Creación de una clase utilitaria centralizada para el manejo de escenas, iconos y recursos globales.

## Funcionalidades
- [x] **Control de Acceso:** Validación de roles de usuario.
- [x] **Flujo de Usuario:** Pantalla de bienvenida personalizada y aceptación de términos legales.
- [x] **Motor de Cálculo:** Lógica polimórfica que determina días de vacaciones exactos.
- [x] **Interfaz Adaptativa:** Uso de layouts avanzados como `GridPane`, `VBox` y `ScrollPane` para una visualización óptima en escritorio.

## Previsualización
Dirigirse a la carpeta "screenshots" donde verán las imagenes de las pantallas.

## Estructura del Proyecto
* `src.ui`: Clases de interfaz de usuario (JavaFX).
* `src.logica`: Motor de cálculo y modelos de datos (Herencia y Polimorfismo).
* `src.util`: Clases de soporte para navegación y alertas.
* `src.ui.styles`: Hojas de estilo CSS.
* `src.ui.images`: Recursos gráficos e iconos.

## Instalación y Ejecución
1. Clona el repositorio:
   ```bash
   git clone [https://github.com/tu-usuario/proyecto-coca-cola.git](https://github.com/tu-usuario/proyecto-coca-cola.git)
2. Asegúrate de tener instalado el JDK 8 (o superior) con soporte para JavaFX.
3. Compila y ejecuta la clase LoginCSS.java para iniciar el sistema.

Desarrollado por Manuel Ferraris
