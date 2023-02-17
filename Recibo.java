
/**
 * Write a description of class Recibo here.
 * Clase recibo que hereda de la Clase Comprobante
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Recibo extends Comprobante
{
    private String serie;
    
    public Recibo(String serie, String fecha, String razonSocial){
        super(fecha,razonSocial);
        this.serie=serie;
    }
}
