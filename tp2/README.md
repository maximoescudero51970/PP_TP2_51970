# Trabajo Práctico N° 2: Paradigmas de Programación

Repositorio correspondiente al **Trabajo Práctico N° 2** de la materia **Paradigmas de Programación** de la **UTN - Facultad Regional Mendoza**.

---

## 👨‍🎓 Datos del Alumno

* **Alumno:** Máximo Escudero
* **Legajo:** 51970
* **Carrera:** Ingeniería en Sistemas de Información
* **Institución:** Universidad Tecnológica Nacional - Facultad Regional Mendoza (UTN - FRM)

---

## 📋 Descripción General del Proyecto

Este proyecto escala el Sistema de Gestión de Eventos Universitarios, aplicando de forma avanzada los conceptos de la **Programación Orientada a Objetos (POO)** en Java (JDK 25). La arquitectura del software se encuentra modularizada en paquetes que mejoran el encapsulamiento, permitiendo el manejo robusto de excepciones, persistencia binaria, uso de interfaces, genéricos avanzados y concurrencia con hilos.

---

## 🏗️ Arquitectura y Estructura de Paquetes

El código fuente se organiza según el modelo conceptual en los siguientes paquetes:

* **`modelo`**: Contiene las clases principales del dominio del negocio (`EventoUniversitario`, `Sala`, `Estudiante`, `Inscripcion`), la clase abstracta `Actividad` y sus subcategorías concretas (`Charla`, `Taller`, `Curso`)[cite: 12].
* **`certificacion`**: Contiene la interfaz `Certificable` que define la emisión de certificados de asistencia[cite: 12].
* **`exepciones`**: Aloja la excepción personalizada `CupoExcedidoException` para el control de capacidad de asistentes[cite: 12].
* **`hilos`**: Contiene la clase concurrente `EnvioTicketsThread` orientada al envío en segundo plano de los tickets de acceso[cite: 12].

---

## 🛠️ Resoluciones Técnicas por Ejercicio

### 🔹 Ejercicio 1: Modularización, Excepciones y Persistencia
* **Modularización:** Separación limpia de responsabilidades mediante paquetes independientes[cite: 12].
* **Excepciones Personalizadas:** Creación e implementación de `CupoExcedidoException` (heredando de `Exception`) para interrumpir y controlar de forma granular cuando un cupo máximo es superado[cite: 12].
* **Persistencia por Serialización:** Utilización de flujos de bytes (`FileOutputStream`, `ObjectOutputStream`, `FileInputStream`, `ObjectInputStream`) para guardar y recuperar el estado completo del `EventoUniversitario` y sus colecciones en archivos binarios locales (`.dat`)[cite: 12].

### 🔹 Ejercicio 2: Interfaces y Polimorfismo
* **Interfaz `Certificable`:** Define el comportamiento para la emisión de documentos de validez académica[cite: 12].
* **Aplicación Selectiva:** Implementada polimórficamente en las clases `Taller` y `Curso`, excluyendo explícitamente a las `Charla` según los requerimientos de negocio[cite: 12].

### 🔹 Ejercicio 3: Genéricos (Generics) y Wildcards
* **Métodos Parametrizados Acotados:** Implementación en `EventoUniversitario` del método para filtrar actividades garantizando el tipado estricto en tiempo de compilación[cite: 12]:
  ```java
  public <T Actividad extends> List<T> filtrarActividadesPorTipo(Class<T> tipo)
