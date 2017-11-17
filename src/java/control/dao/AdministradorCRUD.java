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
public class AdministradorCRUD {
    private Connection conexao;
    private PreparedStatement preparador;
    private ResultSet resultado;
    
    public AdministradorCRUD() {
        conexao = new Conector().getConnection();
    }
    
    public void create(model.Administrador a){
        String sql = "insert into administrador values (default, ?, ?)";
        try {
            preparador = conexao.prepareStatement(sql);
            preparador.setString(1, a.getLogin());
            preparador.setString(2, a.getSenha());
            preparador.execute();
            preparador.close();
        } catch (SQLException e) {
        }
    }
    
        public List<model.Administrador> readAll() {
        String sql = "select * from administrador";
        List<model.Administrador> lista = new ArrayList<>();
        try {
            preparador = conexao.prepareStatement(sql);
            resultado = preparador.executeQuery();
            while(resultado.next()){
                model.Administrador a = new model.Administrador(resultado.getInt("id"), resultado.getString("login"), resultado.getString("senha"));
                lista.add(a);
            }
            resultado.close();
            preparador.close();
            return lista;
        } catch(SQLException e){
            return null;
        }
    }
    
    public model.Administrador readOne(String login, String senha) {
       String sql = "select * from administrador where login = ? and senha = ?";
       model.Administrador a = new model.Administrador();
        try {
            preparador = conexao.prepareStatement(sql);
            preparador.setString(1, login);
            preparador.setString(2, senha);
            resultado = preparador.executeQuery();
            if(resultado.next()){
                a.setId(resultado.getInt("id"));
                a.setLogin(resultado.getString("login"));
                a.setSenha(resultado.getString("senha"));
            } else {
                a = null;
            }
            resultado.close();
            preparador.close();
            return a;
        } catch(SQLException e){
            return null;
        }
    }
    
    public void update(model.Administrador a){
        String sql = "update administrador set login = ? , senha = ? where id = ?";
        try {
            preparador = conexao.prepareStatement(sql);
            preparador.setString(1, a.getLogin());
            preparador.setString(2, a.getSenha());
            preparador.setInt(3, a.getId());
            preparador.execute();
            preparador.close();
        } catch(SQLException e){
        }
    }
    
    public void delete(model.Administrador a){
        String sql = "delete from administrador where id = ?";
        try {
            preparador = conexao.prepareStatement(sql);
            preparador.setInt(1, a.getId());
            preparador.execute();
            preparador.close();
        } catch(SQLException e) {
        }
    }
}
