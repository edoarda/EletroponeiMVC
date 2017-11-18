/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control.servlet;

import model.*;
import control.dao.*;
import java.io.IOException;
import static java.lang.System.out;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author edoarda
 */
@WebServlet(name = "AdminIndexServlet", urlPatterns = {"/AdminIndex"})
public class AdminIndexServlet extends HttpServlet {

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
        List<String> str;
        List<Administrador> adm;
        AdministradorCRUD readAdm = new AdministradorCRUD();
        adm = readAdm.readAll();
        request.setAttribute("Administrador", adm);
        out.println("VOCE É " + adm.get(0).getLogin());
        
        List<Categoria> ctg;
        CategoriaCRUD readCtg = new CategoriaCRUD();
        str = readCtg.getMetadata();
        ctg = readCtg.readAll();
        request.setAttribute("catCampos", str);
        request.setAttribute("categoria", ctg);

        List<Cliente> clt;
        ClienteCRUD readClt = new ClienteCRUD();
        str = readClt.getMetadata();
        clt = readClt.readAll();
        request.setAttribute("cltCampos", str);
        request.setAttribute("cliente", clt);

        List<Compra> cmp;
        CompraCRUD readCmp = new CompraCRUD();
        str = readCmp.getMetadata();
        cmp = readCmp.readAll();
        request.setAttribute("cmpCampos", str);
        request.setAttribute("compra", cmp);

        List<Produto> pdt;
        ProdutoCRUD readPdt = new ProdutoCRUD();
        str = readPdt.getMetadata();
        pdt = readPdt.readAll();
        request.setAttribute("pdtCampos", str);
        request.setAttribute("produto", pdt);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/indexAdmin.jsp");
        dispatcher.forward();
            
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
        processRequest(request, response);
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
