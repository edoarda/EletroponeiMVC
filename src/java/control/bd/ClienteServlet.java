/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control.bd;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Cliente;
import control.dao.ClienteCRUD;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;

/**
 *
 * @author edoarda
 */
@WebServlet(name = "ClienteServlet", urlPatterns = {"/ClienteServlet"})
public class ClienteServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        /*response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            // TODO output your page here. You may use following sample code. 
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ClienteServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ClienteServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }*/
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        
        if(null == session.getAttribute("logado")) {
            //User is NOT logged in.
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.htm");
            dispatcher.forward(request, response);
        } else {  
            String opcao = request.getParameter("opcao");

            if(opcao.equalsIgnoreCase("editar")) {
                int id = Integer.parseInt(request.getParameter("id"));
                ClienteCRUD crud = new ClienteCRUD();
                Cliente clt;
                clt = crud.readOne(id);
                request.setAttribute("cliente", clt);

                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/jsp/editForm/cliente.jsp");
                dispatcher.forward(request, response);
            }
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        HttpSession session = request.getSession();
        
        if(null == session.getAttribute("logado")) {
            //User is NOT logged in.
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.htm");
            dispatcher.forward(request, response);
        } else {  
            String sa = request.getParameter("submitAction");
            ClienteCRUD crud = new ClienteCRUD();
            if(sa.equalsIgnoreCase("criar")) {
                Cliente cliente = new Cliente();
                //administrador.setDescricao(request.getParameter("descricao"));
                //adicionei o nome aqui
                cliente.setBairro(request.getParameter("bairro"));
                cliente.setBandeira(request.getParameter("bandeira"));
                cliente.setCartao(request.getParameter("cartao"));
                cliente.setCelular(request.getParameter("celular"));
                cliente.setCep(request.getParameter("cep"));
                cliente.setCidade(request.getParameter("cidade"));
                cliente.setCpf(request.getParameter("cpf"));
                cliente.setEndereco(request.getParameter("endereco"));
                cliente.setIdentidade(request.getParameter("identidade"));
                cliente.setNome(request.getParameter("nome"));
                cliente.setReferencia(request.getParameter("referencia"));
                cliente.setTelefone(request.getParameter("telefone"));
                cliente.setUf(request.getParameter("uf"));
                crud.create(cliente);
            } else {
                if(sa.equalsIgnoreCase("Ver")){
                    List<String> str;
                    List<Cliente> clt;
                    str = crud.getMetadata();
                    clt = crud.readAll();
                    request.setAttribute("cltCampos", str);
                    request.setAttribute("cliente", clt);
                }
                if(sa.equalsIgnoreCase("Alterar")){
                    int id = Integer.valueOf(request.getParameter("id"));
                    Cliente cliente = crud.readOne(id);
                    //c.setDescricao("mudando");// nao entendi direito o q isso ta fazendo, mudei ele depois, se nao tiver diferença tirar essa linha
                    //adicionei o nome aqui
                    cliente.setBairro(request.getParameter("bairro"));
                    cliente.setBandeira(request.getParameter("bandeira"));
                    cliente.setCartao(request.getParameter("cartao"));
                    cliente.setCelular(request.getParameter("celular"));
                    cliente.setCep(request.getParameter("cep"));
                    cliente.setCidade(request.getParameter("cidade"));
                    cliente.setCpf(request.getParameter("cpf"));
                    cliente.setEndereco(request.getParameter("endereco"));
                    cliente.setIdentidade(request.getParameter("identidade"));
                    cliente.setNome(request.getParameter("nome"));
                    cliente.setReferencia(request.getParameter("referencia"));
                    cliente.setTelefone(request.getParameter("telefone"));
                    cliente.setUf(request.getParameter("uf"));
                    crud.update(cliente);
                }

                if(sa.equalsIgnoreCase("Excluir")){
                    int id = Integer.valueOf(request.getParameter("id"));
                    Cliente cliente = new Cliente();
                    cliente.setId(id);
                    crud.delete(cliente);
                }
            }
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/AdminIndex");
            dispatcher.forward(request, response);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
