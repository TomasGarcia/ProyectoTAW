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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Hp
 */
@WebServlet(name = "editProfileServlet", urlPatterns = {"/editProfileServlet"})
public class editProfileServlet extends HttpServlet {
    
    @EJB
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
            throws ServletException, IOException, ParseException {
       String str;
       Date date;
       HttpSession session = request.getSession();
       
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
       date = new SimpleDateFormat("dd/MM/yyyy").parse(request.getParameter("fecha_nacimiento"));
       usuario.setFechaNacimiento(date);
       str = request.getParameter("pais");
       usuario.setPais(str);
 
       this.usuarioFacade.edit(usuario);

       session.setAttribute("usuario", usuario);

//         String str = request.getParameter("id");
//         Integer idCustomer = new Integer(str);
//         Usuario usuario = this.usuarioFacade.find(idCustomer);
//         request.setAttribute("usuario", usuario);
                  
       
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
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(editProfileServlet.class.getName()).log(Level.SEVERE, null, ex);
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
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(editProfileServlet.class.getName()).log(Level.SEVERE, null, ex);
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
