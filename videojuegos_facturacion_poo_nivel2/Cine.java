
/**
 * Write a description of class Cine here.
 * Clase Cine que extiende de Producto
 * @author (monicamrdam) 
 * @version (17/02/2023)
 */
public class Cine extends Producto 
{
  private String director;
  
  public Cine(CaracteristicasProductos cproducto, String director) {
    super(cproducto);
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
    return  "Articulo de Cine \n"+
        super.toString()+
        "Director: "  +this.director;
  }
}
