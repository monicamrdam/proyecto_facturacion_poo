
/**
 * Write a description of class Cine here.
 * Clase Cine que extiende de Producto
 * @author (monicamrdam) 
 * @version (17/02/2023)
 * Datos incorporados archivo
 * los fabelman; 10.0; 2; true; Steven Spielberg;
 * la niña de la comunion; 20.0; 5; true; Victor Garcia;
 * avatar: el sentido del agua; 30.0; 3; true; James Cameron;
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
