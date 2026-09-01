import java.util.ArrayList;
import java.util.List;

public class EventoUniversitario {

    private final String id;
    private String titulo;
    private double costoBase;
    private boolean gratuito;
    private static int cantidadEventos = 0;

    private Sala sala;
    private List<Actividad> actividades;

    public EventoUniversitario(String id, String titulo, double costoBase, boolean gratuito) {
        this.id = id;
        this.titulo = titulo;
        this.costoBase = costoBase;
        this.gratuito = gratuito;
        cantidadEventos++;
        this.actividades = new ArrayList<>();
    }

    public EventoUniversitario(EventoUniversitario otro) {
        this.id = otro.id;
        this.titulo = otro.titulo;
        this.costoBase = otro.costoBase;
        this.gratuito = otro.gratuito;
        cantidadEventos++;
        this.actividades = new ArrayList<>();
    }
    public double calcularCostoEstimado() {
        if (this.gratuito) {
            return 0.0;
        } else {
            double costoTotalActividades = 0;

            for (Actividad act : actividades) {
                costoTotalActividades += act.calcularCostoMateriales();
            }
            return (this.costoBase + costoTotalActividades) * 1.21;
        }
    }

    public void asignarSala(Sala sala) {
        this.sala = sala;
    }

    // --- NUEVA VERSIÓN EJERCICIO 3: Recibe el String 'tipo' ---
    public void crearActividad(int id, String titulo, int cupo, String tipo) {
        if (tipo.equalsIgnoreCase("Charla")) {
            Charla nuevaCharla = new Charla(id, titulo, cupo, "Disertante a confirmar");
            this.actividades.add(nuevaCharla);

        } else if (tipo.equalsIgnoreCase("Taller")) {
            Taller nuevoTaller = new Taller(id, titulo, cupo, true);
            this.actividades.add(nuevoTaller);

        } else {
            System.out.println("Error: Tipo de actividad desconocido.");
        }
    }

    public List<Actividad> getActividades() {
        return this.actividades;
    }

    public void mostrarDatos() {
        System.out.println("ID: " + this.id);
        System.out.println("Título: " + this.titulo);
        System.out.println("Costo Base: $" + this.costoBase);
        System.out.println("¿Es Gratuito?: " + (this.gratuito ? "Sí" : "No"));
        System.out.println("Costo Estimado Final: $" + calcularCostoEstimado());

        if (this.sala != null) {
            System.out.println("Sala asignada: " + this.sala.getNombre() + " (ID: " + this.sala.getId() + ")");
        } else {
            System.out.println("Sala asignada: Aún no tiene sala.");
        }

        System.out.println("Actividades programadas: " + this.actividades.size());
    }

    public static int getCantidadEventos() {
        return cantidadEventos;
    }
}