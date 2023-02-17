
/**
 * Write a description of class Producto here.
 * Clase padre Producto de la que hereda el resto
 * @author (monicamrdam) 
 * @version (17/02/2023)
 */
public abstract class Producto
{
    private String nombre;
    private double precioUnit;
    private int cantStock;
    private boolean disponible;
    private CaracteristicasProductos cproductos;
    public Producto(CaracteristicasProductos cproductos){
        this.nombre=cproductos.getNombre();
        this.precioUnit=cproductos.getPrecioUnit();
        this.cantStock=cproductos.getCantStock();
        this.disponible=cproductos.isDisponible();
    }

    public String getNombre() {
        return nombre;
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

    @Override
    public String toString() {
        return  "Nombre: "      +this.getNombre()+    "\n"+
        "Precio unidad: " +this.getPrecioUnit()+  " €\n"+
        "En Stock: "    +this.getCantStock()+ "\n";
    }
}
