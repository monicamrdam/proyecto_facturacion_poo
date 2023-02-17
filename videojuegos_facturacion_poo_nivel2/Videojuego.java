
/**
 * Write a description of class Videojuego here.
 * Clase Videojuego que extiende de Producto
 * @author (monicamrdam) 
 * @version (17/02/2023)
 */
public class Videojuego extends Producto 
{
  private String videoconsola;
  
  public Videojuego(String nombre, double precioUnit, int cantStock, boolean disponible, String videoconsola) {
    super(nombre, precioUnit, cantStock, disponible);
    this.videoconsola = videoconsola;
  }
   public String getVideoconsola() {
    return videoconsola;
  }
  public void setVideoconsola(String videoconsola) {
    this.videoconsola = videoconsola;
  }
  @Override
  public String toString() {
    return  "Articulo de Videoconsolan"+
        super.toString()+
        "Videoconsola: "  +this.videoconsola;
  }
}
