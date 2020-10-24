package tp6_java.ejercicio03;

import java.util.ArrayList;
import java.util.Scanner;
import utiles.Lectura;
import utiles.Utiles;
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
            String bebida = Lectura.leerStringM("¿es una Bebida? \ningrese 'y' para SI \nó cualquier otra letra para NO\n ingrese:");
            esBebida = bebida.equalsIgnoreCase("y");
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
                if(!Utiles.continuarM("¿desea continuar añadiendo ingredientes?"))
                    break;
            }
            platos.add(plato);

        }while (Utiles.continuarM("¿desea continuar añadiendo platos?"));

        mostrarMenu(platos);
    }

    private static void mostrarMenu(ArrayList<Plato> menu){
        System.out.println("----------------MENÚ----------------");
        for (Plato plato: menu) {
            System.out.println(plato.getNombreCompleto());
            System.out.println("precio: $ "+plato.getPrecio());
            if(!plato.isEsBebida()){
                System.out.println("ingredientes:");
                System.out.println(Utiles.rellenarEspaciosSimple("nombre",18) +
                        Utiles.rellenarEspaciosSimple("cantidad",9) + "unidad");
                for (Ingrediente ingrediente: plato.getIngredientes()) {
                    System.out.println(Utiles.rellenarEspaciosSimple(ingrediente.getNombre(),18) +
                            Utiles.rellenarEspaciosSimple(String.valueOf(ingrediente.getCantidad()),9) + ingrediente.getUnidadMedida());
                }
            }
            System.out.println("------------------------------------");
        }
        System.out.println("TOTAL DEL MENU: $ "+ totalDelMenu(menu));
    }

    private static double totalDelMenu(ArrayList<Plato> menu){
        double total = 0;
        for (Plato plato:menu) {
            total += plato.getPrecio();
        }
        return total;
    }
}
