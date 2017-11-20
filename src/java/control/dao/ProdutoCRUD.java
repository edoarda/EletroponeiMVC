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
public class ProdutoCRUD {
    private Connection conexao;
    private PreparedStatement preparador;
    private ResultSet resultado;
    
    public ProdutoCRUD() {
        conexao = new Conector().getConnection();
    }
    
    public void create(model.Produto produto){
        String sql = "insert into produto values (default, ?, ?, ?, ?)";
        try {
            preparador = conexao.prepareStatement(sql);
            preparador.setInt(1, produto.getIdCategoria());
            preparador.setString(2, produto.getNome());
            preparador.setString(3, produto.getDescricao());
            preparador.setDouble(4, produto.getValor());
            preparador.execute();
            preparador.close();
        } catch (SQLException e) {
        }
    }
    
        public List<model.Produto> readAll() {
        String sql = "select * from produto";
        List<model.Produto> lista = new ArrayList<>();
        try {
            preparador = conexao.prepareStatement(sql);
            resultado = preparador.executeQuery();
            while(resultado.next()){
                model.Produto produto = new model.Produto(resultado.getInt("id"),
                        resultado.getInt("idcategoria"),
                        resultado.getString("nome"),
                        resultado.getString("descricao"),
                        resultado.getDouble("valor")
                );
                lista.add(produto);
            }
            resultado.close();
            preparador.close();
            return lista;
        } catch(SQLException e){
            return null;
        }
    }
    
    public model.Produto readOne(int id) {
       String sql = "select * from produto where id = ?";
       model.Produto produto = new model.Produto();
        try {
            preparador = conexao.prepareStatement(sql);
            preparador.setInt(1, id);
            resultado = preparador.executeQuery();
            if(resultado.next()){
                produto.setId(resultado.getInt("id"));
                produto.setIdCategoria(resultado.getInt("idcategoria"));
                produto.setNome(resultado.getString("nome"));
                produto.setDescricao(resultado.getString("descricao"));
                produto.setValor(resultado.getDouble("valor"));
            } else {
                produto = null;
            }
            resultado.close();
            preparador.close();
            return produto;
        } catch(SQLException e){
            return null;
        }
    }
    
    public model.Produto readOne(String nome) {
       String sql = "select * from produto where name like %?%";
       model.Produto produto = new model.Produto();
        try {
            preparador = conexao.prepareStatement(sql);
            preparador.setString(1, nome);
            resultado = preparador.executeQuery();
            if(resultado.next()){
                produto.setId(resultado.getInt("id"));
                produto.setIdCategoria(resultado.getInt("idcategoria"));
                produto.setNome(resultado.getString("nome"));
                produto.setDescricao(resultado.getString("descricao"));
                produto.setValor(resultado.getDouble("valor"));
            } else {
                produto = null;
            }
            resultado.close();
            preparador.close();
            return produto;
        } catch(SQLException e){
            return null;
        }
    }
    
    public void update(model.Produto produto){
        String sql = "update produto set idcategoria = ? nome = ? , descricao = ?, valor = ? where id = ?";
        try {
            preparador = conexao.prepareStatement(sql);
            preparador.setInt(1, produto.getIdCategoria());
            preparador.setString(2, produto.getNome());
            preparador.setString(3, produto.getDescricao());
            preparador.setDouble(4, produto.getValor());
            preparador.setInt(5, produto.getId());
            preparador.execute();
            preparador.close();
        } catch(SQLException e){
        }
    }
    
    public void delete(model.Produto produto){
        String sql = "delete from produto where id = ?";
        try {
            preparador = conexao.prepareStatement(sql);
            preparador.setInt(1, produto.getId());
            preparador.execute();
            preparador.close();
        } catch(SQLException e) {
        }
    }
    
    public List<String> getMetadata() {
        List<String> metadata = new ArrayList<>();
        metadata.add("Id");
        metadata.add("IdCategoria");
        metadata.add("Nome");
        metadata.add("Descrição");
        metadata.add("Valor");
        return metadata;
    }
}
