import java.util.Scanner;

/**
 * Write a description of class TiendaVideojuegos here.
 * Clase Main
 * @author (monicamrdam) 
 * @version (17/02/2023)
 */
public class TiendaVideojuegos
{
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        String opcion="";

        do{
            System.out.println("\nIntroduzca la opción que desea realizar:\n"
                +"1. Insertar Productos \n"
                +"2. Mostrar productos \n"
                +"3. Vender productos \n"
                +"4. Mostrar caja\n"
                +"5. Emitir factura\n"
                +"0. Salir\n"
            );            
            opcion=sc.nextLine();
            switch(opcion){
                case "1":
                    System.out.println("Has seleccionado insertar productos");
                    ControlProductos.solicitarDatosParaRegistrar();
                    break;
                case "2":
                    System.out.println("Has seleccionado mostrar productos");
                    ControlProductos.mostrarProductos();
                    break;
                case "3":
                    System.out.println("Has seleccionado comprar productos");
                    ControlProductos.comprarProductos();
                    break;
                case "4":
                    System.out.println("Has seleccionado mostrar caja");
                    break;
                case "5":
                    System.out.println("Has seleccionado emitir factura");
                    break;
                case "0":
                    break;
                default:
                    System.out.println("Has seleccionado una opción incorrecta");
            }
        }while(!opcion.equals("0"));
        System.out.println("Programa finalizado");

    }
}
