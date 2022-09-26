package com.reparto.rest.model;

public class PedidoNuevo {
    private Integer numeroPedido;
    private Integer numeroVehiculo;
    private String direccionEntrega;
    private String destinatario;
    /**
     * @return the numeroPedido
     */
    public Integer getNumeroPedido() {
        return numeroPedido;
    }
    /**
     * @param numeroPedido the numeroPedido to set
     */
    public void setNumeroPedido(Integer numeroPedido) {
        this.numeroPedido = numeroPedido;
    }
    /**
     * @return the numeroVehiculo
     */
    public Integer getNumeroVehiculo() {
        return numeroVehiculo;
    }
    /**
     * @param numeroVehiculo the numeroVehiculo to set
     */
    public void setNumeroVehiculo(Integer numeroVehiculo) {
        this.numeroVehiculo = numeroVehiculo;
    }
    /**
     * @return the direccionEntrega
     */
    public String getDireccionEntrega() {
        return direccionEntrega;
    }
    /**
     * @param direccionEntrega the direccionEntrega to set
     */
    public void setDireccionEntrega(String direccionEntrega) {
        this.direccionEntrega = direccionEntrega;
    }
    /**
     * @return the destinatario
     */
    public String getDestinatario() {
        return destinatario;
    }
    /**
     * @param destinatario the destinatario to set
     */
    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }
    
}
