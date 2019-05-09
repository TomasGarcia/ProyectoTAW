/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Entities.Grupo;
import Entities.Post;
import Entities.Usuario;
import ejb.GrupoFacade;
import ejb.PostFacade;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
 * @author Jose
 */
@WebServlet(name = "newpostgrupoServlet", urlPatterns = {"/newpostgrupoServlet"})
public class newpostgrupoServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    @EJB
    private PostFacade postFacade;
    
    @EJB
    private GrupoFacade grupoFacade;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        String titulo = request.getParameter("titulo");
        System.out.println(titulo);
        String texto = request.getParameter("texto");
        System.out.println(texto);
        String imagen = request.getParameter("imagen");
        System.out.println(imagen);
        String video = request.getParameter("video");
        System.out.println(video);
        Date fecha = new Date();
        
        String strDestinatario = request.getParameter("destinatario");
        Integer idDest = new Integer(strDestinatario);
        
        Post post = new Post();
        post.setId(0);
        post.setDestinatario(idDest);
        post.setFecha(fecha);
        post.setImagen(imagen);
        post.setVideo(video);
        post.setTitulo(titulo);
        post.setTexto(texto);
        Usuario loggedUser = (Usuario) session.getAttribute("usuario");
        post.setUsuarioId(loggedUser);
        post.setUsuarioId1(loggedUser);
        
        Grupo grupo=(Grupo)session.getAttribute("grupo");
        
        List<Post> posts= grupo.getPostList();
        if(posts == null){
            posts = new ArrayList<>();
        }
        posts.add(post);
        grupo.setPostList(posts);
        
//        this.postFacade.create(post);
        
        this.grupoFacade.edit(grupo);
        request.setAttribute("id", grupo.getId());
        
        
        
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/paginaGrupoServlet");
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