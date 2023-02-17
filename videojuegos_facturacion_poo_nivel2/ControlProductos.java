import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Write a description of class ControlProductos here.
 * Clase gestiona los productos
 * @author (monicamrdam) 
 * @version (17/02/2023)
 */
public class ControlProductos
{
    private static final String NOMBRE_ARCHIVO_MUSICA = "musica.txt";
    private static final String SEPARADOR_CAMPO = "; ";
    private static final String SEPARADOR_REGISTRO = "\n";
    
    private Producto productos[] = null;
  private double caja;
  
  //Constructors
  public ControlProductos() { }
  public ControlProductos(Producto[] productos) {
    this.productos = productos;
  }
  
  public static void solicitarDatosParaRegistrar(){
      Scanner sc = new Scanner(System.in);
      String opcion="";
      System.out.println("\nQue tipo de producto es:\n"
      +"1. Cine \n"
      +"2. Musica \n"
      +"3. Videojuegos \n");            
      opcion=sc.nextLine();
      switch(opcion){
            case "1":
                System.out.println("Has seleccionado insertar producto: cine");
                break;
            case "2":
                System.out.println("Has seleccionado insertar producto: musica");
                ControlProductos.solicitarDatosParaRegistrarMusica();
                break;
            case "3":
                System.out.println("Has seleccionado insertar producto: videojuegos");
                break;
            default:
                System.out.println("Has seleccionado una opción incorrecta");
            }
        
    }
  
    private static boolean isDouble(String cadena){
	try {
		Double.parseDouble(cadena);
		return true;
	} catch (NumberFormatException nfe){
		return false;
	}
}
    private static boolean isInt(String cadena){
	try {
		Integer.parseInt(cadena);
		return true;
	} catch (NumberFormatException nfe){
		return false;
	}
}
  
  public static void solicitarDatosParaRegistrarMusica() {
        Scanner sc = new Scanner(System.in);
              System.out.println("Ingrese el nombre: ");
          String nombre= sc.nextLine();
          String precioUnit;
          do{
              System.out.println("Ingrese precio de la unidad: ");
              precioUnit = sc.nextLine();
          }while(!ControlProductos.isDouble(precioUnit));
          String cantStock;
          do{
              System.out.println("Ingrese la cantidad de productos: ");
              cantStock = sc.nextLine();
          }while(!ControlProductos.isInt(cantStock));
          String disponible="";
          String respuesta;
          do{

              System.out.println("Ingrese si esta disponible: (si/no) ");
              respuesta= sc.nextLine();
              if (Character.toUpperCase(respuesta.charAt(0))=='S'){
                 disponible="true";
              }else if(Character.toUpperCase(respuesta.charAt(0))=='N'){
                  disponible="false";
              }else{
                  System.out.print("Opcion incorrecta");
              }
    
          }while(!(disponible.equals("true") || disponible.equals("false")));
          
          
          
        System.out.println("Ingrese el cantante: ");
        String cantante = sc.nextLine();
        ControlProductos.registrar(new Musica(nombre, Double.parseDouble(precioUnit), Integer.parseInt(cantStock),Boolean.parseBoolean(disponible),cantante));
        System.out.println("Registrado exitosamente");
    }

  public static void registrar(Musica musica) {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(NOMBRE_ARCHIVO_MUSICA, true));
            bufferedWriter.write(musica.getNombre() + SEPARADOR_CAMPO + musica.getPrecioUnit() + SEPARADOR_CAMPO
                    + musica.getCantStock() + SEPARADOR_CAMPO + musica.isDisponible() + SEPARADOR_CAMPO+ musica.getCantante() + SEPARADOR_REGISTRO );
            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println("Error escribiendo en archivo: " + e.getMessage());
        }
    }
    
    
    

   public void mostrarProductos(Producto[] productos) { 
      for (int i = 0; i < productos.length; i++) {
        System.out.print(productos[i]+"n-------n");
      }
  }
   public void mostrarNombreProductos(Producto[] productos) { 
      for (int i = 0; i < productos.length; i++) {
        System.out.println(i+1 +" "+productos[i].getNombre()+"n");
      }
      System.out.println("n------------n");
  } 
  public double comprarProducto(Producto[] productos, int num, int cantidadUnidades) {
    if (productos[num-1].isDisponible()) {
      if (productos[num-1].getCantStock() >= cantidadUnidades){
        System.out.println("La compra se ha realizado con éxito!!n");
        productos[num -1].setCantStock(productos[num -1].getCantStock()-cantidadUnidades);
        return caja+=cantidadUnidades*productos[num-1].getPrecioUnit();
      } else {System.out.println("No hay cantidad suficiente de producto");}
    } else {System.out.println("No hay cantidad suficiente de producto");}
    return caja;
  }
   public double mostrarCaja() {
    System.out.print("El total de la caja es ");
    caja=Math.round(caja*100);
    return caja/100;
  } 
}
