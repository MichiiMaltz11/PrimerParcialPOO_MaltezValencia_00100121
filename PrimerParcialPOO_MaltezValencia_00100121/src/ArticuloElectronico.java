

abstract class ArticuloElectronico {
    protected String nombre;
    protected String modelo;
    protected String descripcion;
    protected double precio;

    public ArticuloElectronico(String nombre, String modelo, String descripcion, double precio) {
        this.nombre = nombre;
        this.modelo = modelo;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public abstract double obtenerPrecio();

    public abstract String obtenerDescripcion();

}
