public class TelefonoMovil extends Articulo implements Especificaciones{
    private String tipoTelefono;
    private double anioDeSalida;

    public TelefonoMovil(String Id, String nombre, String modelo, String descripcion, double precio, String tipoTelefono, double anioDeSalida) {
        super(Id, nombre, modelo, descripcion, precio);
        this.tipoTelefono = tipoTelefono;
        this.anioDeSalida = anioDeSalida;
    }
    public TelefonoMovil(){

    }

    public String getTipoTelefono() {
        return tipoTelefono;
    }

    public void setTipoTelefono(String tipoTelefono) {
        this.tipoTelefono = tipoTelefono;
    }

    public double getAnioDeSalida() {
        return anioDeSalida;
    }

    public void setAnioDeSalida(double anioDeSalida) {
        this.anioDeSalida = anioDeSalida;
    }

    @Override
    public double obtenerPrecio() {
        return calcularPrecio(anioDeSalida);
    }

    @Override
    public String obtenerDescripcion() {
        return descripcionArticulo(tipoTelefono);
    }


    @Override
    public double calcularPrecio(double anioSalida) {
        if (anioSalida > 2015){
            System.out.println("(Se aplico cargo extra debido al año de salida)");
            return precio + 200;
        }else{
            return precio;
        }
    }

    @Override
    public String descripcionArticulo(String descripcionEspecificacion) {
        return " - Descripcion general: " + descripcion + " - Descripcion especifica del tipo de telefono: " + descripcionEspecificacion;
    }
}
