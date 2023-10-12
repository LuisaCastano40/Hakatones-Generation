import java.util.HashSet;
import java.util.Set;

public class Agenda {

    //Inicializamos la colección set que almacenará los contactos
    private Set<Contacto> contactos;

    //constructor para indicar el tamaño que tendrá la agenda
    public Agenda(int capacidad) {
        contactos = new HashSet<>(capacidad);
    }

    //Método añadir contactos a la agenda y verificar si existen
    public void añadirContacto(Contacto contacto, int capacidad) {
        //Se invoca la función existeContacto para validar que no existe el contacto antes de agregarlo
        if (!AgendaLlena(capacidad)){
            existeContacto(contacto);
        }
    }
    public void existeContacto(Contacto contacto) {

        //Se crea un boolean para validar si ya existe el contacto que se ve a agregar
        boolean nombreExiste = false;
        //Se hace bucle for each para recorrer el HashSet
        for (Contacto nombre : contactos) {
            //Se hace condicional para validar que el nombre que se ingresa no se encuentre en el HashSet
            if (nombre.getNombre().equals(contacto.getNombre())) {
                nombreExiste = true;
                break;
            }
        }
        //Se hace condicional para agregar el nuevo contacto al HashSet
        if (nombreExiste) {
            System.out.println("Este contacto ya exite!!!");
        } else {
            contactos.add(contacto);
            System.out.println("Contacto agregado con exito!!!");
        }
    }
    //Método mostrar lista de contactos
    public void ListarContactos (){
        if (contactos.size() != 0){
            for (Contacto contacto : contactos ){
                System.out.println("Nombre: " + contacto.getNombre());
                System.out.println("Telefono: "+ contacto.getTelefono());
            }
        } else {
            System.out.println("No hay contactos para mostrar");
        }
    }

    //Método Buscar contactos por nombre
    public void buscaContacto(String nombre) {
        boolean isFound = false;

        for (Contacto c : contactos) {
            if (c.getNombre().equalsIgnoreCase(nombre)) {
                System.out.println("Nombre: " + c.getNombre());
                System.out.println("Teléfono: " + c.getTelefono());
                isFound = true;
                break;
            }
        }

        if (!isFound) {
            System.out.println("No encontramos el contacto");
        }

    }

    //Método Eliminar contactos por nombre

    public String deleteContacto(String nombre) {
        boolean isRemoved = false;
        for (Contacto c : contactos) {
            if (c.getNombre().equalsIgnoreCase(nombre)) {
                contactos.remove(c);
                isRemoved = true;
            }
        }
        String respuesta = isRemoved ? "El contacto se eliminó" : "El contacto no existe";
        return respuesta;

    }

    //Método para verificar si la agenda está llena
    public boolean AgendaLlena (int capacidad){
        if (contactos.size() == capacidad){
            System.out.println("La agenda esta llena");
            return true;
        } else {
            System.out.println("La agenda aun no está llena");
            return false;
        }
    }

    //Método para verificar espacios libres que quedan en la agenda
    public int espacioLibre(int capacidad) {
        return capacidad - contactos.size();
    }

}
