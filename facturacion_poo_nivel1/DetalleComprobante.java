
/**
 * Write a description of class DetalleComprobante here.
 * Clase detalle comprobante
 * @author (monicamrdam) 
 * @version (17/02/2023)
 */
public class DetalleComprobante
{
    private int cantidad;
    private Producto producto;
    private double total;
    
    public DetalleComprobante(int cantidad, String descripcion, double precio){
        this.cantidad=cantidad;
        ingresarProductos(descripcion, precio);
        setTotal();
    }
    public int getCantidad(){
        return cantidad;
    }
    public Producto getProducto(){
        return producto;
    }
    public double getTotal(){
        return total;
    }
    public void setCantidad(int cantidad){
        this.cantidad=cantidad;
    }
    private double calcularTotal(){
        return cantidad + producto.getPrecio();
    }   
    public void setTotal(){
        total=calcularTotal();
    }
    private Producto crearProducto(String descripcion, double precio){
        Producto nuevoProducto=new Producto(descripcion, precio);
        return nuevoProducto;
    }
    private void ingresarProductos(String descripcion, double precio){
        producto = crearProducto(descripcion,precio);
    }
    @Override
    public String toString(){
        return "Producto{" + "descripcion=" + producto.getDescripcion() + ", precio unitario=" + producto.getPrecio() + ", precio total=" + getTotal()+"}";
    }
    public String reporteDescripcion(){
        String mensaje = "";
        mensaje += "Producto: " + producto.getDescripcion();
        mensaje += " | Unidades " + cantidad;
        mensaje += " | Precio Unitario " + producto.getPrecio();
        mensaje += " | Precio " + total;
        return mensaje;
    }
}
