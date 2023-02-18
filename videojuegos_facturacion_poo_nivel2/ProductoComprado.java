
/**
 * Write a description of class ProductoComprado here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ProductoComprado {
    private String descripcion;
    private double precio;

    public ProductoComprado(String descripcion, double precio) {
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    
}