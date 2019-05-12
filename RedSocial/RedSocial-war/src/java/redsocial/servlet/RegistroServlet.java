/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package redsocial.servlet;

import Entities.Usuario;
import redsocial.utils.AccountUtil;
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
import static redsocial.utils.AccountUtil.usuarioDisponible;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Hp
 */
@WebServlet(name = "registroServlet", urlPatterns = {"/registroServlet"})
public class RegistroServlet extends HttpServlet {

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
            throws ServletException, IOException, SQLException, ParseException {
        String username, email, password, nombre, apellido, pais;
        Date fecha_nacimiento;
        Usuario usuario, user;
        boolean ready = true;
        
        if(request.getParameter("username").equals("") || request.getParameter("email").equals("") || request.getParameter("password").equals("")
               || request.getParameter("nombre").equals("") || request.getParameter("apellido").equals("") || request.getParameter("pais").equals("") ){
            ready = false;
            //AQUI DEBERIAMOS HACER ALGO QUE MUESTRE UNA VENTANA EMERGENTE DE ERROR DICIENDO "FALTAN DATOS"
            request.setAttribute("mensaje", "Faltan datos de entrada necesarios");
            request.setAttribute("url", "registro.html");
            RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/error.jsp");
            rd.forward(request, response);
        }
        
        
        username = request.getParameter("username");
        email = request.getParameter("email");
        password = request.getParameter("password");
        nombre = request.getParameter("nombre");
        apellido = request.getParameter("apellido");
        pais = request.getParameter("pais");
        
        
        fecha_nacimiento = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("fecha_nacimiento"));
        
        
        
        System.out.println(username);
        System.out.println(email);
        System.out.println(password);
        System.out.println(nombre);
        System.out.println(apellido);
        System.out.println(pais);
        System.out.println(fecha_nacimiento);
        
        usuario = new Usuario();
        usuario.setId(0);
        usuario.setNombre(nombre);
        usuario.setPassword(password);
        usuario.setNombre(nombre);
        usuario.setApellido(apellido);
        usuario.setPais(pais);
        usuario.setFechaNacimiento(fecha_nacimiento);
        
        if(usuarioDisponible(UsuarioFacade,username)){
            usuario.setUsername(username);
        }else{
            ready = false;
            //ERROR: EL USERNAME NO ESTA DISPONIBLE
            request.setAttribute("mensaje", "El username indicado no esta disponible");
            request.setAttribute("url", "registro.html");
            RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/error.jsp");
            rd.forward(request, response);
        }
        
        if(!AccountUtil.correoEnUso(UsuarioFacade, email)){
            usuario.setEmail(email);
        }else{
            //ERROR: ESE CORREO YA ESTA ASOCIADO A UNA CUENTA
            request.setAttribute("mensaje", "El correo ya esta asociado a una cuenta");
            request.setAttribute("url", "registro.html");
            RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/error.jsp");
            rd.forward(request, response);
        }
        
        if(ready){
            HttpSession session = request.getSession();
//          user = (Usuario) session.getAttribute("userLogin"); //No se si esta bien
            this.UsuarioFacade.create(usuario);
            UsuarioFacade userF = (UsuarioFacade)session.getAttribute("userDB");
            if(userF == null){
                userF = new UsuarioFacade();
            }
            session.setAttribute("userDB", userF);
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(RegistroServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(RegistroServlet.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (SQLException ex) {
            Logger.getLogger(RegistroServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(RegistroServlet.class.getName()).log(Level.SEVERE, null, ex);
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
