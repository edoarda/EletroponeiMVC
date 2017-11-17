/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author edoarda
 */
public class CompraCRUD {
    private Connection conexao;
    private PreparedStatement preparador;
    private ResultSet resultado;
    
    public CompraCRUD() {
        conexao = new Conector().getConnection();
    }
    
    public void create(model.Compra compra){
        String sql = "insert into compra values (default, ?, ?)";
        try {
            preparador = conexao.prepareStatement(sql);
            preparador.setInt(1, compra.getIdCliente());
            preparador.setInt(2, compra.getIdProduto());
            preparador.execute();
            preparador.close();
        } catch (SQLException e) {
        }
    }
    
    public List<model.Compra> readAll() {
        String sql = "select * from compra";
        List<model.Compra> lista = new ArrayList<>();
        try {
            preparador = conexao.prepareStatement(sql);
            resultado = preparador.executeQuery();
            while(resultado.next()){
                model.Compra compra = new model.Compra(resultado.getInt("id"), resultado.getInt("idcliente"), resultado.getInt("idproduto"));
                lista.add(compra);
            }
            resultado.close();
            preparador.close();
            return lista;
        } catch(SQLException e){
            return null;
        }
    }
    
    public model.Compra readOne(int id) {
       String sql = "select * from compra where id = ?";
       model.Compra compra = new model.Compra();
        try {
            preparador = conexao.prepareStatement(sql);
            preparador.setInt(1, id);
            resultado = preparador.executeQuery();
            if(resultado.next()){
                compra.setId(resultado.getInt("id"));
                compra.setIdCliente(resultado.getInt("idcliente"));
                compra.setIdProduto(resultado.getInt("idproduto"));
            } else {
                compra = null;
            }
            resultado.close();
            preparador.close();
            return compra;
        } catch(SQLException e){
            return null;
        }
    }
    
    public void update(model.Compra compra){
        String sql = "update compra set idcliente = ? , idproduto = ? where id = ?";
        try {
            preparador = conexao.prepareStatement(sql);
            preparador.setInt(1, compra.getIdCliente());
            preparador.setInt(2, compra.getIdProduto());
            preparador.setInt(3, compra.getId());
            preparador.execute();
            preparador.close();
        } catch(SQLException e){
        }
    }
    
    public void delete(model.Compra compra){
        String sql = "delete from compra where id = ?";
        try {
            preparador = conexao.prepareStatement(sql);
            preparador.setInt(1, compra.getId());
            preparador.execute();
            preparador.close();
        } catch(SQLException e) {
        }
    }
}
