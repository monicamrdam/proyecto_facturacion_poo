
/**
 * Write a description of class Recibo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Recibo extends Comprobante{
    private String serie; 
    public Recibo(String serie, String fecha, String razonSocial) {
        super(fecha, razonSocial);
        this.serie = serie;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    @Override
    public String reporteComprobante() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
   
}