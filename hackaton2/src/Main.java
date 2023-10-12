import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //Inicializar el scanner para pedir
        Scanner input = new Scanner(System.in);

        //Interacción con el usuario
        System.out.println("¡Saludos! ¿Cuál es tu nombre?: ");
        String usuario = input.nextLine();
        System.out.println("Un placer tenerte por aquí " + usuario);
        System.out.print("Para iniciar, primero ingrese el tamaño de la agenda: ");
        int capacidad = input.nextInt();

        //creamos la agenda
        Agenda agenda = new Agenda(capacidad);

        while (true) {
            System.out.println("--- Menú de Opciones ---");
            System.out.print("Seleccione una opción según la opción que desee ejecutar: \n");
            System.out.println("1. Agregar contacto");
            System.out.println("2. Mostrar lista de contactos");
            System.out.println("3. Buscar contacto");
            System.out.println("4. Borrar contacto");
            System.out.println("5. Ver espacio disponible");
            System.out.println("6. Verificar si la agenda está llena");
            System.out.println("7. Salir");

            int opcion = input.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Por favor ingresa el nombre del contacto: ");
                    input.nextLine();
                    String nombre = input.nextLine().toUpperCase();
                    System.out.println("Por favor ingresa el numero del contacto: ");
                    //input.nextLine();
                    String numero = input.next();
                    Contacto contacto = new Contacto(nombre, numero);
                    agenda.añadirContacto(contacto, capacidad);
                    break;
                case 2:
                    agenda.ListarContactos();
                    break;
                case 3:
                    System.out.print("Ingresa el nombre completo que quieres buscar: ");
                    input.nextLine();
                    String nombreCompleto = input.nextLine().toUpperCase();
                    agenda.buscaContacto(nombreCompleto);
                    break;
                case 4:
                    System.out.print("Ingresa el nombre completo que quieres eliminar: ");
                    input.nextLine();
                    String nombreCompleto2 = input.nextLine().toUpperCase();
                    String respuesta = agenda.deleteContacto(nombreCompleto2);
                    System.out.println(respuesta);
                    break;
                case 5:
                    System.out.println("Espacio disponible: " + agenda.espacioLibre(capacidad) + " para agregar contactos.");
                    break;
                case 6:
                    agenda.AgendaLlena(capacidad);
                    break;
                case 7:
                    System.out.println("¡Adiós!");
                    input.close();
                    System.exit(0);

                default:
                    System.out.println("Opción no válida. Por favor, elija una opción válida.");
            }
            System.out.println("\nPresione Enter para continuar...");
            input.nextLine();
            input.nextLine();
        }
    }
}