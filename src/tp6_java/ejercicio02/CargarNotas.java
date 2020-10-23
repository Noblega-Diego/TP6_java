package tp6_java.ejercicio02;

import java.util.ArrayList;
import java.util.Scanner;

public class CargarNotas {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Alumno> alumnos= new ArrayList<Alumno>();
        do {
            Alumno alumno = new Alumno();
            String nombreCopleto;
            long legajo;
            System.out.println("INGRESE LOS DATOS DEL ALUMNO");
            System.out.print("nombre completo: ");
            nombreCopleto = sc.nextLine();
            alumno.setNombreCompleto(nombreCopleto);
            System.out.print("legajo: ");
            legajo = sc.nextLong();
            alumno.setLegajo(legajo);
            System.out.println("INGRESE LAS NOTAS");
            String residuo = sc.nextLine();
            do {
                Nota nota = new Nota();
                String catedra;
                double notaExamen;
                System.out.print("nombre de la catedra: ");
                catedra = sc.nextLine();
                System.out.print("nota:");
                notaExamen = sc.nextDouble();
                nota.setCatedra(catedra);
                nota.setNotaExamen(notaExamen);
                alumno.addNota(nota);
                residuo = sc.nextLine();
            }while (continuar());
            alumnos.add(alumno);
        }while(continuar());

        for (Alumno alumno: alumnos){
            System.out.println("\n");
            System.out.println("los datos de alumno son:");
            System.out.println("nombre:" + alumno.getNombreCompleto());
            System.out.println("legajo:" + alumno.getLegajo());
            for (Nota nota: alumno.getNotas()) {
                System.out.println("catedra "+ nota.getCatedra());
                System.out.println("    nota:" + nota.getNotaExamen());
            }
            System.out.println("promedio:"+alumno.promedio());
        }
    }
    private static boolean continuar(){
        Scanner sc = new Scanner(System.in);
        System.out.println("¿desea continuar añadiendo? (Y) ó cualquier otra letra para salir");
        String next = sc.nextLine();
        if(next.equalsIgnoreCase("y")){
            return true;
        }else {
            return false;
        }
    }
}
