package modelo.actividades;

public class Charla extends Actividad implements java.io.Serializable {
    private String disertante;

    public Charla(int id, String titulo, int cupoMaximo, String disertante) {
        super(id, titulo, cupoMaximo);
        this.disertante = disertante;
    }

    public Charla() {
        super();
    }

    @Override
    public double calcularCostoMateriales() {
        return 0.0; // Las charlas no tienen costo de materiales[cite: 1]
    }

    @Override
    public String getTipo() {

        return "";
    }
}
