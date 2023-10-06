package puntopeluqueria;

public enum ServicioPeluqueria {
    CORTE("Corte de cabello", "Servicio de corte de cabello", 25.0){
        @Override
        public String mostrarDescripcionServicio() {
            return "5 para samuel";
        }
    },
    UÑAS("Manicura y pedicura", "Servicio de cuidado de uñas", 15.0){
        @Override
        public String mostrarDescripcionServicio() {
            return "5 para samuel";
        }
    },
    TINTE("Tinte de cabello", "Servicio de tinte de cabello", 30.0){
        @Override
        public String mostrarDescripcionServicio() {
            return "5 para samuel";
        }
    };

    private String nombre;
    private  String descripcion;
    private  double precio;

    private ServicioPeluqueria(String nombre, String descripcion, double precio) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getPrecio() {
        return precio;
    }


    public abstract String mostrarDescripcionServicio();

}
