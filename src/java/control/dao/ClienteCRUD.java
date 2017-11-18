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
public class ClienteCRUD {
    private Connection conexao;
    private PreparedStatement preparador;
    private ResultSet resultado;
    
    public ClienteCRUD() {
        conexao = new Conector().getConnection();
    }
    
    public void create(model.Cliente cliente) {
        String sql = "insert into cliente values (default, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            preparador = conexao.prepareStatement(sql);
            preparador.setString(1, cliente.getNome());
            preparador.setString(2, cliente.getEndereco());
            preparador.setString(3, cliente.getBairro());
            preparador.setString(4, cliente.getCidade());
            preparador.setString(5, cliente.getCep());
            preparador.setString(6, cliente.getUf());
            preparador.setString(7, cliente.getCpf());
            preparador.setString(8, cliente.getReferencia());
            preparador.setString(9, cliente.getIdentidade());
            preparador.setString(10, cliente.getTelefone());
            preparador.setString(11, cliente.getCelular());
            preparador.setString(12, cliente.getCartao());
            preparador.setString(13, cliente.getBandeira());
            preparador.execute();
            
            preparador.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
        public List<model.Cliente> readAll() {
        String sql = "select * from cliente";
        List<model.Cliente> lista = new ArrayList<>();
        try {
            preparador = conexao.prepareStatement(sql);
            resultado = preparador.executeQuery();
            while(resultado.next()){
                model.Cliente cliente = new model.Cliente(resultado.getInt("id"), 
                        resultado.getString("nome"), 
                        resultado.getString("endereco"),
                        resultado.getString("bairro"),
                        resultado.getString("cidade"),
                        resultado.getString("cep"),
                        resultado.getString("uf"),
                        resultado.getString("cpf"),
                        resultado.getString("referencia"),
                        resultado.getString("identidade"),
                        resultado.getString("telefone"),
                        resultado.getString("celular"),
                        resultado.getString("cartao"),
                        resultado.getString("bandeira")
                );
                lista.add(cliente);
            }
            resultado.close();
            preparador.close();
            return lista;
        } catch(SQLException e){
            e.printStackTrace();
            return null;
        }
    }
    
    public model.Cliente readOne(int id) {
       String sql = "select * from cliente where id = ?";
       model.Cliente cliente = new model.Cliente();
        try {
            preparador = conexao.prepareStatement(sql);
            preparador.setInt(1, id);
            resultado = preparador.executeQuery();
            if(resultado.next()){
                cliente.setId(resultado.getInt("id"));
                cliente.setNome(resultado.getString("nome"));
                cliente.setEndereco(resultado.getString("endereco"));
                cliente.setBairro(resultado.getString("bairro"));
                cliente.setCidade(resultado.getString("cidade"));
                cliente.setCep(resultado.getString("cep"));
                cliente.setUf(resultado.getString("uf"));
                cliente.setCpf(resultado.getString("cpf"));
                cliente.setReferencia(resultado.getString("referencia"));
                cliente.setIdentidade(resultado.getString("identidade"));
                cliente.setTelefone(resultado.getString("telefone"));
                cliente.setCelular(resultado.getString("celular"));
                cliente.setCartao(resultado.getString("cartao"));
                cliente.setBandeira(resultado.getString("bandeira"));
            } else {
                cliente = null;
            }
            resultado.close();
            preparador.close();
            return cliente;
        } catch(SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public void update(model.Cliente cliente){
        String sql = "update cliente set nome = ? ,"
                + " endereço = ?"
                + " bairro = ?"
                + " cidade = ?"
                + " cep = ?"
                + " uf = ?"
                + " cpf = ?"
                + " referencia = ?"
                + " identidade = ?"
                + " telefone = ?"
                + " celular = ?"
                + " cartao = ?"
                + " bandeira = ?"
                + " where id = ?";
        try {
            preparador = conexao.prepareStatement(sql);
            preparador.setString(1, cliente.getNome());
            preparador.setString(2, cliente.getEndereco());
            preparador.setString(3, cliente.getBairro());
            preparador.setString(4, cliente.getCidade());
            preparador.setString(5, cliente.getCep());
            preparador.setString(6, cliente.getUf());
            preparador.setString(7, cliente.getCpf());
            preparador.setString(8, cliente.getReferencia());
            preparador.setString(9, cliente.getIdentidade());
            preparador.setString(10, cliente.getTelefone());
            preparador.setString(11, cliente.getCelular());
            preparador.setString(12, cliente.getCartao());
            preparador.setString(13, cliente.getBandeira());
            preparador.setInt(3, cliente.getId());
            preparador.execute();
            preparador.close();
        } catch(SQLException e) {
        }
    }
    
    public void delete(model.Cliente cliente){
        String sql = "delete from cliente where id = ?";
        try {
            preparador = conexao.prepareStatement(sql);
            preparador.setInt(1, cliente.getId());
            preparador.execute();
            preparador.close();
        } catch(SQLException e) {
        }
    }
    
    public List<String> getMetadata() {
        List<String> metadata = null;
        metadata.add("Id");
        metadata.add("Nome");
        metadata.add("Endereço");
        metadata.add("Bairro");
        metadata.add("Cidade");
        metadata.add("UF");
        metadata.add("CPF");
        metadata.add("Referência");
        metadata.add("Identidade");
        metadata.add("Telefone");
        metadata.add("Celular");
        metadata.add("Cartão");
        metadata.add("Bandeira");
        
        return metadata;
    }
}
