/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control.bd;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Categoria;
import control.dao.CategoriaCRUD;
import java.util.List;
import javax.servlet.RequestDispatcher;

/**
 *
 * @author edoarda
 */
@WebServlet(name = "CategoriaServlet", urlPatterns = {"/CategoriaServlet"})
@MultipartConfig
public class CategoriaServlet extends HttpServlet {

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
        String opcao = request.getParameter("opcao");
        
        if(opcao.equalsIgnoreCase("editar")) {
            int id = Integer.parseInt(request.getParameter("id"));
            CategoriaCRUD crud = new CategoriaCRUD();
            Categoria cat;
            cat = crud.readOne(id);
            request.setAttribute("categoria", cat);

            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/jsp/editForm/categoria.jsp");
            dispatcher.forward(request, response);
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
        String sa = request.getParameter("submitAction");
        CategoriaCRUD crud = new CategoriaCRUD();
        if(sa == null) {
            Categoria categoria = new Categoria();
            categoria.setDescricao(request.getParameter("descricao"));
            //adicionei o nome aqui
            categoria.setNome(request.getParameter("nome"));
            crud.create(categoria);
        } else {
            if(sa.equalsIgnoreCase("Ver")){
                List<String> str;
                List<Categoria> cat;
                str = crud.getMetadata();
                cat = crud.readAll();
                request.setAttribute("catCampos", str);
                request.setAttribute("categoria", cat);
            }
            if(sa.equalsIgnoreCase("Alterar")){
                int catid = Integer.valueOf(request.getParameter("id"));
                Categoria c = crud.readOne(catid);
                c.setDescricao("mudando");// nao entendi direito o q isso ta fazendo, mudei ele depois, se nao tiver diferença tirar essa linha
                //adicionei o nome aqui
                c.setNome(request.getParameter("nome"));
                c.setDescricao(request.getParameter("descricao"));
                crud.update(c);
            }

            if(sa.equalsIgnoreCase("Excluir")){
                int catid = Integer.valueOf(request.getParameter("id"));
                Categoria c = new Categoria();
                c.setId(catid);
                crud.delete(c);
            }
        }
        //RequestDispatcher rd = request.getRequestDispatcher("/TrabalhoFinal/login-menu/menu.html");
        //rd.forward(request, response);
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
