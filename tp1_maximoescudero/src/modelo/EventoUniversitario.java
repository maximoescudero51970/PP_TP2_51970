package modelo;

import modelo.actividades.Actividad;
import modelo.actividades.Charla;
import modelo.actividades.Curso;
import modelo.actividades.Taller;

import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class EventoUniversitario implements Serializable {
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

    public void crearActividad(int id, String titulo, int cupo, String tipo) {
        if (tipo.equalsIgnoreCase("modelo.actividades.Charla")) {
            Charla nuevaCharla = new Charla(id, titulo, cupo, "Disertante a confirmar");
            this.actividades.add(nuevaCharla);

        } else if (tipo.equalsIgnoreCase("modelo.actividades.Taller")) {
            Taller nuevoTaller = new Taller(id, titulo, cupo, true);
            this.actividades.add(nuevoTaller);

        } else if (tipo.equalsIgnoreCase("modelo.actividades.Curso")) {
            Curso nuevoCurso = new Curso(id, titulo, cupo, 5); // 5 clases por defecto
            this.actividades.add(nuevoCurso);

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
            System.out.println("modelo.Sala asignada: " + this.sala.getNombre() + " (ID: " + this.sala.getId() + ")");
        } else {
            System.out.println("modelo.Sala asignada: Aún no tiene sala.");
        }

        System.out.println("Actividades programadas: " + this.actividades.size());
    }
    public String getTitulo() {
        return this.titulo;
    }
    public static int getCantidadEventos() {
        return cantidadEventos;
    }

    public boolean persistirEvento() {
        try {
            FileOutputStream fos = new FileOutputStream(this.id + ".dat");
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(this);
            oos.close();
            fos.close();

            return true;
        } catch (IOException e) {
            System.err.println("Error al persistir el evento: " + e.getMessage());
            return false;
        }
    }

    public static EventoUniversitario recuperarEvento(String idBuscado) {
        try {
            FileInputStream fis = new FileInputStream(idBuscado + ".dat");
            ObjectInputStream ois = new ObjectInputStream(fis);
            EventoUniversitario eventoRecuperado = (EventoUniversitario) ois.readObject();

            ois.close();
            fis.close();

            return eventoRecuperado;

        } catch (IOException e) {
            System.err.println("Error de lectura: No se pudo abrir el archivo. " + e.getMessage());
            return null;
        } catch (ClassNotFoundException e) {
            System.err.println("Error de conversión: La clase del objeto no fue encontrada. " + e.getMessage());
            return null;
        }
    }
    public <T extends Actividad> List<T> filtrarActividadesPorTipo(Class<T> tipo) {
        List<T> listaFiltrada = new ArrayList<>();
        for (Actividad act : this.actividades) {
            if (tipo.isInstance(act)) {
                listaFiltrada.add(tipo.cast(act));
            }
        }
        return listaFiltrada;
    }
    public double calcularCostoMateriales(List<? extends Actividad> actividadesList) {
        double costoTotal = 0.0;
        for (Actividad act : actividadesList) {
            costoTotal += act.calcularCostoMateriales();
        }
        return costoTotal;
    }
}