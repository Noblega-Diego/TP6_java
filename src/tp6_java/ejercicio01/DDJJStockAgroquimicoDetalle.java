package tp6_java.ejercicio01;

/**
 * @author diego
 */

public class DDJJStockAgroquimicoDetalle {
    private String codigoAgroqimico;
    private String nombreAgroquimico;
    private double capacidadEnvase;
    private int cantidadEnvases;
    private double subTotal;
    private String NroLote;

    public String getCodigoAgroqimico() {
        return codigoAgroqimico;
    }

    public void setCodigoAgroqimico(String codigoAgroqimico) {
        this.codigoAgroqimico = codigoAgroqimico;
    }

    public String getNombreAgroquimico() {
        return nombreAgroquimico;
    }

    public void setNombreAgroquimico(String nombreAgroquimico) {
        this.nombreAgroquimico = nombreAgroquimico;
    }

    public double getCapacidadEnvase() {
        return capacidadEnvase;
    }

    public void setCapacidadEnvase(double capacidadEnvace) {
        this.capacidadEnvase = capacidadEnvace;
    }

    public int getCantidadEnvases() {
        return cantidadEnvases;
    }

    public void setCantidadEnvases(int cantidadEnvaces) {
        this.cantidadEnvases = cantidadEnvaces;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public String getNroLote() {
        return NroLote;
    }

    public void setNroLote(String NroLote) {
        this.NroLote = NroLote;
    }
    
}
