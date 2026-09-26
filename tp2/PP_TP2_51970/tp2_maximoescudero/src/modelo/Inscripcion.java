package modelo;

import java.io.Serializable;
import java.time.LocalDate;
public class Inscripcion implements Serializable {
    private LocalDate fecha;
    private String estado;
    private Estudiante estudiante; // Agregamos la referencia al estudiante

    public Inscripcion(Estudiante estudiante, LocalDate fecha, String estado) {
        this.estudiante = estudiante;
        this.fecha = fecha;
        this.estado = estado;
    }
    public Estudiante getEstudiante() {
        return estudiante;
    }
    public LocalDate getFecha() {
        return fecha;
    }
    public String getEstado() {
        return estado;
    }
}