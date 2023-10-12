// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.util.ArrayList;
import java.util.Scanner;

class Estudiante {
    private String nombre;
    private String apellido;
    private ArrayList<Double> notas;

    public Estudiante(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.notas = new ArrayList<Double>();
    }

    public void agregarNota(double nota) {
        notas.add(nota);
    }

    public double calcularPromedio() {
        double suma = 0.0;
        /*Usar "<=" para iterar i, intentará recorrer toda la longitud del arreglo, y tratará de acceder a un indice
        que no existe, la solución es cambiar es operador por un "<" */
        for (int i = 0; i < notas.size(); i++) {
            suma += notas.get(i);
        }
        return suma / notas.size();
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }
}

public class Main {
    private ArrayList<Estudiante> estudiantes;

    public Main() {
        estudiantes = new ArrayList<Estudiante>();
    }

    public void registrarEstudiante(Estudiante estudiante) {
        estudiantes.add(estudiante);
    }

    public void imprimirPromedios() {
        System.out.println("Promedios de estudiantes:");
        /*Usar "<=" para iterar i, intentará recorrer toda la longitud del arreglo, y tratará de acceder a un indice
        que no existe, la solución es cambiar es operador por un "<" */
        for (int i = 0; i < estudiantes.size(); i++) {
            Estudiante estudiante = estudiantes.get(i);
            double promedio = estudiante.calcularPromedio();
            System.out.println(estudiante.getNombre() + " " + estudiante.getApellido() + ": " + promedio);
        }
    }

    public static void main(String[] args) {
        Main universidad = new Main();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Ingrese el nombre del estudiante (o 'salir' para terminar y ver promedio de notas):");
            String nombre = scanner.nextLine();

            if (nombre.equalsIgnoreCase("salir")) {
                break;
            }

            System.out.println("Ingrese el apellido del estudiante:");
            String apellido = scanner.nextLine();

            Estudiante estudiante = new Estudiante(nombre, apellido);

            boolean continuar = true;
            while (continuar) {
                //se cambió la impresión en consola, para mayor claridad al usuario
                System.out.println("Ingrese una nota (o -1 si ya ingresaste todas las notas):");
                double nota = scanner.nextDouble();
                /* La falta de este Scanner.nextLine(); Hace que al retornar a la toma del siguiente estudiante
                * no se pueda ingresar el nombre y cree un bucle infinito */
                scanner.nextLine();
                if (nota == -1) {
                    continuar = false;
                } else {
                    estudiante.agregarNota(nota);
                }
            }

            universidad.registrarEstudiante(estudiante);
        }

        scanner.close();

        //Agregamos este condicional para que si no se ingresan estudiantes con sus notas, no calcule el promedio.
        if(universidad.estudiantes.size() != 0){
         universidad.imprimirPromedios();
        }else {
            System.out.println("No ingresaste estudiantes ni notas, reinicia el proceso");
        }
    }
}



