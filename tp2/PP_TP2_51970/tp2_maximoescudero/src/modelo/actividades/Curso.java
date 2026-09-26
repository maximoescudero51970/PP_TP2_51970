package modelo.actividades;

import certificacion.Certificable;
import java.io.Serializable;

public class Curso extends Actividad implements certificacion.Certificable, java.io.Serializable {
    private int cantidadClases;

    public Curso(int id, String titulo, int cupoMaximo, int cantidadClases) {
        super(id, titulo, cupoMaximo);
        this.cantidadClases = cantidadClases;
    }
    public Curso () {
        super();
    }

    @Override
    public double calcularCostoMateriales() {
        return this.cantidadClases * 400.0; // Costo por clase del curso
    }

    @Override
    public String getTipo() {
        return "Curso";
    }

    @Override
    public String generarCertificado(modelo.Estudiante estudiante) {
        return "Certificado del Curso: " + this.titulo + " otorgado a " + estudiante.getNombre();
    }
}