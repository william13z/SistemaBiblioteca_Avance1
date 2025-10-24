package utp.Ac.Pa.sistema;

import utp.Ac.Pa.config.ConfiguracionSistema;

public class App {
    public static void main(String[] args) {
        System.out.println("Sistema de Gestión de Biblioteca Académica – Avance #1");
        ConfiguracionSistema cfg = ConfiguracionSistema.cargarPorDefecto();
        System.out.println("Días de préstamo por defecto: " + cfg.getDiasPrestamo());

        // --- DEMO EXPRESS (pegar exactamente dentro del main, debajo de los println) ---
        utp.Ac.Pa.domain.Editorial ed = new utp.Ac.Pa.domain.Editorial("E1","UTP Press");
        utp.Ac.Pa.domain.Libro l1 = new utp.Ac.Pa.domain.Libro("ISBN1","POO",2025, ed);
        utp.Ac.Pa.domain.Autor a1 = new utp.Ac.Pa.domain.Autor("A1","Gamma");
        l1.agregarAutor(a1);

        utp.Ac.Pa.domain.Ejemplar ex1 = new utp.Ac.Pa.domain.Ejemplar("EX-001", l1);
        utp.Ac.Pa.domain.Estudiante u1 = new utp.Ac.Pa.domain.Estudiante("U1","Ana","Sistemas","2025-001");

        java.time.LocalDate hoy = java.time.LocalDate.now();
        utp.Ac.Pa.domain.Prestamo pr = new utp.Ac.Pa.domain.Prestamo(
                "P1", u1, ex1, hoy.minusDays(10), hoy.minusDays(3)
        );

        java.util.List<utp.Ac.Pa.domain.Prestamo> lista =
                java.util.Arrays.asList(pr);

        utp.Ac.Pa.services.ReporteService rep = new utp.Ac.Pa.services.ReporteService();
        System.out.println("Top libros: " +
                rep.topLibrosMasPrestados(lista, hoy.minusDays(30), hoy, 5).size());
        System.out.println("Stats por editorial: " +
                rep.estadisticasPorEditorial(lista, hoy.minusDays(30), hoy).size());
        // --- FIN DEMO ---
    }
}