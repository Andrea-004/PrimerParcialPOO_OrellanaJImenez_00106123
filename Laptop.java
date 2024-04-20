public class Laptop extends Articulo implements Especificaciones{
    private double almacenamiento;
    private String RAM;

    public Laptop(String Id, String nombre, String modelo, String descripcion, double precio, double almacenamiento, String RAM) {
        super(Id, nombre, modelo, descripcion, precio);
        this.almacenamiento = almacenamiento;
        this.RAM = RAM;
    }

    public Laptop(){

    }

    public double getAlmacenamiento() {
        return almacenamiento;
    }

    public void setAlmacenamiento(double almacenamiento) {
        this.almacenamiento = almacenamiento;
    }

    public String getRAM() {
        return RAM;
    }

    public void setRAM(String RAM) {
        this.RAM = RAM;
    }

    @Override
    public double obtenerPrecio() {
        return calcularPrecio(almacenamiento);
    }

    @Override
    public String obtenerDescripcion() {
        return descripcionArticulo(RAM);
    }


    @Override
    public double calcularPrecio(double almacenamientoLaptop) {
        if (almacenamientoLaptop > 120){
            System.out.println("(Se aplico cargo extra debido al almacenamiento)");
            return precio + 20;
        }else{
            return precio;
        }
    }

    @Override
    public String descripcionArticulo(String descripcionEspecificacion) {
        return " - Descripcion general: " + descripcion + " - Descripcion especifica de la RAM de la laptop: " + descripcionEspecificacion;
    }
}
