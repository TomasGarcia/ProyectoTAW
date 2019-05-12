/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package redsocial.servlet;

import Entities.Peticion;
import Entities.PeticionPK;
import Entities.Usuario;
import ejb.PeticionFacade;
import ejb.UsuarioFacade;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "EliminarAmigoServlet", urlPatterns = {"/EliminarAmigoServlet"})
public class EliminarAmigoServlet extends HttpServlet {

    @EJB private UsuarioFacade usuarioFacade;
    @EJB private PeticionFacade peticionFacade;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Usuario usuario = (Usuario)session.getAttribute("usuario");
        
        String strId = request.getParameter("id");
        Integer id = new Integer(strId);
        Usuario amigo = this.usuarioFacade.find(id);
        
        List<Usuario>listaAmigos = usuario.getUsuarioList();
        listaAmigos.remove(amigo);
        usuario.setUsuarioList(listaAmigos);
        this.usuarioFacade.edit(usuario);
        
        List<Usuario>listaAmigos1 = amigo.getUsuarioList();
        listaAmigos1.remove(usuario);
        amigo.setUsuarioList(listaAmigos1);
        this.usuarioFacade.edit(amigo);
        
        PeticionPK peticionPK = new PeticionPK(usuario.getId(), amigo.getId());
        Peticion peticion = this.peticionFacade.find(peticionPK);
        if(peticion == null){
            peticionPK = new PeticionPK(amigo.getId(), usuario.getId());
            peticion = this.peticionFacade.find(peticionPK);
        }
        
        this.peticionFacade.remove(peticion);
        RequestDispatcher rd = request.getRequestDispatcher("friendServlet");
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