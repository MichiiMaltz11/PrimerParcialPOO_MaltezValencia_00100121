public class Laptop extends ArticuloElectronico{
    private String sistemaOperativo;
    private String tamanoPantalla;

    public Laptop(String nombre, String modelo, String descripcion, double precio, String sistemaOperativo, String tamanoPantalla) {
        super(nombre, modelo, descripcion, precio);
        this.sistemaOperativo = sistemaOperativo;
        this.tamanoPantalla = tamanoPantalla;
    }

    public Laptop(String nombre, String modelo, String descripcion, double precio) {
        super(nombre, modelo, descripcion, precio);
    }

    @Override
    public double obtenerPrecio() {
        return precio;
    }

    @Override
    public String obtenerDescripcion() {
        return descripcion + ", Sistema Operativo: " + sistemaOperativo + ", Tamanio de Pantalla: " + tamanoPantalla;
    }



}
