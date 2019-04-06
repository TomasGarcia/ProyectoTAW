/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Entities.Usuario;
import Utils.AccountUtil;
import ejb.UsuarioFacade;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static Utils.AccountUtil.usuarioDisponible;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Hp
 */
@WebServlet(name = "registroServlet", urlPatterns = {"/registroServlet"})
public class registroServlet extends HttpServlet {
    
    @EJB
    private UsuarioFacade UsuarioFacade;

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
        //response.setContentType("text/html;charset=UTF-8");
        //try (PrintWriter out = response.getWriter()) {
        //    /* TODO output your page here. You may use following sample code. */
        //    out.println("<!DOCTYPE html>");
        //    out.println("<html>");
        //    out.println("<head>");
        //    out.println("<title>Servlet registroServlet</title>");            
        //    out.println("</head>");
        //    out.println("<body>");
        //    out.println("<h1>Servlet registroServlet at " + request.getContextPath() + "</h1>");
        //    out.println("</body>");
        //    out.println("</html>");
        String username, email, password, nombre, apellido, pais;
        Date fecha_nacimiento;
        Usuario usuario, user;
        boolean ready = true;
        
        if(request.getParameter("username").equals("") || request.getParameter("email").equals("") || request.getParameter("password").equals("")
               || request.getParameter("nombre").equals("") || request.getParameter("apellido").equals("") || request.getParameter("pais").equals("") ){
            ready = false;
            //AQUI DEBERIAMOS HACER ALGO QUE MUESTRE UNA VENTANA EMERGENTE DE ERROR DICIENDO "FALTAN DATOS"
        }
        
        
        username = request.getParameter("username");
        email = request.getParameter("email");
        password = request.getParameter("password");
        nombre = request.getParameter("nombre");
        apellido = request.getParameter("apellido");
        pais = request.getParameter("pais");
        //fecha_nacimiento = request.getParameter("fecha_nacimiento");
        
        usuario = new Usuario();
        usuario.setNombre(nombre);
        usuario.setClave(password);
        usuario.setNombre(nombre);
        usuario.setApellido(apellido);
        usuario.setPais(pais);
        //usuario.setId(?????????);
        //usuario.setFeecha_Nacimiento(???????)
        
        if(!usuarioDisponible(UsuarioFacade,username)){
            usuario.setUsername(username);
        }else{
            ready = false;
            //ERROR: EL USERNAME NO ESTA DISPONIBLE
        }
        
        if(!AccountUtil.correoEnUso(UsuarioFacade, email)){
            usuario.setEmail(email);
        }else{
            //ERROR: ESE CORREO YA ESTA ASOCIADO A UNA CUENTA
        }
        
        if(ready){
            HttpSession session = request.getSession();
            user = (Usuario) session.getAttribute("userLogin"); //No se si esta bien
            List<Usuario> listaUsuarios = this.UsuarioFacade.findAll();
            session.setAttribute("listaUsuarios", listaUsuarios);
            request.setAttribute("usuarioCreado", usuario);
            RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/index.jsp");
            rd.forward(request, response);
        }
        
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
