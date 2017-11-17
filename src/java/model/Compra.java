/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author edoarda
 */
public class Compra {
    private int id;
    private int idCliente;
    private int idProduto;

    public Compra() {
        
    }
    
    public Compra(int id, int idCliente, int idProduto) {
        this.id = id;
        this.idCliente = idCliente;
        this.idProduto = idProduto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }
    
   
    
}
