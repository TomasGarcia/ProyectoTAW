/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import ejb.PostFacade;
import Entities.Post;
import Entities.Usuario;
import ejb.UsuarioFacade;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import javax.xml.bind.ParseConversionEvent;

/**
 *
 * @author Hp
 */
@WebServlet(name = "newpostServlet", urlPatterns = {"/newpostServlet"})
public class newpostServlet extends HttpServlet {

    @EJB
    private PostFacade postFacade;
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
        response.setContentType("text/html;charset=UTF-8");
      
        HttpSession session = request.getSession();
        Usuario user = (Usuario)session.getAttribute("usuario");
        
        String titulo = request.getParameter("titulo");
        String texto = request.getParameter("texto");
        String imagen = request.getParameter("imagen");
        String video = request.getParameter("video");
        Date fecha = new Date();
        
        Integer destinatario = Integer.parseInt(request.getParameter("destinatario"));
        
        if(destinatario == null){
        //Entiendo por esto que el mensaje es publico
            Post post = new Post();
            post.setId(0);
            post.setUsuarioId(user);
            post.setDestinatario(0);
            post.setFecha(fecha);
            post.setImagen(imagen);
            post.setVideo(video);
            post.setTitulo(titulo);
            
            postFacade.create(post);
        }else{
            //Mensaje privado
            Post post = new Post();
            post.setId(0);
            post.setUsuarioId(user);
            post.setDestinatario(destinatario);
            post.setFecha(fecha);
            post.setImagen(imagen);
            post.setVideo(video);
            post.setTitulo(titulo);
            
            this.postFacade.create(post);
        
        }
        
       
        
        
        RequestDispatcher rd = request.getRequestDispatcher("/muroServlet");
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
