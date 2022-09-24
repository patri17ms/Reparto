package com.reparto.rest.model;

public class PedidoNuevo {
    private boolean entregado;
    private Integer numeroPedido;
    private Integer numeroVehiculo;
    /**
     * @return the entregado
     */
    public boolean isEntregado() {
        return entregado;
    }
    /**
     * @param entregado the entregado to set
     */
    public void setEntregado(boolean entregado) {
        this.entregado = entregado;
    }
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
    
    

}
