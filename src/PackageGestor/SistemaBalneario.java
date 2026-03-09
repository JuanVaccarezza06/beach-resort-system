package PackageGestor;

import PackageEnumeradores.TipoContrato;
import PackageException.DatoNulo;
import PackageGenerico.Almacenamiento;
import PackageJSONUtiles.JSONUtiles;
import PackageModelos.*;

import PackagePersonal.*;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SistemaBalneario {

    private String nombreBalneario;

    //CONSTRUCTOR
    public SistemaBalneario(String nombreBalneario) {
        this.nombreBalneario = nombreBalneario;
    }

    //GET Y SET
    public String getNombreBalneario() {
        return nombreBalneario;
    }

    public void setNombreBalneario(String nombreBalneario) {
        this.nombreBalneario = nombreBalneario;
    }

    //METODOS PROPIOS

    //METODO DE BIENVENIDA
    public String Bienvenida() {
        return "Bienvenido al sistema de gestion";
    }

    //METODO DE MOSTRAR MENU
    public void mostrarMenu() {

        // Informacion del balneario

        Almacenamiento<Servicio> NuestrosServicios = new Almacenamiento<>();
        Almacenamiento<Cochera> NuestrasCocheras = new Almacenamiento<>();
        Almacenamiento<AsistenciaPasillo> NuestrosPuestos = new Almacenamiento<>();
        Almacenamiento<Puesto> NuestrosPlayeros = new Almacenamiento<>();
        Almacenamiento<Medico> NuestrosMedicos = new Almacenamiento<>();

        //Historial del balneario

        Almacenamiento<Reserva> HistorialReservas = new Almacenamiento<>();
        Almacenamiento<Empleado> HistoriaEmpleados = new Almacenamiento<>();

        // Informacion actual

        Almacenamiento<Reserva> ReservasData = new Almacenamiento<>();
        Almacenamiento<Cliente> ClientesData = new Almacenamiento<>();
        Almacenamiento<Empleado> EmpleadosData = new Almacenamiento<>();


        //A partir de aqui, cargo todos los json, en sus debidas colecciones.java, todo hecho desde
        // la clase generica!

        String a = "NuestrosServicios.json";
        String a1 = "NuestrasCocheras.json";
        String a2 = "NuestrosPuestos.json";
        String a3 = "NuestrosPlayeros.json";
        String a4 = "NuestrosMedicos.json";
        String a5 = "HistorialReservas.json";
        String a6 = "HistoriaEmpleados.json";
        String a7 = "ReservasData.json";
        String a8 = "ClientesData.json";
        String a9 = "EmpleadosData.json";

        JSONArray arreglo = JSONUtiles.guardarArchivoEnJSONArray(a);
        NuestrosServicios.cargarServicio(arreglo);

        // Levanta el archivo.json (archivo que esta guardado en el mp3/disco)
        // En este caso levanta el archivo NuestrosServicios.json, lo guarda en un JSONArray
        // llamado arreglo(va tomando distintos valores por cada archivo, no hace falta crear
        // un JSONArray por cada archivo/BDD) luego de guardarlo, se llama al metodo cargar...
        // que lo que hacer es ese archivo que ahora es un JSONArray, pasa a objeto.java(convierte
        // de json a java)

        arreglo = JSONUtiles.guardarArchivoEnJSONArray(a1);
        NuestrasCocheras.cargarCocheras(arreglo);

        arreglo = JSONUtiles.guardarArchivoEnJSONArray(a2);
        NuestrosPuestos.cargarPuestos(arreglo);

        arreglo = JSONUtiles.guardarArchivoEnJSONArray(a3);
        NuestrosPlayeros.cargarAsistencia(arreglo);

        arreglo = JSONUtiles.guardarArchivoEnJSONArray(a4);
        NuestrosMedicos.cargarMedicos(arreglo);

        arreglo = JSONUtiles.guardarArchivoEnJSONArray(a5);
        HistorialReservas.cargarReservas(arreglo);

        arreglo = JSONUtiles.guardarArchivoEnJSONArray(a6);
        HistoriaEmpleados.cargarEmpleados(arreglo);

        arreglo = JSONUtiles.guardarArchivoEnJSONArray(a7);
        ReservasData.cargarReservas(arreglo);

        arreglo = JSONUtiles.guardarArchivoEnJSONArray(a8);
        ClientesData.cargarClientes(arreglo);

        arreglo = JSONUtiles.guardarArchivoEnJSONArray(a9);
        EmpleadosData.cargarEmpleados(arreglo);

        Scanner scanner = new Scanner(System.in);
        int opc = 0;

        do {

            System.out.println("\n--- Gestion de Balneario");
            System.out.println("1. Gestionar Reserva");
            System.out.println("2. Gestionar Servicios");
            System.out.println("3. Atencion Medica");
            System.out.println("4. Bonus Track");
            System.out.println("5. Salir");

            opc = scanner.nextInt();

                switch (opc) {

                    case 1:
                        int opc2 = 0;
                        do{

                            System.out.println("\n--- Gestionar Reserva");
                            System.out.println("1. Crear Reserva");
                            System.out.println("2. Consultar Reserva");
                            System.out.println("3. Actualizar reserva");
                            System.out.println("4. Eliminar Reserva");
                            System.out.println("5. Salir");

                            scanner.nextLine();
                            opc2 = scanner.nextInt();

                            switch (opc2) {

                                case 1:

                                    Cliente c = pedirDatosCliente(scanner);
                                    // Guardamos los datos del cliente, y una vez guardados ya se los
                                    // pasamos a la reserva que va a realizar este cliente, de paso
                                    // les mostramos los mejores servicios que tenes (para no mostrar todos)

                                    System.out.println("Estos son nuestros mejores servicios!");
                                    // Muestra manualmente los 10 mejor servicios!
                                    System.out.println(NuestrosServicios.verVentanillaEspe("5EAA2"));
                                    System.out.println(NuestrosServicios.verVentanillaEspe("2027E"));
                                    System.out.println(NuestrosServicios.verVentanillaEspe("D0214"));
                                    System.out.println(NuestrosServicios.verVentanillaEspe("B0EC3"));
                                    System.out.println(NuestrosServicios.verVentanillaEspe("875F9"));
                                    System.out.println(NuestrosServicios.verVentanillaEspe("18D0D"));
                                    System.out.println(NuestrosServicios.verVentanillaEspe("D4DDA"));
                                    System.out.println(NuestrosServicios.verVentanillaEspe("3788D"));
                                    System.out.println(NuestrosServicios.verVentanillaEspe("E15F5"));
                                    System.out.println(NuestrosServicios.verVentanillaEspe("73F55"));
                                    System.out.println("Presione cualquier tecla para continuar...");
                                    scanner.nextLine();

                                    Reserva r = pedirDatosReserva(scanner, c);
                                    if (r == null) {
                                        break;
                                    }

                                    try {
                                        ReservasData.agregarObjeto(r);
                                        HistorialReservas.agregarObjeto(r);
                                        ClientesData.agregarObjeto(c);
                                    } catch (DatoNulo e) {
                                        throw new RuntimeException(e);
                                    }

                                    System.out.println("El id de su reserva es: " + r.getId() + "!");
                                    break;

                                case 2:
                                    System.out.println("Ingrese el ID de la reserva que desea ver!");
                                    System.out.println("Si desconoce alguna reserva, presione 1 y le mostrare recomendaciones!\n");
                                    scanner.nextLine();
                                    String idEspe = scanner.nextLine();
                                    if(idEspe.equals("1")){
                                        System.out.println("Estas son algunas de reservas,eliga la que mas le guste!");
                                        System.out.println(ReservasData.verVentanillaEspe("3918A"));
                                        System.out.println(ReservasData.verVentanillaEspe("0E1BC"));
                                        System.out.println(ReservasData.verVentanillaEspe("23322"));
                                        System.out.println(ReservasData.verVentanillaEspe("5896C"));
                                        System.out.println(ReservasData.verVentanillaEspe("0EECA"));
                                        System.out.println(ReservasData.verVentanillaEspe("D4F34"));
                                        System.out.println("...");
                                        idEspe = scanner.nextLine();
                                    }
                                    System.out.println("...");
                                    System.out.println(ReservasData.verVentanillaEspe(idEspe));
                                    break;
                                case 3:

                                    System.out.println("Primero que todo necesito que elija una reserva que actualizar!");
                                    System.out.println("Si tiene alguna en mente ingrese el ID, si no, aqui tiene algunas\n" +
                                            "reservas disponibles, eliga la que mas le guste!");
                                    System.out.println("Estas son algunas de reservas disponibles, eliga la que mas le guste!");
                                    System.out.println(ReservasData.verVentanillaEspe("2DF8E"));
                                    System.out.println(ReservasData.verVentanillaEspe("7CA28"));
                                    System.out.println(ReservasData.verVentanillaEspe("6834D"));
                                    System.out.println(ReservasData.verVentanillaEspe("EE8BA"));
                                    System.out.println(ReservasData.verVentanillaEspe("D4F34"));
                                    System.out.println(ReservasData.verVentanillaEspe("0EECA"));
                                    scanner.nextLine();
                                    System.out.println("...");
                                    String IdReserva = scanner.nextLine();
                                    Reserva reser = ReservasData.buscarObjeto(IdReserva);
                                    String nuevoIdServicio = "";
                                    String nuevoIdCochera = "";
                                    String nuevoIdCliente = "";
                                    String nuevaFechaIn = "";
                                    String nuevaFechaOut = "";
                                    List<String> familiares = new ArrayList<>();
                                    int nuevaDuracion = 0;
                                    TipoContrato nuevoContrato = TipoContrato.DIA; // valor null

                                    int opc3 = 0;
                                    do{

                                       System.out.println("\n--- Actualizar Reserva");
                                       System.out.println("1. Actualizar servicio asociado");
                                       System.out.println("2. Actualizar cochera asignada");
                                       System.out.println("3. Actualizar cliente asignado");
                                       System.out.println("4. Actualizar fecha de ingreso");
                                       System.out.println("5. Actualizar fecha de egreso");
                                       System.out.println("6. Agregar familiares/personas a la reserva");
                                        System.out.println("7. Actualizar duracion de la reserva");
                                       System.out.println("8. Cambiar contrato");
                                       System.out.println("9. Salir");

                                       opc3 = scanner.nextInt();

                                       switch (opc3){

                                           case 1:

                                               System.out.println("Ingrese el nuevo servicio de la reserva:");
                                               System.out.println("Si no sabe cual elegir ingrese 1");
                                               scanner.nextLine();
                                               nuevoIdServicio = scanner.nextLine();
                                               if(nuevoIdServicio.equals("1")){
                                                   System.out.println("Recomendaciones:");
                                                   System.out.println(ReservasData.verVentanillaEspe("2DF8E"));
                                                   System.out.println(ReservasData.verVentanillaEspe("7CA28"));
                                                   System.out.println(ReservasData.verVentanillaEspe("6834D"));
                                                   System.out.println(ReservasData.verVentanillaEspe("EE8BA"));
                                                   System.out.println(ReservasData.verVentanillaEspe("D4F34"));
                                                   System.out.println(ReservasData.verVentanillaEspe("0EECA"));
                                                   nuevoIdServicio = scanner.nextLine();
                                               }
                                               System.out.println("Listo! Si regresa al principio del programa, podra visualizar la reserva actualizada!");
                                               System.out.println("Con este ID: "+reser.getId());
                                               reser.setIdServicio(nuevoIdServicio);
                                            break;

                                           case 2:
                                               System.out.println("Ingrese la nueva cochera de la reserva:");
                                               System.out.println("Si no sabe cual elegir ingrese 1");
                                               scanner.nextLine();
                                               nuevoIdCochera = scanner.nextLine();
                                               if(nuevoIdCochera.equals("1")){
                                                   System.out.println("Recomendaciones:");
                                                   try {
                                                       System.out.println(NuestrasCocheras.verObjeto("40CD4"));
                                                       System.out.println(NuestrasCocheras.verObjeto("9B672"));
                                                       System.out.println(NuestrasCocheras.verObjeto("71EEC"));
                                                       System.out.println(NuestrasCocheras.verObjeto("5378F"));
                                                   } catch (DatoNulo e) {
                                                       throw new RuntimeException(e);
                                                   }
                                                   System.out.println("...");
                                                   nuevoIdCochera = scanner.nextLine();
                                               }
                                               System.out.println("Listo! Si regresa al principio del programa, podra visualizar la reserva actualizada!");
                                               System.out.println("Con este ID: "+reser.getId());
                                               reser.setIdCochera(nuevoIdCochera);

                                               break;

                                           case 3:

                                               System.out.println("Ingrese el nuevo Id del nuevo cliente:");
                                               System.out.println("Si no sabe cual elegir ingrese 1");
                                               scanner.nextLine();
                                               nuevoIdCliente = scanner.nextLine();
                                               if(nuevoIdCliente.equals("1")){
                                                   System.out.println("Recomendaciones:");
                                                   try {
                                                       System.out.println(ClientesData.verObjeto("BF435"));
                                                       System.out.println(ClientesData.verObjeto("75340"));
                                                       System.out.println(ClientesData.verObjeto("E5786"));
                                                       System.out.println(ClientesData.verObjeto("E441C"));
                                                   } catch (DatoNulo e) {
                                                       throw new RuntimeException(e);
                                                   }
                                                   System.out.println("...");
                                                   nuevoIdCliente = scanner.nextLine();
                                               }
                                               System.out.println("Listo! Si regresa al principio del programa, podra visualizar la reserva actualizada!");
                                               System.out.println("Con este ID: "+reser.getId());
                                               reser.setIdCliente(nuevoIdCliente);

                                               break;

                                           case 4:

                                               System.out.println("Ingrese la nueva fecha de ingreso!");
                                               scanner.nextLine();
                                               nuevaFechaIn = scanner.nextLine();
                                               System.out.println("Listo! Si regresa al principio del programa, podra visualizar la reserva actualizada!");
                                               System.out.println("Con este ID: "+reser.getId());
                                               reser.setFechaIngreso(nuevaFechaIn);

                                               break;

                                           case 5:

                                               System.out.println("Ingrese la nueva fecha de egreso!");
                                               scanner.nextLine();
                                               nuevaFechaOut = scanner.nextLine();
                                               System.out.println("Listo! Si regresa al principio del programa, podra visualizar la reserva actualizada!");
                                               System.out.println("Con este ID: "+reser.getId());
                                               reser.setFechaIngreso(nuevaFechaOut);

                                               break;

                                           case 6:

                                               System.out.println("Damos por hecho que la persona que quiere ingresar NO esta en nuestra BDD!" +
                                                       "\nPor eso a continuacion le voy a tomar los datos a la nueva persona!");
                                                scanner.nextLine();
                                               Cliente clientito = pedirDatosCliente(scanner,1);

                                               System.out.println("Listo! Si regresa al principio del programa, podra visualizar la reserva actualizada!");
                                               System.out.println("Con este ID: "+reser.getId());
                                               reser.agregarFamiliares(clientito.getId());

                                               break;

                                           case 7:

                                               System.out.println("Ingrese la nueva cantidad de dias/meses de la reserva:");
                                               scanner.nextLine();
                                               nuevaDuracion = scanner.nextInt();
                                               System.out.println("Listo! Si regresa al principio del programa, podra visualizar la reserva actualizada!");
                                               System.out.println("Con este ID: "+reser.getId());
                                               reser.setDuracionReserva(nuevaDuracion);

                                               break;

                                           case 8:

                                               int z = 0;
                                               System.out.println("Eliga el nuevo contrato de la reserva: ");
                                               System.out.println("1. Dia");
                                               System.out.println("2. Mes");
                                               System.out.println("3. Temporada");
                                               z = scanner.nextInt();

                                               if(z == 1) {
                                                   nuevoContrato = TipoContrato.DIA;
                                               }else if(z == 2){
                                                   nuevoContrato = TipoContrato.MES;
                                               }else if(z == 3){
                                                   nuevoContrato = TipoContrato.TEMPORADA;
                                               }else{
                                                   System.out.println("Numero invalido");
                                               }
                                               System.out.println("Listo! Si regresa al principio del programa, podra visualizar la reserva actualizada!");
                                               System.out.println("Con este ID: "+reser.getId());
                                               reser.setTipoContrato(nuevoContrato);

                                               break;

                                           case 9:

                                               System.out.println("Saliendo...");
                                               break;

                                           default:
                                               System.out.println("Opcion invalida!");
                                               break;
                                       }

                                   }while (opc3!=9);

                                    try {
                                        ReservasData.eliminarObjeto(ReservasData.buscarObjeto(reser.getId()));
                                        ReservasData.agregarObjeto(reser);
                                    } catch (DatoNulo e) {
                                        throw new RuntimeException(e);
                                    } // Al ser un set, eliminar el anterior, agrega el mismo actualizado!

                                    break;

                                case 4:

                                    System.out.println("Ingrese el ID de la reserva a eliminar:");
                                    scanner.nextLine();
                                    String reservaEliminar = scanner.nextLine();
                                    try {
                                        ReservasData.eliminarObjeto(ReservasData.buscarObjeto(reservaEliminar));
                                    } catch (DatoNulo e) {
                                        throw new RuntimeException(e);
                                    }

                                    System.out.println("Eliminado!");
                                    break;

                                case 5:

                                    System.out.println("Saliendo...");
                                    break;

                                default:
                                    System.out.println("Opcion NO valida");
                                    break;
                            }
                        }while (opc2 != 5);

                        break;
                        // Romple el case 1, del switch principal!
                    case 2:
                        int opc4 = 0;
                        do{

                            System.out.println("\n--- Gestionar Servicios");
                            System.out.println("1. Mostrar Servicios Disponibles");
                            System.out.println("2. Mostrar Servicios inhabilitados");
                            System.out.println("3. Mostrar TODOS los servicios");
                            System.out.println("4. Mostrar Servicio Especifico");
                            System.out.println("5. Salir");

                            scanner.nextLine();
                            opc4 = scanner.nextInt();

                            switch (opc4) {
                                case 1:
                                    System.out.println("Estos son nuestros servicios listos para reservar!");
                                    System.out.println(NuestrosServicios.mostrarDisponibles());
                                    System.out.println("Presione cualquier tecla para salir...");
                                    scanner.nextLine();
                                    scanner.nextLine();
                                    System.out.println("Saliendo...");
                                    break;
                                case 2:
                                    System.out.println("Estos son los servicios que temporalmente estan inhabilitados! \nPuede ser tanto por problemas en el servicio, o porque simplemente estan ocupados!");
                                    System.out.println(NuestrosServicios.mostrarInhabilitados());
                                    System.out.println("Presione cualquier tecla para salir...");
                                    scanner.nextLine();
                                    scanner.nextLine();
                                    System.out.println("Saliendo...");
                                    break;

                                case 3:
                                    System.out.println("Estos son TODOS los servicios que contamos en nuestro balneario!\n");
                                    try {
                                        System.out.println(NuestrosServicios.verTodaVentanilla());
                                    } catch (DatoNulo e) {
                                        throw new RuntimeException(e);
                                    }
                                    break;
                                case 4:
                                    System.out.println("Ingrese el ID del servicio que desea ver!");
                                    scanner.nextLine();
                                    String idEspe = scanner.nextLine();
                                    System.out.println( NuestrosServicios.verVentanillaEspe(idEspe));
                                    break;
                                case 5:
                                    System.out.println("Saliendo...");
                                    break;
                                default:
                                    System.out.println("Opcion NO valida");
                                    break;
                            }
                        }while (opc4 != 5);

                        break;// Rompe el case 3 del switch principal!

                    case 3:
                        System.out.println("\n--- Atencion Medica");

                        System.out.println("Contamos con mas de 8 medicos profesionales de toda la argentina!\n" +
                                           "Tenemos una organizacion medica tal que en todo momento tenemos medicos" +
                                           "disponibles! de igual manera nuestros playeros y guardavidas estan " +
                                           "capacitados para cualquier eventualidad! Gracias!");

                        System.out.println("Doctores:\n");
                        try {
                            System.out.println(NuestrosMedicos.verTodaVentanilla());
                        } catch (DatoNulo e) {
                            throw new RuntimeException(e);
                        }

                        System.out.println("Presione cualquier tecla para regresar...");
                        scanner.nextLine();
                        scanner.nextLine();
                        System.out.println("Saliendo...");

                        break; // Rompe el case 3 del switch principal!

                    case 4:

                        System.out.println("\n--- Bonus track");
                        System.out.println("1. Verificar si emplead");
                        System.out.println("2. Mostrar Servicios inhabilitados");
                        System.out.println("3. Mostrar TODOS los servicios");
                        System.out.println("4. Mostrar Servicio Especifico");
                        System.out.println("5. Salir");

                        break;

                } //Aca termina el switch principal!

            }while (opc!=5); //Aca termina el while principal!


        // Guarda en un array vacio, todos los datos de X base de datos, en este caso
        // la BDD de nuestros servicios, luego ese array lo sube a un archivo llamado
        // "NuestrosServicios.json", y listo

        JSONArray array = NuestrosServicios.guardarServicios();
        JSONUtiles.writeInFile(array, a1);

        array = NuestrasCocheras.guardarCocheras();
        JSONUtiles.writeInFile(array, a1);

        array = NuestrosPuestos.guardarPuestos();
        JSONUtiles.writeInFile(array, a2);

        array = NuestrosPlayeros.guardarPlayeros();
        JSONUtiles.writeInFile(array, a3);

        array = NuestrosMedicos.guardarMedicos();
        JSONUtiles.writeInFile(array, a4);

        array = HistorialReservas.guardarReservas();
        JSONUtiles.writeInFile(array, a5);

        array = HistoriaEmpleados.guardarEmpleados();
        JSONUtiles.writeInFile(array, a6);

        array = ReservasData.guardarReservas();
        JSONUtiles.writeInFile(array, a7);

        array = ClientesData.guardarClientes();
        JSONUtiles.writeInFile(array, a8);

        array = EmpleadosData.guardarEmpleados();
        JSONUtiles.writeInFile(array, a9);

        // Aqui termina el metodo principal, al termina carga toda la informacion que se cambió a los archivos
        // .json!!
    }

    private Cliente pedirDatosCliente(Scanner scanner) {
        System.out.println(
                "Para disfrutar juntos el verano! Necesitamos sus datos!\n" +
                        "Usted sera el titular de esta reserva, no lo olvide!\n");

        // Pedir al cliente su nombre completo
        scanner.nextLine();
        System.out.print("Ingrese su nombre completo: ");
        String nombreCompleto = scanner.nextLine();

        // Pedir al cliente su número de teléfono
        System.out.print("Ingrese su número de teléfono: ");
        String numeroTelefono = scanner.nextLine();

        // Pedir al cliente su correo electrónico
        System.out.print("Ingrese su correo electrónico: ");
        String email = scanner.nextLine();

        // Pedir al cliente su lugar de origen
        System.out.print("Ingrese su lugar de origen: ");
        String origen = scanner.nextLine();

        // Pedir al cliente su DNI
        System.out.print("Ingrese su DNI: ");
        String dni = scanner.nextLine();

        //Cargamos los datos en un Objeto tipo Cliente, y lo retornamos !
        Cliente c = new Cliente(true, nombreCompleto, numeroTelefono, email, origen, dni);

        return c;
    }

    private Cliente pedirDatosCliente(Scanner scanner, int a) {

        // Pedir al cliente su nombre completo
        System.out.print("Ingrese su nombre completo: ");
        String nombreCompleto = scanner.nextLine();

        // Pedir al cliente su número de teléfono
        System.out.print("Ingrese su número de teléfono: ");
        String numeroTelefono = scanner.nextLine();

        // Pedir al cliente su correo electrónico
        System.out.print("Ingrese su correo electrónico: ");
        String email = scanner.nextLine();

        // Pedir al cliente su lugar de origen
        System.out.print("Ingrese su lugar de origen: ");
        String origen = scanner.nextLine();

        // Pedir al cliente su DNI
        System.out.print("Ingrese su DNI: ");
        String dni = scanner.nextLine();

        //Cargamos los datos en un Objeto tipo Cliente, y lo retornamos !
        Cliente c = new Cliente(true, nombreCompleto, numeroTelefono, email, origen, dni);

        return c;
    }

    private Reserva pedirDatosReserva(Scanner scanner, Cliente c) {

        // Pedimos identificador del servicio que quiere reservar, y tambien le damos
        // la opcion de volver hacia atras!
        System.out.println("Ingrese el ID del servicio que mas le llame la atencion!\n");
        System.out.println("Puede volver hacia atras ingresando la palabra 'VOLVER' \n");

        String IdDelServicio = scanner.nextLine();
        if (IdDelServicio.equals("Volver") || IdDelServicio.equals("volver") || IdDelServicio.equals("VOLVER")) {
            return null; // Si el usurio escribe "volver", vuelve hacia atras! Retornando null!
        }

        // Preguntar qué tipo de contrato desea
        System.out.print("¿Qué tipo de contrato prefiere?\n");
        System.out.println("1. Quiero alquilar por dia!");
        System.out.println("2. Quiero alquilar por mes!");
        System.out.println("3. Quiero alquilar toda la temporada!");

        int TipoDeAlquiler = scanner.nextInt();
        int cantidadTiempoDelAlquiler = 0;
        TipoContrato TipoDeContrato = TipoContrato.TEMPORADA; // LE DAMOS VALOR PREDETERMINADO!

        if (TipoDeAlquiler == 1) {
            TipoDeContrato = TipoContrato.DIA;
            System.out.println("Perfecto! Usted desea alquilar por dia. Cuantos?");
            cantidadTiempoDelAlquiler = scanner.nextInt();
        } else if (TipoDeAlquiler == 2) {
            TipoDeContrato = TipoContrato.MES;
            System.out.println("Perfecto! Usted desea alquilar por mes. Cuantos?");
            System.out.println("Ingrese la cantidad en meses o dias, como lo prefiera!");
            cantidadTiempoDelAlquiler = scanner.nextInt();
        } else if (TipoDeAlquiler == 3) {
            // Si presiono 3 no configuro nada, ya que el predeterminado ya es TEMPORADA!
            System.out.println("Perfecto! Usted desea reservar por temporada. Se tomaran\n" +
                               "de manera legal 90 dias.\n" +
                               "El balneario está abierto desde el 20/11/2024 hasta el dia\n" +
                               "20/03/2025! Puede acceder siempre y cuando estemos disponibles\n"+
                               "¡DISFRUTE SU VERANO! \n");
                cantidadTiempoDelAlquiler = 90;
        }
        // Este tipo de return es un recomendado por java!
        return new Reserva(c.getId(), IdDelServicio, "ASFSD2", cantidadTiempoDelAlquiler, TipoDeContrato, "20/20/2024", "20/20/2024");
    }
}
