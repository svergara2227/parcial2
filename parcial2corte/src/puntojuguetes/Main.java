package puntojuguetes;

import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        JugueteDAO dao = new JugueteDAOImpl();

        // Agregar un nuevo juguete
        dao.agregar(new Juguete(1, "Muñeca", "Juguetes para niñas", 10.5, 20));

        // Obtener un juguete por su ID
        Juguete juguete1 = dao.obtener(1);
        if (juguete1 != null) {
            System.out.println(juguete1.getNombre());
        } else {
            System.out.println("El juguete no existe");
        }

        // Obtener todos los juguetes
        ArrayList<Juguete> todosLosJuguetes = dao.obtenerTodos();
        for (Juguete juguete : todosLosJuguetes) {
            System.out.println(juguete.getNombre());
        }

        // Actualizar un juguete
        Juguete juguete2 = dao.obtener(1);
        if (juguete2 != null) {
            juguete2.setPrecio(12.5);
            dao.actualizar(juguete2);
            System.out.println("El precio del juguete ha sido actualizado");
        } else {
            System.out.println("El juguete no existe");
        }

        // Eliminar un juguete
        Juguete juguete3 = dao.obtener(1);
        if (juguete3 != null) {
            dao.eliminar(juguete3.getId());
            System.out.println("El juguete ha sido eliminado");
        } else {
            System.out.println("El juguete no existe");
        }
    }
}
