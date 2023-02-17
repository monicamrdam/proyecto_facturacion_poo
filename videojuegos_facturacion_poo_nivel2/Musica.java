
/**
 * Write a description of class Musica here.
 * Clase Musica que extiende de Producto
 * @author (monicamrdam) 
 * @version (17/02/2023)
 */
public class Musica extends Producto 
{
  private String cantante;
  
  public Musica(CaracteristicasProductos cproducto, String cantante) {
    super(cproducto);
    this.cantante = cantante;
  }
   public String getCantante() {
    return cantante;
  }
  public void setCantante(String cantante) {
    this.cantante = cantante;
  }
  @Override
  public String toString() {
    return  "Articulo de Musica \n"+
        super.toString()+
        "Cantante: "  +this.cantante;
  }
}
