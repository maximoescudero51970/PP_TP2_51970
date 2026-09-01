public class App {
    public static void main(String[] args) {
        System.out.println("=== SISTEMA DE GESTIÓN DE EVENTOS UTN ===");
        Estudiante e1 = new Estudiante("501", "Lionel Messi");
        Estudiante e2 = new Estudiante("502", "Leandro Paredes");
        Estudiante e3 = new Estudiante("503", "Juan Román Riquelme");

        EventoUniversitario evento1 = new EventoUniversitario("EV-01", "Jornadas de Software", 10000, false);
        EventoUniversitario evento2 = new EventoUniversitario("EV-02", "Congreso de Hardware", 0, true);

        Sala sala1 = new Sala(1, "Aula Magna");
        Sala sala2 = new Sala(2, "Laboratorio 3");

        evento1.asignarSala(sala1);
        evento2.asignarSala(sala2);

        evento1.crearActividad(10, "Introducción a Java", 50, "Charla");
        evento1.crearActividad(20, "Patrones de Diseño", 30, "Taller");

        Actividad charlaJava = evento1.getActividades().get(0);
        Actividad tallerPatrones = evento1.getActividades().get(1);

        charlaJava.inscribir(e1);
        charlaJava.inscribir(e2);
        tallerPatrones.inscribir(e3);

        System.out.println("\n--- RESUMEN EVENTO 1 ---");
        evento1.mostrarDatos();

        System.out.println("\n>> Identificación Polimórfica de Actividades:");

        for (Actividad act : evento1.getActividades()) {
            act.mostrarIdentificacion();
        }

        System.out.println("\n--- RESUMEN EVENTO 2 ---");
        evento2.mostrarDatos();

        System.out.println("\n=========================================");
        System.out.println("TOTAL DE EVENTOS CREADOS: " + EventoUniversitario.getCantidadEventos());
    }
}