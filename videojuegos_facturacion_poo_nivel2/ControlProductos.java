import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;

/**
 * Write a description of class ControlProductos here.
 * Clase gestiona los productos
 * @author (monicamrdam) 
 * @version (17/02/2023)
 */
public class ControlProductos
{
    private static final String NOMBRE_ARCHIVO_CINE = "cine.txt";
    private static final String NOMBRE_ARCHIVO_MUSICA = "musica.txt";
    private static final String NOMBRE_ARCHIVO_VIDEOJUEGOS = "videojuegos.txt";
    private static final String SEPARADOR_CAMPO = "; ";
    private static final String SEPARADOR_REGISTRO = "\n";
    private static CaracteristicasProductos cproducto;
    private static Scanner sc = new Scanner(System.in);

    private Producto productos[] = null;
    private double caja;

    //Constructors
    public ControlProductos() { }

    public ControlProductos(Producto[] productos) {
        this.productos = productos;
    }

    public static void solicitarDatosParaRegistrar(){
        String opcion="";
        System.out.println("\nQue tipo de producto es:\n"
            +"1. Cine \n"
            +"2. Musica \n"
            +"3. Videojuegos \n");            
        opcion=sc.nextLine();
        switch(opcion){
            case "1":
                System.out.println("Has seleccionado insertar producto: cine");
                ControlProductos.solicitarDatosParaRegistrarCine();
                break;
            case "2":
                System.out.println("Has seleccionado insertar producto: musica");
                ControlProductos.solicitarDatosParaRegistrarMusica();
                break;
            case "3":
                System.out.println("Has seleccionado insertar producto: videojuegos");
                ControlProductos.solicitarDatosParaRegistrarVideojuegos();
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

    public static CaracteristicasProductos solicitarDatosParaRegistrarProductos() {
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
            if (respuesta.toUpperCase().equals("SI")){
                disponible="true";
            }else if(respuesta.toUpperCase().equals("NO")){
                disponible="false";
            }else{
                System.out.print("Opcion incorrecta");
            }

        }while(!(disponible.equals("true") || disponible.equals("false")));
        cproducto = new CaracteristicasProductos(nombre, Double.parseDouble(precioUnit), Integer.parseInt(cantStock), Boolean.parseBoolean(disponible));
        return cproducto;

    }

    public static String solicitarDatosDirector(){
        System.out.println("Ingrese el director de cine: ");
        String director = sc.nextLine();
        return director;
    }

    public static void registrar(Cine cine) {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(NOMBRE_ARCHIVO_CINE, true));
            bufferedWriter.write(cine.getNombre() + SEPARADOR_CAMPO + cine.getPrecioUnit() + SEPARADOR_CAMPO
                + cine.getCantStock() + SEPARADOR_CAMPO + cine.isDisponible() + SEPARADOR_CAMPO+ cine.getDirector() + SEPARADOR_REGISTRO );
            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println("Error escribiendo en archivo: " + e.getMessage());
        }
    }

    public static void solicitarDatosParaRegistrarCine(){
        ControlProductos.registrar(new Cine(ControlProductos.solicitarDatosParaRegistrarProductos(),ControlProductos.solicitarDatosDirector()));
        System.out.println("Registrado exitosamente");
    }

    public static String solicitarDatosCantante(){
        System.out.println("Ingrese el cantante: ");
        String cantante = sc.nextLine();
        return cantante;
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

    public static void solicitarDatosParaRegistrarMusica(){      
        ControlProductos.registrar(new Musica(ControlProductos.solicitarDatosParaRegistrarProductos(),ControlProductos.solicitarDatosCantante()));
        System.out.println("Registrado exitosamente");
    }

    public static String solicitarDatosVideoconsola(){
        System.out.println("Ingrese la videoconsola: ");
        String videoconsola = sc.nextLine();
        return videoconsola;
    }

    public static void registrar(Videojuego videoconsola) {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(NOMBRE_ARCHIVO_MUSICA, true));
            bufferedWriter.write(videoconsola.getNombre() + SEPARADOR_CAMPO + videoconsola.getPrecioUnit() + SEPARADOR_CAMPO
                + videoconsola.getCantStock() + SEPARADOR_CAMPO + videoconsola.isDisponible() + SEPARADOR_CAMPO+ videoconsola.getVideoconsola() + SEPARADOR_REGISTRO );
            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println("Error escribiendo en archivo: " + e.getMessage());
        }
    }

    public static void solicitarDatosParaRegistrarVideojuegos(){
        ControlProductos.registrar(new Videojuego(ControlProductos.solicitarDatosParaRegistrarProductos(),ControlProductos.solicitarDatosVideoconsola()));
        System.out.println("Registrado exitosamente");
    }

    public static void mostrarProductos(){
        String opcion="";
        System.out.println("\nQue tipo de producto quieres mostrar:\n"
            +"1. Cine \n"
            +"2. Musica \n"
            +"3. Videojuegos \n");            
        opcion=sc.nextLine();
        switch(opcion){
            case "1":
                System.out.println("Has seleccionado mostrar: cine");
                ControlProductos.imprimirCine(ControlProductos.obtenerDatosCine());
                break;
            case "2":
                System.out.println("Has seleccionado mostrar: musica");
                ControlProductos.imprimirMusica(ControlProductos.obtenerDatosMusica());
                break;
            case "3":
                System.out.println("Has seleccionado mostrar: videojuegos");
                ControlProductos.imprimirVideojuego(ControlProductos.obtenerDatosVideojuego());
                break;
            default:
                System.out.println("Has seleccionado una opción incorrecta");
        }

    }

    public static ArrayList<Cine> obtenerDatosCine() {
        ArrayList<Cine> peliculas = new ArrayList<>();
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader(NOMBRE_ARCHIVO_CINE);
            bufferedReader = new BufferedReader(fileReader);
            String linea;
            while ((linea = bufferedReader.readLine()) != null) {
                String[] arrayPelicula = linea.split(SEPARADOR_CAMPO);
                cproducto = new CaracteristicasProductos(arrayPelicula[0],Double.parseDouble(arrayPelicula[1]),Integer.parseInt(arrayPelicula[2]), Boolean.parseBoolean( arrayPelicula[3]));
                peliculas.add(new Cine(cproducto,arrayPelicula[4]));
            }
        } catch (IOException e) {
            System.out.println("Excepción leyendo archivo: " + e.getMessage());
        } finally {
            try {
                if (fileReader != null) {
                    fileReader.close();
                }
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            } catch (IOException e) {
                System.out.println("Excepción cerrando: " + e.getMessage());
            }
            return peliculas;
        }
    }

    public static void imprimirCine(ArrayList<Cine> peliculas) {
        ArrayList<Cine> pelicula = ControlProductos.obtenerDatosCine();
        System.out.println(
            "+-----+----------+----------------------------------------+----------------------------------------+--------------------+");
        System.out.printf("|%-40s|%-15s|%-15s|%-10s|%-40s|\n", "Nombre", "precioUnit", "cantStock", "disponible","Director");
        System.out.println(
            "+-----+----------+----------------------------------------+----------------------------------------+--------------------+");
        for (int x = 0; x < pelicula.size(); x++) {
            Cine cine = pelicula.get(x);
            System.out.printf("|%-40s|%-15s|%-15s|%-10s|%-40s|\n", cine.getNombre(), cine.getPrecioUnit(),cine.getCantStock(),cine.isDisponible(),cine.getDirector() );
            System.out.println(
                "+-----+----------+----------------------------------------+----------------------------------------+--------------------+");
        }
    }

    public static ArrayList<Musica> obtenerDatosMusica() {
        ArrayList<Musica> canciones = new ArrayList<>();
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader(NOMBRE_ARCHIVO_MUSICA);
            bufferedReader = new BufferedReader(fileReader);
            String linea;
            while ((linea = bufferedReader.readLine()) != null) {
                String[] arrayCanciones = linea.split(SEPARADOR_CAMPO);
                cproducto = new CaracteristicasProductos(arrayCanciones[0],Double.parseDouble(arrayCanciones[1]),Integer.parseInt(arrayCanciones[2]), Boolean.parseBoolean( arrayCanciones[3]));
                canciones.add(new Musica(cproducto,arrayCanciones[4]));
            }
        } catch (IOException e) {
            System.out.println("Excepción leyendo archivo: " + e.getMessage());
        } finally {
            try {
                if (fileReader != null) {
                    fileReader.close();
                }
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            } catch (IOException e) {
                System.out.println("Excepción cerrando: " + e.getMessage());
            }
            return canciones;
        }
    }

    public static void imprimirMusica(ArrayList<Musica> canciones) {
        ArrayList<Musica> cancion = ControlProductos.obtenerDatosMusica();
        System.out.println(
            "+-----+----------+----------------------------------------+----------------------------------------+--------------------+");
        System.out.printf("|%-40s|%-15s|%-15s|%-10s|%-40s|\n", "Nombre", "precioUnit", "cantStock", "disponible","Cantante");
        System.out.println(
            "+-----+----------+----------------------------------------+----------------------------------------+--------------------+");
        for (int x = 0; x < cancion.size(); x++) {
            Musica musica = cancion.get(x);
            System.out.printf("|%-40s|%-15s|%-15s|%-10s|%-40s|\n",musica.getNombre(), musica.getPrecioUnit(),musica.getCantStock(),musica.isDisponible(),musica.getCantante() );
            System.out.println(
                "+-----+----------+----------------------------------------+----------------------------------------+--------------------+");
        }
    }

    public static ArrayList<Videojuego> obtenerDatosVideojuego() {
        ArrayList<Videojuego> videojuegos = new ArrayList<>();
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader(NOMBRE_ARCHIVO_VIDEOJUEGOS);
            bufferedReader = new BufferedReader(fileReader);
            String linea;
            while ((linea = bufferedReader.readLine()) != null) {
                String[] arrayVideojuegos = linea.split(SEPARADOR_CAMPO);
                cproducto = new CaracteristicasProductos(arrayVideojuegos[0],Double.parseDouble(arrayVideojuegos[1]),Integer.parseInt(arrayVideojuegos[2]), Boolean.parseBoolean(arrayVideojuegos[3]));
                videojuegos.add(new Videojuego(cproducto,arrayVideojuegos[4]));
            }
        } catch (IOException e) {
            System.out.println("Excepción leyendo archivo: " + e.getMessage());
        } finally {
            try {
                if (fileReader != null) {
                    fileReader.close();
                }
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            } catch (IOException e) {
                System.out.println("Excepción cerrando: " + e.getMessage());
            }
            return videojuegos;
        }
    }

    public static void imprimirVideojuego(ArrayList<Videojuego> videojuegos) {
        ArrayList<Videojuego> videojuego = ControlProductos.obtenerDatosVideojuego();
        System.out.println(
            "+-----+----------+----------------------------------------+----------------------------------------+--------------------+");
        System.out.printf("|%-40s|%-15s|%-15s|%-10s|%-40s|\n", "Nombre", "precioUnit", "cantStock", "disponible","Videoconsola");
        System.out.println(
            "+-----+----------+----------------------------------------+----------------------------------------+--------------------+");
        for (int x = 0; x < videojuego.size(); x++) {
            Videojuego videojue = videojuego.get(x);
            System.out.printf("|%-40s|%-15s|%-15s|%-10s|%-40s|\n", videojue.getNombre(), videojue.getPrecioUnit(),videojue.getCantStock(),videojue.isDisponible(),videojue.getVideoconsola() );
            System.out.println(
                "+-----+----------+----------------------------------------+----------------------------------------+--------------------+");
        }
    }

    public static void comprarProductos(){
        String opcion="";
        System.out.println("\nQue tipo de producto quieres comprar:\n"
            +"1. Cine \n"
            +"2. Musica \n"
            +"3. Videojuegos \n");            
        opcion=sc.nextLine();
        switch(opcion){
            case "1":
                System.out.println("Has seleccionado comprar: cine");
                ControlProductos.mostrarnombreCine();
                ControlProductos.comprarProducto(ControlProductos.solicitarProductoComprarCine(),ControlProductos.solicitarCantidadComprarCine());
                break;
            case "2":
                System.out.println("Has seleccionado comprar: musica");
                ControlProductos.imprimirMusica(ControlProductos.obtenerDatosMusica());
                break;
            case "3":
                System.out.println("Has seleccionado comprar: videojuegos");
                ControlProductos.imprimirVideojuego(ControlProductos.obtenerDatosVideojuego());
                break;
            default:
                System.out.println("Has seleccionado una opción incorrecta");
        }

    }

    public static void mostrarnombreCine(){
        ArrayList<String> peliculas = new ArrayList<String>();
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader(NOMBRE_ARCHIVO_CINE);
            bufferedReader = new BufferedReader(fileReader);
            String linea;
            while ((linea = bufferedReader.readLine()) != null) {
                String[] arrayPelicula = linea.split(SEPARADOR_CAMPO);
                peliculas.add(arrayPelicula[0]);
            }
        } catch (IOException e) {
            System.out.println("Excepción leyendo archivo: " + e.getMessage());
        } finally {
            try {
                if (fileReader != null) {
                    fileReader.close();
                }
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            } catch (IOException e) {
                System.out.println("Excepción cerrando: " + e.getMessage());
            }
        }
        System.out.println("Listado de cine en el catálogo");
        for (int x = 0; x < peliculas.size(); x++) {

            System.out.println(
                "+-----+----------+---------------------------------+");
            System.out.printf("|%-40s|\n", peliculas.get(x));
        }
    }

    public static String solicitarProductoComprarCine(){
        System.out.println("¿Qué producto desea comprar?: ");
        String productoComprar = sc.nextLine();
        return productoComprar;
    }

    public static int solicitarCantidadComprarCine(){
        String cantContomprar;
        do{
            System.out.println("¿Qué cantidad desea comprar?: ");
            cantContomprar = sc.nextLine();
        }while(!ControlProductos.isInt(cantContomprar));
        return Integer.parseInt(cantContomprar);
    }

    public static void comprarProducto(String productoComprar, int cantidadComprar){
        ArrayList<Cine> peliculaComprar = new ArrayList<>();
        ArrayList<String> todaslineas= new ArrayList<>();
        String nuevalinea="";
        FileReader fileReader = null;
        FileWriter fileWriter=null;
        BufferedReader bufferedReader = null;
        BufferedWriter buffereWriter = null;
        try {
            fileReader = new FileReader(NOMBRE_ARCHIVO_CINE);
            bufferedReader = new BufferedReader(fileReader);
            String linea;
            while ((linea = bufferedReader.readLine()) != null) {
                if(linea.contains(productoComprar)){
                    System.out.println("ProductoComprar " + productoComprar + ": " + linea);
                    String[] arrayPelicula = linea.split(SEPARADOR_CAMPO);
                    double precioUnit=Double.parseDouble(arrayPelicula[1]);
                    int cantStock=Integer.parseInt(arrayPelicula[2]);
                    String disponible=arrayPelicula[3];
                    String director=arrayPelicula[4];

                    if(cantStock < cantidadComprar){
                        disponible= "false";
                        System.out.print("No es posible comprar esa cantidad, actualmente hay solo disponible:  " +  cantStock);
                    }else{
                        cantStock -= cantidadComprar;
                        ControlProductos.gananciasVentas(productoComprar,precioUnit, cantidadComprar);
                    } 
                    nuevalinea=(productoComprar +String.valueOf(precioUnit) + String.valueOf(cantStock)+ disponible + director);
                    todaslineas.add(nuevalinea);
                }
                System.out.print("tamaño todaslineas" + todaslineas.size());
                todaslineas.add(linea);

            }
        } catch (IOException e) {
            System.out.println("Excepción leyendo archivo: " + e.getMessage());
        } finally {
            try {
                if (fileReader != null) {
                    fileReader.close();
                }
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            } catch (IOException e) {
                System.out.println("Excepción cerrando: " + e.getMessage());
            }
        }
         System.out.println("Listado");
            for (int x = 0; x < todaslineas.size(); x++) {

                System.out.println(
                    "+-----+----------+---------------------------------+");
                System.out.printf("|%-40s|\n", todaslineas.get(x));
            }
    }

    public static double gananciasVentas(String productoComprado,double precioUnit, int cantidadComprar){
        double caja=0;
        return caja;
    }
}

