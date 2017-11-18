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
import model.Compra;
import control.dao.CompraCRUD;
import java.util.List;

/**
 *
 * @author edoarda
 */
@WebServlet(name = "CompraServlet", urlPatterns = {"/CompraServlet"})
public class CompraServlet extends HttpServlet {

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
            out.println("<title>Servlet CompraServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CompraServlet at " + request.getContextPath() + "</h1>");
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
        processRequest(request, response);
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
        CompraCRUD crud = new CompraCRUD();
        if(sa == null) {
            Compra compra = new Compra();
            //administrador.setDescricao(request.getParameter("descricao"));
            //adicionei o nome aqui
            compra.setIdCliente(Integer.parseInt(request.getParameter("idcliente")));
            compra.setIdProduto(Integer.parseInt(request.getParameter("idproduto")));
            crud.create(compra);
        } else {
            if(sa.equalsIgnoreCase("Ver")){
                List<String> str;
                List<Compra> cmp;
                str = crud.getMetadata();
                cmp = crud.readAll();
                request.setAttribute("cmpCampos", str);
                request.setAttribute("compra", cmp);
            }
            if(sa.equalsIgnoreCase("Alterar")){
                int id = Integer.valueOf(request.getParameter("compra"));
                Compra compra = crud.readOne(id);
                //c.setDescricao("mudando");// nao entendi direito o q isso ta fazendo, mudei ele depois, se nao tiver diferença tirar essa linha
                //adicionei o nome aqui
                compra.setIdCliente(Integer.parseInt(request.getParameter("idcliente")));
                compra.setIdProduto(Integer.parseInt(request.getParameter("idproduto")));
                crud.update(compra);
            }

            if(sa.equalsIgnoreCase("Excluir")){
                int id = Integer.valueOf(request.getParameter("compra"));
                Compra compra = new Compra();
                compra.setId(id);
                crud.delete(compra);
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
