import java.util.ArrayList;

/**
 * Write a description of class Comprobante here.
 * Clase Comprobante
 * @author (monicamrdam) 
 * @version (17/02/2023)
 */
public abstract class Comprobante
{
   protected String fecha;
   protected String razonSocial;
   protected ArrayList<DetalleComprobante> detalles;
   
   public Comprobante(String fecha, String razonSocial){
        this.fecha=fecha;
        this.razonSocial=razonSocial;
        detalles= new ArrayList<>();
       
   }
   private DetalleComprobante crearDetalleComprobante(int cantidad, String descripcion,double precio){
       DetalleComprobante detalle=new DetalleComprobante(cantidad, descripcion, precio);
       return detalle;
   }
   public void IngresarDetalleComprobante(int cantidad,String descripcion, double precio){
        DetalleComprobante detalle = crearDetalleComprobante(cantidad, descripcion, precio);
        detalles.add(detalle);
    }
    public abstract String reporteComprobante();
}
