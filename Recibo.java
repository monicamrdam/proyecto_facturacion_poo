
/**
 * Write a description of class Recibo here.
 * Clase recibo que hereda de la Clase Comprobante
 * @author (monicamrdam) 
 * @version (17/02/2023)
 */
public class Recibo extends Comprobante
{
    private String serie;
    
    public Recibo(String serie, String fecha, String razonSocial){
        super(fecha,razonSocial);
        this.serie=serie;
    }
    public String getSerie(){
        return serie;
    }
    public void setSerie(String serie){
        this.serie=serie;
    }
    
}
