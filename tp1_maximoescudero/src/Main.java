import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        System.out.println("==========================================");
        System.out.println("   SISTEMA DE EVENTOS - UTN MENDOZA       ");
        System.out.println("==========================================\n");

        Estudiante est1 = new Estudiante("50101", "Lionel Messi");
        Estudiante est2 = new Estudiante("50102", "Leandro Paredes");
        Estudiante est3 = new Estudiante("50103", "Juan Román Riquelme");

        List<Estudiante> listaEstudiantes = new ArrayList<>();
        listaEstudiantes.add(est1);
        listaEstudiantes.add(est2);
        listaEstudiantes.add(est3);

        EventoUniversitario evento1 = new EventoUniversitario("E-001", "Hackathon de Sistemas", 15000.0, false);
        EventoUniversitario evento2 = new EventoUniversitario("E-002", "Charla de Inteligencia Artificial", 0.0, true);

        Sala sala1 = new Sala(10, "Laboratorio Principal");
        Sala sala2 = new Sala(11, "Auditorio Planta Baja");

        evento1.asignarSala(sala1);
        evento2.asignarSala(sala2);

        evento1.crearActividad(101, "Competencia de Java", 20, "Charla");
        evento1.crearActividad(102, "Taller de Bases de Datos", 15, "Taller");

        List<Actividad> actividadesE1 = evento1.getActividades();

        Actividad competenciaJava = actividadesE1.get(0);
        Actividad tallerBD = actividadesE1.get(1);

        competenciaJava.inscribir(est1);
        competenciaJava.inscribir(est3);
        tallerBD.inscribir(est2);

        System.out.println("--- RESUMEN EVENTO 1 ---");
        evento1.mostrarDatos();
        System.out.println("\n> Detalle de inscriptos en el Evento 1:");
        competenciaJava.mostrarInscripciones();
        tallerBD.mostrarInscripciones();

        System.out.println("\n------------------------------------------\n");

        System.out.println("--- RESUMEN EVENTO 2 ---");
        evento2.mostrarDatos(); // Este lo dejamos sin actividades para ver la diferencia

        System.out.println("\n==========================================");

        System.out.println("TOTAL DE EVENTOS CREADOS EN EL SISTEMA: " + EventoUniversitario.getCantidadEventos());
    }
}