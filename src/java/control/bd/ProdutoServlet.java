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
import model.Produto;
import control.dao.ProdutoCRUD;
import java.util.List;
import javax.servlet.RequestDispatcher;

/**
 *
 * @author edoarda
 */
@WebServlet(name = "ProdutoServlet", urlPatterns = {"/ProdutoServlet"})
public class ProdutoServlet extends HttpServlet {

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
            out.println("<title>Servlet ProdutoServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ProdutoServlet at " + request.getContextPath() + "</h1>");
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
        String opcao = request.getParameter("opcao");
        
        if(opcao.equalsIgnoreCase("editar")) {
            int id = Integer.parseInt(request.getParameter("id"));
            ProdutoCRUD crud = new ProdutoCRUD();
            Produto pdt;
            pdt = crud.readOne(id);
            request.setAttribute("produto", pdt);

            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/jsp/editForm/produto.jsp");
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
        ProdutoCRUD crud = new ProdutoCRUD();
        if(sa == null) {
            Produto produto = new Produto();
            //administrador.setDescricao(request.getParameter("descricao"));
            //adicionei o nome aqui
            produto.setIdCategoria(Integer.parseInt(request.getParameter("idcategoria")));
            produto.setNome(request.getParameter("nome"));
            produto.setDescricao(request.getParameter("descricao"));
            produto.setValor(Double.parseDouble(request.getParameter("nome")));
            crud.create(produto);
        } else {
            if(sa.equalsIgnoreCase("Ver")){
                List<String> str;
                List<Produto> pdt;
                str = crud.getMetadata();
                pdt = crud.readAll();
                request.setAttribute("pdtCampos", str);
                request.setAttribute("produto", pdt);
            }
            if(sa.equalsIgnoreCase("Alterar")){
                int id = Integer.valueOf(request.getParameter("produto"));
                Produto produto = crud.readOne(id);
                //c.setDescricao("mudando");// nao entendi direito o q isso ta fazendo, mudei ele depois, se nao tiver diferença tirar essa linha
                //adicionei o nome aqui
                produto.setIdCategoria(Integer.parseInt(request.getParameter("idcategoria")));
                produto.setNome(request.getParameter("nome"));
                produto.setDescricao(request.getParameter("descricao"));
                produto.setValor(Double.parseDouble(request.getParameter("nome")));
                crud.update(produto);
            }

            if(sa.equalsIgnoreCase("Excluir")){
                int id = Integer.valueOf(request.getParameter("produto"));
                Produto produto = new Produto();
                produto.setId(id);
                crud.delete(produto);
            }
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
