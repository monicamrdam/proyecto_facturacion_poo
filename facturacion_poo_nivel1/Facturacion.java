import java.util.Scanner;

/**
 * Write a description of class Facturacion here.
 * Clase Main del proyecto facturacion_poo_java
 * @author (monicamrdam) 
 * @version (16/02/2023)
 */
public class Facturacion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Factura factura = new Factura("918273123423", "30/05/2014", "UPC.SAC");
       factura.IngresarDetalleComprobante(1, "Curso Inglés", 1000.0);
       factura.IngresarDetalleComprobante(2, "Caramelos UPC", 20.0);
       factura.IngresarDetalleComprobante(10, "Lapiceros", 0.50);
       factura.setTotal();
       factura.setIGV();
        
       System.out.println(factura.reporteComprobante());   
        
    }
    
}
