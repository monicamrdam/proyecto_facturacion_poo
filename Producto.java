
/**
 * Write a description of class Producto here.
 * Clase Producto
 * @author (monicamrdam) 
 * @version (17/02/2023)
 */
public class Producto
{
    private String descripcion;
    private double precio;
    
    public Producto(String descripcion, double precio){
        this.descripcion= descripcion;
        this.precio=precio;
    }
    public String getDescripcion(){
        return descripcion;
    }
    public double getPrecio(){
        return precio;
    }
    
    public void setDescripcion(String descripcion){
        this.descripcion=descripcion;
    }
    public void setPrecio(double precio){
        this.precio=precio;
    }
    @Override
    public String toString(){
        return "Producto{" + "descripcion=" + descripcion + ", precio=" + precio+"}";
    }
}
