/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import ejb.UsuarioFacade;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import Entities.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.jsp.PageContext;

/**
 *
 * @author Hp
 */
@WebServlet(name = "indexServlet", urlPatterns = {"/indexServlet"})
public class indexServlet extends HttpServlet {


        @EJB private UsuarioFacade userFacade;
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
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        Boolean log =(Boolean) session.getAttribute("logged");
        if(log == null){
            log = false;
        }
        int id = -1;
        Usuario loggedUser = (Usuario)session.getAttribute("usuario");


        String email = request.getParameter("email");//.getBytes("ISO-8559-1"), "UTF-8");
        String password =(request.getParameter("password"));//.getBytes("IS0-8559-1"), "utf-8");

        List<Usuario> usuarios = this.userFacade.buscarUsuarioPorEmail(email);
            
        if(!usuarios.isEmpty()){
                loggedUser = usuarios.get(0);
            if(loggedUser.getPassword().equals(password)){
              id = loggedUser.getId();
              log = true;    
            }                                
        }
        
        String redirect = "/MuroServlet";
        if (!log) {
            request.setAttribute("mensaje", "Email o clave incorrecta");
            request.setAttribute("url", "index.jsp");
            redirect = "/error.jsp";
            session.invalidate();
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(redirect);
            dispatcher.forward(request, response); 
        }else{
//            request.setAttribute("usuario", loggedUser);
            session.setAttribute("usuario", loggedUser);
            usuarios = (List) this.userFacade.findAll();
            session.setAttribute("usuarios", usuarios);
            session.setAttribute("logged",log);
        }
        
        RequestDispatcher dispatcher = request.getRequestDispatcher(redirect);
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
