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
public class CategoriaCRUD {
    private Connection conexao;
    private PreparedStatement preparador;
    private ResultSet resultado;
    
    public CategoriaCRUD() {
        conexao = new Conector().getConnection();
    }
    
    public void create(model.Categoria categoria){
        String sql = "insert into categoria values (default, ?, ?)";
        try {
            preparador = conexao.prepareStatement(sql);
            preparador.setString(1, categoria.getNome());
            preparador.setString(2, categoria.getDescricao());
            preparador.execute();
            preparador.close();
        } catch (SQLException e) {
        }
    }
    
        public List<model.Categoria> readAll() {
        String sql = "select * from categoria";
        List<model.Categoria> lista = new ArrayList<>();
        try {
            preparador = conexao.prepareStatement(sql);
            resultado = preparador.executeQuery();
            while(resultado.next()){
                model.Categoria categoria = new model.Categoria(resultado.getInt("id"), resultado.getString("nome"), resultado.getString("descricao"));
                lista.add(categoria);
            }
            resultado.close();
            preparador.close();
            return lista;
        } catch(SQLException e){
            return null;
        }
    }
    
    public model.Categoria readOne(String nome) {
       String sql = "select * from categoria where nome like %?%";
       model.Categoria categoria = new model.Categoria();
        try {
            preparador = conexao.prepareStatement(sql);
            preparador.setString(1, nome);
            resultado = preparador.executeQuery();
            if(resultado.next()){
                categoria.setId(resultado.getInt("id"));
                categoria.setNome(resultado.getString("nome"));
                categoria.setDescricao(resultado.getString("descricao"));
            } else {
                categoria = null;
            }
            resultado.close();
            preparador.close();
            return categoria;
        } catch(SQLException e){
            return null;
        }
    }
    
    public model.Categoria readOne(int id) {
       String sql = "select * from categoria where id = ?";
       model.Categoria categoria = new model.Categoria();
        try {
            preparador = conexao.prepareStatement(sql);
            preparador.setInt(1, id);
            resultado = preparador.executeQuery();
            if(resultado.next()){
                categoria.setId(resultado.getInt("id"));
                categoria.setNome(resultado.getString("nome"));
                categoria.setDescricao(resultado.getString("descricao"));
            } else {
                categoria = null;
            }
            resultado.close();
            preparador.close();
            return categoria;
        } catch(SQLException e){
            return null;
        }
    }
    
    public void update(model.Categoria categoria){
        String sql = "update categoria set nome = ? , descricao = ? where id = ?";
        try {
            preparador = conexao.prepareStatement(sql);
            preparador.setString(1, categoria.getNome());
            preparador.setString(2, categoria.getDescricao());
            preparador.setInt(3, categoria.getId());
            preparador.execute();
            preparador.close();
        } catch(SQLException e){
        }
    }
    
    public void delete(model.Categoria categoria){
        String sql = "delete from categoria where id = ?";
        try {
            preparador = conexao.prepareStatement(sql);
            preparador.setInt(1, categoria.getId());
            preparador.execute();
            preparador.close();
        } catch(SQLException e) {
        }
    }
}
