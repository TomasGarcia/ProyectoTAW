/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;
import ejb.UsuarioFacade;
import Entities.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Hp
 */
@WebServlet(name = "editProfileServlet", urlPatterns = {"/editProfileServlet"})
public class editProfileServlet extends HttpServlet {

    private UsuarioFacade usuarioFacade;
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
       String str;
      
       
       str = request.getParameter("id");
       Usuario usuario = this.usuarioFacade.find(new Integer(str));
       str = request.getParameter("username");
       usuario.setUsername(str);
       str = request.getParameter("email");
       usuario.setEmail(str);
       str = request.getParameter("password");
       usuario.setClave(str);
       str = request.getParameter("nombre");
       usuario.setNombre(str);
       str = request.getParameter("apellido");
       usuario.setApellido(str);
       //FALTA PONER FECHA
       //str = request.getParameter("fecha_nacimiento");
       //usuario.setFechaNacimiento(str);
       str = request.getParameter("pais");
       usuario.setPais(str);
    
       this.usuarioFacade.edit(usuario);
       
       RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/profile.jsp");
       rd.forward(request, response);
    
    
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
