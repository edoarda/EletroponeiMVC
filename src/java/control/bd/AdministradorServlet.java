/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control.bd;

import control.dao.AdministradorCRUD;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Administrador;

/**
 *
 * @author edoarda
 */
@WebServlet(name = "AdministradorServlet", urlPatterns = {"/AdministradorServlet"})
public class AdministradorServlet extends HttpServlet {

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
            out.println("<title>Servlet AdministradorServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AdministradorServlet at " + request.getContextPath() + "</h1>");
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
            // User IS logged in.  
            String opcao = request.getParameter("opcao");
            
            if(opcao.equalsIgnoreCase("editar")) {
                int id = Integer.parseInt(request.getParameter("id"));
                AdministradorCRUD crud = new AdministradorCRUD();
                //List<String> str;
                Administrador adm;
                //str = crud.getMetadata();
                adm = crud.readOne(id);
                //request.setAttribute("admCampos", str);
                request.setAttribute("administrador", adm);

                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/jsp/editForm/administrador.jsp");
                dispatcher.forward(request, response);
            }
            if(opcao.equalsIgnoreCase("deletar")){
                int aid = Integer.valueOf(request.getParameter("id"));
                AdministradorCRUD crud = new AdministradorCRUD();
                Administrador a = new Administrador();
                a.setId(aid);
                crud.delete(a);

                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/AdminIndex");
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
            AdministradorCRUD crud = new AdministradorCRUD();
            if(sa.equalsIgnoreCase("criar")) {
                Administrador administrador = new Administrador();
                //administrador.setDescricao(request.getParameter("descricao"));
                //adicionei o nome aqui
                administrador.setLogin(request.getParameter("login"));
                administrador.setSenha(request.getParameter("senha"));
                crud.create(administrador);
            } else {
                if(sa.equalsIgnoreCase("Ver")){
                    List<String> str;
                    List<Administrador> adm;
                    str = crud.getMetadata();
                    adm = crud.readAll();
                    request.setAttribute("admCampos", str);
                    request.setAttribute("administrador", adm);
                }
                if(sa.equalsIgnoreCase("Alterar")){
                    int aid = Integer.valueOf(request.getParameter("id"));
                    Administrador a = crud.readOne(aid);
                    //c.setDescricao("mudando");// nao entendi direito o q isso ta fazendo, mudei ele depois, se nao tiver diferença tirar essa linha
                    //adicionei o nome aqui
                    a.setLogin(request.getParameter("login"));
                    a.setSenha(request.getParameter("senha"));
                    crud.update(a);
                }

                if(sa.equalsIgnoreCase("Excluir")){
                    int aid = Integer.valueOf(request.getParameter("id"));
                    Administrador a = new Administrador();
                    a.setId(aid);
                    crud.delete(a);
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
