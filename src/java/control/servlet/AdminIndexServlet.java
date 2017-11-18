/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control.servlet;

import model.*;
import control.dao.*;
import java.io.IOException;
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
            List<Administrador> adm;
            AdministradorCRUD readAdm = new AdministradorCRUD();
            adm = readAdm.readAll();
            request.setAttribute("Administrador", adm);
            /*
            List<Categoria> ctg;
            CategoriaCRUD readCtg = new CategoriaCRUD();
            ctg = readCtg.readAll();
            request.setAttribute("Categoria", ctg);
            
            List<Cliente> clt;
            ClienteCRUD readClt = new ClienteCRUD();
            clt = readClt.readAll();
            request.setAttribute("Cliente", clt);
            
            List<Compra> cmp;
            CompraCRUD readCmp = new CompraCRUD();
            cmp = readCmp.readAll();
            request.setAttribute("Compra", cmp);
            
            List<Produto> pdt;
            ProdutoCRUD readPdt = new ProdutoCRUD();
            pdt = readPdt.readAll();
            request.setAttribute("Produto", pdt);*/
            
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/jsp/indexAdmin.jsp");
            dispatcher.forward(request, response);
            
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
