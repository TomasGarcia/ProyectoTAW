/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Entities.Peticion;
import Entities.Usuario;
import ejb.PeticionFacade;
import ejb.UsuarioFacade;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
 * @author Hp
 */
@WebServlet(name = "friendServlet", urlPatterns = {"/friendServlet"})
public class friendServlet extends HttpServlet {
@EJB private UsuarioFacade usuarioFacade;
@EJB private PeticionFacade peticionFacade;
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
        
        HttpSession session = request.getSession();
        
        
//        String strId = request.getParameter("id");
//        Usuario usuario;
//        
//        if(strId != null){
//            Integer id = new Integer(strId);
//            usuario= this.usuarioFacade.find(id);
//        }else{
           Usuario usuario = (Usuario) session.getAttribute("usuario");
//        }
        
        //Esto...
        List<Usuario> listaUsuario = usuario.getUsuarioList1();
        if(listaUsuario==null){
            listaUsuario = new ArrayList<>();
            listaUsuario.add(usuario);
            usuario.setUsuarioList(listaUsuario);
        }
        
        //Lista de todos los usuarios
        List<Usuario> listaUsuarios = this.usuarioFacade.findAll();
        request.setAttribute("listaUsuarios", listaUsuarios);
        
        //Lista con tus amigos
        List<Usuario> listaAmigos = usuario.getUsuarioList();
        if(listaAmigos == null){
            listaAmigos = new ArrayList<>();
            usuario.setUsuarioList1(listaAmigos);
        }
        session.setAttribute("usuario", usuario);
        session.setAttribute("listaAmigos", listaAmigos);
        
        //Lista con tus peticiones
        List<Peticion> listaPeticiones = this.peticionFacade.misPeticiones(usuario.getId());
        request.setAttribute("listaPeticiones", listaPeticiones);
        
        RequestDispatcher rd = request.getRequestDispatcher("/amigos.jsp");
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
