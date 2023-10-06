package puntopeluqueria;

public class MainPeluqueria {
    public static void main(String[] args) {
        // Accede a los valores del enum y muestra la información
        for (ServicioPeluqueria servicio : ServicioPeluqueria.values()) {
            System.out.println("Nombre del servicio: " + servicio.getNombre());
            System.out.println("Descripción del servicio: " + servicio.getDescripcion());
            System.out.println("Precio del servicio: " + servicio.getPrecio());
            System.out.println("Descripción personalizada: " + servicio.mostrarDescripcionServicio());
            System.out.println(); // Salto de línea para separar cada servicio
        }
    }
}
