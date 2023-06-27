package notas;

import java.util.ArrayList;
import java.util.Scanner;

public class Notas {

    ArrayList<String> alumnos;
    int[][] matriz;

    String nombre;
    Scanner entrada = new Scanner(System.in);

    //punto 1
    /**
     * Cargo los alumnos dentro de un array list uso de condicion de corte la
     * palabra "x" y el boolean "b" cuando se termina de cargar muestro la
     * matriz
     *
     */
    public void CargarAlumnos() {

        alumnos = new ArrayList<>();
        boolean b = true;
        while (b == true) {

            System.out.println("Ingrese el nombre del alumno que desea cargar.");
            System.out.println("Para cancelar la carga de alumnos escriba ´x´ ");
            nombre = entrada.nextLine();
            if ("x".equals(nombre)) {
                b = false;
                break;
            }

            alumnos.add(nombre);
            System.out.println("¡Alumno cargado correctamente!");
            System.out.println("----------------------------------------------");
        }
        matriz = new int[alumnos.size()][4];
        MostrarMatriz();

    }

    //punto 2 matriz
    /**
     * Cargo las notas de cada alumno dentro de la matriz declaro una variable
     * nota para guardarlas Pido la nota por teclado y la leo con el next int
     * Luego valido la nota con el if para ver si es mayo o igual a 0 o menos o
     * igual a 10 y si cumple la agrego a la matriz
     */
    public void CargarNota() {
        int nota = 0;

        for (int i = 0; i < matriz.length; i++) {
            System.out.println("Introduzca ahora las notas de " + alumnos.get(i).toString());
            for (int j = 0; j < matriz[i].length; j++) {

                System.out.print("Notas del examen numero " + (j + 1) + ": ");
                nota = entrada.nextInt();
                if (nota >= 0 && nota <= 10) {
                    matriz[i][j] = nota;

                }

            }

        }
        
    }

    //punto 3 mostrar notas
    /**
     * Muestro la matriz y para que quede linda me fije en internet como
     * hacerlo.
     *
     */
    public void MostrarMatriz() {

        System.out.println("---------------------------------------------------------------------");
        System.out.println("Evaluacion 1\tEvaluacion 2\tEvaluacion 3\tEvaluacion 4\tAlumno");

        for (int i = 0; i < matriz.length; i++) {

            for (int j = 0; j < matriz[i].length; j++) {

                System.out.print(matriz[i][j]);
                if (j != matriz[i].length - 1) {
                    System.out.print("\t \t    ");
                }

            }

            System.out.println("  \t |  " + alumnos.get(i).toString());
        System.out.println("---------------------------------------------------------------------");
        }

    }

    //punto 4 Ver nota final de un estudiante: El sistema pide número de estudiante y 
    //devuelve el promedio de los 4 exámenes. Llamar a un método que realice esta funcionalidad.
    /**
     * Declaro las variables suma y promedio y un nuevo scanner, pido por
     * teclado que me ingrese el nombre del alumno valido la variable que
     * ingreso. Despues creo otra variable "nom" para buscar a que indice
     * pertenece el nombre del alumno que se ingreso por teclado
     */
    public void NotaFinalEstudiante() {
        double suma = 0;
        double promedio = 0;
        Scanner nuevo = new Scanner(System.in);
        System.out.println("Ingrese el nombre del alumno: ");
        nombre = nuevo.nextLine();
        int nom = alumnos.indexOf(nombre);
        for (int j = 0; j < matriz[nom].length; j++) {
            suma = suma + matriz[nom][j];

        }
        promedio = suma / 4;
        System.out.println("El promedio de el alumno " + nombre + " es: " + promedio);

    }

    //punto 5 Ver cuántos estudiantes reprobaron un examen en particular: El sistema pide
    // número de examen y devuelve la cantidad de estudiantes que reprobaron. Llamar a un método que realice esta funcionalidad.
    /**
     * Declaro un scanner nuevo, una variable para guardar el numero de examen
     * "exa" y un contador de reprobados Pido ingresar el numero del examen,
     * valido la variable y le resto 1 para que coincida con los indices de la
     * matriz recorro las filas de la matriz y pregunto si el indice del examen
     * se encuentra en la matris y si es menor a 4 y sumo 1 al contador de
     * reprobados
     */
    public void DevolverReprobadosExamen() {
        Scanner nuevo2 = new Scanner(System.in);
        int exa = 0;
        int reprobados = 0;
        System.out.println("Ingrese el numero de examen:");
        exa = nuevo2.nextInt() - 1;
        for (int i = 0; i < matriz.length; i++) {
            if (matriz[i][exa] < 4) {
                reprobados = reprobados + 1;

            }

        }
        System.out.println("La cantidad de reprobados es: " + reprobados);

    }

    //punto 6
    /**
     * Declaro 3 variables, suma, promedio y aprobados (contador) recorro las
     * filas de la matriz, igualo la suma a 0 y despues recorro las columnas
     * hago la suma de las notas y despues calculo el promedio luego pregunto si
     * el promedio es mayor o igual a 4, si es asi se suma en 1 el contador de
     * aprobados y muestro el nombre del alumno y con que promedio aprobo cuando
     * termina de recorrer toda la matriz muestro el contador de aprobados
     *
     */
    public void DevolverAprobados() {

        double suma;
        double promedio = 0;
        int aprobados = 0;
        for (int i = 0; i < matriz.length; i++) {
            suma = 0;

            for (int j = 0; j <= 3; j++) {
                suma = suma + matriz[i][j];
                promedio = suma / 4;

            }
            if (promedio >= 4) {
                aprobados = aprobados + 1;
                System.out.println("El alumno " + alumnos.get(i).toString() + " aprobo con un promedio de: " + promedio);

            }

        }
        System.out.println("La cantidad de alumnos aprobados es de: " + aprobados);

    }

    //punto 7
    /**
     * Declaro 3 variables suma, promedio y desaprobados (contador), primero
     * recorro las filas de la matriz, igualo la suma a 0 luego recorro las
     * columnas que son 4 examenes, dentro de eso resuelvo la suma y el promedio
     * despues pregunto con un if si el promedio es menor a 4 y si es asi sumo 1
     * en el contador de desaprobados y muestro el alumno y con que promedio
     * reprobo Es igual al metodo anterior pero con el if invertido cuando sale
     * del if muestro el contador final de desaprobados
     */
    public void DevolverReprobados() {
        double suma;
        double promedio = 0;
        int desaprobados = 0;
        for (int i = 0; i < matriz.length; i++) {
            suma = 0;
            for (int j = 0; j <= 3; j++) {
                suma = suma + matriz[i][j];
                promedio = suma / 4;

            }
            if (promedio < 4) {
                desaprobados = desaprobados + 1;
                System.out.println("El alumno " + alumnos.get(i).toString() + " reprobo con un promedio de: " + promedio);

            }

        }
        System.out.println("La cantidad de alumnos aprobados es de: " + desaprobados);

    }

}
