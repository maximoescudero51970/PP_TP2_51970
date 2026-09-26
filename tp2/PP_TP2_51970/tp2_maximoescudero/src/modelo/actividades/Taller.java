package modelo.actividades;

import modelo.Estudiante;

public class Taller extends Actividad implements certificacion.Certificable, java.io.Serializable {
    private boolean requiereNotebook;

    public Taller(int id, String titulo, int cupoMaximo, boolean requiereNotebook) {
        super(id, titulo, cupoMaximo);
        this.requiereNotebook = requiereNotebook;
    }
    @Override
    public double calcularCostoMateriales() {
        if (this.requiereNotebook) {
            return 5000.0;
        } else {
            return 2000.0;
        }
    }
    @Override
    public String getTipo() {
        return "modelo.actividades.Taller";
    }

    @Override
    public String generarCertificado(Estudiante estudiante) {
        return "Certificado del Taller: " + this.titulo + " otorgado a " + estudiante.getNombre();
    }

}