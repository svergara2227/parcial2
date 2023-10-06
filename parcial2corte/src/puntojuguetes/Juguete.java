package puntojuguetes;
import java.io.*;
import java.util.ArrayList;

public class Juguete implements Serializable {
    private int id;
    private String nombre;
    private String categoria;
    private double precio;
    private int cantidad;

    public Juguete(int id, String nombre, String categoria, double precio, int cantidad) {
        this.id = id;
        this.nombre = nombre;
        this.categoria = categoria;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public double getPrecio() {
        return precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}

interface JugueteDAO {
    void agregar(Juguete juguete) throws IOException, ClassNotFoundException;
    Juguete obtener(int id) throws IOException, ClassNotFoundException;
    ArrayList<Juguete> obtenerTodos() throws IOException, ClassNotFoundException;
    void actualizar(Juguete juguete) throws IOException, ClassNotFoundException;
    void eliminar(int id) throws IOException, ClassNotFoundException;
}

class JugueteDAOImpl implements JugueteDAO {
    private ArrayList<Juguete> juguetes = new ArrayList<>();
    private final String FILE_NAME = "juguetes.dat";

    public JugueteDAOImpl() throws IOException, ClassNotFoundException {
        File file = new File(FILE_NAME);
        if (file.exists()) {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
            juguetes = (ArrayList<Juguete>) ois.readObject();
            ois.close();
        } else {
            file.createNewFile();
        }
    }

    @Override
    public void agregar(Juguete juguete) throws IOException, ClassNotFoundException {
        juguetes.add(juguete);
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME));
        oos.writeObject(juguetes);
        oos.close();
    }

    @Override
    public Juguete obtener(int id) throws IOException, ClassNotFoundException {
        for (Juguete juguete : juguetes) {
            if (juguete.getId() == id) {
                return juguete;
            }
        }
        return null;
    }

    @Override
    public ArrayList<Juguete> obtenerTodos() throws IOException, ClassNotFoundException {
        return juguetes;
    }

    @Override
    public void actualizar(Juguete juguete) throws IOException, ClassNotFoundException {
        for (int i = 0; i < juguetes.size(); i++) {
            if (juguetes.get(i).getId() == juguete.getId()) {
                juguetes.set(i, juguete);
                ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME));
                oos.writeObject(juguetes);
                oos.close();
                break;
            }
        }
    }

    @Override
    public void eliminar(int id) throws IOException, ClassNotFoundException {
        for (int i = 0; i < juguetes.size(); i++) {
            if (juguetes.get(i).getId() == id) {
                juguetes.remove(i);
                ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME));
                oos.writeObject(juguetes);
                oos.close();
                break;
            }
        }
    }
}

