
/**
 * Write a description of class Cine here.
 * Clase Cine que extiende de Producto
 * @author (monicamrdam) 
 * @version (17/02/2023)
 */
public class Cine extends Producto 
{
  private String director;
  
  public Cine(String nombre, double precioUnit, int cantStock, boolean disponible, String director) {
    super(nombre, precioUnit, cantStock, disponible);
    this.director = director;
  }
   public String getDirector() {
    return director;
  }
  public void setDirector(String director) {
    this.director = director;
  }
  @Override
  public String toString() {
    return  "Articulo de Cinen"+
        super.toString()+
        "Director: "  +this.director;
  }
}
