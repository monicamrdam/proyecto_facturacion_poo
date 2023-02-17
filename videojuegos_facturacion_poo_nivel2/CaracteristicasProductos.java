
/**
 * Write a description of class Productos here.
 * Clase CaracteristicasProductos
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CaracteristicasProductos
{
    private String nombre;
    private double precioUnit;
    private int cantStock;
    private boolean disponible = false;

    public CaracteristicasProductos(String nombre, double precioUnit, int cantStock, boolean disponible) {
        this.nombre   = nombre;
        this.precioUnit = precioUnit;
        this.cantStock  = cantStock;
        this.disponible = disponible;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecioUnit() {
        return this.precioUnit;
    }

    public void setPrecioUnit(double precioUnit) {
        this.precioUnit = precioUnit;
    }

    public int getCantStock() {
        return this.cantStock;
    }

    public void setCantStock(int cantStock) {
        this.cantStock = cantStock;
    }

    public boolean isDisponible() {
        if(getCantStock()>0) this.disponible = true;
        return this.disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

}
