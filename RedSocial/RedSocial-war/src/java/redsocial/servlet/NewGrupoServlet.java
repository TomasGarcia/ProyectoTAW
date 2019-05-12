/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package redsocial.servlet;

import Entities.Grupo;
import Entities.Usuario;
import ejb.GrupoFacade;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
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
import org.jboss.weld.servlet.SessionHolder;

/**
 *
 * @author Hp
 */
@WebServlet(name = "newgrupoServlet", urlPatterns = {"/newgrupoServlet"})
public class NewGrupoServlet extends HttpServlet {

    @EJB private GrupoFacade grupoFacade;
            
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
        Usuario usuario = (Usuario)session.getAttribute("usuario");
        
        String nombre = request.getParameter("nombre");
        String descripcion =(request.getParameter("descripcion"));
        Date date = new Date();
        
        
        Grupo grupo = new Grupo();
        grupo.setNombre(nombre);
        grupo.setDescripcion(descripcion);
        grupo.setFechaCreacion(date);
        grupo.setId(0);
        grupo.setUsuarioId(usuario);
        
        
        List<Usuario> lista = grupo.getUsuarioList();
        if(lista == null){
            lista = new ArrayList<>();
        }
        lista.add(usuario);
        grupo.setUsuarioList(lista);
        

        this.grupoFacade.create(grupo);
        
        
       
        List<Grupo> grupos = this.grupoFacade.findAll();
        
        

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/MuroServlet");
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
