/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author edoarda
 */
@WebServlet(name = "RedirectServlet", urlPatterns = {"/Redirect"})
public class RedirectServlet extends HttpServlet {

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
            String pagina = request.getParameter("pagina");
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/jsp/"+ pagina + ".jsp");
            dispatcher.forward(request, response);
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Redireciona TODO MUNDO (ou nao) dos jps. Ele não é usado nos outros servlets porque... sei lá.";
    }// </editor-fold>

}
