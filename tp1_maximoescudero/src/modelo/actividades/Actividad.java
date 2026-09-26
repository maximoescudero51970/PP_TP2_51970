package modelo.actividades;

import exepciones.CupoExcedidoException;
import modelo.Estudiante;
import modelo.Inscripcion;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class Actividad {

    private int id;
    protected String titulo;
    private int cupoMaximo;
    public final int CUPO_MINIMO = 5;
    private List<Inscripcion> inscripciones;

    public Actividad(int id, String titulo, int cupoMaximo) {
        this.id = id;
        this.titulo = titulo;
        this.cupoMaximo = cupoMaximo;
        this.inscripciones = new ArrayList<>();
    }

    public Actividad() {
        super();
    }

    public Inscripcion inscribir (Estudiante estudiante) throws CupoExcedidoException {

        if (this.inscripciones.size() >= this.cupoMaximo) {
            throw new CupoExcedidoException("El cupo para la actividad está lleno.");
        }
        Inscripcion nuevaInscripcion = new Inscripcion(estudiante, java.time.LocalDate.now(), "Confirmada");
        this.inscripciones.add(nuevaInscripcion);
        return nuevaInscripcion;
    }

    public void mostrarInscripciones() {
        System.out.println("--- Inscriptos en: " + this.titulo + " ---");
        for (Inscripcion i : inscripciones) {
            System.out.println("Alumno: " + i.getEstudiante().getNombre() + " | Estado: " + i.getEstado());
        }
    }
    public abstract double calcularCostoMateriales();
    public abstract String getTipo();
    public final void mostrarIdentificacion() {
        System.out.println("modelo.actividades.Actividad [" + getTipo() + "]: " + this.titulo);
    }
    public String getTitulo() {
        return this.titulo;
    }

    public List<Inscripcion> getInscripciones() {
        return this.inscripciones;
    }
}