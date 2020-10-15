/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author GATEWAY1-
 */
public class Pedidos implements java.io.Serializable{
    int id,programa,lote,pedido,p15,p16,p17,p18,p19,p20,p21,p22,p23,p24,p25,p26,p27,p28,p29,p30,p31,totalpares;

    public int getTotalpares() {
        return totalpares;
    }

    public void setTotalpares(int totalpares) {
        this.totalpares = totalpares;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrograma() {
        return programa;
    }

    public void setPrograma(int programa) {
        this.programa = programa;
    }

    public int getLote() {
        return lote;
    }

    public void setLote(int lote) {
        this.lote = lote;
    }

    public int getPedido() {
        return pedido;
    }

    public void setPedido(int pedido) {
        this.pedido = pedido;
    }

    public int getP15() {
        return p15;
    }

    public void setP15(int p15) {
        this.p15 = p15;
    }

    public int getP16() {
        return p16;
    }

    public void setP16(int p16) {
        this.p16 = p16;
    }

    public int getP17() {
        return p17;
    }

    public void setP17(int p17) {
        this.p17 = p17;
    }

    public int getP18() {
        return p18;
    }

    public void setP18(int p18) {
        this.p18 = p18;
    }

    public int getP19() {
        return p19;
    }

    public void setP19(int p19) {
        this.p19 = p19;
    }

    public int getP20() {
        return p20;
    }

    public void setP20(int p20) {
        this.p20 = p20;
    }

    public int getP21() {
        return p21;
    }

    public void setP21(int p21) {
        this.p21 = p21;
    }

    public int getP22() {
        return p22;
    }

    public void setP22(int p22) {
        this.p22 = p22;
    }

    public int getP23() {
        return p23;
    }

    public void setP23(int p23) {
        this.p23 = p23;
    }

    public int getP24() {
        return p24;
    }

    public void setP24(int p24) {
        this.p24 = p24;
    }

    public int getP25() {
        return p25;
    }

    public void setP25(int p25) {
        this.p25 = p25;
    }

    public int getP26() {
        return p26;
    }

    public void setP26(int p26) {
        this.p26 = p26;
    }

    public int getP27() {
        return p27;
    }

    public void setP27(int p27) {
        this.p27 = p27;
    }

    public int getP28() {
        return p28;
    }

    public void setP28(int p28) {
        this.p28 = p28;
    }

    public int getP29() {
        return p29;
    }

    public void setP29(int p29) {
        this.p29 = p29;
    }

    public int getP30() {
        return p30;
    }

    public void setP30(int p30) {
        this.p30 = p30;
    }

    public int getP31() {
        return p31;
    }

    public void setP31(int p31) {
        this.p31 = p31;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getAgente() {
        return agente;
    }

    public void setAgente(String agente) {
        this.agente = agente;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getFechaentrega() {
        return fechaentrega;
    }

    public void setFechaentrega(String fechaentrega) {
        this.fechaentrega = fechaentrega;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getOperacion() {
        return operacion;
    }

    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }

    public String getHorma() {
        return horma;
    }

    public void setHorma(String horma) {
        this.horma = horma;
    }

    public String getOrdencompra() {
        return ordencompra;
    }

    public void setOrdencompra(String ordencompra) {
        this.ordencompra = ordencompra;
    }
    String cliente,agente,modelo,color,fecharecepcion,fechaentrega,observaciones,operacion,horma,ordencompra;

    public String getFecharecepcion() {
        return fecharecepcion;
    }

    public void setFecharecepcion(String fecharecepcion) {
        this.fecharecepcion = fecharecepcion;
    }
}
