
package tp6_java.ejercicio01;

import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author diego
 */
public class CargaDDJJStockAgroquimico {
    private static String[][] agroquimicos = {{"1001","2ECJEBAGRO","A"},{"1002","D 60 GREEN CROPS","V"},{"1003","ESTER 97","A"},{"1004","AMINA ICONA SL","A"},
            {"1005","ABAMECTINA AGRO","A"},{"1006","FURACARB 31 TS","R"},{"1007","FURAFARM 48F","R"},{"1008","ACETOCLOR ASSA","A"},
            {"1009","GLIFOSATO ACTIVE SIL","R"},{"1010","ABRIGO PLUS","V"}};
    public static void main(String[] args) {
        DDJJStockAgroquimico declaracionJurada = new DDJJStockAgroquimico();
        pedirDatosDeLaDeclaracon(declaracionJurada);
        ingresarAgroquimicos(declaracionJurada);
        ImprimirDeclaracioJurada(declaracionJurada);
    }
    
    private static void pedirDatosDeLaDeclaracon(DDJJStockAgroquimico declaracion){
        String nombre;
        int mes,ano;
        long cuit;
        Scanner scanner = new Scanner(System.in);
        System.out.println("**********************************");
        do{
            System.out.print("Ingrese el nombre de la empresa:");
            nombre = scanner.nextLine();
            System.out.print("Ingrese el cuit:");
            cuit = scanner.nextLong();
            System.out.print("Ingrese mes:");
            mes = scanner.nextInt();
            System.out.print("ingrese el año:");
            ano = scanner.nextInt();
            String residuo = scanner.nextLine();
            Date fechaActual = new Date();
            if(cuit >= 10000000000L){
                if(mes <= fechaActual.getMonth()-1 && ano <= fechaActual.getYear()+1900){
                    declaracion.setEmpresa(nombre);
                    declaracion.setCuit(cuit);
                    declaracion.setMesDeclaracion(mes);
                    declaracion.setAnioDeclaracion(ano);
                    break;
                }
            }
            System.out.println("**********************************");
            System.out.println("ingrese nuevamente los datos");
        }while(true);
    }
    
    private static void ingresarAgroquimicos(DDJJStockAgroquimico declaracion){
        Scanner sc = new Scanner(System.in);
        String nombreAgroquimico ="";
        String codigoAgroqimico ="";
        String bandaAgroqimico ="";
        String numeroLote;
        do{
            double capacidadEnvase;
            int cantidadDeEnvases;
            
            System.out.println("**********************************");
            do{
                System.out.print("ingrese el codigo del agroquimico:");
                codigoAgroqimico = sc.nextLine();
                int i = buscarAgroquimico(codigoAgroqimico);
                if(i != -1){
                    nombreAgroquimico = agroquimicos[i][1];
                    bandaAgroqimico = agroquimicos[i][2];
                    System.out.println("agroquimico encontrado:" + nombreAgroquimico);
                    break;
                }
                System.out.println("**********************************");
                System.out.println("El código del agroquímico ingresado  no  existe,  intente nuevamente");
                
            }while(true);
            
            System.out.println("ingrese capacidad del envse:");
            capacidadEnvase = sc.nextDouble();
            System.out.println("cantidad de envases:");
            cantidadDeEnvases = sc.nextInt();
            if(bandaAgroqimico.equals("R")){
                System.out.println("numero de lote:");
                numeroLote = String.valueOf(sc.nextInt());
            }else{
                numeroLote = "";
            }
            String residuo = sc.nextLine();
            double subtotal = capacidadEnvase * cantidadDeEnvases;
            declaracion.AgregarDetalleAgroquimico(codigoAgroqimico, nombreAgroquimico, capacidadEnvase, cantidadDeEnvases, subtotal, numeroLote);
            System.out.println("**********************************");
            System.out.print("¿desea salir?, 'y' para salir:");
            String salir = sc.nextLine();
            if(salir.equals("y")){
                break;
            }
        }while(true);
    }
    
    private static int buscarAgroquimico(String codigo){
        for (int i = 0;i < agroquimicos.length; i++) {
            if(codigo.equals(agroquimicos[i][0])){
                        return i;
            }
        }
        return -1;
    }
    private static void ImprimirDeclaracioJurada(DDJJStockAgroquimico declaracion){
        System.out.println("\n\n");
        System.out.println("****************************************************************************************************************");
        System.out.println("*                                   Datos de la declaracion jurada                                             *");
        System.out.println("****************************************************************************************************************");
        System.out.println("Empresa: "+ declaracion.getEmpresa());
        System.out.println("CUIT: "+ declaracion.getCuit());
        System.out.println("Mes: "+ declaracion.getMesDeclaracion());
        System.out.println("Año: "+ declaracion.getAnioDeclaracion());
        System.out.println("Código Agroquimico  "+"Nombre Agroquimico  "+"Capacidad Envase Kg/Lt  "+"Cantidad Envase  "+"Subtotal  "+"N°de  Lote");
        
        for (DDJJStockAgroquimicoDetalle agroquimico : declaracion.getDetallesAgroquimico()) {
            System.out.println(
                    rellenarEspaciosSimple(agroquimico.getCodigoAgroqimico(), 20) + 
                    rellenarEspaciosSimple(agroquimico.getNombreAgroquimico(), 20) + 
                    rellenarEspaciosSimple(String.valueOf(agroquimico.getCapacidadEnvase()),24)+ 
                    rellenarEspaciosSimple(String.valueOf(agroquimico.getCantidadEnvases()),17) +
                    rellenarEspaciosSimple(String.valueOf(agroquimico.getSubTotal()),10) +
                    ((agroquimico.getNroLote().equals(""))? "----------" : agroquimico.getNroLote()));
        }
        System.out.println(rellenarEspaciosSimple(" ", 64)+rellenarEspaciosSimple("Total", 17) + declaracion.getTotalKiloLitros());
        System.out.println("****************************************************************************************************************");
    }
    
    private static String rellenarEspaciosSimple(String string, int espaciosTotal) {
        String nuevoString = string;
        if(string.length() < espaciosTotal){
            for(int i = string.length(); i<espaciosTotal; i++){     //inicio con el espacio del array hata el espacio que tendria que tener
                nuevoString += " ";                                 //añade espacio
            }
        }
        return nuevoString;                                         //retorna string con los espacios
    }
    
}
