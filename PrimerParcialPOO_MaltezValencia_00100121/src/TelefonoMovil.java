public class TelefonoMovil extends  ArticuloElectronico {
    private String sistemaOperativo;

    public TelefonoMovil(String nombre, String modelo, String descripcion, double precio, String sistemaOperativo) {
        super(nombre, modelo, descripcion, precio);
        this.sistemaOperativo = sistemaOperativo;
    }

    @Override
    public double obtenerPrecio() {
        return precio;
    }

    @Override
    public String obtenerDescripcion() {
        return descripcion + ", Sistema Operativo: " + sistemaOperativo;
    }

}
