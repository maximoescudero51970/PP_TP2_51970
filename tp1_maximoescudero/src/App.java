import modelo.Estudiante;
import modelo.EventoUniversitario;
import modelo.Sala;
import modelo.Inscripcion;
import modelo.actividades.Actividad;
import modelo.actividades.Charla;
import modelo.actividades.Taller;
import modelo.actividades.Curso;
import java.util.List;
import exepciones.CupoExcedidoException;

public class App {
    public static void main(String[] args) {
        System.out.println("--- SISTEMA DE GESTION DE EVENTOS UTN ---");

        Estudiante e1 = new Estudiante("501", "Lionel Messi");
        Estudiante e2 = new Estudiante("502", "Leandro Paredes");
        Estudiante e3 = new Estudiante("503", "Juan Román Riquelme");
        Estudiante e4 = new Estudiante("504", "Diego Maradona");

        EventoUniversitario evento1 = new EventoUniversitario("EV-01", "Jornadas de Software", 10000.0, false);
        Sala sala1 = new Sala(1, "Aula Magna");
        evento1.asignarSala(sala1);

        evento1.crearActividad(10, "Introduccion a Java", 2, "modelo.actividades.Charla");
        evento1.crearActividad(20, "Patrones de Diseño", 30, "modelo.actividades.Taller");
        evento1.crearActividad(30, "Arquitectura de Software", 20, "modelo.actividades.Curso");

        List<Actividad> listaActividades = evento1.getActividades();
        Actividad charlaJava = listaActividades.get(0);
        Actividad tallerPatrones = listaActividades.get(1);
        Actividad cursoArquitectura = listaActividades.get(2);

        System.out.println("\n--- PROCESO DE INSCRIPCIONES ---");
        try {
            charlaJava.inscribir(e1);
            charlaJava.inscribir(e2);
            tallerPatrones.inscribir(e3);
            cursoArquitectura.inscribir(e4);
            System.out.println("-> Éxito: Inscripciones realizadas correctamente.");
        } catch (CupoExcedidoException e) {
            System.err.println("[ERROR] " + e.getMessage());
        }

        List<Charla> charlas = evento1.filtrarActividadesPorTipo(Charla.class);
        List<Taller> talleres = evento1.filtrarActividadesPorTipo(Taller.class);
        List<Curso> cursos = evento1.filtrarActividadesPorTipo(Curso.class);

        System.out.println("\n--- CANTIDAD DE ACTIVIDADES POR TIPO ---");
        System.out.println("Cantidad de Charlas: " + charlas.size());
        System.out.println("Cantidad de Talleres: " + talleres.size());
        System.out.println("Cantidad de Cursos: " + cursos.size());

        double costoCharlas = evento1.calcularCostoMateriales(charlas);
        double costoTalleres = evento1.calcularCostoMateriales(talleres);
        double costoCursos = evento1.calcularCostoMateriales(cursos);

        System.out.println("\n--- COSTOS DE MATERIALES POR TIPO ---");
        System.out.println("Costo de materiales - Charlas: $" + costoCharlas);
        System.out.println("Costo de materiales - Talleres: $" + costoTalleres);
        System.out.println("Costo de materiales - Cursos: $" + costoCursos);

        System.out.println("\n--- EVIDENCIA DE TIPADO CORRECTO ---");
        System.out.println("¿'charlas' es una instancia de List? " + (charlas instanceof List));
        if (!charlas.isEmpty()) {
            System.out.println("Primer elemento tipado como Charla -> Título: " + charlas.get(0).getTitulo());
        }
        if (!talleres.isEmpty()) {
            System.out.println("Primer elemento tipado como Taller -> Título: " + talleres.get(0).getTitulo());
        }
        if (!cursos.isEmpty()) {
            System.out.println("Primer elemento tipado como Curso -> Título: " + cursos.get(0).getTitulo());
        }
    }
}