
package tp6_java.ejercicio01;

import java.util.ArrayList;

/**
 *
 * @author diego
 */
public class DDJJStockAgroquimico {
    private int anioDeclaracion;
    private int mesDeclaracion;
    private double totalKiloLitros;
    private String empresa;
    private long cuit;
    private ArrayList<DDJJStockAgroquimicoDetalle> detallesAgroquimico;

    public DDJJStockAgroquimico() {
        this.detallesAgroquimico = new ArrayList<DDJJStockAgroquimicoDetalle>();
        this.totalKiloLitros = 0;
    }
    
    public void AgregarDetalleAgroquimico(String codigoAgroqimico, String nombreAgroquimico, double capacidadEnvace, int cantidadEnvaces, double subTotal, String NroLote){
        DDJJStockAgroquimicoDetalle detalle = new DDJJStockAgroquimicoDetalle();
        detalle.setNombreAgroquimico(nombreAgroquimico);
        detalle.setCodigoAgroqimico(codigoAgroqimico);
        detalle.setCapacidadEnvase(capacidadEnvace);
        detalle.setCantidadEnvases(cantidadEnvaces);
        detalle.setSubTotal(subTotal);
        detalle.setNroLote(NroLote);
        totalKiloLitros += subTotal;
        this.detallesAgroquimico.add(detalle);
    }
    
    
    
    public int getAnioDeclaracion() {
        return anioDeclaracion;
    }

    public void setAnioDeclaracion(int anioDeclaracion) {
        this.anioDeclaracion = anioDeclaracion;
    }

    public int getMesDeclaracion() {
        return mesDeclaracion;
    }

    public void setMesDeclaracion(int mesDeclaracion) {
        this.mesDeclaracion = mesDeclaracion;
    }

    public double getTotalKiloLitros() {
        return totalKiloLitros;
    }

    public void setTotalKiloLitros(double totalKiloLitros) {
        this.totalKiloLitros = totalKiloLitros;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public long getCuit() {
        return cuit;
    }

    public void setCuit(long cuit) {
        this.cuit = cuit;
    }

    public ArrayList<DDJJStockAgroquimicoDetalle> getDetallesAgroquimico() {
        return detallesAgroquimico;
    }

    public void setDetallesAgroquimico(ArrayList<DDJJStockAgroquimicoDetalle> detallesAgroquimico) {
        this.detallesAgroquimico = detallesAgroquimico;
    }
    
}
