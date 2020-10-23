package tp6_java.ejercicio03;

import java.util.ArrayList;
import java.util.Scanner;
import utiles.Lectura;
public class MenuRestaurant {
    public static void main(String[] args) {
        ArrayList<Plato>platos= new ArrayList<Plato>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Bienvenido!!");
        do {
            Plato plato = new Plato();
            String nombre;
            double precio;
            boolean esBebida;
            System.out.println("-------------------------");
            nombre = Lectura.leerStringM("ingrese nombre del plato:");
            String bebida = Lectura.leerStringM("¿es una Bebida? \n ingrese 'y' para SI \n ó cualquier otra letra para NO\n");
            if(bebida.equalsIgnoreCase("y")){
                esBebida = true;
            }else {
                esBebida = false;
            }
            precio = Lectura.leerDoubleM("ingrese el precio:");
            plato.setNombreCompleto(nombre);
            plato.setEsBebida(esBebida);
            plato.setPrecio(precio);

            while (!esBebida){
                System.out.println("ingrese el ingrediente");
                Ingrediente ingrediente = new Ingrediente();
                String nombreIngrediente,medida;
                double cantidad;
                System.out.println("-------------------------");
                nombreIngrediente = Lectura.leerStringM("nombre del ingrediente:");
                cantidad = Lectura.leerDoubleM("cantidad:");
                medida = Lectura.leerStringM("unidad medida:");
                ingrediente.setCantidad(cantidad);
                ingrediente.setNombre(nombreIngrediente);
                ingrediente.setUnidadMedida(medida);
                plato.addIngrediente(ingrediente);
                if(!continuarM("¿desea continuar añadiendo ingredientes?"))
                    break;
            }
            platos.add(plato);

        }while (continuarM("¿desea continuar añadiendo platos?"));
    }

    private static void mostrarMenu(ArrayList<Plato> menu){
        System.out.println("-----------MENÚ----------------");
        for (Plato plato: menu) {
            System.out.println(plato.getNombreCompleto());
            System.out.println("$"+plato.getPrecio());
            System.out.println("ingredientes:");
        }
    }

    private static boolean continuarM(String mensaje){
        Scanner sc = new Scanner(System.in);
        System.out.println(mensaje +" (Y) ó cualquier otra letra para salir");
        String next = sc.nextLine();
        if(next.equalsIgnoreCase("y")){
            return true;
        }else {
            return false;
        }
    }
}
