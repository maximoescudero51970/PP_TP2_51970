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

Este proyecto escala el **Sistema de Gestión de Eventos Universitarios**, aplicando conceptos avanzados de la **Programación Orientada a Objetos (POO)** en Java (JDK 25)[cite: 12]. La arquitectura del software está modularizada en paquetes independientes para garantizar un diseño robusto, contemplando control de excepciones, persistencia de datos mediante flujos binarios, polimorfismo con interfaces, colecciones con genéricos y ejecución concurrente basada en hilos

---

## 🏗️ Estructura de Paquetes y Componentes

El código fuente se encuentra organizado en el siguiente esquema modular:

* **`modelo`**: Contiene las entidades principales del sistema (`EventoUniversitario`, `Sala`, `Estudiante`, `Inscripcion`), la clase abstracta `Actividad` y sus respectivas especializaciones concretas (`Charla`, `Taller`, `Curso`)[cite: 12].
* **`certificacion`**: Aloja la interfaz `Certificable` utilizada para definir la emisión de constancias de asistencia
* **`exepciones`**: Contiene la excepción personalizada de tipo chequeado `CupoExcedidoException` para el manejo de tolerancia a fallos
* **`hilos`**: Contiene la clase `EnvioTicketsThread` diseñada para procesar el envío concurrente de tickets

---

## 🛠️ Resoluciones Técnicas Implementadas

1. **Excepciones y Tolerancia a Fallos:** Control estricto de cupos máximos en las actividades mediante el lanzamiento explícito (`throw`/`throws`) de `CupoExcedidoException` y su captura en la clase principal
2. **Interfaces y Polimorfismo:** Uso de la interfaz `Certificable` implementada selectivamente en `Taller` y `Curso`, cumpliendo con las reglas de negocio de la cátedra[cite: 12].
3. **Serialización:** Mecanismo de persistencia de objetos mediante `FileOutputStream` y `ObjectOutputStream` para almacenar y recuperar el estado del evento en archivos binarios (`.dat`)
4. **Genéricos y Wildcards:** 
   * Filtrado tipado de actividades mediante métodos parametrizados acotados (`<T extends Actividad>`)
   * Cálculo polimórfico de costos usando comodines (`List<? extends Actividad>`)
5. **Concurrencia (Hilos):** Procesamiento en segundo plano de los tickets de acceso a través de la clase `EnvioTicketsThread` (extendiendo de `Thread`), permitiendo que el flujo principal de la aplicación continúe ejecutándose sin bloqueos

---

## 📥 ¿Cómo clonar y ejecutar el proyecto?

Para probar el funcionamiento de este desarrollo en tu computadora, seguí estos pasos:

### 1. Clonar el Repositorio
Abrí una terminal en tu equipo y ejecutá el siguiente comando para clonar el repositorio mediante HTTPS:
```bash
git clone [https://github.com/maximoescudero51970/PP_TP2_51970.git](https://github.com/maximoescudero51970/PP_TP2_51970.git)
