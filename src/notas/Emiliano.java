package notas;

import java.util.ArrayList;
import java.util.Scanner;

public class Emiliano {

    public static void main(String[] args) {
        Notas nt = new Notas();
        Scanner entrada2 = new Scanner(System.in);

        boolean salir = false;
        int opcion;

        do {
            System.out.println();
            System.out.println("Menu");
            System.out.println("1.Cargar Alumnos: ");
            System.out.println("2.Cargar Notas: ");
            System.out.println("3.Mostrar Notas: ");
            System.out.println("4.Ver nota final de un estudiante:  ");
            System.out.println("5.Ver cuantos estudiantes reprobaron un examen en especifico: ");
            System.out.println("6.Listar Alumnos Aprobados: ");
            System.out.println("7.Listar alumnos Desaprobados: ");
            System.out.println("---------------------------------------------------------------------");

            System.out.println("0. Salir");
            System.out.println("Elije una opcion");

            opcion = entrada2.nextInt();

            switch (opcion) {
                case 1:
                    //Cargar Alumnos */
                    nt.CargarAlumnos();

                    break;
                case 2:
                    //Ingresar Notas */
                    nt.CargarNota();

                    break;
                case 3:
                    //Ver notas Estudiantes */
                    nt.MostrarMatriz();
                    break;

                case 4:
                    //Ver nota final de un estudiante */
                    nt.NotaFinalEstudiante();

                    break;

                case 5:
                    //Ver cuantos estudiantes reprobaron un examen en especifico */
                    nt.DevolverReprobadosExamen();
                    break;

                case 6:
                    //Listar Alumnos Aprobados */
                    nt.DevolverAprobados();
                    break;

                case 7:
                    //Listar alumnos Desaprobados

                    nt.DevolverReprobados();
                    break;

                case 0:
                    salir = true;
                    break;
                default:
                    System.out.println("La opcion elegida no es valida.");

            }

        } while (!salir);

        entrada2.close();
        System.out.println("Bye");

    }

}
