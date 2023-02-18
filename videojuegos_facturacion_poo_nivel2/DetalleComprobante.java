
/**
 * Write a description of class DetalleComprobante here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DetalleComprobante {
    private int cantidad;
    private ProductoComprado producto;
    private double total;

    public DetalleComprobante(int cantidad,String descripcion, double precio) {
        this.cantidad = cantidad;
        ingresarProducto(descripcion, precio);
        setTotal();
    }        

    private void setTotal(){
        total = calcularTotal();
    }
    
    public double getTotal() {
        return total;
    }
     public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
            
    public int getCantidad() {
        return cantidad;
    }

    public ProductoComprado getProducto() {
        return producto;
    }
    
    
    private ProductoComprado crearProducto(String descripcion, double precio){
        ProductoComprado nuevoProducto = new ProductoComprado(descripcion, precio);
        return nuevoProducto;
    }
    
    private void ingresarProducto(String descripcion, double precio){
        producto = crearProducto(descripcion, precio);
    }  
    
    private double calcularTotal(){
        return cantidad * producto.getPrecio();
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